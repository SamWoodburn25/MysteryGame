/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- TownMap: displays the outdoor town map
 */

package Maps;

import Level.*;
import Scripts.SimpleTextScript;
import Scripts.House1Map.TreeScript;
import Scripts.TownMap.*;
import Tilesets.TownTileset;
import Utils.Point;
import java.util.ArrayList;
import NPCs.Max;

public class TownMap1 extends Map {
    public TownMap1() {
        super("town_map.txt", new TownTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Max max = new Max(1, getMapTile(28, 5).getLocation().subtractY(0));
        max.setInteractScript(new ExBestFriendScript());
        npcs.add(max);

        return npcs;
    }


    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();

        Point house1 = getPositionByTileIndex(3, 21);
        // Point tileLocation1 = getMapTile(16, 19).getLocation();
        // entering main home
        // triggers.add(new Trigger(tileLocation1.x, tileLocation1.y, 60,60, new
        // EnterHomeScript(), "enteringHome"));
        triggers.add(new Trigger(house1.x, house1.y, 95, 10, new TownToHouse1Script(), "townToHouse1"));


        // trigger to enter butcher
        Point butcherShop = getPositionByTileIndex(17, 56);
        triggers.add(new Trigger(butcherShop.x, butcherShop.y, 20, 10, new TownToButcherScrpt(), "townToButcher"));

        return triggers;
    }

    @Override
    public void loadScripts() {

        getMapTile(6, 23).setInteractScript(new SimpleTextScript("Your house"));

        getMapTile(15, 57).setInteractScript(new SimpleTextScript("Peter's Butcher Shop"));

        getMapTile(24, 10).setInteractScript(new SimpleTextScript("Max's house - locked"));

        getMapTile(42, 28).setInteractScript(new SimpleTextScript("?? house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }

}
