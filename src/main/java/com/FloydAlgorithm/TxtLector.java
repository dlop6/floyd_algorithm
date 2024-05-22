package com.FloydAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class TxtLector {

    private static HashMap<Integer, String> nodos = new HashMap<>();

    public List<String[]> getRelationsFromTxt(String filePath) {
        List<String[]> values = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                uniqueNodes(parts);
                if (parts.length == 3) {
                    values.add(parts);
                } else {
                    System.out.println("Error en el archivo de texto");
                    return null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }

    public static void uniqueNodes(String[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (!nodos.containsValue(values[i])) {
                nodos.put(nodos.size(), values[i]);
            }
        }
    }

    public HashMap<Integer, String> getNodos() {
        return nodos;
    }

    public int getKey(String value) {
        for (int key : nodos.keySet()) {
            if (nodos.get(key).equals(value)) {
                return key;
            }
        }
        return -1;
    }

    // main

    public static void main(String[] args) {
        TxtLector txtLector = new TxtLector();
        List<String[]> result = txtLector.getRelationsFromTxt("src\\main\\java\\com\\data\\guategrafo.txt");
        System.out.println("Nodos: ");
        System.out.println(txtLector.getNodos());
    }
    

}
