package edu.macalester.comp124.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    /**
     * Tests whether the bubble intersects method appropriate reports if a cannonball intersects it
     * Assumes that the first two parameters for the CannonBall constructor are x and y.
     */
    @Test
    public void testIsCannonBallWithin(){
        double bubbleRadius = 10;
        double bubblePos = bubbleRadius + CannonBall.BALL_RADIUS;
        Bubble bubble = new Bubble(bubblePos, 0, bubbleRadius);
        // Test x values
        CannonBall ball = new CannonBall(0, 0, 0, 0, 0, 0);
        assertFalse(bubble.intersects(ball));
        for(int i = 1; i < 25; i++){
            ball = new CannonBall(i, 0, 0, 0, 0, 0);
            assertTrue(bubble.intersects(ball));
        }
        ball = new CannonBall(bubbleRadius*2 + CannonBall.BALL_RADIUS*2, 0, 0, 0, 0, 0);
        assertFalse(bubble.intersects(ball));

        // Test y values
        bubble = new Bubble(0, bubblePos , bubbleRadius);
        ball = new CannonBall(0, 0, 0, 0, 0, 0);
        assertFalse(bubble.intersects(ball));
        for(int i = 1; i < 25; i++){
            ball = new CannonBall(0, i, 0, 0, 0, 0);
            assertTrue(bubble.intersects(ball));
        }
        ball = new CannonBall(0, bubbleRadius*2 + CannonBall.BALL_RADIUS*2, 0, 0, 0, 0);
        assertFalse(bubble.intersects(ball));
    }

}
