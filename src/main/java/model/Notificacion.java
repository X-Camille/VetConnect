package model;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Notificacion {

    private String encabezado, cuerpo;
    private LocalDate fecha;

    private LocalDate fechaValida(String fechaString){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate fecha = LocalDate.parse(fechaString, formato);
            if (fecha.isBefore(LocalDate.now())) return null;
            return fecha;
        } catch (Exception e) {
            System.err.println("Error al convertir la fecha: " + e.getMessage());
            return null;
        }
    }

    public Notificacion(String encabezado, String cuerpo, String fecha){
        if ((fechaValida(fecha) != null)&&(!cuerpo.isEmpty())&&(!encabezado.isEmpty())){
            this.fecha = fechaValida(fecha);
            this.cuerpo = cuerpo;
            this.encabezado = encabezado;
        } else throw new IllegalArgumentException("La fecha ingresada no es válida.");
    }

    private void crearNotificacion(){

        TrayIcon trayIcon = new TrayIcon(new ImageIcon("src/main/java/model/icon.jpg").getImage());
        trayIcon.setToolTip(this.encabezado); //hay que agregar una imagen de icono, usé un placeholder haha

        try {
            SystemTray.getSystemTray().add(trayIcon);

            trayIcon.displayMessage(this.encabezado, this.cuerpo, TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void lanzarNotificacion(){
        if (SystemTray.isSupported()){
            if (LocalDate.now().equals(this.fecha)){
                crearNotificacion();
            } else {
                System.out.println("Error, fecha no correspondiente.");
            }
        } else {
            System.out.println("SystemTray no disponible en su sistema");
        }
    }

}
