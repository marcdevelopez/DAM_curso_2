package clases_y_componentes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ClasesYComponentes extends JFrame {

	private JPanel panelPrincipal;
	// este panel no se usará, sólo es para aprender a agregarlo a uno ya existente
	private JPanel panelSecundario;
	private JDialog ventanaSecundaria;
	private JTextField tfNombre;
	private static ClasesYComponentes frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ClasesYComponentes();
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
	public ClasesYComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		// se inicializa un panel secundario
		panelSecundario = new JPanel();
		panelSecundario.setBounds(219, 144, 0, 0);
		panelSecundario.setAlignmentY(1.0f);
		panelSecundario.setAlignmentX(1.0f);
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		// Creamos una etiqueta
		JLabel etiqueta_1 = new JLabel("Hola Mundo JLabel");
		etiqueta_1.setBounds(31, 31, 131, 15);
		etiqueta_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		etiqueta_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelPrincipal.add(etiqueta_1);
		// Creamos un boton que enlace con DialogHola
		JButton btAbreDialogHola = new JButton("saludar");
		btAbreDialogHola.setBounds(282, 26, 83, 25);
		panelPrincipal.add(btAbreDialogHola);
		// establecemos tipo y tamaño de letra
		btAbreDialogHola.setFont(new Font("Monospaced", Font.BOLD, 12));
		// establecemos el color de fondo del botón
		btAbreDialogHola.setBackground(Color.MAGENTA);
		// determinamos el color del texto
		btAbreDialogHola.setForeground(Color.white);
		// agregamos imagen de fondo al botón, ojo, el tamaño de la imagen importa
		btAbreDialogHola.setIcon(null);
		// determinamos si estará activo o no el botón
		btAbreDialogHola.setEnabled(true);
		// ponemos a la escucha al botón para el evento:
		btAbreDialogHola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 *  en el método actionPerformed creamos y lanzamos 
				 *  el DialogHola. Tendrá dos parámetros, definidos en 
				 *  el constructor de DialogHola: un JFrame (el actual, 
				 *  al que retornará si programamos un cierre de Jdialog),
				 *  y un boolean, si es true será modal, es decir, no 
				 *  permitirá más ventanas hasta que se ejecute la acción
				 *  que decidamos mediante código en, por ejemplo, un JButton.
				 */
				DialogHola hola = new DialogHola(frame,true);
				/*
				 *  Los diálogos modales son aquellos que no permiten 
				que otras ventanas de diálogo se abran hasta que la
				que se encuentra abierta se haya cerrado; 
				Para indicar a cuál de estos tipos pertenecen, utilizamos 
				el flag de modal del constructor de JDialog, indicando
				a true para modal, y false para no modal.
				Así creamos diálogos modales:
				Hemos definido un JDialog con los componentes que deseemos. 
				Su constructor dispondrá de dos parámetros: parent y modal, 
				que indican el padre del JDialog, y si la ventana es modal 
				(hasta que no se cierre no podemos acceder al padre) o no modal.
				*/
				hola.setModal(true);
				hola.setVisible(true);
				/*
				 * el siguiente método cierra esta ventana y deja abierta a la que se llama
				 */

				dispose();
			}
		});

		// colocamos el secundario dentro del panel principal, sólo para mostrar cómo se
		// hace
		panelPrincipal.add(panelSecundario);
		panelSecundario.setLayout(new BoxLayout(panelSecundario, BoxLayout.X_AXIS));

		tfNombre = new JTextField();
		tfNombre.setBounds(282, 120, 114, 19);
		panelPrincipal.add(tfNombre);
		// tamaño de la caja de texto
		tfNombre.setColumns(10);
		// texto que aparece al inicio en textField
		tfNombre.setText("Fulanito/a");

		JLabel lblCualEsTuNombre = new JLabel("¿Cual es tu nombre?");
		lblCualEsTuNombre.setBounds(31, 122, 219, 15);
		panelPrincipal.add(lblCualEsTuNombre);

		JCheckBox chckbxSoyCateto = new JCheckBox("Soy cateto (puntúa)");
		chckbxSoyCateto.setBounds(31, 162, 172, 23);
		panelPrincipal.add(chckbxSoyCateto);

		// creación de radioButton y agrupación en ButtonGroup
		JRadioButton rbHombre = new JRadioButton("hombre");
		rbHombre.setBounds(31, 201, 149, 23);
		panelPrincipal.add(rbHombre);
		JRadioButton rbMujer = new JRadioButton("mujer");
		rbMujer.setBounds(31, 228, 149, 23);
		ButtonGroup bgSexo = new ButtonGroup();
		bgSexo.add(rbMujer);
		bgSexo.add(rbHombre);

		panelPrincipal.add(rbMujer);

		JLabel lblNivelEstudios = new JLabel("Nivel de estudios:");
		lblNivelEstudios.setBounds(238, 166, 127, 15);
		panelPrincipal.add(lblNivelEstudios);

		JComboBox comboBox = new JComboBox();
		/*
		 * si establecemos el máximo de filas, se excluirán las siguientes en orden
		 * ("profundo" no se mostrará si establecemos 2 como máximo). Pero si 
		 * establecemos un número mayor se mostrarán todas, sin filas en blanco.
		 */
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] 
				{ "Mark Zuckerberg", "medio", "profundo" }));
		// setSelectedIndex comienza en "0", de modo que 1 = "medio".
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(238, 193, 158, 24);
		panelPrincipal.add(comboBox);

		// inicializamos una ventana de diálogo JDialog
		ventanaSecundaria = new JDialog();

		/*
		 * los diálogos de tipo no modal sí permitirán que haya tantos JDialog abiertos
		 * como se desee. true sólo permitirá este.
		 */
		ventanaSecundaria.setModal(false);

	}
}
