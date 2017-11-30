package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class CrearFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JFormattedTextField formattedTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearFactura dialog = new CrearFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearFactura() {
		setTitle("Crear factura");
		setResizable(false);
		setBounds(100, 100, 637, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(349, 10, 1, 1);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(10, 37, 65, 21);
				panel.add(label);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(66, 37, 105, 20);
				panel.add(textField);
			}
			{
				JLabel label = new JLabel("Cedula:");
				label.setBounds(10, 81, 46, 21);
				panel.add(label);
			}
			
			{
				JLabel label = new JLabel("Apellido:");
				label.setBounds(174, 37, 65, 21);
				panel.add(label);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(230, 37, 100, 20);
				panel.add(textField_1);
			}
			{
				JLabel label = new JLabel("Telefono:");
				label.setBounds(174, 81, 65, 21);
				panel.add(label);
			}
			{
				formattedTextField = new JFormattedTextField((AbstractFormatter) null);
				formattedTextField.setColumns(10);
				formattedTextField.setBounds(230, 81, 100, 20);
				panel.add(formattedTextField);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(10, 129, 65, 21);
				panel.add(label);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(66, 129, 264, 20);
				panel.add(textField_2);
			}
			{
				JLabel label = new JLabel("Correo:");
				label.setBounds(10, 173, 46, 21);
				panel.add(label);
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(66, 173, 264, 20);
				panel.add(textField_3);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 606, 129);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("Nombre:");
		label.setBounds(10, 50, 65, 21);
		panel.add(label);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 25, 46, 21);
		panel.add(lblCdula);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 100, 65, 21);
		panel.add(lblDireccion);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(76, 100, 505, 20);
		panel.add(textField_5);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(300, 50, 65, 21);
		panel.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(10, 75, 65, 21);
		panel.add(lblTelefono);
		
		JLabel label_5 = new JLabel("Correo:");
		label_5.setBounds(300, 75, 46, 21);
		panel.add(label_5);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(300, 24, 89, 23);
		panel.add(btnBuscar);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(76, 25, 199, 20);
		panel.add(textField_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(76, 50, 199, 20);
		panel.add(textField_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(76, 75, 199, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(356, 50, 225, 20);
		panel.add(textField_7);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(356, 75, 225, 20);
		panel.add(textField_9);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
