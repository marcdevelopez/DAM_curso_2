package interfaz_grafica_desde_archivo_xml;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class interfazXML extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazXML frame = new interfazXML();
					frame.setSize(800, 600);
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
	public interfazXML() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane = new JPanel();
		GridLayout gl = new GridLayout(9, 1, 0, 5);
		contentPane.setLayout(gl);

		// creamos el objeto File de nuestro XML, desde donde obtendremos datos
		File archivo = new File("informacion.xml");

		// creamos nuestro DocumentBuilderFactory para poder analizar el XML
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);

			// obtenemos una lista con nlos nodos "pagina" del XML
			document.getDocumentElement().normalize();
			NodeList listaPlataformasControlVersiones = document.getElementsByTagName("pagina");

			// y recorremos la lista de nodos para crear JLabels y botones con datos de XML
			for (int i = 0; i < listaPlataformasControlVersiones.getLength(); i++) {
				Node nodo = listaPlataformasControlVersiones.item(i);

				// y ahora recorremos cada nodo de esta lista para obtener elementos por
				// nombre...
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					// creamos objetos Element para obtener nombre, descripción y url, que son
					// elementos de cada nodo "pagina"
					Element element = (Element) nodo;
					// y creamos nuestras vistas de objetos de la interfaz gráfica:
					JButton button = new JButton(element.getElementsByTagName("nombre").item(0).getTextContent());
					contentPane.add(button);

					JLabel descripcion = new JLabel(element.getElementsByTagName("descripcion").item(0).getTextContent());
					contentPane.add(descripcion);
					JLabel url = new JLabel(element.getElementsByTagName("url").item(0).getTextContent());
					contentPane.add(url);
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// por último, añadimos el panel contentpane con nuestros componentes incluidos al contenedor por defecto (getContentPane)
		Container container = getContentPane();
		container.add(contentPane, BorderLayout.CENTER);

	}

}
