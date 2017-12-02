package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafica extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			Grafica dialog = new Grafica();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public Grafica() {
		setBounds(100, 100, 714, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//Aqui se le ponen los valores
				// Fuente de Datos
		        DefaultPieDataset data1 = new DefaultPieDataset();
		        data1.setValue("Disco Duro", 30);
		        data1.setValue("Tarjeta Madre", 30);
		        data1.setValue("Ram", 25);
		        data1.setValue("Micro", 15);

		        // 
		        // Creando el Grafico
		        JFreeChart chart1 = ChartFactory.createPieChart(
		         "Venta de Componentes", 
		         data1, 
		         true, 
		         true, 
		         false);
		     // Crear el Panel del Grafico con ChartPanel
		        ChartPanel chartPanel1 = new ChartPanel(chart1);
		        chartPanel1.setBounds(806, 384, 534, 276);
		        contentPanel.add(chartPanel1);
		        chartPanel1.setMouseZoomable(false);
		        chartPanel1.setDomainZoomable(true);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
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

}
