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



public class CemeteryTileset extends Tileset{

    public CemeteryTileset() {
                super(ImageLoader.load("CemeteryTileset.png"), 16, 16, 3);
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

         //stone path
         Frame pathFrame = new FrameBuilder(getSubImage(3, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder pathTile = new MapTileBuilder(pathFrame);

        mapTiles.add(pathTile);

        //filler tile 
        Frame dirtFrame = new FrameBuilder(getSubImage(3, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder dirtTile = new MapTileBuilder(dirtFrame);

        mapTiles.add(dirtTile);


        //top fence for cemetery
        Frame topFenceFrame = new FrameBuilder(getSubImage(0, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder topFenceTile = new MapTileBuilder(topFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topFenceTile);

        //right top fence w pole thing for cemetary 
        Frame rTopFenceFrame = new FrameBuilder(getSubImage(0, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder rTopFenceTile = new MapTileBuilder(rTopFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopFenceTile);

        //bottom fence 
        Frame btmFenceFrame = new FrameBuilder(getSubImage(0, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder btmFenceTile = new MapTileBuilder(btmFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(btmFenceTile);

        //bottom right fence w pole thing for cemetary 
        Frame rBtmFenceFrame = new FrameBuilder(getSubImage(0, 4))
            .withScale(tileScale)
            .build();

        MapTileBuilder rBtmFenceTile = new MapTileBuilder(rBtmFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rBtmFenceTile);

        //left top fence w pole thing for cemetary 
        Frame lTopFenceFrame = new FrameBuilder(getSubImage(0, 2))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder lTopFenceTile = new MapTileBuilder(lTopFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lTopFenceTile);

        //bottom left fence w pole thing for cemetary 
        Frame lBtmFenceFrame = new FrameBuilder(getSubImage(0, 4))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder lBtmFenceTile = new MapTileBuilder(lBtmFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lBtmFenceTile);

        //right top of side fence
        Frame rTopSideFenceFrame = new FrameBuilder(getSubImage(0, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder rTopSideFenceTile = new MapTileBuilder(rTopSideFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopSideFenceTile);

        //right bottom of side fence
        Frame rBtmSideFenceFrame = new FrameBuilder(getSubImage(0, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder rBtmSideFenceTile = new MapTileBuilder(rBtmSideFenceFrame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rBtmSideFenceTile);

        //left top of side fence
        Frame lTopSideFenceFrame = new FrameBuilder(getSubImage(0, 5))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder lTopSideFenceTile = new MapTileBuilder(lTopSideFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lTopSideFenceTile);

        //left bottom of side fence
        Frame lBtmSideFenceFrame = new FrameBuilder(getSubImage(0, 6))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder lBtmSideFenceTile = new MapTileBuilder(lBtmSideFenceFrame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lBtmSideFenceTile);


        //left top tombstone 1
        Frame lTopT1Frame = new FrameBuilder(getSubImage(0, 7))
            .withScale(tileScale)

            .build();

        MapTileBuilder lTopT1Tile = new MapTileBuilder(lTopT1Frame)
            
            

            .withTileType(TileType.NOT_PASSABLE);
            


        mapTiles.add(lTopT1Tile);


        

        //right top tombstone 1
        Frame rTopT1Frame = new FrameBuilder(getSubImage(0, 8))
            .withScale(tileScale)

            .build();

        MapTileBuilder rTopT1Tile = new MapTileBuilder(rTopT1Frame)
          

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopT1Tile);

        //left bottom tombstone 1
        Frame lBtmT1Frame = new FrameBuilder(getSubImage(0, 9))
            .withScale(tileScale)

            .build();

        MapTileBuilder lBtmT1Tile = new MapTileBuilder(lBtmT1Frame)

            .withTileType(TileType.PASSABLE);

        mapTiles.add(lBtmT1Tile);

        //right bottom tombstone 1
        Frame rBtmT1Frame = new FrameBuilder(getSubImage(1, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder rBtmT1Tile = new MapTileBuilder(rBtmT1Frame)

            .withTileType(TileType.PASSABLE);

        mapTiles.add(rBtmT1Tile);

        //left top tombstone 2
        Frame lTopT2Frame = new FrameBuilder(getSubImage(1, 1))
            .withScale(tileScale)

            .build();

        MapTileBuilder lTopT2Tile = new MapTileBuilder(lTopT2Frame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lTopT2Tile);

        //right top tombstone 2
        Frame rTopT2Frame = new FrameBuilder(getSubImage(1, 2))
            .withScale(tileScale)

            .build();

        MapTileBuilder rTopT2Tile = new MapTileBuilder(rTopT2Frame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopT2Tile);

        //left bottom tombstone 2
        Frame lBtmT2Frame = new FrameBuilder(getSubImage(1, 3))
            .withScale(tileScale)

            .build();

        MapTileBuilder lBtmT2Tile = new MapTileBuilder(lBtmT2Frame)

            .withTileType(TileType.PASSABLE);

        mapTiles.add(lBtmT2Tile);

        //right bottom tombstone 2
        Frame rBtmT2Frame = new FrameBuilder(getSubImage(1, 4))
            .withScale(tileScale)

            .build();

        MapTileBuilder rBtmT2Tile = new MapTileBuilder(rBtmT2Frame)

            .withTileType(TileType.PASSABLE);

        mapTiles.add(rBtmT2Tile);

        //leafless tree1
        Frame ltree1Frame = new FrameBuilder(getSubImage(1, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree1Tile = new MapTileBuilder(ltree1Frame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree1Tile);

        //leafless tree2
        Frame ltree2Frame = new FrameBuilder(getSubImage(1, 6))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree2Tile = new MapTileBuilder(ltree2Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree2Tile);

        //leafless tree3
        Frame ltree3Frame = new FrameBuilder(getSubImage(1, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree3Tile = new MapTileBuilder(ltree3Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree3Tile);

        //leafless tree4
        Frame ltree4Frame = new FrameBuilder(getSubImage(1, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree4Tile = new MapTileBuilder(ltree4Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree4Tile);


        //leafless tree5
        Frame ltree5Frame = new FrameBuilder(getSubImage(1, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree5Tile = new MapTileBuilder(ltree5Frame)
           
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree5Tile);

        //leafless tree6
        Frame ltree6Frame = new FrameBuilder(getSubImage(2, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree6Tile = new MapTileBuilder(ltree6Frame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree6Tile);

        //leafless tree7
        Frame ltree7Frame = new FrameBuilder(getSubImage(2, 1))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree7Tile = new MapTileBuilder(ltree7Frame)
            
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree7Tile);

        //leafless tree8
         Frame ltree8Frame = new FrameBuilder(getSubImage(2, 2))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree8Tile = new MapTileBuilder(ltree8Frame)
       
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree8Tile);

        //leafless tree9
        Frame ltree9Frame = new FrameBuilder(getSubImage(2, 3))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree9Tile = new MapTileBuilder(ltree9Frame)
       
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree9Tile);

       //leafless tree10
        Frame ltree10Frame = new FrameBuilder(getSubImage(2, 4))
            .withScale(tileScale)
            .build();

         MapTileBuilder ltree10Tile = new MapTileBuilder(ltree10Frame)
      
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree10Tile);

      //leafless tree11
        Frame ltree11Frame = new FrameBuilder(getSubImage(2, 5))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree11Tile = new MapTileBuilder(ltree11Frame)
   
            .withTileType(TileType.NOT_PASSABLE);

     mapTiles.add(ltree11Tile);

     //leafless tree12
        Frame ltree12Frame = new FrameBuilder(getSubImage(2, 6))
            .withScale(tileScale)
            .build();  

        MapTileBuilder ltree12Tile = new MapTileBuilder(ltree12Frame)
     
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree12Tile);

    //leafless tree13
        Frame ltree13Frame = new FrameBuilder(getSubImage(2, 7))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree13Tile = new MapTileBuilder(ltree13Frame)
   
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree13Tile);

        //leafless tree14
        Frame ltree14Frame = new FrameBuilder(getSubImage(2, 8))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree14Tile = new MapTileBuilder(ltree14Frame)
        
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree14Tile);

        //leafless tree15
        Frame ltree15Frame = new FrameBuilder(getSubImage(2, 9))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree15Tile = new MapTileBuilder(ltree15Frame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree15Tile);

        //leafless tree16
        Frame ltree16Frame = new FrameBuilder(getSubImage(3, 0))
            .withScale(tileScale)
            .build();

        MapTileBuilder ltree16Tile = new MapTileBuilder(ltree16Frame)

            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(ltree16Tile);

        //left border dirt path 
        Frame lDirtBorderFrame = new FrameBuilder(getSubImage(3,3))
            .withScale(tileScale)
            .build();

        MapTileBuilder lDirtBorderTile = new MapTileBuilder(lDirtBorderFrame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(lDirtBorderTile);

         //right border dirt path 
         Frame rDirtBorderFrame = new FrameBuilder(getSubImage(3,4))
            .withScale(tileScale)
            .build();

        MapTileBuilder rDirtBorderTile = new MapTileBuilder(rDirtBorderFrame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(rDirtBorderTile);

        //top border dirt path 
        Frame topDirtBorderFrame = new FrameBuilder(getSubImage(3,5))
            .withScale(tileScale)
            .build();

        MapTileBuilder topDirtBorderTile = new MapTileBuilder(topDirtBorderFrame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(topDirtBorderTile);

        //bottom border dirt path 
        Frame btmDirtBorderFrame = new FrameBuilder(getSubImage(3,6))
            .withScale(tileScale)
            .build();
    
        MapTileBuilder btmDirtBorderTile = new MapTileBuilder(btmDirtBorderFrame)
            .withTileType(TileType.PASSABLE);
    
        mapTiles.add(btmDirtBorderTile);

        //left bottom corner border dirt path 
        Frame lBtmDirtCornerFrame = new FrameBuilder(getSubImage(3,7))
            .withScale(tileScale)
            .build();
    
        MapTileBuilder lBtmDirtCornerTile = new MapTileBuilder(lBtmDirtCornerFrame)
            .withTileType(TileType.PASSABLE);
    
        mapTiles.add(lBtmDirtCornerTile);

        //right bottom corner border dirt path 
        Frame rBtmDirtCornerFrame = new FrameBuilder(getSubImage(3,8))
            .withScale(tileScale)
            .build();
       
        MapTileBuilder rBtmDirtCornerTile = new MapTileBuilder(rBtmDirtCornerFrame)
            .withTileType(TileType.PASSABLE);
       
        mapTiles.add(rBtmDirtCornerTile);

        //left top corner border dirt path 
        Frame lTopDirtCornerFrame = new FrameBuilder(getSubImage(3,9))
            .withScale(tileScale)
            .build();
       
        MapTileBuilder lTopDirtCornerTile = new MapTileBuilder(lTopDirtCornerFrame)
            .withTileType(TileType.PASSABLE);
       
        mapTiles.add(lTopDirtCornerTile);

        //right top corner border dirt path 
        Frame rTopDirtCornerFrame = new FrameBuilder(getSubImage(4,0))
            .withScale(tileScale)
            .build();
       
        MapTileBuilder rTopDirtCornerTile = new MapTileBuilder(rTopDirtCornerFrame)
            .withTileType(TileType.PASSABLE);
       
        mapTiles.add(rTopDirtCornerTile);

         //tombstone 3
         Frame t3Frame = new FrameBuilder(getSubImage(4,1))
            .withScale(tileScale)
            .build();
        
        MapTileBuilder t3Tile = new MapTileBuilder(t3Frame)
            .withTileType(TileType.NOT_PASSABLE);
    
        mapTiles.add(t3Tile);

           // blinking eyes
            Frame[] blinkingEyesFrames = new Frame[] {
            new FrameBuilder(getSubImage(0, 0), 80)
                .withScale(tileScale)
                .build(),
            new FrameBuilder(getSubImage(4, 3), 60)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(4, 2), 60)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(4, 3), 60)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(0,0), 60)
                    .withScale(tileScale)
                    .build()
    };

         MapTileBuilder blinkingEyesTile = new MapTileBuilder(blinkingEyesFrames)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(blinkingEyesTile);

        //left top tombstone 4
         Frame lTopT4Frame = new FrameBuilder(getSubImage(4,4))
            .withScale(tileScale)
            .build();
        
        MapTileBuilder lTopT4Tile = new MapTileBuilder(lTopT4Frame)
            .withTileType(TileType.NOT_PASSABLE);
    
        mapTiles.add(lTopT4Tile);

        //right top tombstone 4
        Frame rTopT4Frame = new FrameBuilder(getSubImage(4,4))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();
    
        MapTileBuilder rTopT4Tile = new MapTileBuilder(rTopT4Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopT4Tile);

        //left bottom tombstone 4
        Frame lBtmT4Frame = new FrameBuilder(getSubImage(4,5))
            .withScale(tileScale)
            .build();
    
        MapTileBuilder lBtmT4Tile = new MapTileBuilder(lBtmT4Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(lBtmT4Tile);

        //right bottom tombstone 4
        Frame rBtmT4Frame = new FrameBuilder(getSubImage(4,5))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();
    
        MapTileBuilder rBtmT4Tile = new MapTileBuilder(rBtmT4Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(rBtmT4Tile);

        // left top tombstone 5
        Frame lTopT5Frame = new FrameBuilder(getSubImage(4,6))
            .withScale(tileScale)
            .build();
    
        MapTileBuilder lTopT5Tile = new MapTileBuilder(lTopT5Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lTopT5Tile);

         // right top tombstone 5
         Frame rTopT5Frame = new FrameBuilder(getSubImage(4,6))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();
 
        MapTileBuilder rTopT5Tile = new MapTileBuilder(rTopT5Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopT5Tile);

        //left bottom tombstone 5
        Frame lBtmT5Frame = new FrameBuilder(getSubImage(4,7))
            .withScale(tileScale)
            .build();
    
        MapTileBuilder lBtmT5Tile = new MapTileBuilder(lBtmT5Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(lBtmT5Tile);

         //right bottom tombstone 5
         Frame rBtmT5Frame = new FrameBuilder(getSubImage(4,7))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();
    
        MapTileBuilder rBtmT5Tile = new MapTileBuilder(rBtmT5Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(rBtmT5Tile);
        
        
        // left top tombstone 6
        Frame lTopT6Frame = new FrameBuilder(getSubImage(4,8))
            .withScale(tileScale)
            .build();
    
        MapTileBuilder lTopT6Tile = new MapTileBuilder(lTopT6Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lTopT6Tile);

         // right top tombstone 6
         Frame rTopT6Frame = new FrameBuilder(getSubImage(4,8))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();
 
        MapTileBuilder rTopT6Tile = new MapTileBuilder(rTopT6Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopT6Tile);

        //left bottom tombstone 6
        Frame lBtmT6Frame = new FrameBuilder(getSubImage(4,9))
            .withScale(tileScale)
            .build();
    
        MapTileBuilder lBtmT6Tile = new MapTileBuilder(lBtmT6Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(lBtmT6Tile);

         //right bottom tombstone 6
         Frame rBtmT6Frame = new FrameBuilder(getSubImage(4,9))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();
    
        MapTileBuilder rBtmT6Tile = new MapTileBuilder(rBtmT6Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(rBtmT6Tile);
        
        
        // left top tombstone 7
        Frame lTopT7Frame = new FrameBuilder(getSubImage(5,0))
            .withScale(tileScale)
            .build();

        MapTileBuilder lTopT7Tile = new MapTileBuilder(lTopT7Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lTopT7Tile);

        // right top tombstone 7
        Frame rTopT7Frame = new FrameBuilder(getSubImage(5,0))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder rTopT7Tile = new MapTileBuilder(rTopT7Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopT7Tile);

        //left bottom tombstone 7
        Frame lBtmT7Frame = new FrameBuilder(getSubImage(5,1))
            .withScale(tileScale)
            .build();

        MapTileBuilder lBtmT7Tile = new MapTileBuilder(lBtmT7Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(lBtmT7Tile);

        //right bottom tombstone 7
        Frame rBtmT7Frame = new FrameBuilder(getSubImage(5,1))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder rBtmT7Tile = new MapTileBuilder(rBtmT7Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(rBtmT7Tile);

        //left top tombstone 8
        Frame lTopT8Frame = new FrameBuilder(getSubImage(5,2))
            .withScale(tileScale)
            .build();

        MapTileBuilder lTopT8Tile = new MapTileBuilder(lTopT8Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(lTopT8Tile);
    
        //right top tombstone 8
        Frame rTopT8Frame = new FrameBuilder(getSubImage(5,2))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();

        MapTileBuilder rTopT8Tile = new MapTileBuilder(rTopT8Frame)
            .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rTopT8Tile);

        //left bottom tombstone 8
        Frame lBtmT8Frame = new FrameBuilder(getSubImage(5,3))
            .withScale(tileScale)
            .build();

        MapTileBuilder lBtmT8Tile = new MapTileBuilder(lBtmT8Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(lBtmT8Tile);

        //right bottom tombstone 8
        Frame rBtmT8Frame = new FrameBuilder(getSubImage(5,3))
            .withScale(tileScale)
            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
            .build();
        
        MapTileBuilder rBtmT8Tile = new MapTileBuilder(rBtmT8Frame)
            .withTileType(TileType.PASSABLE);

        mapTiles.add(rBtmT8Tile);

          //left top tombstone 9
          Frame lTopT9Frame = new FrameBuilder(getSubImage(5,4))
          .withScale(tileScale)
          .build();

      MapTileBuilder lTopT9Tile = new MapTileBuilder(lTopT9Frame)
          .withTileType(TileType.PASSABLE);

      mapTiles.add(lTopT9Tile);
  
      //right top tombstone 9
      Frame rTopT9Frame = new FrameBuilder(getSubImage(5,4))
          .withScale(tileScale)
          .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
          .build();

      MapTileBuilder rTopT9Tile = new MapTileBuilder(rTopT9Frame)
          .withTileType(TileType.NOT_PASSABLE);

      mapTiles.add(rTopT9Tile);

      //left bottom tombstone 9
      Frame lBtmT9Frame = new FrameBuilder(getSubImage(5,5))
          .withScale(tileScale)
          .build();

      MapTileBuilder lBtmT9Tile = new MapTileBuilder(lBtmT9Frame)
          .withTileType(TileType.PASSABLE);

      mapTiles.add(lBtmT9Tile);

      //right bottom tombstone 9
      Frame rBtmT9Frame = new FrameBuilder(getSubImage(5,5))
          .withScale(tileScale)
          .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
          .build();
      
      MapTileBuilder rBtmT9Tile = new MapTileBuilder(rBtmT9Frame)
          .withTileType(TileType.PASSABLE);

      mapTiles.add(rBtmT9Tile);




        

        
    
    


        

                
                
        return mapTiles;


    }
}
