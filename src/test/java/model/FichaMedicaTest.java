package model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class FichaMedicaTest {

    @Test
    public void testConstructorValido() {
        // Arrange
        Mascota mascota = new Mascota("Max", "Perro", "Labrador", "Macho", LocalDate.parse("2020-01-01"));
        Propietario propietario = new Propietario("John Doe", "Doe", "122872732","john@example.com", "123 Main St", "Los Ángeles 123");

        // Act
        FichaMedica fichaMedica = new FichaMedica(mascota, propietario, "Diagnóstico", "Tratamiento");

        // Assert
        assertNotNull(fichaMedica);
        assertEquals(mascota, fichaMedica.getMascota());
        assertEquals(propietario, fichaMedica.getPropietario());
        assertEquals("Diagnóstico", fichaMedica.getDiagnostico());
        assertEquals("Tratamiento", fichaMedica.getTratamiento());
    }

    @Test
    public void testSetters() {
        // Arrange
        FichaMedica fichaMedica = new FichaMedica();

        // Act
        fichaMedica.setDiagnostico("Nuevo Diagnóstico");
        fichaMedica.setTratamiento("Nuevo Tratamiento");

        // Assert
        assertEquals("Nuevo Diagnóstico", fichaMedica.getDiagnostico());
        assertEquals("Nuevo Tratamiento", fichaMedica.getTratamiento());
    }

    @Test
    public void testSettersVacios() {
        // Arrange
        FichaMedica fichaMedica = new FichaMedica();

        // Act
        fichaMedica.setDiagnostico("");
        fichaMedica.setTratamiento("");

        // Assert: Se espera que los valores vacíos sean válidos
        assertEquals("", fichaMedica.getDiagnostico());
        assertEquals("", fichaMedica.getTratamiento());
    }



}