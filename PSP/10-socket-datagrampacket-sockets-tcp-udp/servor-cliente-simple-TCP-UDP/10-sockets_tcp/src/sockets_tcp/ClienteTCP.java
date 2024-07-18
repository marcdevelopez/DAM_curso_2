package sockets_tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClienteTCP {
	/**
	 * crearemos una variable que indicará el puerto donde 
	 * escuchará nuestro servidor, por ejemplo, el puerto 
	 * 6000 y otra con el host donde se aloja el servidor 
	 * (en nuestro caso, como será en la misma máquina, 
	 * será localhost). 
	 */
	private static final String HOST = "localhost";
	private static final int PUERTO = 6000;

	public ClienteTCP() {
		try {
			/**
			 * Para crear el cliente, crearemos un objeto de 
			 * la clase Socket con el host y el puerto deseado. 
			 */
			Socket skCliente = 
					new Socket(HOST, PUERTO);
			/**
			 * Una vez hecho esto, el servidor nos aceptará, 
			 * por lo que el siguiente paso será crear los 
			 * flujos de entrada y de salida para poder llevar 
			 * a cabo la comunicación, mediante los métodos 
			 * readUTF() y writeUTF() respectivamente. 
			 */
			// Obtengo el flujo de entrada del cliente creado
			// (Mensajes que recibe el cliente del servidor)
			InputStream aux = skCliente.getInputStream();
			DataInputStream flujo = 
					new DataInputStream(aux);
			/**
			 * Por último, deberemos de cerrar el Socket. 
			 */
			// Cierro el socket
			skCliente.close();

		} catch (IOException ex) {
			System.out.println("Error -> " + ex.toString());
		}

	}

}
