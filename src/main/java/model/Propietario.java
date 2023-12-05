package model;
import java.util.*;
public class Propietario {
    // Atributos
    public String nombre;
    public String rut;

    Object rutNombre;

    // constructor
    public Propietario(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }



    // Métodos
    public Propietario agregarDatos(){
        do {
            System.out.print("Nombre: ");
            nombre = ingresarNombre();
        }while(validarNombre(nombre));

        do{
            System.out.print("RUT: ");
            rut = ingresarRut();
        }while(!validarRut(rut));
        Propietario propietario= new Propietario(nombre,rut);

        return propietario;
    }

    public String ingresarNombre(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public String ingresarRut(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    //xiao modifica
    public Boolean validarNombre(String nombre) {
        if (nombre.isEmpty()) {
            return true;  // Nombre vacío
        }

        for (int i = 0; i < nombre.length(); i++) {
            char caracter = nombre.charAt(i);
            if (Character.isDigit(caracter)) {
                return true;  // Contiene números
            }
        }

        return false;  // Nombre válido
    }



    // xiao modifica validar rut
    public Boolean validarRut(String rut) {
        if (rut.isEmpty()) {
            return false; // Si la cadena rut está vacía, retorna false
        }

        // Eliminar puntos y guiones del RUT
        rut = rut.replaceAll("[.\\-]", "");

        if (rut.length() < 8 || rut.length() > 9) {
            return false; // Verificar que el RUT tenga 8 o 9 caracteres después de eliminar puntos y guiones
        }

        String RutSinDigito = rut.substring(0, rut.length() - 1);
        char UltimoDigito = rut.charAt(rut.length() - 1);

        // Reemplazar 'k' minúscula por 'K' mayúscula, si es necesario
        if (Character.isLowerCase(UltimoDigito) && UltimoDigito == 'k') {
            UltimoDigito = 'K'; // Convertir 'k' minúscula a 'K' mayúscula si es necesario
        }

        // Verificar que RutSinDigito sea un número entero
        try {
            int ConvertirEnNumero = Integer.parseInt(RutSinDigito);
        } catch (NumberFormatException e) {
            return false; // Si la parte numérica no es un número, la validación falla
        }

        // Verificar que el último dígito sea 'K' o un número
        if (UltimoDigito != 'K' && (UltimoDigito < '0' || UltimoDigito > '9')) {
            return false;
        }

        return true; // RUT válido
    }

    public String getRut(){
        return rut;
    }

    public String getNombre(){
        return nombre;
    }

}
