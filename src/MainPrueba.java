import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainPrueba {
    public static void main(String[] args) {

        List<Parte> partes = new ArrayList<>();

        Cliente clientePrueba = new Cliente("Maksymiliano", "76581933Y", "maksymilioUkraine@mail.ukr", "982441361");
        Empleado empleadoPrueba = new Empleado("76581933Y", "Cristian Viking", "cristianchantada@rmail.com", "622222396");
        Vehiculo vehiculoPrueba = new Vehiculo("1234 JHK", "Seat 600", "Seat");
        Servicio servicioPrueba = new Servicio("Cabar un hoyo para cagar");

        Parte parteDePrueba =
                new Parte(new Date(), clientePrueba, empleadoPrueba, vehiculoPrueba, servicioPrueba);

        partes.add(parteDePrueba);
        FicheroPartes ficheroPartes = new FicheroPartes();
        ficheroPartes.generarPartes(partes);

    }
}
