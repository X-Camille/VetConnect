package vista;

import model.FichaMedica;
import model.VetConnect;
import vista.GUIFichaMedica;
import vista.GUIVetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIVerFicha extends JFrame implements ActionListener {
    private final VetConnect clinica;
    private final FichaMedica ficha;
    private JPanel panelPrincipal;
    private JButton bExportar;
    private JButton bAtras;
    private JButton bVolver;

    public GUIVerFicha(VetConnect clinica, FichaMedica fichaMedica) {
        this.clinica = clinica;
        this.ficha = fichaMedica;
    }

    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelTitulo = crearLabelTitulo();
        panelPrincipal.add(labelTitulo);

        crearPanelesCampos(panelPrincipal);

        establecerBotones(panelPrincipal);

        add(panelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearPanelesCampos(JPanel panelPrincipal) {
        panelPrincipal.setBackground(Color.WHITE);

        crearPanelDatosPropietario(panelPrincipal);
        crearPanelDatosMascota(panelPrincipal);
        crearPanelDescripcion(panelPrincipal);
    }

    private void crearPanelDescripcion(JPanel panelPrincipal) {
        JPanel panelDescripcion = new JPanel();
        panelDescripcion.setBackground(new Color(255, 227, 227));
        panelDescripcion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelDescripcion.setLayout(new BoxLayout(panelDescripcion, BoxLayout.Y_AXIS));

        JLabel labelDescripcion = new JLabel("Descripción");
        labelDescripcion.setFont(new Font("Arial", Font.BOLD, 14));
        labelDescripcion.setBorder(new EmptyBorder(10, 0, 5, 0));
        labelDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDescripcion.add(labelDescripcion);

        panelDescripcion.add(crearPanelCampo("Diagnóstico: " + ficha.getDiagnostico()));
        panelDescripcion.add(crearPanelCampo("Tratamiento: " + ficha.getTratamiento()));

        panelPrincipal.add(panelDescripcion);
    }

    private void crearPanelDatosPropietario(JPanel panelPrincipal) {
        JPanel panelPropietario = new JPanel();
        panelPropietario.setBackground(new Color(255, 227, 227));
        panelPropietario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPropietario.setLayout(new BoxLayout(panelPropietario, BoxLayout.Y_AXIS));

        JLabel labelPropietario = new JLabel("Datos del propietario");
        labelPropietario.setFont(new Font("Arial", Font.BOLD, 14));
        labelPropietario.setBorder(new EmptyBorder(10, 0, 5, 0));
        labelPropietario.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPropietario.add(labelPropietario);

        panelPropietario.add(crearPanelCampo("Nombre: " + ficha.getPropietario().getNombre()));
        panelPropietario.add(crearPanelCampo("Apellido: " + ficha.getPropietario().getApellido()));
        panelPropietario.add(crearPanelCampo("RUT: " + ficha.getPropietario().getRut()));
        panelPropietario.add(crearPanelCampo("Teléfono: " + ficha.getPropietario().getTelefono()));
        panelPropietario.add(crearPanelCampo("Correo: " + ficha.getPropietario().getCorreo()));
        panelPropietario.add(crearPanelCampo("Dirección: " + ficha.getPropietario().getDireccion()));

        panelPrincipal.add(panelPropietario);
    }

    private void crearPanelDatosMascota(JPanel panelPrincipal) {
        JPanel panelMascota = new JPanel();
        panelMascota.setBackground(new Color(255, 227, 227));
        panelMascota.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelMascota.setLayout(new BoxLayout(panelMascota, BoxLayout.Y_AXIS));

        JLabel labelMascota = new JLabel("Datos de la mascota");
        labelMascota.setFont(new Font("Arial", Font.BOLD, 14));
        labelMascota.setBorder(new EmptyBorder(10, 0, 5, 0));
        labelMascota.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMascota.add(labelMascota);

        panelMascota.add(crearPanelCampo("Nombre: " + ficha.getMascota().getNombreMascota()));
        panelMascota.add(crearPanelCampo("Especie: " + ficha.getMascota().getEspecieMascota()));
        panelMascota.add(crearPanelCampo("Raza: " + ficha.getMascota().getRazaMascota()));
        panelMascota.add(crearPanelCampo("Sexo: " + ficha.getMascota().getSexoMascota()));
        panelMascota.add(crearPanelCampo("Fecha nacimiento: " + ficha.getMascota().getFechaNacMascota()));

        panelPrincipal.add(panelMascota);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        return panelPrincipal;
    }

    private JLabel crearLabelTitulo() {
        JLabel labelTitulo = new JLabel("Ficha Médica de " + ficha.getMascota().getNombreMascota());
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        labelTitulo.setBorder(new EmptyBorder(20, 0, 10, 0));
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return labelTitulo;
    }

    private JPanel crearPanelCampo(String labelText) {
        JPanel panelCampo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCampo = new JLabel(labelText);
        labelCampo.setFont(new Font("Arial", Font.PLAIN, 12)); // Puedes agregar la fuente en negrita aquí si es necesario
        panelCampo.add(labelCampo);
        panelCampo.setBackground(Color.WHITE); // Establecer el color de fondo
        return panelCampo;
    }

    private void establecerBotones(JPanel panelPrincipal) {
        bExportar = crearBoton("Exportar a PDF", new Color(176, 227, 227));
        bAtras = crearBoton("Atrás", new Color(176, 227, 227));
        bVolver = crearBoton("Volver al Inicio", new Color(176, 227, 227));
        JPanel panelBotones = crearPanelBotones(bExportar, bAtras, bVolver);
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bExportar) {
            dispose();
        } else if (e.getSource() == bAtras) {
            dispose();
            new GUIBuscador(clinica).mostrarInterfaz();
        } else if (e.getSource() == bVolver) {
            dispose();
            new GUIVetConnect(clinica).mostrarInterfaz();
        }
    }
}
