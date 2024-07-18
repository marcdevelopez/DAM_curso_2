package lectura_stream_bytes_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class LecturaStreamBytesFileInputStream {

	public static void main(String[] args) {
		// creamos un fichero prueba.txt
		File pruebaFichero = new File("prueba.txt");
		try {
			pruebaFichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter escritorFichero = new FileWriter(pruebaFichero);
			escritorFichero.write("Este es un fichero de prueba.");
			// Si no cerramos el stream no se escribe en el fichero!
			escritorFichero.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// creamos objeto FileInputStream para lectura de bytes
		try {
			InputStream entrada = new FileInputStream(pruebaFichero);
			// accedemos a los bytes
			int contenido;
			while ((contenido = entrada.read()) != -1) {
				// imprimo cada char del fichero
				System.out.print((char)contenido);
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir para lectura el fichero prueba.txt");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el fichero prueba.txt");
			e.printStackTrace();
		}

	}

}
