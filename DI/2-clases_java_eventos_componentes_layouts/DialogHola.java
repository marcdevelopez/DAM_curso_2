package clases_y_componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

public class DialogHola extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel saludo;

	/**
	 * Create the dialog.
	 */
	public DialogHola(javax.swing.JFrame parent, boolean modal) {
		super(parent,modal);
		setBounds(100, 100, 450, 300);
		setTitle("Hola");
		setResizable(false);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 440, 266);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		saludo = new JLabel("¡¡¡Holaaaa qué pasaaaaa!!!");
		saludo.setAlignmentX(Component.CENTER_ALIGNMENT);
		saludo.setVerticalTextPosition(SwingConstants.TOP);
		saludo.setBounds(109, 97, 201, 37);
		
		contentPanel.add(saludo);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(359, 229, 54, 25);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}

		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(178, 229, 81, 25);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
	}

}
