package com.FloydAlgorithm;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.GraphStructure.Grafo;

public class FloydAlgorithm {

    public static HashMap<Integer, String> nodos = new HashMap<>();
    public  List<String[]> relations = new ArrayList<>();
    public int[][] distanceMatrix;
    public int[][] rootGraph;
    public int size;

    public static Grafo grafo;

    public int[][] createWeightGraph(String filePath) {
        TxtLector txtLector = new TxtLector();
        relations = txtLector.getRelationsFromTxt(filePath);
        nodos = txtLector.getNodos();
        this.size = nodos.size();
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

    public void floydAlgorithm(int[][] matrizAdyacencia, int size) {
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
    
        this.distanceMatrix = matrizAdyacencia;
        this.rootGraph = rootGraph;
    }

    public int graphCenter() {
        int[] eccentricities = new int[this.size];
        
        for (int i = 0; i < size; i++) {
            int maxDistance = Integer.MIN_VALUE;
            for (int j = 0; j < size; j++) {
                if (this.distanceMatrix[i][j] != Integer.MAX_VALUE && this.distanceMatrix[i][j] > maxDistance) {
                    maxDistance = this.distanceMatrix[i][j];
                }
            }
            eccentricities[i] = maxDistance;
        }

        int center = 0;
        int minEccentricity = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (eccentricities[i] < minEccentricity && eccentricities[i] > 0) {
                minEccentricity = eccentricities[i];
                center = i;
            }
        }
    
        return center;
    }


    public void shortestPath(String origen, String destino) {
        int origenID = getNodeID(origen);
        int destinoID = getNodeID(destino);
        ArrayList<String> path = new ArrayList<>();
        int distanciaTotal = this.distanceMatrix[origenID][destinoID];

        if (distanciaTotal == Integer.MAX_VALUE) {
            System.out.println("No hay una ruta entre " + origen + " y " + destino);
        } else {

            System.out.println("La distancia entre " + origen + " y " + destino + " es de " + distanciaTotal + " km");
            System.out.println("La ruta es: ");

            while (origenID != destinoID) {
                path.add(nodos.get(origenID));
                origenID = this.rootGraph[origenID][destinoID];
            }

            path.add(nodos.get(destinoID));

            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    System.out.println(path.get(i));
                } else {
                    System.out.print(path.get(i) + " -> ");
                }
            }
        }
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

    public void showAllRelations() {
        for (String[] relation : relations) {
            System.out.println("De "+ relation[0] + " a " + relation[1] + " la ruta es de " + relation[2] + " km") ;
        }
    }

    public void showAllNodes() {
        for (int key : nodos.keySet()) {
            System.out.println(nodos.get(key));
        }
    }

    public HashMap<Integer, String> getNodos() {
        return nodos;
    }

    public List<String[]> getRelations() {
        return relations;
    }


}
