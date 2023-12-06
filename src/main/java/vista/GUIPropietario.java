package vista;


import model.VetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIPropietario extends JFrame {

    private final VetConnect clinica;;
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoTelefono;
    private JTextField campoCorreo;
    private JTextField campoDireccion;
    private JButton bSiguiente;
    private JButton bAtras;
    private JButton bVolver;
    private JPanel panelPrincipal;

    public GUIPropietario(VetConnect clinica){
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
            obtenerDatosPropietario();
            dispose();
            new GUIDescripcion(clinica).mostrarInterfaz();
        });

        bAtras.addActionListener(e -> {
            dispose();
            new GUIMascota(clinica).mostrarInterfaz();
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
        JPanel panelNombre = crearPanelCampo("Nombre:", campoNombre);
        panelPrincipal.add(panelNombre);
        JPanel panelApellido = crearPanelCampo("Apellido:", campoApellido);
        panelPrincipal.add(panelApellido);
        JPanel panelTelefono = crearPanelCampo("Telefono:", campoTelefono);
        panelPrincipal.add(panelTelefono);
        JPanel panelCorreo = crearPanelCampo("Correo:", campoCorreo);
        panelPrincipal.add(panelCorreo);
        JPanel panelDireccion = crearPanelCampo("Dirección:", campoDireccion);
        panelPrincipal.add(panelDireccion);
    }

    private void configurarDimensionesCampos() {
        campoNombre = new JTextField(20);
        campoApellido = new JTextField(20);
        campoTelefono = new JTextField(20);
        campoCorreo = new JTextField(20);
        campoDireccion = new JTextField(20);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        return panelPrincipal;
    }

    private JLabel crearLabelTitulo() {
        JLabel labelTitulo = new JLabel("Paso 2: Agregar Propietario");
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


    private void limpiarCampos() {
        campoNombre.setText("");
        campoApellido.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoDireccion.setText("");
    }

    private String[] obtenerDatosPropietario() {
        String nombreText = campoNombre.getText();
        String apellidoText = campoApellido.getText();
        String telefonoText = campoTelefono.getText();
        String correoText = campoCorreo.getText();
        String direccionText = campoDireccion.getText();
        return new String[]{nombreText, apellidoText, telefonoText, correoText, direccionText};
    }

}