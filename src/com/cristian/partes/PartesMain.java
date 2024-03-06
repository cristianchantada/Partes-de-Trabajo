        package com.cristian.partes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import static com.cristian.partes.Validator.validateNifAlgorithm;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PartesMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField obraText;
	private JLabel obraLabel;
	private JLabel lblFecha;
	private JLabel lblEmpleado;
	private JTextField txtEmpleado;
	private JLabel labelCliente;
	private JButton altaParteButton;
	private JDateChooser dateFecha;
	private JComboBox clientNifComboBox;
	private JButton newClientButton;
	private Cliente c;
	private JButton newEmployeeButton;

	private boolean faseCliente = false;
	private boolean faseFecha = false;
	private boolean faseobra = false;
	private boolean faseEmpleado = false;
	private boolean faseMaterial = false;

	public boolean isFaseCliente() {
		return faseCliente;
	}

	public void setFaseCliente(boolean faseCliente) {
		if (faseCliente) {

		} else {

		}

	}

	public boolean isFaseFecha() {
		return faseFecha;
	}

	public void setFaseFecha(boolean faseFecha) {
		this.faseFecha = faseFecha;
	}

	public boolean isFaseobra() {
		return faseobra;
	}

	public void setFaseobra(boolean faseobra) {
		this.faseobra = faseobra;
	}

	public boolean isFaseEmpleado() {
		return faseEmpleado;
	}

	public void setFaseEmpleado(boolean faseEmpleado) {
		this.faseEmpleado = faseEmpleado;
	}

	public boolean isFaseMaterial() {
		return faseMaterial;
	}

	public void setFaseMaterial(boolean faseMaterial) {
		this.faseMaterial = faseMaterial;
	}

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

		// Combo box del NIF del Clieente
		JComboBox<String> clientNifComboBox = new JComboBox<>();
		clientNifComboBox.setBounds(86, 41, 300, 22);
		ArrayList<Cliente> listaDeClientes = new ArrayList<>();
		listaDeClientes = (ArrayList<Cliente>) FicheroCliente.leerFichero();

		clientNifComboBox.addItem("--Escoja un cliente de la lista--");
		for (Cliente cliente : listaDeClientes) {
			clientNifComboBox.addItem(cliente.getNif() + ", " + cliente.getNombre());
		}
		clientNifComboBox.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clientNifComboBox.getSelectedIndex() != 0) {
					faseCliente = true;
				}
			}
		});
		
		///////////////////////////////////////

		JTextField txtCliente = new JTextField();
		txtCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Cliente c = new Cliente(txtCliente.getText(), "", "", "");

				ArrayList<Cliente> lc = new ArrayList<>();
				lc = (ArrayList<Cliente>) FicheroCliente.leerFichero();

				System.out.println("lc is empty? = " + lc.isEmpty());
				for (Cliente cliente : lc) {
					System.out.println("Cliente de lista: " + cliente.getNombre());
				}

				System.out.println("Checkeo existe clietne" + Cliente.clienteExiste(txtCliente.getText(), lc));
				if (Cliente.clienteExiste(txtCliente.getText(), lc)) {
					verMensaje("El cliente existe");
					altaParteButton.setEnabled(false);
					ClienteJFrame cjf = new ClienteJFrame(c);
					cjf.setNifInInput(txtCliente.getText());
					cjf.setVisible(true);
					setFaseCliente(true);

				} else {
					if (!validateNifAlgorithm(txtCliente.getText())) {
						verMensaje("El NIF introducido no es válido, por favor, vuelva a intentarlo");
						txtCliente.setText("");
						txtCliente.requestFocus();
					} else {
						Cliente client = new Cliente(txtCliente.getText());
						ClienteJFrame JfDeCliente = new ClienteJFrame(client);
						JfDeCliente.setVisible(true);
					}
				}
			}
		});

		txtCliente.setBounds(96, 209, 300, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		contentPane.add(clientNifComboBox);

		altaParteButton = new JButton("Alta Parte");
		altaParteButton.setBounds(680, 520, 90, 30);
		altaParteButton.setEnabled(false);
		contentPane.add(altaParteButton);

		labelCliente = new JLabel("Cliente:");
		labelCliente.setBounds(23, 45, 66, 14);
		contentPane.add(labelCliente);

		obraLabel = new JLabel("Obra:");
		obraLabel.setBounds(23, 137, 46, 14);
		contentPane.add(obraLabel);

		obraText = new JTextField();
		obraText.setColumns(10);
		obraText.setBounds(86, 105, 300, 20);
		contentPane.add(obraText);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(23, 74, 46, 14);
		contentPane.add(lblFecha);

		lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(23, 108, 64, 14);
		contentPane.add(lblEmpleado);

		txtEmpleado = new JTextField();
		txtEmpleado.setBounds(86, 134, 300, 20);
		contentPane.add(txtEmpleado);

		dateFecha = new JDateChooser();
		dateFecha.setBounds(86, 74, 300, 20);
		contentPane.add(dateFecha);
		
		newClientButton = new JButton("Nuevo cliente");
		newClientButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		newClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newClientButton.setBounds(401, 41, 114, 23);
		contentPane.add(newClientButton);
		
		newEmployeeButton = new JButton("Nuevo Empleado");
		newEmployeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		newEmployeeButton.setBounds(401, 133, 114, 23);
		contentPane.add(newEmployeeButton);
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