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

import Mundial2026.GestionJugador.Jugador;

public class GestionEntrenador extends JFrame {
	private GestionSeleccion seleccion;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField pais;
    private JLabel resultado;
    private ArrayList<Entrenador> entrenadores = new ArrayList<>();
	
	public GestionEntrenador() {
		setTitle("Entrenador");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 0, 10, 10)); // Divison del espacio
		
		JLabel etiquetaNombre = new JLabel("Nombre: "); //JLabel == crear una etiqueta
		nombre = new JTextField();
		
		JLabel etiquetaApellido = new JLabel("Apellido: ");
        apellido = new JTextField();
        
        JLabel etiquetaEdad = new JLabel("Edad: ");
		edad = new JTextField();
		
		JLabel etiquetaPais = new JLabel("Pais: ");
		pais = new JTextField();
		

        JButton botonMostrar = new JButton("Mostrar Datos");
        JButton añadirEntrenador = new JButton ("Añadir Entreandor");
        JButton volver = new JButton ("Volver");
        //JButton guardarDatos = new JButton("Guardar Datos");
        
        resultado = new JLabel("", SwingConstants.CENTER);
        //resultado.setFont(new Font("Arial", Font.BOLD, 14));
        
        add(etiquetaNombre);
        add(nombre);
        add(etiquetaApellido);
        add(apellido);
        add(etiquetaEdad);
        add(edad);
        add(etiquetaPais);
        add(pais);
        add(botonMostrar);
        add(añadirEntrenador);
        //add(volver);
        //add(guardarDatos);
        add(resultado);  // Etiqueta que muestra el resultado
        
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre, apellido, edad y pais desde los campos de texto
                String nombre1 = nombre.getText();
                String apellido1 = apellido.getText();
                String edad1 = edad.getText();
                String pais1 = pais.getText();

                // Mostrar el resultado en la etiqueta
                resultado.setText("Nombre Completo: " + nombre1 + " " + apellido1 + " , Edad: " + edad1 + " , Pais: "+ pais1);
            }
        });
        
        añadirEntrenador.addActionListener(e -> añadirEntrenador());
    }

	private void añadirEntrenador() {
		// TODO Auto-generated method stub
		String nombre1 = nombre.getText();
        String apellido1 = apellido.getText();
        String edad1 = edad.getText();
        String pais1 = pais.getText();
        entrenadores.add(new Entrenador(nombre1, apellido1,edad1,pais1));
        boolean archivoExiste = new File("entrenadores.csv").exists(); // Verificar si el archivo ya existe
        try (PrintWriter writer = new PrintWriter(new FileWriter("entrenadores.csv", true))) {
        	if (!archivoExiste) {
                writer.println("Nombre,Apellido,Edad,Pais"); // Cabecera del archivo CSV
            }
            for (Entrenador entrenador : entrenadores) {
                writer.println(entrenador.getNombre2() + "," + entrenador.getApellido2() + "," + entrenador.getEdad2() + "," + entrenador.getPais2());
               
            }
            JOptionPane.showMessageDialog(this, "Entrenador agregado: " + nombre1);
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(this, "Error ");
        }
	}

	public static void main(String[] args) {
		GestionEntrenador entrenador = new GestionEntrenador();
        entrenador.setVisible(true);
	}
	
	public static class Entrenador implements Serializable {
		 private String nombre2;
		 private String apellido2;
		 private String edad2;
	     private String pais2;
		public Entrenador(String nombre2, String apellido2, String edad2, String pais2) {
			super();
			this.nombre2 = nombre2;
			this.apellido2 = apellido2;
			this.edad2 = edad2;
			this.pais2 = pais2;
		}
		public String getNombre2() {
			return nombre2;
		}
		public void setNombre2(String nombre2) {
			this.nombre2 = nombre2;
		}
		public String getApellido2() {
			return apellido2;
		}
		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}
		public String getEdad2() {
			return edad2;
		}
		public void setEdad2(String edad2) {
			this.edad2 = edad2;
		}
		public String getPais2() {
			return pais2;
		}
		public void setPais2(String pais2) {
			this.pais2 = pais2;
		}
		@Override
		public String toString() {
			return "Entrenador [nombre2=" + nombre2 + ", apellido2=" + apellido2 + ", edad2=" + edad2 + ", pais2="
					+ pais2 + "]";
		}
	     
	}

}
