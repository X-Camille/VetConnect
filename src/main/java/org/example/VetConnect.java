package org.example;

import java.util.Scanner;

public class VetConnect {

    private FichaMedica ficha_medica = new FichaMedica();

    public static void main(String[] args) {
        VetConnect clinica = new VetConnect();
        clinica.menuPrincipal();
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inicio del programa");
        String opcion;
        do {
            mostrarOpcionesPrincipales();
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    menuSecundario();
                    break;
                case "2":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("2"));
    }

    public void mostrarOpcionesPrincipales() {
        System.out.println("Elige una opción");
        System.out.println("------------------------------");
        System.out.println("1 - Ingresar");
        System.out.println("2 - Salir");
    }

    public void menuSecundario() {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            menuSecundarioMensajes();
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    ficha_medica.crearFichaMedica();
                    break;
                case "2":
                    // Agrega aquí la lógica para buscar ficha médica
                    System.out.println("Buscar ficha médica seleccionada.");
                    break;
                case "3":
                    // Agrega aquí la lógica para mostrar notificaciones
                    System.out.println("Mostrar notificaciones seleccionado.");
                    break;
                case "4":
                    System.out.println("Retrocediendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("4"));
    }

    public void menuSecundarioMensajes() {
        System.out.println("Bienvenido a VetConnect");
        System.out.println("Elige una opción");
        System.out.println("------------------------------");
        System.out.println("1 - Agregar ficha médica");
        System.out.println("2 - Buscar ficha médica");
        System.out.println("3 - Mostrar notificaciones");
        System.out.println("4 - Retroceder al menú principal");
    }
}
