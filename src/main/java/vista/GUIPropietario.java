package vista;


import controller.VetConnectController;
import model.Mascota;
import model.Propietario;
import model.VetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPropietario extends JFrame implements ActionListener {

    private final VetConnect clinica;;
    private JTextField campoNombre, campoApellido, campoRut, campoTelefono, campoCorreo, campoDireccion;
    private JButton bSiguiente;
    private JButton bAtras;
    private JButton bVolver;
    private JPanel panelPrincipal;

    private VetConnectController controller;

    public GUIPropietario(VetConnect clinica, VetConnectController controller){
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
        JPanel panelApellido = crearPanelCampo("Apellido:", campoApellido);
        panelPrincipal.add(panelApellido);
        JPanel panelRut = crearPanelCampo("RUT:", campoRut);
        panelPrincipal.add(panelRut);
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
        campoRut = new JTextField(20);
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
        Propietario propietario = controller.getPropietario();
        if(propietario != null){
            campoNombre.setText(propietario.getNombre());
            campoApellido.setText(propietario.getApellido());
            campoRut.setText(propietario.getRut());
            campoTelefono.setText(propietario.getTelefono());
            campoCorreo.setText(propietario.getCorreo());
            campoDireccion.setText(propietario.getDireccion());
        }
    }

    private String[] obtenerDatosPropietario() {
        String nombreText = campoNombre.getText();
        String apellidoText = campoApellido.getText();
        String rutText = campoRut.getText();
        String telefonoText = campoTelefono.getText();
        String correoText = campoCorreo.getText();
        String direccionText = campoDireccion.getText();
        return new String[]{nombreText, apellidoText, rutText, telefonoText, correoText, direccionText};
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
        if (controller.validarEntradasPropietario(obtenerDatosPropietario())) {
            dispose();
            new GUIDescripcion(clinica, controller).mostrarInterfaz();
        } else {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar en blanco ni deben contener números.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volverAtras() {
        dispose();
        new GUIMascota(clinica, controller).mostrarInterfaz();
    }

    private void volverAVetConnect() {
        controller = null;
        dispose();
        new GUIVetConnect(clinica).mostrarInterfaz();
    }


}