package retrocesodereaderpushbackreader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
public class RetrocesoDeReaderPushbackReader {
    public static void main(String[] args) {
        // Creamos un fichero para luego leerlo con PushbackReader
        File fichero = new File("fichero");
        try {
            fichero.createNewFile();
            Writer escritor = new FileWriter(fichero);
            escritor.write("Este es el contenido del fichero");
        } catch (IOException ex) {
            Logger.getLogger(RetrocesoDeReaderPushbackReader.class.
                    getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                Logger.getLogger(RetrocesoDeReaderPushbackReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            // instanciamos un objeto PushBackReader
            PushbackReader pushBackReader = new PushbackReader(
            /*
             para ello necesitamos a su vez instanciar un objeto FileReader
             indicando la ruta del fichero a tratar
             la primera letra del fichero es “E”.    
            */       
                    new FileReader(fichero)); 
            /*
            usamos el método read() y justo 
            después mostramos por pantalla el byte leído haciendo casting de 
            “char”. 
            mostramos por pantalla la letra “E”. 
            */
            int data = pushBackReader.read();
            System.out.println((char) data);
            /*
            Justo en la siguiente línea nos aparece un método nuevo unread(data). 
            Es el método clave de esta clase definida. Este método devuelve al 
            stream de datos el byte que hemos leído con anterioridad, de tal 
            forma que si volvemos a hacer un read() y mostramos por pantalla, 
            obtendremos el mismo byte que antes. En este caso la letra “D”. 
            */
            pushBackReader.unread(data);
            data=pushBackReader.read();
            System.out.println((char)data);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RetrocesoDeReaderPushbackReader.class.
                    getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RetrocesoDeReaderPushbackReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
