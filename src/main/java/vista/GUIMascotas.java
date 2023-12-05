package vista;


import model.Mascota;

import javax.swing.*;
import java.time.LocalDate;

public class GUIMascotas {
/*
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();
        Mascota mascota = new Mascota("melo", "gato", "melo",
                hoy, "Macho");
        GUIMascotas ventana = new GUIMascotas(mascota);
        ventana.ventana().setVisible(true);
    }

    private Mascota mascota;

    public GUIMascotas(Mascota mascota) {
        this.mascota = mascota;
    }

    public JFrame ventana(){
        GUIVetConnect ventana = new GUIVetConnect(clinica);
        JFrame frame = ventana.Ventana();
        JPanel panelNombre = panelPequeño(datoInfo("Nombre"),
                informacion(this.mascota.getNombreMascota()));
        frame.add(panelNombre);
        JPanel panel1 = panelGrande(panelPequeño(datoInfo("Sexo"),
                informacion(this.mascota.getSexoMascota())),panelPequeño(datoInfo("Especie"),
                informacion(this.mascota.getEspecieMascota())));
        frame.add(panel1);
        JPanel panel2 = panelGrande(panelPequeño(datoInfo("raza"),
                informacion(this.mascota.getRazaMascota())),panelPequeño(datoInfo("Nacimiento"),
                informacion(this.mascota.getFechaNacMascota().toString())));
        frame.add(panel2);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        return frame;
    }

    public JPanel panelPequeño(JLabel etiqueta, JTextField info){
        JPanel panel = new JPanel();
        panel.add(etiqueta);
        panel.add(info);
        return panel;
    }
    public JPanel panelGrande(JPanel panel1, JPanel panel2){
        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        return panel;
    }

    public JTextField informacion(String info){
        JTextField dato = new JTextField(info);
        dato.setEditable(false);
        return dato;
    }

    public JLabel datoInfo(String info){
        JLabel dato = new JLabel(info);
        return dato;
    }
*/
}