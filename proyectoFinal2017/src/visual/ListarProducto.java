package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Tienda;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class ListarProducto extends JDialog implements Serializable{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private static DefaultTableModel model;
	private static Object[] fila;
	

	public ListarProducto() {
		
		 
		setTitle("Listado de Productos");
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
			scrollPane.setBounds(10, 11, 614, 327);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setEnabled(false);
				scrollPane.setViewportView(table);
				model = new DefaultTableModel();
				String[] columnNames = {"Tipo","Codigo","Marca", "Modelo", "Numero de serie","Cantidad","Precio Compra","Precio Venta"};
				model.setColumnIdentifiers(columnNames);
				table_1 = new JTable();									
				table_1.setEnabled(false);
				table_1.setModel(model);
				loadProductos(); 
				scrollPane.setViewportView(table_1);
			}
		}
		{
			JLabel label = new JLabel("");
			
			label.setBounds(0, 0, 691, 427);
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

	private void loadProductos() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i<Tienda .getInstance().getMisComponentes().size();i++) {
			
			fila[0] =  Tienda.getInstance().tipoDeComponente(Tienda.getInstance().getMisComponentes().get(i) );
			
			fila[1] =  Tienda.getInstance().getMisComponentes().get(i).getCodigo();
			fila[2] =  Tienda.getInstance().getMisComponentes().get(i).getMarca();
			fila[3] =  Tienda.getInstance().getMisComponentes().get(i).getModelo();
			fila[4] =  Tienda.getInstance().getMisComponentes().get(i).getNumeroSerie();
			fila[5] =  Tienda.getInstance().getMisComponentes().get(i).getCantidad();			
			fila[6] =  Tienda.getInstance().getMisComponentes().get(i).getPrecioCompra();
			fila[7] =  Tienda.getInstance().getMisComponentes().get(i).getPrecioVenta();
			model.addRow(fila);
		}
	}
	
	

}
