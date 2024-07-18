package sockets_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class ClienteUDP {
	private static final int PUERTO = 6789;
	private static final String HOST = "localhost";

	public ClienteUDP() {
		try {
			String mensajeenviar = String.valueOf("Hola");
			// Creo el socket UDP
			DatagramSocket socketUDP = 
					new DatagramSocket();
			byte[] mensaje = mensajeenviar.getBytes();
			// Obtengo la direccion del host
			InetAddress hostServidor = InetAddress.getByName (HOST);
			// Construimos un datagrama para enviar el mensaje al servidor
			DatagramPacket peticion = 
					new DatagramPacket (
							mensaje, 
							mensajeenviar.length(),
							hostServidor, 
							PUERTO);
			// Enviamos el datagrama
			socketUDP.send(peticion);
			// Construimos el DatagramPacket que contendra la respuesta
			byte[] bufer = new byte[1000];
			// Construimos el DatagramPacket que contendra la respuesta
			DatagramPacket respuesta = 
					new DatagramPacket(
							bufer, 
							bufer.length);
			socketUDP.receive(respuesta);
			// Enviamos la respuesta del servidor a la salida estandar
			System.out.println("Respuesta: " + 
			new String(respuesta.getData()));
			// Cerramos el socket
			socketUDP.close();
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
