/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa un cliente de nuestra aplicación
 * @author Francisco Jesús Delgado Almirón
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            String direccionIP = "localhost";
            int puerto = 5056;
            
            // Optengo la IP real
            InetAddress ip = InetAddress.getByName(direccionIP);
            
            System.out.println("CLIENTE: Conectando con " 
            + direccionIP + ":" + puerto + "...");
            
            // Establezco la conexión con la IP y el puerto
            Socket socket = new Socket(ip, puerto);
            
            System.out.println("CLIENTE: Conexión establecida.");
            
            // Obtengo los flujos de entrada y salida
            DataInputStream entrada = 
            		new DataInputStream(socket.getInputStream());
            DataOutputStream salida = 
            		new DataOutputStream(socket.getOutputStream());
            
            // Este es el bucle que va a permitir la comunicación entre el
            // cliente y el cliente hebra
            boolean salir = false;
            Scanner teclado_String = new Scanner(System.in);
            while (!salir)  
            {
                // Imprimo el mensaje del cliente
                System.out.println(entrada.readUTF());
                // Leo la respuesta y la envío 
                // (Si quiero número aleatorio o salir)
                String textoenviar = teclado_String.nextLine(); 
                salida.writeUTF(textoenviar);
                
                // Según lo que le haya enviado al servidor...
                switch(textoenviar)
                {                    
                    case "1": // Opción mostrar número aleatorio
                        // Imprimo el mensaje del número aleatorio 
                    	// del cliente 
                        String mensajerecibido = entrada.readUTF(); 
                        System.out.println(mensajerecibido); 
                        break;
                    case "2": // Opción salir
                        System.out.println(""
                        		+ "CLIENTE: Cerrando la conexión...");
                        socket.close();
                        System.out.println(""2
                        		+ "CLIENTE: Conexión cerrada.");
                        salir = true; 
                        break;
                    default:
                        System.out.println(""
                        		+ "CLIENTE: Opción incorrecta.");
                        break;
                }
            }
            
            // Cierro los flujos
            try
            { 
                entrada.close(); 
                salida.close();              
            }
            catch(IOException e)
            { 
                System.out.println("ERROR CLIENTE 2 -> " + e.toString()); 
            }
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
