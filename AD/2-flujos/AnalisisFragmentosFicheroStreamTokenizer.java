package analisisfragmentosficherostreamtokenizer;
/*
 La clase StreamTokenizer tiene la capacidad de analizar el fichero por «trozos»
o «fragmentos». Evaluaremos dichos fragmentos y comprobaremos si son palabras 
o números. Reconoce identificadores: números, comillas, espacios, etc., 
lo cual nos puede ser de gran utilidad al analizar ficheros dependiendo de si 
su tipología sea de números o de caracteres.
 */
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AnalisisFragmentosFicheroStreamTokenizer {
    public static void main(String[] args) {
        /*
        instaciamos el objeto StreamTokenizer usando el constructor por medio 
        del cual le pasamos un StringReader.
         */
        StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(""
                + "Este es el texto de un StreamTokenizer"));
        /*
        algunos de sus métodos estáticos nos dan información de la tipología de 
        los distintos Tokens:
        - TT_EOF: indica el final del fichero (End Of File)
        - TT_EOL: indica el final de la línea (End Of Line)
        - TT_WORD: indica que el token es de tipo palabra, conjunto de letras. 
        - TT_NUMBER: indica que el token evaluado es un número o una asociación 
        de ellos. 
         */
        try {
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                // si el token es de tipo palabra, mostraremos por pantalla dicha palabra.
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(streamTokenizer.sval);
                    // si es de tipo número, mostraremos por pantalla el número.
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(streamTokenizer.nval);
                    // si es de tipo final de línea se imprimirá retorno de carro.
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AnalisisFragmentosFicheroStreamTokenizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
