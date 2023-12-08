package org.example;

import org.example.Propietario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropietarioTest {

    @Test
    public void testValidarNombreConNombreVacio() {
        Propietario propietario = new Propietario();
        assertTrue(propietario.validarNombre(""));
    }

    @Test
    public void testValidarNombreConNumerosEnElNombre() {
        Propietario propietario = new Propietario();
        assertTrue(propietario.validarNombre("John123"));
    }

    @Test
    public void testValidarNombreConCaracteresEspeciales() {
        Propietario propietario = new Propietario();
        assertFalse(propietario.validarNombre("John@Doe"));
    }

    @Test
    public void testValidarNombreConNombreValido() {
        Propietario propietario = new Propietario();
        assertFalse(propietario.validarNombre("JohnDoe"));
    }

    @Test
    public void testValidarNombreConEspacios() {
        Propietario propietario = new Propietario();
        assertFalse(propietario.validarNombre("John Doe"));
    }

    @Test
    public void testValidarRutConRutVacio() {
        Propietario propietario = new Propietario();
        assertFalse(propietario.validarRut(""));
    }

    @Test
    public void testValidarRutConRutMenorDeOchoDigitos() {
        Propietario propietario = new Propietario();
        assertFalse(propietario.validarRut("1234567"));
    }

    @Test
    public void testValidarRutConRutMayorDeNueveDigitos() {
        Propietario propietario = new Propietario();
        assertFalse(propietario.validarRut("1234567890"));
    }

    @Test
    public void testValidarRutConRutInvalido() {
        Propietario propietario = new Propietario();
        assertTrue(propietario.validarRut("12345678-k"));
    }

    @Test
    public void testValidarRutConRutConDigitoInvalido() {
        Propietario propietario = new Propietario();
        assertFalse(propietario.validarRut("12345678A"));
    }
}
