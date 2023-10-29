package org.example.Ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaInicio {

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
        JComboBox mascotas = new JComboBox();
        mascotas.addItem("melo 1");
        mascotas.addItem("melo 2");
        return mascotas;
    }

    public JButton AddButton(){
        JButton add= new JButton("+");
        return add;
    }
}
