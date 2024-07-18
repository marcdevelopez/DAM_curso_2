package escrituralecturaarraycaractereschararrayreader.writer;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EscrituraLecturaArrayCaracteresCharArrayReaderWriter {
    public static void main(String[] args) {
        CharArrayWriter writer = new CharArrayWriter();
        CharArrayReader reader;
        /*
        en data asignamos la información que leeremos
         */
        int data = 0;
        try {
            /*
            Escribimos en el escritor de array de caracteres
             */
            writer.write("Esto es escrito en un objeto CharArrayWriter");
            /*
            Usamos CharArrayReader a partir del mismo CharArrayWriter writer
            pasándolo como parámetro, convertido a array de caracteres
             */
            reader = new CharArrayReader(writer.toCharArray());
            /*
            leemos el primer byte, para luego seguir leyendo mientras 
            no lleguemos al final del array de caracteres
             */
            data = reader.read();
            while (data != -1) {
                // BLOQUE
                System.out.println((char) data);
                // incrementamos el caracter leido para la próxima iteración
                data = reader.read();
            }
            /*
            Como no usaremos más el flujo de lectura de caracteres lo cerramos
             */
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(EscrituraLecturaArrayCaracteresCharArrayReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Si no lo usamos más lo cerramos
        writer.close();
    }
}
