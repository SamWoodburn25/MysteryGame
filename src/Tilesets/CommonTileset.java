package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.MapTile;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class CommonTileset extends Tileset {

    public CommonTileset() {
        super(ImageLoader.load("CommonTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // grass
        Frame grassFrame = new FrameBuilder(getSubImage(6, 0))
        .withScale(tileScale)
        .build();
  
        MapTileBuilder grassTile = new MapTileBuilder(grassFrame);
  
        mapTiles.add(grassTile);

        // walkway
        Frame walkwayFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();
        
        MapTileBuilder walkwayTile = new MapTileBuilder(walkwayFrame);

        mapTiles.add(walkwayTile);

        // lamp
        Frame lampFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder lampTile = new MapTileBuilder(lampFrame);

        mapTiles.add(lampTile);

        // wallLivingRoom
        Frame wallLivingRoomFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder wallLivingRoomTile = new MapTileBuilder(wallLivingRoomFrame);


        mapTiles.add(wallLivingRoomTile);

        // left roof complex
        Frame leftRoofComplexFrame = new FrameBuilder(getSubImage(1, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder leftRoofComplexTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftRoofComplexFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftRoofComplexTile);

        // middle roof complex
        Frame middleRoofComplexFrame = new FrameBuilder(getSubImage(1, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder middleRoofComplexTile = new MapTileBuilder(grassFrame)
                .withTopLayer(middleRoofComplexFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(middleRoofComplexTile);
        
        // middle roof complex
        Frame rightRoofComplexFrame = new FrameBuilder(getSubImage(1, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder rightRoofComplexTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightRoofComplexFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightRoofComplexTile);

        // topDoor
        Frame topDoorFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder topDoorTile = new MapTileBuilder(topDoorFrame);

        mapTiles.add(topDoorTile);

        // black spot
        Frame blackSpotFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder blackSpotTile = new MapTileBuilder(blackSpotFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(blackSpotTile);

        // dark wall
        Frame darkWallFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder darkWallTile = new MapTileBuilder(darkWallFrame);

        mapTiles.add(darkWallTile);

        // light wall
        Frame lightWallFrame = new FrameBuilder(getSubImage(2, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder lightWallTile = new MapTileBuilder(lightWallFrame);

        mapTiles.add(lightWallTile);

        // left middle door
        Frame middleLeftDoorFrame = new FrameBuilder(getSubImage(2, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder middleLeftDoorTile = new MapTileBuilder(middleLeftDoorFrame);

        mapTiles.add(middleLeftDoorTile);

        // right middle door
        Frame middleRightDoorFrame = new FrameBuilder(getSubImage(2, 3))
        .withScale(tileScale)
        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
        .build();

        MapTileBuilder middleRightDoorTile = new MapTileBuilder(middleRightDoorFrame);

        mapTiles.add(middleRightDoorTile);

        
        // left window roof complex
        Frame leftWindowRoofComplexFrame = new FrameBuilder(getSubImage(3, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder leftWindowRoofComplexTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftWindowRoofComplexFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftWindowRoofComplexTile);
        
        // right window roof complex
        Frame rightWindowRoofComplexFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();
       
        MapTileBuilder rightWindowRoofComplexTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightWindowRoofComplexFrame)
               .withTileType(TileType.PASSABLE);
       
               mapTiles.add(rightWindowRoofComplexTile);


        // gravel
        Frame gravelFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .withBounds(1, 2, 14, 14)
                .build();

        MapTileBuilder gravelTile = new MapTileBuilder(gravelFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(gravelTile);

        // bottom door
        Frame bottomDoorFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomDoorTile = new MapTileBuilder(bottomDoorFrame);

        mapTiles.add(bottomDoorTile);

        // top left tree new
        Frame leftTopTreeBranchNewFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftTopTreeBranchNewTile = new MapTileBuilder(grassFrame)
        .withTopLayer(leftTopTreeBranchNewFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(leftTopTreeBranchNewTile);
        
        // top middle tree new
        Frame middleTopTreeBranchNewFrame = new FrameBuilder(getSubImage(4, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder middleTopTreeBranchNewTile = new MapTileBuilder(grassFrame)
        .withTopLayer(middleTopTreeBranchNewFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(middleTopTreeBranchNewTile);

        // top right tree new
        Frame rightTopTreeBranchNewFrame = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder rightTopTreeBranchNewTile = new MapTileBuilder(grassFrame)
        .withTopLayer(rightTopTreeBranchNewFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(rightTopTreeBranchNewTile);
        
        // bottom tree new
        Frame bottomTreeBranchNewFrame = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomTreeBranchNewTile = new MapTileBuilder(grassFrame)
        .withTopLayer(bottomTreeBranchNewFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(bottomTreeBranchNewTile);

        // grass tile (6,0) implemented at top of class

        // sand
        Frame sandFrame = new FrameBuilder(getSubImage(6, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandTile = new MapTileBuilder(sandFrame);

        mapTiles.add(sandTile);

        // floor
        Frame floorFrame = new FrameBuilder(getSubImage(7, 2))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder floorTile = new MapTileBuilder(floorFrame);
   
        mapTiles.add(floorTile); 

        //living room wall tile
        Frame livingRoomWallFrame  = new FrameBuilder(getSubImage(6, 3))
                .withScale(tileScale)
                .build();
   
        MapTileBuilder livingRoomWallTile = new MapTileBuilder(livingRoomWallFrame);
   
        mapTiles.add(livingRoomWallTile); 
         
        // right couch
        Frame rightCouchFrame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .build();
   
        MapTileBuilder rightCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(rightCouchFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rightCouchTile);
        
        //middle Tree Old
        Frame middleTreeOldFrame = new FrameBuilder(getSubImage(7, 0))
                .withScale(tileScale)
                .build();
   
        MapTileBuilder middleTreeOldTile = new MapTileBuilder(middleTreeOldFrame)
                //.withTopLayer(middleTreeOldFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(middleTreeOldTile);
        
        //middle Tree Old
        Frame leavesTreeOldFrame = new FrameBuilder(getSubImage(7, 1))
                .withScale(tileScale)
                .build();
   
        MapTileBuilder leavesTreeOldTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leavesTreeOldFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leavesTreeOldTile);
        
        // left table
        Frame leftTableFrame = new FrameBuilder(getSubImage(7, 3))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder leftTableTile = new MapTileBuilder(darkWallFrame)
                .withTopLayer(leftTableFrame);
   
        mapTiles.add(leftTableTile);

        // right table
        Frame rightTableFrame = new FrameBuilder(getSubImage(7, 4))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder rightTableTile = new MapTileBuilder(darkWallFrame)
                .withTopLayer(rightTableFrame);
   
        mapTiles.add(rightTableTile);

        // tree trunk bottom
        Frame treeTrunkBottomOldFrame = new FrameBuilder(getSubImage(8, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder treeTrunkBottomOldTile = new MapTileBuilder(treeTrunkBottomOldFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkBottomOldTile);
       
        // mushrooms
        Frame mushroomFrame = new FrameBuilder(getSubImage(8, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder mushroomTile = new MapTileBuilder(mushroomFrame);

        mapTiles.add(mushroomTile);

        // tree trunk with full hole
        Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(8, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkWithFullHoleFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(treeTrunkWithFullHoleTile);
       
         // middle branch
        Frame middleBranchFrame = new FrameBuilder(getSubImage(8, 3))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder middleBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(middleBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(middleBranchTile);
        
        // left end branch
        Frame leftEndBranchOldFrame = new FrameBuilder(getSubImage(8, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndBranchOldTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftEndBranchOldFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftEndBranchOldTile);

        // right end branch
        Frame rightEndBranchOldFrame = new FrameBuilder(getSubImage(8, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndBranchOldTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightEndBranchOldFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightEndBranchOldTile);

        // rock
        Frame rockFrame = new FrameBuilder(getSubImage(9, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder rockTile = new MapTileBuilder(rockFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rockTile);

        // bush
        Frame bushFrame = new FrameBuilder(getSubImage(9, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bushTile = new MapTileBuilder(bushFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bushTile);

        // house body
        Frame PurpleTilingOldHouseFrame = new FrameBuilder(getSubImage(9, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder PurpleTilingOldHouseTile = new MapTileBuilder(PurpleTilingOldHouseFrame);

        mapTiles.add(PurpleTilingOldHouseTile);

        // left house roof
        Frame leftPurpleOldHouseRoofFrame = new FrameBuilder(getSubImage(10, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftPurpleOldHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftPurpleOldHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftPurpleOldHouseRoofTile);

        // right house roof
        Frame rightPurpleOldHouseRoofFrame = new FrameBuilder(getSubImage(10, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightPurpleOldHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightPurpleOldHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightPurpleOldHouseRoofTile);

        // left window
        Frame purpleLeftWindowOldHouseFrame = new FrameBuilder(getSubImage(10, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder purpleLeftWindowOldHouseTile = new MapTileBuilder(purpleLeftWindowOldHouseFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(purpleLeftWindowOldHouseTile);

        // right window
        Frame purpleRightWindowOldHouseFrame = new FrameBuilder(getSubImage(10, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder purpleRightWindowOldHouseTile = new MapTileBuilder(purpleRightWindowOldHouseFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(purpleRightWindowOldHouseTile);

        // top door
        Frame purpleTopDoorFrame = new FrameBuilder(getSubImage(10, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder purpleTopDoorTile = new MapTileBuilder(purpleTopDoorFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(purpleTopDoorTile);
        
        // bottom door
        Frame purpleBottomDoorFrame = new FrameBuilder(getSubImage(10, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder purpleBottomDoorTile = new MapTileBuilder(purpleBottomDoorFrame);
        mapTiles.add(purpleBottomDoorTile);

        // top water
        Frame[] topWaterFrames = new Frame[] {
        new FrameBuilder(getSubImage(11, 0), 65)
                .withScale(tileScale)
                .build(),
        new FrameBuilder(getSubImage(11, 1), 65)
                .withScale(tileScale)
                .build(),
        new FrameBuilder(getSubImage(11, 2), 65)
                .withScale(tileScale)
                .build(),
        new FrameBuilder(getSubImage(11, 1), 65)
                .withScale(tileScale)
                .build(),
        new FrameBuilder(getSubImage(11, 0), 65)
                .withScale(tileScale)
                .build(),
        new FrameBuilder(getSubImage(11, 3), 65)
                .withScale(tileScale)
                .build(),
        new FrameBuilder(getSubImage(11, 4), 65)
                .withScale(tileScale)
                .build(),
        new FrameBuilder(getSubImage(11, 3), 65)
                .withScale(tileScale)
                .build()
        };

        MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topWaterTile);

        // sign
        Frame signFrame = new FrameBuilder(getSubImage(9, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder signTile = new MapTileBuilder(grassFrame)
                .withTopLayer(signFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(signTile);

        // top left couch
        Frame topLeftNewCouchFrame = new FrameBuilder(getSubImage(12, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder topLeftNewCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(topLeftNewCouchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(topLeftNewCouchTile);

        // top middle couch
        Frame topMiddleNewCouchFrame = new FrameBuilder(getSubImage(12, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder topMiddleNewCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(topMiddleNewCouchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(topMiddleNewCouchTile);

        // top right couch
        Frame topRightNewCouchFrame = new FrameBuilder(getSubImage(12, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder topRightNewCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(topRightNewCouchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(topRightNewCouchTile);

        // bottom left couch
        Frame bottomLeftNewCouchFrame = new FrameBuilder(getSubImage(13, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder bottomLeftNewCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomLeftNewCouchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bottomLeftNewCouchTile);

        // bottom middle couch
        Frame bottomMiddleNewCouchFrame = new FrameBuilder(getSubImage(13, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder bottomMiddleNewCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomMiddleNewCouchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bottomMiddleNewCouchTile);

        // bottom left couch
        Frame bottomRightNewCouchFrame = new FrameBuilder(getSubImage(13, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder bottomRightNewCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomRightNewCouchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bottomRightNewCouchTile);

        // left table
        Frame leftNewTableFrame = new FrameBuilder(getSubImage(13, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder leftNewTableTile = new MapTileBuilder(darkWallFrame)
                .withTopLayer(leftNewTableFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftNewTableTile);

        // middle table
        Frame middleNewTableFrame = new FrameBuilder(getSubImage(12, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder middleNewTableTile = new MapTileBuilder(darkWallFrame)
                .withTopLayer(middleNewTableFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(middleNewTableTile);

        // right table
        Frame rightNewTableFrame = new FrameBuilder(getSubImage(12, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightNewTableTile = new MapTileBuilder(darkWallFrame)
                .withTopLayer(rightNewTableFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightNewTableTile);

        // right luggage
        Frame rightLuggageFrame = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder rightLuggageTile = new MapTileBuilder(floorFrame)
        .withTopLayer(rightLuggageFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(rightLuggageTile);

        // middle luggage
        Frame middleLuggageFrame = new FrameBuilder(getSubImage(5, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder middleLuggageTile = new MapTileBuilder(floorFrame)
        .withTopLayer(middleLuggageFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(middleLuggageTile);

        // top luggage
        Frame topLuggageFrame = new FrameBuilder(getSubImage(5, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder topLuggageTile = new MapTileBuilder(floorFrame)
        .withTopLayer(topLuggageFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(topLuggageTile);

        // bottom fridge
        Frame bottomFridgeFrame = new FrameBuilder(getSubImage(13, 3))
                .withScale(tileScale)
                //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder bottomFridgeTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomFridgeFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bottomFridgeTile);

        // middle right fridge
        Frame middleRightFridgeFrame = new FrameBuilder(getSubImage(15, 0))
                .withScale(tileScale)
                //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder middleRightFridgeTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(middleRightFridgeFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(middleRightFridgeTile);

        

       


        // top fridge
        Frame topFridgeFrame = new FrameBuilder(getSubImage(14, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder topFridgeTile = new MapTileBuilder(livingRoomWallFrame)
        .withTopLayer(topFridgeFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(topFridgeTile);

        // top left stove
        Frame topLeftStoveFrame = new FrameBuilder(getSubImage(14, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder topLeftStoveTile = new MapTileBuilder(livingRoomWallFrame)
        .withTopLayer(topLeftStoveFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(topLeftStoveTile);

        // bottom left stove
        Frame bottomLeftStoveFrame = new FrameBuilder(getSubImage(15, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomLeftStoveTile = new MapTileBuilder(livingRoomWallFrame)
        .withTopLayer(bottomLeftStoveFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(bottomLeftStoveTile);

        // top right stove
        Frame topRightStoveFrame = new FrameBuilder(getSubImage(14, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder topRightStoveTile = new MapTileBuilder(livingRoomWallFrame)
        .withTopLayer(topRightStoveFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(topRightStoveTile);

        // bottom right stove
        Frame bottomRightStoveFrame = new FrameBuilder(getSubImage(15, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomRightStoveTile = new MapTileBuilder(livingRoomWallFrame)
        .withTopLayer(bottomRightStoveFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(bottomRightStoveTile);

        // top right counter
        Frame topRightCounterFrame = new FrameBuilder(getSubImage(14, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder topRightCounterTile = new MapTileBuilder(livingRoomWallFrame)
        .withTopLayer(topRightCounterFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(topRightCounterTile);

        // bottom right counter
        Frame bottomRightCounterFrame = new FrameBuilder(getSubImage(15, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomRightCounterTile = new MapTileBuilder(floorFrame)
        .withTopLayer(bottomRightCounterFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(bottomRightCounterTile);

        // top right stove
        Frame topLeftCounterFrame = new FrameBuilder(getSubImage(14, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder topLeftCounterTile = new MapTileBuilder(livingRoomWallFrame)
        .withTopLayer(topLeftCounterFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(topLeftCounterTile);

        // bottom left counter
        Frame bottomLeftCounterFrame = new FrameBuilder(getSubImage(15, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomLeftCounterTile = new MapTileBuilder(floorFrame)
        .withTopLayer(bottomLeftCounterFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(bottomLeftCounterTile);

        // wall one butcher
        Frame wallOneButcherFrame = new FrameBuilder(getSubImage(16, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder wallOneButcherTile = new MapTileBuilder(wallOneButcherFrame);       
        mapTiles.add(wallOneButcherTile);
 
        // wall two butcher
        Frame wallTwoButcherFrame = new FrameBuilder(getSubImage(16, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder wallTwoButcherTile = new MapTileBuilder(wallTwoButcherFrame);       
        mapTiles.add(wallTwoButcherTile);

        // left top butcher table
        Frame leftTopButcherTableFrame = new FrameBuilder(getSubImage(16, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftTopButcherTableTile = new MapTileBuilder(wallTwoButcherFrame)
        .withTopLayer(leftTopButcherTableFrame)
        .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(leftTopButcherTableTile);
                
        // middle butcher table
        Frame middleButcherTableFrame = new FrameBuilder(getSubImage(16, 3))
        .withScale(tileScale)
                .build();

        MapTileBuilder middleButcherTableTile = new MapTileBuilder(wallOneButcherFrame)
        .withTopLayer(middleButcherTableFrame)
        .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(middleButcherTableTile);

        // right top butcher table
        Frame rightTopButcherTableFrame = new FrameBuilder(getSubImage(16, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder rightTopButcherTableTile = new MapTileBuilder(wallTwoButcherFrame)
        .withTopLayer(rightTopButcherTableFrame)
        .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(rightTopButcherTableTile);

        // floor butcher
        Frame floorButcherFrame = new FrameBuilder(getSubImage(17, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder floorButcherTile = new MapTileBuilder(floorButcherFrame);       
        mapTiles.add(floorButcherTile);

        // right butcher table leg
        Frame rightButcherTableLegFrame = new FrameBuilder(getSubImage(17, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder rightButcherTableLegTile = new MapTileBuilder(floorButcherFrame)
        .withTopLayer(rightButcherTableLegFrame)
        .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(rightButcherTableLegTile);

         // left butcher table leg
         Frame leftButcherTableLegFrame = new FrameBuilder(getSubImage(17, 2))
         .withScale(tileScale)
         .build();

        MapTileBuilder leftButcherTableLegTile = new MapTileBuilder(floorButcherFrame)
        .withTopLayer(leftButcherTableLegFrame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftButcherTableLegTile);

        // top pig body
        Frame topPigBodyFrame = new FrameBuilder(getSubImage(18, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder topPigBodyTile = new MapTileBuilder(wallOneButcherFrame)
        .withTopLayer(topPigBodyFrame)
        .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(topPigBodyTile);

        // middle pig body
        Frame middlePigBodyFrame = new FrameBuilder(getSubImage(17, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder middlePigBodyTile = new MapTileBuilder(wallTwoButcherFrame)
        .withTopLayer(middlePigBodyFrame)
        .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(middlePigBodyTile);

        // bottom pig body
        Frame bottomPigBodyFrame = new FrameBuilder(getSubImage(18, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomPigBodyTile = new MapTileBuilder(wallOneButcherFrame)
                .withTopLayer(bottomPigBodyFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(bottomPigBodyTile);

        // blood splatter one
        Frame bloodSplatterOneFrame = new FrameBuilder(getSubImage(18, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder bloodSplatterOneTile = new MapTileBuilder(floorButcherFrame)
        .withTopLayer(bloodSplatterOneFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(bloodSplatterOneTile);

        // blood splatter one
        Frame bloodSplatterTwoFrame = new FrameBuilder(getSubImage(18, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder bloodSplatterTwoTile = new MapTileBuilder(floorButcherFrame)
        .withTopLayer(bloodSplatterTwoFrame)
        .withTileType(TileType.PASSABLE);
       
        mapTiles.add(bloodSplatterTwoTile);

        // top door butcher
        Frame topDoorButcherFrame = new FrameBuilder(getSubImage(19, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder topDoorButcherTile = new MapTileBuilder(topDoorButcherFrame);       
        mapTiles.add(topDoorButcherTile);

        // middle door butcher
        Frame middleDoorButcherFrame = new FrameBuilder(getSubImage(19, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder middleDoorButcherTile = new MapTileBuilder(middleDoorButcherFrame);       
        mapTiles.add(middleDoorButcherTile);

        // bottom door butcher
        Frame bottomDoorButcherFrame = new FrameBuilder(getSubImage(19, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomDoorButcherTile = new MapTileBuilder(bottomDoorButcherFrame);       
        mapTiles.add(bottomDoorButcherTile);
        
        // right middle door butcher
        Frame rMiddleDoorButcherFrame = new FrameBuilder(getSubImage(19, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rMiddleDoorButcherTile = new MapTileBuilder(rMiddleDoorButcherFrame);
        mapTiles.add(rMiddleDoorButcherTile);

        // bottom door butcher
        Frame rBottomDoorButcherFrame = new FrameBuilder(getSubImage(19, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rBottomDoorButcherTile = new MapTileBuilder(rBottomDoorButcherFrame);       
        mapTiles.add(rBottomDoorButcherTile);

        // outside butcher wall 1
        Frame outsideButcherWallOneFrame = new FrameBuilder(getSubImage(18, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideButcherWallOneTile = new MapTileBuilder(outsideButcherWallOneFrame);       
        mapTiles.add(outsideButcherWallOneTile);

        // outside butcher wall 2
        Frame outsideButcherWallTwoFrame = new FrameBuilder(getSubImage(19, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideButcherWallTwoTile = new MapTileBuilder(outsideButcherWallTwoFrame);       
        mapTiles.add(outsideButcherWallTwoTile);
        
        // outside butcher wall w right window
        Frame outsideButcherWallRightWindowFrame = new FrameBuilder(getSubImage(19, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideButcherWallRightWindowTile = new MapTileBuilder(outsideButcherWallRightWindowFrame);       
        mapTiles.add(outsideButcherWallRightWindowTile);

        // bottom door butcher
        Frame outsideButcherWallLeftWindowFrame = new FrameBuilder(getSubImage(19, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder outsideButcherWallLeftWindowTile = new MapTileBuilder(outsideButcherWallLeftWindowFrame);       
        mapTiles.add(outsideButcherWallLeftWindowTile);

        // right roof butcher
        Frame rightButcherRoofFrame = new FrameBuilder(getSubImage(20, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightButcherRoofTile = new MapTileBuilder(grassFrame)
        .withTopLayer(rightButcherRoofFrame)
        .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(rightButcherRoofTile);

        // left roof butcher
        Frame leftButcherRoofFrame = new FrameBuilder(getSubImage(20, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftButcherRoofTile = new MapTileBuilder(grassFrame)
        .withTopLayer(leftButcherRoofFrame)
        .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(leftButcherRoofTile);

        // chimney roof butcher
        Frame chimneyButcherRoofFrame = new FrameBuilder(getSubImage(20, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder chimneyButcherRoofTile = new MapTileBuilder(grassFrame)
        .withTopLayer(chimneyButcherRoofFrame)
        .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(chimneyButcherRoofTile);

        // outside butcher grate left
        Frame outsideButcherGrateLeftFrame = new FrameBuilder(getSubImage(20, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideButcherGrateLeftTile = new MapTileBuilder(outsideButcherGrateLeftFrame);       
        mapTiles.add(outsideButcherGrateLeftTile);
       
        // outside butcher grate middle
        Frame outsideButcherGrateMiddleFrame = new FrameBuilder(getSubImage(20, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideButcherGrateMiddleTile = new MapTileBuilder(outsideButcherGrateMiddleFrame);       
        mapTiles.add(outsideButcherGrateMiddleTile);

        // outside butcher grate right
        Frame outsideButcherGrateRightFrame = new FrameBuilder(getSubImage(20, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideButcherGrateRightTile = new MapTileBuilder(outsideButcherGrateRightFrame);       
        mapTiles.add(outsideButcherGrateRightTile);

        // left border
        Frame leftBorderFrame = new FrameBuilder(getSubImage(21, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftBorderTile = new MapTileBuilder(leftBorderFrame);       
        mapTiles.add(leftBorderTile);

         // top border
         Frame topBorderFrame = new FrameBuilder(getSubImage(21, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder topBorderTile = new MapTileBuilder(topBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);
        
        
        mapTiles.add(topBorderTile);

         // right border
         Frame rightBorderFrame = new FrameBuilder(getSubImage(21, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder rightBorderTile = new MapTileBuilder(rightBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);
        
        
        mapTiles.add(rightBorderTile);

         // bottom border
         Frame bottomBorderFrame = new FrameBuilder(getSubImage(21, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomBorderTile = new MapTileBuilder(bottomBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bottomBorderTile);

        // left corner border
        Frame leftCornerBorderFrame = new FrameBuilder(getSubImage(21, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftCornerBorderTile = new MapTileBuilder(leftCornerBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(leftCornerBorderTile);

         //right corner border
         Frame rightCornerBorderFrame = new FrameBuilder(getSubImage(22, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder rightCornerBorderTile = new MapTileBuilder(rightCornerBorderFrame)      
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(rightCornerBorderTile);

        //bottom wall
        Frame bottomWallFrame = new FrameBuilder(getSubImage(22, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomWallTile = new MapTileBuilder(bottomWallFrame);       
        mapTiles.add(bottomWallTile);

        // nightstand
        Frame nightstandFrame = new FrameBuilder(getSubImage(17, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder nightstandTile = new MapTileBuilder(floorFrame)
                .withTopLayer(nightstandFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(nightstandTile);

        // top floor lamp
        Frame TopFloorLampFrame = new FrameBuilder(getSubImage(22, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder topFloorLampTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(TopFloorLampFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(topFloorLampTile);

        // middle floor lamp 
        Frame middleFloorLampFrame = new FrameBuilder(getSubImage(23, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder middleFloorLampTile = new MapTileBuilder(bottomWallFrame)
                .withTopLayer(middleFloorLampFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(middleFloorLampTile);

        // bottom floor lamp 
        Frame bottomFloorLampFrame = new FrameBuilder(getSubImage(24, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomFloorLampTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomFloorLampFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bottomFloorLampTile);

        // top right of book shelf
        Frame topRightShelfFrame = new FrameBuilder(getSubImage(22, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder topRightShelfTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(topRightShelfFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(topRightShelfTile);

         // top left of book shelf
        Frame topLeftShelfFrame = new FrameBuilder(getSubImage(22, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder topLeftShelfTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(topLeftShelfFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topLeftShelfTile);

         // bottom left of book shelf
         Frame bottomLeftShelfFrame = new FrameBuilder(getSubImage(23, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomLeftShelfTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomLeftShelfFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bottomLeftShelfTile);

        // bottom right of book shelf
        Frame bottomRightShelfFrame = new FrameBuilder(getSubImage(23, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomRightShelfTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomRightShelfFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(bottomRightShelfTile);


        // top left table
        Frame topLeftTableFrame = new FrameBuilder(getSubImage(23, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder topLeftTableTile = new MapTileBuilder(floorFrame)
                .withTopLayer(topLeftTableFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(topLeftTableTile);

        // top right table 
        Frame topRightTableFrame = new FrameBuilder(getSubImage(23, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder topRightTableTile = new MapTileBuilder(floorFrame)
                .withTopLayer(topRightTableFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(topRightTableTile);

        // bottom left table
        Frame bottomLeftTableFrame = new FrameBuilder(getSubImage(24, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomLeftTableTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomLeftTableFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(bottomLeftTableTile);


        // bottom right table 
        Frame bottomRightTableFrame = new FrameBuilder(getSubImage(24, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomRightTableTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomRightTableFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(bottomRightTableTile);

        //  side couch tile 1
        Frame sideCouch1Frame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder sideCouch1Tile = new MapTileBuilder(floorFrame)
                .withTopLayer(sideCouch1Frame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(sideCouch1Tile);

        // side couch tile 2
        Frame sideCouch2Frame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder sideCouch2Tile = new MapTileBuilder(floorFrame)
                .withTopLayer(sideCouch2Frame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(sideCouch2Tile);

        // side couch tile 3
        Frame sideCouch3Frame = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder sideCouch3Tile = new MapTileBuilder(floorFrame)
                .withTopLayer(sideCouch3Frame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(sideCouch3Tile);

        // side couch tile 4
        Frame sideCouch4Frame = new FrameBuilder(getSubImage(3, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder sideCouch4Tile = new MapTileBuilder(floorFrame)
                .withTopLayer(sideCouch4Frame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(sideCouch4Tile); 

        // right dinner table
        Frame rightDinnerTableFrame = new FrameBuilder(getSubImage(4, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder rightDinnerTableTile = new MapTileBuilder(floorFrame)
                .withTopLayer(rightDinnerTableFrame)
                .withTileType(TileType.NOT_PASSABLE);
       
        mapTiles.add(rightDinnerTableTile); 

         // left dinner table
         Frame leftDinnerTableFrame = new FrameBuilder(getSubImage(5, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftDinnerTableTile = new MapTileBuilder(floorFrame)
                .withTopLayer(leftDinnerTableFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftDinnerTableTile);

         // chair
         Frame livingRoomChairFrame = new FrameBuilder(getSubImage(6, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder livingRoomChairTile = new MapTileBuilder(floorFrame)
                .withTopLayer(livingRoomChairFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(livingRoomChairTile);

        // top left window
        Frame topLeftWindowFrame = new FrameBuilder(getSubImage(7, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder topLeftWindowTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(topLeftWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topLeftWindowTile);

        // bottom  left window
        Frame bottomLeftWindowFrame = new FrameBuilder(getSubImage(8, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomLeftWindowTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(bottomLeftWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bottomLeftWindowTile);

         // top right window
         Frame topRightWindowFrame = new FrameBuilder(getSubImage(9, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder topRightWindowTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(topRightWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topRightWindowTile);

        // bottom  right window
        Frame bottomRightWindowFrame = new FrameBuilder(getSubImage(10, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder bottomRightWindowTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(bottomRightWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bottomRightWindowTile);


        Frame middleLeftFridgeFrame = new FrameBuilder(getSubImage(15, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder middleLeftFridgeTile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(middleLeftFridgeFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(middleLeftFridgeTile);

        // bottom left fridge
        Frame bottomLeftFridgeFrame = new FrameBuilder(getSubImage(13, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder bottomLeftFridgeTile = new MapTileBuilder(floorFrame)
                .withTopLayer(bottomLeftFridgeFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bottomLeftFridgeTile);



        // counter 1
        Frame counter1Frame = new FrameBuilder(getSubImage(11, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter1Tile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(counter1Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter1Tile);

        // counter 2
        Frame counter2Frame = new FrameBuilder(getSubImage(12, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter2Tile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(counter2Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter2Tile);

        // counter 3
        Frame counter3Frame = new FrameBuilder(getSubImage(13, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter3Tile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(counter3Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter3Tile);

        // counter 4
        Frame counter4Frame = new FrameBuilder(getSubImage(14, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter4Tile = new MapTileBuilder(bottomWallFrame)
                .withTopLayer(counter4Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter4Tile);

        // counter 5
        Frame counter5Frame = new FrameBuilder(getSubImage(15, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter5Tile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(counter5Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter5Tile);

        // counter 6
        Frame counter6Frame = new FrameBuilder(getSubImage(16, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter6Tile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(counter6Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter6Tile);

        // counter 7
        Frame counter7Frame = new FrameBuilder(getSubImage(17, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter7Tile = new MapTileBuilder(floorFrame)
                .withTopLayer(counter7Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter7Tile);
        
        // counter 8
        Frame counter8Frame = new FrameBuilder(getSubImage(18, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter8Tile = new MapTileBuilder(floorFrame)
                .withTopLayer(counter8Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter8Tile);

        // counter 9
        Frame counter9Frame = new FrameBuilder(getSubImage(19, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder counter9Tile = new MapTileBuilder(floorFrame)
                .withTopLayer(counter9Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter9Tile);

        // counter 10
        Frame counter10Frame = new FrameBuilder(getSubImage(13, 5))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder counter10Tile = new MapTileBuilder(livingRoomWallFrame)
                .withTopLayer(counter10Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(counter10Tile);



        



         

         
















        return mapTiles;
    }
}
