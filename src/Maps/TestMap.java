package Maps;

import EnhancedMapTiles.PushableRock;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.*;
//import NPCs.Bug;
import NPCs.Butcher;
//import NPCs.Dinosaur;
import NPCs.ExGf;
import NPCs.MHDaughter;
import NPCs.Mom;
//import NPCs.Walrus;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import Utils.Point;

import java.util.ArrayList;

import Engine.ImageLoader;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        enhancedMapTiles.add(pushableRock);


        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        

        Mom mom = new Mom(1, getMapTile(10, 20).getLocation().subtractY(40));
        mom.setInteractScript(new MomScript());
        npcs.add(mom);

        ExGf ex = new ExGf(1, getMapTile(5, 20).getLocation().subtractY(40));
        //ex.setInteractScript(new ExGfScript());
        npcs.add(ex);

        MHDaughter daughter = new MHDaughter(1, getMapTile(4, 28).getLocation().subtractY(40));
        npcs.add(daughter);

        Butcher butcher = new Butcher(3, getMapTile(7, 12).getLocation().subtractX(20));
        npcs.add(butcher);

        // Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        // walrus.setInteractScript(new WalrusScript());
        // npcs.add(walrus);

        // Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        // dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        // dinosaur.setInteractScript(new DinoScript());
        // npcs.add(dinosaur);
        
        // Bug bug = new Bug(3, getMapTile(7, 12).getLocation().subtractX(20));
        // bug.setInteractScript(new BugScript());
        // npcs.add(bug);

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        Point tileLocation1 = getMapTile(1, 21).getLocation();
        /*triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));*/
        triggers.add(new Trigger(tileLocation1.x, tileLocation1.y, 10,160, new ExitScript(), "exitInteract" ));
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}

