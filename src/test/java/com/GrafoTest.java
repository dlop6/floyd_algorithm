package com;

import com.GraphStructure.Grafo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GrafoTest {

    private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo(5);
    }

    @Test
    public void testAgregarArista() {
        grafo.agregarArista(0, 1, 10);
        assertEquals(10, grafo.getWeight(0, 1));
    }

    @Test
    public void testRemoveArista() {
        grafo.agregarArista(0, 1, 10);
        grafo.removeArista(0, 1);
        assertEquals(0, grafo.getWeight(0, 1));
    }

    @Test
    public void testGetWeight() {
        grafo.agregarArista(0, 1, 10);
        assertEquals(10, grafo.getWeight(0, 1));
    }

    @Test
    public void testGetMatrizAdyacencia() {
        grafo.agregarArista(0, 1, 10);
        int[][] matriz = grafo.getMatrizAdyacencia();
        assertEquals(10, matriz[0][1]);
    }

    @Test
    public void testSetMatrizAdyacencia() {
        grafo.setMatrizAdyacencia(0, 1, 10);
        assertEquals(10, grafo.getWeight(0, 1));
    }

    @Test
    public void testSetInfiniteValues() {
        grafo.agregarArista(0, 1, 10);
        grafo.setInfiniteValues();
        int[][] matriz = grafo.getMatrizAdyacencia();
        assertEquals(10, matriz[0][1]);
        assertEquals(Integer.MAX_VALUE, matriz[1][0]);
    }
}
