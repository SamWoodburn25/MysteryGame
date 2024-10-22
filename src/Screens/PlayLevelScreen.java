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
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TownMap;
import Maps.House1Map;
//import Players.Cat;
import Players.MC;
import Utils.Direction;
import Utils.Point;



public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map currMap;
    //protected Map insideMap;
    //protected Map outsideMap;
    //protected Map map;
    protected Map house1Map, townMap;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected JournalUI journal;
    private boolean journalVisible = false;
    protected Point point;


    //constructor 
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        // define/setup current map
        // this.currMap = new House1Map();

        //setup journal
        //journal = new JournalUI(this.currMap.getFlagManager());
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
        flagManager.addFlag("exitInteract",false);
        flagManager.addFlag("enteringHome", false);

        /*this.currMap.setFlagManager(flagManager);
        journal.setFlagManager(flagManager);*/
        flagManager.addFlag("house1ToTown", false);
        flagManager.addFlag("townToHouse1", false);


        //define other maps
        /*insideMap = new House1Map();
        insideMap.setFlagManager(this.currMap.getFlagManager());
        outsideMap = new TownMap();
        outsideMap.setFlagManager(this.currMap.getFlagManager()); */

        // Define and set up maps
        house1Map = new House1Map();
        house1Map.setFlagManager(flagManager);

        townMap = new TownMap();
        townMap.setFlagManager(flagManager);

        // Set the initial map to house1Map (starting map)
        currMap = house1Map;
        currMap.setFlagManager(flagManager);

        // Setup journal with the flag manager of the current map
        journal = new JournalUI(currMap.getFlagManager());


        
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
        //if leaving through door on left, switch maps
        /*if(this.currMap.getFlagManager().isFlagSet("exitInteract")){
            this.currMap = outsideMap;
            initialize();

        }
        //going back into house, switch maps
        if(this.currMap.getFlagManager().isFlagSet("enteringHome")){
            this.currMap = insideMap;
            initialize();
            //set location to doorway
            
        } */

        /* FOR CAT GAME */
        // if flag is set at any point during gameplay, game is "won"
        if (currMap.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }

        /* 
        if (currMap.getFlagManager().isFlagSet("exitInteract")) {
            screenCoordinator.setGameState(GameState.MYMAP);
        }
        */
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
        if (currMap.getFlagManager().isFlagSet("townToHouse1")) {
            currMap = house1Map;
            point = currMap.getPositionByTileIndex(17, 21); //6,4
            player.setMap(currMap);
            player.setLocation(point.x, point.y);
            player.setFacingDirection(Direction.DOWN);
            flagManager.unsetFlag("townToHouse1");
        }

    }

    public void draw(GraphicsHandler graphicsHandler) {
        //if the journal is currently open draw that
        if(journalVisible){
            journal.draw(graphicsHandler);
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
