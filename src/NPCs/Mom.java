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
import java.util.HashMap;

// This class is for the mom NPC
public class Mom extends NPC {
    

    public Mom(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("mom.png"), 40, 60), "BOUNCE_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(7, 1, 16, 38)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(2)
                           .withBounds(7, 1, 16, 38)
                           .build()
           });
           put("BOUNCE_LEFT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0), 8)
                    .withScale(2)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(7, 1, 16, 38)
                    .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 1), 8)
                    .withScale(2)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(7, 1, 16, 38)
                    .build()
            });
            put("BOUNCE_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 12)
                        .withScale(2)
                        .withBounds(7, 1, 16, 38)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 1), 12)
                        .withScale(2)
                        .withBounds(7, 1, 16, 38)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
