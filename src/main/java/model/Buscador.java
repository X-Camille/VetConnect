package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Buscador {

    private String rut, nombrePropietario, nombreMascota, fecha;
    private ArrayList<FichaMedica> fichasMedicas;
    private ArrayList<FichaMedica> fichasEncontradas;

    public Buscador(ArrayList<FichaMedica> fichasMedicas){
        this.fichasMedicas = fichasMedicas;
    }

    public ArrayList<FichaMedica> iniciarBusquedaPorDatos(String[] datos) {
        inicializarVariablesBusqueda(datos);

        fichasEncontradas = new ArrayList<>();

        for (FichaMedica ficha : fichasMedicas) {
            if (cumpleCondicionesBusqueda(ficha)) {
                fichasEncontradas.add(ficha);
            }
        }
        return fichasEncontradas;
    }

    private boolean cumpleCondicionesBusqueda(FichaMedica ficha) {
        return (rut.isEmpty() || ficha.getPropietario().getRut().equals(rut))
                && (nombrePropietario.isEmpty() || ficha.getPropietario().getNombre().equalsIgnoreCase(nombrePropietario))
                && (nombreMascota.isEmpty() || ficha.getMascota().getNombreMascota().equalsIgnoreCase(nombreMascota))
                && (fecha.isEmpty() || ficha.getMascota().getFechaNacMascota().equals(LocalDate.parse(fecha)));
    }

    public void inicializarVariablesBusqueda(String[] datos){
        this.rut = datos[0];
        this.nombrePropietario = datos[1];
        this.nombreMascota = datos[2];
        this.fecha = datos[3];
    }

}
