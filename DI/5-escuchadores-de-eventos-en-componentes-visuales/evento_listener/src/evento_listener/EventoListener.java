package evento_listener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventoListener extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventoListener frame = new EventoListener();
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
	public EventoListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Se coloca una etiqueta en Panel
		JLabel lblNewLabel = new JLabel("...");
		// Se añade al panel
		contentPane.add(lblNewLabel);
		// Se crea un nuevo botón y añade al panel
		JButton btnNewButton = new JButton("Pulsa aquí");
		contentPane.add(btnNewButton);
		// producción y detección de eventos del componente
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 *  Aquí se ejecuta el código cuando el listener coincide 
				 *  con este método actionPerformed...
				 */
				lblNewLabel.setText("Hola mundo");
			}
		});
	}

}
