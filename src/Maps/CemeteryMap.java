/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- TownMap: displays the outdoor town map
 */

package Maps;

import java.util.ArrayList;

import Level.*;
import Scripts.CemeteryMap.CemeteryToTownScript;
import Tilesets.TownTileset;
import Utils.Point;


public class CemeteryMap extends Map {
    public CemeteryMap() {
        super("cemetery_map.txt", new TownTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    /*@Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Max max = new Max(1, getMapTile(28, 5).getLocation().subtractY(0));
        max.setInteractScript(new ExBestFriendScript());
        npcs.add(max);

        return npcs;
    }*/


    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();

        Point toTown = getPositionByTileIndex(0,24);
        triggers.add(new Trigger(toTown.x + 10, toTown.y, 10,100, new CemeteryToTownScript(), "ButcherToTown"));
    
        return triggers;
    }

   /*  @Override
    public void loadScripts() {

        getMapTile(6, 23).setInteractScript(new SimpleTextScript("Your house"));

        getMapTile(15, 57).setInteractScript(new SimpleTextScript("Peter's Butcher Shop"));

        getMapTile(24, 10).setInteractScript(new SimpleTextScript("Max's house - locked"));

        getMapTile(42, 28).setInteractScript(new SimpleTextScript("?? house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }*/

}
