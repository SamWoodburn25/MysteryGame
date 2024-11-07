/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- CreditScreen: Manages the credits screen, displaying credits information and handling 
 * the transition back to the main menu upon user input
 */

package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont alteredByLabel;
    protected SpriteFont secondAlteredByLabel;
    protected SpriteFont returnInstructionsLabel;

    //constructor with a ScreenCoordinator parameter
    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 15, 7, "Apple Chancery", 30, new Color(184, 15, 10));
        createdByLabel = new SpriteFont("Created by Alex Thimineur", 100, 91, "Apple Chancery", 20, new Color(184, 15, 10));
        alteredByLabel = new SpriteFont("Altered by Morgan Montz, Ella Berry, Adelina Chocho,", 100, 130, "Apple Chancery", 20, new Color(184, 15, 10));
        secondAlteredByLabel = new SpriteFont("                    Sam Woodburn, and Tuana Turhan", 100, 160, "Apple Chancery", 20, new Color(184, 15, 10));
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 532, "Apple Chancery", 30,  new Color(184, 15, 10));
        keyLocker.lockKey(Key.SPACE);
    }

    //update, if the space key is pressed go back to main menu
    public void update() {
        background.update(null);
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    //draw each element of the credit screen
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        alteredByLabel.draw(graphicsHandler);
        secondAlteredByLabel.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
