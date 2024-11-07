/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- ScaryGraveyardScreen: Manages drawing the graveyard pop up in the game
*/

package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;
 
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScaryGraveyardScreen {
    protected BufferedImage graveyardImage;
    protected ScreenCoordinator screenCoordinator;
    protected FlagManager flagManager;
    protected boolean popUpVisible = false;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean popUpShown = false;
  
 
    //constructor with FlagManager parameter
    public ScaryGraveyardScreen(FlagManager flagManager) {
        this.flagManager = flagManager;
        // Load butcher pop up image
        graveyardImage = ImageLoader.load("graveyardPopUp.png");
    }
      
    //set flag manager
    public void setFlagManager(FlagManager flagManager){
        this.flagManager = flagManager;
    }
      
    //draw
    public void draw(GraphicsHandler graphicsHandler) {
        //draw while the image is visible
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        graphicsHandler.drawImage(graveyardImage, 0, 0, 800, 550);
    }
} 