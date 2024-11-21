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

public class HowToPlay extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont HowToPlaylabel;
    protected SpriteFont Rule1label;
    protected SpriteFont Rule2label;
    protected SpriteFont Rule3label;
    protected SpriteFont Rule4label;
    protected SpriteFont Rule5label;
    protected SpriteFont Rule6label;
    protected SpriteFont Rule7label;
    protected SpriteFont Returnlabel;
    

    //constructor with a ScreenCoordinator parameter
    public HowToPlay(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
    //background = new TitleScreenMap();
    //background.setAdjustCamera(false);
    HowToPlaylabel = new SpriteFont("How To Play",15, 7, "Apple Chancery", 30, new Color(184, 15, 10));
    Rule1label = new SpriteFont("1) TO MOVE: Use the arrow keys.", 75, 93, "Apple Chancery", 25, new Color(184, 15, 10));
    Rule2label = new SpriteFont("2) TO TALK: Use the space key to talk to other characters.", 75, 150, "Apple Chancery", 25, new Color(184, 15, 10));
    Rule3label = new SpriteFont("3) TO CHECK SIGNS: Use 'space' key when in contact with sign.", 75, 207, "Apple Chancery", 25, new Color(184, 15, 10));
    Rule4label = new SpriteFont("4) TO OPEN JOURNAL: Use the 'j' key to open/close journal.", 75, 264, "Apple Chancery", 25, new Color(184, 15, 10));
    Rule5label = new SpriteFont("5) TO FLIP JOURNAL PAGES: Use the arrow keys.", 75, 321, "Apple Chancery", 25, new Color(184, 15, 10));
    Rule6label = new SpriteFont("7) TO SPRINT: Hold down 'shift' key.", 75, 378, "Apple Chancery", 25, new Color(184, 15, 10));
    Rule7label = new SpriteFont("8) TO ESCAPE POP-UPs: Use 'esc' key.", 75, 435, "Apple Chancery", 25, new Color(184, 15, 10));
    Returnlabel = new SpriteFont("Press SPACE to return to the menu", 20, 532, "Apple Chancery", 25, new Color(255, 255, 255));
    
    keyLocker.lockKey(Key.SPACE);
}
    

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, 800, 600, Color.BLACK); 

       
        HowToPlaylabel.draw(graphicsHandler);
        Rule1label.draw(graphicsHandler);
        Rule2label.draw(graphicsHandler);
        Rule3label.draw(graphicsHandler);
        Rule4label.draw(graphicsHandler);
        Rule5label.draw(graphicsHandler);
        Rule6label.draw(graphicsHandler);
        Rule7label.draw(graphicsHandler);
        Returnlabel.draw(graphicsHandler);
    }
}
