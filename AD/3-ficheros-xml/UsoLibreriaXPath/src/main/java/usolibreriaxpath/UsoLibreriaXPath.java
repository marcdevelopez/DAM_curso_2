package usolibreriaxpath;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author marc
 */
public class UsoLibreriaXPath {
    

    public static void main(String[] args) {
        File file = new File("ejemplo.xml");
        DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dBFactory.newDocumentBuilder();
            /*
            Creamos un Document con el método parse (analiza) del DocumentBuilder
            con el que podremos analizar el documento .xml
             */
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();

            String expresionXPath = "/pizzas/pizza";
            // creamos una lista de nodos para la clase /pizza
            NodeList nodeList = (NodeList) xPath.compile(
                    expresionXPath).evaluate(
                            doc, XPathConstants.NODESET);
            // recorremos los nodos para trabajar con el xml:
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                System.out.println("\nCurrent Element: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    System.out.println("Nombre de la pizza: "
                            + element.getAttribute("nombre")
                            + "\nPrecio: " + element.getAttribute("precio")
                    /*
                      podemos seguir iterando en nodos agregando nueva
                      expresion XPath...
                     */
                    );

                }

            }
            /* multicatch para en este caso ahorra líneas de código.
            Se aconseja tratar cada try-catch por separado...
             */
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            Logger.getLogger(UsoLibreriaXPath.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
}
