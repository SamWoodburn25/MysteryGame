/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- ScaryDogScreen: Manages drawing the dog  pop up in the game
 */

 package Screens;

 import Engine.*;
 import Game.ScreenCoordinator;
 import Level.FlagManager;
 
 import java.awt.*;
 import java.awt.image.BufferedImage;
  
  public class ScaryDogScreen {
      protected BufferedImage dumpScare;
      protected ScreenCoordinator screenCoordinator;
      protected FlagManager flagManager;
      protected boolean popUpVisible = false;
      protected KeyLocker keyLocker = new KeyLocker();
      protected boolean popUpShown = false;
  
 
      //constructor with FlagManager parameter
      public ScaryDogScreen(FlagManager flagManager) {
         this.flagManager = flagManager;
         // Load butcher pop up image
         dumpScare = ImageLoader.load("dumpscare.png");
      }
      
      //set flag manager
      public void setFlagManager(FlagManager flagManager){
          this.flagManager = flagManager;
      }
      
      //draw
      public void draw(GraphicsHandler graphicsHandler) {
          //draw while the image is visible
         graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
         graphicsHandler.drawImage(dumpScare, 0, 0, 800, 550);
      }
  
  } 