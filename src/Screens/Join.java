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

public class Join extends Screen {
    protected BufferedImage[] joinImages;
    protected ScreenCoordinator screenCoordinator;
    protected FlagManager flagManager;
    protected boolean popUpVisible = false;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean popUpShown = false;
    protected ScreenManager screenManager;
    protected int keyPressTimer;
   // private int delay;
    private int fadeEffect;
    protected int currImageIndex = 0;
    protected int frameCount = 0;
    protected int delay = 120; //framesPerImage - displays images for 2 seconds at 60 frames per second

  
 
    
    public Join(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        //this.screenManager = new ScreenManager();
        // Load image 
       
    }
      
    //set flag manager
    public void setFlagManager(FlagManager flagManager){
        this.flagManager = flagManager;
    }
      

    @Override
    public void initialize() {
        //deathImages = ImageLoader.load("dead_ending1.png");
        //keyPressTimer = 0; //initialize timer

        joinImages = new BufferedImage[] {
            ImageLoader.load("cutscene_2nd.png"),
            ImageLoader.load("cutscene2.png"),
            ImageLoader.load("cutscene3.png"),
            ImageLoader.load("cutscene4.png"),
            ImageLoader.load("cutscene5.png"),
            ImageLoader.load("cutscene6good.png"),
            ImageLoader.load("cutscene7good.png"),

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

            if (currImageIndex >= joinImages.length)  {
                screenCoordinator.setGameState(GameState.WIN);
            }
        }
        
    }

     //draw
     public void draw(GraphicsHandler graphicsHandler) {
        int screenWidth = 800;
        int screenHeight = 590;

        if (currImageIndex < joinImages.length) {
            graphicsHandler.drawImage(joinImages[currImageIndex], 0, 0, screenWidth, screenHeight);

            fadeEffect = Math.min(255, (frameCount * 255)/delay);
            graphicsHandler.drawFilledRectangle(0,0, screenWidth, screenHeight, new Color(0,0,0, 255 -fadeEffect) );
        }

        
    }
} 
