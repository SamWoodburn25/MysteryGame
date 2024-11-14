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

public class GraveYardPuzzle extends Screen{
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

    public GraveYardPuzzle(FlagManager flagManager){
        new ImageLoader();
        this.flagManager = flagManager;
    }

    @Override
    public void initialize() {}
    
    @Override
    public void update() {
        
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(140,79,83));
    }

    //draw the border around the selected image
    public void drawImageWithBorder(GraphicsHandler g, BufferedImage img, int x, int y){
        g.drawImage(img, x, y, 62, 62);
        g.drawRectangle(x, y, 63, 63, Color.black,10);
    }
}

