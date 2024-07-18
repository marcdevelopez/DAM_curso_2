package clases_y_componentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class EjemploGridLayout extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploGridLayout frame = new EjemploGridLayout();
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
	public EjemploGridLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		/*
		 *  ojo, al establecer las filas y columnas:
		 *  si en este caso en parámetro fila establecemos 4,
		 *  evidentemente a no haber suficientes objetos para
		 *  rellenar el grid, aparecerán 4 filas pero nu8nguna columna.
		 */
		contentPane.setLayout(new GridLayout(2,2));
		
		lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		contentPane.add(lblNewLabel_3);
		
		
	}

}
