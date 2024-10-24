/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- fridgeScreen: Manages drawing the fridge shop pop up in house1 of the game
 */

package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;

import java.awt.*;
import java.awt.image.BufferedImage;
 
 public class FridgeScreen {
     protected BufferedImage fridge;
     protected ScreenCoordinator screenCoordinator;
     protected FlagManager flagManager;
     protected boolean popUpVisible = false;
     protected KeyLocker keyLocker = new KeyLocker();
     protected boolean popUpShown = false;
 

     //constructor with FlagManager parameter
     public FridgeScreen(FlagManager flagManager) {
        this.flagManager = flagManager;
        // Load butcher pop up image
        fridge = ImageLoader.load("fridge.png");
     }
     
     //set flag manager
     public void setFlagManager(FlagManager flagManager){
         this.flagManager = flagManager;
     }
     
     //draw
     public void draw(GraphicsHandler graphicsHandler) {
         //draw while the image is visible
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        graphicsHandler.drawImage(fridge, 0, 0, 800, 550);
     }
 
 } 