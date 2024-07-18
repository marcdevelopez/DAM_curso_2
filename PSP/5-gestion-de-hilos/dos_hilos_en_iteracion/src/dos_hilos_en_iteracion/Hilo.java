package dos_hilos_en_iteracion;

public class Hilo extends Thread {
	private String nombre;
	// dormir será el tiempo que se ejecutará sleep (milisegundos)
	private int dormir;

	public Hilo(String nombre, int dormir) {
		this.nombre = nombre;
		this.dormir = dormir;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Soy el hilo " + nombre + " en la iteración " + i);
			try {
				sleep(dormir);
			} catch (InterruptedException ex) {
				System.out.println("Error: " + ex.toString());
			}
		}
	}
}
