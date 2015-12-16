import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class EncryptionUI extends JFrame{
	private Encryptor encryptor;

	public EncryptionUI()
	{
		encryptor = new Encryptor();       
		//encryptor.setEncryptionStrategy(new CopyEncryptor());       
		 
		
		Box box = Box.createVerticalBox(); 
		add(box); 
		JTextArea textArea = new JTextArea(100, 50);
		box.add(textArea);
		textArea.setBorder(new TitledBorder("Original"));
		
		JTextArea textArea2 = new JTextArea(100, 50);
		box.add(textArea2);
		textArea2.setBorder(new TitledBorder("Encrypted"));
		
		Box encrypted = Box.createHorizontalBox();
		add(encrypted, BorderLayout.SOUTH);
		JButton encrypt = new JButton("Encrypt");
		encrypt.addActionListener(
				e -> {
					String text = textArea.getText();				
					String reverse = new StringBuffer(text).reverse().toString();
					String rev = reverse.toLowerCase();
					textArea2.setText(rev);
				});
		
		encrypted.add(encrypt);
		JButton decrypt = new JButton("Decrypt");
		decrypt.addActionListener(
				e -> {
					String text = textArea2.getText();				
					String reverse = new StringBuffer(text).reverse().toString();
					String rev = reverse.toLowerCase();
					textArea.setText(rev);
				});
		encrypted.add(decrypt);
		
		String [] auswahl = {"Reverse", "Copy"};
		JComboBox comboBox = new JComboBox(auswahl);
		comboBox.addActionListener(
				e ->{
					String text = textArea.getText();
					if(auswahl[1]!=null){
						String reverse = new StringBuffer(text).reverse().toString();
						String rev = reverse.toLowerCase();
						textArea2.setText(rev);
					}
					if(auswahl[2]!=null){
					textArea2.setText(text);;
					}
					
				}
				);
		encrypted.add(comboBox);
		
	}
	
		public static void main(String[] args){
		EncryptionUI frame = new EncryptionUI();
			frame.pack();
			frame.setSize(300, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}
	

	
}
