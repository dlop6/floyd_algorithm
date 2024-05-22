package com;

import java.util.Scanner;
import com.FloydAlgorithm.FloydAlgorithm;


public class Main {

    public static void main(String[] args) {


        System.out.println("BIENVENIDO AL SISTEMA DE RUTAS ENTRE HOSPIALES\n\n");

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 7) {

            FloydAlgorithm floydAlgorithm = new FloydAlgorithm();
            int[][] matrizAdyacencia = floydAlgorithm.createWeightGraph("src\\main\\java\\com\\data\\guategrafo.txt");
            int[][][] floydAlgorithmResult = floydAlgorithm.floydAlgorithm(matrizAdyacencia, matrizAdyacencia.length);
            int[][] distanceMatrix = floydAlgorithmResult[0];
            int[][] rootGraph = floydAlgorithmResult[1];


            System.out.println("Por favor, seleccione una opción:\n");
            System.out.println("1. Ingresar una nueva ruta");
            System.out.println("2. Eliminar una ruta");
            System.out.println("3. Ver todas las rutas");
            System.out.println("4. Ver todas las ubicaciones de los hospitales");
            System.out.println("5. Ver la ruta más corta entre dos hospitales");
            System.out.println("6. Encontrar el centro de operaciones");
            System.out.println("7. Salir\n");

            option = scanner.nextInt();

            switch (option) {
            case 1:
                System.out.println("Ingrese el nombre del hospital de origen:");
                String origen = scanner.next();
                System.out.println("Ingrese el nombre del hospital de destino:");
                String destino = scanner.next();
                System.out.println("Ingrese la distancia entre los hospitales:");
                int distancia = scanner.nextInt();
                try {
                    floydAlgorithm.getGrafo().agregarArista(floydAlgorithm.getNodeID(origen), floydAlgorithm.getNodeID(destino), distancia);
                    System.out.println("Ruta agregada con éxito.");
                } catch (Exception e) {
                    System.out.println("Error al agregar la ruta: " + e.getMessage());
                }
                

                break;
            case 2:
                System.out.println("Ingrese el nombre del hospital de origen:");
                origen = scanner.next();
                System.out.println("Ingrese el nombre del hospital de destino:");
                destino = scanner.next();
                // Llama al método para eliminar una ruta.
                break;
            case 3:
                // Llama al método para ver todas las rutas.
                break;
            case 4:
                // Llama al método para ver todas las ubicaciones de los hospitales.
                break;

            case 5:
                System.out.println("Ingrese el nombre del hospital de origen:");
                origen = scanner.next();
                System.out.println("Ingrese el nombre del hospital de destino:");
                destino = scanner.next();
                // Llama al método para ver la ruta más corta entre dos hospitales.
                break;
            
            case 6:
                // Llama al método para encontrar el centro de operaciones.
                break;
            case 7:
                System.out.println("Gracias por utilizar el sistema de rutas entre hospitales.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
            }
        }

    }
    
}
