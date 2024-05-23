package com.FloydAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.PrintWriter;

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

    public static void addRelations(List<String[]> values, String origen, String destino, String distancia) {
        boolean matchFound = false;

        for (String[] value : values) {
            if (value[0].equals(origen) && value[1].equals(destino)) {
                value[2] = distancia;
                matchFound = true;
                break;
            }
        }

        if (!matchFound) {
            values.add(new String[] { origen, destino, distancia });
        }
    }

    public static void removeRelation(List<String[]> values, String origen, String destino) {
        for (String[] value : values) {
            if (value[0].equals(origen) && value[1].equals(destino)) {
                values.remove(value);
                break;
            }
        }
    }

    public static void rewriteTxt(String filePath, List<String[]> values) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (String[] value : values) {
                printWriter.println(value[0] + " " + value[1] + " " + value[2]);
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
