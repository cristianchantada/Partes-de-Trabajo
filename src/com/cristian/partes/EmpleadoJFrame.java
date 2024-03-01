/*package com.cristian.partes;

import static com.cristian.partes.PartesMain.verMensaje;
import static com.cristian.partes.Validator.*;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EmpleadoJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailInput;
	private JTextField nifInput;
	private JTextField nameInput;
	private JTextField phoneInput;
	private JTextField employeeCodeInput;

	public EmpleadoJFrame() {
		getContentPane().setLayout(null);
	}

	public EmpleadoJFrame(Empleado e) {
		this();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		nifInput = new JTextField();
		nifInput.setBounds(193, 29, 203, 20);
		nifInput.setColumns(10);
		nifInput.setText(e.getNif());
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
		
		employeeCodeInput = new JTextField();
		employeeCodeInput.setBounds(193, 122, 203, 20);
		contentPane.add(employeeCodeInput);
		employeeCodeInput.setColumns(10);

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
		
		JLabel employeeCodeLabel = new JLabel("Código de empleado");
		employeeCodeLabel.setBounds(33, 125, 123, 20);
		contentPane.add(employeeCodeLabel);

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
		String employeeCode = employeeCodeInput.getText();

		boolean checker = true;
		if (!nifValidator(nif)) {
			nifInput.setText("");
			checker = false;
		}

		if (!emailValidator(email)) {
			emailInput.setText("");
			checker = false;
		}

		if (!phoneValidator(phone)) {
			checker = false;
			phoneInput.setText("");
		}

		if (validarNombre(name)) {
			verMensaje("El código de cliente no es corecto, por favor, inténtelo de nuevo");
			checker = false;
			nameInput.setText("");
		}
		
		if( validarCodigoOperario(employeeCode)) {
			verMensaje("El nombre del cliente no es válido, por favor, inténtelo de nuevo");
			checker = false;
			employeeCodeInput.setText("");
		}

		if (checker) {
			Empleado newEmpleado = new Empleado(nif, name, phone, email);
			List<Cliente> lc = new ArrayList<>();
			lc = FicheroCliente.leerFichero();
			lc.add(newEmpleado);
			FicheroCliente.crearFichero(lc);
			verMensaje(newEmpleado.toString());
			dispose();
		}
	}
}*/