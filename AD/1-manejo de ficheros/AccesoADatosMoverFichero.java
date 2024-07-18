package acceso_a_datos_mover_fichero;

import java.io.*;

public class AccesoADatosMoverFichero {

	public static void main(String[] args) {
		String rutaFichero = "";

		try {

			// creamos el path de archivo prueba1.txt
			File fileOrigen = new File("prueba1.txt");
			fileOrigen.createNewFile(); // escribimos en el fichero un texto
			Writer escritorFicheros1 = new FileWriter("prueba1.txt");
			escritorFicheros1.write("Este es el archivo prueba1");
			escritorFicheros1.close();
			// creamos un directorio que contendrá prueba2.txt
			File directorio = new File("directorio");
			directorio.mkdir();
			// creamos el archivo destino dentro del directorio creado
			File fileDestino = new File(directorio + "/prueba2.txt");
			fileDestino.createNewFile();
			// escribimos en el fichero un texto
			Writer escritorFicheros2 = new FileWriter(directorio + "/prueba2.txt");
			escritorFicheros2.write("Este es el archivo prueba2 dentro del directorio");
			escritorFicheros2.close();

			// desmarcar para ver resultado de movimiento:

			// if (fileOrigen.renameTo(fileDestino)) {
			// System.out.println("El fichero se movió correctamente!");
			// } else {
			// System.out.println("El fichero no pudo moverse");
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}