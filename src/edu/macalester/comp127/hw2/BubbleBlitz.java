package edu.macalester.comp127.hw2;

import comp127graphics.CanvasWindow;
import comp127graphics.Rectangle;

import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

/**
 * The main game class to run the game popping bubbles.
 */
@SuppressWarnings("WeakerAccess")
public class BubbleBlitz {

    private Random random;
    private Cannon cannon;
    private BubbleManager bubbleManager;
    private CanvasWindow canvas;

    public static final int WINDOW_PADDING = 30;
    public static final Color SKY_COLOR = new Color(188, 217, 255);
    public static final Color GROUND_COLOR = new Color(122, 181, 107);


    public static void main(String[] args) {
        BubbleBlitz game = new BubbleBlitz();
        game.run();
    }

    public BubbleBlitz() {
        canvas = new CanvasWindow("BubbleBlitz", 800, 600);
        random = new Random();
        bubbleManager = new BubbleManager(canvas);
    }

    public void run() {
        while (true) {
            resetGame();
            playGame();
        }
    }

    /**
     * Resets the canvas by removing everything and redrawing new bubbles and a new random placement for the cannon.
     */
    public void resetGame() {
        bubbleManager.removeAllBubbles();
        canvas.removeAll();
        createBackground();
        bubbleManager.generateBubbles();
        createCannon(random.nextDouble() * (canvas.getWidth() - WINDOW_PADDING) + WINDOW_PADDING, canvas.getHeight() - WINDOW_PADDING, 90);
        canvas.draw();
    }

    private void playGame() {
        Scanner input = new Scanner(System.in);
        while (bubbleManager.bubblesStillExist()) {
            System.out.println("Enter an angle between 0 and 180 degrees: ");
            double angle = input.nextDouble();
            cannon.updateCannon(angle);
            System.out.println("Enter a velocity: ");
            double velocity = input.nextDouble();
            CannonBall cannonBall = new CannonBall(cannon.getX2(), cannon.getY2(), velocity, angle, canvas.getWidth(), canvas.getHeight());
            cannonBall.addToCanvas(canvas);
            shoot(cannonBall);
            System.out.println("------------------------");
            cannonBall.removeFromCanvas(canvas);
            canvas.draw();
        }
    }

    private void shoot(CannonBall cannonBall) {
        boolean ballIsInMotion = true;
        int count = 0;
        while (ballIsInMotion) {
            ballIsInMotion = cannonBall.updatePosition(0.1) && !bubbleManager.testHit(cannonBall);
            canvas.pause(10);
            canvas.draw();
        }
    }

    /**
     * Creates a cannon.
     * @param centerX The anchor position of the cannon
     * @param centerY The anchor position of the cannon
     * @param angleDegrees The direction of the cannon
     */
    private void createCannon(double centerX, double centerY, double angleDegrees) {
        cannon = new Cannon(centerX, centerY, angleDegrees);
        canvas.add(cannon);
    }

    /**
     * Creates the sky and ground background
     */
    private void createBackground() {
        Rectangle sky = new Rectangle(0, 0, canvas.getWidth(), canvas.getHeight());
        sky.setFillColor(SKY_COLOR);
        sky.setFilled(true);
        canvas.add(sky);

        Rectangle ground = new Rectangle(0, canvas.getHeight() - WINDOW_PADDING, canvas.getWidth(), WINDOW_PADDING);
        ground.setFilled(true);
        ground.setFillColor(GROUND_COLOR);
        ground.setStroked(false);
        canvas.add(ground);
    }

}
