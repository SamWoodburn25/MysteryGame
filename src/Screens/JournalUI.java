/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Screens
 * class- JournalUI: Manages the journal UI in the game, handling page navigation, visibility toggles, 
 * and dynamic content updates based on gameplay flags (more pages added as game is played)
 */

package Screens;

import Engine.*;
import Level.FlagManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class JournalUI {
    protected LinkedList<BufferedImage> journalPages;
    //basic pages
    protected BufferedImage journalCover, emptyJournal, journalPageIntro;
    //specific journal pages- journalPage_whatItIsAbout
    protected BufferedImage journalPage_Max1, journalPage_Max2, journalPage_Peter1, journalPage_Peter2, journalPage_Exgf1, journalPage_Exgf2, journalPage_Boss1, journalPage_Boss2, journalPage_Boss3, journalPage_MH1, journalPage_MH2, journalPage_MH3;
    protected BufferedImage journalPage_Paycheck, journalPage_party1, journalPage_party2, journalPage_party3, journalPage_Medullis1, journalPage_Medullis2, journalPage_Medullis3, journalPage_Poem;
    protected BufferedImage currPagePic;
    protected FlagManager flagManager;
    protected int currPage;
    protected boolean journalIsVisible = false;
    protected boolean bookOpen = false;
    protected KeyLocker keyLocker = new KeyLocker();

    //constructor with FlagManager parameter
    public JournalUI(FlagManager flagManager) {
        this.flagManager = flagManager;
        /*  Load journal images */
        //intial pages
        journalCover = ImageLoader.load("JournalCover.png");
        emptyJournal = ImageLoader.load("EmptyJournal.png");
        journalPageIntro = ImageLoader.load("JPageIntro.png");
        //about max
        journalPage_Max1 = ImageLoader.load("jPage_max_1.png");
        journalPage_Max2 = ImageLoader.load("jPage_max_2.png");
        //about peter
        journalPage_Peter1 = ImageLoader.load("jPage_Peter_1.png");
        journalPage_Peter2 = ImageLoader.load("jPage_Peter_2.png");
        //about gf
        journalPage_Exgf1 = ImageLoader.load("jPage_exgf_1.png");
        journalPage_Exgf2 = ImageLoader.load("jPage_exgf_2.png");
        //about boss
        journalPage_Boss1 = ImageLoader.load("jpage_boss_1.png");
        journalPage_Boss2 = ImageLoader.load("jpage_boss_2.png");
        journalPage_Boss3 = ImageLoader.load("jpage_boss_3.png");
        //about mad hatter
        journalPage_MH1 = ImageLoader.load("jpage_MHBar_1.png");
        journalPage_MH2 = ImageLoader.load("jpage_MHBar_2.png");
        journalPage_MH3 = ImageLoader.load("jpage_MHBar_3.png");
        //paycheck
        journalPage_Paycheck = ImageLoader.load("jpage_paycheck.png");
        //about partying
        journalPage_party1 = ImageLoader.load("jpage_party_1.png");
        journalPage_party2 = ImageLoader.load("jpage_party_2.png");
        journalPage_party3 = ImageLoader.load("jpage_party_3.png");
        //about medullis
        journalPage_Medullis1 = ImageLoader.load("jpage_medullis_1.png");
        journalPage_Medullis2 = ImageLoader.load("jpage_medullis_2.png");
        journalPage_Medullis3 = ImageLoader.load("jpage_medullis_3.png");
        //poem
        journalPage_Poem = ImageLoader.load("jpage_poem.png");
        
        
        //add first images to list and an empty
        journalPages = new LinkedList<BufferedImage>();
        journalPages.add(journalCover);
        journalPages.add(journalPageIntro);
        journalPages.add(emptyJournal);
        //set the current page to the journal cover
        currPage = 0;
    }

    public void setFlagManager(FlagManager flagManager){
        this.flagManager = flagManager;
    }

    //is the journal screen visible
    public void toggleVisibility() {
        journalIsVisible = !journalIsVisible;
        bookOpen = false; // Reset to cover when toggled
    }

    public void setCurrPage(int currPage){
        this.currPage = currPage;
    }
    public int getCurrPage(){
        return this.currPage;
    }

    //update
    public void update() {
        /* adding pages */
        //if the player has talked to mom, add that page
        if (journalIsVisible && flagManager.isFlagSet("hasTalkedToMom")) {
            // check if the page from mom is not already added to avoid adding it multiple times
            if (!journalPages.contains(journalPage_Max1)) {
                //remove blank page, add page from max, add blank page back
                journalPages.removeLast();
                journalPages.add(journalPage_Max1);
                journalPages.add(journalPage_Max2);
                journalPages.add(emptyJournal);
            }
            //check for talking to max about peter
            if (journalIsVisible && flagManager.isFlagSet("hasTalkedToMax") && flagManager.isFlagSet("max_aboutPeter")) {
                //check if added, if not add butcher page 
                if(!journalPages.contains(journalPage_Peter1)){
                    journalPages.removeLast();
                    journalPages.add(journalPage_Peter1);
                    journalPages.add(journalPage_Peter2);
                    journalPages.add(emptyJournal);
                }
            }   
            //check for talking to max about ex
            if (journalIsVisible && flagManager.isFlagSet("hasTalkedToMax") && flagManager.isFlagSet("max_aboutEx")) {
                //check if added, if not add ex gf page
                if(!journalPages.contains(journalPage_Exgf1)){
                    journalPages.removeLast();
                    journalPages.add(journalPage_Exgf1);
                    journalPages.add(journalPage_Exgf2);
                    journalPages.add(emptyJournal);
                }
            }  
            //check for talking to camilla
            if (journalIsVisible && flagManager.isFlagSet("hasTalkedToGF")) {
                //check if added, if not add boss (damien) page 
                if(!journalPages.contains(journalPage_Boss1)){
                    journalPages.removeLast();
                    journalPages.add(journalPage_Boss1);
                    journalPages.add(journalPage_Boss2);
                    journalPages.add(journalPage_Boss3);
                    journalPages.add(emptyJournal);
                }
                //check if player helped her solve her puzzle, if yes add mad hatter pages
                if (flagManager.isFlagSet("exGfPuzzleSolved")) {
                    if(!journalPages.contains(journalPage_MH1)){
                        journalPages.removeLast();
                        journalPages.add(journalPage_MH1);
                        journalPages.add(journalPage_MH2);
                        journalPages.add(journalPage_MH3);
                        journalPages.add(emptyJournal);
                    }
                }
            } 
            //check for talking to the boss damien
            if (journalIsVisible && flagManager.isFlagSet("hasTalkedToDamien")) {
                //check if added, if not add partying page 
                if(!journalPages.contains(journalPage_party1) && !journalPages.contains(journalPage_Paycheck)){
                    journalPages.removeLast();
                    journalPages.add(journalPage_party1);
                    journalPages.add(journalPage_party2);
                    journalPages.add(journalPage_party3);
                    journalPages.add(journalPage_Paycheck);
                    journalPages.add(emptyJournal);
                }
            }
            //check for helping the mad hatters daughter
            if (journalIsVisible && flagManager.isFlagSet("hasTalkedToDrugDealerDaughter") && !flagManager.isFlagSet("badDD")) {
                //check if added, if not add medullis page 
                if(!journalPages.contains(journalPage_Medullis1)){
                    journalPages.removeLast();
                    journalPages.add(journalPage_Medullis1);
                    journalPages.add(journalPage_Medullis2);
                    journalPages.add(journalPage_Medullis3);
                    journalPages.add(emptyJournal);
                }
            }
            //check for helping the butcher
            if (journalIsVisible && flagManager.isFlagSet("butcherPuzzleSolved")) {
                //check if added, if not add poetry page 
                if(!journalPages.contains(journalPage_Poem)){
                    journalPages.removeLast();
                    journalPages.add(journalPage_Poem);
                    journalPages.add(emptyJournal);
                }
            }
        }//closing talking to mom if loop, must talk to mom before accessing any page


        /* page turning */
        //if right arrow key is clicked, increase current page count, move to next page if available in list
        if (Keyboard.isKeyUp(Key.RIGHT) && !keyLocker.isKeyLocked(Key.RIGHT)) {
            bookOpen = true;
            if (bookOpen && currPage < journalPages.size() - 1) {
                currPage++;
                currPagePic = journalPages.get(currPage);
                //lock the key until it is pressed again
                keyLocker.lockKey(Key.RIGHT);  
            }
        }
        if (Keyboard.isKeyDown(Key.RIGHT)) {
            //unlock when key is pressed down again
            keyLocker.unlockKey(Key.RIGHT);  
        }
        // Lock the right key if it's the last page
        if (currPage == journalPages.size() - 1) {
            keyLocker.lockKey(Key.RIGHT);  
        }

        //if left arrow key is clicked, decrease current page count, move to previous page if not already at page 0
        if (Keyboard.isKeyUp(Key.LEFT) && !keyLocker.isKeyLocked(Key.LEFT)) {
            if (bookOpen && currPage > 0) {
                currPage--;
                currPagePic = journalPages.get(currPage);
                // Lock the key until it is pressed again
                keyLocker.lockKey(Key.LEFT);  
            }
        }
        if (Keyboard.isKeyDown(Key.LEFT)) {
            // Unlock when key is pressed down again
            keyLocker.unlockKey(Key.LEFT);  
        }
    }


    //draw
    public void draw(GraphicsHandler graphicsHandler) {
        //draw while the journal is visible/ is open
        if (journalIsVisible) {
            graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
            //if the book was opened draw the current page, if not draw the cover
            if (bookOpen) {
                graphicsHandler.drawImage(currPagePic, 0, 0, 700, 600);
            }
            else{
                graphicsHandler.drawImage(journalCover, 20, 20, 700, 550);
            }
        }
    }

}



