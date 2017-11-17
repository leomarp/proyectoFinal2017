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
	private JTextField txtnombre;
	private  JFormattedTextField txtcedula;
	private JTextField txtapellido;
	private JFormattedTextField txttelefono;
	private JTextField txtdireccion;
	private JTextField txtcorreo;
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
			lblNombre.setBounds(10, 37, 65, 14);
			panel.add(lblNombre);
			
			txtnombre = new JTextField();
			txtnombre.setBounds(59, 34, 105, 20);
			panel.add(txtnombre);
			txtnombre.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(10, 81, 46, 14);
			panel.add(lblCedula);
			
			try {
				cedu = new MaskFormatter("###-#######-#");
				tele = new MaskFormatter("(###)-###-####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			
			
			txtcedula = new  JFormattedTextField(cedu);;
			txtcedula.setBounds(59, 78, 105, 20);
			panel.add(txtcedula);
			txtcedula.setColumns(10);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(174, 37, 65, 14);
			panel.add(lblApellido);
			
			txtapellido = new JTextField();
			txtapellido.setBounds(230, 34, 100, 20);
			panel.add(txtapellido);
			txtapellido.setColumns(10);
			
					
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(174, 81, 65, 14);
			panel.add(lblTelefono);
			
			txttelefono = new JFormattedTextField(tele);
			txttelefono.setBounds(230, 78, 100, 20);
			panel.add(txttelefono);
			txttelefono.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(10, 129, 65, 14);
			panel.add(lblDireccion);
			
			txtdireccion = new JTextField();
			txtdireccion.setBounds(66, 126, 264, 20);
			panel.add(txtdireccion);
			txtdireccion.setColumns(10);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(10, 173, 46, 14);
			panel.add(lblCorreo);
			
			txtcorreo = new JTextField();
			txtcorreo.setBounds(66, 170, 264, 20);
			panel.add(txtcorreo);
			txtcorreo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtnombre.getText().equalsIgnoreCase("")  && !txtcorreo.getText().equalsIgnoreCase("") && !txtdireccion.getText().equalsIgnoreCase("")
								&& txtcedula.getText().length()==13 && txttelefono.getText().length()==14 && !txtapellido.getText().equalsIgnoreCase("") ) {
						String nombre=txtnombre.getText();
						String apellido=txtapellido.getText();
						String correo=txtcorreo.getText();
						String cedula=txtcedula.getText();
						String direccion=txtdireccion.getText();
						String telefono=txttelefono.getText();
						
						Cliente cliente=new Cliente(nombre, apellido, cedula, direccion, telefono, correo);
						
						Tienda.getInstance().AgregarCliente(cliente);
						JOptionPane.showMessageDialog(null, "El cliente se ha registrado satisfactorimente", null, JOptionPane.INFORMATION_MESSAGE, null);
						CleanCliente();
						}else { JOptionPane.showMessageDialog(null, "Datos Imcompletos",null,JOptionPane.WARNING_MESSAGE,null);}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
	
	private void CleanCliente() {
		txtnombre.setText("");
		txtcedula.setText("");
		txtdireccion.setText("");
		txttelefono.setText("");
		txtcorreo.setText("");
		txtapellido.setText("");
		
	}
	
	
}
