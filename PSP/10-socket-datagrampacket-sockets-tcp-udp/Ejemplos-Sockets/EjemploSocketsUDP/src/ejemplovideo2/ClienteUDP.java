/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/**
 * Esta clase representa un cliente UDP
 * @author Francisco Jesús Delgado Almirón
 */
public class ClienteUDP {

    private static final int PUERTO = 6789;
    private static final String HOST = "localhost";
    private Random aleatorio;

    public ClienteUDP() {
        try {
            // Creo el mensaje a enviar al servidor con un número aleatorio
            aleatorio = new Random();
            int numerocliente = aleatorio.nextInt(100) + 1;
            String mensajeenviar = String.valueOf(numerocliente);
            // Creo el socket UDP
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = mensajeenviar.getBytes();
            // Obtengo la dirección del host
            InetAddress hostServidor = InetAddress.getByName(HOST);
            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, mensajeenviar.length(),
                            hostServidor,
                            PUERTO);
            // Enviamos el datagrama
            socketUDP.send(peticion);
            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(bufer,
                    bufer.length);
            socketUDP.receive(respuesta);
            // Enviamos la respuesta del servidor a la salida estandar
            System.out.println("Respuesta: " + new String(respuesta.getData()));
            // Cerramos el socket
            socketUDP.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ClienteUDP();
    }
}
