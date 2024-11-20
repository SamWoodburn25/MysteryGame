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

// This class is for the crow NPC
public class ScaryDog extends NPC {

    public ScaryDog(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("scarydog.png"), 40, 50), "BOUNCE_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("BOUNCE_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 12)
                        .withScale(3)
                        .withBounds(4, 22, 28, 3)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 1), 12)
                        .withScale(3)
                        .withBounds(4, 22, 28, 3)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 2), 12)
                        .withScale(3)
                        .withBounds(4, 22, 28, 3)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 3), 20)
                        .withScale(3)
                        .withBounds(4, 22, 28, 3)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 4), 12)
                        .withScale(3)
                        .withBounds(4, 22, 28, 3)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 5), 12)
                        .withScale(3)
                        .withBounds(4, 22, 28, 3)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
