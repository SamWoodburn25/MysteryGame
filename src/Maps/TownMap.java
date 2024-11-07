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
import Scripts.House1Map.BrotherExGFScript;
import Scripts.House1Map.TreeScript;
 import Scripts.TownMap.*;
 import Tilesets.TownTileset;
 import Utils.Point;
 import java.util.ArrayList;
 import NPCs.*;
 
 public class TownMap extends Map {
     public TownMap() {
         super("town_map1.txt", new TownTileset());
         this.playerStartPosition = getMapTile(17, 20).getLocation();
     }
 
     @Override
     public ArrayList<NPC> loadNPCs() {
         ArrayList<NPC> npcs = new ArrayList<>();
 
         Max max = new Max(1, getMapTile(40, 8).getLocation().subtractY(0));
         max.setInteractScript(new ExBestFriendScript());
         npcs.add(max);

         ExGf ex = new ExGf(1, getMapTile(36, 55).getLocation().subtractY(40));
        ex.setInteractScript(new BrotherExGFScript());
        npcs.add(ex);
 
         return npcs;
     }
 
 
     @Override
     public ArrayList<Trigger> loadTriggers() {
         ArrayList<Trigger> triggers = new ArrayList<>();
 
         Point house1 = getPositionByTileIndex(21, 13);
         // Point tileLocation1 = getMapTile(16, 19).getLocation();
         // entering main home
         // triggers.add(new Trigger(tileLocation1.x, tileLocation1.y, 60,60, new
         // EnterHomeScript(), "enteringHome"));
         triggers.add(new Trigger(house1.x, house1.y, 95, 10, new TownToHouse1Script(), "townToHouse1"));
 
 
         // trigger to enter butcher
         Point butcherShop = getPositionByTileIndex(69, 46);
         triggers.add(new Trigger(butcherShop.x, butcherShop.y, 20, 10, new TownToButcherScrpt(), "townToButcher"));
 
        // pop up image trigger
        Point photoLoc = getPositionByTileIndex(68, 13);
        triggers.add(new Trigger(photoLoc.x, photoLoc.y, 100, 5, new PopUpGraveyardImageScript(), "graveyardImage"));

         return triggers;
     }
 
     @Override
     public void loadScripts() {
 
         getMapTile(24, 13).setInteractScript(new SimpleTextScript("Your house"));
 
         getMapTile(73, 44).setInteractScript(new SimpleTextScript("Peter's Butcher Shop"));
 
         getMapTile(36, 18).setInteractScript(new SimpleTextScript("Max's house"));
 
         getMapTile(52, 44).setInteractScript(new SimpleTextScript("Town Hall"));
 
         getMapTile(2, 6).setInteractScript(new TreeScript());
     }
 
 }
 