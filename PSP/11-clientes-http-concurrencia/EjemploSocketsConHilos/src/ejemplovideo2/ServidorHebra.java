/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

/**
 * Esta clase representa una hebra que se ejecutará en el servidor y que dará
 * servicio a un cliente independiente
 *
 * @author Francisco Jesús Delgado Almirón
 */
public class ServidorHebra extends Thread {

    private DataInputStream entrada;
    private DataOutputStream salida;
    private Socket socketcliente;

    public ServidorHebra(
    		Socket socketcliente, 
    		DataInputStream entrada, 
    		DataOutputStream salida) {
        this.socketcliente = socketcliente;
        this.entrada = entrada;
        this.salida = salida;
    }

    @Override
    public void run() {
        boolean salir = true;
        String mensajerecibido;
        Random generador = new Random();

        while (salir) {
            try {
                // Pregunto al cliente qué quiero hacer
                salida.writeUTF("SERVIDOR: ¿Qué quieres hacer?\n\t1.- Generar número aleatorio.\n\t2.- Salir.\n\t(Esperando petición del cliente...)");

                // Recibo la respuesta del cliente 
                mensajerecibido = entrada.readUTF();

                // Según el mensaje recibido...
                switch (mensajerecibido) {
                    case "1":
                        int aleatorio = generador.nextInt(500);
                        salida.writeUTF(""
                        		+ "SERVIDOR: El número aleatorio generado es "
                        		+ aleatorio);
                        break;
                    case "2":
                        System.out.println(""
                        		+ "SERVIDOR: El cliente " 
                        		+ this.socketcliente + " envía salir...");
                        System.out.println(""
                        		+ "SERVIDOR: Cerrando la conexión...");
                        this.socketcliente.close();
                        System.out.println(""
                        		+ "SERVIDOR: Conexión cerrada.");
                        salir = false;
                        break;
                }
            } catch (IOException e) {
                System.out.println("ERROR SERVIDOR 2 -> " + e.toString());
            }
        }

        // Cierro los flujos
        try {
            this.entrada.close();
            this.salida.close();
        } catch (IOException e) {
            System.out.println("ERROR SERVIDOR 3 -> " + e.toString());
        }
    }
}
