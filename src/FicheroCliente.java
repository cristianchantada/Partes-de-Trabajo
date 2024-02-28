import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FicheroCliente {

	private final static String RUTA_A_FICHERO_CLIENTES = "C:\\DAW\\Programación\\Java2Evaluacion\\PartesDeTrabajo\\src\\model\\partes.dat";

	public static List<Cliente> leerFichero() {
	    ArrayList<Cliente> clientes = new ArrayList<>();
	    try (ObjectInputStream miFichero = new ObjectInputStream(new FileInputStream(RUTA_A_FICHERO_CLIENTES))) {
	        while (true) {
	            try {
	                clientes = (ArrayList<Cliente>) miFichero.readObject();
	            } catch (EOFException e) {
	                break;
	            }
	        }
	    } catch (ClassNotFoundException e) {
	        System.out.println("Clase de objeto no encontrada: " + e.getMessage());
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.out.println("Error de entrada/salida: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return clientes;
	}


	public static void crearFichero(List<Cliente> cliente) {
		try (ObjectOutputStream miFichero = new ObjectOutputStream(new FileOutputStream(RUTA_A_FICHERO_CLIENTES))) {
			miFichero.writeObject(cliente);
		} catch (IOException write) {
			System.out.println("ERROR 01: No se da grabado la lista");
		}
	}

}