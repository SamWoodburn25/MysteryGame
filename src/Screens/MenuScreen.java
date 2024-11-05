/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- MenuScreen: Manages the main menu screen, handling menu navigation, item selection, 
 * and transitions to other game states based on user input

 */
package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected ScreenManager screenManager;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont playGame;
    protected SpriteFont credits;
    protected SpriteFont howToPlay;
    protected BufferedImage background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int screenWidth;
    protected int screenHeight;

    //constructor with ScreenCoordinator parameter
    public MenuScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        this.screenManager = new ScreenManager();
    }

    //initialize main menu screen elements
    @Override
    public void initialize() {
        playGame = new SpriteFont("PLAY GAME", 200, 123, "Apple Chancery", 30, new Color(184, 15, 10));
        playGame.setOutlineColor(Color.black);
        playGame.setOutlineThickness(3);
        credits = new SpriteFont("CREDITS", 200, 223, "Apple Chancery", 30, new Color(184, 15, 10));
        credits.setOutlineColor(Color.black);
        credits.setOutlineThickness(3);
        howToPlay = new SpriteFont("HOW TO PLAY", 200, 323, "Apple Chancery", 30, new Color(184, 15, 10));
        howToPlay.setOutlineColor(Color.black);
        howToPlay.setOutlineThickness(3);
        background = ImageLoader.load("TitleScreen.png");
        keyPressTimer = 0;
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    //update
    public void update() {
        // update background map (to play tile animations)
        //background.update(null);

        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentMenuItemHovered > 2) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 2;
        }

        // Set pointer location and color based on the hovered item
        pointerLocationX = 170;
        if (currentMenuItemHovered == 0) {
            pointerLocationY = 130;
        } else if (currentMenuItemHovered == 1) {
            pointerLocationY = 230;
        } else if (currentMenuItemHovered == 2) {
            pointerLocationY = 330;
        }


        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        if (currentMenuItemHovered == 0) {
            playGame.setColor(new Color(184, 15, 10));
            credits.setColor(new Color(184, 15, 10));
            pointerLocationX = 170;
            pointerLocationY = 130;
        } else if (currentMenuItemHovered == 1) {
            playGame.setColor(new Color(184, 15, 10));
            credits.setColor(new Color(184, 15, 10));
            pointerLocationX = 170;
            pointerLocationY = 230;
        }else if (currentMenuItemHovered == 2) {
            playGame.setColor(new Color(184, 15, 10));
            credits.setColor(new Color(184, 15, 10));
            pointerLocationX = 170;
            pointerLocationY = 330;
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.CONTEXT0);
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.CREDITS);
            }else if (menuItemSelected == 2) {
                screenCoordinator.setGameState(GameState.HOWTOPLAY);
            }
        }
    }

    //draw each element of the main menu
    public void draw(GraphicsHandler graphicsHandler) {
        int screenWidth = 800;
        int screenHeight = 590;
        graphicsHandler.drawImage(background, 0, 0, screenWidth, screenHeight);

        playGame.draw(graphicsHandler);
        credits.draw(graphicsHandler);
        howToPlay.draw(graphicsHandler);


        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(184, 15, 10), Color.black, 2);
    }
}
