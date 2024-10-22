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
import Scripts.TownMap.*;
import Tilesets.CommonTileset;
import Utils.Point;
import java.util.ArrayList;


public class TownMap extends Map {
    public TownMap() {
        super("town_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
<<<<<<< HEAD

        //trigger to enter house1
        Point house1 = getPositionByTileIndex(16,20);
=======
        Point house1 = getPositionByTileIndex(16,23);
        //Point tileLocation1 = getMapTile(16, 19).getLocation();
        //entering main home
        //triggers.add(new Trigger(tileLocation1.x, tileLocation1.y, 60,60, new EnterHomeScript(), "enteringHome"));
>>>>>>> 60aad67b52c1630f956eab5bfdd1dbbb6d08a024
        triggers.add(new Trigger(house1.x, house1.y, 95,10, new TownToHouse1Script(),"townToHouse1"));

        //trigger to enter butcher
        Point butcherShop = getPositionByTileIndex(17,56);
        triggers.add(new Trigger(butcherShop.x, butcherShop.y, 20,10, new TownToButcherScrpt(), "townToButcher"));

        return triggers;
    }
    
    
}

