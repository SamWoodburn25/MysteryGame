/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- Context0Screen: Manages the first context screen, displaying background information and handling 
 * the transition from main screen to second context screen.
 */

package Screens;

import java.awt.Color;
import java.awt.image.BufferedImage;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

public class Context0Screen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected ScreenManager screenManager;
    protected BufferedImage background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont contextLabel0;
    protected SpriteFont contextLabel1;
    protected SpriteFont contextLabel2;
    protected SpriteFont contextLabel3;
    protected SpriteFont contextLabel4;
    protected SpriteFont contextLabel5;
    protected SpriteFont continueLabel;
    protected int screenWidth;
    protected int screenHeight;


    //constructor with a ScreenCoordinator parameter
    public Context0Screen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        this.screenManager = new ScreenManager();
    }
    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = ImageLoader.load("ContextScreen0.png");
        contextLabel0 = new SpriteFont("A few months ago, your brother disappeared out of nowhere.", 70, 140, "Apple Chancery", 28, new Color(184, 15, 10));
        contextLabel1 = new SpriteFont("The only clue police found was his torn up notebook left", 90,226, "Apple Chancery", 28, new Color(184, 15, 10));
        contextLabel2 = new SpriteFont("in his room, which is now in your possession. Your mom", 70, 313, "Apple Chancery", 30, new Color(184, 15, 10));
        contextLabel3 = new SpriteFont("is in a state of denial", 270, 400, "Apple Chancery", 30, new Color(184, 15, 10));
      
        continueLabel = new SpriteFont("Press Space to Continue", 580, 530, "Apple Chancery", 15, new Color(255, 225, 225));
        keyLocker.lockKey(Key.SPACE);
    }
    
    //update, if the space key is pressed go back to main menu
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.CONTEXT1);
        }
    }

    //draw each element of the credit screen
    public void draw(GraphicsHandler graphicsHandler) {
        int screenWidth = 800;
        int screenHeight = 590;
        graphicsHandler.drawImage(background, 0, 0, screenWidth, screenHeight);
        contextLabel0.draw(graphicsHandler);
        contextLabel1.draw(graphicsHandler);
        contextLabel2.draw(graphicsHandler);
        contextLabel3.draw(graphicsHandler);
        continueLabel.draw(graphicsHandler);
    }
}
