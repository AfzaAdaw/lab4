package clientSide;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import text.Text;

public class ClientFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
		// Private components
		private JLabel label;
		private JLabel wordslabel;
		public static JButton button;
		private JPanel panel;
		public static JTextField textField;


	/**
	 * Create the application.
	 * @param text2 
	 */
	public ClientFrame(Text text) {
		
		initialize(text);
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @param text 
	 */
	private void initialize(Text text) {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("client side: send text");
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		getContentPane().add(panel,BorderLayout.CENTER);
		
		label = new JLabel();
		panel.add(label);
		label.setText("Text: ");
		
		textField = new JTextField(40);
		textField.setBounds(10, 20, 165, 25);
		panel.add(textField);
		textField.setText(" ");
		
		button = new JButton("enter");
		button.setBounds(10, 50, 10, 10);
		panel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Text text = new Text();
			 client client = new client();
				text.setText(textField.getText()); 

			 try {
				client.sendText(text);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			}
		});
		
		wordslabel = new JLabel();
		panel.add(wordslabel);
		wordslabel.setBackground(Color.WHITE);
		wordslabel.setText("Word count: ");


	}

	public void updateWordCount(Text text) {
		wordslabel.setText("Word count: 0 ");
		
		wordslabel.setText("Word count: "+ text.getTextLength());
		
	}


}
