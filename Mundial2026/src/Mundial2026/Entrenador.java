package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Entrenador extends JFrame{
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField pais;
    private JLabel resultado;
	
	public Entrenador() {
		setTitle("Entrenador");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 0, 10, 10)); // Divison del espacio
		
		JLabel etiquetaNombre = new JLabel("Nombre: "); //JLabel == crear una etiqueta
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
        //resultado.setFont(new Font("Arial", Font.BOLD, 14));
        
        add(etiquetaNombre);
        add(nombre);
        add(etiquetaApellido);
        add(apellido);
        add(etiquetaEdad);
        add(edad);
        add(etiquetaPais);
        add(pais);
        add(botonMostrar);
        add(guardarDatos);
        add(resultado);  // Etiqueta que muestra el resultado
        
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre, apellido, edad y pais desde los campos de texto
                String nombre1 = nombre.getText();
                String apellido1 = apellido.getText();
                String edad1 = edad.getText();
                String pais1 = pais.getText();

                // Mostrar el resultado en la etiqueta
                resultado.setText("Nombre Completo: " + nombre1 + " " + apellido1 + " , Edad: " + edad1 + " , Pais: "+ pais1);
            }
        });
    }
		
	
	public static void main (String[] args) {
		 Entrenador entrenador = new Entrenador();
         entrenador.setVisible(true);
	}
}
