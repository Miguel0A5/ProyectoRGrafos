package com.mycompany.proyectorgrafos;
import java.util.Scanner;

public class Insercion {

    // Este es el método que lanza todo el menú de inserción
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in); // Scanner para leer lo que el usuario escribe
        int opcion = 0; // Aquí guardamos la opción que elige el usuario

        // Bucle del menú, sigue hasta que el usuario elija regresar
        while (opcion != 3) {
            System.out.println("-------------------------------------");
            System.out.println("         MENÚ DE INSERCIÓN          ");
            System.out.println("-------------------------------------");
            System.out.println("1. ¿Qué es la Inserción?");
            System.out.println("2. Empezar con el Tutorial de Inserción");
            System.out.println("3. Regresar al Menú Principal");
            System.out.print("Selecciona una opción: ");