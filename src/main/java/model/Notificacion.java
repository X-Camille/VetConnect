package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Notificacion {

    private String encabezado, cuerpo;
    private LocalDate fecha;

    private LocalDate FechaValida(String fechaString){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate fecha = LocalDate.parse(fechaString, formato);
            if (fecha.isBefore(LocalDate.now())) return null;
            return fecha;
        } catch (Exception e) {
            System.err.println("Error al convertir la fecha: " + e.getMessage());
            return null;
        }
    }

    public Notificacion(String encabezado, String cuerpo, String fecha){
        if ((FechaValida(fecha) != null)&&(!cuerpo.isEmpty())&&(!encabezado.isEmpty())){
            this.fecha = FechaValida(fecha);
            this.cuerpo = cuerpo;
            this.encabezado = encabezado;
        } else throw new IllegalArgumentException("La fecha ingresada no es válida.");
    }

}