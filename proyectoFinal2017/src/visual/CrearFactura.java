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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CrearFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JFormattedTextField formattedTextField;
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtPrecio;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTable table;

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
		setBounds(100, 100, 598, 561);
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
		panel.setBounds(10, 11, 560, 129);
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
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(76, 100, 470, 20);
		panel.add(txtDireccion);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(300, 50, 65, 21);
		panel.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(10, 75, 65, 21);
		panel.add(lblTelefono);
		
		JLabel label_5 = new JLabel("Correo:");
		label_5.setBounds(300, 75, 46, 21);
		panel.add(label_5);
		
		JButton btnBuscarCedula = new JButton("Buscar");
		btnBuscarCedula.setBounds(300, 24, 89, 23);
		panel.add(btnBuscarCedula);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(76, 25, 199, 20);
		panel.add(txtCedula);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 50, 199, 20);
		panel.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(76, 75, 199, 20);
		panel.add(txtTelefono);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(356, 50, 190, 20);
		panel.add(txtApellido);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(356, 75, 190, 20);
		panel.add(txtCorreo);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Infomaci\u00F3n del producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 144, 560, 135);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 25, 69, 14);
			panel_1.add(lblNewLabel);
			
			JLabel lblComponente = new JLabel("Producto:");
			lblComponente.setBounds(10, 50, 82, 14);
			panel_1.add(lblComponente);
			
			JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setBounds(300, 50, 69, 14);
			panel_1.add(lblModelo);
			
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setBounds(10, 75, 69, 14);
			panel_1.add(lblMarca);
			
			JLabel lblPrecio = new JLabel("Cantidad:");
			lblPrecio.setBounds(300, 75, 69, 14);
			panel_1.add(lblPrecio);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(72, 22, 199, 20);
			panel_1.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtProducto = new JTextField();
			txtProducto.setColumns(10);
			txtProducto.setBounds(72, 47, 199, 20);
			panel_1.add(txtProducto);
			
			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(72, 97, 199, 20);
			panel_1.add(txtPrecio);
			
			txtModelo = new JTextField();
			txtModelo.setColumns(10);
			txtModelo.setBounds(356, 47, 190, 20);
			panel_1.add(txtModelo);
			
			txtMarca = new JTextField();
			txtMarca.setColumns(10);
			txtMarca.setBounds(72, 72, 199, 20);
			panel_1.add(txtMarca);
			
			JButton btnBuscarCodigo = new JButton("Buscar");
			btnBuscarCodigo.setBounds(303, 21, 89, 23);
			panel_1.add(btnBuscarCodigo);
			
			JLabel lblCantidad = new JLabel("Precio:");
			lblCantidad.setBounds(10, 100, 69, 14);
			panel_1.add(lblCantidad);
			
			JSpinner spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnCantidad.setBounds(356, 72, 190, 20);
			panel_1.add(spnCantidad);
			
			JButton btnAgregarAlCarrito = new JButton("Agregar al carrito");
			btnAgregarAlCarrito.setBounds(303, 100, 154, 23);
			panel_1.add(btnAgregarAlCarrito);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 284, 560, 167);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 540, 134);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(26, 462, 56, 14);
		contentPanel.add(lblSubtotal);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(202, 462, 72, 14);
		contentPanel.add(lblDescuento);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(377, 462, 46, 14);
		contentPanel.add(lblTotal);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(78, 459, 114, 20);
		contentPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(264, 459, 103, 20);
		contentPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(422, 459, 108, 20);
		contentPanel.add(textField_17);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVender = new JButton("Vender");
				btnVender.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnVender.setActionCommand("OK");
				buttonPane.add(btnVender);
				getRootPane().setDefaultButton(btnVender);
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
}
