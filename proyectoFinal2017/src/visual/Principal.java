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
		mnCliente.add(mntmRegistrarCliente);
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar Clientes");
		mnCliente.add(mntmListarClientes);
		
		JMenu mnNewMenu = new JMenu("Productos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrarProducto = new JMenuItem("Registrar producto");
		mnNewMenu.add(mntmRegistrarProducto);
		
		JMenuItem mntmListarProducto = new JMenuItem("Listar Producto");
		mnNewMenu.add(mntmListarProducto);
		
		JMenu mnVenta = new JMenu("Ventas");
		menuBar.add(mnVenta);
		
		JMenuItem mntmCrearFactura = new JMenuItem("Crear factura");
		mnVenta.add(mntmCrearFactura);
		
		JMenuItem mntmListarFactura = new JMenuItem("Listar Factura");
		mnVenta.add(mntmListarFactura);
		
		JMenu mnCombos = new JMenu("Combos");
		menuBar.add(mnCombos);
		
		JMenuItem mntmVerCombos = new JMenuItem("Ver Combos");
		mnCombos.add(mntmVerCombos);
		
		JMenu mnInventario = new JMenu("Inventario");
		menuBar.add(mnInventario);
		
		JMenuItem mntmInventario = new JMenuItem("Inventario");
		mnInventario.add(mntmInventario);
		
		JMenuItem mntmOrdenesDeCompras = new JMenuItem("Ordenes de Compras");
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
