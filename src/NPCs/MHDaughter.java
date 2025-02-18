package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Utils.Point;
import java.util.HashMap;

// This class is for the mom NPC
public class MHDaughter extends NPC {
    

    public MHDaughter(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("mh_daughter.png"), 32, 32), "BOUNCE_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(4)
                            .withBounds(16, -5, 14, 2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(4)
                           .withBounds(6, -5, 14, 2)
                           .build()
           });
           put("BOUNCE_LEFT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(10, 20, 10, 1)
                    .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(10, 20, 10, 1)
                    .build()
            });
            put("BOUNCE_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                        .withScale(4)
                        .withBounds(10, 20, 10, 1)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                        .withScale(4)
                        .withBounds(10, 20, 10, 1)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
