package edu.macalester.comp124.hw2;

import comp124graphics.Ellipse;

/**
 * Represents a cannon ball that follows a parabolic arc based on physics equations.
 */
public class CannonBall extends Ellipse {
    public static final double GRAVITY = -9.8;
    public static final double BALL_RADIUS = 2.5;

    private double x, y, dx, dy, maxX, maxY;

    public CannonBall(
            double centerX,
            double centerY,
            double initialSpeed,
            double initialAngle,
            double maxX,
            double maxY) {

        super(0, 0, BALL_RADIUS * 2, BALL_RADIUS * 2);
        setFilled(true);

        x = centerX;
        y = centerY;
        updateEllipsePosition();

        this.maxX = maxX;
        this.maxY = maxY;

        double initialAngleInRadians = Math.toRadians(initialAngle);
        dx = initialSpeed * Math.cos(initialAngleInRadians);
        dy = initialSpeed * -Math.sin(initialAngleInRadians);
    }

    public double getCenterX() {
        return x;
    }

    public double getCenterY() {
        return y;
    }

    @Override
    public double getX() {
        return x;
    }

    /**
     * Update the cannon ball's position if it is in bounds
     * @return true if the ball is in within the maxXBound and maxYBound
     */
    public boolean updatePosition(double dt) {
        double newX = x + dx * dt,
               newY = y + dy * dt;
        if(newX > 0 && newX < maxX && newY > 0 && newY < maxY) {
            x = newX;
            y = newY;
            dy -= GRAVITY * dt;
            updateEllipsePosition();
            return true;
        } else {
            return false;
        }
    }

    private void updateEllipsePosition() {
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
    }
}
