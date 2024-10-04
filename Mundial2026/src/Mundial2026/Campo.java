package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Campo extends JFrame {
	private JTextField nombre;
	private JTextField capacidad;
	private JTextField localidad;
    private JLabel resultado;
    
    public Campo() {
    	setTitle("Campo");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 0, 10, 10)); // Divison del espacio
		
		JLabel etiquetaNombre = new JLabel("Nombre: "); //JLabel == crear una etiqueta
		nombre = new JTextField();
		
		JLabel etiquetaCapacidad = new JLabel("Capacidad: ");
        capacidad = new JTextField();
        
        JLabel etiquetaLocalidad = new JLabel("Localidad: ");
		localidad = new JTextField();
		
		 JButton botonMostrar = new JButton("Mostrar Campo");
	     JButton guardarDatos = new JButton("Guardar Campo");
	     
	     resultado = new JLabel("", SwingConstants.CENTER);
	     
	     add(etiquetaNombre);
	     add(nombre);
	     add(etiquetaCapacidad);
	     add(capacidad);
	     add(etiquetaLocalidad);
	     add(localidad);
	     add(botonMostrar);
	     add(guardarDatos);
	     add(resultado);  // Etiqueta que muestra el resultado
	     
	    botonMostrar.addActionListener(new ActionListener() {
	    @Override
	    	public void actionPerformed(ActionEvent e) {
	    		// Obtener el nombre, apellido, edad y pais desde los campos de texto
	    		String nombre1 = nombre.getText();
	    		String capacidad1 = capacidad.getText();
	    		String localidad1 = localidad.getText();
	    	
		        // Mostrar el resultado en la etiqueta
		    	resultado.setText("Nombre: " + nombre1 + " , Capacidad:  " + capacidad1 + " , Localidad: " + localidad1);
	    	}
	    });
    }
    public static void main (String[] args) {
		 Campo campo = new Campo();
        campo.setVisible(true);
	}
}
