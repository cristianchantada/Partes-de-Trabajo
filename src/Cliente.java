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
		nombre=name;
		correo=mail;
		telefono=tlf;
	}
	
	public String getNif() {
		return nif;
	}
	
	@Override
	public String toString() {
		return " Cliente{" + "nombre='" + nombre + '\'' + ", nif='" + nif + '\'' + ", correo='" + correo + '\''
				+ ", telefono='" + telefono + '\'' + '}';
	}

	public static boolean clienteExiste(String nif,List<Cliente> lc ) {
		for(Cliente c:lc ) {
			if(nif.equals(c.nif)) return true;
		}
		return false;
	}
	
}
		
