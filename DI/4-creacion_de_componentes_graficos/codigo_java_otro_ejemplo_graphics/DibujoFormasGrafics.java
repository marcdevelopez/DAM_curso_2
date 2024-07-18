package dibujo_formas_graphics;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DibujoFormasGrafics extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DibujoFormasGrafics frame = new DibujoFormasGrafics();
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
	public DibujoFormasGrafics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(100, 100, 800, 300);
	}

	@Override
	public void paint(Graphics graphics) {
		// Llamar al método paint de la clase superior.
		super.paint(graphics);
		// Activar el método del color que queramos, en este caso es verde
		graphics.setColor(Color.green);
		/**
		 * Dibujar un óvalo desde la coordenada ‘x’ en 150 píxeles e ‘y’ en 70 píxeles.
		 * Con un radio en el eje ‘x’ de 50
		 */
		graphics.fillOval(150, 70, 50, 70);
		graphics.setColor(Color.yellow);
		/**
		 * Dibujar un rectángulo que comience en el eje ‘x’ en el píxel 350 y en el eje
		 * ‘y’ en el 70. De ancho que tenga 50 píxeles y de alto 70.
		 */
		graphics.fillRect(350, 70, 50, 70);
		graphics.setColor(Color.orange);
		/**
		 * Dibujar un triángulo utilizando el método fillPolygon indicando las
		 * posiciones en el eje ‘x’ de los tres vértices, las posiciones de los tres
		 * vértices en el eje ‘y’.
		 */
		int[] vx1 = { 600, 650, 550 };
		int[] vy1 = { 70, 120, 120 };
		graphics.fillPolygon(vx1, vy1, 3);
	}

}
