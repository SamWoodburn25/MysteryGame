package Tilesets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Builders.MapTileBuilder;
import Engine.ImageLoader;
import Level.Tileset;

public class TownTileset extends Tileset{

    public TownTileset() {
                super(ImageLoader.load("TownTileset.png"), 16, 16, 3);
        }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
    //tiles









        throw new UnsupportedOperationException("Unimplemented method 'defineTiles'");
    }
    
}
