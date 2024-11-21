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
import Game.GameState;
import Game.ScreenCoordinator;
import Level.FlagManager;
 
import java.awt.*;
import java.awt.image.BufferedImage;

public class Death extends Screen {
    protected BufferedImage[] deathImages;
    protected ScreenCoordinator screenCoordinator;
    protected FlagManager flagManager;
    protected boolean popUpVisible = false;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean popUpShown = false;
    protected ScreenManager screenManager;
    protected int keyPressTimer;
    private int fadeEffect;
    protected int currImageIndex = 0;
    protected int frameCount = 0;
    protected int delay = 100; 

  
 
    
    public Death(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
       
    }
      
    //set flag manager
    public void setFlagManager(FlagManager flagManager){
        this.flagManager = flagManager;
    }
      

    @Override
    public void initialize() {
        deathImages = new BufferedImage[] {
            ImageLoader.load("cutscene_2nd.png"),
            ImageLoader.load("cutscene2.png"),
            ImageLoader.load("cutscene3.png"),
            ImageLoader.load("cutscene4.png"),
            ImageLoader.load("dead_ending1.png"),
            ImageLoader.load("dead_ending2.png"),
            ImageLoader.load("dead_ending3.png")

        };

        currImageIndex = 0; //start with the first image
        frameCount = 0; 
    }

    @Override
    public void update() {
        frameCount++;

        if(frameCount >= delay){
            frameCount = 0;
            currImageIndex++;

            if (currImageIndex >= deathImages.length)  {
                screenCoordinator.setGameState(GameState.LOST);
            }
        }
        
    }

     //draw
     public void draw(GraphicsHandler graphicsHandler) {
        int screenWidth = 800;
        int screenHeight = 590;

        if (currImageIndex < deathImages.length) {
            graphicsHandler.drawImage(deathImages[currImageIndex], 0, 0, screenWidth, screenHeight);

            fadeEffect = Math.min(255, (frameCount * 255)/delay);
            graphicsHandler.drawFilledRectangle(0,0, screenWidth, screenHeight, new Color(0,0,0, 255 - fadeEffect) );
        }

        
    }
} 