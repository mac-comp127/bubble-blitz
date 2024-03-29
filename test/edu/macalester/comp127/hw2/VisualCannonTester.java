package edu.macalester.comp127.hw2;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Line;

import java.awt.Color;

@SuppressWarnings("WeakerAccess")
public class VisualCannonTester {

    public static final double SPEED = 100;
    public static final int WINDOW_PADDING = 30;

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Cannon Angles", 1100, 600);
        Cannon cannon = new Cannon(WINDOW_PADDING, canvas.getHeight() - WINDOW_PADDING, 0);
        canvas.add(cannon);

        for (int angle = 0; angle <= 90; angle += 5) {
            cannon.updateCannon(angle);

            double angleInDegrees = angle;
            double maxXBound = canvas.getWidth();
            double maxYBound = canvas.getHeight() - WINDOW_PADDING;

            //TODO: instantiate a CannonBall using the variables immediately above and the SPEED constant
            // CannonBall cannonBall = new CannonBall(/* add constructor parameters here */);

            //TODO: uncomment the code below
            // cannonBall.addToCanvas(canvas);
            // boolean ballIsInMotion = true;
            // while (ballIsInMotion) {
            //     double oldX = cannonBall.getCenterX();
            //     double oldY = cannonBall.getCenterY();
            //     ballIsInMotion = cannonBall.updatePosition(0.1);
            //     Line tracer = new Line(oldX, oldY, cannonBall.getCenterX(), cannonBall.getCenterY());
            //     tracer.setStrokeColor(Color.LIGHT_GRAY);
            //     canvas.add(tracer);
            //     canvas.draw();
            //     canvas.pause(5);
            // }
        }
    }
}
