package streamscontuberias;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
public class StreamsConTuberias {
    public static void main(String[] args) throws IOException {
        /*
        Instanciamos los objetos para entrada y salida de flujos
        El primero de ellos hace referencia a un objeto de salida, 
        el cual, podría ser por ejemplo una escritura de un fichero, 
        pero en este caso simplemente simularemos la escritura de la frase: 
        “Hola chavales!”.
         */
        final PipedOutputStream salida = new PipedOutputStream();
        /*
        instanciamos la tubería de entrada pasándole por parámetro la salida 
        creada previamente. De esta forma la “tubería” quedará conectada 
        y tendremos acceso al fichero de salida que está realizando la escritura. 
         */
        final PipedInputStream entrada = new PipedInputStream(salida);
        String textoSalida = "Hola chavales!";
        /*
        Creamos 2 hilos: 
            hilo1 para escribir
            hilo2 para leer
        En el hilo1 escribimos los bytes referenciados 
         */
        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    /*
                        Dentro del hilo escribimos los bytes en la salida
                     */
                    salida.write(textoSalida.getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(StreamsConTuberias.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        /*
        En el hilo2 leremos "al mismo tiempo" en la misma tubería
        el objeto PipedInputStream nombrado entrada
         */
        Thread hilo2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    /*
                    Como en entrada tenemos como argumento salida, 
                    podremos leer lo escrito en salida:
                    leemos directamente del PipedInputStream cuya variable 
                    definimos “entrada”, referenciada directamente a la salida, 
                    por lo cual tenemos acceso a ella. 
                    Básicamente lo que hacemos es leer directamente Byte a Byte 
                    del fichero de salida al mismo tiempo que se está escribiendo. 
                     */
                    int unByte = entrada.read();
                    while (unByte != -1) {
                        System.out.print((char) unByte);
                        unByte = entrada.read();
                    }
                } catch (IOException e) {
                }
            }
        });
        /*
        Sólo nos queda lanzar los dos hilos
        ejecutamos ambos hilos, teniendo en cuenta que “hilo2” va a tener acceso 
        de lectura a “hilo1” y, por lo tanto, va a mostrar por pantalla justo 
        lo que “hilo1” está escribiendo.
         */
        hilo1.start();
        hilo2.start();
    }
}
