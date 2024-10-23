/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- ButcherShopScreen: Manages the butcher shop pop up in the game, handling visibility toggles
 */

package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;
import NPCs.Butcher;

import java.awt.*;
import java.awt.image.BufferedImage;
 
 public class GoreyButcherShopScreen {
     protected BufferedImage goreyButcherShop;
     protected ScreenCoordinator screenCoordinator;
     protected FlagManager flagManager;
     protected boolean popUpVisible = false;
     protected KeyLocker keyLocker = new KeyLocker();
     protected boolean popUpShown = false;
 

     //constructor with FlagManager parameter
     public GoreyButcherShopScreen(FlagManager flagManager) {
        this.flagManager = flagManager;
        // Load butcher pop up image
        goreyButcherShop = ImageLoader.load("goreyButcherShop.png");
     }
 
     public void setFlagManager(FlagManager flagManager){
         this.flagManager = flagManager;
     }
 
     //is the photo pop up screen visible
     public void toggleVisibility() {
        popUpVisible = !popUpVisible; //makes it true
     }

     //update
    public void update() {
        
    }

     //draw
     public void draw(GraphicsHandler graphicsHandler) {
         //draw while the image is visible
         if (popUpVisible) {
            System.out.println("visible");
             graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
             graphicsHandler.drawImage(goreyButcherShop, 0, 0, 800, 550);
         }
         else{
            System.out.println("invisible");
         }
     }
 
 } 