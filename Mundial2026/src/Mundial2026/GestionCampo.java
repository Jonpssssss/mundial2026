package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GestionCampo extends JFrame {
	private JTextField nombre;
	private JTextField capacidad;
	private JTextField localidad;
    private JLabel resultado;
    private ArrayList<Campo> campos = new ArrayList<>();
    
    public GestionCampo() {
    	setTitle("Campo");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 0, 10, 10)); // Divison del espacio
		
		JLabel etiquetaNombre = new JLabel("Nombre: "); //JLabel == crear una etiqueta
		nombre = new JTextField();
		
		JLabel etiquetaCapacidad = new JLabel("Capacidad: ");
        capacidad = new JTextField();
        
        JLabel etiquetaLocalidad = new JLabel("Localidad: ");
		localidad = new JTextField();
		
		 JButton botonMostrar = new JButton("Mostrar Campo");
	     JButton guardarCampo = new JButton("Guardar Campo");
	     
	     resultado = new JLabel("", SwingConstants.CENTER);
	     
	     add(etiquetaNombre);
	     add(nombre);
	     add(etiquetaCapacidad);
	     add(capacidad);
	     add(etiquetaLocalidad);
	     add(localidad);
	     add(botonMostrar);
	     add(guardarCampo);
	     add(resultado);  // Etiqueta que muestra el resultado
	     
	    botonMostrar.addActionListener(new ActionListener() {
	    @Override
	    	public void actionPerformed(ActionEvent e) {
	    		// Obtener el nombre, apellido, edad y pais desde los campos de texto
	    		String nombre1 = nombre.getText();
	    		String capacidad1 = capacidad.getText();
	    		String localidad1 = localidad.getText();
	    	
		        // Mostrar el resultado en la etiqueta
		    	resultado.setText("Nombre: " + nombre1 + " , Capacidad:  " + capacidad1 + " , Localidad: " + localidad1);
	    	}
	    });
	    
	    guardarCampo.addActionListener(e -> guardarCamp());
    }
    private void guardarCamp() {
		// TODO Auto-generated method stub
    	String nombre1 = nombre.getText();
    	String capacidad1 = capacidad.getText();
    	String localidad1 = localidad.getText();
    	campos.add(new Campo (nombre1,capacidad1,localidad1));
    	boolean archivoExiste = new File("campos.csv").exists();
    	try (PrintWriter writer = new PrintWriter(new FileWriter("campos.csv", true))) {
        	if (!archivoExiste) {
                writer.println("Nombre,Capacidad,Localidad"); // Cabecera del archivo CSV
            }
            for (Campo campo : campos) {
                writer.println(campo.getNombre2() + "," + campo.getCapacidad2() + "," + campo.getLocalidad2());
               
            }
            JOptionPane.showMessageDialog(this, "Campo agregado: " + nombre1);
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(this, "Error ");
        }
	}
	public static void main (String[] args) {
		 GestionCampo campo = new GestionCampo();
        campo.setVisible(true);
	}
	
	public static class Campo implements Serializable{
		private String nombre2;
		private String capacidad2;
		private String localidad2;
		public Campo(String nombre2, String capacidad2, String localidad2) {
			super();
			this.nombre2 = nombre2;
			this.capacidad2 = capacidad2;
			this.localidad2 = localidad2;
		}
		public String getNombre2() {
			return nombre2;
		}
		public void setNombre2(String nombre2) {
			this.nombre2 = nombre2;
		}
		public String getCapacidad2() {
			return capacidad2;
		}
		public void setCapacidad2(String capacidad2) {
			this.capacidad2 = capacidad2;
		}
		public String getLocalidad2() {
			return localidad2;
		}
		public void setLocalidad2(String localidad2) {
			this.localidad2 = localidad2;
		}
		@Override
		public String toString() {
			return "Campo [nombre2=" + nombre2 + ", capacidad2=" + capacidad2 + ", localidad2=" + localidad2 + "]";
		}
		
		
		
	}
}
