package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Prin_Vendedor extends JFrame implements Serializable{

	private JPanel contentPane;
	private Dimension dim;
	private JButton btnVender;
	private JButton btnCombo;
	


	public Prin_Vendedor() {
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
		
		JMenuItem mntmListarProducto = new JMenuItem("Listar Producto");// es la misma ventana que inventario 
		mntmListarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario invent = new Inventario();
				invent.setModal(true);
				invent.setLocationRelativeTo(null);
				invent.setVisible(true);
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
				Combos comb = new Combos();
				comb.setModal(true);
				comb.setLocationRelativeTo(null);
				comb.setVisible(true);
			}
		});
		mnCombos.add(mntmVerCombos);
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
		
		JLabel label = new JLabel("");
		label.setBounds(10, 0, 1574, 790);
		label.setIcon(new ImageIcon(Principal.class.getResource("/Fotos/prin.jpg")));
		contentPane.add(label);
	}
}
