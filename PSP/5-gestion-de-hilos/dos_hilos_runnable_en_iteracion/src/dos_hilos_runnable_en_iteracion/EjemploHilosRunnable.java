package dos_hilos_runnable_en_iteracion;

public class EjemploHilosRunnable {

	public static void main(String[] args) {
		// Creamos los hilos
		HiloRunnable hilo1 = new HiloRunnable("Hilo 1", 1000);
		HiloRunnable hilo2 = new HiloRunnable("Hilo 2", 1000);

		Thread hebra1 = new Thread(hilo1);
		Thread hebra2 = new Thread(hilo2);

		// Lanzamos los hilos
		hebra1.start();
		hebra2.start();

	}

}
