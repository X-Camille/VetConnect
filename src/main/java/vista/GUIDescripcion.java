package vista;


import controller.VetConnectController;
import model.Propietario;
import model.VetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDescripcion extends JFrame implements ActionListener {

    private final VetConnect clinica;;
    private JTextArea campoTratamiento;
    private JTextArea campoDiagnostico;
    private JButton bIngresarFicha;
    private JButton bAtras;
    private JButton bVolver;
    private JPanel panelPrincipal;
    private VetConnectController controller;

    public GUIDescripcion(VetConnect clinica, VetConnectController controller){
        this.clinica = clinica;
        this.controller = controller;
    }
    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        campoDiagnostico = new JTextArea(5, 20);
        campoTratamiento = new JTextArea(5, 20);

        setSize(1000, 600); // Ajustar el tamaño de la ventana

        JLabel labelTitulo = crearLabelTitulo();
        panelPrincipal.add(labelTitulo);
        crearPanelesCampos(panelPrincipal); // Llamada a los paneles de campos solo una vez
        establecerBotones(panelPrincipal);
        establecerCampos();

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

    private JPanel crearPanelCampo(String labelText, JTextArea textArea) {
        JPanel panelCampo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCampo = new JLabel(labelText);
        panelCampo.add(labelCampo);
        panelCampo.add(new JScrollPane(textArea)); // Añadir JScrollPane para desplazarse por el texto
        return panelCampo;
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

    private void establecerBotones(JPanel panelPrincipal) {
        if(controller.getFichaEditada() != null){
            bIngresarFicha = crearBoton("Guardar Cambios", new Color(176, 227, 227));
        } else {
            bIngresarFicha = crearBoton("Ingresar Ficha", new Color(176, 227, 227));
        }
        bAtras = crearBoton("Atrás", new Color(176, 227, 227));
        bVolver = crearBoton("Volver al Inicio", new Color(176, 227, 227));
        JPanel panelBotones = crearPanelBotones(bIngresarFicha, bAtras, bVolver);
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

    private JPanel crearPanelBotones(JButton ingresarButton, JButton atrasButton, JButton bVolver) {
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(ingresarButton);
        panelBotones.add(atrasButton);
        panelBotones.add(bVolver);
        return panelBotones;
    }

    private void establecerCampos() {
        if(controller != null){
            campoDiagnostico.setText(controller.getDiagnostico());
            campoTratamiento.setText(controller.getTratamiento());
        }
    }

    private String[] obtenerDatosFichaMedica() {
        String diagnosticoText, tratamientoText;
        if(campoDiagnostico.getText().isEmpty()) {
            diagnosticoText = "Sin definir.";
        } else {
            diagnosticoText = campoDiagnostico.getText();
        }
        if(campoTratamiento.getText().isEmpty()){
            tratamientoText = "Sin definir.";
        } else {
            tratamientoText = campoTratamiento.getText();
        }
        return new String[]{diagnosticoText, tratamientoText};
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bIngresarFicha) {
            procesarIngresoFicha();
        } else if (e.getSource() == bAtras) {
            volverAtras();
        } else if (e.getSource() == bVolver) {
            volverAVetConnect();
        }
    }

    private void procesarIngresoFicha() {
        controller.validarEntradasDescripcion(obtenerDatosFichaMedica());
        controller.enviarDatos();
        if (controller.getFichaEditada() != null){
            JOptionPane.showMessageDialog(this, "Se han guardado los cambios.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "La ficha médica ha sido agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
        new GUIVetConnect(clinica).mostrarInterfaz();
    }

    private void volverAtras() {
        dispose();
        new GUIPropietario(clinica, controller).mostrarInterfaz();
    }

    private void volverAVetConnect() {
        controller = null;
        dispose();
        new GUIVetConnect(clinica).mostrarInterfaz();
    }

}