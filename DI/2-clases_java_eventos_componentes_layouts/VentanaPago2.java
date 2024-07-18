package clases_y_componentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VentanaPago2 extends JFrame {

	private JPanel contentPane;

	// En esta clase no tenemos método main ya que no es la clase principal

	/**
	 * Create the frame.
	 */
	public VentanaPago2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMedioPagoSeleccione = new JLabel("Seleccione el método de pago");
		lblMedioPagoSeleccione.setBounds(92, 45, 305, 15);
		contentPane.add(lblMedioPagoSeleccione);
		
		JRadioButton rdbtnPayPal = new JRadioButton("PayPal");
		rdbtnPayPal.setSelected(true);
		rdbtnPayPal.setBounds(105, 88, 149, 23);
		contentPane.add(rdbtnPayPal);
		
		JRadioButton rdbtnTarjCred = new JRadioButton("Tarjeta de crédito");
		rdbtnTarjCred.setBounds(105, 115, 149, 23);
		contentPane.add(rdbtnTarjCred);
		
		JRadioButton rdbtnTaquilla = new JRadioButton("Taquilla");
		rdbtnTaquilla.setBounds(105, 142, 149, 23);
		contentPane.add(rdbtnTaquilla);
		
		ButtonGroup btGroupMetodosPago = new ButtonGroup();
		btGroupMetodosPago.add(rdbtnPayPal);
		btGroupMetodosPago.add(rdbtnTarjCred);
		btGroupMetodosPago.add(rdbtnTaquilla);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setBounds(92, 200, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("ok");
		btnOk.setBounds(280, 200, 117, 25);
		contentPane.add(btnOk);
	}
}
