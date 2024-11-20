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
import Scripts.LockedAreaScript;
import Scripts.SimpleTextScript;
import Scripts.House1Map.*;
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

         Investigator investigator = new Investigator(1, getMapTile(30, 50).getLocation().subtractY(40));
         investigator.setInteractScript(new InvestigatorScript());
         npcs.add(investigator);

         Boss boss = new Boss(1, getMapTile(26, 52).getLocation().subtractY(40));
         boss.setInteractScript(new DamienScript());
         npcs.add(boss);

         Crow crow1 = new Crow(1, getMapTile(36, 50).getLocation().subtractY(40));
         npcs.add(crow1);

         ExGf ex = new ExGf(1, getMapTile(33, 37).getLocation().subtractY(40));
         ex.setInteractScript(new BrotherExGFScript());
         npcs.add(ex); 

         MHDaughter daughter = new MHDaughter(1, getMapTile(33, 40).getLocation().subtractY(40));
         daughter.setInteractScript(new DrugDealerDaughterScript());
         npcs.add(daughter);

 
         return npcs;
     }
 
 
     @Override
     public ArrayList<Trigger> loadTriggers() {
         ArrayList<Trigger> triggers = new ArrayList<>();
 
         //trigger to enter the main character's house
         Point house1 = getPositionByTileIndex(21, 13);
         triggers.add(new Trigger(house1.x, house1.y, 95, 10, new TownToHouse1Script(), "townToHouse1"));
 
 
         // trigger to enter butcher
         Point butcherShop = getPositionByTileIndex(69, 46);
         triggers.add(new Trigger(butcherShop.x, butcherShop.y, 20, 10, new TownToButcherScript(), "townToButcher"));

         //trigger to enter cemetery
         //Point cemetery = getPositionByTileIndex(96, 20);
         //triggers.add(new Trigger(cemetery.x+20 , cemetery.y, 10, 100, new TownToCemeteryScript(), "townToCemetery"));
 
 
         //Point lockedCemetery = getPositionByTileIndex(96, 18);
         //triggers.add(new Trigger(lockedCemetery.x , lockedCemetery.y, 1, 2, new LockedAreaScript(), "lockedCemetery"));
 

        Point lockedCemetery = getPositionByTileIndex(96, 19);
        //triggers.add(new Trigger(lockedCemetery.x , lockedCemetery.y, 1, 2, new LockedAreaScript(), "lockedCemetery"));
        triggers.add(new Trigger(lockedCemetery.x , lockedCemetery.y, 10, 10, new TownToCemeteryScript(), "townToCemetery"));
 



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
 