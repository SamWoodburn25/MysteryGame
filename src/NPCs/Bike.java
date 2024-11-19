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

// This class is for the ex gf NPC
public class Bike extends NPC {

    public Bike(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("bike.png"), 32, 32), "STAND_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(4, 28, 28, 2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withBounds(4, 28, 28, 2)
                           .build()
           });
           put("BOUNCE_RIGHT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0), 10)
                    .withScale(3)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(4, 28, 28, 2)
                    .build()
            });
            put("BOUNCE_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 12)
                        .withScale(3)
                        .withBounds(4, 28, 28, 2)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
