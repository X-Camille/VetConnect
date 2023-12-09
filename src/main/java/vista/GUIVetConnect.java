package vista;


import model.VetConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIVetConnect extends JFrame implements ActionListener {

    private final VetConnect clinica;
    private JButton bFichasMedicas;
    private JButton bBuscador;
    private JButton bNotificaciones;

    public GUIVetConnect(VetConnect clinica) {
        this.clinica = clinica;
    }

    public void mostrarInterfaz() {
        configurarVentana();
        JPanel panel = crearPanel();
        panel.setBackground(Color.WHITE); // Establecer el fondo del panel como blanco
        getContentPane().setBackground(Color.WHITE);
        agregarComponentes(panel);
        mostrarVentana();
    }

    private void configurarVentana() {
        setTitle("Plataforma VetConnect");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false); // Bloquear la maximización de la ventana
    }

    private JPanel crearPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("VetConnect", SwingConstants.CENTER);
        configurarTitulo(titleLabel, gbc, panel);

        ImageIcon icono = new ImageIcon("C:/Users/Lenovo/Desktop/logo.jpg");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(59, 59, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

        JLabel imagenLabel = new JLabel(iconoRedimensionado);
        gbc.gridx = 0;
        gbc.gridy = 0; // Posicionando la imagen en la fila 0
        gbc.gridwidth = 1; // Ocupará una columna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(imagenLabel, gbc);

        gbc.gridx = 0; // Volviendo a la misma columna que la imagen
        gbc.gridy = 1; // Ubicando el título en la fila 1
        gbc.gridwidth = 1; // Ocupará una columna
        panel.add(titleLabel, gbc);

        bFichasMedicas = crearBoton("Fichas Médicas", new Color(255, 227, 227));
        configurarBoton(bFichasMedicas, gbc, panel, 2);

        bBuscador = crearBoton("Buscador", new Color(255, 227, 227));
        configurarBoton(bBuscador, gbc, panel, 3);

        bNotificaciones= crearBoton("Notificaciones", new Color(255, 227, 227));
        configurarBoton(bNotificaciones, gbc, panel, 6);

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

    private void mostrarVentana() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bFichasMedicas) {
            dispose();
            new GUIFichaMedica(clinica).mostrarInterfaz();
        } else if (e.getSource() == bBuscador) {
            dispose();
            new GUIBuscador(clinica).mostrarInterfaz();
        } else if (e.getSource() == bNotificaciones) {
            dispose();
            new GUINotificacion(clinica).mostrarInterfaz();
        }
    }
}