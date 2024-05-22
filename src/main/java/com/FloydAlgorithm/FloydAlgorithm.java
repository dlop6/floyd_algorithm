package com.FloydAlgorithm;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.GraphStructure.Grafo;

public class FloydAlgorithm {

    HashMap<Integer, String> nodos = new HashMap<>();
    public  List<String[]> relations = new ArrayList<>();

    public int[][] createWeightGraph(String filePath) {
        TxtLector txtLector = new TxtLector();
        relations = txtLector.getRelationsFromTxt(filePath);
        nodos = txtLector.getNodos();
        Grafo grafo = new Grafo(nodos.size());
        for (String[] relation : relations) {
            int origen = txtLector.getKey(relation[0]);
            int destino = txtLector.getKey(relation[1]);
            int weight = Integer.parseInt(relation[2]);
            grafo.agregarArista(origen, destino, weight);
        }

        for (int i = 0; i < nodos.size(); i++) {
            grafo.setMatrizAdyacencia(null);
            
        }

        return grafo.getMatrizAdyacencia();
    }

    public int[][] createRootGraph(String filePath) {
        TxtLector txtLector = new TxtLector();
        relations = txtLector.getRelationsFromTxt(filePath);
        nodos = txtLector.getNodos();
        Grafo grafo = new Grafo(nodos.size());
        for (String[] relation : relations) {
            int origen = txtLector.getKey(relation[0]);
            int destino = txtLector.getKey(relation[1]);
            grafo.agregarArista(origen, destino, 1);
        }

        return grafo.getMatrizAdyacencia();
    }




    // main 
    public static void main(String[] args) {
        FloydAlgorithm floydAlgorithm = new FloydAlgorithm();
        int[][] matrizAdyacencia = floydAlgorithm.createWeightGraph("src\\main\\java\\com\\data\\guategrafo.txt");
        System.out.println("Matriz de adyacencia: ");
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
}
