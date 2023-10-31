package org.example.Ventanas;

import org.example.Mascota;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class VentanaInicio {

    private ArrayList<Mascota> mascotas;

    public VentanaInicio(){
        this.mascotas = new ArrayList<>();
        LocalDate meloCumple = LocalDate.of(2017,9,20);
        Mascota melo1 = new Mascota("Melo Gordo", "Gato",
                "DPL", meloCumple,"Macho");
        Mascota melo2 = new Mascota("Melo Flaco", "Gato",
                "DPL", meloCumple,"Macho");
        this.mascotas.add(melo1);
        this.mascotas.add(melo2);
    }

    public static void main(String[] args) {
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.Ventana().setVisible(true);
    }

    public JFrame Ventana(){
        JFrame ventana = new JFrame("VetConnect");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500,300);
        JPanel panel = PanelSuperior();
        ventana.add(panel);
        return ventana;
    }
    public JButton BackButton(){
        JButton back= new JButton("<--");
        return back;
    }
    public JPanel PanelSuperior(){
        JPanel panel = new JPanel();
        panel.add(BackButton());
        panel.add(listaMascotas());
        panel.add(AddButton());
        return panel;
    }

    public JComboBox listaMascotas(){
        JComboBox mascotasbox = new JComboBox();
        for (Mascota melo : mascotas) {
            mascotasbox.addItem(melo.getNombreMascota());
        }
        mascotasbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mascota mascota = new Mascota("nombre","especie",
                        "raza",LocalDate.now(),"sexo");
                String animal = (String) mascotasbox.getSelectedItem();
                for (Mascota melo : mascotas){
                    if (animal.equals(melo.getNombreMascota())){
                        mascota = melo;
                    }
                }
                VentanaMascota ventanaMascota = new VentanaMascota(mascota);
                ventanaMascota.ventana().setVisible(true);
            }
        });
        return mascotasbox;
    }

    public JButton AddButton(){
        JButton add= new JButton("+");
        return add;
    }
}
