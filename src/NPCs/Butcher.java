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
                            .withBounds(12, 4, 14, 44)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(4)
                           .withBounds(12, 4, 14, 44)
                           .build()
           });
           put("BOUNCE_LEFT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0), 12)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(6, -4, 14, 14)
                    .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 1), 12)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(6, -4, 14, 14)
                    .build()
            });
            put("BOUNCE_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 12)
                        .withScale(4)
                        .withBounds(6, -5, 14, 10)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 1), 12)
                        .withScale(4)
                        .withBounds(6, -5, 14, 10)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
