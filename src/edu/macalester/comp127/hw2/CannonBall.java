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

    // This solution keeps centerX and centerY as instance variables.
    // Solutions could also choose to derive them from the Ellipse’s x and y properties.
    private double centerX, centerY, dx, dy, maxX, maxY;

    private Ellipse ballShape;

    public CannonBall(
            double centerX,
            double centerY,
            double initialSpeed,
            double initialAngle,
            double maxX,
            double maxY) {

        // In this solution, updateEllipsePosition() sets x & y below,
        // but it’s also fine to do the center → upper left math in the constructor call right here:
        ballShape = new Ellipse(0, 0, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ballShape.setFilled(true);

        this.centerX = centerX;
        this.centerY = centerY;
        updateEllipsePosition();

        this.maxX = maxX;
        this.maxY = maxY;

        double initialAngleInRadians = Math.toRadians(initialAngle);
        dx = initialSpeed * Math.cos(initialAngleInRadians);
        dy = initialSpeed * -Math.sin(initialAngleInRadians);
    }

    /**
     * The cannonball’s center on the screen.
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * The cannonball’s center on the screen.
     */
    public double getCenterY() {
        return centerY;
    }

    /**
     * Update the cannon ball's position if it is in bounds
     * @return true if the ball is in within the maxXBound and maxYBound
     */
    public boolean updatePosition(double dt) {
        double newX = centerX + dx * dt,
               newY = centerY + dy * dt;
        if(newX >= 0 && newX <= maxX && newY >= 0 && newY <= maxY) {
            centerX = newX;
            centerY = newY;
            dy -= GRAVITY * dt;
            updateEllipsePosition();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the Ellipse’s position on the screen to reflect centerX and centerY, so that the
     * graphical position of the ball matches the physics position.
     */
    private void updateEllipsePosition() {
        ballShape.setCenter(centerX, centerY);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ballShape);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ballShape);
    }
}
