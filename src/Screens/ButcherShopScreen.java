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

// import Players.Cat;
import Players.MC;
import Utils.Direction;


// This class is for when the RPG game is actually being played
public class ButcherShopScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected KeyLocker keyLocker = new KeyLocker();
    protected JournalUI journal;
    private boolean journalVisible = false;
    //protected String mapName;
    


    public ButcherShopScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        // define/setup map
        map = new TownMap();
        map.setFlagManager(flagManager);

        //setup journal
        journal = new JournalUI(map.getFlagManager());
    

        // setup player
        player = new MC(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

        //winScreen = new WinScreen(this);
    }

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

        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }


    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    
    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED
    }
}
