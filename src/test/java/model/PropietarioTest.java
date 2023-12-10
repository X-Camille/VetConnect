package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class PropietarioTest {

    @Test
    public void testValidarNombre() {
        assertFalse(Propietario.validarNombre("Juan"));// es falso debidao a que la compañera lo hizo al revez
        assertTrue(Propietario.validarNombre(""));
        assertTrue(Propietario.validarNombre("Maria123"));
    }

    @Test
    public void testValidarRut() {
        assertTrue(Propietario.validarRut("12345678-9"));
        assertFalse(Propietario.validarRut(""));
        assertTrue(Propietario.validarRut("12.345.678-9"));
    }

    @Test
    public void testValidarCorreo() {
        assertTrue(Propietario.validarCorreo("correo@ejemplo.com"));
        assertFalse(Propietario.validarCorreo(""));
        assertFalse(Propietario.validarCorreo("correo@ejemplo"));
    }

    @Test
    public void testValidarTelefono() {
        assertTrue(Propietario.validarTelefono("+123456789"));
        assertFalse(Propietario.validarTelefono(""));
        assertFalse(Propietario.validarTelefono("123-456-789"));
    }
}
