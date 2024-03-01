package com.cristian.partes;
import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {

	private String nombre;
	private String nif;
	private String correo;
	private String telefono;
	
	public Cliente() {}
	
	public Cliente(String nif){
		this();
		this.nif = nif;
	}
	
	public Cliente(String nif, String name, String tlf, String mail) {
		this(nif);
		this.nombre=name;
		this.correo=mail;
		this.telefono=tlf;
	}
	
	public String getNif() {
		return nif;
	}
	
	@Override
	public String toString() {
		return "El cliente ha sido creado con los siguientes datos:"
				+ "\n\tNombre: " + nombre
				+ "\n\tNIF: " + nif 
				+ "\n\tTeléfono: " + telefono
				+ "\n\tCorreo electrónico: " + correo;
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
}
		
