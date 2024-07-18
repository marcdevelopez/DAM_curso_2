package dos_hilos_runnable_en_iteracion;

import static java.lang.Thread.sleep;

public class HiloRunnable implements Runnable {

	private String nombre;
	private int dormir;

	public HiloRunnable(String nombre, int dormir) {
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
