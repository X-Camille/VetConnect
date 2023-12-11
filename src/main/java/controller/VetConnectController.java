package controller;
import data.GestorDatos;
import data.GestorPDF;
import model.Buscador;
import model.FichaMedica;
import model.Mascota;
import model.Propietario;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VetConnectController {
    private Mascota mascota;
    private Propietario propietario;
    private String diagnostico;
    private String tratamiento;

    private FichaMedica fichaEditada;

    public FichaMedica getFichaEditada(){
        return fichaEditada;
    }
    public Mascota getMascota(){
        return mascota;
    }

    public Propietario getPropietario(){
        return propietario;
    }

    public String getDiagnostico(){
        return diagnostico;
    }

    public String getTratamiento(){
        return tratamiento;
    }

    public final GestorDatos gestorDatos = new GestorDatos();
    public boolean validarEntradasMascotas(String[] datos) {
        if(comprobarSiCamposVacios(datos) || !cadenasValidasMascotas(datos) || !manejoExcepcionFechaValida(datos[4])){
            return false;
        } else {
            mascota = new Mascota(datos[0], datos[1], datos[2], datos[3], LocalDate.parse(datos[4]));
            return true;
        }
    }

    public boolean manejoExcepcionFechaValida(String cadenaFecha){
        try {
            LocalDate fecha = LocalDate.parse(cadenaFecha);
            return true;
        } catch (Exception e) {
            System.err.println("Formato de fecha no válido.");
            return false;
        }
    }
    public boolean comprobarSiCamposVacios(String[] datos) {
        for (String dato : datos) {
            if (dato == null || dato.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean cadenasValidasMascotas(String[] datos) {
        for (int i=0; i < (datos.length-1); i++) {
            if (!datos[i].matches("^[^0-9]*$")) {
                return false;
            }
        }
        return true;
    }

    public boolean validarEntradasPropietario(String[] datos){
        if(comprobarSiCamposVacios(datos) || !cadenasValidasPropietario(datos)){
           return false;
        } else {
            propietario = new Propietario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
            if(propietario.validarRut(datos[2])){
                return true;
            } else {
                propietario = null;
                return false;
            }
        }
    }

    public boolean cadenasValidasPropietario(String[] datos) {
        return datos[0].matches("^[^0-9]*$") || datos[1].matches("^[^0-9]*$");
    }


    public void validarEntradasDescripcion(String[] datos){
        if(true == true){
            diagnostico = datos[0];
            tratamiento = datos[1];
        }
    }

    public void enviarDatos(){
        FichaMedica fichaMedica = new FichaMedica(mascota, propietario, diagnostico, tratamiento);
        if (fichaEditada != null) {
            gestorDatos.modificarDato(fichaMedica, fichaEditada,"C:/Users/Lenovo/Desktop/fichas_medicas.txt");
        } else {
            gestorDatos.registrarDato(fichaMedica, "C:/Users/Lenovo/Desktop/fichas_medicas.txt");
        }
    }

    public ArrayList<FichaMedica> obtenerDatosDelArchivo(){
        return gestorDatos.leerArchivoFichaMedica("C:/Users/Lenovo/Desktop/fichas_medicas.txt");
    }

    public ArrayList<FichaMedica> buscarFichasMedicas(String[] datos){
        ArrayList<FichaMedica> fichasMedicas = obtenerDatosDelArchivo();
        Buscador buscador = new Buscador(fichasMedicas);
        return buscador.iniciarBusquedaPorDatos(datos);
    }

    public void editarFichaMedica(FichaMedica ficha){
        mascota = ficha.getMascota();
        propietario = ficha.getPropietario();
        diagnostico = ficha.getDiagnostico();
        tratamiento = ficha.getTratamiento();
        fichaEditada = ficha;
    }

    public boolean eliminarFichaMedica(FichaMedica ficha){
        return gestorDatos.eliminarFichaMedica(ficha, "C:/Users/Lenovo/Desktop/fichas_medicas.txt");
    }

    public boolean generarPDF(FichaMedica ficha) throws IOException {
        GestorPDF gestor = new GestorPDF();
        return gestor.generarArchivoPDF(ficha);
    }
}
