package Maps;

import Level.Map;
import Tilesets.CommonTileset;
import Tilesets.TownTileset;

public class TownMap1 extends Map {
    public TownMap1() {
        super("town_map1.txt", new TownTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }
    
}