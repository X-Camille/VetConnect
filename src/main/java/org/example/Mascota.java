package org.example;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Mascota {
    // atributos de la clase de mascota
    private String NombreMascota;
    private String EspecieMascota;
    private String RazaMascota;
    private LocalDate FechaNacMascota;
    private String SexoMascota;

    // constructor
    public Mascota(String nombre, String especie, String raza, LocalDate fechaNac, String sexo) {
        NombreMascota = nombre;
        EspecieMascota = especie;
        RazaMascota = raza;
        FechaNacMascota = fechaNac;
        SexoMascota = sexo;
    }

    // get y set de NombreMascota
    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String Nombre) {
        NombreMascota = Nombre;
    }

    // get y set de EspecieMascota
    public String getEspecieMascota() {
        return EspecieMascota;
    }

    public void setEspecieMascota(String Especie) {
        EspecieMascota = Especie;
    }

    //get y set de RazaMascota
    public String getRazaMascota() {
        return RazaMascota;
    }

    public void setRazaMascota(String Raza) {
        RazaMascota = Raza;
    }

    //get y set de FechaNacMascota
    public LocalDate getFechaNacMascota() {
        return FechaNacMascota;
    }

    public void setFechaNacMascota(LocalDate Fecha) {
        FechaNacMascota = Fecha;
    }


    //get yset de SexoMascota
    public String getSexoMascota() {
        return SexoMascota;
    }

    public void setSexoMascota(String sexoMascota) {
        SexoMascota = sexoMascota;
    }


    public String calcularEdad() {
        LocalDate fechahoy = LocalDate.now();
        Period periodo = Period.between(FechaNacMascota, fechahoy);
        return (periodo.getYears() + " años y " + periodo.getMonths() + "meses.");
    }

    public void setDueno() {
        System.out.println("Esto es un placeholder!!");
        System.out.println("El dueño es otro objeto!!");
    }

    public void setFichaMedica(){
        System.out.println("Esto es un placeholder!!");
        System.out.println("La ficha es otro objeto!!!");
    }

}