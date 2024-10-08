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
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;


public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected JournalUI journal;
    private boolean journalVisible = false;

    //constructor
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
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

        // define/setup map
        map = new TestMap();
        map.setFlagManager(flagManager);

        //setup journal
        journal = new JournalUI(map.getFlagManager());

        // setup player
        player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);
        map.setPlayer(player);

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

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
                    map.update(player);
                    break;
                // if level has been completed, bring up level cleared screen
                case LEVEL_COMPLETED:
                    winScreen.update();
                    break;
            }
        }

        /* FOR CAT GAME */
        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall")) {
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
                    map.draw(player, graphicsHandler);
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
