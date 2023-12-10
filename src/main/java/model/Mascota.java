package model;
import java.time.LocalDate;

public class Mascota {
    private String nombreMascota;
    private String especie;
    private String raza;
    private String sexo;
    private LocalDate fechaNacMascota;

    public Mascota(String nombre, String especie, String raza, String sexo, LocalDate fechaNac) {
        this.nombreMascota = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.fechaNacMascota = fechaNac;
    }
    public String getNombreMascota() {
        return nombreMascota;
    }
    public void setNombreMascota(String Nombre) {
        nombreMascota = Nombre;
    }
    public String getEspecieMascota() {
        return especie;
    }
    public void setEspecieMascota(String Especie) {
        especie = Especie;
    }
    public String getRazaMascota() {
        return raza;
    }
    public void setRazaMascota(String Raza) {
        raza = Raza;
    }
    public LocalDate getFechaNacMascota() {
        return fechaNacMascota;
    }
    public String getSexoMascota() {
        return sexo;
    }
    public void setSexoMascota(String sexoMascota) {
        sexo = sexoMascota;
    }
    public void setFechaNacMascota(LocalDate fechaNacMascota) {
        this.fechaNacMascota = fechaNacMascota;
    }
    public String toString(){
        return getNombreMascota() + "/" + getEspecieMascota() + "/" + getRazaMascota() + "/" + getSexoMascota() + "/" + getFechaNacMascota() + "/";
    }

}