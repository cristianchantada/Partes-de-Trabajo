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

public class ClienteJFrame extends JFrame implements ActionListener{

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
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public ClienteJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nifInput = new JTextField();
		nifInput.setBounds(131, 29, 203, 20);
		nifInput.setColumns(10);
		contentPane.add(nifInput);
		
		nameInput = new JTextField();
		nameInput.setBounds(131, 60, 203, 20);
		nameInput.setColumns(10);
		contentPane.add(nameInput);
		
		phoneInput = new JTextField();
		phoneInput.setBounds(131, 91, 203, 20);
		phoneInput.setColumns(10);
		contentPane.add(phoneInput);
		
		emailInput = new JTextField();
		emailInput.setBounds(131, 122, 203, 20);
		contentPane.add(emailInput);
		emailInput.setColumns(10);
		
		JLabel nifLabel = new JLabel("NIF nuevo cliente");
		nifLabel.setBounds(33, 29, 123, 20);
		contentPane.add(nifLabel);
		
		JLabel nameLabel = new JLabel("Nombre");
		nameLabel.setBounds(33, 63, 123, 20);
		contentPane.add(nameLabel);
		
		JLabel phoneLabel = new JLabel("Teléfono");
		phoneLabel.setBounds(33, 94, 123, 20);
		contentPane.add(phoneLabel);
		
		JLabel emailLabel = new JLabel("Correo electrónico");
		emailLabel.setBounds(33, 125, 123, 20);
		contentPane.add(emailLabel);
		
		JButton createClientButton = new JButton("Crear nuevo cliente");
		createClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createClientButton.setBounds(195, 180, 139, 23);
		contentPane.add(createClientButton);
	}
	
	public ClienteJFrame(List<Cliente> listaClientes) {
		this();
		this.listaClientes = listaClientes;
	}
	
	public void setNifInInput(String nif) {
		nifInput.setText(nif);
		nifInput.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nif = nifInput.getText().replaceAll("\\s", "").replaceAll("-", "");
		String name = nameInput.getText();
		String email = emailInput.getText();
		String phone = phoneInput.getText();
				
		// Regex de los datos	
		String nifRegex = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$|^[xyzXYZ]\\d{7}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";
		Pattern nifPattern = Pattern.compile(nifRegex);
		Matcher nifMatcher = nifPattern.matcher(nif);
		
		String emailRegex = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailMatcher = emailPattern.matcher(email);
		
		String phoneRegex = "^(?:\\+?34)?[6-9]\\d{8}$\r\n";
		Pattern phonePattern = Pattern.compile(phoneRegex);
		Matcher phoneMatcher = emailPattern.matcher(phone);
		
        boolean checker = true;
        String message;
        if (!nifMatcher.matches()) {
            message = "Su DNI no contiene un formato válido, por favor, inténtelo de nuevo";
            JOptionPane.showMessageDialog(null, message);
            System.out.println(message);
            checker = false;
            nifInput.setText("");
            checker = false;
        }
        
        // Lógica de validación del email;
        if (!nifMatcher.matches()) {
            message = "Su EMAIL no contiene un formato válido, por favor, inténtelo de nuevo";
            JOptionPane.showMessageDialog(null, message);
            System.out.println(message);
            checker = false;
            emailInput.setText("");
            checker = false;
        }
        
        // Lógica de validación del teléfono.
        if (!nifMatcher.matches()) {
            message = "Su TELÉFONO no contiene un formato válido, por favor, inténtelo de nuevo";
            JOptionPane.showMessageDialog(null, message);
            System.out.println(message);
            checker = false;
            emailInput.setText("");
            checker = false;
        }
        
        if(checker) {
        	Cliente newClient = new Cliente(nif, name, phone, email);
        	showSimpleMessage(newClient.toString());
        }

	}
	
    public static void showSimpleMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
