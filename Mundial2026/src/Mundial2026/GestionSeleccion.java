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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Mundial2026.GestionEntrenador.Entrenador;
import Mundial2026.GestionJugador.Jugador;

public class GestionSeleccion extends JFrame {
	private static JTextField pais;
	static ArrayList<Entrenador> entrenadores = new ArrayList<>();
	static ArrayList<Jugador> jugadores = new ArrayList<>();
	
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
		JButton modificar = new JButton("Modificar");
		
				
		add(etiquetaPais);
		add(pais);
		
		add(botonAñadirJugadores);
		add(botonAñadirEntrenador);
		add(botonAñadirSeleccion);
		add (modificar);
		
		System.out.println(jugadores);
		
		modificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Modificar modifi = new Modificar();
				modifi.setVisible(true);
			}
		});		
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
				boolean archivoExiste = new File(pais.getText()+ ".csv").exists(); // Verificar si el archivo ya existe
	                try (PrintWriter writer = new PrintWriter(new FileWriter(pais.getText()+ ".csv", true))){
	                	if (!archivoExiste) {
	                		writer.print("Entrenador: ");
	                		for (Entrenador entrenador : entrenadores) {
		                		if (entrenador.getPais2().equals(pais.getText())) {
		                			writer.println(entrenador.getNombre2() + "," + entrenador.getApellido2());
								}
		                    }
	                		writer.print("");
	                		writer.print("Jugadores: ");
	                        writer.println("Nombre,Apellido,Edad,Pais"); // Cabecera del archivo CSV
	                        for (Jugador jugador : jugadores) {
		                		if (jugador.getPais2().equals(pais.getText())) {
		                			writer.println(jugador.getNombre2() + "," + jugador.getApellido2() + "," + jugador.getEdad2() + "," + jugador.getPais2());
								}
		                    }
	                    }
	                	JOptionPane.showMessageDialog(null, "Jugadores guardados en " + pais.getText() + ".csv con éxito.");
	                } catch (IOException ex) {
	                    JOptionPane.showMessageDialog(null, "Error al guardar en el archivo CSV.");
	                    ex.printStackTrace();
	                }
	                boolean archivoExiste1 = new File("selecciones.csv").exists(); // Verificar si el archivo ya existe
	                try (PrintWriter writer = new PrintWriter(new FileWriter("selecciones.csv", true))){
	                	if (!archivoExiste) {
	                		writer.println(pais.getText());
	                    }
	                } catch (IOException ex) {	           
	                    ex.printStackTrace();
	                }
	            }
	        });
		
		
	}
	
	public static JTextField getPais() {
		return pais;
	}

	public static void setPais(JTextField pais) {
		GestionSeleccion.pais = pais;
	}

	public static ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public static void setEntrenadores(ArrayList<Entrenador> entrenadores) {
		GestionSeleccion.entrenadores = entrenadores;
	}

	public static ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public static void setJugadores(ArrayList<Jugador> jugadores) {
		GestionSeleccion.jugadores = jugadores;
	}

	public static void main(String[] args) {
		GestionSeleccion seleccion = new GestionSeleccion();
		seleccion.setVisible(true);

	}

	public static String mirarSeleccion() {
		// TODO Auto-generated method stub
		return GestionSeleccion.pais.getText();
	}
	
	public static class Seleccion {
		private String pais;
		private ArrayList<Jugador>jugadores;
		private ArrayList<Entrenador> entrenadores;
		
		public Seleccion(String pais) {
			super();
			this.pais = pais;
			this.jugadores = jugadores;
			this.entrenadores = entrenadores;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public ArrayList<Jugador> getJugadores() {
			return jugadores;
		}
		public void setJugadores(ArrayList<Jugador> jugadores) {
			this.jugadores = jugadores;
		}
		public ArrayList<Entrenador> getEntrenadores() {
			return entrenadores;
		}
		public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
			this.entrenadores = entrenadores;
		}
		@Override
		public String toString() {
			return "Seleccion [pais=" + pais +"]";
		}
		
		
	}
}
