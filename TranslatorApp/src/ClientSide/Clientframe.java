package ClientSide;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Clientframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField oriText_textField;
	JLabel arablbl ,englbl,korlbl;
	JPanel Mainpanel;
	/**
	 * Create the frame.
	 */
	
	public Clientframe() {
		setBackground(new Color(85, 107, 47));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 290);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 Mainpanel = new JPanel();
		Mainpanel.setBackground(new Color(255, 235, 205));
		Mainpanel.setBounds(5, 5, 488, 248);
		contentPane.add(Mainpanel);
		Mainpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Malay Text ");
		lblNewLabel.setBounds(26, 32, 115, 19);
		Mainpanel.add(lblNewLabel);
		
		oriText_textField = new JTextField();
		oriText_textField.setBounds(26, 64, 157, 31);
		Mainpanel.add(oriText_textField);
		oriText_textField.setColumns(10);
		
		JLabel translatelbl = new JLabel("Translated Text:");
		translatelbl.setBounds(261, 34, 106, 14);
		Mainpanel.add(translatelbl);
		/*
		JLabel lblNewLabel_1 = new JLabel("Korean : ");
		lblNewLabel_1.setBounds(220, 71, 70, 14);
		Mainpanel.add(lblNewLabel_1);
		*/
		JLabel lblNewLabel_2 = new JLabel("English :");
		lblNewLabel_2.setBounds(218, 72, 68, 14);
		Mainpanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Arabic : ");
		lblNewLabel_3.setBounds(218, 105, 70, 14);
		Mainpanel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("translate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				client client = new client();
				String text = oriText_textField.getText();
					try {
						client.sendText(text);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
			
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(162, 32, 89, 19);
		Mainpanel.add(btnNewButton);
	/*	
		 korlbl = new JLabel("");
		korlbl.setBounds(265, 71, 186, 14);
		Mainpanel.add(korlbl);
		*/
		 englbl = new JLabel("");
		englbl.setBounds(282, 72, 196, 14);
		Mainpanel.add(englbl);
		
		 arablbl = new JLabel("");
		arablbl.setBounds(282, 105, 166, 14);
		Mainpanel.add(arablbl);
	}

	public void updateTranslator(String EngText, String arabText) {

		//korlbl.setText(korText);
		englbl.setText(EngText);
		arablbl.setText(arabText);
	}




	
}
