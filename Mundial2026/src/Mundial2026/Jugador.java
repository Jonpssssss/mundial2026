package Mundial2026;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Jugador extends JFrame {
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField pais;
    private JLabel resultado;
	
	public Jugador() {
		setTitle("Jugador");
		setSize(600,600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 0, 10, 10));
		
		JLabel etiquetaNombre = new JLabel("Nombre: ");
		nombre = new JTextField();
		
		JLabel etiquetaApellido = new JLabel("Apellido: ");
        apellido = new JTextField();
        
        JLabel etiquetaEdad = new JLabel("Edad: ");
		edad = new JTextField();
		
		JLabel etiquetaPais = new JLabel("Pais: ");
		pais = new JTextField();
		

        JButton botonMostrar = new JButton("Mostrar Datos");
        JButton guardarDatos = new JButton("Guardar Datos");
        
        resultado = new JLabel("", SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 14));
        
        add(etiquetaNombre);
        add(nombre);
        add(etiquetaApellido);
        add(apellido);
        add(etiquetaEdad);
        add(edad);
        add(etiquetaPais);
        add(pais);
        //add(botonMostrar);
        //add(botonMostrar, BorderLayout.NORTH);
        add(botonMostrar);
        add(guardarDatos);
        add(resultado);  // Etiqueta que muestra el resultado
        
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre y apellido desde los campos de texto
                String nombre1 = nombre.getText();
                String apellido1 = apellido.getText();
                String edad1 = edad.getText();
                String pais1 = pais.getText();

                // Mostrar el resultado en la etiqueta
                resultado.setText("Nombre Completo: " + nombre1 + " " + apellido1 + "Edad:" + edad1 + "Pais"+ pais1);
            }
        });
    }
		
	
	public static void main (String[] args) {
		 Jugador jugador = new Jugador();
         jugador.setVisible(true);
	}
}
