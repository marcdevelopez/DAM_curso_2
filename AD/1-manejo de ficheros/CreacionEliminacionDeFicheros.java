package creacion_eliminacion_ficheros;

import java.io.File;

public class CreacionEliminacionDeFicheros {

	public static void main(String[] args) {
		// creamos un directorio en la raiz del proyecto
		// primero creamos la ruta del directorio
		File directorio = new File("directorio");
		// y lo creamos con mkdir
		directorio.mkdir();
		// creamos la ruta del archivo con File
		File fichero = new File(directorio + "/archivo.txt");
		try {
			// creamos el fichero, vacío
			fichero.createNewFile();
			// ahora eliminamos el fichero creado
			// quitar comentario para eliminar el fichero creado...
			
			// fichero.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}