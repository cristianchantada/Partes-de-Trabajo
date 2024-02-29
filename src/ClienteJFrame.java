import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClienteJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailInput;
	private JTextField nifInput;
	private JTextField nameInput;
	private JTextField phoneInput;
	private List<Cliente> listaClientes;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteJFrame frame = new ClienteJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ClienteJFrame(Cliente c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nifInput = new JTextField();
		nifInput.setBounds(193, 29, 203, 20);
		nifInput.setColumns(10);
		nifInput.setText(c.getNif());
		
		
		System.out.println("NifCliente en JFrameCliente = " + c.getNif());
		
		
		nifInput.setEnabled(false);
		contentPane.add(nifInput);

		nameInput = new JTextField();
		nameInput.setBounds(193, 60, 203, 20);
		nameInput.setColumns(10);
		contentPane.add(nameInput);

		phoneInput = new JTextField();
		phoneInput.setBounds(193, 91, 203, 20);
		phoneInput.setColumns(10);
		contentPane.add(phoneInput);

		emailInput = new JTextField();
		emailInput.setBounds(193, 122, 203, 20);
		contentPane.add(emailInput);
		emailInput.setColumns(10);

		JLabel nameLabel = new JLabel("Nombre");
		nameLabel.setBounds(33, 63, 123, 20);
		contentPane.add(nameLabel);
		
		JLabel nifLabel = new JLabel("NIF nuevo cliente");
		nifLabel.setBounds(33, 29, 150, 20);
		contentPane.add(nifLabel);

		JLabel phoneLabel = new JLabel("Teléfono");
		phoneLabel.setBounds(33, 94, 123, 20);
		contentPane.add(phoneLabel);

		JLabel emailLabel = new JLabel("Correo electrónico");
		emailLabel.setBounds(33, 125, 123, 20);
		contentPane.add(emailLabel);

		JButton createClientButton = new JButton("Crear nuevo cliente");
		createClientButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pulsarBoton();
			}
		});

		createClientButton.setBounds(195, 180, 139, 23);
		contentPane.add(createClientButton);
	}

	public ClienteJFrame(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void setNifInInput(String nif) {
		nifInput.setText(nif);
		nifInput.setEnabled(false);
	}

	public void pulsarBoton() {

		String nif = nifInput.getText().replaceAll("\\s", "").replaceAll("-", "");
		String name = nameInput.getText();
		String email = emailInput.getText();
		String phone = phoneInput.getText();

		if(!Validator.nifValidator(nif)) {
			nifInput.setText("");
		}




		boolean checker = true;
		
		if (!nifMatcher.matches()) {
			message = "Su DNI no contiene un formato válido, por favor, inténtelo de nuevo";
			JOptionPane.showMessageDialog(null, message);
			System.out.println(message);
			nifInput.setText("");
			checker = false;
		} else {
			if (!validateNifAlgorithm(nif)) {
				message = "Su NIF no contiene un formato válido, por favor, inténtelo de nuevo";
				JOptionPane.showMessageDialog(null, message);
				System.out.println(message);
				nifInput.setText("");
				checker = false;
			}
		}

		// Lógica de validación del email;
		if (!emailMatcher.matches()) {
			message = "Su EMAIL no contiene un formato válido, por favor, inténtelo de nuevo";
			JOptionPane.showMessageDialog(null, message);
			System.out.println(message);
			emailInput.setText("");
			checker = false;
		}

		// Lógica de validación del teléfono.
		if (!phoneMatcher.matches()) {
			message = "Su TELÉFONO no contiene un formato válido, por favor, inténtelo de nuevo";
			JOptionPane.showMessageDialog(null, message);
			System.out.println(message);
			checker = false;
			phoneInput.setText("");
		}
		
		if(name.isEmpty()) {
			message = "El nombre del cliente no puede estar vacío, por favor, inténtelo de nuevo";
			JOptionPane.showMessageDialog(null, message);
			checker = false;
			nameInput.setText("");
		}

		if (checker) {
			Cliente newClient = new Cliente(nif, name, phone, email);
			List<Cliente> lc = new ArrayList<>();
			lc = FicheroCliente.leerFichero();
			lc.add(newClient);
			FicheroCliente.crearFichero(lc);
			showSimpleMessage(newClient.toString());
			dispose();
		}
	}

	public static void showSimpleMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}



}
