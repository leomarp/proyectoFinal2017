package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LogIn extends JDialog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JPasswordField ptxtCont;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogIn dialog = new LogIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/Fotos/if_computer__desktop__electronic__pc__monitor__screen__technology_2317975.png")));
		
		setTitle("Ingresar");
		setBounds(100, 100, 334, 315);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(LogIn.class.getResource("/Fotos/if_photo_370076.png")));
			label.setBounds(97, 0, 128, 128);
			contentPanel.add(label);
		}
		{
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setIcon(new ImageIcon(LogIn.class.getResource("/Fotos/if_user_male4_172628.png")));
			lblUsuario.setBounds(10, 139, 109, 21);
			contentPanel.add(lblUsuario);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setIcon(new ImageIcon(LogIn.class.getResource("/Fotos/if_lock_511942 (1).png")));
			lblContrasea.setBounds(10, 200, 109, 21);
			contentPanel.add(lblContrasea);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(129, 139, 135, 21);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			ptxtCont = new JPasswordField();
			ptxtCont.setBounds(129, 197, 135, 21);
			contentPanel.add(ptxtCont);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				
				JButton btnIngresar = new JButton("Ingresar");
				btnIngresar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String usuario= txtNombre.getText();
						char[] clave= ptxtCont.getPassword();
						String pass= new String(clave);
						String admin="admin";
						
						if (usuario.equals(admin) && pass.equals(admin)) {
							dispose();
							JOptionPane.showMessageDialog(null, "Bienvenido al Sistema","Entrada",JOptionPane.INFORMATION_MESSAGE);
							Principal p= new Principal();
							p.setVisible(true);
							}else{
								JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta","Error",JOptionPane.ERROR_MESSAGE);
								clean();
							}
					}

					
				});
				btnIngresar.setActionCommand("OK");
				buttonPane.add(btnIngresar);
				getRootPane().setDefaultButton(btnIngresar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	private void clean() {
		txtNombre.setText("" );
		ptxtCont.setText("");
		txtNombre.requestFocus();
	}

}
