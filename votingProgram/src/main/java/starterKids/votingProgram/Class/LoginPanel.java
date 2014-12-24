package starterKids.votingProgram.Class;

import java.awt.Component;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel loginPanel;
	private JPanel zipPanel;
	private JPanel peselPanel;

	private JTextField peselField;
	private JComboBox<String> zipCodeBox;	
	static final String gapList[] = {"","45-234", "73-410", "73-215", "43-420"};
    final static int maxGap = 20;

	LoginPanel(){
		createLoginPanel();
		createElementForPanel();
		addElementToLoginPanel();
	}
		private void createLoginPanel(){
			 loginPanel = new JPanel();
		}	
		private void createElementForPanel(){
			createZipCodeBox();
			createZipPanel();
			createPeselField();		 
			createPeselPanel();
		}
			private void createZipCodeBox() {
				zipCodeBox = new JComboBox<String>(gapList);
			}
			private void createPeselField() {
				peselField = new JTextField();
				peselField.setBounds(217, 5, 106, 228);
				peselField.setColumns(10);
				peselField.setTransferHandler(null);
				
				 peselField.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						checkIfCorrectKey(e);				
					}			
					@Override
					public void keyReleased(KeyEvent e) {}			
					@Override
					public void keyPressed(KeyEvent e) {}
					
					 public void checkIfCorrectKey(KeyEvent e){
						 if(!(e.getKeyChar()>='0' && e.getKeyChar()<='9')){
							 e.consume();
						 }	
						 if(peselField.getText().length()>=11){
							 e.consume();
						 }
					 }
				});
			}	
			private void createZipPanel() {
				zipPanel = new JPanel();
				zipPanel.add(new Label("Kod pocztowy:"));
				zipPanel.add(zipCodeBox);
				zipPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
			}
			private void createPeselPanel() {
				peselPanel = new JPanel();
				peselPanel.add(new Label("Pesel:"));			
				peselPanel.add(peselField);
			}
			
		private void addElementToLoginPanel(){			
			loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
			loginPanel.add(Box.createVerticalStrut(20));
			loginPanel.add(zipPanel);
			loginPanel.add(Box.createVerticalGlue());
			loginPanel.add(peselPanel);
			loginPanel.add(Box.createVerticalGlue());	
		}
	
	
	public boolean ifPeselCorrect(){
		boolean isPeselCorrect = (peselField.getText().length()==11) ? true: false;
		return isPeselCorrect;
	}
	
	public boolean ifComboBoxCorrect() {	
		String value=zipCodeBox.getSelectedItem().toString();
		boolean isComboBoxCorrect = (value.equals("")) ? false : true;
		return isComboBoxCorrect;
	}
	public JPanel getPanel() {
		return loginPanel;
	}
	public JComboBox<String> getZipCodeBox() {
		return zipCodeBox;
	}
    public JTextField getPeselField() {
		return peselField;
	}

	
}
