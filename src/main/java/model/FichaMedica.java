package model;

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

    public FichaMedica(){ // Constructor para probar UT
        this.mascota = null;
        this.propietario = null;
        this.diagnostico = "";
        this.tratamiento = "";
    }

    public Propietario getPropietario(){
        return propietario;
    }

    public Mascota getMascota(){
        return mascota;
    }

    public String getDiagnostico(){
        return diagnostico;
    }

    public String getTratamiento(){
        return tratamiento;
    }

    public void setDiagnostico(String diagnóstico) {
        this.diagnostico = diagnóstico;
    }

    public void setTratamiento(String tratamiento){
        this.tratamiento = tratamiento;
    }
    public String toString(){
        return getMascota().toString() + getPropietario().toString() + getDiagnostico() + "|" + getTratamiento() + "|";
    }
}

