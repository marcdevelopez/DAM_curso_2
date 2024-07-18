package planificacion_hlos_con_join;

public class EjemploPlanificacionHilosConJoin {

	public static void main(String[] args) {

		Hilo hilo1 = new Hilo("Hilo 1", 1000);
		Hilo hilo2 = new Hilo("Hilo 2", 1000);
		Hilo hilo3 = new Hilo("Hilo 3", 1000);

		try {
			// con join() conseguimos que se espere el hilo hasta terminar su bloqueo
			hilo1.start(); // iniciamos el hilo: estado: listo o runnable
			hilo1.join(); // hacemos que se espere
			hilo2.start(); // start llama a run(), y el hilo se ejecuta
			hilo2.join();
			hilo3.start();
			hilo3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
