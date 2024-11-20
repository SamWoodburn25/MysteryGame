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
     private static BackgroundMusic backgroundMusic;
     private static boolean musicInitialized = false;
 
     public static void main(String[] args) {
         new Game();
     }
 
     public Game() {
         // Create the game window and setup screen manager
         GameWindow gameWindow = new GameWindow();
         ScreenManager screenManager = gameWindow.getScreenManager();
         screenManager.setCurrentScreen(new ScreenCoordinator());
 
         // Initialize background music
         if (!musicInitialized) {
             backgroundMusic = new BackgroundMusic("Resources/GameSong.wav");
             musicInitialized = true;
         }
 
         // Start the game
         gameWindow.startGame();
     }
 
     // Getter for background music
     public static BackgroundMusic getBackgroundMusic() {
         return backgroundMusic;
     }
 }