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

        MapTileBuilder blackSpotTile = new MapTileBuilder(blackSpotFrame);

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
                .withTileType(TileType.NOT_PASSABLE);

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
        Frame rightTopTreeBranchNewFrame = new FrameBuilder(getSubImage(4, 3))
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

        //left couch
        Frame leftCouchFrame = new FrameBuilder(getSubImage(6, 3))
                .withScale(tileScale)
                .build();
   
        MapTileBuilder leftCouchTile = new MapTileBuilder(floorFrame)
                .withTopLayer(leftCouchFrame)
                .withTileType(TileType.NOT_PASSABLE);
   
        mapTiles.add(leftCouchTile); 
         
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
   
        MapTileBuilder middleTreeOldTile = new MapTileBuilder(grassFrame)
                .withTopLayer(middleTreeOldFrame)
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


        return mapTiles;
    }
}
