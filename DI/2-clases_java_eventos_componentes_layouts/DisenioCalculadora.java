package clases_y_componentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class DisenioCalculadora extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisenioCalculadora frame = new DisenioCalculadora();
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
	public DisenioCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 4, 1, 1));
		
		JButton btnVacio1 = new JButton("");
		btnVacio1.setVisible(false);
		contentPane.add(btnVacio1);
		
		JButton btnVacio2 = new JButton("");
		btnVacio2.setVisible(false);
		contentPane.add(btnVacio2);
		
		JButton btnVacio3 = new JButton("");
		btnVacio3.setVisible(false);
		contentPane.add(btnVacio3);
		
		JButton btnSumar = new JButton("+");
		contentPane.add(btnSumar);
		
		JButton btnUno = new JButton("1");
		contentPane.add(btnUno);
		
		JButton btnDos = new JButton("2");
		contentPane.add(btnDos);
		
		JButton btnTres = new JButton("3");
		contentPane.add(btnTres);
		
		JButton btnRestar = new JButton("-");
		contentPane.add(btnRestar);
		
		JButton btnCuatro = new JButton("4");
		contentPane.add(btnCuatro);
		
		JButton btnCinco = new JButton("5");
		contentPane.add(btnCinco);
		
		JButton btnSeis = new JButton("6");
		contentPane.add(btnSeis);
		
		JButton btnDividir = new JButton("/");
		contentPane.add(btnDividir);
		
		JButton btnSiete = new JButton("7");
		contentPane.add(btnSiete);
		
		JButton btnOcho = new JButton("8");
		contentPane.add(btnOcho);
		
		JButton btnNueve = new JButton("9");
		contentPane.add(btnNueve);
		
		JButton btnMultiplicar = new JButton("X");
		contentPane.add(btnMultiplicar);
		
		JButton btnCero = new JButton("0");
		contentPane.add(btnCero);
		
		JButton btnDecimal = new JButton(",");
		contentPane.add(btnDecimal);
		
		JButton btnDelete = new JButton("DEL");
		contentPane.add(btnDelete);
		
		JButton btnIgual = new JButton("=");
		contentPane.add(btnIgual);
		
	}

}
