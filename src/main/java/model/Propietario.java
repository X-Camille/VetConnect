package model;
import java.util.*;
public class Propietario {
    // Atributos
    private String nombre;
    private String rut;

    /*public Propietario(String nombre,String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    // Método Main
    public static void main(String[] args) {
        Propietario p1 = new Propietario(" "," ");
        p1.agregarDatos();
        System.out.println("Nombre: " + p1.getNombre());
        System.out.println("RUT: " + p1.getRut());
    }*/

    // Métodos
    public void agregarDatos(){
        do {
            System.out.print("Nombre: ");
            nombre = ingresarNombre();
        }while(!validarRut(nombre));

        do{
            System.out.print("RUT: ");
            rut = ingresarRut();
        }while(!validarRut(rut));
    }

    public String ingresarNombre(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public String ingresarRut(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public Boolean validarNombre(String nombre){
        return !nombre.isEmpty();
    }
    public Boolean validarRut(String rut){
        return !rut.isEmpty();// Ejemplo muy básico
    }

    public String getRut(){
        return rut;
    }

    public String getNombre(){
        return nombre;
    }

}
