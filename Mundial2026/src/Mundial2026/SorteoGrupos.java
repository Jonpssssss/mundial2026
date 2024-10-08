package Mundial2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import Mundial2026.GestionJugador.Jugador;
import Mundial2026.GestionSeleccion.Seleccion;

public class SorteoGrupos extends JFrame{
		private ArrayList<Seleccion>selecciones = new ArrayList<>();
	
	public SorteoGrupos() {
		
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
}
