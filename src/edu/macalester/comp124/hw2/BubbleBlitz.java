package edu.macalester.comp124.hw2;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import comp124graphics.CanvasWindow;
import comp124graphics.Line;
import comp124graphics.Rectangle;

/**
 * The main game class to run the game popping bubbles.
 */
public class BubbleBlitz extends CanvasWindow {

    private Random random;
    private Cannon cannon;
    private BubbleManager bubbleManager;

    public static final int WINDOW_PADDING = 30;
    public static final Color SKY_COLOR = new Color(188, 217, 255);
    public static final Color GROUND_COLOR = new Color(122, 181, 107);


    public static void main(String[] args) {
        BubbleBlitz game = new BubbleBlitz();
        game.run();
    }

    public BubbleBlitz() {
        super("BubbleBlitz", 800, 600);
        random = new Random();
        bubbleManager = new BubbleManager(this);
    }

    public void run() {
        resetGame();
    }

    /**
     * Resets the canvas by removing everything and redrawing new bubbles and a new random placement for the cannon.
     */
    public void resetGame() {
        bubbleManager.removeAllBubbles();
        removeAll();
        createBackground();
        bubbleManager.generateBubbles();
        createCannon(random.nextDouble() * (getWidth() - WINDOW_PADDING) + WINDOW_PADDING, getHeight() - WINDOW_PADDING, 90);
    }

    /**
     * Creates a cannon.
     * @param centerX The anchor position of the cannon
     * @param centerY The anchor position of the cannon
     * @param angleDegrees The direction of the cannon
     */
    private void createCannon(double centerX, double centerY, double angleDegrees) {
        cannon = new Cannon(centerX, centerY, angleDegrees);
        add(cannon);
    }


    /**
     * Creates the sky and ground background
     */
    private void createBackground() {
        Rectangle sky = new Rectangle(0, 0, getWidth(), getHeight());
        sky.setFillColor(SKY_COLOR);
        sky.setFilled(true);
        add(sky);

        Rectangle ground = new Rectangle(0, getHeight()- WINDOW_PADDING, getWidth(), WINDOW_PADDING);
        ground.setFilled(true);
        ground.setFillColor(GROUND_COLOR);
        ground.setStroked(false);
        add(ground);
    }

}
