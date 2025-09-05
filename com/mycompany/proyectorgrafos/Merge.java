package com.mycompany.proyectorgrafos;

import java.util.Scanner;

public class Merge {

        public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // ===================== MINI MENÚ =====================
            System.out.println("=================================================");
            System.out.println("      DEMOSTRACIÓN DEL ALGORITMO MERGE SORT     ");
            System.out.println("=================================================");
            System.out.println("Selecciona una opción:");
            System.out.println("1.- Ver ejemplo gráfico del proceso Merge");
            System.out.println("2.- Qué es Merge Sort");
            System.out.println("3.- Empezar a ordenar números");
            System.out.println("0.- Regresar al menú principal");

            System.out.print("Opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    mostrarEjemploGrafico();
                    break;
                case "2":
                    mostrarConcepto();
                    break;
                case "3":
                    ejecutarPrograma(sc); // el flujo actual de ingreso y Merge Sort
                    break;
                case "0":
                    System.out.println("Regresando al menú principal...\n");
                    return; // sale del método y vuelve al MainMenu
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.\n");
            }
        }
    }

    // ===================== OPCIÓN 1: Ejemplo gráfico =====================
    public static void mostrarEjemploGrafico() {
        System.out.println("\n--- Ejemplo gráfico de Merge Sort ---\n");
        System.out.println("Arreglo: [34, 12, 89, 5, 67, 23]");
        System.out.println("\n                 [34, 12, 89, 5, 67, 23]");
        System.out.println("                  /                   \\");
        System.out.println("         [34, 12, 89]                 [5, 67, 23]");
        System.out.println("           /       \\                    /       \\");
        System.out.println("       [34]     [12, 89]              [5]      [67, 23]");
        System.out.println("               /    \\                          /    \\");
        System.out.println("           [12]    [89]                  [67]      [23]");
        System.out.println("\n        ---> Se ordenan los subarreglos pequeños");
        System.out.println("        [12, 34, 89]  y  [5, 23, 67]");
        System.out.println("\n        ----> Se combinan los grandes <----");
        System.out.println("          [5, 12, 23, 34, 67, 89]\n");
    }

    // ===================== OPCIÓN 2: Concepto =====================
    public static void mostrarConcepto() {
        System.out.println("\n--- Qué es Merge Sort ---\n");
        System.out.println("Merge Sort es un algoritmo de ordenamiento eficiente\n" +
                           "que utiliza el enfoque de 'divide y vencerás'.\n" +
                           "Consiste en dividir el arreglo en partes más pequeñas,\n" +
                           "ordenarlas y luego combinarlas (merge) en orden.\n" +
                           "Complejidad: O(n log n)\n");
    }


    

























        
        
}
