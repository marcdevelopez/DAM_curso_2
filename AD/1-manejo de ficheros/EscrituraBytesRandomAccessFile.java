package escritura_bytes_randomaccessfile;

import java.io.File;

public class EscrituraBytesRandomAccessFile {

	public static void main(String[] args) {
		// creamos primero un fichero con los datos a leer
		File pruebaFichero = new File("entrada.txt");
		try {
			pruebaFichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter escritorFichero = new FileWriter(pruebaFichero);
			escritorFichero.write("0123456789 (posiciones del puntero)...");
			// Si no cerramos el stream no se escribe en el fichero!
			escritorFichero.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			/*
			 * RandomAccessFile posee dos constructores, en ambos constructores el segundo
			 * parámetro es el mismo: el modo de acceso. Sin embargo, para el primer
			 * parámetro tenemos la versión del constructor en la que podemos introducir el
			 * objeto File directamente o, como en el caso de la imagen superior, introducir
			 * la ruta del fichero directamente como String.
			 */
			RandomAccessFile file = new RandomAccessFile("entrada.txt", "rw");
			/*
			 * Con el método seek() básicamente nos posicionamos en el punto que indiquemos
			 * del fichero. Acepta como parámetro un objeto de tipo “long”.
			 */
			int posicionPuntero = 8;
			file.seek(posicionPuntero);
			/*
			 * Usaremos el método write() para escribir un byte. Dicho byte se escribirá en
			 * la posición actual donde se encuentre el puntero. Acepta como parámetro un
			 * entero (el byte a escribir). insertaremos la letra «D» en el fichero que
			 * corresponde a 68 en la codificación de caracteres ASCII.
			 * 
			 */
			file.write(68);
			/*
			 * ahora sacaremos por pantalla el texto: Crearemos un objeto RandomAccessFile
			 * para lecttura ("r")
			 */
			RandomAccessFile fileLectura = new RandomAccessFile("entrada.txt", "r");
			// Creamos un puntero y lo ponemos a 0
			long posicionPunteroLectura = 0;
			// Recorremos el RandomAccessFile imprimiendo cada byte
			while (posicionPunteroLectura <= file.length()) {
				fileLectura.seek(posicionPunteroLectura);
				System.out.print((char) fileLectura.read());
				posicionPunteroLectura++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
