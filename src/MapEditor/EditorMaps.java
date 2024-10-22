package MapEditor;

import Level.Map;
import Maps.TitleScreenMap;
import Maps.TownMap;
import Maps.ButcherShopMap;
import Maps.House1Map;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("House1Map");
            add("TitleScreen");
            add("TownMap");
            add("ButcherShop");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "House1Map":
                return new House1Map();
            case "TitleScreen":
                return new TitleScreenMap();
            case "TownMap":
                return new TownMap();
            case "ButcherShop":
                return new ButcherShopMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
