package model;

public class Propietario {
    // Atributos
    public String nombre;
    public String apellido;
    public String rut;
    public String telefono;
    public String correo;
    public String direccion;


    // constructor
    public Propietario(String nombre, String apellido, String rut) {
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

    public static Boolean validarNombre(String nombre) {
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


    public static Boolean validarRut(String rut) {
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
    public static boolean validarCorreo(String correo) {
        // Verificar si el correo no está vacío y contiene al menos un "@" y un "."
        return correo != null && !correo.isEmpty() && correo.contains("@") && correo.contains(".");
    }
    public String toString(){
        return getNombre() + "/" + getApellido() + "/" + getRut() + "/" + getTelefono() + "/" + getCorreo() + "/" + getDireccion() + "/";
    }
    public static boolean validarTelefono(String telefono) {
        // Verificar si el teléfono no es vacío ni null
        if (telefono == null || telefono.isEmpty()) {
            return false;
        }

        // Eliminar todos los espacios
        telefono = telefono.replaceAll("\\s", "");

        // Verificar si contiene al menos 5 y no más de 13 caracteres
        if (telefono.length() < 5 || telefono.length() > 13) {
            return false;
        }

        // Verificar que no sea un número negativo
        if (telefono.startsWith("-")) {
            return false;
        }

        // Verificar si todos los caracteres son números o el símbolo "+"
        for (char caracter : telefono.toCharArray()) {
            if (!Character.isDigit(caracter) && caracter != '+') {
                return false;
            }
        }

        // Si pasa todas las verificaciones, el teléfono es válido
        return true;
    }
}
