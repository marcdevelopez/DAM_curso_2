package dos_hilos_en_iteracion;

public class EjemploHilos {

	public static void main(String[] args) {
		// Creamos los hilos
		Hilo hilo1 = new Hilo("Hilo 1", 1000);
		Hilo hilo2 = new Hilo("Hilo 2", 1000);

		// Lanzamos los hilos
		hilo1.start();
		hilo2.start();

	}

}
