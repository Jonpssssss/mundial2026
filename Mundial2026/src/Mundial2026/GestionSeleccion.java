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
				boolean archivoExiste = new File(pais.getText()+ ".csv").exists(); // Verificar si el archivo ya existe
	                try (PrintWriter writer = new PrintWriter(new FileWriter(pais.getText()+ ".csv", true))){
	                	if (!archivoExiste) {
	                        writer.println("Nombre,Apellido,Edad,Pais"); // Cabecera del archivo CSV
	                    }
	                	for (Jugador jugador : jugadores) {
	                		if (jugador.getPais2().equals(pais.getText())) {
	                			writer.println(jugador.getNombre2() + "," + jugador.getApellido2() + "," + jugador.getEdad2() + "," + jugador.getPais2());
							}
	                    }
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

}
