package com.mardevelopez.creacion_proceso;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class Creacion_Proceso {

    public static void main(String[] args) {
        try {
            /*
            vamos a ejecutar un proceso con Chrome
            y para ello guardamos en un String la ruta de acceso al ejecutable.
            Estoy en un sistema Linux (Debian)
             */
            final String RUTA_PROCESO = "/usr/lib/firefox-esr/firefox-esr";
            // Creamos el proceso
            ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
            // con el método start() de Process lanzamos el proceso
            Process process = pb.start();
            // el estado del proceso se puede ver con waitFor()
            int retorno = process.waitFor();
            System.out.println("El proceso del programa " + RUTA_PROCESO
                    + " devuelve: " + retorno);
          
            // Obtener el tiempo desde el inicio del sistema 
          
           
        } catch (IOException ex) {
            Logger.getLogger(Creacion_Proceso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Creacion_Proceso.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("¡El proceso hijo finalizó de forma incorrrecta!");
        }

    }
}
