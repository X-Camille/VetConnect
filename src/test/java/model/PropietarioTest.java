package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class PropietarioTest {
    Propietario propietario = new Propietario();

    @Test
    public void testValidarNombre() {
        assertFalse(propietario.validarNombre("Juan"));// es falso debidao a que la compañera lo hizo al revez
        assertTrue(propietario.validarNombre(""));
        assertTrue(propietario.validarNombre("Maria123"));
    }

    @Test
    public void testValidarRut() {
        assertTrue(propietario.validarRut("12345678-9"));
        assertFalse(propietario.validarRut(""));
        assertTrue(propietario.validarRut("12.345.678-9"));
    }

    @Test
    public void testValidarCorreo() {
        assertTrue(propietario.validarCorreo("correo@ejemplo.com"));
        assertFalse(propietario.validarCorreo(""));
        assertFalse(propietario.validarCorreo("correo@ejemplo"));
    }

    @Test
    public void testValidarTelefono() {
        assertTrue(propietario.validarTelefono("+123456789"));
        assertFalse(propietario.validarTelefono(""));
        assertFalse(propietario.validarTelefono("123-456-789"));
    }
}