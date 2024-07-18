package priopridad_hilos_setpriority;

public class EjemploPrioridadHilos {

	public static void main(String[] args) {
		Hilo hilo1 = new Hilo("Hilo 1", 1000);
		Hilo hilo2 = new Hilo("Hilo 2", 1000);
		Hilo hilo3 = new Hilo("Hilo 3", 1000);

		/*
		 *  Daremos prioridades a los hilos, aunque dependerá del
		 *  planificador del sistema el orden final. Es prioridad, 
		 *  no planificación, recordemos. Para planificar debemos usar join(/)
		 *  y así esperará el hilo hasta terminar su ejecución para ejecutar
		 *  el siguiente hilo deseadop.
		 */
		hilo1.setPriority(Thread.MAX_PRIORITY);
		hilo2.setPriority(Thread.NORM_PRIORITY);
		hilo3.setPriority(Thread.MIN_PRIORITY);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
