package Mundial2026;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreacionDeUsuario extends JFrame {
	private JTextField nombre;
	private JTextField contra;
	private JTextField seleccion;
	
	public CreacionDeUsuario () {
		setTitle("Creacion de usuario");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 0, 10, 10)); // Divison del espacio
	    setLocationRelativeTo(null);
	    
	    JLabel usuario = new JLabel("Nombre de usuario: ");
	    nombre = new JTextField();
	    JLabel contraseña = new JLabel("Contraseña: ");
	    contra = new JTextField();
	    JLabel pais = new JLabel("Introduce tu Pais: ");
	    seleccion = new JTextField();
	    
	    JButton guardar = new JButton("Guardar informacion");
	    
	    add(usuario);
	    add(nombre);
	    add(contraseña);
	    add(contra);
	    add(pais);
	    add(seleccion);
	    add(guardar);
	    
	    guardar.addActionListener(e -> guardarUsuario());
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
	                writer.println(nombre1 + "," + contraseña1 + "," + pais1 + ",");
	            JOptionPane.showMessageDialog(this, "Usuario agregado: " + nombre1);
	            InicioDeSesioPorSeleccion inicioDeSesioPorSeleccion = new InicioDeSesioPorSeleccion();
				inicioDeSesioPorSeleccion.setVisible(true);
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
