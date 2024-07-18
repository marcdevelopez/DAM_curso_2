package clases_y_componentes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioUsuarioContrasenia extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textContraseña;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioUsuarioContrasenia frame = new InicioUsuarioContrasenia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InicioUsuarioContrasenia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(46, 43, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(46, 122, 90, 16);
		contentPane.add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(268, 38, 130, 26);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(264, 117, 134, 26);
		contentPane.add(textContraseña);
		
		JButton boton_inicio = new JButton("Inicio");
		boton_inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user,pwd;
				user=textUsuario.getText();
				pwd=String.copyValueOf(textContraseña.getPassword());
				if(user.contentEquals("admin")&&pwd.equals("1234")) {
					InicioSesionUsuario acceso = new InicioSesionUsuario();
					acceso.setVisible(true);
				}else {
					JOptionPane.showInternalMessageDialog(null, "El usuario o contraseña es incorrecto");
				}
			}
		});
		boton_inicio.setBounds(93, 202, 117, 29);
		contentPane.add(boton_inicio);
		
		JButton boton_salir = new JButton("Salir");
		boton_salir.setBounds(217, 202, 117, 29);
		contentPane.add(boton_salir);
	}
}