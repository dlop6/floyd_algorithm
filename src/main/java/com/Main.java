package com;

import java.util.Scanner;
import com.FloydAlgorithm.FloydAlgorithm;
import com.FloydAlgorithm.TxtLector;

public class Main {

    public static void main(String[] args) {

        System.out.println("BIENVENIDO AL SISTEMA DE RUTAS ENTRE HOSPIALES\n\n");

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 7) {

            FloydAlgorithm floydAlgorithm = new FloydAlgorithm();
            int[][] matrizAdyacencia = floydAlgorithm.createWeightGraph("src\\main\\java\\com\\data\\guategrafo.txt");
            floydAlgorithm.floydAlgorithm(matrizAdyacencia, matrizAdyacencia.length);
           
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
                        int origenID = floydAlgorithm.getNodeID(origen);
                        int destinoID = floydAlgorithm.getNodeID(destino);
                        
                        if (origenID == -1 || destinoID == -1) {
                            throw new Exception("Uno de las ubicaciones de los hospitales no existe.");
                        }

                        floydAlgorithm.getGrafo().agregarArista(origenID, destinoID, distancia);
                        TxtLector.addRelations(floydAlgorithm.getRelations(), origen, destino,
                                String.valueOf(distancia));
                        TxtLector.rewriteTxt("src\\main\\java\\com\\data\\guategrafo.txt",
                                floydAlgorithm.getRelations());
                        System.out.println("Ruta agregada con éxito.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar la ruta: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del hospital de origen:");
                    String origen2 = scanner.next();
                    System.out.println("Ingrese el nombre del hospital de destino:");
                    String destino2 = scanner.next();

                    try {
                        int origenID = floydAlgorithm.getNodeID(origen2);
                        int destinoID = floydAlgorithm.getNodeID(destino2);
                        if (origenID == -1 || destinoID == -1) {
                            throw new Exception("Uno de las ubicaciones de los hospitales no existe.");
                        }

                        floydAlgorithm.getGrafo().removeArista(origenID, destinoID);
                        TxtLector.removeRelation(floydAlgorithm.getRelations(), origen2, destino2);
                        TxtLector.rewriteTxt("src\\main\\java\\com\\data\\guategrafo.txt",
                                floydAlgorithm.getRelations());

                        System.out.println("Ruta eliminada con éxito.");
                    } catch (Exception e) {
                        System.out.println("Error al eliminar la ruta: " + e.getMessage());
                    }

                    break;
                case 3:
                    floydAlgorithm.showAllRelations();
                    break;
                case 4:
                    System.out.println("Ubicaciones de los hospitales:");
                    floydAlgorithm.showAllNodes();
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del hospital de origen:");
                    String origen3 = scanner.next();
                    System.out.println("Ingrese el nombre del hospital de destino:");
                    String destino3 = scanner.next();

                    if (floydAlgorithm.getNodeID(origen3) == -1 || floydAlgorithm.getNodeID(destino3) == -1) {
                        System.out.println("Uno de las ubicaciones de los hospitales no existe.");
                        break;
                    }
                    
                    floydAlgorithm.shortestPath(origen3, destino3);
                    break;
                case 6:
                    int center = floydAlgorithm.graphCenter();
                    System.out.println("El centro de operaciones es: " + floydAlgorithm.getNodos().get(center));
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
