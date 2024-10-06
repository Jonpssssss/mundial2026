package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Mundial2026.GestionJugador.Jugador;

public class GestionSeleccion extends JFrame {
	private JTextField pais;
	private static ArrayList<Jugador> jugadores = new ArrayList<>();
	
	public GestionSeleccion(){
		setTitle("Seleccion");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 0, 10, 10)); // Divison del espacio
		
		JLabel etiquetaPais = new JLabel("Introducce el pais: ");
		pais = new JTextField();
		
		JButton botonAñadirJugadores = new JButton("Añadir Jugadores");
		JButton botonAñadirEntrenador = new JButton("Añadir Entrenador");
		JButton botonAñadirSeleccion = new JButton ("Añadir Seleccion");
		
		add(etiquetaPais);
		add(pais);
		
		add(botonAñadirJugadores);
		add(botonAñadirEntrenador);
		add(botonAñadirSeleccion);
		
		botonAñadirJugadores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionJugador gestionjuga = new GestionJugador();
				gestionjuga.setVisible(true);
			}
		});
		
		botonAñadirEntrenador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionEntrenador gestionentre = new GestionEntrenador();
				gestionentre.setVisible(true);
			}
		});
		
		
		botonAñadirSeleccion.addActionListener(new ActionListener() {
			
		@Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    Seleccion.guardarEnCSV(pais.getText()+ ".csv");
	                    JOptionPane.showMessageDialog(null, "Jugadores guardados en seleccion.csv con éxito.");
	                } catch (IOException ex) {
	                    JOptionPane.showMessageDialog(null, "Error al guardar en el archivo CSV.");
	                    ex.printStackTrace();
	                }
	            }
	        });
		
        
	}

	public static void main(String[] args) {
		GestionSeleccion seleccion = new GestionSeleccion();
		seleccion.setVisible(true);

	}
	
	private static class Seleccion {
		private String nombreSeleccion;
		private String entrenadorSeleccion;
		private static ArrayList<Jugador> jugadoresSeleccion = new ArrayList<>();
		
		
		public Seleccion(String nombreSeleccion, String entrenadorSeleccion) {
			super();
			this.nombreSeleccion = nombreSeleccion;
			this.entrenadorSeleccion = entrenadorSeleccion;
			this.jugadoresSeleccion = new ArrayList<>();
		}
		
	    public void agregarJugadorDesdeLista(Jugador jugador) {
	    	jugadoresSeleccion.add(jugador);
	    }

		public String getNombreSeleccion() {
			return nombreSeleccion;
		}

		public void setNombreSeleccion(String nombreSeleccion) {
			this.nombreSeleccion = nombreSeleccion;
		}

		public String getEntrenadorSeleccion() {
			return entrenadorSeleccion;
		}

		public void setEntrenadorSeleccion(String entrenadorSeleccion) {
			this.entrenadorSeleccion = entrenadorSeleccion;
		}

		public ArrayList<Jugador> getJugadoresSeleccion() {
			return jugadoresSeleccion;
		}

		@Override
		public String toString() {
			return "Seleccion [nombreSeleccion=" + nombreSeleccion + ", entrenadorSeleccion=" + entrenadorSeleccion
					+ ", jugadoresSeleccion=" + jugadoresSeleccion + "]";
		}
		
	    public static void guardarEnCSV(String nombreArchivo) throws IOException {
	    	System.out.println(jugadoresSeleccion);
	        FileWriter csvWriter = new FileWriter(nombreArchivo);
	        csvWriter.append("Nombre,Apellido,Edad,Pais");
	        for (Jugador jugador : jugadoresSeleccion) {
	            csvWriter.append(jugador.getNombre2()).append(",").append(jugador.getApellido2()).append(jugador.getEdad2()).append(",").append(jugador.getPais2());
	        }
	        csvWriter.flush();
	        csvWriter.close();
	    }
		
		
	}

}
