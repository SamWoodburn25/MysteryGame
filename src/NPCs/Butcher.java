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
public class Butcher extends NPC {
    

    public Butcher(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("butcher_son.png"), 60, 60), "BOUNCE_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(4)
                            .withBounds(12, 20, 24, 12)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(4)
                           .withBounds(12, 20, 24, 12)
                           .build()
           });
           put("BOUNCE_LEFT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0), 12)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(12, 20, 24, 12)
                    .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 1), 12)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(12, 20, 24, 12)
                    .build()
            });
            put("BOUNCE_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 12)
                        .withScale(4)
                        .withBounds(12, 20, 24, 12)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 1), 12)
                        .withScale(4)
                        .withBounds(12, 20, 24, 12)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
