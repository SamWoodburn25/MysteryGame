package Level;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.ScreenManager;
import GameObject.Rectangle;
import Utils.Direction;
import Utils.Point;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
    This class is for defining a map that is used for a specific level
    The map class handles/manages a lot of different things, including:
    1. tile map -- the map tiles that make up the map
    2. entities in the map -- this includes enemies, enhanced map tiles, and npcs
    3. the map's camera, which does a lot of work itself in the Camera class
    4. adjusting camera location based off of player location
    5. calculating which tile a game object is currently on based on its x and y location
*/

public abstract class Map {
    // the tile map (map tiles that make up the entire map image)
    protected MapTile[] mapTiles;

    // width and height of the map in terms of the number of tiles width-wise and height-wise
    protected int width;
    protected int height;

    // the tileset this map uses for its map tiles
    protected Tileset tileset;

    // camera class that handles the viewable part of the map that is seen by the player of a game during a level
    protected Camera camera;

    // location player should start on when this map is first loaded
    protected Point playerStartPosition;

    // the location of the "mid point" of the screen
    // this is what tells the game that the player has reached the center of the screen, therefore the camera should move instead of the player
    // this goes into creating that "map scrolling" effect
    protected int xMidPoint, yMidPoint;

    // in pixels, this basically creates a rectangle defining how big the map is
    // startX and Y will always be 0, endX and Y is the number of tiles multiplied by the number of pixels each tile takes up
    protected int startBoundX, startBoundY, endBoundX, endBoundY;

    // the name of the map text file that has the tile map information
    protected String mapFileName;

    // lists to hold map entities that are a part of the map
    protected ArrayList<EnhancedMapTile> enhancedMapTiles;
    protected ArrayList<NPC> npcs;
    protected ArrayList<Trigger> triggers;

    // current script that is being executed (if any)
    protected Script activeScript;

    // if set to false, camera will not move as player moves
    protected boolean adjustCamera = true;

    // map tiles in map that are animated
    protected ArrayList<MapTile> animatedMapTiles;

    // flag manager instance to keep track of flags set while map is loaded
    protected FlagManager flagManager;

    // map's textbox instance
    protected Textbox textbox;

    // reference to current player
    protected Player player;

    //current map
    protected int currMapInt = 0;
    public Map currMap;

    public Map(String mapFileName, Tileset tileset) {
        this.mapFileName = mapFileName;
        this.tileset = tileset;
        setupMap();
        this.startBoundX = 0;
        this.startBoundY = 0;
        this.endBoundX = width * tileset.getScaledSpriteWidth();
        this.endBoundY = height * tileset.getScaledSpriteHeight();
        this.xMidPoint = ScreenManager.getScreenWidth() / 2;
        this.yMidPoint = (ScreenManager.getScreenHeight() / 2);
        this.playerStartPosition = new Point(0, 0);
    }

    public Map(BufferedImage bufferedImage) {
        loadMapFile();
    }

    public Map(String mapFileName, int screenWidth, int screenHeight) {
        this.mapFileName = mapFileName;
        setupMap();
        this.startBoundX = 0;
        this.startBoundY = 0;
        this.xMidPoint = ScreenManager.getScreenWidth() / 2;
        this.yMidPoint = (ScreenManager.getScreenHeight() / 2);
        this.playerStartPosition = new Point(0, 0);
    }

    public void initialize(){}
    
    // setter getter map
    public void setCurrMapInt(int currMapInt){
        this.currMapInt = currMapInt;
    }
    public int getCurrMapInt(){
        return this.currMapInt;
    }
    // sets up map by reading in the map file to create the tile map
    // loads in enemies, enhanced map tiles, and npcs
    // and instantiates a Camera
    public void setupMap() {
        animatedMapTiles = new ArrayList<>();

        loadMapFile();

        this.enhancedMapTiles = loadEnhancedMapTiles();
        for (EnhancedMapTile enhancedMapTile: this.enhancedMapTiles) {
            enhancedMapTile.setMap(this);
        }

        this.npcs = loadNPCs();
        for (NPC npc: this.npcs) {
            npc.setMap(this);
        }

        this.triggers = loadTriggers();
        for (Trigger trigger: this.triggers) {
            trigger.setMap(this);
        }

        this.loadScripts();

        this.camera = new Camera(0, 0, tileset.getScaledSpriteWidth(), tileset.getScaledSpriteHeight(), this);
        this.textbox = new Textbox(this);
    }

    // reads in a map file to create the map's tilemap
    private void loadMapFile() {
        Scanner fileInput;
        try {
            // open map file that is located in the MAP_FILES_PATH directory
            fileInput = new Scanner(new File(Config.MAP_FILES_PATH + this.mapFileName));
        } catch(FileNotFoundException ex) {
            // if map file does not exist, create a new one for this map (the map editor uses this)
            System.out.println("Map file " + Config.MAP_FILES_PATH + this.mapFileName + " not found! Creating empty map file...");

            try {
                createEmptyMapFile();
                fileInput = new Scanner(new File(Config.MAP_FILES_PATH + this.mapFileName));
            } catch(IOException ex2) {
                ex2.printStackTrace();
                System.out.println("Failed to create an empty map file!");
                throw new RuntimeException();
            }
        }

        // read in map width and height from the first line of map file
        this.width = fileInput.nextInt();
        this.height = fileInput.nextInt();

        // define array size for map tiles, which is width * height (this is a standard array, NOT a 2D array)
        this.mapTiles = new MapTile[this.height * this.width];
        fileInput.nextLine();

        // read in each tile index from the map file, use the defined tileset to get the associated MapTile to that tileset, and place it in the array
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int tileIndex = fileInput.nextInt();
                int xLocation = j * tileset.getScaledSpriteWidth();
                int yLocation = i * tileset.getScaledSpriteHeight();
                MapTile tile = tileset.getTile(tileIndex).build(xLocation, yLocation);
                tile.setMap(this);
                setMapTile(j, i, tile);

                if (tile.isAnimated()) {
                    animatedMapTiles.add(tile);
                }
            }
        }

        fileInput.close();
    }

    // creates an empty map file for this map if one does not exist
    // defaults the map dimensions to 0x0
    private void createEmptyMapFile() throws IOException {
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(Config.MAP_FILES_PATH + this.mapFileName);
        fileWriter.write("0 0\n");
        fileWriter.close();
    }

    // gets player start position based on player start tile (basically the start tile's position on the map)
    public Point getPlayerStartPosition() {
        return playerStartPosition;
    }

    // get position on the map based on a specific tile index
    public Point getPositionByTileIndex(int xIndex, int yIndex) {
        MapTile tile = getMapTile(xIndex, yIndex);
        return new Point(tile.getX(), tile.getY());
    }

    public Tileset getTileset() {
        return tileset;
    }

    public String getMapFileName() {
        return mapFileName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidthPixels() {
        return width * tileset.getScaledSpriteWidth();
    }

    public int getHeightPixels() {
        return height * tileset.getScaledSpriteHeight();
    }

    public MapTile[] getMapTiles() {
        return mapTiles;
    }

    public void setMapTiles(MapTile[] mapTiles) {
        this.mapTiles = mapTiles;
    }

    // get specific map tile from tile map
    public MapTile getMapTile(int x, int y) {
        if (isInBounds(x, y)) {
            return mapTiles[getConvertedIndex(x, y)];
        } else {
            return null;
        }
    }

    // set specific map tile from tile map to a new map tile
    public void setMapTile(int x, int y, MapTile tile) {
        if (isInBounds(x, y)) {
            MapTile oldMapTile = getMapTile(x, y);
            animatedMapTiles.remove(oldMapTile);
            mapTiles[getConvertedIndex(x, y)] = tile;
            tile.setMap(this);
            if (tile.isAnimated()) {
                animatedMapTiles.add(tile);
            }
        }
    }

    // returns a tile based on a position in the map
    public MapTile getTileByPosition(float xPosition, float yPosition) {
        Point tileIndex = getTileIndexByPosition(xPosition, yPosition);
        if (isInBounds(Math.round(tileIndex.x), Math.round(tileIndex.y))) {
            return getMapTile(Math.round(tileIndex.x), Math.round(tileIndex.y));
        } else {
            return null;
        }
    }

    // returns the index of a tile (x index and y index) based on a position in the map
    public Point getTileIndexByPosition(float xPosition, float yPosition) {
        int xIndex = Math.round(xPosition) / tileset.getScaledSpriteWidth();
        int yIndex = Math.round(yPosition) / tileset.getScaledSpriteHeight();
        return new Point(xIndex, yIndex);
    }

    // checks if map tile being requested is in bounds of the tile map array
    private boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    // since tile map array is a standard (1D) array and not a 2D,
    // instead of doing [y][x] to get a value, instead the same can be achieved with x + width * y
    private int getConvertedIndex(int x, int y) {
        return x + width * y;
    }

    // list of scripts defined to be a part of the map, should be overridden in a subclass
    public void loadScripts() { }

    // list of enhanced map tiles defined to be a part of the map, should be overridden in a subclass
    protected ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        return new ArrayList<>();
    }

    // list of npcs defined to be a part of the map, should be overridden in a subclass
    protected ArrayList<NPC> loadNPCs() {
        return new ArrayList<>();
    }

    protected ArrayList<Trigger> loadTriggers() {
        return new ArrayList<>();
    }

    public Camera getCamera() {
        return camera;
    }

    public ArrayList<EnhancedMapTile> getEnhancedMapTiles() {
        return enhancedMapTiles;
    }

    public ArrayList<NPC> getNPCs() {
        return npcs;
    }
    public ArrayList<Trigger> getTriggers() { return triggers; }

    public ArrayList<MapTile> getAnimatedMapTiles() {
        return animatedMapTiles;
    }

    public Script getActiveScript() {
        return activeScript;
    }

    public void setActiveScript(Script script) {
        activeScript = script;

        // script is set to null if there is no active script running, or if a script has completed running
        // if script is null, do not set it to be active
        // otherwise, set script to active, which will begin its execution
        if (script != null) {

            // if the script was not previously preloaded (preloadScripts method) beforehand, this will load the script dynamically
            // preloading is recommended, but both are supported
            if (script.getScriptActions() == null) {
                activeScript.setMap(this);
                activeScript.setPlayer(player);
                activeScript.initialize();
            }
            activeScript.setIsActive(true);
        }
    }

    public void preloadScripts() {
        // setup map scripts to have references to the map and player
        for (MapTile mapTile : mapTiles) {
            if (mapTile.getInteractScript() != null) {
                mapTile.getInteractScript().setMap(this);
                mapTile.getInteractScript().setPlayer(player);
                mapTile.getInteractScript().initialize();
            }
        }
        for (NPC npc : npcs) {
            if (npc.getInteractScript() != null) {
                npc.getInteractScript().setMap(this);
                npc.getInteractScript().setPlayer(player);
                npc.getInteractScript().initialize();
            }
        }
        for (EnhancedMapTile enhancedMapTile : enhancedMapTiles) {
            if (enhancedMapTile.getInteractScript() != null) {
                enhancedMapTile.getInteractScript().setMap(this);
                enhancedMapTile.getInteractScript().setPlayer(player);
                enhancedMapTile.getInteractScript().initialize();
            }
        }
        for (Trigger trigger : triggers) {
            if (trigger.getTriggerScript() != null) {
                trigger.getTriggerScript().setMap(this);
                trigger.getTriggerScript().setPlayer(player);
                trigger.getTriggerScript().initialize();
            }
        }
    }

    public NPC getNPCById(int id) {
        for (NPC npc : npcs) {
            if (npc.getId() == id) {
                return npc;
            }
        }
        return null;
    }

    // returns all active enhanced map tiles (enhanced map tiles that are a part of the current update cycle) -- this changes every frame by the Camera class
    public ArrayList<EnhancedMapTile> getActiveEnhancedMapTiles() {
        return camera.getActiveEnhancedMapTiles();
    }

    // returns all active npcs (npcs that are a part of the current update cycle) -- this changes every frame by the Camera class
    public ArrayList<NPC> getActiveNPCs() {
        return camera.getActiveNPCs();
    }

    public ArrayList<Trigger> getActiveTriggers() {
        return camera.getActiveTriggers();
    }

    // add an enhanced map tile to the map's list of enhanced map tiles
    public void addEnhancedMapTile(EnhancedMapTile enhancedMapTile) {
        enhancedMapTile.setMap(this);
        this.enhancedMapTiles.add(enhancedMapTile);
    }

    // add an npc to the map's list of npcs
    public void addNPC(NPC npc) {
        npc.setMap(this);
        this.npcs.add(npc);
    }

    // add a trigger to the map's list of triggers
    public void addTrigger(Trigger trigger) {
        trigger.setMap(this);
        this.triggers.add(trigger);
    }

    public void setAdjustCamera(boolean adjustCamera) {
        this.adjustCamera = adjustCamera;
    }


    public ArrayList<MapEntity> getSurroundingMapEntities(Player player) {
        ArrayList<MapEntity> surroundingMapEntities = new ArrayList<>();

        // gets surrounding tiles
        Point playerCurrentTile = getTileIndexByPosition((int)player.getBounds().getX1(), (int)player.getBounds().getY1());
        for (int i = (int)playerCurrentTile.y - 1; i <= playerCurrentTile.y + 1; i++) {
            for (int j = (int)playerCurrentTile.x - 1; j <= playerCurrentTile.x + 1; j++) {
                MapTile mapTile = getMapTile(j, i);
                if (mapTile != null && mapTile.getInteractScript() != null) {
                    surroundingMapEntities.add(mapTile);
                }
            }
        }
        // gets active surrounding npcs
        surroundingMapEntities.addAll(getActiveNPCs());
        surroundingMapEntities.addAll(getActiveEnhancedMapTiles());
        return surroundingMapEntities;
    }

    public void entityInteract(Player player) {
        ArrayList<MapEntity> surroundingMapEntities = getSurroundingMapEntities(player);
        ArrayList<MapEntity> playerTouchingMapEntities = new ArrayList<>();
        for (MapEntity mapEntity : surroundingMapEntities) {
            if (mapEntity.getInteractScript() != null && mapEntity.intersects(player.getInteractionRange())) {
                playerTouchingMapEntities.add(mapEntity);
            }
        }
        MapEntity interactedEntity = null;
        if (playerTouchingMapEntities.size() == 1) {
            if (playerTouchingMapEntities.get(0).isUncollidable || isInteractedEntityValid(playerTouchingMapEntities.get(0), player)) {
                interactedEntity = playerTouchingMapEntities.get(0);
            }
        }
        else if (playerTouchingMapEntities.size() > 1) {
            MapEntity currentLargestAreaOverlappedEntity = null;
            float currentLargestAreaOverlapped = 0;
            for (MapEntity mapEntity : playerTouchingMapEntities) {
                if (mapEntity.isUncollidable() || isInteractedEntityValid(mapEntity, player)) {
                    float areaOverlapped = mapEntity.getAreaOverlapped(player.getInteractionRange());
                    if (areaOverlapped > currentLargestAreaOverlapped) {
                        currentLargestAreaOverlappedEntity = mapEntity;
                        currentLargestAreaOverlapped = areaOverlapped;
                    }
                }
            }
            interactedEntity = currentLargestAreaOverlappedEntity;
        }
        if (interactedEntity != null) {
            setActiveScript(interactedEntity.getInteractScript());
        }
    }

    private boolean isInteractedEntityValid(MapEntity interactedEntity, Player player) {
        Rectangle playerBounds = player.getBounds();
        Rectangle entityBounds = interactedEntity.getBounds();

        // this does several checks to ensure the player's location releative to the entity's is valid for interaction
        // takes into account things like player's current location, entity's current location, player's facing direction, player's center point, etc.
        // this prevents things like being able to interact with an entity without facing it and other oddities like that
                
        // if player is facing left and entity is completely to the left of the player, location is valid
        if (player.getFacingDirection() == Direction.LEFT && entityBounds.getX2() < playerBounds.getX1()) {
            return true;
        }
        // if player is facing right and entity is completely to the right of the player, location is valid
        else if (player.getFacingDirection() == Direction.RIGHT && entityBounds.getX1() > playerBounds.getX2()) {
            return true;
        } 
        //if player is facing up and entity is below player, location is valid
        else if (player.getFacingDirection() == Direction.UP && entityBounds.getY1() > playerBounds.getY2()) {
            return true;
        }
        //if player is facing down and entity is below player, location is valid
        else if (player.getFacingDirection() == Direction.DOWN && entityBounds.getY1() < playerBounds.getY2()) {
            return true;
        }

        boolean isEntityOverOrUnderPlayer = entityBounds.getY2() < playerBounds.getY1() || entityBounds.getY1() > playerBounds.getY2();
        if (interactedEntity instanceof NPC) {
            // if player is facing left and entity is either on top of or underneath player and player's center point is greater than entity's center point, location is valid
            if (player.getFacingDirection() != Direction.RIGHT && isEntityOverOrUnderPlayer && playerBounds.getX1() < entityBounds.getX2()) {
                return true;
            }
            // if player is facing right and entity is either on top of or underneath player and player's center point is less than entity's center point, location is valid
            else if (player.getFacingDirection() != Direction.LEFT && isEntityOverOrUnderPlayer && playerBounds.getX2() > entityBounds.getX1()) {
                return true;
            }
            
        }
        else {
            // if interacted with anything other than NPC, it doesn't matter which direction you're facing, so it's valid if above/below player
            if (isEntityOverOrUnderPlayer) {
                return true;
            }
        }

        // if none of the location validity checks matched, location is not valid and the interaction will fail
        return false;
    }

    public void update(Player player) {
        if (adjustCamera) {
            adjustMovementY(player);
            adjustMovementX(player);
        }
        camera.update(player);
        if (textbox.isActive()) {
            textbox.update();
        }
    }

    // based on the player's current X position (which in a level can potentially be updated each frame),
    // adjust the player's and camera's positions accordingly in order to properly create the map "scrolling" effect
    private void adjustMovementX(Player player) {
        // if player goes past center screen (on the right side) and there is more map to show on the right side, push player back to center and move camera forward
        if ((player.getCalibratedXLocation() + (player.getWidth() / 2)) > xMidPoint && camera.getEndBoundX() < endBoundX) {
            float xMidPointDifference = xMidPoint - (player.getCalibratedXLocation() + (player.getWidth() / 2));
            camera.moveX(-xMidPointDifference);

            // if camera moved past the right edge of the map as a result from the move above, move camera back and push player forward
            if (camera.getEndBoundX() > endBoundX) {
                float cameraDifference = camera.getEndBoundX() - endBoundX;
                camera.moveX(-cameraDifference);
            }
        }
        // if player goes past center screen (on the left side) and there is more map to show on the left side, push player back to center and move camera backwards
        else if ((player.getCalibratedXLocation() + (player.getWidth() / 2)) < xMidPoint && camera.getX() > startBoundX) {
            float xMidPointDifference = xMidPoint - (player.getCalibratedXLocation() + (player.getWidth() / 2));
            camera.moveX(-xMidPointDifference);

            // if camera moved past the left edge of the map as a result from the move above, move camera back and push player backward
            if (camera.getX() < startBoundX) {
                float cameraDifference = startBoundX - camera.getX();
                camera.moveX(cameraDifference);
            }
        }
    }

    // based on the player's current Y position (which in a level can potentially be updated each frame),
    // adjust the player's and camera's positions accordingly in order to properly create the map "scrolling" effect
    private void adjustMovementY(Player player) {
        // if player goes past center screen (below) and there is more map to show below, push player back to center and move camera upward
        if ((player.getCalibratedYLocation() + (player.getHeight() / 2)) > yMidPoint && camera.getEndBoundY() < endBoundY) {
            float yMidPointDifference = yMidPoint - (player.getCalibratedYLocation() + (player.getHeight() / 2));
            camera.moveY(-yMidPointDifference);

            // if camera moved past the bottom of the map as a result from the move above, move camera upwards and push player downwards
            if (camera.getEndBoundY() > endBoundY) {
                float cameraDifference = camera.getEndBoundY() - endBoundY;
                camera.moveY(-cameraDifference);
            }
        }
        // if player goes past center screen (above) and there is more map to show above, push player back to center and move camera upwards
        else if ((player.getCalibratedYLocation() + (player.getHeight() / 2)) < yMidPoint && camera.getY() > startBoundY) {
            float yMidPointDifference = yMidPoint - (player.getCalibratedYLocation() + (player.getHeight() / 2));
            camera.moveY(-yMidPointDifference);

            // if camera moved past the top of the map as a result from the move above, move camera downwards and push player upwards
            if (camera.getY() < startBoundY) {
                float cameraDifference = startBoundY - camera.getY();
                camera.moveY(cameraDifference);
            }
        }
    }

    public void reset() {
        setupMap();
    }

    public void draw(GraphicsHandler graphicsHandler) {
        camera.draw(graphicsHandler);
    }

    public void draw(Player player, GraphicsHandler graphicsHandler) {
        camera.draw(player, graphicsHandler);
        if (textbox.isActive()) {
            textbox.draw(graphicsHandler);
        }
    }

    public FlagManager getFlagManager() { return flagManager; }

    public void setFlagManager(FlagManager flagManager) {
        this.flagManager = flagManager;
    }

    public Textbox getTextbox() { return textbox; }

    public int getStartBoundX() { return startBoundX; }
    public int getStartBoundY() { return startBoundY; }
    public int getEndBoundX() { return endBoundX; }
    public int getEndBoundY() { return endBoundY; }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
