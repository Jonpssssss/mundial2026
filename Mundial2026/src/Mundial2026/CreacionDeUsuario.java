package Mundial2026;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreacionDeUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField contra;
	private JTextField seleccion;
	
	public CreacionDeUsuario () {
		setTitle("Creacion de usuario");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    setLocationRelativeTo(null);
	    
	    JPanel panelNorte = new JPanel();
	    JLabel bienvenida = new JLabel("Bienvenido a la creacion de usuario");
	    panelNorte.add(bienvenida);
	    add(panelNorte, BorderLayout.NORTH);
	    JPanel panelCentral = new JPanel(new GridLayout(4,0,10,10));
	    JLabel usuario = new JLabel("Nombre de usuario: ");
	    nombre = new JTextField();
	    JLabel contraseña = new JLabel("Contraseña: ");
	    contra = new JPasswordField();
	    JLabel pais = new JLabel("Introduce tu Pais: ");
	    seleccion = new JTextField();
	    
	    JButton guardar = new JButton("Guardar informacion");
	    
	    panelCentral.add(usuario);
	    panelCentral.add(nombre);
	    panelCentral.add(contraseña);
	    panelCentral.add(contra);
	    panelCentral.add(pais);
	    panelCentral.add(seleccion);
	    panelCentral.add(guardar);
	    
	    add(panelCentral, BorderLayout.CENTER);
	    
	    
	    guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guardarUsuario();
				
			}
		});
	}

	private void guardarUsuario() {
		String nombre1 = nombre.getText();
        String contraseña1 = contra.getText();
        String pais1 = seleccion.getText();
        
		boolean archivoExiste = new File("usuarios.csv").exists(); // Verificar si el archivo ya existe
		 try (PrintWriter writer = new PrintWriter(new FileWriter("usuarios.csv", true))) {
	        	if (!archivoExiste) {
	                writer.println("Nombre,Contraseña,Pais"); // Cabecera del archivo CSV
	            }
	                writer.println(nombre1 + "," + contraseña1 + "," + pais1);
	            JOptionPane.showMessageDialog(this, "Usuario agregado: " + nombre1);
	           
	            InicioDeSesioPorSeleccion inicio = new InicioDeSesioPorSeleccion();
	            inicio.setVisible(true);
	            dispose();
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(this, "Error ");
	        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreacionDeUsuario creacion = new CreacionDeUsuario();
		creacion.setVisible(true);
	}

}
