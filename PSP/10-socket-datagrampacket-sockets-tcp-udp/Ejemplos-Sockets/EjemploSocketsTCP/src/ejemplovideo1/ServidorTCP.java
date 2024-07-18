/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase representa un servidor TCP
 * @author Francisco Jesús Delgado Almirón
 */
public class ServidorTCP {

    private static final int PUERTO = 6000;
    private static final int MAX_CLIENTES = 3;

    public ServidorTCP() {
        try {
            // Creo el socket servidor que escucha
            // en el puerto 6000
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            // Escucho a un cierto número de clientes
            for (int numCli = 0; numCli < MAX_CLIENTES; numCli++) {
                // Escucho a un cliente
                Socket skCliente = skServidor.accept();
                // Cuando escucha un cliente da un aviso
                System.out.println("Sirvo al cliente " + numCli);
                // Obtiene el flujo de salida del cliente
                // (Mensajes que envía al cliente)
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujo = new DataOutputStream(aux);
                // Manda un mensaje al cliente
                flujo.writeUTF("Hola cliente " + numCli);
                // Cierro el socket servidor
                skCliente.close();
            }
            System.out.println("Demasiados clientes por hoy.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Método main del servidor
    public static void main(String[] args) {
        new ServidorTCP();
    }
}
