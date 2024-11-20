package Screens;
/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- ButcherDeathScreen: Manages drawing the butcher's death pop up in the game
 */

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import Level.FlagManager;


public class ButcherDeathScreen{
    // protected ScreenCoordinator screenCoordinator;
    // protected ScreenManager screenManager;
    // protected BufferedImage background;
    // protected KeyLocker keyLocker = new KeyLocker();
    // protected int screenWidth;
    // protected int screenHeight;


    // //constructor with a ScreenCoordinator parameter
    // public ButcherDeathScreen(ScreenCoordinator screenCoordinator) {
    //     this.screenCoordinator = screenCoordinator;
    //     this.screenManager = new ScreenManager();
    // }
    // @Override
    // public void initialize() {
    //     // setup graphics on screen (background map, spritefont text)
    //     background = ImageLoader.load("butcher_death.png");
    //             keyLocker.lockKey(Key.SPACE);
    // }
    
    // //update, if the space key is pressed go back to main menu
    // public void update() {
    //     if (Keyboard.isKeyUp(Key.SPACE)) {
    //         keyLocker.unlockKey(Key.SPACE);
    //     }
    //     if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
    //         screenCoordinator.setGameState(GameState.LEVEL);
    //     }
    // }

    // //draw each element of the credit screen
    // public void draw(GraphicsHandler graphicsHandler) {
    //     int screenWidth = 800;
    //     int screenHeight = 590;
    //     graphicsHandler.drawImage(background, 0, 0, screenWidth, screenHeight);
    // }
    protected BufferedImage butcherDeath;
    protected ScreenCoordinator screenCoordinator;
    protected FlagManager flagManager;
    protected boolean popUpVisible = false;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean popUpShown = false;
  
 
    //constructor with FlagManager parameter
    public ButcherDeathScreen(FlagManager flagManager) {
        this.flagManager = flagManager;
        // Load file pop up image
        butcherDeath = ImageLoader.load("butcher_death.png");
    }
      
    //set flag manager
    public void setFlagManager(FlagManager flagManager){
        this.flagManager = flagManager;
    }
    
    //draw
    public void draw(GraphicsHandler graphicsHandler) {
        //draw while the image is visible
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        graphicsHandler.drawImage(butcherDeath, 0, 0, 800, 550);
    }
} 