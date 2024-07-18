package metodos_clase_file;

import java.io.File;

public class MetodosClaseFile {

	public static void main(String[] args) throws IOException {

		File objetoFile = new File("/home/marc/mi-archivo");
		/*
		 * Método createNewFile(): throws IOException
		 */
		System.out.println(objetoFile.createNewFile());
		/*
		 * Método getAbsolutePath()
		 */
		System.out.println(objetoFile.getAbsolutePath());
		/*
		 * Método isDirectory()
		 */
		System.out.println(objetoFile.isDirectory());
		/*
		 * Método mkdir()
		 */
		File otroObjetoFile = new File("mi-directorio");
		System.out.println(otroObjetoFile.mkdir());
		/*
		 * Método renameTo(File dest)
		 */
		File objetoFileRenombrado = new File("/home/marc/mi-archivo-renombrado");
		System.out.println(objetoFile.renameTo(objetoFileRenombrado));
		/*
		 * Método exists()
		 */
		System.out.println(objetoFile.exists());
	}

}
