package edu.macalester.comp127.hw2;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

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

        // TODO: implement me.
        //        
        // You'll need to initialize ballShape.
        // Hint: Look at Ellipse's available constructors.
        //
        // You'll also need to initialize the instance variables you added above.
        //
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
     * Adds the cannonball's shape to the given canvas.
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ballShape);
    }

    /**
     * Removes the cannonball's shape from the given canvas.
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ballShape);
    }
}
