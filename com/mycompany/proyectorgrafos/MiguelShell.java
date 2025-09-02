/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectografos;

import java.util.*;


public class MiguelShell {
    Scanner entrada = new Scanner(System.in);
    private Shell grafo = new Shell();

    public void ejecutar() {
        int opcion = 0;

        // Mostrar el concepto SOLO una vez al entrar
        System.out.println("\n--- Concepto de Grafo Shell ---");
        System.out.println("El método de capas (Shell) consiste en organizar los nodos en niveles,");
        System.out.println("partiendo de un nodo origen, agrupando sus vecinos en capas sucesivas.");
        System.out.println("Así se obtiene una representación BFS del grafo.\n");

        do {
            System.out.println("\n--- MENÚ SHELL (Grafos) ---");
            System.out.println("1.- Agregar vértices");
            System.out.println("2.- Agregar aristas");
            System.out.println("3.- Ver grafo");
            System.out.println("4.- Orientación Shell (capas desde un nodo origen)");
            System.out.println("5.- Ver ejemplo de grafo con capas");
            System.out.println("6.- Salir");

            try {
                opcion = Integer.parseInt(entrada.nextLine()); 
                switch (opcion) {
                    case 1:
                        grafo.agregarVertice(entrada);
                        break;

                    case 2:
                        grafo.agregarArista(entrada);
                        break;

                    case 3:
                        grafo.verGrafo();
                        break;

                    case 4:
                        System.out.print("Ingrese el nodo origen: ");
                        String origen = entrada.nextLine();
                        grafo.orientacionShell(origen);
                        break;

                    case 5:
                        mostrarEjemplo();
                        break;

                    case 6:
                        System.out.println("Saliendo del módulo Shell...");
                        break;

                    default:
                        System.out.println("Valor no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida, intente de nuevo.");
            }
        } while (opcion != 6);

    }

    private void mostrarEjemplo() {
        System.out.println("\nEjemplo de orientación Shell:");
        System.out.println("   A");
        System.out.println("  / \\");
        System.out.println(" B   C");
        System.out.println(" |   |");
        System.out.println(" D   E");

        System.out.println("\nPaso 1: Escogemos el nodo origen → A");
        System.out.println("Shell 0: {A}");

        System.out.println("\nPaso 2: Vecinos directos de A → B y C");
        System.out.println("Shell 1: {B, C}");

        System.out.println("\nPaso 3: Vecinos de B y C → D y E");
        System.out.println("Shell 2: {D, E}");

        System.out.println("\nResultado final:");
        System.out.println("Shell 0 → {A}");
        System.out.println("Shell 1 → {B, C}");
        System.out.println("Shell 2 → {D, E}");
    }
}

