package vista;


import model.VetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIDescripcion extends JFrame {

    private final VetConnect clinica;;
    private JTextField campoTratamiento;
    private JTextField campoDiagnostico;
    private JButton bIngresarFicha;
    private JButton bAtras;
    private JButton bVolver;
    private JPanel panelPrincipal;

    public GUIDescripcion(VetConnect clinica){
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

        bIngresarFicha.addActionListener(e -> {
            obtenerDatosFichaMedica();
            dispose();
            new GUIVetConnect(clinica).mostrarInterfaz();
        });

        bAtras.addActionListener(e -> {
            dispose();
            new GUIPropietario(clinica).mostrarInterfaz();
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
        JPanel panelDiagnostico = crearPanelCampo("Diagnóstico:", campoDiagnostico);
        panelPrincipal.add(panelDiagnostico);
        JPanel panelTratamiento = crearPanelCampo("Tratamiento:", campoTratamiento);
        panelPrincipal.add(panelTratamiento);
    }

    private void configurarDimensionesCampos() {
        campoDiagnostico= new JTextField(20);
        campoTratamiento = new JTextField(20);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        return panelPrincipal;
    }

    private JLabel crearLabelTitulo() {
        JLabel labelTitulo = new JLabel("Paso 3: Agregar Descripción");
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
        bIngresarFicha = crearBoton("Ingresar Ficha Médica", new Color(176, 227, 227));
        bAtras = crearBoton("Atrás", new Color(176, 227, 227));
        bVolver = crearBoton("Volver al Inicio", new Color(176, 227, 227));
        JPanel panelBotones = crearPanelBotones(bIngresarFicha, bAtras, bVolver);
        panelPrincipal.add(panelBotones);
    }


    private JButton crearBoton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.BLACK);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }

    private JPanel crearPanelBotones(JButton ingresarButton, JButton atrasButton, JButton bVolver) {
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(ingresarButton);
        panelBotones.add(atrasButton);
        panelBotones.add(bVolver);
        return panelBotones;
    }


    private void limpiarCampos() {
        campoDiagnostico.setText("");
        campoTratamiento.setText("");
    }

    private String[] obtenerDatosFichaMedica() {
        String diagnosticoText = campoDiagnostico.getText();
        String tratamientoText = campoTratamiento.getText();
        return new String[]{diagnosticoText, tratamientoText};
    }

}