package edu.macalester.comp124.hw2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CannonBallTest {

    @Test
    public void testBasicUpdatePosition(){
        CannonBall ball = new CannonBall(100, 100, 100, 45, 1100, 600);

        ball.updatePosition(0.1);
        assertEquals(104.571, ball.getX(), 0.001);
        assertEquals(90.4289, ball.getY(), 0.001);

        ball.updatePosition(0.1);
        assertEquals(111.642, ball.getX(), 0.001);
        assertEquals(83.4558, ball.getY(), 0.001);

        ball.updatePosition(0.1);
        assertEquals(118.713, ball.getX(), 0.001);
        assertEquals(76.5807, ball.getY(), 0.001);
    }

    //TODO: Add more test methods
}
