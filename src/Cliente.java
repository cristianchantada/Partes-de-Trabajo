import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {

	private String nombre;
	private String nif;
	private String correo;
	private String telefono;
	
	public Cliente() {}
	
	public Cliente(String nif, String name, String tlf, String mail) {
		this.nif=nif;
		this.nombre=name;
		this.correo=mail;
		this.telefono=tlf;
	}
	
	public String getNif() {
		return nif;
	}
	
	@Override
	public String toString() {
		return "El cliente ha sido creado con los siguientes datos"
				+ "\tNombre: " + nombre
				+ "\tNIF: " + nif 
				+ "\tTeléfono: " + telefono
				+ "\tCorreo electrónico: " + correo;
	}

	public static boolean clienteExiste(String nif,List<Cliente> lc ) {
		if(lc != null) {
			for(Cliente c:lc ) {
				if(nif.equals(c.nif)) return true;
			}
			return false;
		}
		return false;
	}
	
	public static boolean validateNifAlgorithm(String nif) {
        String[] lettersTable = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        if(nif.length() > 0) {
            if (nif.charAt(0) == 'X') {
                char[] nifCharArray = nif.toCharArray();
                nifCharArray[0] = '0';
                nif = new String(nifCharArray);
            } else if (nif.charAt(0) == 'Y') {
                char[] nifCharArray = nif.toCharArray();
                nifCharArray[0] = '1';
                nif = new String(nifCharArray);
            } else if (nif.charAt(0) == 'Z') {
                char[] nifCharArray = nif.toCharArray();
                nifCharArray[0] = '2';
                nif = new String(nifCharArray);
            }

            String letter = nif.substring(8);
            String upperLetter = letter.toUpperCase();
            Integer number = Integer.parseInt(nif.substring(0, 8));
            int rest = number % 23;

            if (lettersTable[rest].equals(upperLetter)) {
                return true;
            } else {
                return false;
            }
        } else {
        	System.out.println("El campo DNI ha llegado vacío al checkeo con algoritmo DNI");
        	return false;
        }
    }
	
}
		
