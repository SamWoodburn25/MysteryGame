package Tilesets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;
public class TownTileset extends Tileset{

    public TownTileset() {
                super(ImageLoader.load("TownTileset.png"), 16, 16, 3);
        }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // grass
        Frame grassFrame = new FrameBuilder(getSubImage(0, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame);

        mapTiles.add(grassTile);


        // path
        Frame pathFrame = new FrameBuilder(getSubImage(0, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder pathTile = new MapTileBuilder(pathFrame);

        mapTiles.add(pathTile);



        // tree1
        Frame tree1Frame = new FrameBuilder(getSubImage(0, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree1Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree1Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree1Tile);

        // tree2
        Frame tree2Frame = new FrameBuilder(getSubImage(0, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree2Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree2Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree2Tile);

        // tree 3
        Frame tree3Frame = new FrameBuilder(getSubImage(0, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree3Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree3Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree3Tile);

        // tree4
        Frame tree4Frame = new FrameBuilder(getSubImage(0, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree4Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree4Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree4Tile);

        // tree5
        Frame tree5Frame = new FrameBuilder(getSubImage(0, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree5Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree5Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree5Tile);

        // tree6
        Frame tree6Frame = new FrameBuilder(getSubImage(0, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree6Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree6Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree6Tile);

        // tree7
        Frame tree7Frame = new FrameBuilder(getSubImage(0, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree7Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree7Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree7Tile);

        // tree8
        Frame tree8Frame = new FrameBuilder(getSubImage(0, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree8Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree8Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree8Tile);

        // tree9
        Frame tree9Frame = new FrameBuilder(getSubImage(1, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree9Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree9Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree9Tile);

        // tree10
        Frame tree10Frame = new FrameBuilder(getSubImage(1, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree10Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree10Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree10Tile);

        // tree11
        Frame tree11Frame = new FrameBuilder(getSubImage(1, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree11Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree11Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree11Tile);

        // tree12
        Frame tree12Frame = new FrameBuilder(getSubImage(1, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree12Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree12Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree12Tile);

        // tree13
        Frame tree13Frame = new FrameBuilder(getSubImage(1, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree13Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree13Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree13Tile);

        // tree14
        Frame tree14Frame = new FrameBuilder(getSubImage(1, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree14Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree14Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree14Tile);

        // tree15
        Frame tree15Frame = new FrameBuilder(getSubImage(1, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree15Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree15Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree15Tile);

        // tree16
        Frame tree16Frame = new FrameBuilder(getSubImage(1, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree16Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree16Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree16Tile);

        // tree17
        Frame tree17Frame = new FrameBuilder(getSubImage(1, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree17Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree17Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree17Tile);

        // tree18
        Frame tree18Frame = new FrameBuilder(getSubImage(1, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree18Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree18Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree18Tile);

        // tree19
        Frame tree19Frame = new FrameBuilder(getSubImage(2, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree19Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree19Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree19Tile);

        // tree20
        Frame tree20Frame = new FrameBuilder(getSubImage(2, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree20Tile = new MapTileBuilder(grassFrame)
            .withTopLayer(tree20Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree20Tile);

        // house1roof
        Frame house1RoofFrame = new FrameBuilder(getSubImage(2, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1RoofTile = new MapTileBuilder(house1RoofFrame);

        mapTiles.add(house1RoofTile);

        // house1 right roof
        Frame house1rRoofFrame = new FrameBuilder(getSubImage(2, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1rRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(house1rRoofFrame)
        .   withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1rRoofTile);

        // house1 left roof
        Frame house1lRoofFrame = new FrameBuilder(getSubImage(2, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1lRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(house1lRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1lRoofTile);

        // house1 top roof
        Frame house1TopRoofFrame = new FrameBuilder(getSubImage(2, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1TopRoofTile = new MapTileBuilder(house1TopRoofFrame);

        mapTiles.add(house1TopRoofTile);

        // house1 bottom roof
        Frame house1BottomRoofFrame = new FrameBuilder(getSubImage(2, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1BottomRoofTile = new MapTileBuilder(house1BottomRoofFrame);

        mapTiles.add(house1BottomRoofTile);

        // house1 left bottom roof
        Frame house1lBottomRoofFrame = new FrameBuilder(getSubImage(2, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1lBottomRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(house1lBottomRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1lBottomRoofTile);

        //house1 right bottom roof
        Frame house1rBottomRoofFrame = new FrameBuilder(getSubImage(2, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1rBottomRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(house1rBottomRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1rBottomRoofTile);


        Frame house1ExtWallFrame = new FrameBuilder(getSubImage(2, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1ExtWallTile = new MapTileBuilder(house1ExtWallFrame);

        mapTiles.add(house1ExtWallTile);

        // walkway
        Frame walkwayFrame = new FrameBuilder(getSubImage(3, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder walkwayTile = new MapTileBuilder(walkwayFrame);

        mapTiles.add(walkwayTile);


        // lamp
        Frame lampFrame = new FrameBuilder(getSubImage(3, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder lampTile = new MapTileBuilder(lampFrame);

        mapTiles.add(lampTile);

        // topDoor
         Frame topDoorFrame = new FrameBuilder(getSubImage(3, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder topDoorTile = new MapTileBuilder(topDoorFrame);

        mapTiles.add(topDoorTile);


        // left middle door
        Frame middleLeftDoorFrame = new FrameBuilder(getSubImage(3, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder middleLeftDoorTile = new MapTileBuilder(middleLeftDoorFrame);

        mapTiles.add(middleLeftDoorTile);


        // right middle door
        Frame middleRightDoorFrame = new FrameBuilder(getSubImage(3, 3))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder middleRightDoorTile = new MapTileBuilder(middleRightDoorFrame);

        mapTiles.add(middleRightDoorTile);


        // bottom door
        Frame bottomDoorFrame = new FrameBuilder(getSubImage(3, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder bottomDoorTile = new MapTileBuilder(bottomDoorFrame);

        mapTiles.add(bottomDoorTile);

        // sign
        Frame signFrame = new FrameBuilder(getSubImage(3, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder signTile = new MapTileBuilder(grassFrame)
            .withTopLayer(signFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(signTile);

        // outside butcher wall 1
        Frame outsideButcherWallOneFrame = new FrameBuilder(getSubImage(3,6 ))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherWallOneTile = new MapTileBuilder(outsideButcherWallOneFrame);
        mapTiles.add(outsideButcherWallOneTile);


        /// bottom door butcher
        Frame bottomDoorButcherFrame = new FrameBuilder(getSubImage(3, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder bottomDoorButcherTile = new MapTileBuilder(bottomDoorButcherFrame);
        mapTiles.add(bottomDoorButcherTile);


        // middle door butcher
        Frame middleDoorButcherFrame = new FrameBuilder(getSubImage(3, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder middleDoorButcherTile = new MapTileBuilder(middleDoorButcherFrame);
        mapTiles.add(middleDoorButcherTile);

        // top door butcher
        Frame topDoorButcherFrame = new FrameBuilder(getSubImage(3, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder topDoorButcherTile = new MapTileBuilder(topDoorButcherFrame);
        mapTiles.add(topDoorButcherTile);


        // outside butcher wall w right window
        Frame outsideButcherWallRightWindowFrame = new FrameBuilder(getSubImage(4, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherWallRightWindowTile = new MapTileBuilder(outsideButcherWallRightWindowFrame);
        mapTiles.add(outsideButcherWallRightWindowTile);

        // outside butcher wall 2
        Frame outsideButcherWallTwoFrame = new FrameBuilder(getSubImage(4, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherWallTwoTile = new MapTileBuilder(outsideButcherWallTwoFrame);
        mapTiles.add(outsideButcherWallTwoTile);

        // left roof butcher
        Frame leftButcherRoofFrame = new FrameBuilder(getSubImage(4, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder leftButcherRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(leftButcherRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftButcherRoofTile);


        // right roof butcher
        Frame rightButcherRoofFrame = new FrameBuilder(getSubImage(4, 2))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder rightButcherRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(rightButcherRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rightButcherRoofTile);

        // chimney roof butcher
        Frame chimneyButcherRoofFrame = new FrameBuilder(getSubImage(4, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder chimneyButcherRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(chimneyButcherRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(chimneyButcherRoofTile);

        // outside butcher grate left
        Frame outsideButcherGrateLeftFrame = new FrameBuilder(getSubImage(4, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherGrateLeftTile = new MapTileBuilder(outsideButcherGrateLeftFrame);
        mapTiles.add(outsideButcherGrateLeftTile);

        // outside butcher grate middle
        Frame outsideButcherGrateMiddleFrame = new FrameBuilder(getSubImage(4, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherGrateMiddleTile = new MapTileBuilder(outsideButcherGrateMiddleFrame);
        mapTiles.add(outsideButcherGrateMiddleTile);

        // outside butcher grate right
        Frame outsideButcherGrateRightFrame = new FrameBuilder(getSubImage(4,6))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherGrateRightTile = new MapTileBuilder(outsideButcherGrateRightFrame);
        mapTiles.add(outsideButcherGrateRightTile);


        // house1 left small roof
        Frame house1lSmallRoofFrame = new FrameBuilder(getSubImage(4, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1lSmallRoofTile = new MapTileBuilder(house1RoofFrame)
            .withTopLayer(house1lSmallRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1lSmallRoofTile);

        // house1 right small roof
        Frame house1rSmallRoofFrame = new FrameBuilder(getSubImage(4, 8))
        .withScale(tileScale)
        .build();

        MapTileBuilder house1rSmallRoofTile = new MapTileBuilder(house1RoofFrame)
        .withTopLayer(house1rSmallRoofFrame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1rSmallRoofTile);

        //house1 top left window
        Frame house1lTopWindowFrame = new FrameBuilder(getSubImage(4, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1lTopWindowTile = new MapTileBuilder(house1ExtWallFrame)
            .withTopLayer(house1lTopWindowFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1lTopWindowTile);

        // house1 top right window
        Frame house1rTopWindowFrame = new FrameBuilder(getSubImage(5, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1rTopWindowTile = new MapTileBuilder(house1ExtWallFrame)
            .withTopLayer(house1rTopWindowFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1rTopWindowTile);

        // house1  left bottom window
        Frame house1lBottomWindowFrame = new FrameBuilder(getSubImage(5, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1lBottomWindowTile = new MapTileBuilder(house1ExtWallFrame)
            .withTopLayer(house1lBottomWindowFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1lBottomWindowTile);


        // house1 right bottom window
        Frame house1rBottomWindowFrame = new FrameBuilder(getSubImage(5, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1rBottomWindowTile = new MapTileBuilder(house1ExtWallFrame)
            .withTopLayer(house1rBottomWindowFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1rBottomWindowTile);

        // house1 normal top left window
        Frame house1lNormTopWindowFrame = new FrameBuilder(getSubImage(5, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1lNormTopWindowTile = new MapTileBuilder(house1ExtWallFrame)
            .withTopLayer(house1lNormTopWindowFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1lNormTopWindowTile);

        // house1 normal top right window
        Frame house1rNormTopWindowFrame = new FrameBuilder(getSubImage(5, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1rNormTopWindowTile = new MapTileBuilder(house1ExtWallFrame)
            .withTopLayer(house1rNormTopWindowFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1rNormTopWindowTile);

        //reversed exterior wall tile
        Frame house1rExtWallFrame = new FrameBuilder(getSubImage(2, 9))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder house1rExtWallTile = new MapTileBuilder(house1rExtWallFrame);

        mapTiles.add(house1rExtWallTile);



        //house2 exterior wall tile
        Frame house2ExtWallFrame = new FrameBuilder(getSubImage(5, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder house2ExtWallTile = new MapTileBuilder(house2ExtWallFrame);

        mapTiles.add(house2ExtWallTile);


        //house2 right roof 
        Frame house2rRoofFrame = new FrameBuilder(getSubImage(5, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder house2rRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(house2rRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house2rRoofTile);


        //house2 left roof 
        Frame house2lRoofFrame = new FrameBuilder(getSubImage(5, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder house2lRoofTile = new MapTileBuilder(grassFrame)
            .withTopLayer(house2lRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house2lRoofTile);














            











        return mapTiles;


    }
    
}
