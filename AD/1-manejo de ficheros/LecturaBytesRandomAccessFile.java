package lectura_bytes_randomaccessfile;

import java.io.File;

public class LecturaBytesRandomAccessFile {

	public static void main(String[] args) {
		/*
		 * LECTURA DE UN BYTE
		 * 
		 * Creamos un fichero con los datos a leer
		 */
		
		File pruebaFichero = new File("salida.txt");
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
		try {
			/*
			 * RandomAccessFile posee dos constructores: En ambos constructores el segundo
			 * parámetro es el mismo: el modo de acceso.
			 * Sin embargo, para el primer parámetro tenemos la versión del constructor en
			 * la que podemos introducir el objeto File directamente o, como en este caso,
			 * introducir la ruta del fichero directamente como String.
			 */
			RandomAccessFile file = new RandomAccessFile("salida.txt", "r");
			/*
			 * Con el método seek() básicamente nos posicionamos en el punto que indiquemos
			 * del fichero. Acepta como parámetro un objeto de tipo “long”.
			 */
			long posicionPuntero = 0;
			file.seek(posicionPuntero);
			/*
			 * Si usamos el método getFilePointer(), obtendremos como respuesta un tipo
			 * long. Este número es exactamente la posición del puntero en Bytes
			 */
			long filePointer = file.getFilePointer();
			/*
			 * Con el método read(), podremos leer un byte directamente de nuestro fichero.
			 * Devolverá dicho byte a partir de la posición actual del puntero.
			 */
			int unByte = file.read();
			System.out.println(
					"\nEl byte leído en el puntero " + String.valueOf(filePointer) + " es: " + (char) unByte);

			/*
			 * LECTURA DE UN ARRAY DE BYTES (CONJUNTO DE BYTES)
			 * 
			 * Si en lugar de leer un byte, lo que nos interesa realmente es leer una
			 * cantidad determinada de bytes, podremos realizar esta implementación:
			 * 
			 * En primer lugar, crearemos un array de bytes, en concreto la longitud del
			 * File pruebaFichero en bytes.
			 */
			byte[] arrayBytes = new byte[(int) pruebaFichero.length()];
			/*
			 * Definimos la posición del puntero y el tamaño de bytes que queremos extraer
			 * de nuestro fichero. Lo pondremos a 0, ya que el método seek() ya situa el
			 * puntero donde empezar queremos que comience a leer...
			 */
			int inicioPunteroMetodoRead = 0;
			// definimos la cantidad de bytes a leer; queremos leer la palabra "fichero".
			int size = 7;
			/*
			 * Por último, usamos el método read(), que en este caso, acepta los siguientes
			 * parámetros:
			 * 
			 * • Primer parámetro: el array de bytes dónde se va a almacenar la información,
			 * • Segundo parámetro: el inicio o posición en la que comenzaremos a leer. 
			 * • Último parámetro: la cantidad máxima de bytes a extraer.
			 * 
			 * Modificamos el puntero de lectura del RandomAccessFile para comenzar a leer
			 * el primer byte (carácter) donde elijamos:
			 */
			long inicioPunteroLecturaSeek = 11;
			file.seek(inicioPunteroLecturaSeek);
			int bytesLeidos = file.read(arrayBytes, inicioPunteroMetodoRead, size);
			// A continuación recorremos el array y lo imprimimos
			System.out.println("\n" + size + " bytes leídos, desde el puntero " + inicioPunteroLecturaSeek + ":");
			for (int n : arrayBytes) {
				System.out.print((char) n);
			}

			// cerramos el flujo del objeto RandomAccessFile para no desperdiciar recursos
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

