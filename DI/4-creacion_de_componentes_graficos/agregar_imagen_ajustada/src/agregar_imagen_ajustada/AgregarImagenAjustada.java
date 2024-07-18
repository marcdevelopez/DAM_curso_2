package agregar_imagen_ajustada;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AgregarImagenAjustada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int ancho=500;
	private int alto=500;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarImagenAjustada frame = new AgregarImagenAjustada();
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
	public AgregarImagenAjustada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, ancho, alto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i= t.getImage("java.png");
        /**
         *  situo la imagen + 50 px en x e y para que no salga recortada
         *  y disminuyo el ancho y alto de la imagen por el mismo motivo
         */
        g.drawImage(i, 50, 50, ancho-100, alto-100, this);
    }

}
