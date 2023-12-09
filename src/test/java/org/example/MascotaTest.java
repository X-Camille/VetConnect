package org.example;

import static org.junit.Assert.*;

import org.example.Mascota;
import org.junit.Test;
import java.time.LocalDate;

public class MascotaTest {

    @Test
    public void testGetEspecieMascota() {
        // Crear una mascota con una especie específica
        Mascota mascota = new Mascota("Fido", "Perro", "Labrador", LocalDate.now(), "Macho");

        // Verificar que la especie obtenida sea la esperada
        assertEquals("Perro", mascota.getEspecieMascota());
    }

    @Test
    public void testSetEspecieMascota() {
        // Crear una mascota
        Mascota mascota = new Mascota("Nombre", "EspecieAntigua", "Raza", LocalDate.now(), "Sexo");

        // Cambiar la especie de la mascota
        mascota.setEspecieMascota("NuevaEspecie");

        // Verificar que la especie cambiada sea la esperada
        assertEquals("NuevaEspecie", mascota.getEspecieMascota());
    }

    @Test
    public void testGetRazaMascota() {
        // Crear una mascota con una raza específica
        Mascota mascota = new Mascota("Fido", "Perro", "Labrador", LocalDate.now(), "Macho");

        // Verificar que la raza obtenida sea la esperada
        assertEquals("Labrador", mascota.getRazaMascota());
    }

    @Test
    public void testSetRazaMascota() {
        // Crear una mascota
        Mascota mascota = new Mascota("Nombre", "Especie", "RazaAntigua", LocalDate.now(), "Sexo");

        // Cambiar la raza de la mascota
        mascota.setRazaMascota("NuevaRaza");

        // Verificar que la raza cambiada sea la esperada
        assertEquals("NuevaRaza", mascota.getRazaMascota());
    }

    @Test
    public void testGetFechaNacMascota() {
        // Crear una mascota con una fecha de nacimiento específica
        LocalDate fechaNacimiento = LocalDate.of(2020, 1, 1);
        Mascota mascota = new Mascota("Fido", "Perro", "Labrador", fechaNacimiento, "Macho");

        // Verificar que la fecha de nacimiento obtenida sea la esperada
        assertEquals(fechaNacimiento, mascota.getFechaNacMascota());
    }

    @Test
    public void testSetFechaNacMascota() {
        // Crear una mascota
        Mascota mascota = new Mascota("Nombre", "Especie", "Raza", LocalDate.now(), "Sexo");

        // Cambiar la fecha de nacimiento de la mascota
        LocalDate nuevaFechaNac = LocalDate.of(2021, 2, 2);
        mascota.setFechaNacMascota(nuevaFechaNac);

        // Verificar que la fecha de nacimiento cambiada sea la esperada
        assertEquals(nuevaFechaNac, mascota.getFechaNacMascota());
    }

    @Test
    public void testGetSexoMascota() {
        // Crear una mascota con un sexo específico
        Mascota mascota = new Mascota("Fido", "Perro", "Labrador", LocalDate.now(), "Macho");

        // Verificar que el sexo obtenido sea el esperado
        assertEquals("Macho", mascota.getSexoMascota());
    }

    @Test
    public void testSetSexoMascota() {
        // Crear una mascota
        Mascota mascota = new Mascota("Nombre", "Especie", "Raza", LocalDate.now(), "SexoAntiguo");

        // Cambiar el sexo de la mascota
        mascota.setSexoMascota("NuevoSexo");

        // Verificar que el sexo cambiado sea el esperado
        assertEquals("NuevoSexo", mascota.getSexoMascota());
    }

    // Ajusta las pruebas según la lógica específica de tu aplicación.
}
