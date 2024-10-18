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
    
    private mapaUsuario mapa;

    // Constructor para inicializar la pantalla de inicio de sesión
    public InicioDeSesioPorSeleccion() {
    	mapa = new mapaUsuario();
    
        // Configuración de la ventana principal
        setTitle("Iniciar Sesión");
        setSize(600, 400); // Tamaño de la ventana
        
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
        JTextField usuario = new JTextField("Usuario o Correo electronico", 20);
        estiloCampo(usuario);
        usuario.setForeground(new Color(200, 200, 200)); // Color del marcador más claro

        // Enfocar el campo de usuario
        usuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usuario.getText().equals("Usuario o Correo electronico")) {
                    usuario.setText("");
                    usuario.setForeground(Color.WHITE); // Cambiar color al escribir
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usuario.getText().isEmpty()) {
                    usuario.setForeground(new Color(200, 200, 200)); // Restablecer el color del marcador
                    usuario.setText("Usuario o Correo electronico"); // Restablecer texto
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
        contraseña.setForeground(new Color(200, 200, 200)); // Color del marcador más claro
        contraseña.setText("Contraseña"); // Texto de marcador

        // Enfocar el campo de contraseña
        contraseña.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(contraseña.getPassword()).equals("Contraseña")) {
                    contraseña.setEchoChar('●'); // Mostrar como caracter oculto
                    contraseña.setText(""); // Limpiar el campo
                    contraseña.setForeground(Color.WHITE); // Cambiar color al escribir
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (contraseña.getPassword().length == 0) {
                    contraseña.setEchoChar((char) 0); // Muestra el texto como caracteres normales
                    contraseña.setForeground(new Color(200, 200, 200)); // Restablecer el color del marcador
                    contraseña.setText("Contraseña"); // Restablecer texto
                } else {
                    contraseña.setEchoChar('●'); // Restablecer el caracter oculto si hay texto
                }
            }
        });

        gbc.gridy = 2; // Fila para el campo de contraseña
        panelContenido.add(contraseña, gbc);

        // Botón de inicio de sesión
        JButton iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 16));
        iniciarSesion.setBackground(Color.BLACK.darker());
        iniciarSesion.setForeground(Color.WHITE);
        iniciarSesion.setFocusPainted(false);
        gbc.gridy = 4; // Fila para el botón
        gbc.gridwidth = 2; // Ocupa dos columnas
        panelContenido.add(iniciarSesion, gbc);

        // Botón "Crear cuenta"
        JButton crearCuenta = new JButton("¿No tienes cuenta? Crear cuenta");
        crearCuenta.setFont(new Font("Arial", Font.PLAIN, 14));
        crearCuenta.setForeground(Color.WHITE);
        crearCuenta.setContentAreaFilled(false); // Fondo transparente
        crearCuenta.setBorderPainted(false); // Sin bordes
        gbc.gridy = 5; // Fila para el botón de crear cuenta
        gbc.gridwidth = 2; // Ocupa dos columnas
        panelContenido.add(crearCuenta, gbc);
        

        // Añadir el panel de contenido al panel de fondo
        panelFondo.add(panelContenido, BorderLayout.CENTER);

        // Añadir el panel a la ventana
        add(panelFondo);

        // Hacer visible la ventana 
        setVisible(true);
        
        // El foco está en el marco, así que no se coloca en usuario ni en contraseña
        requestFocus(); 

        // Acción del botón de inicio de sesión
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario1 = usuario.getText();
                String contraseña1 = new String(contraseña.getPassword());
                GestionSeleccion gesSel = new GestionSeleccion();
                
                manejarSesion(usuario1, contraseña1);
            }

			private void manejarSesion(String usuario1, String contraseña1) {
		        GestionSeleccion gesSel = new GestionSeleccion(); // Ventana de gestión de selección
		        
		        System.out.println("Usuario ingresado: " + usuario1);
		        System.out.println("Contraseña ingresada: " + contraseña1);

		        // Validar usuario y contraseña
		        if (mapa.validateUser(usuario1, contraseña1)) {
		            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
		            String pais = mapa.getUserSelection(usuario1); // Obtener la selección del usuario
		            gesSel.setPais(pais); // Pasar el país a la ventana de gestión
		            dispose(); // Cierra la ventana de inicio de sesión
		            gesSel.setVisible(true); // Abre la siguiente ventana
		        } else {
		            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
		        }				
			}
        });

        // Acción del botón de "Crear cuenta"
        crearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreacionDeUsuario creacionDeUsuario = new CreacionDeUsuario();
            	creacionDeUsuario.setVisible(true);
            	dispose();
            }
        });
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
//        InicioDeSesioPorSeleccion creacion = new InicioDeSesioPorSeleccion();
//		creacion.setVisible(true);
    }
}



