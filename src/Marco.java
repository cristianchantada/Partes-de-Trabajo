import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Marco extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JTextField textField_1;
    private JLabel lblVehculos;
    private JLabel lblObras;
    private JLabel lblPartes;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Marco frame = new Marco();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Marco() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                new ClienteMarco(textField.getText());
                System.out.println("focus lost");
            }
        });
        textField.setBounds(175, 32, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel cliente = new JLabel("cliente");
        cliente.setBounds(10, 35, 46, 14);
        contentPane.add(cliente);

        lblNewLabel = new JLabel("Empleados");
        lblNewLabel.setBounds(10, 65, 107, 14);
        contentPane.add(lblNewLabel);

        textField_1 = new JTextField();
        textField_1.setBounds(175, 62, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        lblVehculos = new JLabel("vehículos");
        lblVehculos.setBounds(10, 90, 107, 14);
        contentPane.add(lblVehculos);

        lblObras = new JLabel("obras");
        lblObras.setBounds(10, 115, 74, 14);
        contentPane.add(lblObras);

        lblPartes = new JLabel("material");
        lblPartes.setBounds(10, 140, 107, 14);
        contentPane.add(lblPartes);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(175, 112, 86, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(175, 87, 86, 20);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(175, 137, 86, 20);
        contentPane.add(textField_4);

        JButton btnNewButton = new JButton("crear parte");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nifCliente = textField.getText();
                String nifEmpleado = textField_1.getText();
                String matriculaVahiculo = textField_3.getText();
                String descripcionServicio = textField_4.getText();
                String fecha = textField_4.getText();

                // Que cada uno se busque la vida para pasar al constructor de Parte: Cliente,
                // Empleado, Vehiculo y Servicio


                Date fechaFormat = formatearFecha(fecha);

                Parte newParte = new Parte(fecha, cliente, empleado, vehiculo, servicio);

                FicheroPartes ficheroPartes = new FicheroPartes();
                List<Parte> listaPartes = ficheroPartes.consultarPartes();
                listaPartes.add(newParte);
                ficheroPartes.generarPartes(listaPartes);



            }
        });
        btnNewButton.setBounds(175, 215, 89, 23);
        contentPane.add(btnNewButton);
    }


    public Date formatearFecha(String fechaString){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoFecha.parse(fechaString);
            System.out.println("Fecha parseada: " + fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

}