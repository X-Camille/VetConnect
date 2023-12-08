package org.example;

import java.util.*;

public class FichaMedica {
    private String diagnostico = "";
    private String tratamiento = "";
    private final Propietario propietario;

    public FichaMedica() {
        propietario = new Propietario();
    }

    public void crearFichaMedica() {
        agregarDatosUsuario(); // Métodos de la clase Propietario
        agregarDatosMascota(); // Métodos de la clase Animal
        deseaAgregarDiagnostico();
        deseaAgregarTratamiento();
        mostrarFichaMedica();
    }

    public void deseaAgregarDiagnostico(){
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("¿Desea agregar un diagnóstico? 1. Sí - 2. No ");
            opcion = scanner.nextLine();
        } while(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2"));

        switch (opcion) {
            case "1":
                diagnostico = agregarDiagnostico();
                break;
            case "2":
                diagnostico = "No hay diagnóstico para este paciente.";
                break;
            default:
                System.out.println("Surgió un problema al generar el diagnóstico."); // Caso por default en caso de que hubiera algún error
        }
    }

    public void deseaAgregarTratamiento(){
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("¿Desea agregar un tratamiento? 1. Sí - 2. No ");
            opcion = scanner.nextLine();
        } while(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2"));

        switch (opcion) {
            case "1":
                agregarTratamiento();
                break;
            case "2":
                tratamiento = "No hay tratamiento para este paciente";
                break;
            default:
                System.out.println("Surgió un problema al generar el tratamiento."); // Caso por default en caso de que hubiera algún error
        }
    }

    public void agregarDatosUsuario() {
        System.out.println("Ingrese los datos del usuario: ");
        propietario.agregarDatos();
    }

    public void agregarDatosMascota() {
        System.out.println("Ingrese los datos del paciente: ");

    }

    public String agregarDiagnostico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el diagnóstico del paciente: ");
        return scanner.nextLine();
    }

    public void agregarTratamiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tratamiento del paciente: ");
        tratamiento = scanner.nextLine();
    }

    public void mostrarFichaMedica() {
        System.out.println("El rut del propietario es " + propietario.getRut());
        System.out.println(diagnostico);
        System.out.println(tratamiento);
    }
}
