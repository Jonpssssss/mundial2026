package Mundial2026;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class InicioDeSesionPorSeleccion extends JFrame {

    
	private static final long serialVersionUID = 1L;

	// Constructor para inicializar la pantalla de inicio de sesión
    public InicioDeSesionPorSeleccion() {
        // Configuración de la ventana principal
        setTitle("Inicio de Sesión");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        // Crear un panel principal para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Crear los componentes de la interfaz de usuario
        JLabel user = new JLabel("Usuario:");
        JTextField usuario = new JTextField();
        
        JLabel cont = new JLabel("Contraseña:");
        JPasswordField contraseña = new JPasswordField();
        
        user.setFont(new Font("Times New Roman", Font.ITALIC,20));
        cont.setFont(new Font("Times New Roman", Font.ITALIC,20));
        
        

        JButton iniciarSesion = new JButton("Iniciar Sesión");
        
        iniciarSesion.setFont(new Font("Times New Roman", Font.ITALIC,20));
        
        iniciarSesion.setBackground(Color.GRAY);

        // Añadir los componentes al panel
        panel.add(user);
        panel.add(usuario);
        panel.add(cont);
        panel.add(contraseña);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(iniciarSesion);

        // Añadir el panel a la ventana
        add(panel, BorderLayout.CENTER);

        // Añadir una acción al botón de inicio de sesión
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario1 = usuario.getText();
                String contraseña1 = new String(contraseña.getPassword());
                GestionSeleccion gesSel = new GestionSeleccion();

                if (usuario1.equals("") && contraseña1.equals("")) {
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

    public static void main(String[] args) {
        // Ejecutar la pantalla de inicio de sesión
        SwingUtilities.invokeLater(() -> new InicioDeSesionPorSeleccion());
    }
}
