package primera_clase_jframe;

import java.awt.EventQueue;

public class Ventana_prueba extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_prueba frame = new Ventana_prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnIzquierdo = new JButton("aceptar");
		contentPane.add(btnIzquierdo, BorderLayout.WEST);
		
		JButton btnDerecho = new JButton("cancelar");
		contentPane.add(btnDerecho, BorderLayout.EAST);
	}

}

