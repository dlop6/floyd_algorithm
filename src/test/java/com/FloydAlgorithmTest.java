package com;

import org.junit.Before;
import org.junit.Test;

import com.FloydAlgorithm.FloydAlgorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FloydAlgorithmTest {

    private FloydAlgorithm floydAlgorithm;

    @Before
    public void setUp() {
        floydAlgorithm = new FloydAlgorithm();
    }

    @Test
    public void testCreateWeightGraph() {
        // This file path needs to be replaced with an actual file path for testing
        String filePath = "src\\test\\java\\com\\test files\\testRelations.txt"; 

        int[][] expectedMatrix = {
            {0, 30, 25, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 25},
            {20, Integer.MAX_VALUE, 0, 18},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 0}
        };
        

        int[][] resultMatrix = floydAlgorithm.createWeightGraph(filePath);
        assertArrayEquals(expectedMatrix, resultMatrix);
    }

    @Test
    public void testFloydAlgorithm() {
        int[][] initialMatrix = {
            {0, 29, Integer.MAX_VALUE, Integer.MAX_VALUE, 25, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, 25, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 15, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 18},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 25},
            {20, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        floydAlgorithm.floydAlgorithm(initialMatrix, 6);

        int[][] expectedDistanceMatrix = {
            {0, 29, 54, 69, 25, 50},
            {78, 0, 25, 40, 103, 58},
            {53, 82, 0, 15, 78, 33},
            {38, 67, 92, 0, 63, 18},
            {45, 74, 99, 114, 0, 25},
            {20, 49, 74, 89, 45, 0}
        };
        

        assertArrayEquals(expectedDistanceMatrix, floydAlgorithm.distanceMatrix);
    }

    @Test
    public void testGraphCenter() {
        int[][] initialMatrix = {
            {0, 29, 54, Integer.MAX_VALUE, 25, 43},
            {Integer.MAX_VALUE, 0, 25, 40, Integer.MAX_VALUE, 58},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 15, Integer.MAX_VALUE, 33},
            {38, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 18},
            {45, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 25},
            {20, 49, 74, Integer.MAX_VALUE, 45, 0}
        };

        floydAlgorithm.floydAlgorithm(initialMatrix, 6);
        int center = floydAlgorithm.graphCenter();

        int expectedCenter = 0; // Assuming node 0 (Mixco) is the center
        assertEquals(expectedCenter, center);
    }

}



