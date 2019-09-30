package edu.macalester.comp127.hw2;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

/**
 * Represents a cannon ball that follows a parabolic arc based on physics equations.
 */
@SuppressWarnings("WeakerAccess")
public class CannonBall {
    public static final double GRAVITY = -9.8;
    public static final double BALL_RADIUS = 2.5;

    //TODO: Add instance variables. Remember that instance variables may or may not have corresponding constructor parameters.

    private Ellipse ballShape;

    public CannonBall(
            double centerX,
            double centerY,
            double initialSpeed,
            double initialAngle,
            double maxX,
            double maxY) {

        //TODO: implement me.
        // You'll need to appropriately call super() in the very first line.
        // Hint: Look at Ellipse's available constructors.

        // To compute the initial velocity:
        //
        //double initialAngleRadians = Math.toRadians(initialAngle);
        //initialSpeed * cos(initialAngleInRadians)   // initial x velocity
        //initialSpeed * -sin(initialAngleInRadians)  // initial y velocity
        //
        // (You'll need to figure out how to use those values.)
    }

    /**
     * Update the cannon ball's position if it is in bounds
     * @return true if the ball is in within the maxXBound and maxYBound
     */
    public boolean updatePosition(double dt) {
        //TODO: fix me
        return false;
    }

    /**
     * Adds the cannonball's image to the given canvas.
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ballShape);
    }

    /**
     * Remove the cannonball's image to the given canvas.
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ballShape);
    }
}
