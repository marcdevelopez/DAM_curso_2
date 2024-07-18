package parserxml_dom;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author marc
 */
public class ParserXML_DOM {
    static DocumentBuilder builder;

    public static void main(String[] args) {
        
        // Instanciamos la clase DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        /*
        Establecemos el atributo de validación como “true” para 
        asegurarnos que el fichero que se cargue esté bien validado.
        */
        // da error la siguiente línea
        // factory.setValidating(true);
        /*
        Se hace un set también, al atributo de “ignorar los elementos que 
        contengan espacios en blanco”, a “true”. 
        */
        factory.setIgnoringElementContentWhitespace(true);
        try {
            /*
            Creamos un objeto DocumentBuilder por medio de la factoría creada
            previamente.
            */
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ParserXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Instanciamos un nuevo fichero indicando la ruta del fichero a analizar.
        File file = new File("ejemplo.xml");
        try {
            /*
            Cargamos el fichero completo con el método builder.parse(file), y se
            asigna a un objeto de tipo Document. De esta forma quedará almacenado, y
            podremos realizar diferentes acciones con dicho objeto en las líneas
            siguientes.
            */
            Document doc = builder.parse(file);
            // Normalizamos la estructura xml, este método funciona correctamente
           
            // doc.getDocumentElement().normalize();
        } catch (SAXException ex) {
            Logger.getLogger(ParserXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParserXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
