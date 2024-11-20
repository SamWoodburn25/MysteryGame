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

        MapTileBuilder tree16Tile = new MapTileBuilder(tree16Frame)
           
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

        MapTileBuilder tree19Tile = new MapTileBuilder(tree19Frame)
          
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree19Tile);

        // tree20
        Frame tree20Frame = new FrameBuilder(getSubImage(2, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder tree20Tile = new MapTileBuilder(tree20Frame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(tree20Tile);

        // town ground 
        Frame townGroundFrame = new FrameBuilder(getSubImage(2, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder townGroundTile = new MapTileBuilder(townGroundFrame);

        mapTiles.add(townGroundTile);

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

        // house1 roof 
        Frame house1RoofFrame = new FrameBuilder(getSubImage(2, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1RoofTile = new MapTileBuilder(house1RoofFrame);

        mapTiles.add(house1RoofTile);

        // not passable grass frame
        Frame npGrassFrame = new FrameBuilder(getSubImage(0, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder npGrassTile = new MapTileBuilder(npGrassFrame)
            //.withTopLayer(house1lBottomRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(npGrassTile);

        //house1 right bottom roof
        Frame house1rBottomRoofFrame = new FrameBuilder(getSubImage(2, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1rBottomRoofTile = new MapTileBuilder(npGrassFrame)
            .withTopLayer(house1rBottomRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house1rBottomRoofTile);


        Frame house1ExtWallFrame = new FrameBuilder(getSubImage(2, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder house1ExtWallTile = new MapTileBuilder(house1ExtWallFrame)
            .withTileType(TileType.NOT_PASSABLE);

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

        MapTileBuilder middleRightDoorTile = new MapTileBuilder(middleRightDoorFrame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(middleRightDoorTile);


        // bottom door
        Frame bottomDoorFrame = new FrameBuilder(getSubImage(3, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder bottomDoorTile = new MapTileBuilder(bottomDoorFrame)
        .withTileType(TileType.PASSABLE);

        mapTiles.add(bottomDoorTile);

        // sign
        Frame signFrame = new FrameBuilder(getSubImage(3, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder signTile = new MapTileBuilder(signFrame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(signTile);

        // outside butcher wall 1
        Frame outsideButcherWallOneFrame = new FrameBuilder(getSubImage(3,6 ))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherWallOneTile = new MapTileBuilder(outsideButcherWallOneFrame)
            .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(outsideButcherWallOneTile);


        /// bottom door butcher
        Frame bottomDoorButcherFrame = new FrameBuilder(getSubImage(3, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder bottomDoorButcherTile = new MapTileBuilder(bottomDoorButcherFrame)
            .withTileType(TileType.PASSABLE);
        mapTiles.add(bottomDoorButcherTile);


        // middle door butcher
        Frame  middleDoorButcherFrame = new FrameBuilder(getSubImage(3, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder middleDoorButcherTile = new MapTileBuilder(middleDoorButcherFrame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(middleDoorButcherTile);

        // top door butcher
        Frame topDoorButcherFrame = new FrameBuilder(getSubImage(3, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder topDoorButcherTile = new MapTileBuilder(topDoorButcherFrame)
            .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(topDoorButcherTile);


        // outside butcher wall w right window
        Frame outsideButcherWallRightWindowFrame = new FrameBuilder(getSubImage(4, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherWallRightWindowTile = new MapTileBuilder(outsideButcherWallRightWindowFrame)
            .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(outsideButcherWallRightWindowTile);

        // outside butcher wall 2
        Frame outsideButcherWallTwoFrame = new FrameBuilder(getSubImage(4, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherWallTwoTile = new MapTileBuilder(outsideButcherWallTwoFrame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(outsideButcherWallTwoTile);

        // left roof butcher
        Frame leftButcherRoofFrame = new FrameBuilder(getSubImage(4, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder leftButcherRoofTile = new MapTileBuilder(npGrassFrame)
            .withTopLayer(leftButcherRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftButcherRoofTile);


        // right roof butcher
        Frame rightButcherRoofFrame = new FrameBuilder(getSubImage(4, 2))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder rightButcherRoofTile = new MapTileBuilder(npGrassFrame)
            .withTopLayer(rightButcherRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rightButcherRoofTile);

        // chimney roof butcher
        Frame chimneyButcherRoofFrame = new FrameBuilder(getSubImage(4, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder chimneyButcherRoofTile = new MapTileBuilder(npGrassFrame)
            .withTopLayer(chimneyButcherRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(chimneyButcherRoofTile);

        // outside butcher grate left
        Frame outsideButcherGrateLeftFrame = new FrameBuilder(getSubImage(4, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherGrateLeftTile = new MapTileBuilder(outsideButcherGrateLeftFrame)
            .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(outsideButcherGrateLeftTile);

        // outside butcher grate middle
        Frame outsideButcherGrateMiddleFrame = new FrameBuilder(getSubImage(4, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherGrateMiddleTile = new MapTileBuilder(outsideButcherGrateMiddleFrame)
            .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(outsideButcherGrateMiddleTile);

        // outside butcher grate right
        Frame outsideButcherGrateRightFrame = new FrameBuilder(getSubImage(4,6))
            .withScale(tileScale)
            .build();

        MapTileBuilder outsideButcherGrateRightTile = new MapTileBuilder(outsideButcherGrateRightFrame)
            .withTileType(TileType.NOT_PASSABLE);
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



        //sidewalk
        Frame sidewalk3Frame = new FrameBuilder(getSubImage(5, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder sidewalk3Tile = new MapTileBuilder(sidewalk3Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(sidewalk3Tile);


        //house2 right roof 
        Frame house2rRoofFrame = new FrameBuilder(getSubImage(5, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder house2rRoofTile = new MapTileBuilder(npGrassFrame)
            .withTopLayer(house2rRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house2rRoofTile);


        //house2 left roof 
        Frame house2lRoofFrame = new FrameBuilder(getSubImage(5, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder house2lRoofTile = new MapTileBuilder(npGrassFrame)
            .withTopLayer(house2lRoofFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(house2lRoofTile);

        //pathway right border
        Frame pathRightBorderFrame  = new FrameBuilder(getSubImage(5, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder pathRightBorderTile  = new MapTileBuilder(pathRightBorderFrame);
       

        mapTiles.add(pathRightBorderTile);

         //pathway top border
         Frame pathTopBorderFrame  = new FrameBuilder(getSubImage(5, 9))
         .withScale(tileScale)
         .build();

     MapTileBuilder pathTopBorderTile  = new MapTileBuilder(pathTopBorderFrame);
    

     mapTiles.add(pathTopBorderTile);

      //pathway left border
      Frame pathLeftBorderFrame  = new FrameBuilder(getSubImage(6, 0))
      .withScale(tileScale)
      .build();

  MapTileBuilder pathLeftBorderTile  = new MapTileBuilder(pathLeftBorderFrame);
 

  mapTiles.add(pathLeftBorderTile);

  //pathway bottom border
  Frame pathBottomBorderFrame  = new FrameBuilder(getSubImage(6, 1))
  .withScale(tileScale)
  .build();

MapTileBuilder pathBottomBorderTile  = new MapTileBuilder(pathBottomBorderFrame);


mapTiles.add(pathBottomBorderTile);

 //pathway bottom left corner border
 Frame pathBtmLeftCornerBorderFrame  = new FrameBuilder(getSubImage(6, 2))
 .withScale(tileScale)
 .build();

MapTileBuilder pathBtmLeftCornerBorderTile  = new MapTileBuilder(pathBtmLeftCornerBorderFrame);


mapTiles.add(pathBtmLeftCornerBorderTile);

//pathway bottom right corner border
Frame pathBtmRightCornerBorderFrame  = new FrameBuilder(getSubImage(6, 3))
.withScale(tileScale)
.build();

MapTileBuilder pathBtmRightCornerBorderTile  = new MapTileBuilder(pathBtmRightCornerBorderFrame);


mapTiles.add(pathBtmRightCornerBorderTile);

//pathway top left corner border
Frame pathTopLeftCornerBorderFrame  = new FrameBuilder(getSubImage(6, 4))
.withScale(tileScale)
.build();

MapTileBuilder pathTopLeftCornerBorderTile  = new MapTileBuilder(pathTopLeftCornerBorderFrame);


mapTiles.add(pathTopLeftCornerBorderTile);

//pathway bottom right corner border
Frame pathTopRightCornerBorderFrame  = new FrameBuilder(getSubImage(6, 5))
.withScale(tileScale)
.build();

MapTileBuilder pathTopRightCornerBorderTile  = new MapTileBuilder(pathTopRightCornerBorderFrame);


mapTiles.add(pathTopRightCornerBorderTile);

//building1 (town hall maybe) left border ext wall
Frame building1LeftExtWallFrame  = new FrameBuilder(getSubImage(6, 6))
.withScale(tileScale)
.build();

MapTileBuilder building1LeftExtWallTile  = new MapTileBuilder(building1LeftExtWallFrame)
.withTileType(TileType.NOT_PASSABLE);


mapTiles.add(building1LeftExtWallTile);

//building1 (town hall maybe) ext wall
Frame building1ExtWallFrame  = new FrameBuilder(getSubImage(6, 7))
.withScale(tileScale)
.build();

MapTileBuilder building1ExtWallTile  = new MapTileBuilder(building1ExtWallFrame)
.withTileType(TileType.NOT_PASSABLE);


mapTiles.add(building1ExtWallTile);

//building1 (town hall maybe) right border ext wall
Frame building1RightExtWallFrame  = new FrameBuilder(getSubImage(6, 8))
.withScale(tileScale)
.build();

MapTileBuilder building1RightExtWallTile  = new MapTileBuilder(building1RightExtWallFrame)
.withTileType(TileType.NOT_PASSABLE);



mapTiles.add(building1RightExtWallTile);


//top left building1 roof
Frame topLeftB1RoofFrame  = new FrameBuilder(getSubImage(6, 9))
.withScale(tileScale)
.build();

MapTileBuilder topLeftB1RoofTile  = new MapTileBuilder(npGrassFrame)
    .withTopLayer(topLeftB1RoofFrame)
    .withTileType(TileType.NOT_PASSABLE);   



mapTiles.add(topLeftB1RoofTile);

//top right building1 roof
Frame topRightB1RoofFrame  = new FrameBuilder(getSubImage(7, 0))
.withScale(tileScale)
.build();

MapTileBuilder topRightB1RoofTile  = new MapTileBuilder(npGrassFrame)
            .withTopLayer(topRightB1RoofFrame)
            .withTileType(TileType.NOT_PASSABLE);   


mapTiles.add(topRightB1RoofTile);



//left building1 roof
Frame leftB1RoofFrame  = new FrameBuilder(getSubImage(7, 1))
.withScale(tileScale)
.build();

MapTileBuilder leftB1RoofTile  = new MapTileBuilder(building1ExtWallFrame)
    .withTopLayer(leftB1RoofFrame)
    .withTileType(TileType.NOT_PASSABLE); 


mapTiles.add(leftB1RoofTile);

//right building1 roof
Frame rightB1RoofFrame  = new FrameBuilder(getSubImage(7, 2))
.withScale(tileScale)
.build();

MapTileBuilder rightB1RoofTile  = new MapTileBuilder(building1ExtWallFrame)
    .withTopLayer(rightB1RoofFrame)
    .withTileType(TileType.NOT_PASSABLE); 


mapTiles.add(rightB1RoofTile);

//building1 roof
Frame b1RoofFrame  = new FrameBuilder(getSubImage(7, 6))
.withScale(tileScale)
.build();

MapTileBuilder b1RoofTile  = new MapTileBuilder(b1RoofFrame);


mapTiles.add(b1RoofTile);



//bottom left building1 roof
Frame btmLeftB1RoofFrame  = new FrameBuilder(getSubImage(7, 3))
.withScale(tileScale)
.build();

MapTileBuilder btmLeftB1RoofTile  = new MapTileBuilder(b1RoofFrame)
    .withTopLayer(btmLeftB1RoofFrame)
    .withTileType(TileType.NOT_PASSABLE); 


mapTiles.add(btmLeftB1RoofTile);

//bottom left building1 roof
Frame btmRightB1RoofFrame  = new FrameBuilder(getSubImage(7, 4))
.withScale(tileScale)
.build();

MapTileBuilder btmRightB1RoofTile  = new MapTileBuilder(b1RoofFrame)
    .withTopLayer(btmRightB1RoofFrame)
    .withTileType(TileType.NOT_PASSABLE); 


mapTiles.add(btmRightB1RoofTile);

//top building1 roof
Frame topB1RoofFrame  = new FrameBuilder(getSubImage(7, 5))
.withScale(tileScale)
.build();

MapTileBuilder topB1RoofTile  = new MapTileBuilder(topB1RoofFrame);


mapTiles.add(topB1RoofTile);



//bottom building1 roof
Frame btmB1RoofFrame  = new FrameBuilder(getSubImage(7, 7))
.withScale(tileScale)
.build();

MapTileBuilder btmB1RoofTile  = new MapTileBuilder(btmB1RoofFrame);


mapTiles.add(btmB1RoofTile);


//top left building 1 window
Frame topLB1WindowFrame  = new FrameBuilder(getSubImage(7, 8))
.withScale(tileScale)
.build();

MapTileBuilder topLB1WindowTile  = new MapTileBuilder(building1ExtWallFrame)
        .withTopLayer(topLB1WindowFrame)
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(topLB1WindowTile);

//top right building 1 window
Frame topRB1WindowFrame  = new FrameBuilder(getSubImage(7, 9))
.withScale(tileScale)
.build();

MapTileBuilder topRB1WindowTile  = new MapTileBuilder(building1ExtWallFrame)
        .withTopLayer(topRB1WindowFrame)
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(topRB1WindowTile);

//bottom left building 1 window
Frame btmLB1WindowFrame  = new FrameBuilder(getSubImage(8, 0))
.withScale(tileScale)
.build();

MapTileBuilder btmLB1WindowTile  = new MapTileBuilder(building1ExtWallFrame)
        .withTopLayer(btmLB1WindowFrame)
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(btmLB1WindowTile);

//bottom right building 1 window
Frame btmRB1WindowFrame  = new FrameBuilder(getSubImage(8, 1))
.withScale(tileScale)
.build();

MapTileBuilder btmRB1WindowTile  = new MapTileBuilder(building1ExtWallFrame)
        .withTopLayer(btmRB1WindowFrame)
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(btmRB1WindowTile);

//top building1 door
Frame topB1doorFrame  = new FrameBuilder(getSubImage(8, 2))
.withScale(tileScale)
.build();

MapTileBuilder topB1doorTile  = new MapTileBuilder(topB1doorFrame)
        
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(topB1doorTile);

//middle left building1 door
Frame middleLB1doorFrame  = new FrameBuilder(getSubImage(8, 3))
.withScale(tileScale)
.build();

MapTileBuilder middleLB1doorTile  = new MapTileBuilder(middleLB1doorFrame)
      
        .withTileType(TileType.PASSABLE);


mapTiles.add(middleLB1doorTile);

//middle left building1 door
Frame middleRB1doorFrame  = new FrameBuilder(getSubImage(8, 3))
.withScale(tileScale)
.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
.build();

MapTileBuilder middleRB1doorTile  = new MapTileBuilder(middleRB1doorFrame)
      
        .withTileType(TileType.PASSABLE);


mapTiles.add(middleRB1doorTile);




//bottom building1 door
Frame btmB1doorFrame  = new FrameBuilder(getSubImage(8, 4))
.withScale(tileScale)
.build();

MapTileBuilder btmB1doorTile  = new MapTileBuilder(btmB1doorFrame)
      
        .withTileType(TileType.PASSABLE);


mapTiles.add(btmB1doorTile);

//left shop wall
Frame lShopWallFrame  = new FrameBuilder(getSubImage(8, 5))
.withScale(tileScale)
.build();

MapTileBuilder lShopWallTile  = new MapTileBuilder(lShopWallFrame)
      
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(lShopWallTile);

//shop wall
Frame shopWallFrame  = new FrameBuilder(getSubImage(8, 6))
.withScale(tileScale)
.build();

MapTileBuilder shopWallTile  = new MapTileBuilder(shopWallFrame)
      
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(shopWallTile);

//right shop wall
Frame rShopWallFrame  = new FrameBuilder(getSubImage(8, 7))
.withScale(tileScale)
.build();

MapTileBuilder rShopWallTile  = new MapTileBuilder(rShopWallFrame)
      
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(rShopWallTile);

//shop roof
Frame shopRoofFrame  = new FrameBuilder(getSubImage(8, 8))
.withScale(tileScale)
.build();

MapTileBuilder shopRoofTile  = new MapTileBuilder(shopRoofFrame)
      
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(shopRoofTile);

//clear window
Frame clearWindowFrame  = new FrameBuilder(getSubImage(8, 9))
.withScale(tileScale)
.build();

MapTileBuilder clearWindowTile  = new MapTileBuilder(clearWindowFrame)
      
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(clearWindowTile);

//left shop sign
Frame lShopSignFrame  = new FrameBuilder(getSubImage(9, 0))
.withScale(tileScale)
.build();

MapTileBuilder lShopSignTile  = new MapTileBuilder(shopWallFrame)
        .withTopLayer(lShopSignFrame)
        .withTileType(TileType.PASSABLE);


mapTiles.add(lShopSignTile);

//right shop sign
Frame rShopSignFrame  = new FrameBuilder(getSubImage(9, 1))
.withScale(tileScale)
.build();

MapTileBuilder rShopSignTile  = new MapTileBuilder(shopWallFrame)
        .withTopLayer(rShopSignFrame)
        .withTileType(TileType.PASSABLE);


mapTiles.add(rShopSignTile);

//walkway top border
Frame walkwayTopFrame  = new FrameBuilder(getSubImage(9, 2))
.withScale(tileScale)
.build();

MapTileBuilder walkwayTopTile  = new MapTileBuilder(walkwayTopFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayTopTile);

//walkway bottom border
Frame walkwayBtmFrame  = new FrameBuilder(getSubImage(9, 3))
.withScale(tileScale)
.build();

MapTileBuilder walkwayBtmTile  = new MapTileBuilder(walkwayBtmFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayBtmTile);

//walkway bottom left corner border
Frame walkwayBtmLCornerFrame  = new FrameBuilder(getSubImage(9, 4))
.withScale(tileScale)
.build();

MapTileBuilder walkwayBtmLCornerTile  = new MapTileBuilder(walkwayBtmLCornerFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayBtmLCornerTile);

//walkway bottom right corner border
Frame walkwayBtmRCornerFrame  = new FrameBuilder(getSubImage(9, 5))
.withScale(tileScale)
.build();

MapTileBuilder walkwayBtmRCornerTile  = new MapTileBuilder(walkwayBtmRCornerFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayBtmRCornerTile);

//walkway top left corner border
Frame walkwayTopLCornerFrame  = new FrameBuilder(getSubImage(9, 6))
.withScale(tileScale)
.build();

MapTileBuilder walkwayTopLCornerTile  = new MapTileBuilder(walkwayTopLCornerFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayTopLCornerTile);

//walkway top right corner border
Frame walkwayTopRCornerFrame  = new FrameBuilder(getSubImage(9, 7))
.withScale(tileScale)
.build();

MapTileBuilder walkwayTopRCornerTile  = new MapTileBuilder(walkwayTopRCornerFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayTopRCornerTile);

//walkway right border
Frame walkwayRightFrame  = new FrameBuilder(getSubImage(9, 8))
.withScale(tileScale)
.build();

MapTileBuilder walkwayRightTile  = new MapTileBuilder(walkwayRightFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayRightTile);

//walkway left border
Frame walkwayLeftFrame  = new FrameBuilder(getSubImage(9, 9))
.withScale(tileScale)
.build();

MapTileBuilder walkwayLeftTile  = new MapTileBuilder(walkwayLeftFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(walkwayLeftTile);

//sidewalk2 
Frame sidewalkFrame  = new FrameBuilder(getSubImage(10, 0))
.withScale(tileScale)
.build();

MapTileBuilder sidewalkTile  = new MapTileBuilder(sidewalkFrame)
        
        .withTileType(TileType.PASSABLE);


mapTiles.add(sidewalkTile);

//left building 2 wall
Frame lB2WallFrame = new FrameBuilder(getSubImage(10, 1))
.withScale(tileScale)
.build();

MapTileBuilder lB2WallTile  = new MapTileBuilder(lB2WallFrame)
        
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(lB2WallTile);

// building 2 wall
Frame b2WallFrame = new FrameBuilder(getSubImage(10, 2))
.withScale(tileScale)
.build();

MapTileBuilder b2WallTile  = new MapTileBuilder(b2WallFrame)
        
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(b2WallTile);

//right building 2 wall
Frame rB2WallFrame = new FrameBuilder(getSubImage(10, 3))
.withScale(tileScale)
.build();

MapTileBuilder rB2WallTile  = new MapTileBuilder(rB2WallFrame)
        
        .withTileType(TileType.NOT_PASSABLE);


mapTiles.add(rB2WallTile);


        //leafless tree1
        Frame ltree1Frame = new FrameBuilder(getSubImage(10, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree1Tile = new MapTileBuilder(ltree1Frame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree1Tile);

        //leafless tree2
        Frame ltree2Frame = new FrameBuilder(getSubImage(10, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree2Tile = new MapTileBuilder(ltree2Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree2Tile);

        //leafless tree3
        Frame ltree3Frame = new FrameBuilder(getSubImage(10, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree3Tile = new MapTileBuilder(ltree3Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree3Tile);

        //leafless tree4
        Frame ltree4Frame = new FrameBuilder(getSubImage(10, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree4Tile = new MapTileBuilder(ltree4Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree4Tile);


        //leafless tree5
        Frame ltree5Frame = new FrameBuilder(getSubImage(10, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree5Tile = new MapTileBuilder(ltree5Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree5Tile);

        //leafless tree6
        Frame ltree6Frame = new FrameBuilder(getSubImage(10, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree6Tile = new MapTileBuilder(ltree6Frame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree6Tile);

        //leafless tree7
        Frame ltree7Frame = new FrameBuilder(getSubImage(11, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree7Tile = new MapTileBuilder(ltree7Frame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree7Tile);

        //leafless tree8
         Frame ltree8Frame = new FrameBuilder(getSubImage(11, 1))
         .withScale(tileScale)
         .build();

        MapTileBuilder ltree8Tile = new MapTileBuilder(ltree8Frame)
       
         .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree8Tile);

        //leafless tree9
        Frame ltree9Frame = new FrameBuilder(getSubImage(11, 2))
        .withScale(tileScale)
        .build();

       MapTileBuilder ltree9Tile = new MapTileBuilder(ltree9Frame)
       
        .withTileType(TileType.NOT_PASSABLE);

       mapTiles.add(ltree9Tile);

       //leafless tree10
       Frame ltree10Frame = new FrameBuilder(getSubImage(11, 3))
       .withScale(tileScale)
       .build();

      MapTileBuilder ltree10Tile = new MapTileBuilder(ltree10Frame)
      
       .withTileType(TileType.NOT_PASSABLE);

      mapTiles.add(ltree10Tile);

      //leafless tree11
      Frame ltree11Frame = new FrameBuilder(getSubImage(11, 4))
      .withScale(tileScale)
      .build();

     MapTileBuilder ltree11Tile = new MapTileBuilder(ltree11Frame)
   
      .withTileType(TileType.NOT_PASSABLE);

     mapTiles.add(ltree11Tile);

     //leafless tree12
     Frame ltree12Frame = new FrameBuilder(getSubImage(11, 5))
     .withScale(tileScale)
     .build();

    MapTileBuilder ltree12Tile = new MapTileBuilder(ltree12Frame)
     
     .withTileType(TileType.NOT_PASSABLE);

    mapTiles.add(ltree12Tile);

    //leafless tree13
    Frame ltree13Frame = new FrameBuilder(getSubImage(11, 6))
    .withScale(tileScale)
    .build();

   MapTileBuilder ltree13Tile = new MapTileBuilder(ltree13Frame)
   
    .withTileType(TileType.NOT_PASSABLE);

   mapTiles.add(ltree13Tile);

   //leafless tree14
   Frame ltree14Frame = new FrameBuilder(getSubImage(11, 7))
   .withScale(tileScale)
   .build();

  MapTileBuilder ltree14Tile = new MapTileBuilder(ltree14Frame)
  
   .withTileType(TileType.NOT_PASSABLE);

  mapTiles.add(ltree14Tile);

//leafless tree15
Frame ltree15Frame = new FrameBuilder(getSubImage(11, 8))
.withScale(tileScale)
.build();

MapTileBuilder ltree15Tile = new MapTileBuilder(ltree15Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(ltree15Tile);

//leafless tree16
Frame ltree16Frame = new FrameBuilder(getSubImage(11, 9))
.withScale(tileScale)
.build();

MapTileBuilder ltree16Tile = new MapTileBuilder(ltree16Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(ltree16Tile);

//building 3 left wall
Frame lB3WallFrame = new FrameBuilder(getSubImage(1, 18))
.withScale(tileScale)
.build();

MapTileBuilder lB3WallTile = new MapTileBuilder(lB3WallFrame)

.withTileType(TileType.PASSABLE);

mapTiles.add(lB3WallTile);


//top fence for cemetery
Frame topFenceFrame = new FrameBuilder(getSubImage(0, 10))
.withScale(tileScale)
.build();

MapTileBuilder topFenceTile = new MapTileBuilder(topFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(topFenceTile);

//right top fence w pole thing for cemetary 
Frame rTopFenceFrame = new FrameBuilder(getSubImage(0, 11))
.withScale(tileScale)
.build();

MapTileBuilder rTopFenceTile = new MapTileBuilder(rTopFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rTopFenceTile);

//bottom fence 
Frame btmFenceFrame = new FrameBuilder(getSubImage(0, 12))
.withScale(tileScale)
.build();

MapTileBuilder btmFenceTile = new MapTileBuilder(btmFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(btmFenceTile);

//bottom right fence w pole thing for cemetary 
Frame rBtmFenceFrame = new FrameBuilder(getSubImage(0, 13))
.withScale(tileScale)
.build();

MapTileBuilder rBtmFenceTile = new MapTileBuilder(rBtmFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rBtmFenceTile);

//left top fence w pole thing for cemetary 
Frame lTopFenceFrame = new FrameBuilder(getSubImage(0, 11))
.withScale(tileScale)
.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
.build();

MapTileBuilder lTopFenceTile = new MapTileBuilder(lTopFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lTopFenceTile);

//bottom left fence w pole thing for cemetary 
Frame lBtmFenceFrame = new FrameBuilder(getSubImage(0, 13))
.withScale(tileScale)
.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
.build();

MapTileBuilder lBtmFenceTile = new MapTileBuilder(lBtmFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lBtmFenceTile);

//right top of side fence
Frame rTopSideFenceFrame = new FrameBuilder(getSubImage(0, 14))
.withScale(tileScale)
.build();

MapTileBuilder rTopSideFenceTile = new MapTileBuilder(rTopSideFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rTopSideFenceTile);

//right bottom of side fence
Frame rBtmSideFenceFrame = new FrameBuilder(getSubImage(0, 15))
.withScale(tileScale)
.build();

MapTileBuilder rBtmSideFenceTile = new MapTileBuilder(rBtmSideFenceFrame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rBtmSideFenceTile);

//left top of side fence
Frame lTopSideFenceFrame = new FrameBuilder(getSubImage(0, 14))
.withScale(tileScale)
.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
.build();

MapTileBuilder lTopSideFenceTile = new MapTileBuilder(lTopSideFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lTopSideFenceTile);

//left bottom of side fence
Frame lBtmSideFenceFrame = new FrameBuilder(getSubImage(0, 15))
.withScale(tileScale)
.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
.build();

MapTileBuilder lBtmSideFenceTile = new MapTileBuilder(lBtmSideFenceFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lBtmSideFenceTile);


//left top tombstone 1
Frame lTopT1Frame = new FrameBuilder(getSubImage(0, 16))
.withScale(tileScale)

.build();

MapTileBuilder lTopT1Tile = new MapTileBuilder(lTopT1Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lTopT1Tile);

//right top tombstone 1
Frame rTopT1Frame = new FrameBuilder(getSubImage(0, 17))
.withScale(tileScale)

.build();

MapTileBuilder rTopT1Tile = new MapTileBuilder(rTopT1Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rTopT1Tile);

//left bottom tombstone 1
Frame lBtmT1Frame = new FrameBuilder(getSubImage(0, 18))
.withScale(tileScale)

.build();

MapTileBuilder lBtmT1Tile = new MapTileBuilder(lBtmT1Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lBtmT1Tile);

//right bottom tombstone 1
Frame rBtmT1Frame = new FrameBuilder(getSubImage(0, 19))
.withScale(tileScale)

.build();

MapTileBuilder rBtmT1Tile = new MapTileBuilder(rBtmT1Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rBtmT1Tile);

//left top tombstone 2
Frame lTopT2Frame = new FrameBuilder(getSubImage(1, 10))
.withScale(tileScale)

.build();

MapTileBuilder lTopT2Tile = new MapTileBuilder(lTopT2Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lTopT2Tile);

//right top tombstone 2
Frame rTopT2Frame = new FrameBuilder(getSubImage(1, 11))
.withScale(tileScale)

.build();

MapTileBuilder rTopT2Tile = new MapTileBuilder(rTopT2Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rTopT2Tile);

//left bottom tombstone 2
Frame lBtmT2Frame = new FrameBuilder(getSubImage(1, 12))
.withScale(tileScale)

.build();

MapTileBuilder lBtmT2Tile = new MapTileBuilder(lBtmT2Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lBtmT2Tile);

//right bottom tombstone 2
Frame rBtmT2Frame = new FrameBuilder(getSubImage(1, 13))
.withScale(tileScale)

.build();

MapTileBuilder rBtmT2Tile = new MapTileBuilder(rBtmT2Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rBtmT2Tile);

//left top tombstone 3
Frame lTopT3Frame = new FrameBuilder(getSubImage(1, 14))
.withScale(tileScale)

.build();

MapTileBuilder lTopT3Tile = new MapTileBuilder(lTopT3Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lTopT3Tile);

//right top tombstone 3
Frame rTopT3Frame = new FrameBuilder(getSubImage(1, 15))
.withScale(tileScale)

.build();

MapTileBuilder rTopT3Tile = new MapTileBuilder(rTopT3Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rTopT3Tile);

//left bottom tombstone 3
Frame lBtmT3Frame = new FrameBuilder(getSubImage(1, 16))
.withScale(tileScale)

.build();

MapTileBuilder lBtmT3Tile = new MapTileBuilder(lBtmT3Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lBtmT3Tile);

//right bottom tombstone 3
Frame rBtmT3Frame = new FrameBuilder(getSubImage(1, 17))
.withScale(tileScale)

.build();

MapTileBuilder rBtmT3Tile = new MapTileBuilder(rBtmT3Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rBtmT3Tile);

//building 3 left wall - line 1394

//building 3 wall
Frame b3WallFrame = new FrameBuilder(getSubImage(1, 19))
.withScale(tileScale)

.build();

MapTileBuilder b3WallTile = new MapTileBuilder(b3WallFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(b3WallTile);

//right building 3 wall
Frame rB3WallFrame = new FrameBuilder(getSubImage(2, 10))
    .withScale(tileScale)

    .build();

MapTileBuilder rB3WallTile = new MapTileBuilder(rB3WallFrame)

    .withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rB3WallTile);

//left building 4 wall
Frame lB4WallFrame = new FrameBuilder(getSubImage(2, 11))
.withScale(tileScale)

.build();

MapTileBuilder lB4WallTile = new MapTileBuilder(lB4WallFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lB4WallTile);

//building 4 wall
Frame b4WallFrame = new FrameBuilder(getSubImage(2, 12))
.withScale(tileScale)

.build();

MapTileBuilder b4WallTile = new MapTileBuilder(b4WallFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(b4WallTile);


//right building 4 wall
Frame rB4WallFrame = new FrameBuilder(getSubImage(2, 13))
.withScale(tileScale)

.build();

MapTileBuilder rB4WallTile = new MapTileBuilder(rB4WallFrame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rB4WallTile);

//roof 2
Frame r2Frame = new FrameBuilder(getSubImage(2, 14))
.withScale(tileScale)

.build();

MapTileBuilder r2Tile = new MapTileBuilder(r2Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(r2Tile);

//roof 3
Frame r3Frame = new FrameBuilder(getSubImage(2, 15))
.withScale(tileScale)

.build();

MapTileBuilder r3Tile = new MapTileBuilder(r3Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(r3Tile);

//butcher sign 1
Frame butcherSign1Frame = new FrameBuilder(getSubImage(2, 16))
.withScale(tileScale)

.build();

MapTileBuilder butcherSign1Tile = new MapTileBuilder(outsideButcherWallOneFrame)
.withTopLayer(butcherSign1Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(butcherSign1Tile);

//butcher sign 2
Frame butcherSign2Frame = new FrameBuilder(getSubImage(2, 17))
.withScale(tileScale)

.build();

MapTileBuilder butcherSign2Tile = new MapTileBuilder(outsideButcherWallOneFrame)
.withTopLayer(butcherSign2Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(butcherSign2Tile);

//butcher sign 3
Frame butcherSign3Frame = new FrameBuilder(getSubImage(2, 18))
.withScale(tileScale)

.build();

MapTileBuilder butcherSign3Tile = new MapTileBuilder(outsideButcherWallOneFrame)
.withTopLayer(butcherSign3Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(butcherSign3Tile);


//butcher sign 4
Frame butcherSign4Frame = new FrameBuilder(getSubImage(2, 19))
.withScale(tileScale)

.build();

MapTileBuilder butcherSign4Tile = new MapTileBuilder(outsideButcherWallOneFrame)
.withTopLayer(butcherSign4Frame)

.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(butcherSign4Tile);

//random door part 1
Frame randD1Frame = new FrameBuilder(getSubImage(3, 10))
.withScale(tileScale)

.build();

MapTileBuilder randD1Tile = new MapTileBuilder(randD1Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randD1Tile);

//random door part  2
Frame randD2Frame = new FrameBuilder(getSubImage(3, 11))
.withScale(tileScale)

.build();

MapTileBuilder randD2Tile = new MapTileBuilder(randD2Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randD2Tile);

//random door right
Frame rRandDoorFrame = new FrameBuilder(getSubImage(3, 11))
.withScale(tileScale)
.withImageEffect(ImageEffect.FLIP_HORIZONTAL)

.build();

MapTileBuilder rRandDoorTile = new MapTileBuilder(rRandDoorFrame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rRandDoorTile);



//random door part 3
Frame randD3Frame = new FrameBuilder(getSubImage(3, 12))
.withScale(tileScale)

.build();

MapTileBuilder randD3Tile = new MapTileBuilder(randD3Frame)


.withTileType(TileType.PASSABLE);

mapTiles.add(randD3Tile);

//left bar wall
Frame lBarWallFrame = new FrameBuilder(getSubImage(3, 13))
.withScale(tileScale)

.build();

MapTileBuilder lBarWallTile = new MapTileBuilder(lBarWallFrame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lBarWallTile);

//bar wall
Frame barWallFrame = new FrameBuilder(getSubImage(3, 14))
.withScale(tileScale)

.build();

MapTileBuilder barWallTile = new MapTileBuilder(barWallFrame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(barWallTile);

//right bar wall
Frame rBarWallFrame = new FrameBuilder(getSubImage(3, 15))
.withScale(tileScale)

.build();

MapTileBuilder rBarWallTile = new MapTileBuilder(rBarWallFrame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rBarWallTile);

//random window part 1
Frame randW1Frame = new FrameBuilder(getSubImage(3, 16))
.withScale(tileScale)

.build();

MapTileBuilder randW1Tile = new MapTileBuilder(randW1Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randW1Tile);

//random window part 2
Frame randW2Frame = new FrameBuilder(getSubImage(3, 17))
.withScale(tileScale)

.build();

MapTileBuilder randW2Tile = new MapTileBuilder(randW2Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randW2Tile);

//random window part 3
Frame randW3Frame = new FrameBuilder(getSubImage(3, 18))
.withScale(tileScale)

.build();

MapTileBuilder randW3Tile = new MapTileBuilder(randW3Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randW3Tile);

//random window part 4
Frame randW4Frame = new FrameBuilder(getSubImage(3, 19))
.withScale(tileScale)

.build();

MapTileBuilder randW4Tile = new MapTileBuilder(randW4Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randW4Tile);

//random window part 5
Frame randW5Frame = new FrameBuilder(getSubImage(4, 10))
.withScale(tileScale)

.build();

MapTileBuilder randW5Tile = new MapTileBuilder(randW5Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randW5Tile);

//random window part 6
Frame randW6Frame = new FrameBuilder(getSubImage(4, 11))
.withScale(tileScale)

.build();

MapTileBuilder randW6Tile = new MapTileBuilder(randW6Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(randW6Tile);

//fancy window on diff building part 1
Frame fancyWindow1Frame = new FrameBuilder(getSubImage(7, 8))
.withScale(tileScale)

.build();

MapTileBuilder fancyWindow1Tile = new MapTileBuilder(b3WallFrame)
.withTopLayer(fancyWindow1Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(fancyWindow1Tile);

//fancy window on diff building part 2
Frame fancyWindow2Frame = new FrameBuilder(getSubImage(7, 9))
.withScale(tileScale)

.build();

MapTileBuilder fancyWindow2Tile = new MapTileBuilder(b3WallFrame)
.withTopLayer(fancyWindow2Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(fancyWindow2Tile);

//fancy window on diff building part 3
Frame fancyWindow3Frame = new FrameBuilder(getSubImage(8, 0))
.withScale(tileScale)

.build();

MapTileBuilder fancyWindow3Tile = new MapTileBuilder(b3WallFrame)
.withTopLayer(fancyWindow3Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(fancyWindow3Tile);

//fancy window on diff building part 4
Frame fancyWindow4Frame = new FrameBuilder(getSubImage(8, 1))
.withScale(tileScale)

.build();

MapTileBuilder fancyWindow4Tile = new MapTileBuilder(b3WallFrame)
.withTopLayer(fancyWindow4Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(fancyWindow4Tile);

//house window on building 2 wall part 1
Frame hWindow1Frame = new FrameBuilder(getSubImage(4, 9))
.withScale(tileScale)

.build();

MapTileBuilder hWindow1Tile = new MapTileBuilder(b2WallFrame)
.withTopLayer(hWindow1Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(hWindow1Tile);

//house window on building 2 wall part 2
Frame hWindow2Frame = new FrameBuilder(getSubImage(5, 0))
.withScale(tileScale)

.build();

MapTileBuilder hWindow2Tile = new MapTileBuilder(b2WallFrame)
.withTopLayer(hWindow2Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(hWindow2Tile);

//house window on building 2 wall part 3
Frame hWindow3Frame = new FrameBuilder(getSubImage(5, 1))
.withScale(tileScale)

.build();

MapTileBuilder hWindow3Tile = new MapTileBuilder(b2WallFrame)
.withTopLayer(hWindow3Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(hWindow3Tile);

//house window on building 2 wall part 4
Frame hWindow4Frame = new FrameBuilder(getSubImage(5, 2))
.withScale(tileScale)

.build();

MapTileBuilder hWindow4Tile = new MapTileBuilder(b2WallFrame)
.withTopLayer(hWindow4Frame)


.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(hWindow4Tile);

//left bar sign 
Frame lBarSignFrame = new FrameBuilder(getSubImage(4, 12))
.withScale(tileScale)

.build();

MapTileBuilder lBarSignTile = new MapTileBuilder(barWallFrame)
.withTopLayer(lBarSignFrame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(lBarSignTile);

//bar sign 
Frame barSignFrame = new FrameBuilder(getSubImage(4, 13))
.withScale(tileScale)

.build();

MapTileBuilder barSignTile = new MapTileBuilder(barWallFrame)
.withTopLayer(barSignFrame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(barSignTile);

//right bar sign 
Frame rBarSignFrame = new FrameBuilder(getSubImage(4, 14))
.withScale(tileScale)

.build();

MapTileBuilder rBarSignTile = new MapTileBuilder(barWallFrame)
.withTopLayer(rBarSignFrame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(rBarSignTile);

//top neon sign 
Frame topNeonSignFrame = new FrameBuilder(getSubImage(4, 15))
.withScale(tileScale)

.build();

MapTileBuilder topNeonSignTile = new MapTileBuilder(barWallFrame)
.withTopLayer(topNeonSignFrame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(topNeonSignTile);

//bottom neon sign 
Frame btmNeonSignFrame = new FrameBuilder(getSubImage(4, 16))
.withScale(tileScale)

.build();

MapTileBuilder btmNeonSignTile = new MapTileBuilder(barWallFrame)
.withTopLayer(btmNeonSignFrame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(btmNeonSignTile);

//decoder clue 1_1 
Frame clue1_1Frame = new FrameBuilder(getSubImage(4, 17))
.withScale(tileScale)

.build();

MapTileBuilder clue1_1Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue1_1Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue1_1Tile);

//decoder clue 1_2 
Frame clue1_2Frame = new FrameBuilder(getSubImage(4, 18))
.withScale(tileScale)

.build();

MapTileBuilder clue1_2Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue1_2Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue1_2Tile);

//decoder clue 2_1 
Frame clue2_1Frame = new FrameBuilder(getSubImage(5, 15))
.withScale(tileScale)

.build();

MapTileBuilder clue2_1Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue2_1Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue2_1Tile);

//decoder clue 2_2 
Frame clue2_2Frame = new FrameBuilder(getSubImage(6, 15))
.withScale(tileScale)

.build();

MapTileBuilder clue2_2Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue2_2Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue2_2Tile);

//decoder clue 2_3 
Frame clue2_3Frame = new FrameBuilder(getSubImage(5, 16))
.withScale(tileScale)

.build();

MapTileBuilder clue2_3Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue2_3Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue2_3Tile);

//decoder clue 2_4
Frame clue2_4Frame = new FrameBuilder(getSubImage(6, 16))
.withScale(tileScale)

.build();

MapTileBuilder clue2_4Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue2_4Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue2_4Tile);

//decoder clue 3_1 
Frame clue3_1Frame = new FrameBuilder(getSubImage(4, 19))
.withScale(tileScale)

.build();

MapTileBuilder clue3_1Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue3_1Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue3_1Tile);

//decoder clue 3_2
Frame clue3_2Frame = new FrameBuilder(getSubImage(5, 19))
.withScale(tileScale)

.build();

MapTileBuilder clue3_2Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue3_2Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue3_2Tile);

//decoder clue 4_1 
Frame clue4_1Frame = new FrameBuilder(getSubImage(5, 17))
.withScale(tileScale)

.build();

MapTileBuilder clue4_1Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue4_1Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue4_1Tile);

//decoder clue 4_2
Frame clue4_2Frame = new FrameBuilder(getSubImage(5, 18))
.withScale(tileScale)

.build();

MapTileBuilder clue4_2Tile = new MapTileBuilder(barWallFrame)
.withTopLayer(clue4_2Frame)
.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(clue4_2Tile);


//FBI frame
Frame fbiFrame = new FrameBuilder(getSubImage(6, 17))
.withScale(tileScale)

.build();

MapTileBuilder fbiTile = new MapTileBuilder(fbiFrame)

.withTileType(TileType.PASSABLE);

mapTiles.add(fbiTile);

        return mapTiles;


    }
    
}
