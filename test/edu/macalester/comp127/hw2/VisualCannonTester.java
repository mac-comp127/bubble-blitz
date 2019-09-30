package edu.macalester.comp127.hw2;

import comp127graphics.CanvasWindow;
import comp127graphics.Line;

import java.awt.*;

@SuppressWarnings("WeakerAccess")
public class VisualCannonTester extends CanvasWindow {

    private Cannon cannon;

    public static final double SPEED = 100;
    public static final int WINDOW_PADDING = 30;

    public static void main(String[] args) {
        VisualCannonTester tester = new VisualCannonTester();
    }

    public VisualCannonTester() {
        super("Cannon Angles", 1100, 600);
        cannon = new Cannon(WINDOW_PADDING, getHeight()-WINDOW_PADDING, 0);
        add(cannon);

        for(int angle=0; angle <=90; angle+=5) {
            cannon.updateCannon(angle);

            double angleInDegrees = angle;
            double ballInitialCenterX = cannon.getX2();
            double ballInitialCenterY = cannon.getY2();
            double maxXBound = getWidth();
            double maxYBound = getHeight()-WINDOW_PADDING;

            //TODO: instantiate a CannonBall using the variables immediately above and the SPEED constant
            CannonBall cannonBall = new CannonBall(
                cannon.getX2(),
                cannon.getY2(),
                SPEED,
                angleInDegrees,
                maxXBound,
                maxYBound);

            add(cannonBall);
            boolean ballIsInMotion = true;
            while (ballIsInMotion) {
                double oldX = cannonBall.getCenterX();
                double oldY = cannonBall.getCenterY();
                ballIsInMotion = cannonBall.updatePosition(0.1);
                Line tracer = new Line(oldX, oldY, cannonBall.getCenterX(), cannonBall.getCenterY());
                tracer.setStrokeColor(Color.LIGHT_GRAY);
                add(tracer);
                draw();
                pause(10);
            }
        }
    }
}
