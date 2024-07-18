package creacion_fichero_bytes_fileoutputstream;

import java.io.FileNotFoundException;

public class CreacionFicheroBytesFileOutputStream {

	public static void main(String[] args) {
		String path = "salida.txt";
		String cadena = "Esto es una prueba de escritura";
		// pasamos a array de bytes la cadena de texto:
		byte[] arrayBytes = cadena.getBytes();
		
		try {
			// creamos el fichero en el path:
			FileOutputStream output = new FileOutputStream(path);
			// escribimos en el fichero:
			output.write(arrayBytes);
			output.close();
			System.out.println("Fichero escrito correctamente");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}