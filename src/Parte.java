import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Parte implements Serializable {

    private Date fecha;
    private String observaciones;
    private String estado;
    private Cliente cliente;
    private Empleado empleado;
    private Vehiculo vehiculo; //opcional
    private Servicio servicio; //opcional
    private Material material; //opcional
    private Localizacion localizacion;

    public Parte(){}

    public Parte(Date fecha, String estado){
        this.fecha = fecha;
        this.estado = estado;
    }

    public Parte(Date fecha, String estado, String observaciones){
        this(fecha, estado);
    }

    public Parte (Date fecha, String estado, String observaciones, Empleado empleado){
        this(fecha, estado, observaciones);
        this.empleado = empleado;
    }

    public Parte (Date fecha, String estado, String observaciones, Empleado empleado, Localizacion localizacion){
        this(fecha, estado, observaciones, empleado);
        this.localizacion = localizacion;
    }

    public Parte (Date fecha, String estado, String observaciones, Empleado empleado, Localizacion localizacion, Cliente cliente){
        this(fecha, estado, observaciones, empleado, localizacion);
        this.cliente = cliente;
    }

    public Parte (Date fecha, String estado, String observaciones, Empleado empleado, Localizacion localizacion, Cliente cliente, Vehiculo vehiculo){
        this(fecha, estado, observaciones, empleado, localizacion, cliente);
        this.vehiculo = vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }



    @Override
    public String toString() {
        return "----- Parte con fecha" + fecha + "-------\n" +
                "\t\tObservaciones:" + observaciones + "\n" +
                "\t\tEstado:\n\t\t\t" + estado + "\n" +
                "\t\tCliente:\n\t\t\t" + cliente + "\n" +
                "\t\tEmpleado:\n\t\t\t" + empleado + "\n" +
                "\t\tVehiculo:\n\t\t\t" + vehiculo + "\n" +
                "\t\tServicio:\n\t\t\t" + servicio + "\n" +
                "\t\tMaterial:\n\t\t\t" + material + "\n" +
                "\t\tlocalizacion\t\t\t: " + localizacion + "\n\n";
    }
}
