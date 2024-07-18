package contadorlineaslinenumberreader;
/*
LineNumberReader es hija de BufferedReader. 
Almacena y cuenta el número de líneas leídas de caracteres. 
Está orientada a trabajar y analizar líneas completas. 
Empieza leyendo por la primera línea con el contador a 0 y cada vez que 
encuentra un retorno de carro incrementa su valor en +1.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ContadorLineasLineNumberReader {
    public static void main(String[] args) {
        try {
            /*
            Se instancia LineNumberReader con un nuevo objeto FileReader, el cual 
            es instanciado con un fichero que se ha agregado al proyecto. 
             */
            LineNumberReader lineNumberReader
                    = new LineNumberReader(new FileReader("prueba.txt"
                    ));
            // quedará almacenado el contenido de la primera línea con readLine()
            String line = lineNumberReader.readLine();
            /*
            mientras se tengan líneas que recorrer, se irá mostrando por 
            pantalla tanto el número de la línea en la que se está posicionado, 
            como su contenido, a través de: getLineNumber() y 
            System.out.println(line). De esta forma iremos mostrando el 
            contenido del fichero completo línea tras línea.
             */
            while (line != null) {
                System.out.println("Línea número "
                        + lineNumberReader.getLineNumber()
                        + ": "
                        + line);
                line = lineNumberReader.readLine();
            }
            lineNumberReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorLineasLineNumberReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContadorLineasLineNumberReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
