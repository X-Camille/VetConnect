package model;

import model.Mascota;
import model.Propietario;

import java.time.LocalDate;

public class FichaMedica {
    private String diagnostico;
    private String tratamiento;
    private final Propietario propietario;
    private final Mascota mascota;

    public FichaMedica(Mascota mascota, Propietario propietario, String diagnostico, String tratamiento) {
        this.mascota = mascota;
        this.propietario = propietario;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public FichaMedica() { // Constructor para probar UT
        this.mascota = null;
        this.propietario = null;
        this.diagnostico = "";
        this.tratamiento = "";
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public String toString() {
        return getMascota().toString() + "/" + getPropietario().toString() + "/" + getDiagnostico() + "/" + getTratamiento() + "/";
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public LocalDate getFecha() {
        // Devuelve la fecha actual
        return LocalDate.now();
    }
}
