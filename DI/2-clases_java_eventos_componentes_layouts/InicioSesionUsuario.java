package clases_y_componentes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextField;

public class InicioSesionUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtBienvenida;

	// esta clase no tiene método main, ya que no es la clase principal

	/**
	 * Create the frame.
	 */
	public InicioSesionUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtBienvenida = new JTextField();
		txtBienvenida.setText("Bienvenida");
		contentPane.add(txtBienvenida, BorderLayout.NORTH);
		txtBienvenida.setColumns(10);
	}

}