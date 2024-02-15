import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente implements Serializable {

    /**
     * JavaDoc
     **/

    // String
    private static final Scanner teclado = new Scanner(System.in);
    /**
     * @author ULISES III
     * @version 1.1
     * @Descripcion: En esta clase Cliente se Realiza y que genere un fichero con la
     * lista de partes realizados y tenga la posibilidad de Generar,
     * Consultar, Ver con detalle la lista de clientes
     * <p>
     * // NIF/Documento identidad (Validado) // b. Nombre // c. Correo
     * electrónico (validado) // d. Teléfono de contacto
     * @Modulos: Crear fichero , generar datos por teclado , grabar fichero
     */

    // Atributos de la clase

    // Lista Array
    static List<Cliente> listaClientes = new ArrayList<>();
    // Pattern
    private final Pattern nifPattern = Pattern.compile("^\\d{8}\\w[TRWAGMYFPDXBNJZSQVHLCKE]$");
    private final Pattern telefonoPattern = Pattern.compile("^\\d{3}\\s\\d{3}\\s\\d{3}$");
    private String nombre;
    private String nif;
    private String correo;
    private String telefono;
    // fichero
    private String ficheroCliente;

    public Cliente() {
//  Nunca llamar a los metodos de la clase por evitar un bucle infinito
        // verificarCliente();
        //insertarDatos();
    }

    public static void main(String[] arg) {
        Cliente nuevoCliente = new Cliente();
        FicheroCliente fichero = new FicheroCliente();
        nuevoCliente.insertarDatos();
        nuevoCliente.archivoCliente(listaClientes);
        fichero.crearFichero(nuevoCliente);
        System.out.println(nuevoCliente);

        // Crear instancia de la clase para crear el fichero del cliente
    }

    public void insertarDatos() {
        boolean salir = false;
        System.out.println("Introduce los datos del cliente : Nombre, Nif, Correo, Telefono");
        Cliente cliente = new Cliente();
        while (!salir) {

            System.out.println("Nombre : ");

            nombre = teclado.next();
            listaClientes.add(cliente);

            System.out.println(" Nif : ");
            nif = teclado.next();
            listaClientes.add(cliente);

            Matcher matcherNif = nifPattern.matcher(nif);

            // Verificar Nif

            if (matcherNif.find()) {
                System.out.println("Pattern found at index: " + matcherNif.start());
            } else {
                System.out.println("Pattern not found");
            }

            System.out.println(" Correo : ");
            correo = teclado.next();
            listaClientes.add(cliente);

            System.out.println(" Telefono : ");
            telefono = teclado.next();

            Matcher matcherTelefono = telefonoPattern.matcher(telefono);

            if (matcherTelefono.find()) {
                System.out.println("Nif valido en el  index: " + matcherTelefono.start());
            } else {
                System.out.println("Nif no válido");
            }

            listaClientes.add(cliente);

            // metodo para seguir o no introduciendo datos

            System.out.println(" - ¿ Quieres dejar de introducit Datos del cliente ? (s - n) ");

            String continuar = teclado.next();

            if (!continuar.equalsIgnoreCase("s")) {
                salir = true;
            }

        }
    }

    /**
     * Metodo 2 : Insertar Datos por teclado
     **/

    public List<Cliente> archivoCliente(List<Cliente> listaClientes) {
        List<String> propiedadesClientes = new ArrayList<>();
        for (Cliente cliente : listaClientes) {

            propiedadesClientes.add(cliente.getNombre());
            propiedadesClientes.add(cliente.getNif());
            propiedadesClientes.add(cliente.getCorreo());
            propiedadesClientes.add(cliente.getTelefono());

        }
        return listaClientes;
    }

    /**
     * public void verificarCliente() {
     * <p>
     * // Verificar Datos del cliente
     * <p>
     * if ( ver si cliente existe) { System.out.println("el cliente verificado
     * existe"); }else ( noexist ){
     * <p>
     * System.out.println(" el cliente no existe , introduce un nuevo cliente ");
     * break; } }
     **/

    // devolver la lista del cliente

    // Metodo 3 : Grabar fichero

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    @Override
    public String toString() {
        return " Cliente{" + "nombre='" + nombre + '\'' + ", nif='" + nif + '\'' + ", correo='" + correo + '\''
                + ", telefono='" + telefono + '\'' + '}';
    }

}