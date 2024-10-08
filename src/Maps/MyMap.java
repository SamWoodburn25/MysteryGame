package Maps;

import Level.*;
import Tilesets.CommonTileset;

public class MyMap extends Map {
    public MyMap() {
        super("my_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }
    
}
