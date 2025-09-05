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

        // Combinar arreglos temporales
        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar elementos restantes
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

       // Método para mostrar un subarreglo como String
    public static String subArregloToString(long[] arr, int izq, int der) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = izq; i <= der; i++) {
            sb.append(arr[i]);
            if (i < der) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Explicación del merge paso a paso
    public static void mostrarMergeExplicativo(long[] arr, int izq, int medio, int der) {
        System.out.println("--- Merge paso a paso ---");
        System.out.println("Subarreglo izquierdo : " + subArregloToString(arr, izq, medio));
        System.out.println("Subarreglo derecho  : " + subArregloToString(arr, medio + 1, der));
        System.out.println("Se combinan en orden...");
        System.out.println("Resultado combinado : " + subArregloToString(arr, izq, der) + "\n");
         System.out.println("==========================================\n");
    }
}
