package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


import logic.Tienda;
import logic.Cliente;
import logic.Componente;
import logic.Factura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CrearFactura extends JDialog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtCedula,txtTelefono;
	private JTextField txtNombre,txtApellido,txtSubTotal,txtDescuento,txtTotal,txtDireccion;
	private JTextField txtCorreo,txtCodigo,txtProducto,txtPrecio,txtModelo,txtMarca;
	
	Object[] fila; //Nuevo
	private DefaultTableModel model_comp,model;
	private JTable table,table_comp;
	private JButton btnBuscarCodigo;
	private JSpinner spnCantidad,spnDescuento;
	private JButton btnVender;
	private static MaskFormatter formato;
	private static MaskFormatter telef;	
	private ArrayList<Componente> carrito= new ArrayList<>();
	private ArrayList<Componente> listaTemporal= Tienda.getInstance().getMisComponentes();
	
	
	private Cliente cliente=null;

	public CrearFactura() {
		setTitle("Crear factura");
		
		//creacion de un arreglo temporadl de componentes
		
		
		
		setResizable(false);
		setBounds(100, 100, 588, 687);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		try {
			formato = new MaskFormatter("###-#######-#");
			telef = new MaskFormatter("(###)-###-####");

			} catch (Exception e) {
				e.printStackTrace();
			}
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 560, 129);
		contentPanel.add(panel);
		{
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
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setEditable(false);
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
		}
		//PARA BUSCAR EL CLIENTE
		JButton btnBuscarCedula = new JButton("");
		btnBuscarCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Tienda.getInstance().BuscarCliente(txtCedula.getText()) != null){
					cliente =Tienda.getInstance().BuscarCliente(txtCedula.getText());
					cargarCliente(cliente) ;
					
				}else{
					JOptionPane.showMessageDialog(null, "Cliente no encontrado");
					
				}
				
			
			}
		});
		btnBuscarCedula.setIcon(new ImageIcon(CrearFactura.class.getResource("/Fotos/if_Search_858732.png")));
		btnBuscarCedula.setBounds(300, 11, 46, 37);
		panel.add(btnBuscarCedula);
		
		txtCedula = new JFormattedTextField(formato);
		txtCedula.setColumns(10);
		txtCedula.setBounds(76, 25, 199, 20);
		panel.add(txtCedula);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 50, 199, 20);
		panel.add(txtNombre);
		
		txtTelefono = new JFormattedTextField(telef);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(76, 75, 199, 20);
		panel.add(txtTelefono);
		
		txtApellido = new JTextField();
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(356, 50, 190, 20);
		panel.add(txtApellido);
		
		txtCorreo = new JTextField();
		txtCorreo.setBackground(Color.WHITE);
		txtCorreo.setEditable(false);
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
			
			JLabel lblComponente = new JLabel("# Serie:");
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
			txtCodigo.setBackground(Color.WHITE);
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(72, 22, 199, 20);
			panel_1.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtProducto = new JTextField();
			txtProducto.setBackground(Color.WHITE);
			txtProducto.setEditable(false);
			txtProducto.setColumns(10);
			txtProducto.setBounds(72, 47, 199, 20);
			panel_1.add(txtProducto);
			
			txtPrecio = new JTextField();
			txtPrecio.setBackground(Color.WHITE);
			txtPrecio.setEditable(false);
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(72, 97, 199, 20);
			panel_1.add(txtPrecio);
			
			txtModelo = new JTextField();
			txtModelo.setBackground(Color.WHITE);
			txtModelo.setEditable(false);
			txtModelo.setColumns(10);
			txtModelo.setBounds(356, 47, 190, 20);
			panel_1.add(txtModelo);
			
			txtMarca = new JTextField();
			txtMarca.setBackground(Color.WHITE);
			txtMarca.setEditable(false);
			txtMarca.setColumns(10);
			txtMarca.setBounds(72, 72, 199, 20);
			panel_1.add(txtMarca);
			
			table_comp= new JTable();
			model_comp= new DefaultTableModel();
			String[] columnComp = {"Código","Marca", "Modelo","Disponible", "Venta"};
			model_comp.setColumnIdentifiers(columnComp);
			table_comp.setModel(model_comp);
			
			btnBuscarCodigo = new JButton("");
			btnBuscarCodigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//PARA PRESENTAR UNA VENTANA CON TODOS LOS COMPONENTES
					cargarListComponentes();
					int dialogButton=0;
					int dialogResult= JOptionPane.showConfirmDialog(null,new JScrollPane(table_comp),"Elegir Componente", dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION && table_comp.getSelectedRow()!=-1){
					int fila = table_comp.getSelectedRow();
					String codigo = (String) table_comp.getModel().getValueAt(fila, 0);
					Componente c= new Componente();
					
					if(Tienda.getInstance().BuscarCodigoComponente(listaTemporal,codigo) != null){
						c=Tienda.getInstance().BuscarCodigoComponente(listaTemporal ,codigo);
						
						cargarComponente(c);
					}else{
						JOptionPane.showMessageDialog(null, "Error Con Componente Seleccionando");
					}
					
					}else{
						JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún componente");
					}
				
				
				
				
				
				
				}

				
			});
			btnBuscarCodigo.setIcon(new ImageIcon(CrearFactura.class.getResource("/Fotos/if_Search_858732.png")));
			btnBuscarCodigo.setBounds(300, 11, 46, 34);
			panel_1.add(btnBuscarCodigo);
			
			JLabel lblCantidad = new JLabel("Precio:");
			lblCantidad.setBounds(10, 100, 69, 14);
			panel_1.add(lblCantidad);
			
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(356, 72, 190, 20);
			panel_1.add(spnCantidad);
			
			JButton btnAgregarAlCarrito = new JButton("Agregar al carrito");
			btnAgregarAlCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(confirmarAgregadoACarrito()){
						String codigo= txtCodigo.getText();
						int cantidad=(int) spnCantidad.getValue();
						System.out.println("Cantidad: " +cantidad);
						
							Componente componenteSeleccionado=new Componente();
							
							componenteSeleccionado=Tienda.getInstance().BuscarCodigoComponente(listaTemporal,codigo);
							componenteSeleccionado.setCantidad(cantidad);
							System.out.println(componenteSeleccionado.getCantidad());
							listaTemporal=Tienda.getInstance().eliminarCantidadArticulo(listaTemporal,codigo,cantidad);
							System.out.println("ListaTemporal: "+listaTemporal);
							carrito.add(componenteSeleccionado);
							actualizarCarrito();
							
						
						
						
					}
					
					
				}
			});
			btnAgregarAlCarrito.setBounds(300, 100, 154, 23);
			panel_1.add(btnAgregarAlCarrito);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 290, 560, 202);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 540, 169);
		panel_1.add(scrollPane);
		
		table = new JTable();
		
		model= new DefaultTableModel();
		String[] columnComp1 = {"Código","Marca", "Modelo","Precio Unidad","Cantidad", "Precio Total"};
		model.setColumnIdentifiers(columnComp1);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(22, 576, 56, 14);
		contentPanel.add(lblSubtotal);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(217, 576, 72, 14);
		contentPanel.add(lblDescuento);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(415, 576, 46, 14);
		contentPanel.add(lblTotal);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBackground(Color.WHITE);
		txtSubTotal.setEditable(false);
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(74, 573, 114, 20);
		contentPanel.add(txtSubTotal);
		
		txtDescuento = new JTextField();
		txtDescuento.setBackground(Color.WHITE);
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(285, 573, 103, 20);
		contentPanel.add(txtDescuento);
		
		txtTotal = new JTextField();
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(460, 573, 108, 20);
		contentPanel.add(txtTotal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Descuentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 503, 560, 59);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDescuentoAplicado = new JLabel("Descuento Aplicado:");
		lblDescuentoAplicado.setBounds(10, 25, 135, 14);
		panel_2.add(lblDescuentoAplicado);
		
		 spnDescuento = new JSpinner();
		spnDescuento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(99), new Float(1)));
		spnDescuento.setBounds(155, 22, 114, 20);
		panel_2.add(spnDescuento);
		
		JButton btnAplicarDescuento = new JButton("Aplicar Descuento");
		btnAplicarDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTotales();
			
			}
		});
		btnAplicarDescuento.setBounds(279, 21, 164, 23);
		panel_2.add(btnAplicarDescuento);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVender = new JButton("Facturar");
				btnVender.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					//FACTURAR
						if(confirmarFactura()){
							int codigo= Tienda.getInstance().getMisFacturas().size()+1; 
							Date date = new Date();
							Factura factura = new Factura();
							factura.setCliente(cliente);
							factura.setCodigo(Integer.toString(codigo) );
							factura.setDescuentoAplicado((float)spnDescuento.getValue());
							factura.setMisComponentes(carrito);
							factura.setFecha(date);
							factura.setPrecioVenta(Float.parseFloat(txtTotal.getText()));
							Tienda.getInstance().setMisComponentes(listaTemporal);
							
							Tienda.getInstance().AgregarFactura(factura);
							JOptionPane.showMessageDialog(null, "Guardado con éxito");
							cleanTodo();
						}
						
						
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
	
	
	private boolean confirmarFactura() {
		if(txtNombre.getText().equalsIgnoreCase("")){
			JOptionPane.showMessageDialog(null, "Error. Debe Cargar Cliente.");
			return false;
			
		}
		if(carrito.size()==0){
			JOptionPane.showMessageDialog(null, "Error. Debe agregar al carrito al menos un artículo.");
			return false;
			
		}
				
		return true;
	}
	public void cleanTodo(){
		CleanComponente();
		CleanCliente();
		cleanCarrito();
		cleanTotales();
		spnDescuento.setValue(0);
		
		
	}
	
	
	public boolean confirmarAgregadoACarrito(){
		
		for (int i = 0; i < listaTemporal.size(); i++) {
			if(listaTemporal.get(i).getCodigo().equalsIgnoreCase(txtCodigo.getText())){
				if(listaTemporal.get(i).getCantidad()==0){
					JOptionPane.showMessageDialog(null, "No Existe Disponibilidad para este Articulo"); 
					return false;
					
				}
				
			}
		}
		
		
		if(spnCantidad.getValue().toString().equalsIgnoreCase("0")){
			JOptionPane.showMessageDialog(null, "Digite una cantidad"); 
			return false;
		}
		if(Tienda.getInstance().existeArticuloEnArreglo(carrito, txtCodigo.getText())){
			
			for (int i = 0; i < carrito.size(); i++) {
				
				if (carrito.get(i).getCodigo().equalsIgnoreCase(txtCodigo.getText())) {
					if(Tienda.getInstance().siExisteDisponibilidadSegunCantidadAComprar(listaTemporal,txtCodigo.getText(),(Integer)spnCantidad.getValue())){
						carrito.get(i).setCantidad( carrito.get(i).getCantidad() + (Integer)spnCantidad.getValue());
						return true;
						
					}else{
						JOptionPane.showMessageDialog(null, "Digite una cantidad menor"); 
						return false;
						
					}
					
					
				}
				
			}
			
		}
		

		return true;
	}
	
	
	
	public void cleanTotales(){
		txtTotal.setText("0.0");
		txtSubTotal.setText("0.0");
		txtDescuento.setText("0.0");
		
	}
	public void cleanCarrito(){
		cargarCarrito(null);
	}
	
	public void CleanComponente(){
		
		spnCantidad.setValue(0);
		txtCodigo.setText("");
		txtProducto.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtPrecio.setText("");
	}
	private void cargarComponente(Componente c){
		
		spnCantidad.setValue(1);
		txtCodigo.setText(c.getCodigo());
		txtProducto.setText(c.getNumeroSerie());
		txtMarca.setText(c.getMarca());
		txtModelo.setText(c.getModelo());
		txtPrecio.setText(Float.toString(c.getPrecioVenta()));
	}
	
	private void CleanCliente() {
		txtApellido.setText("");
		txtCedula.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtCorreo.setText("");
		cliente=null;
	}
	private void cargarCliente(Cliente c) {
		txtApellido.setText(c.getApellido());
		txtNombre.setText(c.getNombre());
		txtTelefono.setText(c.getTelefono());
		txtDireccion.setText(c.getDireccion());
		txtCorreo.setText(c.getCorreo());
		
		
	}
	
	private void actualizarCarrito(){
		cargarCarrito(carrito);
		actualizarTotales();
		
	}
	
	private void actualizarTotales(){
		float subtotal=(float) 0.0;
		for (int i = 0; i < carrito.size(); i++) {
			subtotal+=carrito.get(i).getPrecioVenta();
		}
		txtSubTotal.setText(Float.toString(subtotal));
		if(spnDescuento.getValue().toString().equalsIgnoreCase("")){
			spnDescuento.setValue((float)0.0);
		}
		float descuento=subtotal* ((float)spnDescuento.getValue()/100);
		txtDescuento.setText(Float.toString(descuento));
		float total= subtotal -descuento;
		txtTotal.setText(Float.toString(total));
		
	}
	
	private void cargarCarrito(ArrayList<Componente> comp) {
		if(comp==null){
			model.setRowCount(0);
			
		}else{
		model.setRowCount(0);
		fila=new Object[model.getColumnCount()];
		for(int i=0; i<comp.size();i++){
			fila[0]= comp.get(i).getCodigo();
			fila[1]= comp.get(i).getMarca();
			fila[2]= comp.get(i).getModelo();
			fila[3]= comp.get(i).getPrecioVenta();
			fila[4]= comp.get(i).getCantidad();
			fila[5]= Tienda.getInstance().precioTotalCantidad(comp.get(i));
			
			
			model.addRow(fila);
		}
		}
	}
	
	private void cargarListComponentes() {
		
		model_comp.setRowCount(0);
		fila=new Object[model_comp.getColumnCount()];
		System.out.println(listaTemporal);
		for(int i=0; i<listaTemporal.size();i++){
			fila[0]= listaTemporal.get(i).getCodigo();
			fila[1]= listaTemporal.get(i).getMarca();
			fila[2]= listaTemporal.get(i).getModelo();
			fila[3]= listaTemporal.get(i).getCantidad();
			fila[4]= listaTemporal.get(i).getPrecioVenta();
			
			model_comp.addRow(fila);
		}
	}
}
