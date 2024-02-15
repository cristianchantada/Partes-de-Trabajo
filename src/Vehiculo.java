import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehiculo implements Serializable {
    final static String RUTA = new File("").getAbsolutePath() + "\\src\\";
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> matriculas = new ArrayList<>();
    private static ArrayList<String> marcas = new ArrayList<>();
    private static ArrayList<String> modelos = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatos();
        System.out.println("Dame el número de la matricula");
        String mat = sc.nextLine();
        if (matriculas.contains(mat)) {
            System.out.println("ERROR. La matricula ya existe");

        } else {
            matriculas.add(mat);
            System.out.println("De que marca es el vehiculo");
            String marc = sc.nextLine();
            marcas.add(marc);
            System.out.println("Que modelo es el vehiculo");
            String model = sc.nextLine();
            modelos.add(model);
        }

        escribirEnArchivo();
        guardarDatos();
    }


    static void escribirEnArchivo() {
        try {
            FileWriter writer = new FileWriter(RUTA + "vehiculos.txt");

            for (int i = 0; i < matriculas.size(); i++) {
                writer.write("Matricula: " + matriculas.get(i) + "  Modelo: " + modelos.get(i) + "  Marca: " + marcas.get(i) + "\n");
            }
            writer.close();
            System.out.println("Datos escritos en el archivo correctamente.");

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(RUTA + "vehiuclos.dat"));
            outputStream.writeObject(new Vehiculo());
            outputStream.close();
            System.out.println("Vehiculos serializados correctamente.");

        } catch (Exception o) {
            System.out.println("Error al escribir en el archivo: " + o.getMessage());
        }
    }

    static void guardarDatos() {
        try (FileWriter writer = new FileWriter(RUTA + "Vehiculos(Datos).txt")) {
            for (int i = 0; i < matriculas.size(); i++) {
                writer.write(matriculas.get(i) + "," + modelos.get(i) + "," + marcas.get(i) + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    static void cargarDatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA + "Materiales(Datos).txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                matriculas.add(partes[0]);
                modelos.add(partes[1]);
                marcas.add(partes[2]);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public static ArrayList<String> getMatriculas() {
        return matriculas;
    }

    public static void setMatriculas(ArrayList<String> matriculas) {
        Vehiculo.matriculas = matriculas;
    }

    public static ArrayList<String> getMarcas() {
        return marcas;
    }

    public static void setMarcas(ArrayList<String> marcas) {
        Vehiculo.marcas = marcas;
    }

    public static ArrayList<String> getModelos() {
        return modelos;
    }

    public static void setModelos(ArrayList<String> modelos) {
        Vehiculo.modelos = modelos;
    }
}

