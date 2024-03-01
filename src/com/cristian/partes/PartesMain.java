package com.cristian.partes;
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
import java.util.ArrayList;
import static com.cristian.partes.Validator.validateNifAlgorithm;
import java.awt.Color;

public class PartesMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtCliente;
	private JTextField obraText;
	private JLabel obraLabel;
	private JLabel lblFecha;
	private JLabel lblEmpleado;
	private JTextField txtEmpleado;
	private JLabel labelCliente;
	private JButton altaParteButton;
	private JDateChooser dateFecha;
	
	private boolean faseCliente = false;
	private boolean faseFecha = false;
	private boolean faseobra = false;
	private boolean faseEmpleado = false;
	private boolean faseMaterial = false;
	
	public boolean isFaseCliente() {
		return faseCliente;
	}

	public void setFaseCliente(boolean faseCliente) {
		if(faseCliente) {
			dateFecha.setBackground(Color.WHITE);
			dateFecha.setEnabled(true);
			txtCliente.setBackground(Color.GREEN);
		} else {
			dateFecha.setBackground(Color.RED);
			dateFecha.setEnabled(false);
		}
		this.faseCliente = faseCliente;
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

		altaParteButton = new JButton("Alta Parte");
		altaParteButton.setBounds(680, 520, 90, 30);
		altaParteButton.setEnabled(false);
		contentPane.add(altaParteButton);

		labelCliente = new JLabel("Cliente:");
		labelCliente.setBounds(10, 11, 46, 14);
		contentPane.add(labelCliente);

		txtCliente = new JTextField();
		txtCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Cliente c = new Cliente(txtCliente.getText(), "", "", "");

				ArrayList<Cliente> lc = new ArrayList<>();
				lc = (ArrayList<Cliente>) FicheroCliente.leerFichero();
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
						
						System.out.println("Nif en Partes 0 = "  + txtCliente.getText());

						JfDeCliente.setVisible(true);
					}
				}
			}
		});

		txtCliente.setBounds(86, 5, 300, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		obraLabel = new JLabel("Obra:");
		obraLabel.setBounds(10, 36, 46, 14);
		contentPane.add(obraLabel);

		obraText = new JTextField();
		obraText.setBackground(Color.RED);
		obraText.setColumns(10);
		obraText.setBounds(86, 33, 300, 20);
		obraText.setEnabled(false);
		contentPane.add(obraText);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(430, 11, 46, 14);
		contentPane.add(lblFecha);

		lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(10, 67, 64, 14);
		contentPane.add(lblEmpleado);

		txtEmpleado = new JTextField();
		txtEmpleado.setBackground(Color.RED);
		txtEmpleado.setBounds(86, 61, 300, 20);
		txtEmpleado.setEnabled(false);
		contentPane.add(txtEmpleado);

		dateFecha = new JDateChooser();
		dateFecha.setBackground(Color.RED);
		dateFecha.setBounds(475, 5, 152, 20);
		dateFecha.setEnabled(false);
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