package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class OrdenesCompra extends JDialog implements Serializable{

	private final JPanel contentPanel = new JPanel();
	
	private JTable table;
	private static DefaultTableModel tablamodelo;
	static Object[] fila;

	
	public OrdenesCompra() {
		
		setBounds(100, 100, 807, 485);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Orden de compra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			panel.setBounds(10, 11, 771, 386);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 30, 751, 345);
			panel.add(scrollPane);
			
			String[] columnsHeaders = {"Codigo", "Marca", "Modelo", "Cant. Disponible"};
			tablamodelo = new DefaultTableModel();
			tablamodelo.setColumnIdentifiers(columnsHeaders);
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(tablamodelo);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEliminar = new JButton("Ordenar Componentes");
				btnEliminar.setForeground(Color.BLACK);
				btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				buttonPane.add(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadtable();
	}


	private void loadtable() {
		// TODO Auto-generated method stub
		
	}
	

}
