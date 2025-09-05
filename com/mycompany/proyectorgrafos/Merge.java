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
    





        
        
}
