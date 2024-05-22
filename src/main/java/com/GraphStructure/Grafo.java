package com.GraphStructure;

import com.FloydAlgorithm.TxtLector;


public class Grafo {

    private int[][] matrizAdyacencia;
    
    int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino, int weight) {
        matrizAdyacencia[origen][destino] = weight;
        
    }

    public void removeArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 0;
    }

    public int getWeight(int origen, int destino) {
        return matrizAdyacencia[origen][destino];
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void setMatrizAdyacencia(int row, int column, int value) {
        this.matrizAdyacencia[row][column] = value;
    }

    public void setInfiniteValues() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j] == 0) {
                    matrizAdyacencia[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }



    
    
}
