package edu.macalester.comp127.hw2;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import comp127graphics.CanvasWindow;
import comp127graphics.Line;
import comp127graphics.Rectangle;

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

    public void run(){
        while(true) {
            resetGame();
            playGame();
        }
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
        draw();
    }

    private void playGame(){
        Scanner input = new Scanner(System.in);
        while(bubbleManager.bubblesStillExist()) {
            System.out.println("Enter an angle between 0 and 180 degrees: ");
            double angle = input.nextDouble();
            cannon.updateCannon(angle);
            System.out.println("Enter a velocity: ");
            double velocity = input.nextDouble();
            CannonBall cannonBall = new CannonBall(cannon.getX2(), cannon.getY2(), velocity, angle, getWidth(), getHeight());
            add(cannonBall);
            shoot(cannonBall);
            System.out.println("------------------------");
            remove(cannonBall);
            draw();
        }
    }

    private void shoot(CannonBall cannonBall){
        boolean ballIsInMotion = true;
        int count = 0;
        while (ballIsInMotion) {
            ballIsInMotion = cannonBall.updatePosition(0.1) && !bubbleManager.testHit(cannonBall);
            pause(10);
            draw();
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
