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
import Maps.MyMap;
import Maps.TestMap;
//import Players.Cat;
import Players.MC;
import Utils.Direction;



public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map currMap;
    protected Map insideMap;
    protected Map outsideMap;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected JournalUI journal;
    private boolean journalVisible = false;
    protected GoreyButcherShopScreen butcherShopScreen;
    private boolean popUpVisible = false;


    //constructor 
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        // define/setup current map
        this.currMap = new TestMap();

        //setup journal
        journal = new JournalUI(this.currMap.getFlagManager());

        butcherShopScreen = new GoreyButcherShopScreen(this.currMap.getFlagManager());
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
        flagManager.addFlag("popUpButcherImage", false);

        this.currMap.setFlagManager(flagManager);
        journal.setFlagManager(flagManager);

        //define other maps
        insideMap = new TestMap();
        insideMap.setFlagManager(this.currMap.getFlagManager());
        outsideMap = new MyMap();
        outsideMap.setFlagManager(this.currMap.getFlagManager());

        // setup player
        player = new MC(this.currMap.getPlayerStartPosition().x, this.currMap.getPlayerStartPosition().y);
        player.setMap(this.currMap);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);
        this.currMap.setPlayer(player);

        // let pieces of map know which button to listen for as the "interact" button
        this.currMap.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        this.currMap.preloadScripts();

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
                    this.currMap.update(player);
                    break;
                // if level has been completed, bring up level cleared screen
                case LEVEL_COMPLETED:
                    winScreen.update();
                    break;
            }
        }
        //if leaving through door on left, switch maps
        if(this.currMap.getFlagManager().isFlagSet("exitInteract")){
            this.currMap = outsideMap;
            initialize();

        }
        //going back into house, switch maps
        if(this.currMap.getFlagManager().isFlagSet("enteringHome")){
            this.currMap = insideMap;
            initialize();
            //set location to doorway
            
        }

        //if walking through trigger, play image
        if(this.currMap.getFlagManager().isFlagSet("popUpImageButcher")){
            popUpVisible = !popUpVisible;
            butcherShopScreen.toggleVisibility();
            initialize();
        }




        /* FOR CAT GAME */
        // if flag is set at any point during gameplay, game is "won"
        if (this.currMap.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }

        /* 
        if (currMap.getFlagManager().isFlagSet("exitInteract")) {
            screenCoordinator.setGameState(GameState.MYMAP);
        }
        */

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
                    this.currMap.draw(player, graphicsHandler);
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
