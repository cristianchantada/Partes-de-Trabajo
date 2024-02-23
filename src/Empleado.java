import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable {
    String nif;
    String nombre;
    String correo;
    String telefono;
    String codigo;
    Date fecha;

    public Empleado(){}

    public Empleado(String nif, String nombre, String correo, String telefono){
        this();
        this.nif = nif;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}