package Mundial2026;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Prueba extends JFrame {
    private static final long serialVersionUID = 1L;

    // Carga la imagen de fondo
    private BufferedImage fondo;

    // Constructor para inicializar la pantalla de inicio de sesión
    public Prueba() {
        // Configuración de la ventana principal
        setTitle("Inicio de Sesión");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Cargar la imagen de fondo desde la ruta local
        try {
            fondo = ImageIO.read(new File("src/Mundial2026/1682100384236.jpeg")); // Cambia esta ruta por la ruta donde guardaste la imagen
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear un panel personalizado para el fondo
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibuja la imagen de fondo
                if (fondo != null) {
                    g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        panelFondo.setLayout(new BorderLayout()); // Usar BorderLayout para centrar el panel

        // Crear un panel para organizar los componentes
        JPanel panelContenido = new JPanel();
        panelContenido.setOpaque(false); // Permitir que el fondo sea visible
        panelContenido.setLayout(new GridBagLayout());
        
        // Crear un GridBagConstraints para centrar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que los componentes se estiren horizontalmente
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centrar los componentes

        // Crear los componentes de la interfaz de usuario
        JLabel user = new JLabel("Usuario:");
        user.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        
        // Crear un JTextField con un estilo de botón
        JTextField usuario = new JTextField(15);
        estiloCampo(usuario);

        JLabel cont = new JLabel("Contraseña:");
        cont.setFont(new Font("Times New Roman", Font.ITALIC, 20));

        // Crear un JPasswordField con un estilo de botón
        JPasswordField contraseña = new JPasswordField(15);
        estiloCampo(contraseña);

        JButton iniciarSesion = new JButton("Iniciar Sesión");
        iniciarSesion.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        iniciarSesion.setBackground(Color.GRAY);

        // Añadir los componentes al panel de contenido utilizando GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelContenido.add(user, gbc);

        gbc.gridx = 1;
        panelContenido.add(usuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelContenido.add(cont, gbc);

        gbc.gridx = 1;
        panelContenido.add(contraseña, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Hacer que el botón ocupe dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el botón
        panelContenido.add(iniciarSesion, gbc);

        // Añadir el panel de contenido al panel de fondo
        panelFondo.add(panelContenido, BorderLayout.CENTER);

        // Añadir el panel a la ventana
        add(panelFondo);

        // Añadir una acción al botón de inicio de sesión
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario1 = usuario.getText();
                String contraseña1 = new String(contraseña.getPassword());
                GestionSeleccion gesSel = new GestionSeleccion();

                if (usuario1.isEmpty() && contraseña1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    dispose();
                    gesSel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        // Hacer visible la ventana 
        setVisible(true);
    }

    // Método para aplicar estilo a JTextField y JPasswordField
    private void estiloCampo(JTextField campo) {
        campo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        campo.setBackground(new Color(240, 240, 240)); // Color de fondo similar a un botón
        campo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Borde similar a un botón
        campo.setPreferredSize(new Dimension(200, 30)); // Tamaño preferido
    }

    public static void main(String[] args) {
        // Ejecutar la pantalla de inicio de sesión
        SwingUtilities.invokeLater(() -> new Prueba());
    }
}


