/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- CharacterSelectionScreen : users will be able to select which character they would like to be through the available choices

 */
package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CharacterSelectScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected ScreenManager screenManager;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected static int menuItemSelected = -1;
    protected SpriteFont getChar;
    protected SpriteFont char1;
    protected SpriteFont char2;
    protected BufferedImage background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int screenWidth;
    protected int screenHeight;
    protected int character;
    
        //constructor with ScreenCoordinator parameter
        public CharacterSelectScreen(ScreenCoordinator screenCoordinator) {
            this.screenCoordinator = screenCoordinator;
            this.screenManager = new ScreenManager();
        }
    
        //initialize character select screen elements
        @Override
        public void initialize() {
            getChar = new SpriteFont("Select Your Character's Hair Length", 200, 123, "Apple Chancery", 30, new Color(184, 15, 10));
            getChar.setOutlineColor(Color.black);
            getChar.setOutlineThickness(3);
    
            char1 = new SpriteFont("Long", 150, 323, "Apple Chancery", 30, new Color(184, 15, 10));
            char1.setOutlineColor(Color.black);
            char1.setOutlineThickness(3);
    
            char2 = new SpriteFont("Short", 450, 323, "Apple Chancery", 30, new Color(184, 15, 10));
            char2.setOutlineColor(Color.black);
            char2.setOutlineThickness(3);

            background = ImageLoader.load("ContextScreen0.png");
            keyPressTimer = 0;
            menuItemSelected = -1;
            keyLocker.lockKey(Key.SPACE);
        }
    
        //update
        public void update() {
            // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
            if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
                keyPressTimer = 14;
                currentMenuItemHovered++;
            } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
                keyPressTimer = 14;
                currentMenuItemHovered--;
            } else {
                if (keyPressTimer > 0) {
                    keyPressTimer--;
                }
            }
    
            // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
            if (currentMenuItemHovered > 1) {
                currentMenuItemHovered = 0;
            } else if (currentMenuItemHovered < 0) {
                currentMenuItemHovered = 1;
            }
    
            // Set pointer location and color based on the hovered item
            pointerLocationY = 330;
            if (currentMenuItemHovered == 0) {
                pointerLocationX = 170;
            } else if (currentMenuItemHovered == 1) {
                pointerLocationY = 470;
            } 
    
    
            // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
            if (currentMenuItemHovered == 0) {
                char1.setColor(new Color(184, 15, 10));
                char1.setColor(new Color(184, 15, 10));
                pointerLocationX = 170;
                pointerLocationY = 330;
            } else if (currentMenuItemHovered == 1) {
                char2.setColor(new Color(184, 15, 10));
                char2.setColor(new Color(184, 15, 10));
                pointerLocationX = 470;
                pointerLocationY = 330;
            }
    
            // if space is pressed on menu item, change to appropriate screen based on which item was chosen
            if (Keyboard.isKeyUp(Key.SPACE)) {
                keyLocker.unlockKey(Key.SPACE);
            }
            if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
                menuItemSelected = currentMenuItemHovered;
                if (menuItemSelected == 0) {
                    System.out.println("long");
                    screenCoordinator.setGameState(GameState.LEVEL);
                } else if (menuItemSelected == 1) {
                    System.out.println("short");
                    screenCoordinator.setGameState(GameState.LEVEL);
                }
            }
        }
    
        //draw each element of the char select screen
        public void draw(GraphicsHandler graphicsHandler) {
            int screenWidth = 800;
            int screenHeight = 590;
            graphicsHandler.drawImage(background, 0, 0, screenWidth, screenHeight);
    
            getChar.draw(graphicsHandler);
            char1.draw(graphicsHandler);
            char2.draw(graphicsHandler);
    
    
            graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(184, 15, 10), Color.black, 2);
        }
    
        //accesses player choice
        public static int getChoice(){
            return menuItemSelected;
        }

}
