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
import Scripts.TownMap.*;
 import Scripts.House1Map.*;
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
 
         Max max = new Max(1, getMapTile(34, 8).getLocation().subtractY(0));
         max.setInteractScript(new ExBestFriendScript());
         npcs.add(max);

         Investigator investigator0 = new Investigator(1, getMapTile(20, 53).getLocation().subtractY(40));
         investigator0.setInteractScript(new InvestigatorScript0());
         npcs.add(investigator0);

         Investigator investigator1 = new Investigator(1, getMapTile(87, 13).getLocation().subtractY(40));
         investigator1.setInteractScript(new InvestigatorScript1());
         npcs.add(investigator1);

         Investigator investigator2 = new Investigator(1, getMapTile(12, 18).getLocation().subtractY(40));
         investigator2.setInteractScript(new InvestigatorScript2());
         npcs.add(investigator2);

         Boss boss = new Boss(1, getMapTile(49, 65).getLocation().subtractY(0));
         boss.setInteractScript(new DamienScript());
         npcs.add(boss);



         ExGf ex = new ExGf(1, getMapTile(24, 39).getLocation().subtractY(0));
         ex.setInteractScript(new BrotherExGFScript());
         npcs.add(ex); 

         MHDaughter daughter = new MHDaughter(1, getMapTile(64, 57).getLocation().subtractY(40));
         daughter.setInteractScript(new DrugDealerDaughterScript());
         npcs.add(daughter);

         DrugDealer drugDealer = new DrugDealer(1,getMapTile(66, 56).getLocation().subtractY(0));
         drugDealer.setInteractScript(new DrugDealerScript());
         npcs.add(drugDealer);

         Bike bike = new Bike(1, getMapTile(87, 16).getLocation().subtractY(0));
         bike.setInteractScript(new BikeTangibility());
         npcs.add(bike);

         ScaryDog dog = new ScaryDog(1, getMapTile(70,54).getLocation().subtractY(0));
         dog.setInteractScript(new BikeTangibility());
         npcs.add(dog);

 
         return npcs;
     }
 
 
     @Override
     public ArrayList<Trigger> loadTriggers() {
         ArrayList<Trigger> triggers = new ArrayList<>();
 
         //trigger to enter the main character's house
         Point house1 = getPositionByTileIndex(15, 13);
         triggers.add(new Trigger(house1.x, house1.y, 95, 10, new TownToHouse1Script(), "townToHouse1"));
 
 
         // trigger to enter butcher
         Point butcherShop = getPositionByTileIndex(63, 47);
         triggers.add(new Trigger(butcherShop.x, butcherShop.y, 50, 10, new TownToButcherScript(), "townToButcher"));


        Point lockedCemetery = getPositionByTileIndex(90, 19);
        triggers.add(new Trigger(lockedCemetery.x , lockedCemetery.y, 10, 10, new LockedAreaScript(), "lockedCemetery"));
        triggers.add(new Trigger(lockedCemetery.x , lockedCemetery.y, 10, 100, new TownToCemeteryScript(), "townToCemetery"));

 
        Point fbiFile = getPositionByTileIndex(89, 75);
        triggers.add(new Trigger(fbiFile.x , fbiFile.y, 50, 50, new PopUpFileImageScript(), "fileImage"));
 

        Point dog = getPositionByTileIndex(70,57);
        triggers.add(new Trigger(dog.x, dog.y, 10, 50, new PopUpDogImageScript(), "scaryDogPopUp"));


        

         return triggers;
     }
 
     @Override
     public void loadScripts() {
        


         getMapTile(18, 13).setInteractScript(new SimpleTextScript("Your house"));
 
         getMapTile(30, 18).setInteractScript(new SimpleTextScript("Max's house"));


     }
 
 }
 