package Mundial2026;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import Mundial2026.GestionJugador.Jugador;

public class JugadorListCellRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = 1L;
	
	@Override
	 public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
	 // modificamos el comportamiento por defecto del renderer del JList
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
        if(value instanceof Jugador) {
        	Jugador jugador = (Jugador)value;
        	String pais = jugador.getPais2();
        	//if(pais.equals)
        	label.setText(jugador.getNombre2() + " " + jugador.getApellido2());
        }
        return label;
	 }
}
