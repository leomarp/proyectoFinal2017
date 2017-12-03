package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import logic.Componente;
import logic.Tienda;
import javax.swing.DefaultComboBoxModel;



public class Combos extends JDialog {
	

	private ArrayList<Componente>miscomponentes;
	private static DefaultTableModel modelComboCreado;
	private static DefaultTableModel modelTodo,modelCombo;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtNombreCombo;
	private JTextField txtNumeroCombo;
	private JTable tableDeCombos;
	private JTable tableComponentes;
	private JTable tableCombosPorCrear;
	static Object[] fila;
	private ArrayList<Componente>miscombos;
	private JComboBox<String> cbxCombos;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Combos dialog = new Combos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Combos() {
		setTitle("Combos");
		setResizable(false);
		setBounds(100, 100, 864, 601);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		miscombos = new ArrayList<Componente>();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Combos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 298, 838, 230);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCombos = new JLabel("Combos:");
		lblCombos.setBounds(10, 31, 52, 14);
		panel.add(lblCombos);
		
		cbxCombos = new JComboBox();
		cbxCombos.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		cbxCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxCombos.getSelectedIndex()>0) {
					CargarCombosCreados(cbxCombos.getSelectedIndex()-1);
					txtNombre.setText(Tienda.getInstance().getMisCombos().get(cbxCombos.getSelectedIndex()-1).getNombre());
					
				}else {modelComboCreado.setRowCount(0); }
			}
		});
		cbxCombos.setBounds(58, 28, 138, 20);
		panel.add(cbxCombos);
		cbxCombos.addItem("<Seleccione>");
		for(int k=0;k<Tienda.getInstance().getMisCombos().size();k++) {
			cbxCombos.addItem(Integer.toString(k+1));
		}
			
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(216, 31, 62, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(269, 28, 138, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JScrollPane scrollPaneCombosCreados = new JScrollPane();
		scrollPaneCombosCreados.setBounds(10, 69, 818, 152);
		panel.add(scrollPaneCombosCreados);
		
		tableDeCombos = new JTable();
		scrollPaneCombosCreados.setColumnHeaderView(tableDeCombos);
		
		JLabel lblNombreDelCombo = new JLabel("Nombre del Combo:");
		lblNombreDelCombo.setBounds(10, 33, 145, 14);
		contentPanel.add(lblNombreDelCombo);
		
		txtNombreCombo = new JTextField();
		txtNombreCombo.setBounds(133, 30, 145, 20);
		contentPanel.add(txtNombreCombo);
		txtNombreCombo.setColumns(10);
		
		JLabel lblNumeroDeCombo = new JLabel("Numero de Combo:");
		lblNumeroDeCombo.setBounds(10, 63, 145, 14);
		contentPanel.add(lblNumeroDeCombo);
		
		txtNumeroCombo = new JTextField();
		txtNumeroCombo.setBounds(133, 60, 145, 20);
		contentPanel.add(txtNumeroCombo);
		txtNumeroCombo.setColumns(10);
		
		JScrollPane scrollPaneTodos = new JScrollPane();
		scrollPaneTodos.setBounds(10, 113, 320, 174);
		contentPanel.add(scrollPaneTodos);
		
		tableComponentes = new JTable();
		modelTodo=new DefaultTableModel();
		
		String [] columnNames1= {"Código","Tipo","Modelo","Precio"};
		modelTodo.setColumnIdentifiers(columnNames1);
		
		tableComponentes=new JTable(modelTodo);
		
		tableComponentes.getColumnModel().getColumn(0).setPreferredWidth(59);
		tableComponentes.getColumnModel().getColumn(0).setMinWidth(59);
		tableComponentes.getColumnModel().getColumn(0).setMaxWidth(59);
		tableComponentes.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableComponentes.getColumnModel().getColumn(1).setMinWidth(100);
		tableComponentes.getColumnModel().getColumn(1).setMaxWidth(100);
		scrollPaneTodos.setColumnHeaderView(tableComponentes);
		
		CargarMisComponentes();
		
		JScrollPane scrollPaneCombo = new JScrollPane();
		scrollPaneCombo.setBounds(514, 113, 334, 174);
		contentPanel.add(scrollPaneCombo);
		
		
		
		tableCombosPorCrear = new JTable();
		modelCombo=new  DefaultTableModel();
		modelCombo.setColumnIdentifiers(columnNames1);
		tableCombosPorCrear.setModel(modelCombo);
		tableCombosPorCrear.getColumnModel().getColumn(0).setPreferredWidth(59);
		tableCombosPorCrear.getColumnModel().getColumn(0).setMinWidth(59);
		tableCombosPorCrear.getColumnModel().getColumn(0).setMaxWidth(59);
		tableCombosPorCrear.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableCombosPorCrear.getColumnModel().getColumn(1).setMinWidth(100);
		tableCombosPorCrear.getColumnModel().getColumn(1).setMaxWidth(100);
		
		scrollPaneCombo.setColumnHeaderView(tableCombosPorCrear);
		
		JLabel lblComponentes = new JLabel("Componentes");
		lblComponentes.setBounds(10, 98, 85, 14);
		contentPanel.add(lblComponentes);
		
		JLabel lblCombos_1 = new JLabel("Combo");
		lblCombos_1.setBounds(529, 98, 56, 14);
		contentPanel.add(lblCombos_1);
		
		JButton buttonseleccion = new JButton(">");
		buttonseleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Componente co=new Componente();
				co=Tienda.getInstance().getMisComponentes().get(tableComponentes.getSelectedRow());
				miscombos.add(co);
				CargarPreCombo();
			}
		});
		buttonseleccion.setBounds(372, 147, 104, 23);
		contentPanel.add(buttonseleccion);
		
		JButton btnCrearCombo = new JButton("Crear Combo");
		btnCrearCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(txtNombreCombo.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Escriba un nombre para el Combo");
				
			}else{
				
				Combos co=new Combos();
				for(int i=0;i<miscombos.size();i++) {
					
					//co.getMiCombo().add(miscombos.get(i));
				}
				//co.setNombre(txtNombreCombo.getText());
				//Tienda.getInstance().getMisCombos().add(co);
				cbxCombos.removeAllItems();
				cbxCombos.addItem("<Seleccione>");
				for(int k=0;k<Tienda.getInstance().getMisCombos().size();k++) {
					cbxCombos.addItem(Integer.toString(k+1));
				}
				//cbxCombos
				miscombos.clear();
				CargarPreCombo();
				txtNumeroCombo.setText(Integer.toString(Tienda.getInstance().getMisCombos().size()+1));
			}
			
			}
				
		});
				
				
		
		btnCrearCombo.setBounds(372, 238, 104, 23);
		contentPanel.add(btnCrearCombo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnSeleccionarCombo = new JButton("Seleccionar Combo");
			btnSeleccionarCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbxCombos.getSelectedIndex()>0) {
						
						//CrearFactura factura=new CrearFactura(Tienda.getInstance().getMisCombos().get(cbxCombos.getSelectedIndex()-1));
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
		
		CargarMisComponentes();
		
	}
	
	
	
	
	
	
private void CargarMisComponentes() {
		
		modelTodo.setRowCount(0);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tableComponentes.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
	
		fila = new Object[modelTodo.getColumnCount()];
		for(int i=0;i<Tienda.getInstance().getMisComponentes().size() ;i++){
			fila[0]=  Tienda.getInstance().getMisComponentes().get(i).getCodigo();
			fila[1] = Tienda.getInstance().getMisComponentes().get(i).getNombre();
			fila[2] = Tienda.getInstance().getMisComponentes().get(i).getMarca() +" " 
					 +Tienda.getInstance().getMisComponentes().get(i).getModelo();	
			fila[3] = Tienda.getInstance().getMisComponentes().get(i).getPrecioVenta();
			modelTodo.addRow(fila);	
	}}
	
	
	
	
private void CargarPreCombo() {
	
	modelTodo.setRowCount(0);
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	tableCombosPorCrear.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
	
	fila=new Object[modelCombo.getColumnCount()];
	
	for(int i=0;i<miscombos.size() ;i++){
		fila[0]=  miscombos.get(i).getCodigo();
		fila[1] = miscombos.get(i).getNombre();
		fila[2] = miscombos.get(i).getMarca() +" " 
				 +miscombos.get(i).getModelo();	
		fila[3] = miscombos.get(i).getPrecioVenta();
		modelCombo.addRow(fila);
	
	
	
}}	
	
private void CargarCombosCreados(int num) {
	
	modelComboCreado.setRowCount(0);
	fila= new Object[modelComboCreado.getColumnCount()];
	for(int i=0;i<Tienda.getInstance().getMisCombos().get(num).getMiCombo().size();i++) {
		fila[0]=Tienda.getInstance().getMisCombos().get(num).getMiCombo().get(i).getCodigo();
		fila[1]=Tienda.getInstance().getMisCombos().get(num).getMiCombo().get(i).getNombre();
		fila[2]=Tienda.getInstance().getMisCombos().get(num).getMiCombo().get(i).getMarca()+""
		+Tienda.getInstance().getMisCombos().get(num).getMiCombo().get(i).getModelo();
		modelComboCreado.addRow(fila);;
	}
	
	
	
}	
}
