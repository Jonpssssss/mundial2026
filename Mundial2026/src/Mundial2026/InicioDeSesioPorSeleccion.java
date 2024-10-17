package Mundial2026;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class InicioDeSesioPorSeleccion extends JFrame {
    private static final long serialVersionUID = 1L;

    // Carga la imagen de fondo
    private BufferedImage fondo;

    // Constructor para inicializar la pantalla de inicio de sesión
    public InicioDeSesioPorSeleccion() {
        // Configuración de la ventana principal
        setTitle("Iniciar Sesión");
        setSize(600, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Cargar la imagen de fondo desde la ruta local
        try {
            fondo = ImageIO.read(new File("src/Mundial2026/1682100384236.jpeg")); // Asegúrate de que esta ruta sea correcta
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen de fondo.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // No continuar si no se carga la imagen
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
                // Dibuja un rectángulo semi-transparente para simular el difuminado
                g.setColor(new Color(0, 0, 0, 150)); // Negro con 150 de transparencia
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panelFondo.setLayout(new BorderLayout()); // Usar BorderLayout para centrar el panel

        // Crear un panel para organizar los componentes
        JPanel panelContenido = new JPanel();
        panelContenido.setOpaque(false); // Permitir que el fondo sea visible
        panelContenido.setLayout(new GridBagLayout()); // Usar GridBagLayout para organizar los componentes

        // Crear un GridBagConstraints para centrar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que los componentes se estiren horizontalmente
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centrar los componentes

        // Título del formulario
        JLabel title = new JLabel("Iniciar sesión");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        panelContenido.add(title, gbc);

        // Campo de usuario
        JTextField usuario = new JTextField(20);
        estiloCampo(usuario);
        usuario.setText("Usuario"); // Texto de marcador
        usuario.setForeground(Color.GRAY); // Color del marcador
        usuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usuario.getText().equals("Usuario")) {
                    usuario.setText("");
                    usuario.setForeground(Color.WHITE); // Cambiar color al escribir
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usuario.getText().isEmpty()) {
                    usuario.setForeground(Color.GRAY); // Restablecer el color del marcador
                    usuario.setText("Usuario"); // Restablecer texto
                }
            }
        });
        gbc.gridwidth = 1; // Restablece a una columna
        gbc.gridy = 1; // Fila para el campo de usuario
        panelContenido.add(usuario, gbc);

        // Campo de contraseña
        JPasswordField contraseña = new JPasswordField(20);
        estiloCampo(contraseña);
        contraseña.setEchoChar((char) 0); // Muestra el texto como caracteres normales
        contraseña.setText("Contraseña"); // Texto de marcador
        contraseña.setForeground(Color.GRAY); // Color del marcador
        contraseña.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(contraseña.getPassword()).equals("Contraseña")) {
                    contraseña.setEchoChar('●'); // Mostrar como caracter oculto
                    contraseña.setText("");
                    contraseña.setForeground(Color.WHITE); // Cambiar color al escribir
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (contraseña.getPassword().length == 0) {
                    contraseña.setEchoChar((char) 0); // Muestra el texto como caracteres normales
                    contraseña.setForeground(Color.GRAY); // Restablecer el color del marcador
                    contraseña.setText("Contraseña"); // Restablecer texto
                }
            }
        });
        gbc.gridy = 2; // Fila para el campo de contraseña
        panelContenido.add(contraseña, gbc);

        // Checkbox de recordar
        JCheckBox recordar = new JCheckBox("Recuerdame");
        recordar.setOpaque(false); // Fondo transparente
        recordar.setForeground(Color.WHITE);
        gbc.gridy = 3; // Fila para el checkbox
        panelContenido.add(recordar, gbc);

        // Botón de inicio de sesión
        JButton iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 16));
        iniciarSesion.setBackground(new Color(229, 9, 20)); // Color rojo de Netflix
        iniciarSesion.setForeground(Color.WHITE);
        iniciarSesion.setFocusPainted(false);
        gbc.gridy = 4; // Fila para el botón
        gbc.gridwidth = 2; // Ocupa dos columnas
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

                // Validar usuario y contraseña
                if (usuario1.equals("Usuario") || contraseña1.equals("Contraseña")) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese usuario y contraseña.");
                } else {
                    // Simulando validación
                    if (usuario1.equals("admin") && contraseña1.equals("admin")) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                        dispose(); // Cierra la ventana de inicio de sesión
                        gesSel.setVisible(true); // Abre la siguiente ventana
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                }
            }
        });

        // Hacer visible la ventana 
        setVisible(true);
    }

    // Método para aplicar estilo a JTextField y JPasswordField
    private void estiloCampo(JTextField campo) {
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        campo.setBackground(new Color(50, 50, 50)); // Color de fondo oscuro
        campo.setForeground(Color.WHITE); // Color de texto blanco
        campo.setCaretColor(Color.WHITE); // Color del cursor
        campo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaciado interno
        campo.setPreferredSize(new Dimension(250, 40)); // Tamaño preferido
    }

    // Método para aplicar estilo a JPasswordField
    private void estiloCampo(JPasswordField campo) {
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        campo.setBackground(new Color(50, 50, 50)); // Color de fondo oscuro
        campo.setForeground(Color.WHITE); // Color de texto blanco
        campo.setCaretColor(Color.WHITE); // Color del cursor
        campo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaciado interno
        campo.setPreferredSize(new Dimension(250, 40)); // Tamaño preferido
    }

    public static void main(String[] args) {
        // Ejecutar la pantalla de inicio de sesión
        SwingUtilities.invokeLater(() -> new InicioDeSesioPorSeleccion());
    }
}
