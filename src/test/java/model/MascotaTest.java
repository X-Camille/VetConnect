package model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class MascotaTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String nombre = "Firulais";
        String especie = "Perro";
        String raza = "Labrador";
        String sexo = "Macho";
        String fechaNac = "2020-01-01";

        // Act
        Mascota mascota = new Mascota(nombre, especie, raza, sexo, LocalDate.parse(fechaNac));

        // Assert
        assertEquals(nombre, mascota.getNombreMascota());
        assertEquals(especie, mascota.getEspecieMascota());
        assertEquals(raza, mascota.getRazaMascota());
        assertEquals(sexo, mascota.getSexoMascota());
        assertEquals(LocalDate.parse(fechaNac), mascota.getFechaNacMascota());
    }

    @Test
    public void testSetters() {
        // Arrange
        Mascota mascota = new Mascota("Firulais", "Perro", "Labrador", "Macho", LocalDate.parse("2020-01-01"));

        // Act
        mascota.setNombreMascota("NuevoNombre");
        mascota.setEspecieMascota("Gato");
        mascota.setRazaMascota("Siames");
        mascota.setSexoMascota("Hembra");
        mascota.setFechaNacMascota(LocalDate.parse("2019-05-15"));

        // Assert
        assertEquals("NuevoNombre", mascota.getNombreMascota());
        assertEquals("Gato", mascota.getEspecieMascota());
        assertEquals("Siames", mascota.getRazaMascota());
        assertEquals("Hembra", mascota.getSexoMascota());
        assertEquals(LocalDate.parse("2019-05-15"), mascota.getFechaNacMascota());
    }

    @Test
    public void testToString() {
        // Arrange
        Mascota mascota = new Mascota("Firulais", "Perro", "Labrador", "Macho", LocalDate.parse("2020-01-01"));

        // Act
        String result = mascota.toString();

        // Assert
        assertEquals("Firulais|Perro|Labrador|Macho|2020-01-01|", result);
    }
}