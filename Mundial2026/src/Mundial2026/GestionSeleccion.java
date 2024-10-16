package Mundial2026;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Mundial2026.GestionEntrenador.Entrenador;
import Mundial2026.GestionJugador.Jugador;

public class GestionSeleccion extends JFrame {
	private static JTextField pais;
	public GestionSeleccion(){
		setTitle("Seleccion");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		List<Entrenador> entrenadorLista = new ArrayList<>();
		List<Jugador> jugadorLista = new ArrayList<>();
		
		cargarJugadores(jugadorLista);
		cargarEntrenadores (entrenadorLista);
		
		DefaultListModel<Jugador> modeloLista = new DefaultListModel<>();
		modeloLista.addAll(jugadorLista);
		
		JList<Jugador> jLista = new JList<>(modeloLista);
		jLista.setFixedCellWidth(200);
		jLista.setCellRenderer(new JugadorListCellRenderer());
		
		JScrollPane izquierda = new JScrollPane(jLista);
		add(izquierda, BorderLayout.WEST);
		
		
		JPanel panelCentral = new JPanel(new GridLayout(6, 2, 10, 10)); // Divison del espacio
		
		JLabel etiquetaPais = new JLabel("Introducce el pais: ");
        pais = new JTextField();

        JButton botonAñadirJugadores = new JButton("Añadir Jugadores");
        JButton botonAñadirEntrenador = new JButton("Añadir Entrenador");
        JButton botonAñadirSeleccion = new JButton("Añadir Seleccion");
        JButton modificar = new JButton("Modificar");

        panelCentral.add(etiquetaPais);
        panelCentral.add(pais);
        panelCentral.add(botonAñadirJugadores);
        panelCentral.add(botonAñadirEntrenador);
        panelCentral.add(botonAñadirSeleccion);
        panelCentral.add(modificar);
        
        add(panelCentral, BorderLayout.CENTER);
        
		
		modificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Modificar modifi = new Modificar();
				modifi.setVisible(true);
				dispose();
			}
		});		
		botonAñadirJugadores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionJugador gestionjuga = new GestionJugador();
				gestionjuga.setVisible(true);
				
				dispose();
			}
		});
		
		botonAñadirEntrenador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionEntrenador gestionentre = new GestionEntrenador();
				gestionentre.setVisible(true);
				dispose();
			}
		});
		
		
		botonAñadirSeleccion.addActionListener(new ActionListener() {
			
		@Override
	            public void actionPerformed(ActionEvent e) {
				boolean archivoExiste = new File(pais.getText()+ ".csv").exists(); // Verificar si el archivo ya existe
	                try (PrintWriter writer = new PrintWriter(new FileWriter(pais.getText()+ ".csv", false))){

	                	writer.print("Entrenador: ");
	                	for (Entrenador entrenador : entrenadorLista) {
	                		if (entrenador.getPais2().equals(pais.getText())) {
	                			writer.println(entrenador.getNombre2() + "," + entrenador.getApellido2());
	                			}
	                		}
	                
	                	writer.println("");
                		writer.println("Jugadores: ");
	                	for (Jugador jugador : jugadorLista) {
	                		if (jugador.getPais2().equals(pais.getText())) {
	                			writer.println(jugador.getNombre2() + "," + jugador.getApellido2() + "," + jugador.getEdad2() + "," + jugador.getPais2());
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
	
	private void cargarEntrenadores(List<Entrenador> entrenadorLista) {
		// TODO Auto-generated method stub
		File f = new File("entrenadores.csv");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[]campos = linea.split(",");
				String nombre = campos[0];
				String apellido = campos[1];
				String edad = campos[2];
				String pais = campos[3];
				Entrenador nuevo = new Entrenador(nombre,apellido,edad,pais);
				entrenadorLista.add(nuevo);
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cargarJugadores(List<Jugador> jugadorLista) {
		File f = new File("jugadores.csv");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[]campos = linea.split(",");
				String nombre = campos[0];
				String apellido = campos[1];
				String edad = campos[2];
				String pais = campos[3];
				Jugador nuevo = new Jugador(nombre,apellido,edad,pais);
				jugadorLista.add(nuevo);
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static JTextField getPais() {
		return pais;
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
