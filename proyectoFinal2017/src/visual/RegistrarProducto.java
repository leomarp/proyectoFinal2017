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

import logic.Componente;
import logic.DiscoDuro;
import logic.MemoriaRam;
import logic.Procesador;
import logic.TarjetaMadre;
import logic.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Font;

public class RegistrarProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtCodigo;
	private JTextField txtNumerodeSerie;
	private JTextField txtPrecioCompra;
	private JTextField txtPrecioVenta;
    private JPanel panelMemoriaRam ;
    private JPanel panelDiscoDuro;
    private JPanel panelTarjetaMadre;
    private JPanel panelMicroprocesador;
    private JComboBox cbxTipoSoketTarjetaMadre;
    private JComboBox cbxCapacidadRam;
    private JComboBox cbxVelocidadRam ;
    private JComboBox cbxTipoRam;
    private JComboBox cbxCapacidadDiscoDuro;
    private JComboBox cbxVelocidadDiscoDuro;
    private JComboBox cbxTipoConexionDiscoDuro;
    private JComboBox cbxTipoSoketMicroProcesador;
    private JComboBox cbxVelocidadMicroProcesador;
    private JComboBox cbxTipoConexionTarjetaMadre;
    private JComboBox cbxTipoRamTarjetaMadre;
    private JComboBox cbxTipodeProducto;
    private JSpinner spnCantidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarProducto dialog = new RegistrarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarProducto() {
		setTitle("Registrar productos");
		setResizable(false);
		setBounds(100, 100, 488, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		       
		       panelTarjetaMadre = new JPanel();
		       panelTarjetaMadre.setBorder(new TitledBorder(null, "Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		       panelTarjetaMadre.setBounds(10, 224, 462, 143);
		       contentPanel.add(panelTarjetaMadre);
		       panelTarjetaMadre.setLayout(null);
		       panelTarjetaMadre.setVisible(true);
		       
		       JLabel lblTipoDeconector = new JLabel("Tipo de Conector:");
		       lblTipoDeconector.setBounds(10, 33, 109, 14);
		       panelTarjetaMadre.add(lblTipoDeconector);
		       
		        cbxTipoConexionTarjetaMadre = new JComboBox();
		        cbxTipoConexionTarjetaMadre.setModel(new DefaultComboBoxModel(new String[] {"", "AX", "AT", "ATX", "ITX", "BTX", "DTX"}));
		        cbxTipoConexionTarjetaMadre.setBounds(129, 30, 103, 20);
		        panelTarjetaMadre.add(cbxTipoConexionTarjetaMadre);
		        
		        JLabel lblTipoDeRam = new JLabel("Tipo de Ram:");
		        lblTipoDeRam.setBounds(10, 72, 81, 14);
		        panelTarjetaMadre.add(lblTipoDeRam);
		        
		         cbxTipoRamTarjetaMadre = new JComboBox();
		         cbxTipoRamTarjetaMadre.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3"}));
		         cbxTipoRamTarjetaMadre.setBounds(129, 69, 103, 20);
		         panelTarjetaMadre.add(cbxTipoRamTarjetaMadre);
		         
		         JLabel lblTipoDeSoket = new JLabel("Tipo de Soket:");
		         lblTipoDeSoket.setBounds(10, 115, 81, 14);
		         panelTarjetaMadre.add(lblTipoDeSoket);
		         
		         cbxTipoSoketTarjetaMadre = new JComboBox();
		         cbxTipoSoketTarjetaMadre.setModel(new DefaultComboBoxModel(new String[] {"", "PGA", "BGA", "LGA"}));
		         cbxTipoSoketTarjetaMadre.setBounds(129, 112, 103, 20);
		         panelTarjetaMadre.add(cbxTipoSoketTarjetaMadre);
		      
		       panelMicroprocesador = new JPanel();
		       panelMicroprocesador.setBorder(new TitledBorder(null, "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		       panelMicroprocesador.setBounds(10, 224, 462, 143);
		       contentPanel.add(panelMicroprocesador);
		       panelMicroprocesador.setLayout(null);
		       panelMicroprocesador.setVisible(false);
		       
		       JLabel lblTipoDeSoket_1 = new JLabel("Tipo de Soket:");
		       lblTipoDeSoket_1.setBounds(10, 41, 82, 14);
		       panelMicroprocesador.add(lblTipoDeSoket_1);
		       
		        cbxTipoSoketMicroProcesador = new JComboBox();
		        cbxTipoSoketMicroProcesador.setModel(new DefaultComboBoxModel(new String[] {"", "Socket 423", "Socket 479", "Socket 754", "Socket A"}));
		        cbxTipoSoketMicroProcesador.setBounds(100, 38, 98, 20);
		        panelMicroprocesador.add(cbxTipoSoketMicroProcesador);
		        
		        JLabel lblVelocidad = new JLabel("Velocidad:");
		        lblVelocidad.setBounds(10, 93, 75, 14);
		        panelMicroprocesador.add(lblVelocidad);
		        
		         cbxVelocidadMicroProcesador = new JComboBox();
		         cbxVelocidadMicroProcesador.setModel(new DefaultComboBoxModel(new String[] {"", "1.8GHZ", "2.4GHZ", "3.0GHZ"}));
		         cbxVelocidadMicroProcesador.setBounds(100, 90, 98, 20);
		         panelMicroprocesador.add(cbxVelocidadMicroProcesador);
		     
		      panelDiscoDuro = new JPanel();
		      panelDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		      panelDiscoDuro.setBounds(10, 224, 462, 143);
		      contentPanel.add(panelDiscoDuro);
		      panelDiscoDuro.setLayout(null);
		      panelDiscoDuro.setVisible(false);
		      
		      JLabel lblCapacidad = new JLabel("Capacidad:");
		      lblCapacidad.setBounds(10, 28, 69, 14);
		      panelDiscoDuro.add(lblCapacidad);
		      
		       cbxCapacidadDiscoDuro = new JComboBox();
		       cbxCapacidadDiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"", "80GB", "120GB", "250GB", "500GB", "600GB", "1TB", "2TB"}));
		       cbxCapacidadDiscoDuro.setBounds(126, 25, 86, 20);
		       panelDiscoDuro.add(cbxCapacidadDiscoDuro);
		       
		       JLabel lblTipoDeConexion = new JLabel("Tipo de Conexion:");
		       lblTipoDeConexion.setBounds(10, 65, 109, 14);
		       panelDiscoDuro.add(lblTipoDeConexion);
		       
		        cbxTipoConexionDiscoDuro = new JComboBox();
		        cbxTipoConexionDiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"", "IDE", "SATA", "SCSI", "SAS"}));
		        cbxTipoConexionDiscoDuro.setBounds(126, 62, 86, 20);
		        panelDiscoDuro.add(cbxTipoConexionDiscoDuro);
		        
		        JLabel lblVelocidadrpm = new JLabel("Velocidad(RPM):");
		        lblVelocidadrpm.setBounds(10, 105, 97, 14);
		        panelDiscoDuro.add(lblVelocidadrpm);
		        
		         cbxVelocidadDiscoDuro = new JComboBox();
		         cbxVelocidadDiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"", "5,400 (RPM) ", "7,200 (RPM)"}));
		         cbxVelocidadDiscoDuro.setBounds(126, 102, 86, 20);
		         panelDiscoDuro.add(cbxVelocidadDiscoDuro);
		    
		     panelMemoriaRam = new JPanel();
		     panelMemoriaRam.setBorder(new TitledBorder(null, "Memoria Ram", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		     panelMemoriaRam.setBounds(10, 224, 462, 143);
		     contentPanel.add(panelMemoriaRam);
		     panelMemoriaRam.setLayout(null);
		     panelMemoriaRam.setVisible(false);
		     
		     JLabel lblCantidad_1 = new JLabel("Capacidad:");
		     lblCantidad_1.setBounds(10, 31, 67, 14);
		     panelMemoriaRam.add(lblCantidad_1);
		     
		      cbxCapacidadRam = new JComboBox();
		      cbxCapacidadRam.setModel(new DefaultComboBoxModel(new String[] {"", "1GB", "2GB", "4GB", "8GB", "16GB"}));
		     cbxCapacidadRam.setBounds(111, 28, 77, 20);
		     panelMemoriaRam.add(cbxCapacidadRam);
		     
		     JLabel lblVelocidad_1 = new JLabel("Velocidad(MHZ):");
		     lblVelocidad_1.setBounds(10, 71, 99, 14);
		     panelMemoriaRam.add(lblVelocidad_1);
		     
		     cbxVelocidadRam = new JComboBox();
		     cbxVelocidadRam.setModel(new DefaultComboBoxModel(new String[] {"", "400MHZ", "1066MHZ", "2400MHZ", "3000MHZ"}));
		     cbxVelocidadRam.setBounds(111, 68, 77, 20);
		     panelMemoriaRam.add(cbxVelocidadRam);
		     
		     JLabel lblTipo = new JLabel("Tipo:");
		     lblTipo.setBounds(10, 107, 46, 14);
		     panelMemoriaRam.add(lblTipo);
		     
		      cbxTipoRam = new JComboBox();
		      cbxTipoRam.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR2", "DDR3"}));
		     cbxTipoRam.setBounds(111, 104, 77, 20);
		     panelMemoriaRam.add(cbxTipoRam);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(11, 132, 46, 14);
		contentPanel.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(67, 129, 86, 20);
		contentPanel.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 83, 46, 14);
		contentPanel.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(67, 80, 86, 20);
		contentPanel.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 36, 46, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 33, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNumeroDeSerie = new JLabel("Numero de Serie:");
		lblNumeroDeSerie.setBounds(224, 36, 104, 14);
		contentPanel.add(lblNumeroDeSerie);
		
		txtNumerodeSerie = new JTextField();
		txtNumerodeSerie.setBounds(326, 33, 86, 20);
		contentPanel.add(txtNumerodeSerie);
		txtNumerodeSerie.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 180, 65, 14);
		contentPanel.add(lblCantidad);
		
		 spnCantidad = new JSpinner();
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidad.setBounds(67, 177, 86, 20);
		contentPanel.add(spnCantidad);
		
		JLabel lblPrecioCompra = new JLabel("Precio Compra:");
		lblPrecioCompra.setBounds(224, 83, 94, 14);
		contentPanel.add(lblPrecioCompra);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setBounds(326, 80, 86, 20);
		contentPanel.add(txtPrecioCompra);
		txtPrecioCompra.setColumns(10);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta:");
		lblPrecioVenta.setBounds(224, 132, 78, 14);
		contentPanel.add(lblPrecioVenta);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setBounds(326, 129, 86, 20);
		contentPanel.add(txtPrecioVenta);
		txtPrecioVenta.setColumns(10);
		
		JLabel lblTipoDeProducto = new JLabel("Tipo de Producto:");
		lblTipoDeProducto.setBounds(224, 180, 104, 14);
		contentPanel.add(lblTipoDeProducto);
		
		 cbxTipodeProducto = new JComboBox();
		cbxTipodeProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Tarjeta Madre")) {
					panelDiscoDuro.setVisible(false);
					panelMemoriaRam.setVisible(false);
					panelMicroprocesador.setVisible(false);
					panelTarjetaMadre.setVisible(true);
							
					
				}
				if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Memoria Ram")) {
					panelDiscoDuro.setVisible(false);
					panelMemoriaRam.setVisible(true);
					panelMicroprocesador.setVisible(false);
					panelTarjetaMadre.setVisible(false);
							
					
				}
				if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Disco Duro")) {
					panelDiscoDuro.setVisible(true);
					panelMemoriaRam.setVisible(false);
					panelMicroprocesador.setVisible(false);
					panelTarjetaMadre.setVisible(false);
							
					
				}
				if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Microprocesador")) {
					panelDiscoDuro.setVisible(false);
					panelMemoriaRam.setVisible(false);
					panelMicroprocesador.setVisible(true);
					panelTarjetaMadre.setVisible(false);
							
					
				}
				if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
					panelDiscoDuro.setVisible(false);
					panelMemoriaRam.setVisible(false);
					panelMicroprocesador.setVisible(false);
					panelTarjetaMadre.setVisible(false);
							
					
				}
				
				
			}
		});
		cbxTipodeProducto.setModel(new DefaultComboBoxModel(new String[] {"", "Tarjeta Madre", "Microprocesador", "Memoria Ram", "Disco Duro"}));
		cbxTipodeProducto.setBounds(326, 177, 126, 20);
		contentPanel.add(cbxTipodeProducto);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtMarca.getText().equalsIgnoreCase("") && !txtModelo.getText().equalsIgnoreCase("") && !txtPrecioCompra.getText().equalsIgnoreCase("") 
								&& !txtPrecioVenta.getText().equalsIgnoreCase("") && !txtNumerodeSerie.getText().equalsIgnoreCase("") && cbxTipodeProducto.getSelectedIndex()!=0 ) {
							if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("")) {
								JOptionPane.showMessageDialog(null, "Favor completar todos los parametros",null, JOptionPane.WARNING_MESSAGE,null);  
							}
							/*String marca = txtMarca.getText();
							String modelo = txtModelo.getText();
							float preciocompra = Float.parseFloat(txtPrecioCompra.getText().toString());
							float precioventa = Float.parseFloat(txtPrecioVenta.getText().toString());
							String numeroserie = txtNumerodeSerie.getText();
							Integer cantidad = Integer.parseInt(spnCantidad.getValue().toString());*/ 
							
							if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Tarjeta Madre")) {
								if(cbxTipoConexionTarjetaMadre.getSelectedIndex()!=0 && cbxTipoRamTarjetaMadre.getSelectedIndex()!=0 && cbxTipoSoketTarjetaMadre.getSelectedIndex()!=0) {
									/*String tipoconexion = cbxTipoConexionTarjetaMadre.getSelectedItem().toString();
									String tiporam = cbxTipoRamTarjetaMadre.getSelectedItem().toString();
									String tiposocket = cbxTipoSoketTarjetaMadre.getSelectedItem().toString();*/
									//Componente componente=new Componente();
									TarjetaMadre tarjeta=new TarjetaMadre();
									tarjeta.setCantidad(Integer.parseInt(spnCantidad.getValue().toString()));
									tarjeta.setCodigo(txtCodigo.getText());
									tarjeta.setModelo(txtModelo.getText());
									tarjeta.setMarca(txtMarca.getText());
									tarjeta.setNumeroSerie(txtNumerodeSerie.getText());
									tarjeta.setPrecioCompra(Float.parseFloat(txtPrecioCompra.getText().toString()));
									tarjeta.setPrecioVenta(Float.parseFloat(txtPrecioVenta.getText().toString()));
									tarjeta.setTipoConector(cbxTipoConexionTarjetaMadre.getSelectedItem().toString());
									tarjeta.setTipoRam(cbxTipoRamTarjetaMadre.getSelectedItem().toString());
									tarjeta.setTipoSocket(cbxTipoSoketTarjetaMadre.getSelectedItem().toString());
									
									Tienda.getInstance().AgregarComponentes(tarjeta);
									JOptionPane.showMessageDialog(null, "Datos Registrados",null, JOptionPane.INFORMATION_MESSAGE,null);
									//CleanTarjetaMadre();
									CleanCompleto();
								}else { JOptionPane.showMessageDialog(null, "Favor completar todos los parametros",null, JOptionPane.WARNING_MESSAGE,null);  }
								
								
							}
							if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Disco Duro")) {
								if(cbxCapacidadDiscoDuro.getSelectedIndex()!=0 && cbxTipoConexionDiscoDuro.getSelectedIndex()!=0 
										&& cbxVelocidadDiscoDuro.getSelectedIndex()!=0 ) {
									DiscoDuro disco=new DiscoDuro();
									disco.setCantidad(Integer.parseInt(spnCantidad.getValue().toString()));
									disco.setCodigo(txtCodigo.getText());
									disco.setModelo(txtModelo.getText());
									disco.setMarca(txtMarca.getText());
									disco.setNumeroSerie(txtNumerodeSerie.getText());
									disco.setPrecioCompra(Float.parseFloat(txtPrecioCompra.getText().toString()));
									disco.setPrecioVenta(Float.parseFloat(txtPrecioVenta.getText().toString()));
									disco.setCapacidad(cbxCapacidadDiscoDuro.getSelectedItem().toString());
									disco.setTipoConexion(cbxTipoConexionDiscoDuro.getSelectedItem().toString());
									disco.setVelocidad(cbxVelocidadDiscoDuro.getSelectedItem().toString());
									
									Tienda.getInstance().AgregarComponentes(disco);
									JOptionPane.showMessageDialog(null, "Datos Registrados",null, JOptionPane.INFORMATION_MESSAGE,null);
									//CleanDiscoDuro();
									CleanCompleto();
								}else {JOptionPane.showMessageDialog(null, "Favor completar todos los parametros",null, JOptionPane.WARNING_MESSAGE,null);  }
								
								
							}
								
							
							
							
							if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Microprocesador")) {
								if(cbxTipoSoketMicroProcesador.getSelectedIndex()!=0 && cbxVelocidadMicroProcesador.getSelectedIndex()!=0) {
									Procesador procesador=new Procesador();
									procesador.setCantidad(Integer.parseInt(spnCantidad.getValue().toString()));
									procesador.setCodigo(txtCodigo.getText());
									procesador.setModelo(txtModelo.getText());
									procesador.setMarca(txtMarca.getText());
									procesador.setNumeroSerie(txtNumerodeSerie.getText());
									procesador.setPrecioCompra(Float.parseFloat(txtPrecioCompra.getText().toString()));
									procesador.setPrecioVenta(Float.parseFloat(txtPrecioVenta.getText().toString()));
									procesador.setVelocidad(cbxVelocidadMicroProcesador.getSelectedItem().toString());
									procesador.setTipoSocket(cbxTipoSoketMicroProcesador.getSelectedItem().toString());
																													
									
									Tienda.getInstance().AgregarComponentes(procesador);
									JOptionPane.showMessageDialog(null, "Datos Registrados",null, JOptionPane.INFORMATION_MESSAGE,null);
									//CleanMicroprocesador();
									CleanCompleto();
								}else {JOptionPane.showMessageDialog(null, "Favor completar todos los parametros",null, JOptionPane.WARNING_MESSAGE,null);  }
								
								
								
							}
							
							if(cbxTipodeProducto.getSelectedItem().toString().equalsIgnoreCase("Memoria Ram")) {
								if(cbxCapacidadRam.getSelectedIndex()!=0 && cbxVelocidadRam.getSelectedIndex()!=0
										&& cbxTipoRam.getSelectedIndex()!=0) {
									MemoriaRam memoria=new MemoriaRam();
									memoria.setCantidad(Integer.parseInt(spnCantidad.getValue().toString()));
									memoria.setCodigo(txtCodigo.getText());
									memoria.setModelo(txtModelo.getText());
									memoria.setMarca(txtMarca.getText());
									memoria.setNumeroSerie(txtNumerodeSerie.getText());
									memoria.setPrecioCompra(Float.parseFloat(txtPrecioCompra.getText().toString()));
									memoria.setPrecioVenta(Float.parseFloat(txtPrecioVenta.getText().toString()));
									memoria.setTipo(cbxTipoRam.getSelectedItem().toString());
									memoria.setVelocidad(cbxVelocidadRam.getSelectedItem().toString());
									memoria.setCapacidad(cbxCapacidadRam.getSelectedItem().toString());
									
									Tienda.getInstance().AgregarComponentes(memoria);
									JOptionPane.showMessageDialog(null, "Datos Registrados",null, JOptionPane.INFORMATION_MESSAGE,null);
									//CleanMemoriRam();
									CleanCompleto();
								}else {JOptionPane.showMessageDialog(null, "Favor completar todos los parametros",null, JOptionPane.WARNING_MESSAGE,null);  }
							}
							
							
							
							
							
							
						}else {JOptionPane.showMessageDialog(null, "Favor completar todos los parametros",null, JOptionPane.WARNING_MESSAGE,null);  }
						
						
						
						
						
						
						
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
	
	
	
	
	
	public void CleanCompleto() {
		
		
		txtCodigo.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtNumerodeSerie.setText("");
		txtPrecioCompra.setText("");
		txtPrecioVenta.setText("");
		cbxTipodeProducto.setSelectedIndex(0);
		cbxVelocidadMicroProcesador.setSelectedIndex(0);
		cbxTipoSoketMicroProcesador.setSelectedIndex(0);
		spnCantidad.setValue(1);
		cbxTipoConexionTarjetaMadre.setSelectedIndex(0);
		cbxTipoRamTarjetaMadre.setSelectedIndex(0);
		cbxTipoSoketTarjetaMadre.setSelectedIndex(0);
		cbxCapacidadDiscoDuro.setSelectedIndex(0);
		cbxVelocidadDiscoDuro.setSelectedIndex(0);
		cbxTipoConexionDiscoDuro.setSelectedIndex(0);
		cbxCapacidadRam.setSelectedIndex(0);
		
		cbxTipoRam.setSelectedIndex(0);
		
		cbxVelocidadRam.setSelectedIndex(0);
	}
}
