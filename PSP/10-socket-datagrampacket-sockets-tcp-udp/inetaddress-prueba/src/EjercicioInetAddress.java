import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjercicioInetAddress {
	public static void main(String[] args) {
		try {
			System.out.println("-> Dirección IP de una URL, por nombre");
			InetAddress address = InetAddress.getByName("www.google.com");
			System.out.println(address);
			System.out.println("-> Nombre a partir de la dirección");
			int temp = address.toString().indexOf('/');
			address = InetAddress.getByName(address.toString().substring(0, temp));
			System.out.println(address);
			System.out.println("-> Dirección IP actual de LocalHost");
			address = InetAddress.getLocalHost();
			System.out.println(address);
			System.out.println("-> Nombre de LocalHost a partir de la dirección");
			temp = address.toString().indexOf('/');
			address = InetAddress.getByName(address.toString().substring(0, temp));
			System.out.println(address);
			System.out.println("-> Nombre actual de LocalHost");
			System.out.println(address.getHostName());
			System.out.println();
		} catch (UnknownHostException e) {
			System.out.println(e);
			System.out.println("Debes estar conectado para que esto funcione bien.");
		}
	}
}
