package model;
import java.time.LocalDate;
import java.time.Period;

public class Mascota {
    public Mascota(String nombre, String especie, String raza, LocalDate fechaNac, String sexo) {
        NombreMascota = nombre;
        EspecieMascota = especie;
        RazaMascota = raza;
        FechaNacMascota = fechaNac;
        SexoMascota = sexo;
    }
    public Mascota(){

    }

    public static void main(String[] args) {

    }

    private String NombreMascota;

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String Nombre) {
        NombreMascota = Nombre;
    }

    private String EspecieMascota;

    public String getEspecieMascota() {
        return EspecieMascota;
    }

    public void setEspecieMascota(String Especie) {
        EspecieMascota = Especie;
    }

    private String RazaMascota;

    public String getRazaMascota() {
        return RazaMascota;
    }

    public void setRazaMascota(String Raza) {
        RazaMascota = Raza;
    }

    private LocalDate FechaNacMascota;

    public LocalDate getFechaNacMascota() {
        return FechaNacMascota;
    }

    public void setFechaNacMascota(LocalDate Fecha) {
        FechaNacMascota = Fecha;
    }

    private String SexoMascota;

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