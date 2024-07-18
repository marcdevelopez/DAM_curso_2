package mi_primera_ventana_solo_codigo;

import javax.swing.JFrame;

public class MiPrimeraVentanaSoloCodigo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Mi Primera Ventana");

		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Ventana de Inicio");

	}

}

