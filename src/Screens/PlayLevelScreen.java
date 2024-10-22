/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- PlayLevelScreen: Manages the gameplay screen where the actual RPG action occurs and game is
 * actively being played, handling game state transitions, player interactions, and journal toggling 
 * based on gameplay events
 */

package Screens;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TownMap;
import Maps.ButcherShopMap;
import Maps.House1Map;
//import Players.Cat;
import Players.MC;
import Utils.Direction;
import Utils.Point;
import java.awt.image.BufferedImage;



public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map currMap;
    protected Map house1Map, townMap, butcherShop;
    //protected Map insideMap;
    //protected Map outsideMap;
    //protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected GoreyButcherShopScreen goreyButcherScreen;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected JournalUI journal;
    private boolean journalVisible = false;
    protected Point point;
    
    protected GoreyButcherShopScreen butcherShopScreen;
    private boolean popUpVisible = false;
    protected BufferedImage popUp;


    //constructor 
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;

        // define/setup current map
        // this.currMap = new House1Map();

        //setup journal
        //journal = new JournalUI(this.currMap.getFlagManager());

        // butcherShopScreen = new GoreyButcherShopScreen(this.currMap.getFlagManager());
    }

    //initialize, set up screen
    public void initialize() {
        //flag manager- flags to keep track of game play
        flagManager = new FlagManager();
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasTalkedToMom", false);
        flagManager.addFlag("hasFoundBall", false);

        //flags for map switching
        flagManager.addFlag("house1ToTown", false);
        flagManager.addFlag("townToHouse1", false);
        flagManager.addFlag("townToButcher", false);
        flagManager.addFlag("butcherToTown", false);



        flagManager.addFlag("popUpButcherImage", false);
        popUp = ImageLoader.load("goreyButcherShop.png");

        
        // Define and set up maps
        house1Map = new House1Map();
        house1Map.setFlagManager(flagManager);

        townMap = new TownMap();
        townMap.setFlagManager(flagManager);

        butcherShop = new ButcherShopMap();
        butcherShop.setFlagManager(flagManager);

        goreyButcherScreen = new GoreyButcherShopScreen(flagManager);
        goreyButcherScreen.setFlagManager(flagManager);


        // Set the initial map to house1Map (starting map)
        currMap = house1Map;
        currMap.setFlagManager(flagManager);


        // Setup journal with the flag manager of the current map
        journal = new JournalUI(currMap.getFlagManager());

        //Setup pop up with flag manager of current map
        //butcherShopScreen = new GoreyButcherShopScreen(currMap.getFlagManager());
        
        // setup player
        player = new MC(currMap.getPlayerStartPosition().x, currMap.getPlayerStartPosition().y);
        player.setMap(currMap);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);
        currMap.setPlayer(player);


        // let pieces of map know which button to listen for as the "interact" button
        currMap.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        currMap.preloadScripts();

        //set up win screen
        winScreen = new WinScreen(this);
    }

    //update
    public void update() {
        // close pop up on 'esc' key
        if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
            popUpVisible = !popUpVisible;
            butcherShopScreen.toggleVisibility();
            keyLocker.lockKey(Key.ESC);
        }
        if(Keyboard.isKeyUp(Key.ESC)){
            keyLocker.unlockKey(Key.ESC);
        } 

        //open/close journal on 'j' click
        if (Keyboard.isKeyDown(Key.J) && !keyLocker.isKeyLocked(Key.J)) {
            journalVisible = !journalVisible;
            journal.toggleVisibility();
            keyLocker.lockKey(Key.J);
        }
        if(Keyboard.isKeyUp(Key.J)){
            keyLocker.unlockKey(Key.J);
        }
        //if the journal is open update that
        if (journalVisible) {
            journal.update();
        } 
        //otherwise, update other game logic
        else {
            // based on screen state, perform specific actions
            switch (playLevelScreenState) {
                // if level is "running" update player and map to keep game logic for the platformer level going
                case RUNNING:
                    player.update();
                    currMap.update(player);
                    break;
                // if level has been completed, bring up level cleared screen
                case LEVEL_COMPLETED:
                    winScreen.update();
                    break;
            }
        }

        if(currMap.getFlagManager().isFlagSet("popUpButcherImage")){
            goreyButcherScreen.toggleVisibility();
            System.out.println("toggle");
        }

        //leaving through door at bottom of house1 to get to down
        if (currMap.getFlagManager().isFlagSet("house1ToTown")) {
            currMap = townMap;
            point = currMap.getPositionByTileIndex(17, 24);
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            System.out.println("Switching to Town Map. Player Position: " + point.x + ", " + point.y);
            System.out.println("Before Setting Facing Direction: " + player.getFacingDirection());
            player.setFacingDirection(Direction.UP);
            System.out.println("After Setting Facing Direction: " + player.getFacingDirection());
            flagManager.unsetFlag("house1ToTown");
        }
        //leaving town to enter the house1 map
        if (currMap.getFlagManager().isFlagSet("townToHouse1")) {
            currMap = house1Map;
            point = currMap.getPositionByTileIndex(17, 21); //6,4
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            System.out.println("Switching to house Map. Player Position: " + point.x + ", " + point.y);
            player.setFacingDirection(Direction.DOWN);
            flagManager.unsetFlag("townToHouse1");
        }
        //leaving town to enter the butcher shop map
         if (currMap.getFlagManager().isFlagSet("townToButcher")) {
            currMap = butcherShop;
            point = currMap.getPositionByTileIndex(4, 11); 
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            player.setFacingDirection(Direction.DOWN);
            flagManager.unsetFlag("townToButcher");
            System.out.println("entering butcher");
        }
        //leaving butcher shop mao to enter town
        if (currMap.getFlagManager().isFlagSet("butcherToTown")) {
            currMap = townMap;
            point = currMap.getPositionByTileIndex(17, 56); 
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            player.setFacingDirection(Direction.DOWN);
            flagManager.unsetFlag("butcherToTown");
            System.out.println("entering town");
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        //if the journal is currently open draw that
        if(journalVisible){
            journal.draw(graphicsHandler);
        }
        //if popUp image is toggled, draw
        if(popUpVisible){
            butcherShopScreen.draw(graphicsHandler);
        }

        //otherwise draw appropriate graphics based on the screen state
        else{
            switch (playLevelScreenState) {
                case RUNNING:
                    currMap.draw(player, graphicsHandler);
                    break;
                case LEVEL_COMPLETED:
                    winScreen.draw(graphicsHandler);
                    break;
            }
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    //reset all screen elements
    public void resetLevel() {
        initialize();
    }

    //back to menu game state
    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    //this enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED
    }
}