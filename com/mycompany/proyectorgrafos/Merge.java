package com.mycompany.proyectorgrafos;

import java.util.Scanner;

public class Merge {
    //Merge Miguel y Axel

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
                    ejecutarPrograma(sc); // tu flujo actual de ingreso y Merge Sort
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

    // ===================== OPCIÓN 3: Ejecutar programa =====================
    public static void ejecutarPrograma(Scanner sc) {
        final int MAX_NUMEROS = 1000;
        long[] array = null;

        System.out.println("\nINSTRUCCIONES:");
        System.out.println("1. Ingresa la cantidad de números que quieres ordenar.");
        System.out.println("2. Ingresa cada número uno por uno.");
        System.out.println("3. El programa mostrará el arreglo original y el ordenado.");
        System.out.println("-------------------------------------------------\n");

        while (true) {
            System.out.print("¿Cuántos números deseas ordenar? (Máx " + MAX_NUMEROS
                    + ", escribe 0 para regresar al menú): ");
            String entrada = sc.nextLine();

            int n;
            try {
                n = Integer.parseInt(entrada);
                if (n == 0) {
                    System.out.println("Regresando al menú principal...\n");
                    return;
                } else if (n < 0) {
                    System.out.println("Debes ingresar un número mayor que 0.");
                    continue;
                } else if (n > MAX_NUMEROS) {
                    System.out.println("Número demasiado grande. Máx permitido: " + MAX_NUMEROS);
                    continue;
                } else {
                    array = new long[n];
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa solo números enteros.");
                continue;
            }

            int i = 0;
            while (i < array.length) {
                System.out.print("Número " + (i + 1) + " (o escribe 'salir' para cambiar la cantidad): ");
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("salir")) {
                    System.out.println("Regresando para modificar la cantidad de números...\n");
                    break;
                }

                try {
                    array[i] = Long.parseLong(input);
                    i++;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingresa un número entero o 'salir'.");
                }
            }

            if (i == array.length) {
                break;
            }
        }

        System.out.println("\nArreglo original:");
        mostrarArreglo(array);

        System.out.println("\n==========================================");
        System.out.println("=== EJEMPLO DEL PROCESO MERGE SORT ===");
        System.out.println("==========================================\n");

        MergeSort.mergeSortConDiagrama(array, 0, array.length - 1, 0);

        System.out.println("\nArreglo ordenado con Merge Sort:");
        mostrarArreglo(array);

        System.out.println("\n¡Proceso completado! Ahora entiendes cómo funciona Merge Sort :)\n");
    }

    // ===================== MÉTODO PARA MOSTRAR ARREGLO =====================
    public static void mostrarArreglo(long[] arr) {
        for (long num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
