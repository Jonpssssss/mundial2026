package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Mundial2026.GestionJugador.Jugador;

public class Modificar extends JFrame {
	private JComboBox<Jugador> comboBoxJugadores;
	static ArrayList<Jugador> juga = new ArrayList<>();
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField pais;
    private JButton guardar;
    private ArrayList<Jugador>jugar = new ArrayList<>();
	
	 public Modificar() {
	        // Configurar la ventana
	        setTitle("Modificar Jugador");
	        setSize(1000,600);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new GridLayout(7, 0, 10, 10));
	        
	        
	        cargarJugadores(jugar);
	        
	        for (Jugador jugador : jugar) {
	        	//System.out.println(GestionSeleccion.mirarSeleccion());
				if(jugador.getPais2().equals(GestionSeleccion.mirarSeleccion())) {
					juga.add(jugador);
				}
			}
	        System.out.println(GestionSeleccion.getPais());
	        System.out.println(juga);
	        
	        comboBoxJugadores = new JComboBox<>(juga.toArray(new Jugador[0]));
	        nombre = new JTextField();
	        apellido = new JTextField();
	        edad = new JTextField();
	        pais = new JTextField();
	        JButton cerrar = new JButton ("Todo Perfecto");
	        guardar = new JButton("Guardar Cambios");
	        
	        
	        add(new JLabel("Selecciona un jugador:"));
	        add(comboBoxJugadores);
	        add(new JLabel("Nombre:"));
	        add(nombre);
	        add(new JLabel("Apellido:"));
	        add(apellido);
	        add(new JLabel("Pais:"));
	        add(pais);
	        add(new JLabel("Edad:"));
	        add(edad);
	        add(new JLabel());  // Espacio vacío para el layout
	        add(guardar);
	        add(new JLabel());  // Espacio vacío para el layout
	        add(cerrar);
	        
	        cerrar.addActionListener(e -> volver());
	        
	        
	        comboBoxJugadores.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Jugador seleccionado = (Jugador) comboBoxJugadores.getSelectedItem();
	                if (seleccionado != null) {
	                    nombre.setText(seleccionado.getNombre2());
	                    apellido.setText(seleccionado.getApellido2());
	                    pais.setText(seleccionado.getPais2());
	                    edad.setText(seleccionado.getEdad2());
	                }
	            }
	        });
	        
	        guardar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Jugador seleccionado = (Jugador) comboBoxJugadores.getSelectedItem();
	                if (seleccionado != null) {
	                    try {
	                    	seleccionado.setNombre2(nombre.getText());
		                    seleccionado.setApellido2(apellido.getText());
		                    seleccionado.setEdad2(edad.getText());
		                    seleccionado.setPais2(pais.getText());
		                    guardarJugadores(pais.getText() + ".csv");
	                        JOptionPane.showMessageDialog(null, "Cambios guardados con éxito.");
	                    } catch (NumberFormatException ex) {
	                        JOptionPane.showMessageDialog(null, "Edad inválida. Ingrese un número.");
	                    } catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                }
	            }

				private void guardarJugadores(String string) throws IOException {
					// TODO Auto-generated method stub
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(string))) {
			            bw.write("nombre,apellido,edad,pais\n"); // Cabecera
			            ArrayList<Jugador> jugadores = GestionSeleccion.getJugadores(); // Obtener la lista actualizada de jugadores
			            for (Jugador jugador : jugadores) {
			                bw.write(jugador.getNombre2() + "," + jugador.getApellido2() + "," + jugador.getEdad2() + "," + jugador.getPais2());
			            }
			        }
					
				}
	        });
	        
	 }
		private void cargarJugadores(ArrayList<Jugador>jugar) {
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
					juga.add(nuevo);
				}
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			Modificar modificar = new Modificar();
	        modificar.setVisible(true);
		}
		
        private void volver() {
    		// TODO Auto-generated method stub
    		dispose();
    		}
	     
}
