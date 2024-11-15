package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;
 
import java.awt.*;
import java.awt.image.BufferedImage;

public class FBIFileScreen {

    protected BufferedImage fileImage;
    protected ScreenCoordinator screenCoordinator;
    protected FlagManager flagManager;
    protected boolean popUpVisible = false;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean popUpShown = false;
  
 
    //constructor with FlagManager parameter
    public FBIFileScreen(FlagManager flagManager) {
        this.flagManager = flagManager;
        // Load file pop up image
        fileImage = ImageLoader.load("graveyardPopUp.png");
    }
      
    //set flag manager
    public void setFlagManager(FlagManager flagManager){
        this.flagManager = flagManager;
    }
    
    //draw
    public void draw(GraphicsHandler graphicsHandler) {
        //draw while the image is visible
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        graphicsHandler.drawImage(fileImage, 0, 0, 800, 550);
    }
} 