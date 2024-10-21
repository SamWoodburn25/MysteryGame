/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- MyMap: displays the outdoor town map
 */

package Maps;

import Level.*;
import Scripts.MyMap.*;
import Scripts.TestMap.ExitScript;
import Tilesets.CommonTileset;
import Utils.Point;
import java.util.ArrayList;


public class MyMap extends Map {
    
    public MyMap() {
        super("my_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
        currMapInt = 1;
        currMap = this;
    }

    public void initialize(){
        new MyMap();
    }

     // setter getter map
    public void setCurrMapInt(int currMapInt){
        this.currMapInt = currMapInt;
    }
    public int getCurrMapInt(){
        return this.currMapInt;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        //entering main home
        Point homeDoorLocation = getMapTile(16, 19).getLocation();
        triggers.add(new Trigger(homeDoorLocation.x, homeDoorLocation.y, 60,60, new EnterHomeScript(), "enteringHome"));
        //17 56
        //entering butcher shop
        Point butcherDoorLocation = getMapTile(17, 56).getLocation();
        triggers.add(new Trigger(butcherDoorLocation.x, butcherDoorLocation.y, 60,60, new EnterButcherScript(), "enteringButcherShop"));
        return triggers;
    }
    
}

