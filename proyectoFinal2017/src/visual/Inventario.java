package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.Component;

import logic.Cliente;
import logic.Componente;
import logic.DiscoDuro;
import logic.MemoriaRam;
import logic.Procesador;
import logic.TarjetaMadre;
import logic.Tienda;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Inventario extends JDialog {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static JTable table_1;
	private static DefaultTableModel model;
	private static Object[] fila;
	private JComboBox cbxTipo ;
	

	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			ListaCuenta dialog = new ListaCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Inventario() {
		
		 
		setTitle("Inventario");
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setBounds(100, 100, 642, 417);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 34, 614, 304);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setEnabled(false);
				scrollPane.setViewportView(table);
				model = new DefaultTableModel();
				String[] columnNames = {"Codigo","Marca", "Modelo", "P.Compra", "P.Venta","Cantidad"};
				model.setColumnIdentifiers(columnNames);
				table_1 = new JTable();									
				table_1.setEnabled(false);
				table_1.setModel(model);
				loadInventario() ; 
				scrollPane.setViewportView(table_1);
			}
		}
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(396, 9, 46, 21);
		contentPanel.add(lblTipo);
		
		cbxTipo = new JComboBox();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero= cbxTipo.getSelectedIndex();
				loadTipo(numero);
			}

			
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Disco Duro", "Mamoria Ram", "Microprecesador", "Tarjeta Madre"}));
		cbxTipo.setBounds(452, 9, 91, 21);
		contentPanel.add(cbxTipo);
		{
			JLabel label = new JLabel("");
			
			label.setBounds(0, 0, 636, 355);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

	private void loadInventario() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i< Tienda.getInstance().getMisComponentes().size();i++) {
			fila[0] =  Tienda.getInstance().getMisComponentes().get(i).getCodigo();
			fila[1] =  Tienda.getInstance().getMisComponentes().get(i).getMarca();
			fila[2] =  Tienda.getInstance().getMisComponentes().get(i).getModelo();
			fila[3] =  Tienda.getInstance().getMisComponentes().get(i).getPrecioCompra();
			fila[4] =  Tienda.getInstance().getMisComponentes().get(i).getPrecioVenta();
			fila[5] =  Tienda.getInstance().getMisComponentes().get(i).getCantidad();
			
			model.addRow(fila);
		}
	}
	private void loadTipo(int num) {
		model.setRowCount(0);
		/*DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);*/
		fila = new Object[model.getColumnCount()];
switch (num) {
case 0:
	for (Componente comp : Tienda.getInstance().getMisComponentes()) {

		if(comp instanceof DiscoDuro){
		fila[0] =  comp.getCodigo();
		fila[1] =  comp.getMarca();
		fila[2] =  comp.getModelo();
		fila[3] =  comp.getPrecioCompra();
		fila[4] =  comp.getPrecioVenta();
		fila[5] =  comp.getCantidad();
		
		model.addRow(fila);
		}
	}
	
	break;
case 1:
	for (Componente comp : Tienda.getInstance().getMisComponentes()) {

		if(comp instanceof DiscoDuro){
		fila[0] =  comp.getCodigo();
		fila[1] =  comp.getMarca();
		fila[2] =  comp.getModelo();
		fila[3] =  comp.getPrecioCompra();
		fila[4] =  comp.getPrecioVenta();
		fila[5] =  comp.getCantidad();
		
		model.addRow(fila);
		}
	}
	break;
case 2:
	for (Componente comp : Tienda.getInstance().getMisComponentes()) {

		if(comp instanceof MemoriaRam){
		fila[0] =  comp.getCodigo();
		fila[1] =  comp.getMarca();
		fila[2] =  comp.getModelo();
		fila[3] =  comp.getPrecioCompra();
		fila[4] =  comp.getPrecioVenta();
		fila[5] =  comp.getCantidad();
		
		model.addRow(fila);
		}
	}
	break;
case 3:
	for (Componente comp : Tienda.getInstance().getMisComponentes()) {

		if(comp instanceof Procesador){
		fila[0] =  comp.getCodigo();
		fila[1] =  comp.getMarca();
		fila[2] =  comp.getModelo();
		fila[3] =  comp.getPrecioCompra();
		fila[4] =  comp.getPrecioVenta();
		fila[5] =  comp.getCantidad();
		
		model.addRow(fila);
		}
	}
	break;
case 4:
	for (Componente comp : Tienda.getInstance().getMisComponentes()) {

		if(comp instanceof TarjetaMadre){
		fila[0] =  comp.getCodigo();
		fila[1] =  comp.getMarca();
		fila[2] =  comp.getModelo();
		fila[3] =  comp.getPrecioCompra();
		fila[4] =  comp.getPrecioVenta();
		fila[5] =  comp.getCantidad();
		
		model.addRow(fila);
		}
	}
	break;

default:
	break;
}
	}	
}