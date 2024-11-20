/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- CemeteryMap: displays the outdoor cemetery map
 */

package Maps;

import java.util.ArrayList;

import Level.*;
import NPCs.BodyBone;
import NPCs.BodyBoneThree;
import NPCs.BodyBoneTwo;
import NPCs.BottomLegs;
import NPCs.Brother;
import NPCs.Crow;
import NPCs.RandBone;
import NPCs.Skull;
import NPCs.SkullOne;
import NPCs.SkullThree;
import NPCs.SkullTwo;
import Scripts.CemeteryMap.CemeteryToTownScript;
import Scripts.CemeteryMap.DeathScript;
import Scripts.CemeteryMap.JoinScript;
import Scripts.House1Map.BrotherScript;
import Scripts.TownMap.PopUpGraveyardImageScript;
import Tilesets.CemeteryTileset;

import Utils.Point;


public class CemeteryMap extends Map {
    public CemeteryMap() {
        super("cemetery_map.txt", new CemeteryTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Crow crow1 = new Crow(2, getMapTile(8, 26).getLocation().subtractY(0));
        npcs.add(crow1);

        Crow crow2 = new Crow(2,getMapTile(4, 16).getLocation().subtractY(0));
        npcs.add(crow2);

        BodyBone bodybone = new BodyBone(4, getMapTile(5, 25).getLocation().subtractY(0));
        npcs.add(bodybone);

        BodyBoneTwo bodyBoneTwo= new BodyBoneTwo(4, getMapTile(22,20).getLocation().subtractY(0));
        npcs.add(bodyBoneTwo);

        BodyBoneTwo bodyBoneTwo2 = new BodyBoneTwo(4,getMapTile(24,8).getLocation().subtractY(0));
        npcs.add(bodyBoneTwo2);

        BodyBoneThree bodyBoneThree= new BodyBoneThree(4, getMapTile(21,18).getLocation().subtractY(0));
        npcs.add(bodyBoneThree);

        BodyBoneThree bodyBoneThree2= new BodyBoneThree(4, getMapTile(39,15).getLocation().subtractY(4));
        npcs.add(bodyBoneThree2);

        Skull skull1 = new Skull(4, getMapTile(13, 19).getLocation().subtractY(0));
        npcs.add(skull1);

        SkullOne skullOne = new SkullOne(4, getMapTile(19,19).getLocation().subtractY(0));
        npcs.add(skullOne);

        SkullOne skullOne2 = new SkullOne(4, getMapTile(38,14).getLocation().subtractY(-10));
        npcs.add(skullOne2);

        SkullTwo skullTwo = new SkullTwo(4, getMapTile(19,26).getLocation().subtractY(0));
        npcs.add(skullTwo);

        SkullThree skullThree = new SkullThree(4, getMapTile(3,19).getLocation().subtractY(0));
        npcs.add(skullThree);

        SkullThree skullThree2 = new SkullThree(4, getMapTile(25,14).getLocation().subtractY(0));
        npcs.add(skullThree2);

        

        BottomLegs bottomLegs = new BottomLegs(4, getMapTile(4,24).getLocation().subtractY(0));
        npcs.add(bottomLegs);

        BottomLegs bottomLegs2 = new BottomLegs(4,getMapTile(20,11).getLocation().subtractY(0));
        npcs.add(bottomLegs2);

        RandBone randBone = new RandBone (4, getMapTile(7,24).getLocation().subtractY(0));
        npcs.add(randBone);

        RandBone randBone2 = new RandBone (4, getMapTile(8,24).getLocation().subtractY(0));
        npcs.add(randBone2);

        RandBone randBone3 = new RandBone (4, getMapTile(28,14).getLocation().subtractY(0));
        npcs.add(randBone3);
        
        Brother max = new Brother(1, getMapTile(39, 10).getLocation().subtractY(0));
        max.setInteractScript(new BrotherScript());
        npcs.add(max);



        return npcs;
    }


    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();

    
        //temp trigger to test death cutscene
        // Point deathLoc = getMapTile(40,12).getLocation();
        // triggers.add(new Trigger(deathLoc.x, deathLoc.y, 10, 160, new DeathScript(), "deathScript"));

        // Point joinLoc = getMapTile(37,7).getLocation();
        // triggers.add(new Trigger(joinLoc.x, joinLoc.y, 10, 160, new JoinScript(), "joinScript"));
        
        Point toTown = getPositionByTileIndex(0,30);
        triggers.add(new Trigger(toTown.x +14, toTown.y,5 ,100, new CemeteryToTownScript(), "CemeteryToTown"));
    
         // pop up image trigger
        Point photoLoc = getPositionByTileIndex(11, 29);
        triggers.add(new Trigger(photoLoc.x + 25, photoLoc.y, 20, 5, new PopUpGraveyardImageScript(), "graveyardImage"));
        
        return triggers;
    }

    

   /*  @Override
    public void loadScripts() {

        getMapTile(6, 23).setInteractScript(new SimpleTextScript("Your house"));

    }*/

}
