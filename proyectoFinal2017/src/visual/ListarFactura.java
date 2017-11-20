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
	public ListarFactura() {
		
		 
		setTitle("Listado de Factura");
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
				String[] columnNames = {"Codigo","Cliente", "Fecha", "Precio",""};
				model.setColumnIdentifiers(columnNames);
				table_1 = new JTable();									
				table_1.setEnabled(false);
				table_1.setModel(model);
				loadVehiculo() ; 
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

	private void loadVehiculo() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i<Tienda .getInstance().getMisClientes().size();i++) {
			fila[0] =  Tienda.getInstance().getMisFacturas().get(i).getCodigo();
			fila[1] =  Tienda.getInstance().getMisFacturas().get(i).getCliente();
			fila[2] =  Tienda.getInstance().getMisFacturas().get(i).getFecha();
			fila[3] =  Tienda.getInstance().getMisFacturas().get(i).getPrecioVenta();
			//fila[4] =  Tienda.getInstance().getMisFacturas().get(i).getDireccion();			
			//fila[5] =  Tienda.getInstance().getMisFacturas().get(i).getCorreo();
			model.addRow(fila);
		}
	}
	
	

}