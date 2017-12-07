package visual;

import java.text.ParseException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogIn l= new LogIn();
		l.setLocationRelativeTo(null);
		l.setVisible(true);

	}

}
