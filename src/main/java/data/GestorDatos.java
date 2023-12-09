package data;

import model.FichaMedica;
import model.Mascota;
import model.Propietario;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class GestorDatos {
    private String[] lineas;

    public ArrayList<FichaMedica> leerArchivoFichaMedica(String direccionArchivo) {
        ArrayList<FichaMedica> datosFichaMedica = new ArrayList<FichaMedica>(){};

        try (BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("/");
                if (datos.length == 13) {
                    Mascota mascota = new Mascota(datos[0], datos[1], datos[2], datos[3], LocalDate.parse(datos[4]));
                    Propietario propietario = new Propietario(datos[5], datos[6], datos[7], datos[8], datos[9], datos[10]);
                    FichaMedica fichaMedica = new FichaMedica(mascota, propietario, datos[11], datos[12]);
                    datosFichaMedica.add(fichaMedica);
                } else {
                    System.out.println("Error al generar las fichas médicas.");
                }
            }
            return datosFichaMedica;
        } catch (IOException e) {
            System.out.println("No se encontraron datos en el archivo.");
            throw new RuntimeException(e);
        }
    }

    public boolean registrarDato(FichaMedica fichaMedica, String direccionArchivo) {
        boolean lineaVacia=false;
        try {
            File file = new File(direccionArchivo);

            if (!file.exists()) {
                lineaVacia=true;
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);

            if(!lineaVacia){
                bw.newLine();
            }

            bw.write(fichaMedica.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador");
            return false;
        }
    }

    public boolean modificarDato(FichaMedica fichaActualizada, FichaMedica fichaOriginal, String direccionArchivo) {
        try {
            ArrayList<FichaMedica> fichasOriginales = leerArchivoFichaMedica("C:/Users/Lenovo/Desktop/fichas_medicas.txt");
            ArrayList<FichaMedica> fichasNuevas = new ArrayList<>();

            for (FichaMedica ficha : fichasOriginales){
                if(Objects.equals(ficha.toString(), fichaOriginal.toString())){
                    fichasNuevas.add(fichaActualizada);
                } else {
                    fichasNuevas.add(ficha);
                }
            }

            System.out.println("Contenido de fichasNuevas:");
            for (FichaMedica ficha : fichasNuevas) {
                System.out.println(ficha.toString());
            }

            escribirFichasMedicas(fichasNuevas, direccionArchivo);

            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar dato. Por favor contactar al administrador.");
            e.printStackTrace(); // Esto imprimirá la traza de la excepción para diagnosticar problemas.
            return false;
        }
    }

    public boolean eliminarFichaMedica(FichaMedica fichaAEliminar, String direccionArchivo){
        try {
            ArrayList<FichaMedica> fichasOriginales = leerArchivoFichaMedica("C:/Users/Lenovo/Desktop/fichas_medicas.txt");
            ArrayList<FichaMedica> fichasNuevas = new ArrayList<>();

            for (FichaMedica ficha: fichasOriginales) {
                if (!Objects.equals(ficha.toString(), fichaAEliminar.toString())) {
                    fichasNuevas.add(ficha);
                }
            }
            escribirFichasMedicas(fichasNuevas, direccionArchivo);
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar dato. Por favor contactar al administrador.");
            e.printStackTrace(); // Esto imprimirá la traza de la excepción para diagnosticar problemas.
            return false;
        }
    }


    private void escribirFichasMedicas(ArrayList<FichaMedica> fichas, String direccionArchivo) {
        try {
            FileWriter fw = new FileWriter(direccionArchivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (FichaMedica ficha : fichas) {
                bw.write(ficha.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir las fichas médicas. Favor contactar al administrador.");
        }
    }
}