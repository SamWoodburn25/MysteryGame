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
import NPCs.BodyBone;
import NPCs.BodyBoneThree;
import NPCs.BodyBoneTwo;
import NPCs.BottomLegs;
import NPCs.Crow;
import NPCs.RandBone;
import NPCs.Skull;
import NPCs.SkullOne;
import NPCs.SkullThree;
import NPCs.SkullTwo;
import Scripts.CemeteryMap.CemeteryToTownScript;
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

        Skull skull1 = new Skull(4, getMapTile(8, 18).getLocation().subtractY(0));
        npcs.add(skull1);

        Crow crow1 = new Crow(2, getMapTile(7, 15).getLocation().subtractY(0));
        npcs.add(crow1);

        BodyBone bodybone = new BodyBone(4, getMapTile(9, 23).getLocation().subtractY(0));
        npcs.add(bodybone);

        BodyBoneTwo bodyBoneTwo= new BodyBoneTwo(4, getMapTile(30,19).getLocation().subtractY(0));
        npcs.add(bodyBoneTwo);

        BodyBoneThree bodyBoneThree= new BodyBoneThree(4, getMapTile(17,26).getLocation().subtractY(0));
        npcs.add(bodyBoneThree);

        SkullOne skullOne = new SkullOne(4, getMapTile(19,19).getLocation().subtractY(0));
        npcs.add(skullOne);

        SkullTwo skullTwo = new SkullTwo(4, getMapTile(28,25).getLocation().subtractY(0));
        npcs.add(skullTwo);

        SkullThree skullThree = new SkullThree(4, getMapTile(20,15).getLocation().subtractY(0));
        npcs.add(skullThree);


        BottomLegs bottomLegs = new BottomLegs(4, getMapTile(11,27).getLocation().subtractY(0));
        npcs.add(bottomLegs);

        RandBone randBone = new RandBone (4, getMapTile(10,30).getLocation().subtractY(0));
        npcs.add(randBone);

        RandBone randBone1 = new RandBone (4, getMapTile(9,29).getLocation().subtractY(0));
        npcs.add(randBone1);

        RandBone randBone2 = new RandBone (4, getMapTile(11,29).getLocation().subtractY(0));
        npcs.add(randBone2);

        return npcs;
    }


    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();

        Point toTown = getPositionByTileIndex(0,24);
        triggers.add(new Trigger(toTown.x + 10, toTown.y, 10,100, new CemeteryToTownScript(), "CemeteryToTown"));
    
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
