package Screens;

import Engine.*;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.awt.image.BufferedImage;

// This class is for the win level screen
public class LostScreen extends Screen {
    protected SpriteFont LostMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected BufferedImage loseScreen;

    public LostScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        loseScreen = ImageLoader.load("lose_screen.png");


       
        keyLocker.lockKey(Key.ESC);
    }

    @Override
    public void update() {
       
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

     if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            playLevelScreen.goBackToMenu();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        int screenWidth = 800;
        int screenHeight = 590;
        graphicsHandler.drawImage(loseScreen, 0, 0, screenWidth, screenHeight);

        
    }
}
