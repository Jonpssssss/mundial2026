package Mundial2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mapaUsuario {
//    private Map<String, String> usuarios = new HashMap<>(); // Almacena usuarios y contraseñas
    private Map<String, String> usuarios1 = new HashMap<>(); // Almacena usuarios y contraseñas
    private Map<String, String> selecciones = new HashMap<>(); // Almacena usuarios y sus selecciones

    public mapaUsuario() {
      cargarUsuarios(); // Cargar usuarios al iniciar
    	//usuarios = new HashMap<>();
        // Agregar usuarios de ejemplo (usuario, contraseña)
//        usuarios.put("usuario1", "contraseña1");
//        usuarios.put("usuario2", "contraseña2");
      
      System.out.println(usuarios1);
    }

    private void cargarUsuarios() {
        File f = new File("usuarios.csv"); // Ruta al archivo CSV
        try (
        	Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[]campos = linea.split(",");
                String usuario = campos[0];
                String contraseña = campos[1];
                String pais = campos[2];

                usuarios1.put(usuario, contraseña); // Almacenar credenciales
                selecciones.put(usuario, pais); // Almacenar país
                System.out.println("Usuario agregado: " + usuario); // Confirmación
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No se pudo cargar el archivo de usuarios.");
        }
    }

    public boolean validateUser(String usuario, String contraseña) {
        return usuarios1.containsKey(usuario) && usuarios1.get(usuario).equals(contraseña);
    }

    public String getUserSelection(String usuario) {
    	//return "Argentina"; // o cualquier otro país según tu lógica
        return selecciones.get(usuario);
    }
}
