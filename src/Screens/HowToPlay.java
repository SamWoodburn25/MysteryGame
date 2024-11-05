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
    protected SpriteFont Rule8label;
    protected SpriteFont Rule9label;
    protected SpriteFont Rule10label;
    protected SpriteFont Rule11label;
    protected SpriteFont EndOflabel;
    

    //constructor with a ScreenCoordinator parameter
    public HowToPlay(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
    //background = new TitleScreenMap();
    //background.setAdjustCamera(false);
    HowToPlaylabel = new SpriteFont("How To Play",50, 20, "Apple Chancery", 70, new Color(184, 15, 10));
    Rule1label = new SpriteFont("1-)Use arrow keys for moving in map to navigate.", 70, 120, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule2label = new SpriteFont("2-)Use space button for talking with NPC's(caracters).", 70, 160, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule3label = new SpriteFont("3-)If you want to know which house is locked or which house belongs to whom, ", 70, 200, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule4label = new SpriteFont("you can check by pressing the space key on the label (marker) in front of the house.", 70, 240, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule5label = new SpriteFont("4-)You can open the Journal by pressing the “j” button where it reminds you of ", 70, 280, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule6label = new SpriteFont("the rules again on the first page. ", 70, 320, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule7label = new SpriteFont("5-)The next pages of the Journal are filled with things you talk about with ", 70, 360, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule8label = new SpriteFont("6-)NPC's (characters). So you don't have to remember everything :)))) ", 70, 400, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule9label = new SpriteFont("7-)Hold down 'shift' to sprint and view the red bar in the top right corner to see how", 70, 440, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule10label = new SpriteFont("far you can run.", 70, 480, "Apple Chancery", 20, new Color(184, 15, 10));
    Rule11label = new SpriteFont("8-)If a pop-up appears, use 'esc' to close it ", 70, 520, "Apple Chancery", 20, new Color(184, 15, 10));
    EndOflabel = new SpriteFont("Press SPACE to return to menu...", 70, 550, "Apple Chancery", 20, new Color(184, 15, 10));
    
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
        Rule8label.draw(graphicsHandler);
        Rule9label.draw(graphicsHandler);
        Rule10label.draw(graphicsHandler);
        Rule11label.draw(graphicsHandler);
        EndOflabel.draw(graphicsHandler);
    }
}
