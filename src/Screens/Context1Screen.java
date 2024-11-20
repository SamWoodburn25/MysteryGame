/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- Context1Screen: Manages the second context screen, displaying background information and handling 
 * the transition from first context screen to level screen.
 */
 package Screens;

 import java.awt.Color;
 import java.awt.image.BufferedImage;
 
 import Engine.GraphicsHandler;
 import Engine.ImageLoader;
 import Engine.Key;
 import Engine.KeyLocker;
 import Engine.Keyboard;
 import Engine.Screen;
 import Engine.ScreenManager;
 import Game.GameState;
 import Game.ScreenCoordinator;
 import SpriteFont.SpriteFont;
 
 public class Context1Screen extends Screen {
     protected ScreenCoordinator screenCoordinator;
     protected ScreenManager screenManager;
     protected BufferedImage background;
     protected KeyLocker keyLocker = new KeyLocker();
     protected SpriteFont contextLabel6;
     protected SpriteFont contextLabel7;
     protected SpriteFont contextLabel8;
     protected SpriteFont contextLabel9;
     protected SpriteFont contextLabel10;
     protected SpriteFont contextLabel11;
     protected SpriteFont continueLabel;
     protected int screenWidth;
     protected int screenHeight;
 
 
     //constructor with a ScreenCoordinator parameter
     public Context1Screen(ScreenCoordinator screenCoordinator) {
         this.screenCoordinator = screenCoordinator;
         this.screenManager = new ScreenManager();
     }
     @Override
     public void initialize() {
         // setup graphics on screen (background map, spritefont text)
         background = ImageLoader.load("ContextScreen1.png");
         contextLabel6 = new SpriteFont("Your task is to talk to those that may be connected", 90, 100, "Apple Chancery", 30, new Color(184, 15, 10));
         contextLabel7 = new SpriteFont("to him and gain information and clues about what", 85, 187, "Apple Chancery", 30,  new Color(184, 15, 10));
         contextLabel8 = new SpriteFont("occurred leading up to his disappearance that can", 90, 275, "Apple Chancery", 30, new Color(184, 15, 10));
         contextLabel9 = new SpriteFont("explain what happened to your brother and give", 105, 363, "Apple Chancery", 30, new Color(184, 15, 10));
         contextLabel10 = new SpriteFont("your family the closure they need.", 200, 440, "Apple Chancery", 30,  new Color(184, 15, 10));
        //  contextLabel11 = new SpriteFont("and its the last token you have of your brother.", 75, 450, "Apple Chancery", 30, new Color(184, 15, 10));
         
         continueLabel = new SpriteFont("Press Space to Continue", 580, 530, "Apple Chancery", 15, new Color(255, 225, 225));
         keyLocker.lockKey(Key.SPACE);
     }
     
     //update, if the space key is pressed go back to main menu
     public void update() {
         if (Keyboard.isKeyUp(Key.SPACE)) {
             keyLocker.unlockKey(Key.SPACE);
         }
         if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
             screenCoordinator.setGameState(GameState.MISSINGPOSTER);
         }
     }
 
     //draw each element of the credit screen
     public void draw(GraphicsHandler graphicsHandler) {
         int screenWidth = 800;
         int screenHeight = 590;
         graphicsHandler.drawImage(background, 0, 0, screenWidth, screenHeight);
         contextLabel6.draw(graphicsHandler);
         contextLabel7.draw(graphicsHandler);
         contextLabel8.draw(graphicsHandler);
         contextLabel9.draw(graphicsHandler);
         contextLabel10.draw(graphicsHandler);
        //  contextLabel11.draw(graphicsHandler);
         continueLabel.draw(graphicsHandler);
     }
 }
 