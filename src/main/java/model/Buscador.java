package model;

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

        boolean buscarPorRut = !rut.isEmpty();
        boolean buscarPorNombrePropietario = !nombrePropietario.isEmpty();
        boolean buscarPorNombreMascota = !nombreMascota.isEmpty();
        boolean buscarPorFecha = !fecha.isEmpty();

        fichasEncontradas = new ArrayList<>();

        for (FichaMedica ficha : fichasMedicas) {
            boolean coincideRut = (!buscarPorRut || ficha.getPropietario().getRut().equals(rut));
            boolean coincideNombrePropietario = (!buscarPorNombrePropietario || ficha.getPropietario().getNombre().equalsIgnoreCase(nombrePropietario));
            boolean coincideNombreMascota = (!buscarPorNombreMascota || ficha.getMascota().getNombreMascota().equalsIgnoreCase(nombreMascota));
            boolean coincideFecha = (!buscarPorFecha || ficha.getFecha().equalsIgnoreCase(fecha));

            if (coincideRut && coincideNombrePropietario && coincideNombreMascota && coincideFecha) {
                fichasEncontradas.add(ficha);
            }
        }
        return fichasEncontradas;
    }

    public void inicializarVariablesBusqueda(String[] datos){
        this.rut = datos[0];
        this.nombrePropietario = datos[1];
        this.nombreMascota = datos[2];
        this.fecha = datos[3];
    }

}
