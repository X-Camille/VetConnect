package vista;

import controller.VetConnectController;
import model.Notificacion;
import model.VetConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUINotificacion extends JFrame implements ActionListener {

    private final VetConnect clinica;
    private JTextField campoCabeza, campoCuerpo, campoFecha;
    private JLabel textoCabeza, textoCuerpo, textoFecha;
    private JButton bCrearNotificacion, bAtras;
    private JPanel panelPrincipal;
    private VetConnectController controller;

    public GUINotificacion(VetConnect clinica, VetConnectController controller) {
        this.clinica = clinica;
        this.controller = controller;
    }

    public GUINotificacion(VetConnect clinica) {
        this.clinica = clinica;
    }

    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(0);

        encabezado();
        cuerpo();
        agregarFecha();

        botonCrear();
        atras();

        add(panelPrincipal);

        setVisible(true);
        setResizable(false);
        setSize(360, 400);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        return panelPrincipal;
    }

    private void encabezado() {
        JLabel labelCabeza = new JLabel("Ingrese título de la notificación");
        JTextField campoCabeza = new JTextField();
        campoCabeza.setBounds(20, 70, 300, 20);
        labelCabeza.setFont(new Font("Arial", Font.BOLD, 14));
        labelCabeza.setBounds(20, 40, 300, 20);
        this.textoCabeza = labelCabeza;
        this.campoCabeza = campoCabeza;
        this.campoCabeza.addActionListener(this);
        this.add(labelCabeza);
        this.add(campoCabeza);
    }


    private void cuerpo() {
        JLabel labelCuerpo = new JLabel("Ingrese contenido de la notificación");
        JTextField campoCuerpo = new JTextField();
        campoCuerpo.setBounds(20, 130, 300, 80);
        labelCuerpo.setFont(new Font("Arial", Font.BOLD, 14));
        labelCuerpo.setBounds(20, 100, 300, 20);
        this.textoCuerpo = labelCuerpo;
        this.campoCuerpo = campoCuerpo;
        this.campoCuerpo.addActionListener(this);
        this.add(labelCuerpo);
        this.add(campoCuerpo);
    }


    private void agregarFecha() {
        JLabel labelFecha = new JLabel("Ingrese fecha (yyyy-MM-dd)");
        JTextField campoFecha = new JTextField();
        campoFecha.setBounds(20, 250, 300, 20);
        labelFecha.setFont(new Font("Arial", Font.BOLD, 14));
        labelFecha.setBounds(20, 220, 300, 20);
        this.textoFecha = labelFecha;
        this.campoFecha = campoFecha;
        this.add(labelFecha);
        this.add(campoFecha);
    }

    private void botonCrear() {
        JButton botonCrear = new JButton("CREAR NOTIFICACIÓN");
        botonCrear.setBounds(20, 280, 300, 30);
        botonCrear.setFont(new Font("Arial", Font.BOLD, 14));
        this.bCrearNotificacion = botonCrear;
        this.add(botonCrear);
        this.bCrearNotificacion.addActionListener(this);
    }
    private void atras() {
        JButton botonAtras = new JButton("ATRÁS");
        botonAtras.setBounds(20, 320, 300, 30);
        botonAtras.setFont(new Font("Arial", Font.BOLD, 14));
        this.bAtras = botonAtras;
        this.add(botonAtras);
        this.bAtras.addActionListener(this);
    }

    private Notificacion crearNotificacion(){
        try {
            return new Notificacion(this.campoCabeza.getText(),
                    this.campoCuerpo.getText(),this.campoFecha.getText());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAtras){
            new GUIVetConnect(this.clinica).mostrarInterfaz();
            this.dispose();
        }
        if (e.getSource() == bCrearNotificacion){
            Notificacion notificacion = crearNotificacion();
            if (notificacion != null){
                JOptionPane.showMessageDialog(this,"Notificación creada correctamente");
                new GUIVetConnect(this.clinica).mostrarInterfaz();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Error, ingrese correctamente los datos");
            }
        }
    }
}
