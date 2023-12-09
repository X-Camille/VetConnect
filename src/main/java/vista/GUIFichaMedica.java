package vista;


import model.VetConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFichaMedica extends JFrame implements ActionListener {

    private final VetConnect clinica;
    private JButton bAgregarFicha;
    private JButton bEditarFicha;
    private JButton bEliminarFicha;
    private JButton bAtras;

    public GUIFichaMedica(VetConnect clinica) {
        this.clinica = clinica;
    }

    public void mostrarInterfaz() {
        configurarVentana();
        JPanel panel = crearPanel();
        panel.setBackground(Color.WHITE); // Establecer el fondo del panel como blanco
        getContentPane().setBackground(Color.WHITE);
        agregarComponentes(panel);
        mostrarVentana(panel);
    }

    private void configurarVentana() {
        setTitle("Gestión de Fichas Médicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false); // Bloquear la maximización de la ventana
    }

    private JPanel crearPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Gestión de Fichas Médicas", SwingConstants.CENTER);
        configurarTitulo(titleLabel, gbc, panel);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(titleLabel, gbc);

        bAgregarFicha = crearBoton("Agregar Ficha Médica", new Color(255, 227, 227));
        configurarBoton(bAgregarFicha, gbc, panel, 2);

        bEditarFicha = crearBoton("Editar Ficha Médica", new Color(255, 227, 227));
        configurarBoton(bEditarFicha, gbc, panel, 3);

        bEliminarFicha = crearBoton("Eliminar Ficha Médica", new Color(255, 227, 227));
        configurarBoton(bEliminarFicha, gbc, panel, 6);

        bAtras = crearBoton("Atrás", new Color(255, 227, 227));
        configurarBoton(bAtras, gbc, panel, 8);

        return panel;
    }

    private void configurarTitulo(JLabel label, GridBagConstraints gbc, JPanel panel) {
        label.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label, gbc);
    }

    private JButton crearBoton(String texto, Color color) {
        JButton button = new JButton(texto);
        button.addActionListener(this);

        // Añadir el cambio de color cuando el mouse pasa sobre el botón
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(176, 227, 227)); // Cambiar a otro color cuando el mouse entra
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color); // Volver al color original cuando el mouse sale
            }
        });

        button.setBackground(color);
        return button;
    }

    private void configurarBoton(JButton button, GridBagConstraints gbc, JPanel panel, int gridY) {
        gbc.gridx = 0;
        gbc.gridy = gridY;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(button, gbc);
    }

    private void agregarComponentes(JPanel panel) {
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void mostrarVentana(JPanel panel) {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAgregarFicha) {
            dispose();
            new GUIMascota(clinica).mostrarInterfaz();
        } else if (e.getSource() == bEditarFicha) {
            dispose();
            new GUIEditar(clinica).mostrarInterfaz();
        } else if (e.getSource() == bEliminarFicha) {
            dispose();
            new GUIEliminar(clinica).mostrarInterfaz();
        } else if (e.getSource() == bAtras){
            dispose();
            new GUIVetConnect(clinica).mostrarInterfaz();
        }
    }
}