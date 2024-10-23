/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- ButcherShop: displays the meat shop map
 */

package Maps;

import Level.*;
import Scripts.*;
import Scripts.ButcherShopMap.*;
import Tilesets.CommonTileset;
import Utils.Point;
import Utils.Point;

// import Utils.Point;
import java.util.ArrayList;

public class ButcherShopMap extends Map {
    public ButcherShopMap() {
        super("butcher_shop.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(4, 6).getLocation();
        currMapInt = 2;
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

         //trigger to enter town
        Point town = getPositionByTileIndex(4,5);
        triggers.add(new Trigger(town.x, town.y, 20,10, new ButcherToTownScript(), "ButcherToTown"));

        return triggers;
    } 
}
