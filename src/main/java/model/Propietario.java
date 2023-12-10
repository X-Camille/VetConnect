ackage model;
import java.util.*;
public class Propietario {
    // Atributos
    public String nombre;
    public String apellido;
    public String rut;
    public String telefono;
    public String correo;
    public String direccion;


    // constructor
    public Propietario(String nombre, String apellido, String rut, String telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Propietario(){

    }

    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getRut(){
        return rut;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getCorreo(){
        return correo;
    }
    public String getDireccion(){
        return direccion;
    }

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

    public String toString(){
        return getNombre() + "/" + getApellido() + "/" + getRut() + "/" + getTelefono() + "/" + getCorreo() + "/" + getDireccion() + "/";
    }
}
