package com;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.junit.Before;

import java.util.HashMap;
import java.util.List;
import com.FloydAlgorithm.TxtLector;

import static org.junit.Assert.*;

public class TxtLectorTest {

    private TxtLector txtLector;
    private final String filePath = "src\\test\\java\\com\\test files\\testfile.txt";

    @Before
    public void setUp() {
        txtLector = new TxtLector();
    }

    @Test
    public void testReadTxtFile() {
        List<String[]> result = txtLector.getRelationsFromTxt(filePath);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertArrayEquals(new String[] { "Mixco", "Antigua", "30" }, result.get(0));
        assertArrayEquals(new String[] { "Antigua", "Escuintla", "25" }, result.get(1));
        assertArrayEquals(new String[] { "Escuintla", "SantaLucia", "15" }, result.get(2));
    }

    @Test
    public void testUniqueNodes() {
        txtLector.getRelationsFromTxt(filePath);
        HashMap<Integer, String> nodes = txtLector.getNodos();

        assertEquals(4, nodes.size());
        assertTrue(nodes.containsValue("Mixco"));
        assertTrue(nodes.containsValue("Antigua"));
        assertTrue(nodes.containsValue("Escuintla"));
        assertTrue(nodes.containsValue("SantaLucia"));
    }
}