package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logic.Cliente;
import logic.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private  JFormattedTextField txtCedula;
	private JTextField txtApellido;
	private JFormattedTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private MaskFormatter cedu;
	private MaskFormatter tele;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente() {
		setTitle("Registrar cliente");
		setResizable(false);
		setBounds(100, 100, 382, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 37, 65, 21);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(66, 37, 105, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(10, 81, 46, 21);
			panel.add(lblCedula);
			
			try {
				cedu = new MaskFormatter("###-#######-#");
				tele = new MaskFormatter("(###)-###-####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			
			
			txtCedula = new  JFormattedTextField(cedu);;
			txtCedula.setBounds(66, 81, 105, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(174, 37, 65, 21);
			panel.add(lblApellido);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(230, 37, 100, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);
			
					
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(174, 81, 65, 21);
			panel.add(lblTelefono);
			
			txtTelefono = new JFormattedTextField(tele);
			txtTelefono.setBounds(230, 81, 100, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
			lblDireccion.setBounds(10, 129, 65, 21);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(66, 129, 264, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(10, 173, 46, 21);
			panel.add(lblCorreo);
			
			txtCorreo = new JTextField();
			txtCorreo.setBounds(66, 173, 264, 20);
			panel.add(txtCorreo);
			txtCorreo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btcGuardar = new JButton("Guardar");
				btcGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtNombre.getText().equalsIgnoreCase("")  && !txtCorreo.getText().equalsIgnoreCase("") && !txtDireccion.getText().equalsIgnoreCase("")
								&& txtCedula.getText().length()==13 && txtTelefono.getText().length()==14 && !txtApellido.getText().equalsIgnoreCase("") ) {
						String nombre=txtNombre.getText();
						String apellido=txtApellido.getText();
						String correo=txtCorreo.getText();
						String cedula=txtCedula.getText();
						String direccion=txtDireccion.getText();
						String telefono=txtTelefono.getText();
						
						Cliente cliente=new Cliente(nombre, apellido, cedula, direccion, telefono, correo);
						
						Tienda.getInstance().AgregarCliente(cliente);
						JOptionPane.showMessageDialog(null, "El cliente se ha registrado satisfactorimente", null, JOptionPane.INFORMATION_MESSAGE, null);
						CleanCliente();
						}else { JOptionPane.showMessageDialog(null, "Datos Imcompletos",null,JOptionPane.WARNING_MESSAGE,null);}
					}
				});
				btcGuardar.setActionCommand("OK");
				buttonPane.add(btcGuardar);
				getRootPane().setDefaultButton(btcGuardar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void CleanCliente() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtApellido.setText("");
		
	}
	
	
}
