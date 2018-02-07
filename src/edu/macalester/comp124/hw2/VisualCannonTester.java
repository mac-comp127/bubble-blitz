package edu.macalester.comp124.hw2;

import comp124graphics.CanvasWindow;
import comp124graphics.Line;

import java.awt.*;

public class VisualCannonTester extends CanvasWindow {

    private Cannon cannon;

    public static final double VELOCITY = 100;
    public static final int WINDOW_PADDING = 30;

    public static void main(String[] args){
        VisualCannonTester tester = new VisualCannonTester();
    }

    public VisualCannonTester(){
        super("Cannon Angles", 1100, 600);
        cannon = new Cannon(WINDOW_PADDING, getHeight()-WINDOW_PADDING, 0);
        add(cannon);

        for(int angle=0; angle <=90; angle+=5){
            cannon.updateCannon(angle);

            double angleInDegrees = angle;
            double ballInitialCenterX = cannon.getX2();
            double ballInitialCenterY = cannon.getY2();
            double maxXBound = getWidth();
            double maxYBound = getHeight()-WINDOW_PADDING;

            //TODO: initialize an instance of your cannon ball using the values above and the initial VELOCITY
            CannonBall cannonBall = null; // FIXME

            add(cannonBall);
            boolean ballIsInMotion = true;
            while (ballIsInMotion) {
                double oldX = cannonBall.getX();
                double oldY = cannonBall.getY();
                ballIsInMotion = cannonBall.updatePosition();
                Line tracer = new Line(oldX, oldY, cannonBall.getX(), cannonBall.getY());
                tracer.setStrokeColor(Color.LIGHT_GRAY);
                add(tracer);
                pause(10);
            }
        }
    }
}
