package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import logic.Tienda;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class Principal extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private JButton btnVender;
	private JButton btnCombo;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
					
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Principal() {
		setTitle("PC Parts");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Fotos/if_computer__desktop__electronic__pc__monitor__screen__technology_2317975.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width-0, dim.height-40);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		JMenu mnCliente = new JMenu("Clientes");
		menuBar.add(mnCliente);
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar Clientes");
		mntmListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente list = new ListarCliente();
				list.setModal(true);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
			}
		});
		mnCliente.add(mntmListarClientes);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarCliente list = new RegistrarCliente();
				list.setModal(true);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
			
			}
		});
		mnCliente.add(mntmRegistrarCliente);
		
		JMenu mnNewMenu = new JMenu("Productos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrarProducto = new JMenuItem("Registrar producto");
		mntmRegistrarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProducto reg = new RegistrarProducto();
				reg.setModal(true);
				reg.setLocationRelativeTo(null);
				reg.setVisible(true);
			}
		});
		mnNewMenu.add(mntmRegistrarProducto);
		
		/*JMenuItem mntmListarProducto = new JMenuItem("Listar Producto");
		mntmListarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProducto list = new ListarProducto();
				list.setModal(true);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
			}
		});
		mnNewMenu.add(mntmListarProducto);*/
		
		JMenu mnVenta = new JMenu("Ventas");
		menuBar.add(mnVenta);
		
		JMenuItem mntmCrearFactura = new JMenuItem("Crear factura");
		mntmCrearFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearFactura reg = new CrearFactura();
				reg.setModal(true);
				reg.setLocationRelativeTo(null);
				reg.setVisible(true);
			}
		});
		mnVenta.add(mntmCrearFactura);
		
		JMenuItem mntmListarFactura = new JMenuItem("Listar Factura");
		mntmListarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarFactura list = new ListarFactura();
				list.setModal(true);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
			}
		});
		mnVenta.add(mntmListarFactura);
		
		JMenu mnCombos = new JMenu("Combos");
		menuBar.add(mnCombos);
		
		JMenuItem mntmVerCombos = new JMenuItem("Ver Combos");
		mntmVerCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combos comb = new Combos();
				comb.setModal(true);
				comb.setLocationRelativeTo(null);
				comb.setVisible(true);
			}
		});
		mnCombos.add(mntmVerCombos);
		
		JMenu mnInventario = new JMenu("Inventario");
		menuBar.add(mnInventario);
		
		JMenuItem mntmInventario = new JMenuItem("Inventario");
		mntmInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario invent = new Inventario();
				invent.setModal(true);
				invent.setLocationRelativeTo(null);
				invent.setVisible(true);
			}
		});
		mnInventario.add(mntmInventario);
		
		JMenuItem mntmOrdenesDeCompras = new JMenuItem("Ordenes de Compras");
		mntmOrdenesDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdenesCompra ordenCompra = new OrdenesCompra();
				ordenCompra.setModal(true);
				ordenCompra.setLocationRelativeTo(null);
				ordenCompra.setVisible(true);
			}
		});
		mnInventario.add(mntmOrdenesDeCompras);
		
		JMenu mnLogout = new JMenu("Salir");
		menuBar.add(mnLogout);
		
		JMenuItem mntmLogout = new JMenuItem("Cerrar sesion");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogIn l= new LogIn();
				l.setLocationRelativeTo(null);
				l.setVisible(true);
			}
		});
		mnLogout.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCombo = new JButton("");
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combos com= new Combos();
				com.setModal(true);
				com.setLocationRelativeTo(null);
				com.setVisible(true);
			}
		});
		btnCombo.setBackground(Color.BLACK);
		btnCombo.setIcon(new ImageIcon(Principal.class.getResource("/Fotos/if_08_Sales_1871425 (1).png")));
		btnCombo.setBounds(826, 79, 67, 58);
		contentPane.add(btnCombo);
		
		btnVender = new JButton("");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearFactura reg = new CrearFactura();
				reg.setModal(true);
				reg.setLocationRelativeTo(null);
				reg.setVisible(true);
				}
		});
		btnVender.setBackground(Color.BLACK);
		btnVender.setForeground(Color.BLACK);
		btnVender.setIcon(new ImageIcon(Principal.class.getResource("/Fotos/if_12_Bills_1871414(2).png")));
		btnVender.setBounds(691, 79, 67, 58);
		contentPane.add(btnVender);
		
		JButton btnGrafica = new JButton("");
		btnGrafica.setIcon(new ImageIcon(Principal.class.getResource("/Fotos/if_Tablet-Chart_379405 (1).png")));
		btnGrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grafica graf = new Grafica();
				graf.setModal(true);
				graf.setLocationRelativeTo(null);
				graf.setVisible(true);
			}
		});
		btnGrafica.setBackground(Color.BLACK);
		btnGrafica.setBounds(963, 79, 67, 58);
		contentPane.add(btnGrafica);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1584, 800);
		label.setIcon(new ImageIcon(Principal.class.getResource("/Fotos/Pc.Solution.jpg")));
		contentPane.add(label);
		if(!Tienda.getInstance().abrirDatos()){
			
			JOptionPane.showMessageDialog(null, "Error al cargar los datos. Verifique archivo de datos.");
		}
		
	}
}
