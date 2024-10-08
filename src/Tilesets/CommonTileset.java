package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
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

        // sign
        Frame oldSignFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .withBounds(1, 2, 14, 14)
                .build();

        MapTileBuilder oldSignTile = new MapTileBuilder(oldSignFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldSignTile);

        // lamp
        Frame lampFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder lampTile = new MapTileBuilder(lampFrame);

        mapTiles.add(lampTile);

        // oldRock
        Frame oldRockFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldRockTile = new MapTileBuilder(oldRockFrame);
        //        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldRockTile);

        // tree trunk with full hole
        Frame oldTreeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldTreeTrunkWithFullHoleTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldTreeTrunkWithFullHoleFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldTreeTrunkWithFullHoleTile);

        // left end branch
        Frame oldLeftEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                //.withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder oldLeftEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldLeftEndBranchFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldLeftEndBranchTile);

        // right end branch
        Frame oldRightEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder oldRightEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldRightEndBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldRightEndBranchTile);
        
        // tree trunk
        Frame oldTreeTrunkFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldTreeTrunkTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldTreeTrunkFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldTreeTrunkTile);

        // tree top leaves
        Frame oldTreeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldTreeTopLeavesTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldTreeTopLeavesFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldTreeTopLeavesTile);
        
        // yellow flower
        Frame[] oldYellowFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(1, 2), 65)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(1, 3), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 4), 65)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder oldYellowFlowerTile = new MapTileBuilder(oldYellowFlowerFrames);

        mapTiles.add(oldYellowFlowerTile);

        // purple flower
        Frame[] oldPurpleFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(0, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 3), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 4), 65)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder oldPurpleFlowerTile = new MapTileBuilder(oldPurpleFlowerFrames);

        mapTiles.add(oldPurpleFlowerTile);

        // middle branch
        Frame oldMiddleBranchFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder oldMiddleBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldMiddleBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldMiddleBranchTile);

        // tree trunk bottom
        Frame oldTreeTrunkBottomFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldTreeTrunkBottomTile = new MapTileBuilder(oldTreeTrunkBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldTreeTrunkBottomTile);

        // mushrooms
        Frame oldMushroomFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldMushroomTile = new MapTileBuilder(oldMushroomFrame)
                .withTileType(TileType.NOT_PASSABLE);;

        mapTiles.add(oldMushroomTile);


        // grey rock
        Frame oldGreyRockFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldGreyRockTile = new MapTileBuilder(oldGreyRockFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldGreyRockTile);

        // bush
        Frame oldBushFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldBushTile = new MapTileBuilder(oldBushFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldBushTile);

        // house body
        Frame oldHouseBodyFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldHouseBodyTile = new MapTileBuilder(oldHouseBodyFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldHouseBodyTile);

        // house roof body
        Frame oldHouseRoofBodyFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldHouseRoofBodyTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldHouseRoofBodyFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldHouseRoofBodyTile);

        // left house roof
        Frame oldLeftHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldLeftHouseRoofTile = new MapTileBuilder(oldLeftHouseRoofFrame)
                .withTopLayer(oldLeftHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldLeftHouseRoofTile);

        // right house roof
        Frame oldRightHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder oldRightHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(oldRightHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(oldRightHouseRoofTile);

        // left window
        Frame oldLeftWindowFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldLeftWindowTile = new MapTileBuilder(oldLeftWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldLeftWindowTile);

        // right window
        Frame oldRightWindowFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder oldRightWindowTile = new MapTileBuilder(oldRightWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldRightWindowTile);

        // door
        Frame oldDoorFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder oldDoorTile = new MapTileBuilder(oldDoorFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldDoorTile);

        // top water
        Frame[] oldTopWaterFrames = new Frame[] {
            new FrameBuilder(getSubImage(5, 0), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 2), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 0), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 4), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder oldTopWaterTile = new MapTileBuilder(oldTopWaterFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(oldTopWaterTile);

        // sign
        Frame signFrame = new FrameBuilder(getSubImage(9, 0))
                .withScale(tileScale)
                .withBounds(1, 2, 14, 14)
                .build();

        MapTileBuilder signTile = new MapTileBuilder(signFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(signTile);

        // sand
        Frame sandFrame = new FrameBuilder(getSubImage(6, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandTile = new MapTileBuilder(sandFrame);

        mapTiles.add(sandTile);

        // rock
        Frame rockFrame = new FrameBuilder(getSubImage(9, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder rockTile = new MapTileBuilder(rockFrame);
        //        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rockTile);

        // tree trunk with full hole
        Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(8, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkWithFullHoleFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(treeTrunkWithFullHoleTile);

        // left end branch
        Frame leftEndBranchFrame = new FrameBuilder(getSubImage(8, 4))
                .withScale(tileScale)
                //.withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftEndBranchFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftEndBranchTile);

        // right end branch
        Frame rightEndBranchFrame = new FrameBuilder(getSubImage(8, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightEndBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightEndBranchTile);
        
        // tree trunk
        Frame treeTrunkFrame = new FrameBuilder(getSubImage(7, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(treeTrunkTile);

        // tree top leaves
        Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(7, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTopLeavesTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTopLeavesFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(treeTopLeavesTile);
        
        // leaves
        Frame leavesFrame = new FrameBuilder(getSubImage(7, 2))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder leavesTile = new MapTileBuilder(leavesFrame);
   
        mapTiles.add(leavesTile); 
         
        // floor
        Frame floorFrame = new FrameBuilder(getSubImage(7, 3))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder floorTile = new MapTileBuilder(floorFrame);
   
        mapTiles.add(floorTile); 
         
        // left table
        Frame leftTableFrame = new FrameBuilder(getSubImage(7, 4))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder leftTableTile = new MapTileBuilder(leftTableFrame);
   
        mapTiles.add(leftTableTile);
       
        // wall
        Frame wallFrame = new FrameBuilder(getSubImage(6, 2))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder wallTile = new MapTileBuilder(wallFrame);
   
        mapTiles.add(wallTile); 
         
        // left couch
        Frame leftCouchFrame = new FrameBuilder(getSubImage(6, 3))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder leftCouchTile = new MapTileBuilder(leftCouchFrame);
   
        mapTiles.add(leftCouchTile); 
         
        // right couch
        Frame rightCouchFrame = new FrameBuilder(getSubImage(6, 4))
        .withScale(tileScale)
        .build();
   
        MapTileBuilder rightCouchTile = new MapTileBuilder(rightCouchFrame);
   
        mapTiles.add(rightCouchTile);
        
        // middle branch
        Frame middleBranchFrame = new FrameBuilder(getSubImage(8, 3))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder middleBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(middleBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(middleBranchTile);

        // tree trunk bottom
        Frame treeTrunkBottomFrame = new FrameBuilder(getSubImage(8, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkBottomTile = new MapTileBuilder(treeTrunkBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkBottomTile);

        // mushrooms
        Frame mushroomFrame = new FrameBuilder(getSubImage(8, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTile = new MapTileBuilder(mushroomFrame)
                .withTileType(TileType.NOT_PASSABLE);;

        mapTiles.add(mushroomTile);


        // grey rock
        Frame greyRockFrame = new FrameBuilder(getSubImage(9, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder greyRockTile = new MapTileBuilder(greyRockFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(greyRockTile);

        // bush
        Frame bushFrame = new FrameBuilder(getSubImage(9, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bushTile = new MapTileBuilder(bushFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bushTile);

        // house body
        Frame houseBodyFrame = new FrameBuilder(getSubImage(9, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder houseBodyTile = new MapTileBuilder(houseBodyFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(houseBodyTile);

        // house roof body
        Frame houseRoofBodyFrame = new FrameBuilder(getSubImage(10, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder houseRoofBodyTile = new MapTileBuilder(grassFrame)
                .withTopLayer(houseRoofBodyFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(houseRoofBodyTile);

        // left house roof
        Frame leftHouseRoofFrame = new FrameBuilder(getSubImage(10, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftHouseRoofTile = new MapTileBuilder(leftHouseRoofFrame)
                .withTopLayer(leftHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftHouseRoofTile);

        // right house roof
        Frame rightHouseRoofFrame = new FrameBuilder(getSubImage(10, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightHouseRoofTile);

        // left window
        Frame leftWindowFrame = new FrameBuilder(getSubImage(10, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftWindowTile = new MapTileBuilder(leftWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftWindowTile);

        // right window
        Frame rightWindowFrame = new FrameBuilder(getSubImage(10, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightWindowTile = new MapTileBuilder(rightWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rightWindowTile);

        // door
        Frame doorFrame = new FrameBuilder(getSubImage(10, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder doorTile = new MapTileBuilder(doorFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(doorTile);

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
