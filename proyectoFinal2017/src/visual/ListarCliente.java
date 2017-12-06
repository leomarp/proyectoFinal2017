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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Tienda;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class ListarCliente extends JDialog implements Serializable{

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
	public ListarCliente() {
		
		 
		setTitle("Listado de Cliente");
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setBounds(100, 100, 670, 417);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 644, 316);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setEnabled(false);
				scrollPane.setViewportView(table);
				model = new DefaultTableModel();
				String[] columnNames = {"Cedula","Nombre", "Apellido", "Telefono", "Direccion","Correo"};
				model.setColumnIdentifiers(columnNames);
				table_1 = new JTable();									
				table_1.setEnabled(false);
				table_1.setModel(model);
				loadCliente() ; 
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

	private void loadCliente() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i<Tienda .getInstance().getMisClientes().size();i++) {
			fila[0] =  Tienda.getInstance().getMisClientes().get(i).getCedula();
			fila[1] =  Tienda.getInstance().getMisClientes().get(i).getNombre();
			fila[2] =  Tienda.getInstance().getMisClientes().get(i).getApellido();
			fila[3] =  Tienda.getInstance().getMisClientes().get(i).getTelefono();
			fila[4] =  Tienda.getInstance().getMisClientes().get(i).getDireccion();
			
			fila[5] =  Tienda.getInstance().getMisClientes().get(i).getCorreo();
			model.addRow(fila);
		}
	}
	
	

}