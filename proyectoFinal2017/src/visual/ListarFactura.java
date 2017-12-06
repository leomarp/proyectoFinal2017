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
import java.awt.event.ActionEvent;

public class ListarFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private static DefaultTableModel model;
	private static Object[] fila;
	


	public ListarFactura() {
		
		 
		setTitle("Listado de Factura");
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setBounds(100, 100, 642, 417);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 614, 320);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			model = new DefaultTableModel();
			
			String[] columnNames = {"Código","Cliente","Cantidad Artículos", "Fecha","Total"};
			model.setColumnIdentifiers(columnNames);
			table.setModel(model);
			
			scrollPane.setViewportView(table);
			load() ; 
			
		
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
				JButton cancelButton = new JButton("Salir");
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

	private void load() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i<Tienda .getInstance().getMisFacturas().size();i++) {
			fila[0] =  Tienda.getInstance().getMisFacturas().get(i).getCodigo();
			fila[1] =  Tienda.getInstance().getMisFacturas().get(i).getCliente().getNombre() +" " +Tienda.getInstance().getMisFacturas().get(i).getCliente().getApellido();
			fila[2] =  Tienda.getInstance().getMisFacturas().get(i).getMisComponentes().size();
			fila[3] =  Tienda.getInstance().getMisFacturas().get(i).getFecha();
			fila[4] =  Tienda.getInstance().getMisFacturas().get(i).getPrecioVenta();
			
			model.addRow(fila);
		}
	}
	
	

}