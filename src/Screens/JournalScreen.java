package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;

import java.awt.*;
import java.awt.image.BufferedImage;


// This class is for the journal cover screen
public class JournalScreen extends Screen {
    protected BufferedImage journalCover;
    protected BufferedImage journalPage;
    protected boolean openPage;
    protected KeyLocker keyLocker = new KeyLocker();
    protected ScreenCoordinator screenCoordinator;
    protected GameState prevState;
    protected ScreenManager screenManager;

    public JournalScreen(ScreenCoordinator screenCoordinator, GameState prevState){
        this.screenCoordinator = screenCoordinator;
        this.screenManager = new ScreenManager();
        this.prevState = prevState;
        this.openPage = false;
    }

    @Override
    public void initialize() {
        journalCover = ImageLoader.load("journal.png");
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
			//isJournalOpen = !isJournalOpen;
			keyLocker.lockKey(Key.ESC);
			screenCoordinator.setGameState(this.prevState);
		}
		if (Keyboard.isKeyUp(Key.ESC)) {
			keyLocker.unlockKey(Key.ESC);
		}

        if (Keyboard.isKeyDown(Key.RIGHT) && !keyLocker.isKeyLocked(Key.RIGHT)) {
			//isJournalOpen = !isJournalOpen;
			keyLocker.lockKey(Key.RIGHT);
			turnPage();
		}
		if (Keyboard.isKeyUp(Key.RIGHT)) {
			keyLocker.unlockKey(Key.RIGHT);
		}
    }

    public void setPrevState(GameState prevState){
        this.prevState = prevState;
    }
    public GameState getPrevState(){
        return this.prevState;
    }

    public void turnPage(){
        System.out.println("turn page- to be implemented ");
        this.openPage = true;
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        graphicsHandler.drawImage(journalCover, 10, 10, 800, 550);
/* 
        if(openPage){
            graphicsHandler.drawImage(journalPage, 10, 10);
        }
        */
    }

}



