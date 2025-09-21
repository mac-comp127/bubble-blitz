package edu.macalester.comp127.hw2;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

/**
 * Represents a bubble that could be popped by a CannonBall.
 */
public class Bubble {
    public static final int NUM_LAYERS = 5;
    public static final Color BUBBLE_COLOR = new Color(201, 150, 216, 55);

    private final GraphicsGroup graphics;
    private double centerX;
    private double centerY;
    private double radius;

    /**
     * Constructs a bubble centered on the centerX/Y position with the specified radius.
     */
    public Bubble(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;

        graphics = new GraphicsGroup();
        createBubbleDrawing();
        graphics.setPosition(centerX - radius, centerY - radius);
    }

    /**
     * Returns the art for this bubble.
     */
    public GraphicsGroup getGraphics() {
        return graphics;
    }

    /**
     * Create concentric ellipses to represent the bubble.
     */
    private void createBubbleDrawing() {
        double curRadius = radius;
        for (int i = 0; i < NUM_LAYERS; i++) {
            Ellipse ellipse = new Ellipse(
                radius - curRadius,
                radius - curRadius,
                2 * curRadius,
                2 * curRadius
            );
            ellipse.setFillColor(BUBBLE_COLOR);
            ellipse.setFilled(true);
            ellipse.setStroked(false);
            graphics.add(ellipse);
            curRadius -= radius / NUM_LAYERS;
        }
    }

    /**
     * Tests for intersections between the given cannon ball and this bubble.
     *
     * @return true If the given ball intersects this bubble (even tangentially).
     */
    public boolean intersects(CannonBall ball) {
        // TODO: return true if the ball is within the radius of the bubble.
        // Hint: Don't forget to take into account the ball's radius too.
        // Hint: The Math.hypot() method can help you compute the distance between two points.
        return false;
    }

    /**
     * Animates this bubble popping to nothing. This method waits until the animation finishes.
     */
    public void animatePop() {
        int animSteps = 10;
        for (int step = 0; step < animSteps; step++) {
            graphics.setScale(Math.pow(1.3, step + 1));
            graphics.getCanvas().draw();
            graphics.getCanvas().pause(16);
        }
    }
}
