package vista;


import controller.VetConnectController;
import model.Mascota;
import model.VetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUIMascota extends JFrame implements ActionListener{

    private final VetConnect clinica;
    private JTextField campoNombre;
    private JTextField campoEspecie;
    private JTextField campoRaza;
    private JTextField campoSexo;
    private JTextField campoFechaNacimiento;
    private JButton bSiguiente;
    private JButton bAtras;
    private JButton bVolver;
    private JPanel panelPrincipal;
    private VetConnectController controller;

    public GUIMascota(VetConnect clinica){
        this.clinica = clinica;
        this.controller = new VetConnectController();
    }

    public GUIMascota(VetConnect clinica, VetConnectController controller){
        this.clinica = clinica;
        this.controller = controller;
    }

    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelTitulo = crearLabelTitulo();
        panelPrincipal.add(labelTitulo);
        configurarDimensionesCampos();
        crearPanelesCampos(panelPrincipal);
        establecerBotones(panelPrincipal);
        establecerCampos();

        add(panelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearPanelesCampos(JPanel panelPrincipal) {
        JPanel panelNombre = crearPanelCampo("Nombre:", campoNombre);
        panelPrincipal.add(panelNombre);
        JPanel panelEspecie = crearPanelCampo("Especie:", campoEspecie);
        panelPrincipal.add(panelEspecie);
        JPanel panelRaza = crearPanelCampo("Raza:", campoRaza);
        panelPrincipal.add(panelRaza);
        JPanel panelSexo = crearPanelCampo("Sexo:", campoSexo);
        panelPrincipal.add(panelSexo);
        JPanel panelFechaNacimiento = crearPanelCampo("Fecha nacimiento (yyyy-MM-dd):", campoFechaNacimiento);
        panelPrincipal.add(panelFechaNacimiento);
    }

    private void configurarDimensionesCampos() {
        campoNombre = new JTextField(20);
        campoEspecie = new JTextField(20);
        campoRaza = new JTextField(20);
        campoSexo = new JTextField(20);
        campoFechaNacimiento = new JTextField(20);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        return panelPrincipal;
    }

    private JLabel crearLabelTitulo() {
        JLabel labelTitulo = new JLabel("Paso 1: Agregar Mascota");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        labelTitulo.setBorder(new EmptyBorder(20, 0, 10, 0));
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return labelTitulo;
    }

    private JPanel crearPanelCampo(String labelText, JTextField textField) {
        JPanel panelCampo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCampo = new JLabel(labelText);
        panelCampo.add(labelCampo);
        panelCampo.add(textField);
        return panelCampo;
    }

    private void establecerBotones(JPanel panelPrincipal) {
        bSiguiente = crearBoton("Siguiente", new Color(176, 227, 227));
        bAtras = crearBoton("Atrás", new Color(176, 227, 227));
        bVolver = crearBoton("Volver al Inicio", new Color(176, 227, 227));
        JPanel panelBotones = crearPanelBotones(bSiguiente, bAtras, bVolver);
        panelPrincipal.add(panelBotones);
    }


    private JButton crearBoton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setBackground(bgColor);
        button.setForeground(Color.BLACK);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }

    private JPanel crearPanelBotones(JButton siguienteButton, JButton atrasButton, JButton bVolver) {
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(siguienteButton);
        panelBotones.add(atrasButton);
        panelBotones.add(bVolver);
        return panelBotones;
    }


    private void establecerCampos() {
        Mascota mascota = controller.getMascota();
        if(mascota != null){
            campoNombre.setText(mascota.getNombreMascota());
            campoEspecie.setText(mascota.getEspecieMascota());
            campoRaza.setText(mascota.getRazaMascota());
            campoSexo.setText(mascota.getSexoMascota());
            campoFechaNacimiento.setText(mascota.getFechaNacMascota().toString());
        }
    }

    private String[] obtenerDatosMascotas() {
        String nombreText = campoNombre.getText();
        String especieText = campoEspecie.getText();
        String razaText = campoRaza.getText();
        String sexoText = campoSexo.getText();
        String fechaNacimientoText = campoFechaNacimiento.getText();
        return new String[]{nombreText, especieText, razaText, sexoText, fechaNacimientoText};
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSiguiente) {
            procesarSiguiente();
        } else if (e.getSource() == bAtras) {
            volverAtras();
        } else if (e.getSource() == bVolver) {
            volverAVetConnect();
        }
    }

    private void procesarSiguiente() {
        if (controller.validarEntradasMascotas(obtenerDatosMascotas())) {
            dispose();
            new GUIPropietario(clinica, controller).mostrarInterfaz();
        } else {
            JOptionPane.showMessageDialog(this, "Datos no válidos. Los campos no deben estar en campo, y la fecha debe estar en el formato establecido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volverAtras() {
        dispose();
        controller = null;
        new GUIFichaMedica(clinica).mostrarInterfaz();
    }

    private void volverAVetConnect() {
        dispose();
        controller = null;
        new GUIVetConnect(clinica).mostrarInterfaz();
    }


}