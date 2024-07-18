package com.marcdevelopez.creacionprocesoslinux;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreacionProcesosLinux {

    static ProcessBuilder pb;

    public static void main(String[] args) {
        pb = new ProcessBuilder().command("touch", "/home/marc/"
                + "Escritorio/prueba.txt");
        try {
            /*
            Este método ProcessBuilder.start() iniciará un proceso nuevo. Este 
            va a ejecutar el comando y los argumentos que le indiquemos en el 
            método command() arriba implementado, y se va a ejecutar en el 
            directorio de trabajo que le indiquemos con el método directory(). 
            Además, podrá utilizar las variables de entorno del sistema 
            operativo que estén definidas en environment().
             */
            Process process = pb.start();
            int retorno = process.waitFor();
            System.out.println("El proceso touch devuelve: " + retorno);

            /* segundo proceso, con Runtime.exec, cambiamos nombre al archivo 
            recién creado antes
             */
            Process procesoMv = null;
            // este método .exec es el de 1 parámetro tipo String
            procesoMv = Runtime.getRuntime().exec("mv /home/marc/"
                    + "Escritorio/prueba.txt /home/marc/Escritorio/prueba2.txt");
            int waitFor = procesoMv.waitFor();
            System.out.println("El proceso mv devuelve: " + waitFor);

            /* Ahora ejecutaremos otro método exec() de 3 parámetros, y usaremos 
            el tercero para indicar el directorio de ejecución: 
            Runtime.exec(String[] cmdarray, String[] envp, File dir) 
            Este método ejecutará el comando que le especifiquemos con sus 
            correspondientes argumentos en el parámetro cmdarray, en un proceso 
            hijo que será totalmente independiente. Además, se ejecutará el 
            entorno de trabajo indicado en el parámetro envp, y en el directorio 
            de trabajo especificado en el parámetro dir.
             */
            Process procesoMkdir = null;
            // creamos el argumento cmd para usar mkdir y crar un nuevo directorio
            String[] cmd = {"mkdir", "nuevo_directorio"};
            /*
            cada unos de los índices de este array cmd será un comando o 
            argumento, como si cortátramos en trozos el comando de la consola 
            y lo crearemos en el directorio de trabajo /Escritorio.
            */
            File dir = new File("/home/marc/Escritorio/");
            procesoMkdir = Runtime.getRuntime().exec(cmd, null, dir);
            int waitForMkdir = procesoMv.waitFor();
            System.out.println("El proceso mkdir devuelve: " + waitForMkdir);
        } catch (IOException ex) {
            Logger.getLogger(CreacionProcesosLinux.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreacionProcesosLinux.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
}
