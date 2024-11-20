/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Builders
 * class- MapTileBuilder: a builder to instantiate MapTile objects, aloowing for the configuration of 
 * properties such as type, tile, and graphical layers, before constructing the final MapTile
 */


 package Builders;

 import GameObject.Frame;
 import GameObject.GameObject;
 import Level.MapTile;
 import Level.TileType;
 
 import java.util.HashMap;
 
 public class MapTileBuilder {
 
     private TileType tileType = TileType.PASSABLE;
     private int tileIndex = -1;
     private HashMap<String, Frame[]> bottomLayer = new HashMap<>();;
     private HashMap<String, Frame[]> topLayer = new HashMap<>();;
     private HashMap<String, Frame[] > midLayer = new HashMap<>();;
 
     //constructor with frame parameter
     public MapTileBuilder(Frame bottomLayer) {
         this.bottomLayer.put("DEFAULT", new Frame[] { bottomLayer });
     }
 
     //constructor with frame array parameter
     public MapTileBuilder(Frame[] bottomLayer) {
         this.bottomLayer.put("DEFAULT", bottomLayer);
     }
 
     //sets the tileType then returns this MapTileBuilder
     public MapTileBuilder withTileType(TileType tileType) {
         this.tileType = tileType;
         return this;
     }
 
     //sets the tileIndex then returns this MapTileBuilder
     public MapTileBuilder withTileIndex(int tileIndex) {
         this.tileIndex = tileIndex;
         return this;
     }
 
     //add to the bottom layer hash a new frame of the parameter with key default
     public MapTileBuilder withBottomLayer(Frame bottomLayer) {
         this.bottomLayer.put("DEFAULT", new Frame[] { bottomLayer });
         return this;
     }
 
     //add the frame[] parameter to the bottom layer hash with key default
     public MapTileBuilder withBottomLayer(Frame[] bottomLayer) {
         this.bottomLayer.put("DEFAULT", bottomLayer);
         return this;
     }
 
     //add to the bottom layer hash a new frame of the parameter with key default
     public MapTileBuilder withMidLayer(Frame midLayer) {
         this.midLayer.put("DEFAULT", new Frame[] { midLayer });
         return this;
     }
 
     //add the frame[] parameter to the bottom layer hash with key default
     public MapTileBuilder withMidLayer(Frame[] midLayer) {
         this.midLayer.put("DEFAULT", midLayer);
         return this;
     }
 
     //add to the top layer hash a new frame of the parameter with key default
     public MapTileBuilder withTopLayer(Frame topLayer) {
         this.topLayer.put("DEFAULT", new Frame[] { topLayer });
         return this;
     }
 
     //add the frame[] parameter to the top layer hash with key default
     public MapTileBuilder withTopLayer(Frame[] topLayer) {
         this.topLayer.put("DEFAULT", topLayer);
         return this;
     }
 
     //copy the animations to a new hash map and return it
     public HashMap<String, Frame[]> cloneAnimations(HashMap<String, Frame[]> animations) {
         HashMap<String, Frame[]> animationsCopy = new HashMap<>();
         for (String key : animations.keySet()) {
             Frame[] frames = animations.get(key);
             Frame[] framesCopy = new Frame[frames.length];
             for (int i = 0; i < framesCopy.length; i++) {
                 framesCopy[i] = frames[i].copy();
             }
             animationsCopy.put(key, framesCopy);
         }
         return animationsCopy;
     }
 
     //building a new map tile with game object of the bottom and top layer (if not null) and position of parameter and returns it
     public MapTile build(float x, float y) {
         GameObject bottomLayerAnimation = new GameObject(x, y, cloneAnimations(bottomLayer), "DEFAULT");
         GameObject topLayerAnimation = null;
         if (!topLayer.isEmpty()) {
             topLayerAnimation = new GameObject(x, y, cloneAnimations(topLayer), "DEFAULT");
         }
         return new MapTile(x, y, bottomLayerAnimation, topLayerAnimation, tileType, tileIndex);
     }
     
 }