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

public class MissingPosterScreen extends Screen{
/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- MissingPosterScreen: Manages the missing poster screen.
 */

    protected ScreenCoordinator screenCoordinator;
    protected ScreenManager screenManager;
    protected BufferedImage background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int screenWidth;
    protected int screenHeight;


    //constructor with a ScreenCoordinator parameter
    public MissingPosterScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        this.screenManager = new ScreenManager();
    }
    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = ImageLoader.load("MissingPoster.png");
                keyLocker.lockKey(Key.SPACE);
    }
    
    //update, if the space key is pressed go back to main menu
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.CHARSELECT);
        }
    }

    //draw each element of the credit screen
    public void draw(GraphicsHandler graphicsHandler) {
        int screenWidth = 800;
        int screenHeight = 590;
        graphicsHandler.drawImage(background, 0, 0, screenWidth, screenHeight);
    }
}