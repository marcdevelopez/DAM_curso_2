package sockets_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase representa un servidor TCP
 */
public class ServidorTCP {
	/**
	 * En esta clase, vamos a crear una variable que indicará 
	 * el puerto donde escuchará nuestro servidor, por ejemplo, 
	 * el puerto 6000. 
	 */
	private static final int PUERTO = 6000;

	public ServidorTCP() {
		try {
			/**
			 * Para implementar el servidor, crearemos un 
			 * objeto de la clase ServerSocket con el puerto 
			 * deseado. 
			 * 
			 * Creo el socket servidor que escucha en el puerto 
			 * 6000
			 * 
			 */
			ServerSocket skServidor = 
					new ServerSocket(PUERTO);
			/**
			 * Una vez hecho esto, deberemos crear un bucle 
			 * infinito para atender a todos los clientes que 
			 * se conecten al servidor, obteniéndolos mediante 
			 * el método accept(), que devolverá el cliente 
			 * conectado. 
			 * 
			 * Escucho a los clientes
			 */
			
			while (Boolean.TRUE) {
				
				Socket skCliente = skServidor.accept();
				/**
				 * El siguiente paso será crear los flujos de 
				 * entrada y de salida para poder llevar a 
				 * cabo la comunicación, mediante los métodos 
				 * readUTF() y writeUTF(), respectivamente. 
				 */
				// Obtengo el flujo de entrada del cliente
				// (Mensajes que recibe del cliente)
				InputStream aux2 = skCliente.getInputStream();
				DataInputStream flujorecibir = 
						new DataInputStream(aux2);
				// Obtengo el flujo de salida del cliente
				// (Mensajes que envía al cliente)
				OutputStream aux = skCliente.getOutputStream();
				DataOutputStream flujoenviar = 
						new DataOutputStream(aux);
				// Manda un mensaje al cliente
				flujoenviar.writeUTF("Hola cliente");
				// Por último, deberemos de cerrar el Socket.
				// Cierro el socket servidor
				skCliente.close();
			}
		} catch (IOException e) {
			System.out.println("Error en el servidor: " 
		+ e.getMessage());
		}
	}

}
