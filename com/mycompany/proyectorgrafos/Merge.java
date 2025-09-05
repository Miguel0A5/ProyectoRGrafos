package com.mycompany.proyectorgrafos;

import java.util.Scanner;

public class Merge {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        // ===================== PRESENTACIÓN =====================
        System.out.println("=================================================");
        System.out.println("         DEMOSTRACIÓN DEL ALGORITMO MERGE SORT   ");
        System.out.println("=================================================");
        System.out.println("\n¿Qué es Merge Sort?");
        System.out.println("Es un algoritmo de ordenamiento eficiente que utiliza el enfoque\n"
                + "'divide y vencerás'. Consiste en dividir el arreglo en partes más pequeñas,\n"
                + "ordenarlas y luego combinarlas (merge) en orden.\n"
                + "Su complejidad es O(n log n).");
        System.out.println("-------------------------------------------------");

        // ===================== INSTRUCCIONES =====================
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("1. Ingresa la cantidad de números que quieres ordenar.");
        System.out.println("2. Ingresa cada número uno por uno.");
        System.out.println("3. El programa mostrará el arreglo original y el ordenado.");
        System.out.println("-------------------------------------------------\n");

        final int MAX_NUMEROS = 1000;
        long[] array = null; // arreglo que contendrá los números

        // ===================== BUCLE PRINCIPAL DE CANTIDAD =====================
        while (true) {
            System.out.print("¿Cuántos números deseas ordenar? (Máx " + MAX_NUMEROS
                    + ", escribe 0 para regresar al menú): ");
            String entrada = sc.next();

            int n;
            try {
                n = Integer.parseInt(entrada);
                if (n == 0) {
                    System.out.println("Regresando al menú principal...\n");
                    return; // salir del método y regresar al MainMenu
                } else if (n < 0) {
                    System.out.println("Debes ingresar un número mayor que 0.");
                    continue;
                } else if (n > MAX_NUMEROS) {
                    System.out.println("Número demasiado grande. Máx permitido: " + MAX_NUMEROS);
                    continue;
                } else {
                    array = new long[n]; // inicializamos el arreglo
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa solo números enteros.");
                continue;
            }

            // ===================== INGRESO DE LOS NÚMEROS =====================
            int i = 0;
            while (i < array.length) {
                System.out.print("Número " + (i + 1) + " (o escribe 'salir' para cambiar la cantidad): ");
                String input = sc.next();

                if (input.equalsIgnoreCase("salir")) {
                    System.out.println("Regresando para modificar la cantidad de números...\n");
                    break; // volver al bucle principal de cantidad
                }

                try {
                    array[i] = Long.parseLong(input);
                    i++;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingresa un número entero o 'salir'.");
                }
            }

            if (i == array.length) { // todos los números ingresados correctamente
                break;
            }
        }

        // ===================== MOSTRAR ARREGLO ORIGINAL =====================
        System.out.println("\nArreglo original:");
        mostrarArreglo(array);

        // ===================== ORDENAMIENTO =====================
        System.out.println("\n=== EJEMPLO DEL PROCESO MERGE SORT ===");
        MergeSort.mergeSortConDiagrama(array, 0, array.length - 1, 0);

        // ===================== MOSTRAR ARREGLO ORDENADO =====================
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
