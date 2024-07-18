package clases_y_componentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class EjemploFlowLayout extends JFrame {

	private JPanel contentPane;
	private JLabel jlb1;
	private JLabel jlb2;
	private JLabel jlb3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploFlowLayout frame = new EjemploFlowLayout();
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
	public EjemploFlowLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		// se ha establecido una alineación izquierda, y separación de 10 en hor. y ver.
		FlowLayout fl_contentPane = new FlowLayout(FlowLayout.LEFT, 10, 10);
		contentPane.setLayout(fl_contentPane);
		// se añaden en la misma fila
		JLabel lblNewLabel1;
		lblNewLabel1 = new JLabel("Texto1");
		contentPane.add(lblNewLabel1);
		JLabel lblNewLabel2;
		lblNewLabel2 = new JLabel("Texto2");
		contentPane.add(lblNewLabel2);
		JLabel lblNewLabel3;
		lblNewLabel3 = new JLabel("Texto3");
		contentPane.add(lblNewLabel3);
		
	}

}
