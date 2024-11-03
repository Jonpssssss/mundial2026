package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Arbitro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField pais;
    private JLabel resultado;
	
	public Arbitro() {
		setTitle("Arbitro");
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
                String pais1 = pais.getText();
                
                if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || edad.getText().isEmpty() || pais.getText().isEmpty()) {
                    resultado.setText("Todos los campos son obligatorios.");
                    return;
                }
                
                
                try {
                	int edad1 = Integer.parseInt(edad.getText());
                	resultado.setText("Nombre Completo: " + nombre1 + " " + apellido1 + " , Edad: " + edad1 + " , Pais: "+ pais1);
                }catch (NumberFormatException ex){
                	resultado.setText("Edad debe ser un numero.");
                }

            }
        });
        guardarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (FileWriter writer = new FileWriter("arbitros.csv", true)){
					writer.write(nombre.getText() + "," + apellido.getText() + "," + edad.getText() + "," + pais.getText() + "\n");
					JOptionPane.showMessageDialog(null, "Datos guardados con exito.");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al guardar los datos.");;
				}
			}
        	
        });
    }
		
	
	public static void main (String[] args) {
		 Arbitro arbitro = new Arbitro();
         arbitro.setVisible(true);
	}
}
