import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;
public class EscrituraStreamDeCaracteres {

	public static void main(String[] args) {
		
		try {
			Writer escritorFicheros = new FileWriter("prueba.txt");
			escritorFicheros.write("Este es el contenido del fichero prueba.txt");
			escritorFicheros.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
