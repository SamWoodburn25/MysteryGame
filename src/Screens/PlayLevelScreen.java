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

import Engine.BackgroundMusic;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TownMap;
import Maps.ButcherShopMap;
import Maps.CemeteryMap;
import Maps.House1Map;
import Players.MC;
import Utils.Direction;
import Utils.Point;



public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected LostScreen lostScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected JournalUI journal;
    private boolean journalVisible = false;
    protected Point point;
   
    //maps
    protected Map currMap;
    protected Map house1Map, townMap, butcherShop, cemetery;
    //pop up variables
    protected AFrameHPScreen aFrameHPScreen;
    protected GoreyButcherShopScreen goreyButcherScreen;
    protected ScaryGraveyardScreen scaryGraveyardScreen;
    protected FridgeScreen fridgeScreen;
    protected boolean popUpVisible = false;
    protected boolean drawPopUP = false;
    protected boolean drawPopUpHouse=false;
    protected boolean drawGravePopUP = false;
    protected boolean drawFridgePopUP = false;
    protected boolean drawCharSelect = false;
    //butcher puzzle variables
    protected ButcherPuzzle butcherPuzzle;
    protected boolean puzzleVisible = false;
    protected boolean drawPuzzle = false;
    //exgf puzzle variables
    protected ExgfPuzzle exgfPuzzle;
    protected boolean exPuzzleVisible = false;
    protected boolean exDrawPuzzle = false;
    //graveyard puzzle variables
    protected GraveYardPuzzle graveyardPuzzle;
    protected boolean graveyardPuzzleVisible = false;
    protected boolean graveyardDrawPuzzle = false;

    //character selection variables
    protected CharacterSelectScreen charSelectScreen;
    protected String charHair;
    //music 
    private BackgroundMusic backgroundMusic;

    //constructor 
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        
    }

    //initialize, set up screen
    public void initialize() {
        //flag manager- flags to keep track of who has been talked to
        flagManager = new FlagManager();
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasTalkedToMom", false);
        flagManager.addFlag("hasTalkedToMax", false);
        flagManager.addFlag("max_aboutPeter", false);
        flagManager.addFlag("max_aboutEx", false);
        flagManager.addFlag("hasTalkedToButcher", false);
        flagManager.addFlag("hasTalkedToGF", false);
        flagManager.addFlag("hasTalkedToDrugDealerDaughter", false);
        flagManager.addFlag("hasTalkedToDrugDealer", false);
        flagManager.addFlag("hasTalkedToDamien", false);

        //flags for endings
        flagManager.addFlag("lieMom", false);
        flagManager.addFlag("badButcher", false);
        flagManager.addFlag("badDD", false);
        flagManager.addFlag("badGF", false);

        //flags for map switching
        flagManager.addFlag("house1ToTown", false);
        flagManager.addFlag("townToHouse1", false);
        flagManager.addFlag("townToButcher", false);
        flagManager.addFlag("butcherToTown", false);
        flagManager.addFlag("townToCemetery", false);
        flagManager.addFlag("cemeteryToTown", false);


        //flag to manage pop-up
        flagManager.addFlag("popUpHouseImage",false);
        flagManager.addFlag("popUpButcherImage", false);
        flagManager.addFlag("graveyardImage", false);
        flagManager.addFlag("popUpFridgeImage", false);
        flagManager.addFlag("charSelect", false);

        //flag to open puzzle game screens
        flagManager.addFlag("openButcherPuzzle", false);
        flagManager.addFlag("butcherPuzzleSolved", false);
        flagManager.addFlag("openExgfPuzzle", false);
        flagManager.addFlag("exGfPuzzleSolved", false);
        flagManager.addFlag("openGraveyardPuzzle", false);
        flagManager.addFlag("graveyardPuzzleSolved", false);

        //change to death screen but its not going to work bc the world hates me and wants me to suffer lol 
        flagManager.addFlag("deathScreen", false);

        // setup background music 
        backgroundMusic= new BackgroundMusic("Resources/GameSong.wav");

        //start house music 
        backgroundMusic.playLocationMusic("house");

        
        // Define and set up maps
        house1Map = new House1Map();
        house1Map.setFlagManager(flagManager);

        townMap = new TownMap();
        townMap.setFlagManager(flagManager);

        butcherShop = new ButcherShopMap();
        butcherShop.setFlagManager(flagManager);

        cemetery = new CemeteryMap();
        cemetery.setFlagManager(flagManager);
        

        //define and set up pop-up with flag manager
        aFrameHPScreen= new AFrameHPScreen(flagManager);
        goreyButcherScreen = new GoreyButcherShopScreen(flagManager);
        scaryGraveyardScreen = new ScaryGraveyardScreen(flagManager);
        fridgeScreen = new FridgeScreen(flagManager);

        //puzzles
        butcherPuzzle = new ButcherPuzzle(flagManager);
        exgfPuzzle = new ExgfPuzzle(flagManager);
        graveyardPuzzle = new GraveYardPuzzle(flagManager);

        // Set the initial map to house1Map (starting map)
        currMap = house1Map;
        //currMap.setFlagManager(flagManager);


        // Setup journal with the flag manager of the current map
        journal = new JournalUI(currMap.getFlagManager());
        
        //char select
        int charSelect = CharacterSelectScreen.getChoice();
        if(charSelect == 0){
            charHair = "mc.png";
        } else {
            charHair = "mcSH.png";
        }


        player = new MC(currMap.getPlayerStartPosition().x, currMap.getPlayerStartPosition().y, charHair);


        
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
        lostScreen = new LostScreen(this);

    }

    //update
    public void update() {

        //open/close journal on 'j' click
        if (Keyboard.isKeyDown(Key.J) && !keyLocker.isKeyLocked(Key.J) && !currMap.getFlagManager().isFlagSet("openExgfPuzzle")) {
            //jClicked
            journalVisible = !journalVisible;
            journal.toggleVisibility();
            keyLocker.lockKey(Key.J);
        }
        if(Keyboard.isKeyUp(Key.J)){
            keyLocker.unlockKey(Key.J);
        }
        //update puzzles
        if(drawPuzzle){
            butcherPuzzle.update();
        }
        if(exDrawPuzzle){
            exgfPuzzle.update();
        }
        if(graveyardDrawPuzzle){
            graveyardPuzzle.update();
        }
        //if the journal is open update that
        if (journalVisible) {
            journal.update();
        } 
        //otherwise, update other game logic
        else {
            // based on screen state, perform specific actions
            switch (playLevelScreenState) {
                // if level is "running" update player and map 
                case RUNNING:
                    player.update();
                    currMap.update(player);
                    break;
                // if level has been completed, bring up level cleared screen
                case LEVEL_COMPLETED:
                    winScreen.update();
                    break;
                case LEVEL_NOT_COMPLETED:
                    lostScreen.update();
                    break;
            }
        }

        //if pop up flag set draw the image
        if(currMap.getFlagManager().isFlagSet("popUpHouseImage")){
            drawPopUpHouse = true;
            //close image on escape click
            if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
                drawPopUpHouse = false;
                currMap.getFlagManager().unsetFlag("popUpHouseImage");
                keyLocker.lockKey(Key.ESC);
            }
            if(Keyboard.isKeyUp(Key.ESC)){
                keyLocker.unlockKey(Key.ESC);
            } 
        } 

        //if pop up flag set draw the image
        if(currMap.getFlagManager().isFlagSet("popUpButcherImage")){
            drawPopUP = true;
            //close image on escape click
            if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
                drawPopUP = false;
                currMap.getFlagManager().unsetFlag("popUpButcherImage");
                keyLocker.lockKey(Key.ESC);
            }
            if(Keyboard.isKeyUp(Key.ESC)){
                keyLocker.unlockKey(Key.ESC);
            } 
        }  
        if(currMap.getFlagManager().isFlagSet("graveyardImage")){
            drawGravePopUP = true;
            //close image on escape click
            if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
                drawGravePopUP = false;
                currMap.getFlagManager().unsetFlag("graveyardImage");
                keyLocker.lockKey(Key.ESC);
            }
            if(Keyboard.isKeyUp(Key.ESC)){
                keyLocker.unlockKey(Key.ESC);
            } 
        }  
        if(currMap.getFlagManager().isFlagSet("popUpFridgeImage")){
            drawFridgePopUP = true;
            //close image on escape click
            if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
                drawFridgePopUP = false;
                currMap.getFlagManager().unsetFlag("popUpFridgeImage");
                keyLocker.lockKey(Key.ESC);
            }
            if(Keyboard.isKeyUp(Key.ESC)){
                keyLocker.unlockKey(Key.ESC);
            } 
        }      
        //butcher puzzle
        if(currMap.getFlagManager().isFlagSet("openButcherPuzzle")){
            drawPuzzle = true;
            //close image on escape click
            if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
                drawPuzzle = false;
                currMap.getFlagManager().unsetFlag("openButcherPuzzle");
                keyLocker.lockKey(Key.ESC);
            }
            if(Keyboard.isKeyUp(Key.ESC)){
                currMap.getFlagManager().unsetFlag("openButcherPuzzle");
                keyLocker.unlockKey(Key.ESC);
            } 
        }       
        if(currMap.getFlagManager().isFlagSet("butcherPuzzleSolved")) {
            drawPuzzle = false;
        } 
        //ex puzzle
        if(currMap.getFlagManager().isFlagSet("openExgfPuzzle")){
            exDrawPuzzle = true;
            //close image on escape click
            if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
                exDrawPuzzle = false;
                currMap.getFlagManager().unsetFlag("openExgfPuzzle");
                keyLocker.lockKey(Key.ESC);
            }
            if(Keyboard.isKeyUp(Key.ESC)){
                keyLocker.unlockKey(Key.ESC);
            } 
        } 
        if(currMap.getFlagManager().isFlagSet("exGfPuzzleSolved")) {
            exDrawPuzzle = false;
            currMap.getFlagManager().unsetFlag("openExgfPuzzle");
        }  
                                                                                                   
            
        //character selection
        if(!currMap.getFlagManager().isFlagSet("charSelectScreen")){
            drawCharSelect = true;
            //close screen with space 
            if(Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)){
                drawCharSelect = false; 
                currMap.getFlagManager().unsetFlag("charSelectScreen");
                keyLocker.lockKey(Key.SPACE);
            }
            if(Keyboard.isKeyUp(Key.SPACE)){
                keyLocker.unlockKey(Key.SPACE);
            } 

        

        }  



      //change music 

        /*
         * flags for switching maps: update player, flags, and scripts for each change of currMap
         */
        //leaving through door at bottom of house1 to get to down
        
        
        if (currMap.getFlagManager().isFlagSet("house1ToTown")) {
            currMap = townMap;
            point = currMap.getPositionByTileIndex(21, 15);
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            player.setLocation(point.x, (point.y)-10);
            backgroundMusic.playLocationMusic("town");
            System.out.println("Switching to Town Map. Player Position: " + point.x + ", " + point.y);
            System.out.println("Before Setting Facing Direction: " + player.getFacingDirection());
            player.setFacingDirection(Direction.UP);
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.loadScripts();
            System.out.println("After Setting Facing Direction: " + player.getFacingDirection());
            flagManager.unsetFlag("house1ToTown");
        }
        //leaving town to enter the house1 map
        if (currMap.getFlagManager().isFlagSet("townToHouse1")) {
            currMap = house1Map;
            point = currMap.getPositionByTileIndex(17, 21); //6,4
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            backgroundMusic.playLocationMusic("house");
            player.setFacingDirection(Direction.DOWN);
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.loadScripts();
            flagManager.unsetFlag("townToHouse1");
        }
    
        //leaving town to enter the butcher shop map
         if (currMap.getFlagManager().isFlagSet("townToButcher")) {
            currMap = butcherShop;
            point = currMap.getPositionByTileIndex(4, 5); 
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            backgroundMusic.playLocationMusic("butcher");
            player.setFacingDirection(Direction.DOWN);
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.loadScripts();
            flagManager.unsetFlag("townToButcher");
            System.out.println("entering butcher");
        }
        //leaving butcher shop map to enter town
        if (currMap.getFlagManager().isFlagSet("butcherToTown")) {
            currMap = townMap;
            point = currMap.getPositionByTileIndex(69, 46); 
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            backgroundMusic.PlayMainMusic();
            player.setFacingDirection(Direction.DOWN);
            currMap.setPlayer(player);
            currMap.preloadScripts();
            player.setFacingDirection(Direction.UP);
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.loadScripts();
            flagManager.unsetFlag("butcherToTown");
            System.out.println("entering town");
        }
  
        if (currMap.getFlagManager().isFlagSet("townToCemetery")) {
            //open graveyard puzzle
            graveyardDrawPuzzle = true;
            currMap.getFlagManager().setFlag("openGraveyardPuzzle");
            //close puzzle on escape click
            if(Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)){
                graveyardDrawPuzzle = false;
                currMap.getFlagManager().unsetFlag("openGraveyardPuzzle");
                currMap.getFlagManager().setFlag("cemeteryToTown");
                keyLocker.lockKey(Key.ESC);
            }
            if(Keyboard.isKeyUp(Key.ESC)){
                keyLocker.unlockKey(Key.ESC);
            } 
            //if you solve it close the puzzle and set cemetery map
            if(currMap.getFlagManager().isFlagSet("graveYardPuzzleSolved")) {
                graveyardDrawPuzzle = false;
                currMap.getFlagManager().unsetFlag("openGraveyardPuzzle");
            } 
            currMap = cemetery;
            point = currMap.getPositionByTileIndex(1, 23); 
            player.setMap(currMap);
            player.update();
            player.setLocation(point.x, point.y);
            backgroundMusic.playLocationMusic("cemetery");
            player.setFacingDirection(Direction.DOWN);
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.setPlayer(player);
            currMap.preloadScripts();
            currMap.loadScripts();
            flagManager.unsetFlag("townToCemetery");
        }
            
            //leaving cemetery to enter town
            if (currMap.getFlagManager().isFlagSet("cemeteryToTown")) {
                currMap = townMap;
                point = currMap.getPositionByTileIndex(92, 16); 
                player.setMap(currMap);
                player.setLocation(point.x, point.y);
                backgroundMusic.PlayMainMusic();
                player.setFacingDirection(Direction.DOWN);
                currMap.setPlayer(player);
                currMap.preloadScripts();
                player.setFacingDirection(Direction.UP);
                currMap.setPlayer(player);
                currMap.preloadScripts();
                currMap.loadScripts();
                flagManager.unsetFlag("cemeteryToTown");
            }

            //death
            if(currMap.getFlagManager().isFlagSet("deathScreen")) {
                screenCoordinator.setGameState(GameState.DEATH);
               
            }
        }

    public void draw(GraphicsHandler graphicsHandler) {
        //if the journal is currently open draw that
        if(journalVisible){
            journal.draw(graphicsHandler);
        }

        //otherwise draw appropriate graphics based on the screen state
        else{
            //fixing the journal bug, set back to cover page after closing journal
            journal.setCurrPage(0);
            switch (playLevelScreenState) {
                case RUNNING:
                    //draw the butcher shop pop up if triggered (drawPopUp is true)
                    if(drawPopUP){
                        goreyButcherScreen.draw(graphicsHandler);
                    }
                    else if(drawGravePopUP) {
                        scaryGraveyardScreen.draw(graphicsHandler);
                    }
                    else if(drawFridgePopUP){
                        fridgeScreen.draw(graphicsHandler);
                    }
                    else if(drawPuzzle){
                        butcherPuzzle.draw(graphicsHandler);
                    }
                    else if(exDrawPuzzle){
                        exgfPuzzle.draw(graphicsHandler);
                    }
                    else if (drawPopUpHouse){
                        aFrameHPScreen.draw(graphicsHandler);
                    }
                    else if(graveyardDrawPuzzle && !currMap.getFlagManager().isFlagSet("graveyardPuzzleSolved")){
                        graveyardPuzzle.draw(graphicsHandler);
                    }
                    //otherwise draw current map
                    else{
                        currMap.draw(player, graphicsHandler);
                    }
                    break;
                case LEVEL_COMPLETED:
                    winScreen.draw(graphicsHandler);
                    break;
                case  LEVEL_NOT_COMPLETED:
                    lostScreen.draw(graphicsHandler);
                    break;
            }
        }
    }

    //getter for current playLevelScreenState
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
        RUNNING, LEVEL_COMPLETED, LEVEL_NOT_COMPLETED
    }
}