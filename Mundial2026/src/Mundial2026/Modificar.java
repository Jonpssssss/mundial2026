package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Mundial2026.GestionJugador.Jugador;

public class Modificar extends JFrame {
	private JComboBox<Jugador> comboBoxJugadores;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField pais;
    private JButton guardar;
	
	 public Modificar(ArrayList<Jugador> jugadores) {
	        // Configurar la ventana
	        setTitle("Modificar Jugador");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLayout(new GridLayout(4, 2));
	        
	        comboBoxJugadores = new JComboBox<>(jugadores.toArray(new Jugador[0]));
	        nombre = new JTextField();
	        apellido = new JTextField();
	        edad = new JTextField();
	        pais = new JTextField();
	        guardar = new JButton("Guardar Cambios");
	        
	        
	        add(new JLabel("Selecciona un jugador:"));
	        add(comboBoxJugadores);
	        
	        comboBoxJugadores.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Jugador seleccionado = (Jugador) comboBoxJugadores.getSelectedItem();
	                if (seleccionado != null) {
	                    nombre.setText(seleccionado.getNombre2());
	                    apellido.setText(seleccionado.getNombre2());
	                    pais.setText(seleccionado.getNombre2());
	                    edad.setText(String.valueOf(seleccionado.getEdad2()));
	                }
	            }
	        });
	        
	        guardar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Jugador seleccionado = (Jugador) comboBoxJugadores.getSelectedItem();
	                if (seleccionado != null) {
	                    seleccionado.setNombre2(nombre.getText());
	                    seleccionado.setApellido2(apellido.getText());
	                    seleccionado.setEdad2(edad.getText());
	                    seleccionado.setPais2(edad.getText());
	                    JOptionPane.showMessageDialog(null, "Cambios guardados con éxito.");
	                }
	            }
	        });
	        
	 }
		public static void main(String[] args) {
			Modificar modificar = new Modificar(null);
	        modificar.setVisible(true);
		}
	     
}
