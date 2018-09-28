package edu.macalester.comp124.hw2;

import comp124graphics.Ellipse;

/**
 * Represents a cannon ball that follows a parabolic arc based on physics equations.
 */
public class CannonBall extends Ellipse {
    public static final double GRAVITY = -9.8;
    public static final double BALL_RADIUS = 2.5;

    //TODO: Add instance variables. Remember that instance variables may or may not have corresponding constructor parameters.

    public CannonBall(
            double centerX,
            double centerY,
            double initialSpeed,
            double initialAngle,
            double maxX,
            double maxY) {

        //TODO: implement me

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
    public boolean updatePosition() {
        //TODO: fix me
        return false;
    }
}
