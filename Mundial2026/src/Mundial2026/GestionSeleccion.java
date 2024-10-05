package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GestionSeleccion extends JFrame {
	private JTextField pais;
	
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
		
	
	}

	public static void main(String[] args) {
		GestionSeleccion seleccion = new GestionSeleccion();
		seleccion.setVisible(true);

	}

}
