package controller;
import data.GestorDatos;
import model.Buscador;
import model.FichaMedica;
import model.Mascota;
import model.Propietario;

import java.util.ArrayList;
import java.util.Objects;

public class VetConnectController {
    private Mascota mascota;
    private Propietario propietario;
    private String diagnostico;
    private String tratamiento;

    private FichaMedica fichaEditada;

    public FichaMedica getFichaEditando(){
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
    public void validarEntradasMascotas(String[] datos) {
        if(true == true){
            mascota = new Mascota(datos[0], datos[1], datos[2], datos[3], datos[4]);
        }
    }

    public void validarEntradasPropietario(String[] datos){
        if(true == true){
            propietario = new Propietario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
        }
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
}
