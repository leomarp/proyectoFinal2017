package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logic.Combo;
import logic.Componente;
import logic.Tienda;
import javax.swing.DefaultComboBoxModel;



public class Combos extends JDialog implements Serializable{
	

	private ArrayList<Componente>miscomponentes;
	private static DefaultTableModel modelComponentes,modelCombos,modelTodoscombos;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreCombo;
	private JTable tableComboTodos;
	private JTable tableComponentes;
	private JTable tableComboNew;
	static Object[] fila;
	private ArrayList<Componente>miscombos;
	private JComboBox<String> cbxCombos;
	
	
	public Combos() {
		setTitle("Combos");
		setResizable(false);
		setBounds(100, 100, 881, 607);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Combo PC Parts", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		miscombos = new ArrayList<Componente>();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Combos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 268, 859, 237);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCombos = new JLabel("Combos:");
		lblCombos.setBounds(10, 31, 52, 14);
		panel.add(lblCombos);
		
		cbxCombos = new JComboBox();
		cbxCombos.setBounds(58, 28, 138, 20);
		panel.add(cbxCombos);
		cargarCombosComboBox();
		
		JScrollPane scrollComboTodos = new JScrollPane();
		scrollComboTodos.setBounds(10, 69, 839, 152);
		panel.add(scrollComboTodos);
		
		tableComboTodos = new JTable();
		modelTodoscombos = new DefaultTableModel();
		
		String[] columnNames = {"Tipo","Codigo","Marca", "Modelo", "P.Venta"};
		modelTodoscombos.setColumnIdentifiers(columnNames);
		tableComboTodos.setModel(modelTodoscombos);
		
		scrollComboTodos.setViewportView(tableComboTodos);
		int index=cbxCombos.getSelectedIndex();
		CargarComponentes(modelTodoscombos,Tienda.getInstance().getComboComponentes(index));
		
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(cbxCombos.getSelectedIndex()!=0){
					int index=cbxCombos.getSelectedIndex();
					System.out.println("Index:" +index);
//					System.out.println(cbxCombos.getSelectedItem().toString());
					System.out.println("elementos del combo" +Tienda.getInstance().getComboComponentes(index) );
					CargarComponentes(modelTodoscombos,Tienda.getInstance().getComboComponentes(index) );
				}
			
			}
		});
		btnCargar.setBounds(206, 27, 89, 23);
		panel.add(btnCargar);
		
		JLabel lblNombreDelCombo = new JLabel("Nombre del Combo:");
		lblNombreDelCombo.setBounds(10, 30, 145, 14);
		contentPanel.add(lblNombreDelCombo);
		
		txtNombreCombo = new JTextField();
		txtNombreCombo.setBounds(133, 27, 145, 20);
		contentPanel.add(txtNombreCombo);
		txtNombreCombo.setColumns(10);
		
		
		JButton buttonseleccion = new JButton(">");
		buttonseleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row=tableComponentes.getSelectedRow();
				
				if(row!=-1){
					//Agregar compnente a la tabla de nuevos componentes de nuevo combo. 
					Componente c = Tienda.getInstance().getMisComponentes().get(row);
					miscombos.add(c);
					CargarComponentes(modelCombos,miscombos);
				}
				
				
			}
		});
		buttonseleccion.setBounds(385, 117, 104, 23);
		contentPanel.add(buttonseleccion);
		
		JButton btnCrearCombo = new JButton("Crear Combo");
		btnCrearCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(txtNombreCombo.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Escriba un nombre para el Combo");
				
			}else{
				if(miscombos.size()==0  ){
					JOptionPane.showMessageDialog(null, "Añadir Componentes a la nueva tabla.");
					
				}
				else if(Tienda.getInstance().existeCombo(txtNombreCombo.getText())){
					JOptionPane.showMessageDialog(null, "Seleccione otro nombre para el combo");
					
				}
				else{
				Combo co=new Combo();
				
				co.setNombre(txtNombreCombo.getText() );
				co.setMiCombo(miscombos);
				
				Tienda.getInstance().AgregarCombo(co);
				miscombos.clear();
				cargarCombosComboBox();
				JOptionPane.showMessageDialog(null, "Combo Creado Exitosamente");
				CargarComponentes(modelCombos,null);
				}
			}
			
			}
				
		});
				
				
		
		btnCrearCombo.setBounds(374, 164, 125, 23);
		contentPanel.add(btnCrearCombo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 58, 362, 199);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JScrollPane scrollPaneComponentes = new JScrollPane();
		scrollPaneComponentes.setBounds(10, 11, 342, 174);
		panel_1.add(scrollPaneComponentes);
		
		tableComponentes = new JTable();
		modelComponentes=new DefaultTableModel();
		String[] columnNames1 = {"Tipo","Codigo","Marca", "Modelo", "P.Venta"};
		modelComponentes.setColumnIdentifiers(columnNames1);
		tableComponentes.setModel(modelComponentes);
		scrollPaneComponentes.setViewportView(tableComponentes);
		CargarComponentes(modelComponentes,Tienda.getInstance().getMisComponentes());
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(503, 58, 362, 199);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollComboNew = new JScrollPane();
		scrollComboNew.setBounds(10, 11, 342, 174);
		panel_2.add(scrollComboNew);
		
		tableComboNew = new JTable();
		modelCombos=new DefaultTableModel();
		String[] columnNames2 = {"Tipo","Codigo","Marca", "Modelo", "P.Venta"};
		modelCombos.setColumnIdentifiers(columnNames2);
		tableComboNew.setModel(modelCombos);
		scrollComboNew.setViewportView(tableComboNew);
		
		
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnSeleccionarCombo = new JButton("Seleccionar Combo");
			btnSeleccionarCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbxCombos.getSelectedIndex()>0) {
						
					
					}
				}
			});
			buttonPane.add(btnSeleccionarCombo);
			{
				JButton ButtonGuardar = new JButton("Guardar");
				ButtonGuardar.setActionCommand("OK");
				buttonPane.add(ButtonGuardar);
				getRootPane().setDefaultButton(ButtonGuardar);
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
	
	
	
	private void cargarCombosComboBox(){
		cbxCombos.removeAllItems();
		
		
		for (int i = 0; i < Tienda.getInstance().getMisCombos().size(); i++) {
			cbxCombos.addItem(Tienda.getInstance().getMisCombos().get(i).getNombre() );	
		}
		
	}
	
	
private void CargarComponentes(DefaultTableModel model,ArrayList<Componente> c) {
		if(c==null){
			System.out.println(c);
			model.setRowCount(0);
		}else{
			System.out.println("entra a cargar el array");
			System.out.println(c);
			model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i=0;i<c.size() ;i++){
			fila[0] =  Tienda.getInstance().tipoDeComponente(c.get(i) );
			fila[1]=  c.get(i).getCodigo();
			fila[2] = c.get(i).getMarca();
			fila[3] = c.get(i).getModelo();	
			fila[4] = c.get(i).getPrecioVenta();
			model.addRow(fila);	
		}
		}

}






}
