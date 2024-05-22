package com.FloydAlgorithm;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.GraphStructure.Grafo;
import com.GraphStructure.Node;

public class FloydAlgorithm {

    public static HashMap<Integer, String> nodos = new HashMap<>();
    public  List<String[]> relations = new ArrayList<>();
    public static Grafo grafo;

    public int[][] createWeightGraph(String filePath) {
        TxtLector txtLector = new TxtLector();
        relations = txtLector.getRelationsFromTxt(filePath);
        nodos = txtLector.getNodos();
        grafo = new Grafo(nodos.size());
        for (String[] relation : relations) {
            int origen = txtLector.getKey(relation[0]);
            int destino = txtLector.getKey(relation[1]);
            int weight = Integer.parseInt(relation[2]);
            grafo.agregarArista(origen, destino, weight);
        }

        grafo.setInfiniteValues();

        for (int i = 0; i < nodos.size(); i++) {
            grafo.setMatrizAdyacencia(i, i, 0);
            
        }

        return grafo.getMatrizAdyacencia();
    }

    public int[][][] floydAlgorithm(int[][] matrizAdyacencia, int size) {
        int[][] rootGraph = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rootGraph[i][j] = j;
            }
        }
    
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrizAdyacencia[i][k] != Integer.MAX_VALUE &&
                        matrizAdyacencia[k][j] != Integer.MAX_VALUE &&
                        matrizAdyacencia[i][k] + matrizAdyacencia[k][j] < matrizAdyacencia[i][j]) {
                        
                        matrizAdyacencia[i][j] = matrizAdyacencia[i][k] + matrizAdyacencia[k][j];
                        rootGraph[i][j] = rootGraph[i][k];
                    }
                }
            }
        }
    
        return new int[][][]{matrizAdyacencia, rootGraph};
    }

    public int graphCenter(int[][] distanceMatrix, int size) {
        int[] eccentricities = new int[size];
    
        
        for (int i = 0; i < size; i++) {
            int maxDistance = Integer.MIN_VALUE;
            for (int j = 0; j < size; j++) {
                if (distanceMatrix[i][j] != Integer.MAX_VALUE && distanceMatrix[i][j] > maxDistance) {
                    maxDistance = distanceMatrix[i][j];
                }
            }
            eccentricities[i] = maxDistance;
        }

        int center = 0;
        int minEccentricity = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (eccentricities[i] < minEccentricity) {
                minEccentricity = eccentricities[i];
                center = i;
            }
        }
    
        return center;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public int getNodeID(String name) {
        for (int key : nodos.keySet()) {
            if (nodos.get(key).equals(name)) {
                return  key;
            }
        }
        return -1;

    }




    // main

    public static void main(String[] args) {
        FloydAlgorithm floydAlgorithm = new FloydAlgorithm();
        int[][] matrizAdyacencia = floydAlgorithm.createWeightGraph("src\\main\\java\\com\\data\\guategrafo.txt");
        int[][][] result = floydAlgorithm.floydAlgorithm(matrizAdyacencia, floydAlgorithm.nodos.size());
        int[][] distanceMatrix = result[0];
        int[][] rootGraph = result[1];
        int center = floydAlgorithm.graphCenter(distanceMatrix, floydAlgorithm.nodos.size());
        System.out.println("El centro del grafo es: " + floydAlgorithm.nodos.get(center));
    
    
    } 

}
