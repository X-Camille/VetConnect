package vista;

import controller.VetConnectController;
import model.FichaMedica;
import model.VetConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIEliminar extends JFrame implements ActionListener {

    private final VetConnect clinica;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField campoRut;
    private JTextField campoNombrePropietario;
    private JTextField campoNombreMascota;
    private JTextField campoFecha;
    private JButton bRut, bPropietario, bMascota, bFecha;
    private JPanel panelPrincipal;
    private JButton bBuscar;
    private JButton bEliminar;
    private JButton bAtras;
    private JButton bVolver;
    private ArrayList<FichaMedica> fichasMedicasEncontradas = new ArrayList<>();

    public GUIEliminar(VetConnect clinica) {
        this.clinica = clinica;
    }

    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600); // Tamaño inicial y fijo

        JLabel labelTitulo = crearLabelTitulo();
        panelPrincipal.add(labelTitulo);
        configurarDimensionesCampos();
        crearPanelesCampos(panelPrincipal);
        establecerBotones(panelPrincipal);

        add(panelPrincipal);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearPanelesCampos(JPanel panelPrincipal) {
        JPanel panelTitulo = crearPanelTituloBusqueda();
        panelPrincipal.add(panelTitulo);

        JPanel panelBotonesBusqueda = crearPanelBotonesBusqueda();
        panelPrincipal.add(panelBotonesBusqueda);

        JPanel panelRut = crearPanelCampo("RUT:", campoRut);
        panelPrincipal.add(panelRut);
        JPanel panelNombrePropietario = crearPanelCampo("Nombre del propietario:", campoNombrePropietario);
        panelPrincipal.add(panelNombrePropietario);
        JPanel panelNombreMascota = crearPanelCampo("Nombre de la mascota:", campoNombreMascota);
        panelPrincipal.add(panelNombreMascota);
        JPanel panelFecha = crearPanelCampo("Fecha:", campoFecha);
        panelPrincipal.add(panelFecha);

        bBuscar = new JButton("Buscar");
        panelPrincipal.add(bBuscar);
        bBuscar.addActionListener(this);

        // Tabla vacía
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panelPrincipal.add(scrollPane);
    }

    private JPanel crearPanelTituloBusqueda() {
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTitulo = new JLabel("Buscar por: ");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 12));
        panelTitulo.add(labelTitulo);
        return panelTitulo;
    }

    private JPanel crearPanelBotonesBusqueda() {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));

        bRut = crearBotonBusqueda("RUT");
        bPropietario = crearBotonBusqueda("Propietario");
        bMascota = crearBotonBusqueda("Mascota");
        bFecha = crearBotonBusqueda("Fecha");

        panelBotones.add(bRut);
        panelBotones.add(bPropietario);
        panelBotones.add(bMascota);
        panelBotones.add(bFecha);

        return panelBotones;
    }

    private JButton crearBotonBusqueda(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(100, 30));
        button.setBackground(new Color(176, 227, 227));
        button.setForeground(Color.BLACK);
        return button;
    }
    private void configurarDimensionesCampos() {
        campoRut = new JTextField(20);
        campoRut.setEnabled(false);
        campoNombrePropietario = new JTextField(20);
        campoNombrePropietario.setEnabled(false); // Deshabilitar campo al inicio
        campoNombreMascota = new JTextField(20);
        campoNombreMascota.setEnabled(false); // Deshabilitar campo al inicio
        campoFecha = new JTextField(20);
        campoFecha.setEnabled(false); // Deshabilitar campo al inicio
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        return panelPrincipal;
    }

    private JLabel crearLabelTitulo() {
        JLabel labelTitulo = new JLabel("Seleccione la Ficha Médica que desea eliminar:");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        labelTitulo.setBorder(new EmptyBorder(20, 0, 10, 0));
        labelTitulo.setAlignmentX(Component.RIGHT_ALIGNMENT);
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
        bEliminar = crearBoton("Eliminar Ficha", new Color(176, 227, 227));
        bAtras = crearBoton("Atrás", new Color(176, 227, 227));
        bVolver = crearBoton("Volver al Inicio", new Color(176, 227, 227));
        JPanel panelBotones = crearPanelBotones(bEliminar, bAtras, bVolver);
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

    private String[] obtenerDatosMascotas() {
        String rutText = campoRut.getText();
        String nombrePropietarioText = campoNombrePropietario.getText();
        String nombreMascotaText = campoNombreMascota.getText();
        String fechaText = campoFecha.getText();
        return new String[]{rutText, nombrePropietarioText, nombreMascotaText, fechaText};
    }

    private void llenarTablaConDatos(ArrayList<FichaMedica> fichasMedicas) {
        String[] columnas = {"RUT", "Nombre Propietario", "Nombre Mascota", "Fecha"};
        Object[][] datos = new Object[fichasMedicas.size()][columnas.length];

        for (int i = 0; i < fichasMedicas.size(); i++) {
            FichaMedica ficha = fichasMedicas.get(i);
            datos[i][0] = ficha.getPropietario().getRut();
            datos[i][1] = ficha.getPropietario().getNombre();
            datos[i][2] = ficha.getMascota().getNombreMascota();
            datos[i][3] = ficha.getMascota().getFechaNacMascota();
        }
        tableModel.setDataVector(datos, columnas);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bRut) {
            toggleCampo(campoRut, bRut);
        } else if (e.getSource() == bPropietario) {
            toggleCampo(campoNombrePropietario, bPropietario);
        } else if (e.getSource() == bMascota) {
            toggleCampo(campoNombreMascota, bMascota);
        } else if (e.getSource() == bFecha) {
            toggleCampo(campoFecha, bFecha);
        } else if (e.getSource() == bBuscar) {
            realizarBusqueda();
        } else if (e.getSource() == bEliminar) {
            eliminarFichaMedica();
        } else if (e.getSource() == bAtras) {
            volverAtras();
        } else if (e.getSource() == bVolver) {
            volverAVetConnect();
        }
    }

    private void toggleCampo(JTextField campo, JButton boton) {
        if (campo.isEnabled()) {
            campo.setEnabled(false);
            boton.setBackground(new Color(176, 227, 227));
        } else {
            campo.setEnabled(true);
            boton.setBackground(new Color(139, 167, 199));
        }
    }

    private void realizarBusqueda() {
        VetConnectController controller = new VetConnectController();
        String[] datos = obtenerDatosMascotas();
        fichasMedicasEncontradas = controller.buscarFichasMedicas(datos);
        llenarTablaConDatos(fichasMedicasEncontradas);
    }

    private void eliminarFichaMedica() {
        VetConnectController controller = new VetConnectController();
        FichaMedica fichaMedicaSeleccionada = obtenerFichaSeleccionada();
        assert fichaMedicaSeleccionada != null;
        boolean fichaFueEliminada = controller.eliminarFichaMedica(fichaMedicaSeleccionada);

        if (fichaFueEliminada) {
            String[] datos = obtenerDatosMascotas();
            fichasMedicasEncontradas = controller.buscarFichasMedicas(datos);
            llenarTablaConDatos(fichasMedicasEncontradas);
            JOptionPane.showMessageDialog(this, "La ficha médica ha sido eliminada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "La ficha médica no se pudo eliminar. Inténtelo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volverAtras() {
        dispose();
        new GUIFichaMedica(clinica).mostrarInterfaz();
    }

    private void volverAVetConnect() {
        dispose();
        new GUIVetConnect(clinica).mostrarInterfaz();
    }


    private FichaMedica obtenerFichaSeleccionada() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            return fichasMedicasEncontradas.get(filaSeleccionada);
        }
        return null;
    }
}