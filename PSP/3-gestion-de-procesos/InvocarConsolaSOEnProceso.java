package com.marcdevelopez.invocarconsolasoenproceso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InvocarConsolaSOEnProceso {

    public static void main(String[] args) {
        // Se crea el proceso hijo:
        // para windows sería "CMD"
        ProcessBuilder builder_echo = new ProcessBuilder("/bin/bash");
        Process proceso_echo;
        try {
            proceso_echo = builder_echo.start();
            final Scanner scanner = new Scanner(
                    proceso_echo.getInputStream());
            new Thread() {
                @Override
                public void run() {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                }
            }.start();

            // Obtengo la salida del proceso hijo:
            PrintWriter salida
                    = new PrintWriter(proceso_echo.getOutputStream());
            /**
             * Usamos el objeto PrintWriter salida, que escribe en el flujo de
             * salida del proceso:
             */

            for (int i = 0; i < 10; i++) {
                salida.println("echo Iteración " + i);
                salida.flush();
            }

            // Cerramos los flujos
            salida.close();
        } catch (IOException ex) {
            System.err.println("Excepción de E/S: " + ex.toString());
        }

    }
}
