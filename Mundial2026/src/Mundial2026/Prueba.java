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

        // Crear un panel difuminado (semi-transparente) para los componentes
        JPanel panelDifuminado = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color semiTransparent = new Color(0, 0, 0, 180); // Negro semitransparente
                g.setColor(semiTransparent);
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Bordes redondeados
            }
        };

        panelDifuminado.setOpaque(false); // Permitir que el fondo se vea a través
        panelDifuminado.setLayout(new GridBagLayout()); // Usar GridBagLayout para organizar los componentes
        panelDifuminado.setPreferredSize(new Dimension(400, 200)); // Ajustar el tamaño del panel difuminado

        // Crear un GridBagConstraints para ajustar la posición de los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que los componentes se estiren horizontalmente
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        gbc.anchor = GridBagConstraints.EAST; // Alinear a la derecha

        // Crear los componentes de la interfaz de usuario
        JLabel user = new JLabel("Usuario:");
        user.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        user.setForeground(Color.WHITE); // Cambiar el color del texto a blanco

        JTextField usuario = new JTextField(15);
        estiloCampo(usuario);

        JLabel cont = new JLabel("Contraseña:");
        cont.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        cont.setForeground(Color.WHITE); // Cambiar el color del texto a blanco

        JPasswordField contraseña = new JPasswordField(15);
        estiloCampo(contraseña);

        JButton iniciarSesion = new JButton("Iniciar Sesión");
        iniciarSesion.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        iniciarSesion.setBackground(Color.green);

        // Colocar los JLabel sobre los JTextField y alinear a la derecha
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Alineación a la derecha
        panelDifuminado.add(user, gbc);

        gbc.gridy = 1;
        panelDifuminado.add(usuario, gbc);

        gbc.gridy = 2;
        panelDifuminado.add(cont, gbc);

        gbc.gridy = 3;
        panelDifuminado.add(contraseña, gbc);

        gbc.gridy = 4;
        panelDifuminado.add(iniciarSesion, gbc);

        // Añadir el panel difuminado al panel de fondo
        panelFondo.add(panelDifuminado, BorderLayout.CENTER);

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

