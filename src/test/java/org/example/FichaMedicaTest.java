package org.example;

import org.example.FichaMedica;
import org.junit.Test;
import static org.junit.Assert.*;

public class FichaMedicaTest {

    @Test
    public void testDeseaAgregarDiagnostico_Opcion1() {
        FichaMedica fichaMedica = new FichaMedica("123456789");

        // Simula la entrada del usuario seleccionando "Sí"
        fichaMedica.setDiagnostico("Diagnóstico de prueba");

        assertEquals("Diagnóstico de prueba", fichaMedica.getDiagnostico());
    }

    @Test
    public void testDeseaAgregarDiagnostico_Opcion2() {
        FichaMedica fichaMedica = new FichaMedica("123456789");

        // Simula la entrada del usuario seleccionando "No"
        fichaMedica.setDiagnostico("No hay diagnóstico para este paciente.");

        assertEquals("No hay diagnóstico para este paciente.", fichaMedica.getDiagnostico());
    }

    @Test
    public void testAgregarTratamiento_Opcion1() {
        FichaMedica fichaMedica = new FichaMedica("123456789");

        // Simula la entrada del usuario seleccionando "Sí"
        fichaMedica.setTratamiento("Tratamiento de prueba");

        assertEquals("Tratamiento de prueba", fichaMedica.getTratamiento());
    }

    @Test
    public void testAgregarTratamiento_Opcion2() {
        FichaMedica fichaMedica = new FichaMedica("123456789");

        // Simula la entrada del usuario seleccionando "No"
        fichaMedica.setTratamiento("No hay tratamiento para este paciente");

        assertEquals("No hay tratamiento para este paciente", fichaMedica.getTratamiento());
    }


}
