/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- ButcherShop: displays the meat shop map with the butcher
 */

package Maps;

import Level.*;
import NPCs.Butcher;
import Scripts.ButcherShopMap.*;
import Scripts.House1Map.ButcherScript;
import Tilesets.CommonTileset;
import Utils.Point;

import java.util.ArrayList;

public class ButcherShopMap extends Map {

    public ButcherShopMap() {
        super("butcher_shop.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(14, 10).getLocation();
    }

    //load in butcher NPC with script
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Butcher butcher = new Butcher(3, getMapTile(10, 3).getLocation().subtractX(20));
        butcher.setInteractScript(new ButcherScript());
        npcs.add(butcher);

        return npcs;
    }
 
    //load in triggers
     @Override
     public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();

         //trigger to enter town
        Point town = getPositionByTileIndex(4,5);
        triggers.add(new Trigger(town.x, town.y, 20,10, new ButcherToTownScript(), "ButcherToTown"));

        // pop up image trigger
        Point photoLoc = getPositionByTileIndex(7, 7);
        triggers.add(new Trigger(photoLoc.x, photoLoc.y, 1, 2, new PopUpButcherImageScript(), "popUpButcherImage"));

        return triggers;
    } 
}
