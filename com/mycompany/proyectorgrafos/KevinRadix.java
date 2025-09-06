package com.mycompany.proyectorgrafos;

import java.util.*;

public class KevinRadix {

    /**
     * Método RallyX: Ordena un arreglo dividiéndolo en equipos, ordenando cada equipo y fusionando los resultados.
     * @param arr El arreglo a ordenar.
     * @param equipos Número de equipos (subarreglos).
     */
    public static void rallyX(int[] arr, int equipos) {
        int n = arr.length;
        int tamEquipo = (int) Math.ceil((double) n / equipos);

        // 1. Dividir en equipos y ordenar cada equipo (usando inserción)
        for (int i = 0; i < n; i += tamEquipo) {
            int fin = Math.min(i + tamEquipo, n);
            insercion(arr, i, fin);
        }

        // 2. Fusionar los equipos ordenados
        int[] resultado = new int[n];
        int[] indices = new int[equipos];
        for (int i = 0; i < equipos; i++) {
            indices[i] = i * tamEquipo;
        }

        for (int k = 0; k < n; k++) {
            int minEquipo = -1;
            int minValor = Integer.MAX_VALUE;
            for (int e = 0; e < equipos; e++) {
                int idx = indices[e];
                int fin = Math.min((e + 1) * tamEquipo, n);
                if (idx < fin && arr[idx] < minValor) {
                    minValor = arr[idx];
                    minEquipo = e;
                }
            }
            resultado[k] = minValor;
            indices[minEquipo]++;
        }

        // Copiar resultado al arreglo original
        System.arraycopy(resultado, 0, arr, 0, n);
    }

    // Método de inserción para ordenar un subarreglo
    private static void insercion(int[] arr, int inicio, int fin) {
        for (int i = inicio + 1; i < fin; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= inicio && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 🔹 Método ejecutar para integrarlo al menú
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] datos = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            datos[i] = sc.nextInt();
        }

        System.out.print("Ingrese el número de equipos: ");
        int equipos = sc.nextInt();

        System.out.println("Arreglo original:");
        for (int num : datos) System.out.print(num + " ");

        rallyX(datos, equipos);

        System.out.println("\nArreglo ordenado con RallyX:");
        for (int num : datos) System.out.print(num + " ");
        System.out.println();
    }
}
