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

