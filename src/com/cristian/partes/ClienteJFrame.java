package com.cristian.partes;
import static com.cristian.partes.Validator.*;
import static com.cristian.partes.PartesMain.verMensaje;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClienteJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailInput;
	private JTextField nifInput;
	private JTextField nameInput;
	private JTextField phoneInput;

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

	public void setNifInInput(String nif) {
		nifInput.setText(nif);
		nifInput.setEnabled(false);
	}

	public void pulsarBoton() {

		String nif = nifInput.getText().replaceAll("\\s", "").replaceAll("-", "");
		String name = nameInput.getText();
		String email = emailInput.getText();
		String phone = phoneInput.getText();

		boolean checker = true;
		if(!nifValidator(nif)) {
			nifInput.setText("");
			checker = false;
		}
		
		if(!emailValidator(email)){
			emailInput.setText("");
			checker = false;
		}

		if(!phoneValidator(phone)) {
			checker = false;
			phoneInput.setText("");
		}

		if(!validarNombre(name)) {
			verMensaje("El nombre del cliente no es válido, por favor, inténtelo de nuevo");
			checker = false;
			nameInput.setText("");
		}

		if (checker) {
			Cliente newClient = new Cliente(nif, name, phone, email);
			List<Cliente> lc = new ArrayList<>();
			lc = FicheroCliente.leerFichero();
			lc.add(newClient);
			FicheroCliente.crearFichero(lc);
			verMensaje(newClient.toString());
			dispose();
		}
	}

}
