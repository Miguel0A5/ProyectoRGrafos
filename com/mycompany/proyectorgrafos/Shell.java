/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorgrafos;

/**
 *
 * @author migue
 */
import java.util.*;

public class Shell {
    private Map<String, List<String>> grafo = new HashMap<>();

    // Agregar vértice
    public void agregarVertice(Scanner entrada) {
        System.out.print("Nombre del vértice: ");
        String v = entrada.nextLine();
        if (!grafo.containsKey(v)) {
            grafo.put(v, new ArrayList<>());
            System.out.println("Vértice agregado: " + v);
        } else {
            System.out.println("El vértice ya existe.");
        }
    }

    // Agregar arista
    public void agregarArista(Scanner entrada) {
        System.out.print("Vértice origen: ");
        String origen = entrada.nextLine();
        System.out.print("Vértice destino: ");
        String destino = entrada.nextLine();

        if (!grafo.containsKey(origen) || !grafo.containsKey(destino)) {
            System.out.println("Ambos vértices deben existir.");
            return;
        }

        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen); // grafo no dirigido
        System.out.println("Arista agregada entre " + origen + " y " + destino);
    }

    // Ver grafo (lista de adyacencia)
    public void verGrafo() {
        if (grafo.isEmpty()) {
            System.out.println("El grafo está vacío.");
            return;
        }
        System.out.println("\n--- Representación del grafo ---");
        for (var entry : grafo.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Orientación Shell (BFS en capas)
    public void orientacionShell(String origen) {
        if (!grafo.containsKey(origen)) {
            System.out.println("Ese vértice no existe en el grafo.");
            return;
        }

        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        Map<String, Integer> nivel = new HashMap<>();

        cola.add(origen);
        nivel.put(origen, 0);
        visitados.add(origen);

        System.out.println("\n--- Orientación Shell desde nodo " + origen + " ---");
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            int nivelActual = nivel.get(actual);
            System.out.println("Nodo " + actual + " está en shell " + nivelActual);

            for (String vecino : grafo.get(actual)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                    nivel.put(vecino, nivelActual + 1);
                }
            }
        }
    }
}
