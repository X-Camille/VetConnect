package data;
import model.FichaMedica;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.printing.PDFPageable;

import java.io.IOException;
import java.util.Date;

public class GestorPDF {

    private String[] lineasPdf;

    public boolean generarArchivoPDF(FichaMedica ficha) throws IOException{
        PDDocument documento = new PDDocument();
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
        String[] lineasPdf = this.obtenerLineasPdf(ficha);
        if (rellenarPDF(documento, pagina, lineasPdf)) {
            documento.save(this.generarNombrePdf(ficha));
            documento.close();
            System.out.println("Se ha generado " + this.generarNombrePdf(ficha));
            return true;
        }
        return false;
    }

    public boolean rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasVenta){
        try(PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)){
            for(int linea=0; linea < lineasVenta.length; linea++){
                contenidoPagina.beginText();
                contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight()-(10*linea));
                contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
                contenidoPagina.showText(lineasVenta[linea]);
                contenidoPagina.endText();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String[] obtenerLineasPdf(FichaMedica ficha){
        String[] lineasPdf = new String[18];
        lineasPdf[0] = "";
        lineasPdf[1] = "Ficha Médica de " + ficha.getMascota().getNombreMascota();
        lineasPdf[2] = "Datos propietarios: ";
        lineasPdf[3] = "Nombre: " + ficha.getPropietario().getNombre();
        lineasPdf[4] = "Apellido: " + ficha.getPropietario().getApellido();
        lineasPdf[5] = "Rut: " + ficha.getPropietario().getRut();
        lineasPdf[6] = "Teléfono: " + ficha.getPropietario().getTelefono();
        lineasPdf[7] = "Correo: " + ficha.getPropietario().getCorreo();
        lineasPdf[8] = "Dirección: " + ficha.getPropietario().getDireccion();
        lineasPdf[9] = "Datos mascota: ";
        lineasPdf[10] = "Nombre: " + ficha.getMascota().getNombreMascota();
        lineasPdf[11] = "Especie: " + ficha.getMascota().getEspecieMascota();
        lineasPdf[12] = "Raza: " + ficha.getMascota().getRazaMascota();
        lineasPdf[13] = "Sexo: " + ficha.getMascota().getSexoMascota();
        lineasPdf[14] = "Fecha de Nacimiento: " + ficha.getMascota().getFechaNacMascota();
        lineasPdf[15] = "Descripción: ";
        lineasPdf[16] = "Diagnóstico: " + ficha.getDiagnostico();
        lineasPdf[17] = "Tratamiento: " + ficha.getTratamiento();
        return lineasPdf;
    }
    private String generarNombrePdf(FichaMedica ficha){
        Date fecha = new Date();
        String fechaArchivo = fecha.toString();
        fechaArchivo = fechaArchivo.replace(" ","").replace(":", "");
        return ficha.getPropietario().getRut() + "_" + ficha.getMascota().getNombreMascota() + "_" + fechaArchivo + ".pdf";
    }
}