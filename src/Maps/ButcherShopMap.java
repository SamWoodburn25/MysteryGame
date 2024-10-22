/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Maps
 * class- ButcherShopmap: displays the meat shop map
 */

package Maps;

import Level.*;
// import Scripts.House1Map.ExitScript;
// import Scripts.House1Map.PopUpButcherImageScript;
import Tilesets.CommonTileset;
import Utils.Point;
import java.util.ArrayList;

public class ButcherShopMap extends Map {
    public ButcherShopMap() {
        super("butcher_shop.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
    }
 
     @Override
     public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        // Point tileLocation1 = getMapTile(10, 10).getLocation();

        // // pop-up butcher image
        //     triggers.add(new Trigger(tileLocation1.x, tileLocation1.y, 10,160, new PopUpButcherImageScript(), "popUpButcherImage"));


        return triggers;
    } 
}
