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
public class DrugDealer extends NPC {

    public DrugDealer(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("dd.png"), 40, 60), "BOUNCE_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(4, 50, 28, 2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(2)
                           .withBounds(4, 50, 28, 2)
                           .build()
           });
           put("BOUNCE_LEFT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0), 10)
                    .withScale(2)
                    .withBounds(4, 50, 28, 2)
                    .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 1), 10)
                    .withScale(2)
                    .withBounds(4, 50, 28, 2)
                    .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 2), 10)
                    .withScale(2)
                    .withBounds(4, 50, 28, 2)
                    .build()
            });
            put("BOUNCE_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                        .withScale(2)
                        .withBounds(4, 50, 28, 2)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                        .withScale(2)
                        .withBounds(4, 50, 28, 2)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                        .withScale(2)
                        .withBounds(4, 50, 28, 2)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
