package Mundial2026;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Arbitro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JComboBox<String> paisComboBox;
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
		paisComboBox = new JComboBox<>(getCountries());
		

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
        add(paisComboBox);
        add(botonMostrar);
        add(guardarDatos);
        add(resultado);  // Etiqueta que muestra el resultado
        
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre, apellido, edad y pais desde los campos de texto
                String nombre1 = nombre.getText();
                String apellido1 = apellido.getText();
                String pais1 = (String) paisComboBox.getSelectedItem();
                
                if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || edad.getText().isEmpty() || pais1.isEmpty()) {
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
					writer.write(nombre.getText() + "," + apellido.getText() + "," + edad.getText() + "," + (String) paisComboBox.getSelectedItem() + "\n");
					JOptionPane.showMessageDialog(null, "Datos guardados con exito.");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al guardar los datos.");;
				}
			}
        	
        });
    }
	private String[] getCountries() {
        return new String[]{
            "Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", 
            "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín", 
            "Bhután", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", 
            "Burundi", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", 
            "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", 
            "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", 
            "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada", 
            "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea-Bisáu", "Guinea Ecuatorial", "Haití", "Honduras", "Hungría", "India", 
            "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica", 
            "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", 
            "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", 
            "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", 
            "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", 
            "Omán", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", 
            "Reino Unido", "República Centroafricana", "República Checa", "República de Macedonia", "República del Congo", "República Democrática del Congo", "República Dominicana", "Ruanda", "Rumania", "Rusia", 
            "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", 
            "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur", "Suecia", "Suiza", 
            "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", 
            "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Yemen", 
            "Yibuti", "Zambia", "Zimbabue"
        };
    }
		
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Arbitro arbitro = new Arbitro();
            arbitro.setVisible(true);
        });
    }
}
