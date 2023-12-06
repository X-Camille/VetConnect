package vista;


import model.VetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIMascota extends JFrame {

    private final VetConnect clinica;;
    private JTextField campoEspecie;
    private JTextField campoRaza;
    private JTextField campoSexo;
    private JTextField campoFechaNacimiento;
    private JButton bSiguiente;
    private JButton bAtras;
    private JButton bVolver;
    private JPanel panelPrincipal;

    public GUIMascota(VetConnect clinica){
        this.clinica = clinica;
    }
    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelTitulo = crearLabelTitulo();
        panelPrincipal.add(labelTitulo);
        configurarDimensionesCampos();
        crearPanelesCampos(panelPrincipal);
        establecerBotones(panelPrincipal);

        bSiguiente.addActionListener(e -> {
            obtenerDatosMascotas();
            dispose();
            new GUIPropietario(clinica).mostrarInterfaz();
        });

        bAtras.addActionListener(e -> {
            dispose();
            new GUIFichaMedica(clinica).mostrarInterfaz();
        });

        bVolver.addActionListener(e -> {
            dispose();
            new GUIVetConnect(clinica).mostrarInterfaz();
        });

        add(panelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearPanelesCampos(JPanel panelPrincipal) {
        JPanel panelEspecie = crearPanelCampo("Especie:", campoEspecie);
        panelPrincipal.add(panelEspecie);
        JPanel panelRaza = crearPanelCampo("Raza:", campoRaza);
        panelPrincipal.add(panelRaza);
        JPanel panelSexo = crearPanelCampo("Sexo:", campoSexo);
        panelPrincipal.add(panelSexo);
        JPanel panelFechaNacimiento = crearPanelCampo("Fecha nacimiento:", campoFechaNacimiento);
        panelPrincipal.add(panelFechaNacimiento);
    }

    private void configurarDimensionesCampos() {
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

    /*private void deshabilitarCampos() {
        campoEspecie.setEnabled(false);
        campoRaza.setEnabled(false);
        campoSexo.setEnabled(false);
        campoFechaNacimiento.setEnabled(false);
    }

    private void habilitarCampos() {
        campoEspecie.setEnabled(true);
        campoRaza.setEnabled(true);
        campoSexo.setEnabled(true);
        campoFechaNacimiento.setEnabled(true);
    }*/

    private void limpiarCampos() {
        campoEspecie.setText("");
        campoRaza.setText("");
        campoSexo.setText("");
        campoFechaNacimiento.setText("");
    }

    private String[] obtenerDatosMascotas() {
        String especieText = campoEspecie.getText();
        String razaText = campoRaza.getText();
        String sexoText = campoSexo.getText();
        String fechaNacimientoText = campoFechaNacimiento.getText();
        return new String[]{especieText, razaText, sexoText, fechaNacimientoText};
    }

}