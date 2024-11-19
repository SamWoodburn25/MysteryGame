/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- House1Map: displays the main living room map
 */

package Maps;

import EnhancedMapTiles.PushableRock;
import Level.*;
import NPCs.*;
import Scripts.SimpleTextScript;
import Scripts.House1Map.*;
import Tilesets.CommonTileset;
import Utils.Point;

import java.util.ArrayList;


public class House1Map extends Map {

    public House1Map() {
        super("house1_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 19).getLocation();
        System.out.println("Player starting at: " + playerStartPosition.x + ", " + playerStartPosition.y);
    }

    //load in NPCs
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        //add in mom with script
        Mom mom = new Mom(1, getMapTile(18, 18).getLocation().subtractY(40));
        mom.setInteractScript(new MomScript());
        npcs.add(mom);

        // ExGf ex = new ExGf(1, getMapTile(25, 17).getLocation().subtractY(40));
        // ex.setInteractScript(new BrotherExGFScript());
        // npcs.add(ex);

        // MHDaughter daughter = new MHDaughter(1, getMapTile(29, 16).getLocation().subtractY(40));
        // daughter.setInteractScript(new DrugDealerScript());
        // npcs.add(daughter);

        return npcs;
    }

    //load in triggers
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();

        // trigger to enter town from house
        Point townLoc = getPositionByTileIndex(17, 25);
        
        System.out.println("Trigger for transition set at: " + townLoc.x + ", " + townLoc.y);
        // Point tileLocation1 = getMapTile(6, 14).getLocation();
        // triggers.add(new Trigger(tileLocation1.x, tileLocation1.y, 100,20, new
        // ExitScript(), "exitInteract" ));

        //fridge pop up trigger
        Point photoLoc = getPositionByTileIndex(24, 15);
        triggers.add(new Trigger(photoLoc.x, photoLoc.y, 1, 1, new PopUpFridgeImageScript(), "popUpButcherImage"));

        
        triggers.add(new Trigger(townLoc.x, townLoc.y,200,10, new House1ToTownScript(), "house1ToTown" ));
        System.out.println("Trigger for transition set at: " + townLoc.x + ", " + townLoc.y);
        System.out.println("house1totownscript triggered");

        return triggers;
    }

    //load in scripts
    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(22, 18).setInteractScript(new SimpleTextScript("Mom's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}
