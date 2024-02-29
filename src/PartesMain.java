import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import java.util.List;
import java.util.ArrayList;

public class PartesMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtCliente;
	private JTextField Obra;
	private JLabel lblFecha;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	public Cliente c;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartesMain frame = new PartesMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PartesMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 800, 600);
		contentPane = new JPanel();
		contentPane.setAlignmentY(0.1f);
		contentPane.setAlignmentX(0.1f);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Alta Parte");
		btnNewButton.setBounds(680, 520, 90, 30);
		btnNewButton.setEnabled(false);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);

		txtCliente = new JTextField();
		txtCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Cliente c = new Cliente(txtCliente.getText(), "", "", "");

				ArrayList<Cliente> lc = new ArrayList<>();
				lc = (ArrayList<Cliente>) FicheroCliente.leerFichero();
				if (Cliente.clienteExiste(txtCliente.getText(), lc)) {
					verMensaje("El cliente existe");
					btnNewButton.setEnabled(false);
					ClienteJFrame cjf = new ClienteJFrame(lc);
					cjf.setNifInInput(txtCliente.getText());
					cjf.setVisible(true);
				} else {
					if (!Cliente.validateNifAlgorithm(txtCliente.getText())) {
						verMensaje("El NIF introducido no es válido, por favor, vuelva a intentarlo");
						txtCliente.setText("");
						txtCliente.requestFocus();
					} else {
						Cliente client = new Cliente(txtCliente.getText());
						ClienteJFrame JfDeCliente = new ClienteJFrame(client);
						
						System.out.println("Nif en Partes 0 = "  + txtCliente.getText());

						JfDeCliente.setVisible(true);
					}
				}
			}
		});

		txtCliente.setBounds(86, 5, 300, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Obra:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);

		Obra = new JTextField();
		Obra.setColumns(10);
		Obra.setBounds(86, 33, 300, 20);
		contentPane.add(Obra);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(430, 11, 46, 14);
		contentPane.add(lblFecha);

		lblNewLabel_2 = new JLabel("Empleado:");
		lblNewLabel_2.setBounds(10, 67, 64, 14);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(86, 61, 300, 20);
		contentPane.add(textField_1);

		JDateChooser dateFecha = new JDateChooser();
		dateFecha.setBounds(475, 5, 152, 20);
		contentPane.add(dateFecha);
	}

	public static String pedirCliente() {
		String s = JOptionPane.showInputDialog("Introduce el cliente:");
		verMensaje(
				"Si el cliente existe paso al siguiente campo\n" + "si no existe hago que salte panel de alta cliente");
		return s;
	}

	public static void verMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}