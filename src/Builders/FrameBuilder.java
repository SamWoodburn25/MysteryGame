/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Builders
 * class- FrameBuilder: a builder to instantiating a Frame class, allowing customization of frame 
 * properties such as image, delay, bounds, scale, and visual effects before construction
 */

package Builders;

import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Rectangle;

import java.awt.image.BufferedImage;

public class FrameBuilder {
    private BufferedImage image;
    private int delay;
    private Rectangle bounds;
    private float scale;
    private ImageEffect imageEffect;

    //constructor with image and delay parameters
    public FrameBuilder(BufferedImage image, int delay) {
        this.image = image;
        this.delay = delay;
        if (this.delay < 0) {
            this.delay = 0;
        }
        this.scale = 1;
        this.imageEffect = ImageEffect.NONE;
    }

    //constructor with image paramater
    public FrameBuilder(BufferedImage image) {
        this.image = image;
        this.scale = 1;
        this.imageEffect = ImageEffect.NONE;
    }

    //set frames ractangle bounds and returns this builder for further construction
    public FrameBuilder withBounds(Rectangle bounds) {
        this.bounds = bounds;
        return this;
    }

    //sets a new frame with specified dimensions, returns this builder
    public FrameBuilder withBounds(float x, float y, int width, int height) {
        this.bounds = new Rectangle(Math.round(x), Math.round(y), width, height);
        return this;
    }

    //set new scale if the current scale is non-negative, otherwise set scale to 1, returns a this builder
    public FrameBuilder withScale(float scale) {
        if (this.scale >= 0) {
            this.scale = scale;
        } else {
            this.scale = 1;
        }
        return this;
    }

    //applies a specified imageEffect to a frame, returns this builder
    public FrameBuilder withImageEffect(ImageEffect imageEffect) {
        this.imageEffect = imageEffect;
        return this;
    }

    //constructs and returns a new frame object with the configured properties
    public Frame build() {
        return new Frame(image, imageEffect, scale, bounds, delay);
    }
}