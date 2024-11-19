/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- GraveYardPuzzle: puzzle you need to solve in order to enter the graveyard, find clues around
 * the map to help you solve 
 */

package Screens;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

import Engine.*;
import Level.FlagManager;
import SpriteFont.SpriteFont;

public class GraveYardPuzzle extends Screen{
    protected SpriteFont header1, header2;
    protected BufferedImage code;
    protected InputNumberBox input;
    protected int selectedIndex = 0;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean solved = false;
    protected FlagManager flagManager;

    public GraveYardPuzzle(FlagManager flagManager){
        new ImageLoader();
        this.flagManager = flagManager;

        //instructions message
        header1 = new SpriteFont("This part of the map is locked.", 50, 50, "Apple Chancery", 30, Color.black);
        header1.setOutlineColor(Color.black);
        header1.setOutlineThickness(3);

        header2 = new SpriteFont("Find clues around the map to enter.", 50, 75, "Apple Chancery", 30, Color.black);
        header2.setOutlineColor(Color.black);
        header2.setOutlineThickness(3);

        code = ImageLoader.load("gravepuzzleCode.png");

        input = new InputNumberBox(200, 500, 200, 50);
    }

    @Override
    public void initialize() {}
    
    @Override
    public void update() {
        if(solved){
            flagManager.setFlag("unlockedCemetery");
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(32,61,44));
        header1.draw(graphicsHandler);
        header2.draw(graphicsHandler);
        graphicsHandler.drawImage(code, 25, 100, 550, 100);
        input.draw(graphicsHandler);
    
    }

    //draw the border around the selected image
    public void drawImageWithBorder(GraphicsHandler g, BufferedImage img, int x, int y){
        g.drawImage(img, x, y, 62, 62);
        g.drawRectangle(x, y, 63, 63, Color.black,10);
    }
}


//number box class
 class InputNumberBox {
        private StringBuilder inputText;
        private boolean isActive;
        private int x, y, width, height;
        private KeyLocker keyLocker = new KeyLocker();
        protected boolean key1Used, key2Used, key3Used, key4Used, key5Used, key6Used, key7Used, key8Used, key9Used, key0Used;

        public InputNumberBox(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.inputText = new StringBuilder();
            this.isActive = false;
        }

        public void update( ) {
            if (!isActive) return;

            //handling backspace
            if (Keyboard.isKeyUp(Key.BACKSPACE) && inputText.length() > 0 && !keyLocker.isKeyLocked(Key.BACKSPACE)) {
                inputText.deleteCharAt(inputText.length() - 1);
                keyLocker.lockKey(Key.BACKSPACE);
            }
            else if(Keyboard.isKeyDown(Key.BACKSPACE)){
                keyLocker.unlockKey(Key.BACKSPACE);
            }
            //handling character input
            /* key 1 */
            if (Keyboard.isKeyUp(Key.ONE) && !keyLocker.isKeyLocked(Key.ONE)) {
                if(key1Used){
                    inputText.append('1');
                }
                else{
                   key1Used = true;
                }
                keyLocker.lockKey(Key.ONE);
            }
            else if(Keyboard.isKeyDown(Key.ONE)){
                keyLocker.unlockKey(Key.ONE);
            }
            /* key 2 */
            if (Keyboard.isKeyUp(Key.TWO) && !keyLocker.isKeyLocked(Key.TWO)) {
                if(key2Used){
                    inputText.append('B');
                }
                else{
                    key2Used = true;
                }
                keyLocker.lockKey(Key.TWO);
            }
            else if(Keyboard.isKeyDown(Key.TWO)){
                keyLocker.unlockKey(Key.TWO);
            }
            /* key 3 */
            if (Keyboard.isKeyUp(Key.THREE) && !keyLocker.isKeyLocked(Key.THREE)) {
                if(key3Used){
                    inputText.append('3');
                }
                else{
                    key3Used = true;
                }
                keyLocker.lockKey(Key.THREE);
            }
            else if(Keyboard.isKeyDown(Key.THREE)){
                keyLocker.unlockKey(Key.THREE);
            }
            /* key 4 */
            if (Keyboard.isKeyUp(Key.FOUR) && !keyLocker.isKeyLocked(Key.FOUR)) {
                if(key4Used){
                    inputText.append('4');
                }
                else{
                    key4Used = true;
                }
                keyLocker.lockKey(Key.FOUR);
            }
            else if(Keyboard.isKeyDown(Key.FOUR)){
                keyLocker.unlockKey(Key.FOUR);
            }
            /* key 5 */
            if (Keyboard.isKeyUp(Key.FIVE) && !keyLocker.isKeyLocked(Key.FIVE)) {
                if(key5Used){
                    inputText.append('5');
                }
                else{
                    key5Used = true;
                }
                keyLocker.lockKey(Key.FIVE);
            }
            else if(Keyboard.isKeyDown(Key.FIVE)){
                keyLocker.unlockKey(Key.FIVE);
            }
            /* key 6 */
            if (Keyboard.isKeyUp(Key.SIX) && !keyLocker.isKeyLocked(Key.SIX)) {
                if(key6Used){
                    inputText.append('F');
                }
                else{
                    key6Used = true;
                }
                keyLocker.lockKey(Key.SIX);
            }
            else if(Keyboard.isKeyDown(Key.F)){
                keyLocker.unlockKey(Key.SIX);
            }
            /* key 7 */
            if (Keyboard.isKeyUp(Key.SEVEN) && !keyLocker.isKeyLocked(Key.SEVEN)) {
                if(key7Used){
                    inputText.append('G');
                }
                else{
                    key7Used = true;
                }
                keyLocker.lockKey(Key.SEVEN);
            }
            else if(Keyboard.isKeyDown(Key.SEVEN)){
                keyLocker.unlockKey(Key.SEVEN);
            }
            /* key 8 */
            if (Keyboard.isKeyUp(Key.EIGHT) && !keyLocker.isKeyLocked(Key.EIGHT)) {
                if(key8Used){
                    inputText.append('H');
                }
                else{
                    key8Used = true;
                }
                keyLocker.lockKey(Key.EIGHT);
            }
            else if(Keyboard.isKeyDown(Key.EIGHT)){
                keyLocker.unlockKey(Key.EIGHT);
            }
            /* key 9 */
            if (Keyboard.isKeyUp(Key.NINE) && !keyLocker.isKeyLocked(Key.NINE)) {
                if(key9Used){
                    inputText.append('I');
                }
                else{
                    key9Used = true;
                }
                keyLocker.lockKey(Key.NINE);
            }
            else if(Keyboard.isKeyDown(Key.NINE)){
                keyLocker.unlockKey(Key.NINE);
            }
            /* key 0 */
            if (Keyboard.isKeyUp(Key.ZERO) && !keyLocker.isKeyLocked(Key.ZERO)) {
                if(key0Used){
                    inputText.append('J');
                }
                else{
                    key0Used = true;
                }
                keyLocker.lockKey(Key.ZERO);
            }
            else if(Keyboard.isKeyDown(Key.ZERO)){
                keyLocker.unlockKey(Key.ZERO);
            }
            
        }

        public void draw(GraphicsHandler graphicsHandler) {
            graphicsHandler.drawFilledRectangle(x, y, width, height, Color.WHITE);
            graphicsHandler.drawMeatString(inputText.toString(), x + 5, y +30, null, Color.BLACK);
        }

        public void setActive(boolean isActive) {
            this.isActive = isActive;
        }

        public String getText() {
            return inputText.toString();
        }

        public void clear(){
            int size = inputText.toString().length();
            for(int i = size; i > 0; i--){
                inputText.deleteCharAt(inputText.length() - 1);
            }
        }
    }

