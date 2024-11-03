package Mundial2026;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Mundial2026.GestionJugador.Jugador;
import Mundial2026.GestionSeleccion.Seleccion;

public class SorteoGrupos extends JFrame{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
        JPanel panelGrupos = new JPanel();
        panelGrupos.setLayout(new GridLayout(4, 2, 10, 10)); // 8 grupos organizados en 4 filas y 2 columnas
        
        // Dividir las selecciones en grupos de 4
        char grupo = 'A';
        for (int i = 0; i < selecciones.size(); i += 4) {
            // Crear panel para un grupo
            JPanel panelGrupo = new JPanel();
            panelGrupo.setBorder(BorderFactory.createTitledBorder("Grupo " + grupo)); // Añadir título "Grupo A", "Grupo B", etc.
            panelGrupo.setLayout(new BoxLayout(panelGrupo, BoxLayout.Y_AXIS)); // Organizar selecciones verticalmente
            
            // Añadir las 4 selecciones al grupo
            for (int j = i; j < i + 4 && j < selecciones.size(); j++) {
                panelGrupo.add(new JLabel(selecciones.get(j).getPais()));
            }
            
            // Añadir el panel del grupo al panel principal
            panelGrupos.add(panelGrupo);
            grupo++; // Avanzar al siguiente grupo
        }
        
        // Limpiar el contenido anterior y mostrar el nuevo panel de grupos
        getContentPane().removeAll(); // Quitar todo lo anterior de la ventana
        add(panelGrupos, BorderLayout.CENTER); // Añadir el panel con los grupos al centro de la ventana
        revalidate(); // Actualizar el layout
        repaint(); // Repintar la ventana
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