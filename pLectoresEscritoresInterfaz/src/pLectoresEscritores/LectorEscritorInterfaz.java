package pLectoresEscritores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

public class LectorEscritorInterfaz {

	private JFrame frame;
	private JTextField txtLectoresEscritores;
	private JTextField txtLectores;
	private JTextField txtEscritores;
	private JTextField txtTiempoTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LectorEscritorInterfaz window = new LectorEscritorInterfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LectorEscritorInterfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		long inicio1=System.currentTimeMillis();
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(30, 144, 255));
		frame.setBounds(100, 100, 434, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtLectoresEscritores = new JTextField();
		txtLectoresEscritores.setText(" PROBLEMA- LECTORES ESCRITORES");
		txtLectoresEscritores.setBounds(103, 11, 193, 20);
		frame.getContentPane().add(txtLectoresEscritores);
		txtLectoresEscritores.setColumns(10);
		
		txtLectores = new JTextField();
		txtLectores.setBackground(new Color(0, 206, 209));
		txtLectores.setText(" LECTORES");
		txtLectores.setBounds(10, 11, 71, 32);
		frame.getContentPane().add(txtLectores);
		txtLectores.setColumns(10);
		
		txtEscritores = new JTextField();
		txtEscritores.setBackground(new Color(0, 206, 209));
		txtEscritores.setText("  ESCRITORES");
		txtEscritores.setBounds(316, 11, 89, 32);
		frame.getContentPane().add(txtEscritores);
		txtEscritores.setColumns(10);
		
		TextArea textArea = new TextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setBounds(10, 61, 261, 217);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("Tiempo Lector: ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(285, 169, 120, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo Escritor: ");
		lblNewLabel_1.setBounds(282, 194, 123, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Detener");
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(285, 121, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		txtTiempoTotal = new JTextField();
		txtTiempoTotal.setText("Tiempo total: ");
		txtTiempoTotal.setBounds(285, 268, 120, 20);
		frame.getContentPane().add(txtTiempoTotal);
		txtTiempoTotal.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total Escritor:");
		lblNewLabel_4.setBounds(285, 219, 120, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Total Lector:");
		lblNewLabel_5.setBounds(285, 244, 120, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestor gestor=new gestor(textArea,lblNewLabel,lblNewLabel_1,lblNewLabel_4,lblNewLabel_5);
				escritor[] escritor=new escritor[70];
				lector[] lector=new lector[90];
				for (int i =0;i<escritor.length;i++) {
		        	escritor[i]=new escritor(gestor, i, textArea);
		        }
		        for (int i =0;i<lector.length;i++) {
		        	lector[i]=new lector(gestor,i,textArea);
		        }
		        for (int i =0;i<lector.length;i++) {
		        	lector[i].start();
		        }
		        for (int i =0;i<escritor.length;i++) {
		        	escritor[i].start();
		        } 
		        btnNewButton_1.addActionListener(new ActionListener() {
					 @SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						 for (int i =0;i<lector.length;i++) {
					        	lector[i].stop();
					        }
					        for (int i =0;i<escritor.length;i++) {
					        	escritor[i].stop();
					        } 
		
					        long fin1=System.currentTimeMillis();
							double tiempo1=(double) ((fin1-inicio1)/1000);
						 txtTiempoTotal.setText("Tiempo total: "+"\n"+tiempo1);
				 }
			});
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(285, 87, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("Caso 1:");
		lblNewLabel_2.setBounds(286, 62, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		


	}
}
