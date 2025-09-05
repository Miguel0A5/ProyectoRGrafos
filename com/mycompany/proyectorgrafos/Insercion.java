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

            try {
                opcion = scanner.nextInt(); // Leemos la opción del usuario
                switch (opcion) {
                    case 1:
                        explicarInsercion(); // Mostramos la explicación de inserción
                        break;
                    case 2:
                        iniciarTutorialCompleto(scanner); // Empezamos el tutorial completo
                        break;
                    case 3:
                        System.out.println("Regresando al Menú Principal...");
                        return; // Esto hace que salgamos de este menú y volvamos al principal
                    default:
                        System.out.println("Opción no válida. Por favor, elige 1, 2 o 3.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
                scanner.next(); // Limpiamos lo que el usuario escribió mal
            }
        }
        // No cerramos el Scanner aquí porque lo usamos en otros menús
        // scanner.close();  
    }
