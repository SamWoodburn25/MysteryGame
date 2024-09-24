package NPCs;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Utils.Point;
//This class for mom.png
public class Mom extends NPC {

    //Constructor 
    public Mom(int id, Point location){
        super(id,location.x,location.y, new SpriteSheet(ImageLoader.load("mom.png"), 24, 24),"STAND_LEFT" );
    }
    public HashMap<String,Frame[]>loadAnimations(SpriteSheet spriteSheet){
        return new HashMap<String,Frame[]>(){{
            put("STAND_LEFT", new Frame[]{
                new FrameBuilder(spriteSheet.getSprite(0, 0))
                    .withScale(3)
                    .withBounds(7, 13, 11, 7)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build()
            });
            put("STAND_RIGHT",new Frame[]{
                new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(7,13,11,7)
                            .build()
            });
        }};
    }
    public void draw(GraphicsHandler graphicsHandler){
        super.draw(graphicsHandler);
    }
}
