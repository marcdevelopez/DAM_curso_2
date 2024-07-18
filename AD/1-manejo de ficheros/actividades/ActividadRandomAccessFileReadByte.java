package actividad_randomaccessfile_readbyte;

import java.io.File;

public class ActividadRandomAccessFileReadByte {

	public static void main(String[] args) {
		/*
		 * Actividad 2, curso DAM 2, Tema 1 de acceso a datos: Modo acceso aleatorio
		 * RancomAccessFile
		 * 
		 * El fichero creado previamente es: fichero.txt, creado en la raíz de este
		 * proyecto. Contendrá entre 5 y 10 líneas, de modo que vamos a modificarlo
		 */
		File fichero = new File("fichero.txt");
		FileWriter escritorFile;
		RandomAccessFile accesoFile;
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			escritorFile = new FileWriter(fichero);
			escritorFile.write("Despensa:\n-Yogur\n-Pera\n-Coco\n-Pollo\n-Leche");
			escritorFile.close();
			/*
			 * inicializamos acceso aleatorio al fichero en modo lectura "r"
			 */
			accesoFile = new RandomAccessFile(fichero, "r");
			/*
			 * Situamos el puntero en el byte número 5, como se nos pide en la actividad,
			 * teniendo en cuenta que el primero es el byte número 0 (Despe -> n <-):
			 */
			accesoFile.seek(5);
			// Guardamos el valor del byte en un int, y lo mostramos por pantalla...
			int byte5 = accesoFile.read();
			System.out.println("El byte número 5 del fichero de 6 líneas es: " 
			                 + ((char) byte5) + ".");
			accesoFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
