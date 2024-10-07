package Mundial2026;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GestionJugador extends JFrame {
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField pais;
    private JLabel resultado;
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
	
	public GestionJugador() {
		setTitle("Jugador");
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
        JButton añadirJugador = new JButton("Añadir Jugador");
        JButton cerrar = new JButton ("Todo Perfecto");
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
        add(añadirJugador);
        add(cerrar);
        //add(guardarDatos);
        add(resultado);// Etiqueta que muestra el resultado
        
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
        
        añadirJugador.addActionListener(e -> añadirJugador());
        cerrar.addActionListener(e -> volver());
        
        //guardarDatos.addActionListener(e -> guardarJugadores());
	}
	private void volver() {
		// TODO Auto-generated method stub
		dispose();
		}
	
	private void añadirJugador() {
		// TODO Auto-generated method stub
		String nombre1 = nombre.getText();
        String apellido1 = apellido.getText();
        String edad1 = edad.getText();
        String pais1 = pais.getText();
        jugadores.add(new Jugador(nombre1, apellido1,edad1,pais1));
        añadirLista2(nombre1, apellido1, edad1, pais1);
        boolean archivoExiste = new File("jugadores.csv").exists(); // Verificar si el archivo ya existe
        try (PrintWriter writer = new PrintWriter(new FileWriter("jugadores.csv", true))) {
        	if (!archivoExiste) {
                writer.println("Nombre,Apellido,Edad,Pais"); // Cabecera del archivo CSV
            }
            for (Jugador jugador : jugadores) {
                writer.println(jugador.getNombre2() + "," + jugador.getApellido2() + "," + jugador.getEdad2() + "," + jugador.getPais2());
            }
            JOptionPane.showMessageDialog(this, "Jugador agregado: " + nombre1);
            borrar();
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(this, "Error ");
        }
        
	}
	
	private void borrar() {
		nombre.setText("");
		apellido.setText("");
		edad.setText("");
		pais.setText("");	
	}
	
	private static void añadirLista2(String nombre, String apellido, String edad, String pais) {
		// TODO Auto-generated method stub
		GestionSeleccion.jugadores.add(new Jugador(nombre,apellido,edad,pais));
		System.out.println(jugadores);
		
		
	}


/*
	private void guardarJugadores() {
		 try (PrintWriter writer = new PrintWriter(new FileWriter("jugadores.csv"))) {
	            writer.println("Nombre,Apellido,Edad,Pais"); // Cabecera del archivo CSV
	            for (Jugador jugador : jugadores) {
	                writer.println(jugador.getNombre2() + "," + jugador.getApellido2() + "," + jugador.getEdad2() + "," + jugador.getPais2());
	               
	            }
	            JOptionPane.showMessageDialog(this, "Jugador agregado: ");
	        } catch (IOException e) {
	        }
	}
*/

	public static void main (String[] args) {
		 GestionJugador jugador = new GestionJugador();
         jugador.setVisible(true);

	}
	
	 public static class Jugador implements Serializable {
		 private String nombre2;
		 private String apellido2;
		 private String edad2;
	     private String pais2;
	     
		public Jugador(String nombre2, String apellido2, String edad2, String pais2) {
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
			return "Jugador [nombre=" + nombre2 + ", apellido=" + apellido2 + ", edad=" + edad2 + ", pais=" + pais2
					+ "]";
		}
	    
	 }
}
