import java.io.FileNotFoundException;

public class LecturaStreamDeCaracteres {

	public static void main(String[] args) {
		try {
			FileReader lector = new FileReader("prueba.txt");
			int data = -2;
			while (data != -1) {
				data = lector.read();
				System.out.print((char)data);
			}
			lector.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}