package com.mycompany.proyectorgrafos;

import java.util.*;

public class ProyectoRGrafos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ Principal ---");
            System.out.println("1.- Ejemplo de shell -- Miguel_A5"); // MiguelShell
            System.out.println("2.- Ejemplo de inserción - Arturo"); // ArturoIsercion
            System.out.println("3.- Ejemplo de Selección - Isarel"); // IsarelSeleccion
            System.out.println("4.- Ejemplo de Radix -- Kevin"); // KevinRadix
            System.out.println("5.- Ejemplo de Heap -- Armando"); // ArmandoHeap
            System.out.println("6.- Ejemplo de Merge -- Axel y Miguel"); // AxelMiguelMerge
            System.out.println("7.- Ejemplo de Quicksort -- Eduardo"); // EduardoQuicksort
            System.out.println("8.- Salir"); // EduardoQuicksort
            try {
                opcion = Integer.parseInt(entrada.nextLine());
                switch (opcion) {
                    case 1:
                        MiguelShell miguel = new MiguelShell();
                        miguel.ejecutar;
                        break;

                    case 2:
                    Insercion Arturo = new insercion();    
                    Arturo.ejecutar();
                        break;
                     
                    case 3:
                        //No vino murio la paz
                        break;

                    case 4:
                        KevinRadix kevin = new KevinRadix();
                        kevin.ejecutar();
                        break;

                    case 5:
                        //muerte
                        break;

                    case 6:
                        Merge miguelyaxel = new Merge();
                        Merge.ejecutar();
                        break;

                    case 7:
                        Quicksort eduardo = new Quicksort();
                        eduardo.ejecutar();
                        break;

                    case 8:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Valor no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida, intente de nuevo.");
            }
        } while (opcion != 8);

        entrada.close();
    }

}
