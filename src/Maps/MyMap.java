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
import Scripts.MyMap.EnterHomeScript;
import Scripts.TestMap.ExitScript;
import Tilesets.CommonTileset;
import Utils.Point;
import java.util.ArrayList;


public class MyMap extends Map {
    public MyMap() {
        super("my_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        Point tileLocation1 = getMapTile(16, 19).getLocation();
        //entering main home
        triggers.add(new Trigger(tileLocation1.x, tileLocation1.y, 60,60, new EnterHomeScript(), "enteringHome"));
        return triggers;
    }
    
}

