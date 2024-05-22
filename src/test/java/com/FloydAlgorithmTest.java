package com;


import org.junit.Test;

import org.junit.Before;

import com.FloydAlgorithm.FloydAlgorithm;

import static org.junit.Assert.*;

public class FloydAlgorithmTest {

    private FloydAlgorithm floydAlgorithm;

    @Before
    public void setUp() {
        floydAlgorithm = new FloydAlgorithm();
    }

    @Test
    public void testCreateWeightGraph() {
        // Supón que tenemos un archivo de texto con las relaciones en "testRelations.txt"
        // Debes asegurarte de tener este archivo en tu directorio de recursos de prueba.
        String filePath = "src\\test\\java\\com\\test files\\testRelations.txt";
        
        // Llama al método createWeightGraph y verifica los resultados.
        int[][] weightGraph = floydAlgorithm.createWeightGraph(filePath);
        
        // Añade las aserciones necesarias para verificar que el grafo se creó correctamente.
        // Estas aserciones dependen del contenido esperado del archivo testRelations.txt.
        assertNotNull(weightGraph);
        assertEquals(0, weightGraph[0][0]);
        assertEquals(30, weightGraph[0][1]);
        assertEquals(Integer.MAX_VALUE, weightGraph[0][2]);
        // Añade más aserciones según sea necesario.
    }

    @Test
    public void testFloydAlgorithm() {
        int INF = Integer.MAX_VALUE;
        int[][] matrizAdyacencia = {
            {0, 30, INF, 25},
            {INF, 0, 25, INF},
            {INF, INF, 0, 15},
            {20, INF, 18, 0}
        };
        int size = matrizAdyacencia.length;

        int[][][] result = floydAlgorithm.floydAlgorithm(matrizAdyacencia, size);

        // Verifica la matriz de adyacencia transformada.
        int[][] expectedAdyacencia = {
            {0, 30, 50, 25},
            {43, 0, 25, 40},
            {35, 45, 0, 15},
            {20, 50, 18, 0}
        };

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals(expectedAdyacencia[i][j], result[0][i][j]);
            }
        }

        // Verifica la matriz de rutas.
        int[][] expectedRutas = {
            {0, 1, 3, 3},
            {3, 1, 2, 3},
            {3, 3, 2, 3},
            {0, 2, 2, 3}
        };

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals(expectedRutas[i][j], result[1][i][j]);
            }
        }
    }
}