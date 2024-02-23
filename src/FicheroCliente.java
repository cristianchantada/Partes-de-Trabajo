import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FicheroCliente {
	
	public static ArrayList<Cliente> leerFichero() {
		ArrayList<Cliente> cliente = null;
		try (ObjectInputStream miFichero = new ObjectInputStream(new FileInputStream("Clientes.dat"))) {
			while (true) {
				cliente = (ArrayList<Cliente>) miFichero.readObject();
			}
		} catch (ClassNotFoundException e) {System.out.println("1");
		} catch (EOFException e) {System.out.println("2");
		} catch (IOException e) {System.out.println("3");
		}
		return cliente;
	}	

	public static void crearFichero(ArrayList<Cliente> cliente) {
		try (ObjectOutputStream miFichero = new ObjectOutputStream(new FileOutputStream("Clientes.dat"))) {
			miFichero.writeObject(cliente);
		} catch (IOException write) {
			System.out.println("ERROR 01: No se da grabado la lista");
		}
	}
	
}