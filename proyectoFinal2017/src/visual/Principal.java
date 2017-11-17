package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Tienda;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private static Tienda tiend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(Tienda.getInstance());
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal(Tienda tienda) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width-0, dim.height-40);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Clientes");
		menuBar.add(mnCliente);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente reg = new RegistrarCliente();
				reg.setModal(true);
				reg.setLocationRelativeTo(null);
				reg.setVisible(true);
			
			}
		});
		mnCliente.add(mntmRegistrarCliente);
		
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
		
		JMenuItem mntmListarProducto = new JMenuItem("Listar Producto");
		mntmListarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProducto list = new ListarProducto();
				list.setModal(true);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
			}
		});
		mnNewMenu.add(mntmListarProducto);
		
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
				Combo comb = new Combo();
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/Fotos/fotoPrin.jpg")));
		contentPane.add(label, BorderLayout.CENTER);
	}


}
