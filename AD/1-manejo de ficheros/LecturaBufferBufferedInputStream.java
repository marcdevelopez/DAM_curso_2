package lectura_buffer_bufferedinputstream;

import java.io.BufferedInputStream;

public class LecturaBufferBufferedInputStream {

	public static void main(String[] args) {

		/*
		 * Creamos el fichero a leer
		 */

		File archivoALeer = new File("archivo.txt");
		try {
			archivoALeer.createNewFile();
			FileWriter escritor = new FileWriter(archivoALeer);
			escritor.write("Este es el contenido del archivo...");
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedInputStream flujoEntradaBuffer = null;
		/*
		 * definición del tamaño del buffer que se usará posteriormente
		 */
		int bufferSize = 4 * 1024;
		/*
		 * Se instancia nuestro objeto, el cual, necesita dos parámetros: El primero es
		 * un objeto de tipo FileInputStream con la ruta de nuestro fichero, y el
		 * segundo parámetro es el tamaño que deseamos darle a nuestro buffer, definido
		 * en la línea amterior.
		 */
		try {
			flujoEntradaBuffer = new BufferedInputStream(new FileInputStream(archivoALeer), bufferSize);
			int datos;
			/*
			 * En el bucle “while” realizaremos la lectura de un bloque de datos siempre y
			 * cuando nuestra variable “info” no contenga -1, lo cual, si es así, indicará
			 * que el contenido del fichero ha finalizado y que nuestro buffer no tendrá
			 * información que proporcionar. Es dentro del bucle donde podremos manipular la
			 * información y realizar las operaciones que deseemos.
			 */
			while ((datos = flujoEntradaBuffer.read()) != -1) {
				System.out.print((char) datos);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				/*
				 * Cierre y liberación de recursos de nuestro buffer.
				 */
				flujoEntradaBuffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
