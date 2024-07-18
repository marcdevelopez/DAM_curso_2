package interfaz_teclado_piano_eventos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfugue.player.Player;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfazTeclado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Player player=new Player(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazTeclado frame = new InterfazTeclado();
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
	public InterfazTeclado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JButton btnDO = new JButton("DO");
		btnDO.setBounds(12, 10, 55, 250);;
		contentPane.add(btnDO);
		
		JButton btnRE = new JButton("RE");
		btnRE.setBounds(71, 10, 55, 250);
		contentPane.add(btnRE);
		
		JButton btnMI = new JButton("MI");
		btnMI.setBounds(130, 10, 55, 250);
		contentPane.add(btnMI);
		
		JButton btnFA = new JButton("FA");
		btnFA.setBounds(189, 10, 55, 250);
		contentPane.add(btnFA);
		
		JButton btnSOL = new JButton("SOL");
		btnSOL.setBounds(247, 10, 55, 250);
		contentPane.add(btnSOL);
		
		JButton btnLA = new JButton("LA");
		btnLA.setBounds(306, 10, 55, 250);
		contentPane.add(btnLA);
		
		JButton btnSI = new JButton("SI");
		btnSI.setBounds(364, 10, 55, 250);
		contentPane.add(btnSI);
		
		// según el evento ejecutamos un código:
		btnDO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.play("C");
			}
		});
		btnRE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.play("D");
			}
		});
		btnMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.play("E");
			}
		});
		btnFA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.play("F");
			}
		});
		btnSOL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.play("G");
			}
		});
		btnLA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.play("A");
			}
		});
		btnSI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.play("B");
			}
		});
	
	}
}
