package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Engine.*;
import Level.FlagManager;
import Level.Map;

public class ButcherPuzzle extends Screen{
    protected BufferedImage scale, currMeat, meatCut1, meatCut2, meatCut3, meatCut4, meatCut5, meatCut6, meatCut7, meatCut8, meatCut9, meatCut10, meatCut11, meatCut12, meatCut13, meatCut14;
    protected BufferedImage instructions;
    protected List<MeatOption> meats, stackedMeats;
    protected float goalWeight, currWeight;
    protected String goalWeighString, currWeightString;
    protected int selectedIndex = 0;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean solved = false;
    protected boolean instructionsVisible = true;
    protected boolean add, remove =false;
    protected FlagManager flagManager;

    public ButcherPuzzle(FlagManager flagManager){
        new ImageLoader();
        this.flagManager = flagManager;
        scale = ImageLoader.load("scaleImage.png");
        instructions = ImageLoader.load("butcherPuzzleInstruc.png");
        stackedMeats = new ArrayList<>();
        meats = Arrays.asList(
            new MeatOption("meatCut1.png", 4),
            new MeatOption("meatCut2.png", 6),
            new MeatOption("meatCut3.png", 3),
            new MeatOption("meatCut4.png", 12),
            new MeatOption("meatCut5.png", 8),
            new MeatOption("meatCut6.png", 10),
            new MeatOption("meatCut7.png", 20),
            new MeatOption("meatCut8.png", 25),
            new MeatOption("meatCut9.png", 2),
            new MeatOption("meatCut10.png", 1),
            new MeatOption("meatCut11.png", 40),
            new MeatOption("meatCut12.png", 5)
        );
        goalWeight = (int)((Math.random()*100)+1);
        currWeight = 0;
        goalWeighString = "Goal Wieght = " + goalWeight;
        currWeightString = "Current Weight = " + currWeight;
    }

    @Override
    public void initialize() {}
    
    @Override
    public void update() {
        if(instructionsVisible){
            if (Keyboard.isKeyUp(Key.B) && !keyLocker.isKeyLocked(Key.B)) {
            keyLocker.lockKey(Key.B);
            } 
            else if(Keyboard.isKeyDown(Key.B)){
                instructionsVisible = false;
                keyLocker.unlockKey(Key.B);
            }
        }
        else {
            //move down the list
            if (Keyboard.isKeyUp(Key.RIGHT) && !keyLocker.isKeyLocked(Key.RIGHT)) {
                selectedIndex = Math.min(meats.size() - 1, selectedIndex + 1);
                keyLocker.lockKey(Key.RIGHT);
            } 
            else if(Keyboard.isKeyDown(Key.RIGHT)){
                keyLocker.unlockKey(Key.RIGHT);
            }
            //move up the list
            if(Keyboard.isKeyUp(Key.LEFT) && !keyLocker.isKeyLocked(Key.LEFT)) {
                selectedIndex = Math.max(0, selectedIndex - 1);
                keyLocker.lockKey(Key.LEFT);
            }
            else if (Keyboard.isKeyDown(Key.LEFT)) {
                keyLocker.unlockKey(Key.LEFT);
            }
            //add to scale
            if (Keyboard.isKeyUp(Key.ENTER) && !keyLocker.isKeyLocked(Key.ENTER)) {
                addMeatToScale(meats.get(selectedIndex));
                keyLocker.lockKey(Key.ENTER);
            }
            else if (Keyboard.isKeyDown(Key.ENTER)) {
                keyLocker.unlockKey(Key.ENTER);
            }
            //removing from scale
            if (Keyboard.isKeyUp(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
                removeMeatFromScale(meats.get(selectedIndex));
                keyLocker.lockKey(Key.SPACE);
            }
            else if (Keyboard.isKeyDown(Key.SPACE)) {
                keyLocker.unlockKey(Key.SPACE);
            }
            if(currWeight == goalWeight){
                solved = true;
                flagManager.setFlag("butcherPuzzleSolved");
            }
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(140,79,83));
        if(instructionsVisible){
            graphicsHandler.drawImage(instructions, 50, 0, 725, 600);
        }
        else{
            graphicsHandler.drawMeatString(currWeightString, 150, 520, null, Color.black);
            graphicsHandler.drawMeatString(goalWeighString, 150, 550, null, Color.black);
            graphicsHandler.drawImage(scale, 125, 250, 180, 200);
            int xValue = 500;
            int yValue = 0;
            //draw meats
            for(int i=0; i<meats.size(); i++){
                currMeat = meats.get(i).getImage();
                if(i>0 && i%2 == 0){
                    yValue+=100;
                    xValue = 600;
                }
                else{
                    xValue+=100;
                }
                if (i == selectedIndex) {
                    drawImageWithBorder(graphicsHandler, currMeat, xValue, yValue); // Highlight selected
                }
                graphicsHandler.drawImage(meats.get(i).getImage(), xValue, yValue, 62, 62);
                //System.out.println("drawing: " + meats.get(i) + "xvalue-" + xValue + "yvalue-" + yValue);
            }
            //draw meat stack
            int meatx = 200;
            int meaty = 230;
            for(int i = 0; i<stackedMeats.size(); i++){
                graphicsHandler.drawImage(stackedMeats.get(i).getImage(), meatx, meaty, 50, 50);
                meaty -= 55;
            }
        }
    }

    //draw the border around the selected image
    public void drawImageWithBorder(GraphicsHandler g, BufferedImage img, int x, int y){
        g.drawImage(img, x, y, 62, 62);
        g.drawRectangle(x, y, 63, 63, Color.black,10);
    }

    public void addMeatToScale(MeatOption meatOption){
        if(add){
            currWeight = currWeight + meatOption.getWeight();
            currWeightString = "Current Weight = " + currWeight;
            stackedMeats.add(meatOption);
        }
        add = true;
    }
    public void removeMeatFromScale(MeatOption meatOption){
        if(remove){
            if(stackedMeats.size()>0){
                currWeight = currWeight - meatOption.getWeight();
                currWeightString = "Current Weight = " + currWeight;
                stackedMeats.remove(stackedMeats.size()-1);
            }
            else{
                System.out.println("nothing to remove");
            }
        }
        remove = true;
    }
}


class MeatOption {
    BufferedImage image;
    float weight;

    public MeatOption(String imagePath, float weight) {
        this.image = ImageLoader.load(imagePath);
        this.weight = weight;
    }

    public BufferedImage getImage() {
        return image;
    }

    public float getWeight() {
        return weight;
    }
}