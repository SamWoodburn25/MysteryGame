/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * package- Game
 * class- Game: The game starts here; This class just starts up a GameWindow and attaches 
 * the ScreenCoordinator to the ScreenManager instance in the GameWindow and attatches sound;
 * From this point on the ScreenCoordinator class will dictate what the game does
 */

package Game;

import Engine.BackgroundMusic;
import Engine.GameWindow;
import Engine.ScreenManager;


public class Game {
    BackgroundMusic backgroundMusic;
    boolean musicInitialized = false;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        GameWindow gameWindow = new GameWindow();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
        gameWindow.startGame();

        //add in music resource file
        if (!musicInitialized) {
            backgroundMusic = new BackgroundMusic("Resources/GameSong.wav");
            musicInitialized = true;
        }

        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.play(); // Start playing the background music
        }
    }

 }
  
 