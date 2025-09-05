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

    // Este método maneja el tutorial completo de inserción
    private static void iniciarTutorialCompleto(Scanner scanner) {
        trabajarConInsercion(scanner, true); // Primero hacemos el tutorial guiado

        System.out.println("\n--- ¡Felicidades! Has terminado el tutorial. ---");
        System.out.println("Ahora es tu turno de practicar sin ayuda.");
        System.out.println("1. Terminar el tutorial y practicar (sin instrucciones)");
        System.out.println("2. Regresar al Menú Principal");
        System.out.print("Selecciona una opción: ");

        int opcionFinal;
        try {
            opcionFinal = scanner.nextInt(); // Leemos la opción final del usuario
            if (opcionFinal == 1) {
                trabajarConInsercion(scanner, false); // Practica sin instrucciones
            } else if (opcionFinal != 2) {
                System.out.println("Opción no válida. Regresando al menú principal.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada no válida. Regresando al menú principal.");
            scanner.next(); // Limpiamos buffer
        }
    }

    // Explicación básica de qué es la inserción
    private static void explicarInsercion() {
        System.out.println("\n--- ¿QUÉ ES LA INSERCIÓN? ---");
        System.out.println("La inserción es un algoritmo de ordenamiento que construye un arreglo final ordenado, elemento por elemento.");
        System.out.println("Es como cuando ordenas una mano de cartas: tomas una carta y la pones en la posición correcta entre las cartas que ya tienes ordenadas.");
        System.out.println("En cada paso, el algoritmo toma un elemento y lo inserta en su lugar adecuado dentro de la parte ya ordenada del arreglo.");
        System.out.println("Este proceso se repite hasta que todos los elementos están en su lugar. Es simple y eficiente para arreglos pequeños.");
        System.out.println("-------------------------------------");
    }

    // Método que hace todo el trabajo de insertar los números
    // conInstrucciones = true si es tutorial guiado, false si es práctica
    private static void trabajarConInsercion(Scanner scanner, boolean conInstrucciones) {
        String titulo = conInstrucciones ? "TUTORIAL DE INSERCIÓN" : "PRÁCTICA DE INSERCIÓN (SIN INSTRUCCIONES)";
        System.out.println("\n--- " + titulo + " ---");
        System.out.print("¿Cuántos números quieres insertar? (Máximo 10): ");
        int n = 0;
        try {
            n = scanner.nextInt();
            if (n > 10 || n <= 0) {
                System.out.println("El número debe ser entre 1 y 10.");
                return; // Si el número no es válido, regresamos
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingresa un número.");
            scanner.next();
            return;
        }

        int[] arreglo = new int[n]; // Creamos el arreglo donde vamos a insertar los números
        if (conInstrucciones) {
            System.out.println("Vamos a insertar los números uno por uno.");
        }

        // Bucle para insertar todos los números
        for (int i = 0; i < n; i++) {
            System.out.print("\nIntroduce el número " + (i + 1) + ": ");
            int numeroAInsertar = 0;
            try {
                numeroAInsertar = scanner.nextInt(); // Leemos el número
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
                scanner.next();
                i--; // Volvemos a pedir el mismo número
                continue;
            }

            if (conInstrucciones) {
                System.out.println("Paso " + (i + 1) + ": Insertando el número " + numeroAInsertar);
            }

            int j = i - 1;
            // Movemos los números mayores a la derecha
            while (j >= 0 && arreglo[j] > numeroAInsertar) {
                if (conInstrucciones) {
                    System.out.println("  -> El número " + arreglo[j] + " es mayor que " + numeroAInsertar + ", lo movemos una posición a la derecha.");
                }
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            // Insertamos el número en su posición correcta
            arreglo[j + 1] = numeroAInsertar;
            if (conInstrucciones) {
                System.out.println("  -> El número " + numeroAInsertar + " se inserta en la posición correcta.");
                System.out.print("Estado actual del arreglo: ");
                imprimirArreglo(arreglo, i + 1);
            }
        }

        System.out.println("\n¡El arreglo ha sido ordenado completamente!");
        System.out.print("Arreglo final: ");
        imprimirArreglo(arreglo, n); // Mostramos el arreglo final
        System.out.println("-------------------------------------");
    }

    // Método simple para imprimir un arreglo hasta cierto tamaño
    private static void imprimirArreglo(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
