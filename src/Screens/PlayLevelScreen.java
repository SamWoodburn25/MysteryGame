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
import Maps.ButcherShopMap;
import Maps.MyMap;
import Maps.TestMap;
//import Players.Cat;
import Players.MC;
import Utils.Direction;
import Utils.Point;



public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map currMap;
    protected Map insideMap;
    protected Map outsideMap;
    protected Map butcherShop;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected JournalUI journal;
    protected boolean journalVisible = false;
    protected boolean allowTransition = true;
    protected Point lastTransitionPosition;


    //constructor 
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        System.out.println("calling play level");
        this.screenCoordinator = screenCoordinator;
        // define/setup current map
        this.currMap = new TestMap();
        flagManager = new FlagManager();
        this.currMap.setFlagManager(flagManager);
        //setup journal
        journal = new JournalUI(this.currMap.getFlagManager());
        //define other maps
        insideMap = new TestMap();
        insideMap.setFlagManager(this.currMap.getFlagManager());
        outsideMap = new MyMap();
        outsideMap.setFlagManager(this.currMap.getFlagManager());
        butcherShop = new ButcherShopMap();
        butcherShop.setFlagManager(this.currMap.getFlagManager());
    }

    //initialize, set up screen
    public void initialize() {
        //flag manager- flags to keep track of game play
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasTalkedToMom", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("exitInteract",false);
        flagManager.addFlag("enteringHome", false);
        flagManager.addFlag("recentlyTransitioned", false);
        flagManager.addFlag("canEnter", false);
        flagManager.addFlag("canExit", true);


        this.currMap.setFlagManager(flagManager);
        journal.setFlagManager(flagManager);

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
        //set up  current map
        setMap();

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
                    System.out.println(currMap);
                    //checkForTransitionReset();
                    break;
                // if level has been completed, bring up level cleared screen
                case LEVEL_COMPLETED:
                    winScreen.update();
                    break;
            }
        }

        /* FOR CAT GAME */
        // if flag is set at any point during gameplay, game is "won"
        if (this.currMap.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
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

    public void setMap(){
        //if(!allowTransition) return;
        // Temporarily store the current map for comparison
        Map oldMap = currMap;
        // Determine which map to switch based on some integer index
        switch(currMap.getCurrMapInt()) {
            case 0:
                currMap = insideMap;
                break;
            case 1:
                currMap = outsideMap;
                flagManager.setFlag("canEnter");
                flagManager.unsetFlag("cantExit");
                break;
            case 2:
                this.currMap = butcherShop;
                break;
            default:
                System.out.println("DEFAULT");
                return; // If the index is invalid or no change is needed, do nothing
    }

    // If the map has changed, update player and map context
    if (currMap != oldMap) {
        player.setMap(currMap); // Update the player's map context
        player.setPosition(currMap.getPlayerStartPosition().x, currMap.getPlayerStartPosition().y); // Set player position
        currMap.setPlayer(player); // Ensure the new map is aware of the player
        currMap.setFlagManager(flagManager);
        //lastTransitionPosition = new Point(player.getX(), player.getY());
        //allowTransition = false;
        oldMap = currMap;
    }
}


private void checkForTransitionReset() {
    // Assume lastTransitionPosition is stored when transition occurs
    /* 
     double distance = Math.sqrt(Math.pow(player.getX() - lastTransitionPosition.x, 2) +
                                Math.pow(player.getY() - lastTransitionPosition.y, 2));
    if (distance > 700) {
        allowTransition = true;  // Re-enable transitions
    }
    */

    if(player.getX() > 18 && player.getY() < 20){
        allowTransition = true;
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