package edu.macalester.comp127.hw2;

import edu.macalester.graphics.Line;
import edu.macalester.graphics.Point;

/**
 * A cannon represented as a Line graphical object pointing a specific direction based on the input angle.
 */
public class Cannon {
    public static final double CANNON_LENGTH = 25;

    private final Line line;
    private double angle;

    public Cannon(double centerX, double centerY, double angleDegrees) {
        if (angleDegrees < 0 || angleDegrees > 180) {
            throw new IllegalArgumentException("angleDegrees must be an angle between 0 and 180 degrees");
        }

        line = new Line(centerX, centerY, 0, 0);
        line.setStrokeWidth(5);
        setAngle(angleDegrees);
    }

    /**
     * Returns the visual representation of this cannon.
     */
    public Line getGraphics() {
        return line;
    }

    /**
     * Returns the position at which the cannonball comes out of the cannon.
     */
    public Point getBallExitPosition() {
        return line.getEndPosition();
    }

    /**
     * Animates the cannon rotating to the given angle
     * @param newAngle in degrees, between 0 and 180
     */
    public void rotateToAngle(double newAngle) {
        if (newAngle < 0 || newAngle > 180) {
            throw new IllegalArgumentException("angle must be between 0 and 180 degrees");
        }

        for (int i = 0; i < 20; i++) {
            double alpha = i / 20.0;
            double intermediateAngle = lerp(angle, newAngle, alpha);
            setAngle(intermediateAngle);
            line.getCanvas().draw();
            line.getCanvas().pause(10);
        }
        setAngle(newAngle);
    }

    /**
     * Instantly moves the cannon to the given angle. For internal use.
     */
    private void setAngle(double angle) {
        this.angle = angle;

        double angleInRadians = Math.toRadians(angle);
        double x2 = line.getX1() + CANNON_LENGTH * Math.cos(angleInRadians);
        double y2 = line.getY1() + CANNON_LENGTH * -Math.sin(angleInRadians);
        line.setEndPosition(x2, y2);
    }

    /**
     * Helper method to linearly interpolate between two numbers.
     * @param a starting number
     * @param b ending number
     * @param alpha 0-1 value for how far along between the starting and ending numbers
     * @return interpolated value
     */
    private double lerp(double a, double b, double alpha) {
        return a + alpha * (b - a);
    }
}
