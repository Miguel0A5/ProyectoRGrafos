package com.mycompany.proyectorgrafos;

public class MergeSort {

    // Método principal de Merge Sort con diagrama y explicación
    public static void mergeSortConDiagrama(long[] arr, int izq, int der, int nivel) {
        if (izq < der) {
            // Mostrar subarreglo antes de dividir
            System.out.println("Nivel " + nivel + " -> Subarreglo: " + subArregloToString(arr, izq, der));

            int medio = (izq + der) / 2;

            // Recursión izquierda
            mergeSortConDiagrama(arr, izq, medio, nivel + 1);

            // Recursión derecha
            mergeSortConDiagrama(arr, medio + 1, der, nivel + 1);

            // Combinar subarreglos
            merge(arr, izq, medio, der);

            // Mostrar subarreglo después de combinar
            System.out.println("Nivel " + nivel + " -> Combinado: " + subArregloToString(arr, izq, der));
            
            // Explicación del merge paso a paso
            mostrarMergeExplicativo(arr, izq, medio, der);
        }
    }

       // Método para combinar dos subarreglos
    public static void merge(long[] arr, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        long[] L = new long[n1];
        long[] R = new long[n2];

        // Copiar datos a los arreglos temporales
        for (int i = 0; i < n1; i++) {
            L[i] = arr[izq + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[medio + 1 + j];
        }

