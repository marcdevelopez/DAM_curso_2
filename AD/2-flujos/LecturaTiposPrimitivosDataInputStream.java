package lecturatiposprimitivosdatainputstream;
/*
Útil para  lectura de tipos primitivos. 
Se suele usar la clase DataInputStream para leer ficheros que previamente han 
sido escritos con DataOutputStream. 
Hereda métodos de InputStream.
Si queremos leer byte a byte con el método read(), evidentemente lo tendremos 
también disponible, así como la lectura con un array de bytes. 
Atencion: cuando leemos tipos de datos primitivos no hay forma de distinguir la 
lectura de un número “-1” a la lectura de fin de flujo que es también -1, 
por lo tanto, es muy importante en este tipo de lectura saber qué tipo de datos 
vamos a leer y qué orden llevan. 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LecturaTiposPrimitivosDataInputStream {
    public static void main(String[] args) {
        try {
            // vamos a introducir datos en el fichero
            /*
            para leer de un fichero por medio de la clase DataInputStream, 
            antes hemos tenido que realizar la escritura ordenada del fichero y 
            debemos conocer el tipo de datos y la cantidad de ellos que ha sido 
            insertada. Usamos DataOutputStream. 
            El objeto es instanciado en su constructor con un FileOutputStream 
            con la ruta del fichero que vamos a escribir.
             */
            DataOutputStream salida = new DataOutputStream(
                    new FileOutputStream("datos.bin"));
            /*
            Escribimos en el fichero distintos tipos primitivos de Java usando 
            diferentes métodos: 
            • writeInt() : solo aceptara entero como parámetro. 
            • writeFloat() : solo aceptara float como parámetro.
            • writeDouble() : solo aceptara double como parámetro.
             */
            salida.writeInt(10);
            salida.writeFloat(10.10F);
            salida.writeDouble(10.1234);
            // cerramos nuestro flujo y liberamos recursos.
            salida.close();
            // ahora vamos a crear el flujo de lectura de datos primitivos
            DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream("datos.bin"));
            int entero = dataInputStream.readInt();
            float numFloat = dataInputStream.readFloat();
            double numDouble = dataInputStream.readDouble();
            dataInputStream.close();
            System.out.println("El número entero es: " + entero);
            System.out.println("El número float es: " + numFloat);
            System.out.println("El número double es: " + numDouble);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaTiposPrimitivosDataInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaTiposPrimitivosDataInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
