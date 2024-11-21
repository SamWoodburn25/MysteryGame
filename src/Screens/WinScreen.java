package Screens;

import Engine.*;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.awt.image.BufferedImage;

// This class is for the win level screen
public class WinScreen extends Screen {
    protected SpriteFont winMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected BufferedImage winScreen;

    public WinScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        winScreen = ImageLoader.load("win_screen.png");
        //keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);
    }

    @Override
    public void update() {
        // if (Keyboard.isKeyUp(Key.SPACE)) {
        //     keyLocker.unlockKey(Key.SPACE);
        
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // // if space is pressed, reset level. if escape is pressed, go back to main menu
        // if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
        //     playLevelScreen.resetLevel();
        if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            playLevelScreen.goBackToMenu();
        }
    }
    

    public void draw(GraphicsHandler graphicsHandler) {
        int screenWidth = 800;
        int screenHeight = 590;

        graphicsHandler.drawImage(winScreen, 0, 0, screenWidth, screenHeight);
    }
}
