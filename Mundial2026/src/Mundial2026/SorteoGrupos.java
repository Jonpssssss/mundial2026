package Mundial2026;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import Mundial2026.GestionJugador.Jugador;
import Mundial2026.GestionSeleccion.Seleccion;

public class SorteoGrupos extends JFrame{
		private ArrayList<Seleccion>selecciones = new ArrayList<>();
		private JTextArea areaResultado;
	
	public SorteoGrupos() {
		
		selecciones = new ArrayList<>();
		cargarSelecciones(selecciones);
		
		setTitle ("Sorteo");
		setSize(1000,600);
		setLocationRelativeTo(null);
		
		
		JButton sorteo = new JButton ("Realizar Sorteo");
		areaResultado = new JTextArea();
        areaResultado.setEditable(false);
		
		sorteo.addActionListener(e -> crearSorteo());
		
		add(sorteo, BorderLayout.NORTH);
		add(areaResultado);
	}
	private void crearSorteo() {
		// TODO Auto-generated method stub
		Collections.shuffle(selecciones);
		
        StringBuilder resultado = new StringBuilder();
        char grupo = 'A';
		
		for (int i = 0; i < selecciones.size(); i++) {
			if(i % 4 == 0) {
				resultado.append("\nGrupo " + grupo + ":\n");
		        grupo++;
			}
			resultado.append("- " + selecciones.get(i).getPais() + "\n");
		}
		areaResultado.setText(resultado.toString());
		
	}
	private void cargarSelecciones(ArrayList<Seleccion>sele) {
		File f = new File("selecciones.csv");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[]campos = linea.split(",");
				String nombre = campos[0];
				Seleccion nueva = new Seleccion(nombre);
				selecciones.add(nueva);
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SorteoGrupos sorteo = new SorteoGrupos();
		sorteo.setVisible(true);

	}
}
