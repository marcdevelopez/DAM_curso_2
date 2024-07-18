package clases_y_componentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPago1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPago1 frame = new VentanaPago1();
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
	public VentanaPago1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("¿Seguro que quiere continuar?");
		lblNewLabel.setBounds(70, 79, 228, 15);
		contentPane.add(lblNewLabel);

		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setForeground(UIManager.getColor("OptionPane.background"));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(70, 194, 117, 25);
		contentPane.add(btnCancelar);

		JButton btnPagar = new JButton("pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPago2 pago = new VentanaPago2();
				pago.setVisible(true);
			}
		});
		btnPagar.setBackground(Color.GREEN);
		btnPagar.setBounds(269, 194, 117, 25);
		contentPane.add(btnPagar);
	}
}
