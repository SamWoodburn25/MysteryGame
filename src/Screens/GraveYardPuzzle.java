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
import java.util.Arrays;
import java.util.List;

import Engine.*;
import Level.FlagManager;
import SpriteFont.SpriteFont;

public class GraveYardPuzzle extends Screen{
    protected SpriteFont header1, header2;
    protected BufferedImage code, exitSign;
    protected InputNumberBox input1, input2, input3, input4, currInput;
    protected List<InputNumberBox> inputBoxes;
    protected int selectedIndex = 0;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean solved = false;
    protected boolean firstCorrect, secondCorrect, thirdCorrect, fourthCorrect = false;
    protected FlagManager flagManager;
    protected ImageLoader imageLoader = new ImageLoader();

    public GraveYardPuzzle(FlagManager flagManager){
        this.flagManager = flagManager;
        keyLocker.unlockKey(Key.ESC);

        //instructions message
        header1 = new SpriteFont("This part of the map is locked.", 140, 50, "Apple Chancery", 40, Color.black);
        header1.setOutlineColor(Color.black);
        header1.setOutlineThickness(5);

        header2 = new SpriteFont("Find clues around the map to enter.", 120, 110, "Apple Chancery", 40, Color.black);
        header2.setOutlineColor(Color.black);
        header2.setOutlineThickness(5);

        code = imageLoader.load("gravepuzzleCode.png");
        exitSign = imageLoader.load("exitPuzzle.png");

        input1 = new InputNumberBox(210, 400, 50, 60);
        input2 = new InputNumberBox(330, 400, 50, 60);
        input3 = new InputNumberBox(450, 400, 50, 60);
        input4 = new InputNumberBox(570, 400, 50, 60);

        inputBoxes = Arrays.asList(input1, input2, input3, input4);
    }

    @Override
    public void initialize() {}
    
    @Override
    public void update() {
        //if all boxes are full check if they're right and delete the incorrect (code = 2837)
        if(!input1.getText().equals("") && !input2.getText().equals("") && !input3.getText().equals("") && !input4.getText().equals("")){
            //input1
            if(input1.getText().equals("2")){
                firstCorrect = true;
            }
            else{ input1.clear(); }
            //input2
            if(input2.getText().equals("8")){
                secondCorrect = true;
            }
            else{ input2.clear(); }
            //input3
            if(input3.getText().equals("3")){
                thirdCorrect = true;
            }
            else{ input3.clear(); }
            //input4
            if(input4.getText().equals("7")){
                fourthCorrect = true;
            }
            else{ input4.clear(); }

            //check if all are correct
            if(firstCorrect && secondCorrect && thirdCorrect && fourthCorrect){
                flagManager.setFlag("graveyardPuzzleSolved");
            }
            else{
                selectedIndex = 0;
            }
        }



        //move right after a number is entered the list
        if (!input1.getText().equals("")) { 
            selectedIndex = 1;
            if (!input2.getText().equals("")) { 
                selectedIndex = 2; 
                if (!input3.getText().equals("")) { 
                    selectedIndex = 3; 
                } 
                else { selectedIndex = 2; }
            } 
            else { selectedIndex = 1; }
         } 
        else { selectedIndex = 0; }


        //setting which input is active
        if(selectedIndex == 0){
            input1.setActive(true);
            input1.update();
            input2.setActive(false);
            input3.setActive(false);
            input4.setActive(false);
        }
        else if(selectedIndex == 1){
            input2.setActive(true);
            input2.update();
            input1.setActive(false);
            input3.setActive(false);
            input4.setActive(false);
        }
        else if(selectedIndex == 2){
            input3.setActive(true);
            input3.update();
            input1.setActive(false);
            input2.setActive(false);
            input4.setActive(false);
        }
        else if(selectedIndex == 3){
            input4.setActive(true);
            input4.update();
            input1.setActive(false);
            input2.setActive(false);
            input3.setActive(false);
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        //background
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(32,61,44));
        //headers (instructions)
        header1.draw(graphicsHandler);
        header2.draw(graphicsHandler);
        //exit and secret code
        graphicsHandler.drawImage(code, 75, 160, 675, 275);
        graphicsHandler.drawImage(exitSign, 5, 5, 125, 45);
        //draw input boxes
        input1.draw(graphicsHandler);
        input2.draw(graphicsHandler);
        input3.draw(graphicsHandler);
        input4.draw(graphicsHandler);
        //draw selected box
        int xValue = 210;
        int yValue = 400;
        for(int i=0; i<inputBoxes.size(); i++){
            currInput = inputBoxes.get(i);
            if (i == selectedIndex) {
                drawInputBoxWithBorder(graphicsHandler, currInput, xValue, yValue); // Highlight selected
            }
            xValue+=120;
        }
    }

    //draw the border around the selected image
    public void drawInputBoxWithBorder(GraphicsHandler g, InputNumberBox inp, int x, int y){
        inp.draw(g);
        g.drawRectangle(x, y, 50, 60, Color.white,5);
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
                    inputText.append('2');
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
                    inputText.append('6');
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
                    inputText.append('7');
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
                    inputText.append('8');
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
                    inputText.append('9');
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
                    inputText.append('0');
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
            graphicsHandler.drawFilledRectangle(x, y, width, height, new Color(120, 161, 137));
            graphicsHandler.drawMeatString(inputText.toString(), x + 15, y +40, null, Color.BLACK);
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

