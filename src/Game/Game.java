package Game;

import Engine.BackgroundMusic;
import Engine.GameWindow;
import Engine.ScreenManager;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
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
        // Sounds BackRoundMusic = new Sounds();
        // BackRoundMusic.shoundBackRound();

        if (!musicInitialized) {
            backgroundMusic = new BackgroundMusic("Resources/GameSong.wav");
            musicInitialized = true;
        }

        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.play(); // Start playing the background music
        }
    }

}
