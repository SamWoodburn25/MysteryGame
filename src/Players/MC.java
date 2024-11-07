package Players;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

import java.util.HashMap;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class MC extends Player {

    public MC(float x, float y, String hairType) {
        super(new SpriteSheet(ImageLoader.load(hairType), 40, 90), x, y, "STAND_FORWARD");
        //CHANGE BACK TO 2.3
        walkSpeed = 5.3f;
    }

    public void update() {
        super.update();
    }

    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_FORWARD", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(8, 45, 20, 40)
                            .build()
            });

            put("STAND_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(4, 0))
                        .withScale(2)
                        .withBounds(8, 45, 20, 40)
                        .build()
           });

           put("STAND_BACKWARD", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 0))
                        .withScale(2)
                        .withBounds(8, 45, 20, 40)
                        .build()
           });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(4, 0))
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 45, 20, 40)
                            .build()
            });

            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(5, 0), 7)
                            .withScale(2)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 1), 7)
                            .withScale(2)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 2), 7)
                            .withScale(2)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 3), 7)
                            .withScale(2)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 4), 7)
                            .withScale(2)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 5), 7)
                            .withScale(2)
                            .withBounds(8, 45, 20, 40)
                            .build()
            });

            put("WALK_BACKWARD", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(3, 0), 8)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 1), 8)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 2), 8)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 3), 8)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 4), 8)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 5), 8)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build()
                });


            put("WALK_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(5, 0), 7)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 1), 7)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 2), 7)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 3), 7)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 4), 7)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 45, 20, 40)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 5), 7)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(8, 45, 20, 40)
                            .build()
            });

            put("WALK_FORWARD", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 1), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 2), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 3), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 4), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 5), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 6), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 7), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 8), 6)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build()
                });

            put("RUN_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(5, 0), 4)
                .withScale(2)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(8, 45, 20, 40)
                .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 1), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 2), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 3), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 4), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 5), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 6), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 7), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 8), 4)
                        .withScale(2)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .withBounds(8, 45, 20, 40)
                        .build()
                });

                put("RUN_RIGHT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(5, 0), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 1), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 2), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 3), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 4), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 5), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 6), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 7), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(5, 8), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build()
                });

                put("RUN_BACKWARD", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(3, 0), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 1), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 2), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 3), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 4), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(3, 5), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build()
                });

                put("RUN_FORWARD", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 1), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 2), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 3), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 4), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 5), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 6), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 7), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 8), 4)
                                .withScale(2)
                                .withBounds(8, 45, 20, 40)
                                .build()
                });
        }};
    }
}
