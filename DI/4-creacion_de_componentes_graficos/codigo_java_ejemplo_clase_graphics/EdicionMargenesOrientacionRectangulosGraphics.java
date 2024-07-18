package interfaz_edicion_margenes_orientacion_rectangulos_graphics;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class EdicionMargenesOrientacionRectangulosGraphics extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spinnerMargenSuperior;
	JSpinner spinnerMargenInferior;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdicionMargenesOrientacionRectangulosGraphics frame = new EdicionMargenesOrientacionRectangulosGraphics();
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
	public EdicionMargenesOrientacionRectangulosGraphics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(219, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPagina = new JLabel("Página");
		lblPagina.setBounds(41, 10, 70, 15);
		contentPane.add(lblPagina);

		JLabel lblMargenSuperior = new JLabel("Margen superior");
		lblMargenSuperior.setBounds(156, 12, 119, 15);
		contentPane.add(lblMargenSuperior);

		JLabel lblMargenInferior = new JLabel("Margen inferior");
		lblMargenInferior.setBounds(156, 104, 119, 15);
		contentPane.add(lblMargenInferior);

		JLabel lblOrientacionDePagina = new JLabel("Orientación pág.");
		lblOrientacionDePagina.setBounds(296, 12, 132, 15);
		contentPane.add(lblOrientacionDePagina);

		/**
		 * Quedaría por desarrollar el límite de los spinner en caso de 
		 * que se encontraran el margen inferior y el superior, de tal
		 * manera que no dejara aumentar el margen si el otro margen es 
		 * superior al total de la altura del rectángulo menos el margen 
		 * aplicado al margen que se está modificando...
		 * No me da tiempo a desarrollarlo, si no no llegaré al examen 
		 * de DAM en diciembre! Quien lo desarrolle puede pedirme una pullrequest!
		 */
		
		//SpinnerNumberModel(comienzo, minimo, máximo, pasos)
		SpinnerNumberModel modelo1SpinnerNumberModel = new SpinnerNumberModel(0, 0, 140, 1);
		spinnerMargenSuperior = new JSpinner(modelo1SpinnerNumberModel);
		spinnerMargenSuperior.setBounds(172, 39, 63, 20);
		spinnerMargenSuperior.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				repaint();
				
			}
		});
		/**
		 * Esta es otra manera de hacerlo, pero el repaint solo se ejecuta 
		 * al pulsar otro spinner...:
		 * JSpinner.DefaultEditor editorSup = ((JSpinner.DefaultEditor) spinnerMargenSuperior.getEditor());
		JTextField textFieldSup = editorSup.getTextField();
		textFieldSup.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// cuando pierde el foco pulsando otro componente se repinta
				repaint();
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		 */
		

		contentPane.add(spinnerMargenSuperior);

		SpinnerNumberModel modelo2SpinnerNumberModel = new SpinnerNumberModel(0, 0, 140, 1);
		spinnerMargenInferior = new JSpinner(modelo2SpinnerNumberModel);
		spinnerMargenInferior.setBounds(172, 131, 63, 20);
		spinnerMargenInferior.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				repaint();
				
			}
		});
		
		/**
		 * Esta es otra manera de hacerlo, pero el repaint solo se ejecuta 
		 * al pulsar otro spinner...:
		 * JSpinner.DefaultEditor editorInf = ((JSpinner.DefaultEditor) spinnerMargenInferior.getEditor());
		JTextField textFieldInf = editorInf.getTextField();
		textFieldInf.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// cuando pierde el foco pulsando otro componente se repinta
				repaint();
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		 */
		
		
		
		contentPane.add(spinnerMargenInferior);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Horizontal", "Vertical" }));
		comboBox.setBounds(296, 39, 132, 24);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Si no lo repintamos no se cambiará
				repaint();
			}
		});

		JButton btnInicializar = new JButton("Inicializar");
		btnInicializar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spinnerMargenInferior.setValue(0);
				spinnerMargenSuperior.setValue(0);
				comboBox.setSelectedIndex(0);
				repaint();

			}

		});
		btnInicializar.setBounds(172, 215, 117, 25);
		contentPane.add(btnInicializar);

	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		// establecemos el color de los trazos
		graphics.setColor(Color.blue);
		// dibujamos un rectángulo de color blue (setColor)
		graphics.drawRect(30, 80, 100, 140);

		// obtenemos el valor del spinner para dibujar las líneas de márgenes rojas
		int ms = Integer.parseInt(spinnerMargenSuperior.getValue().toString());
		int mi = Integer.parseInt(spinnerMargenInferior.getValue().toString());

		graphics.setColor(Color.red);
		// linea superior
		graphics.drawLine(30, 80 + ms, 130, 80 + ms);
		// linea inferior
		graphics.drawLine(30, 220 - mi, 130, 220 - mi);

		// Vamos a cambiar la orientación del otro rectángulo
		String orientacionString = (String) comboBox.getSelectedItem();
		if (orientacionString.equals("Horizontal")) {
			graphics.drawRect(320, 120, 140, 100);
		} else {
			graphics.drawRect(320, 120, 100, 140);
		}

	}
}
