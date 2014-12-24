package starterKids.votingProgram.Class;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class MyFrame{
	
	private JFrame frame;
	
	private LoginPanel loginPanel = new LoginPanel();
	private CandidatePanel myCandidatePanel;// = new CandidatePanel(getContentPane());
	private JPanel buttonPanel = new JPanel();	
	
	private JButton loginButton = new JButton("Login");
	private JButton acceptButton = new JButton("Zatwierdz");
	private ButtonGroup options = new ButtonGroup();
	
	
    public MyFrame(String name) {
		Dimension minimalsize = new Dimension(400,300);
		
    	frame = new JFrame(name);
		frame.setMinimumSize(minimalsize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    }

	public Container getContentPane(){
		return frame.getContentPane();
	}
	
	private void changePanel(JPanel newPanel) {
		getContentPane().removeAll();					
		getContentPane().add(newPanel);
		getContentPane().revalidate();
	}
	public void addComponentsToPane() {

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		myCandidatePanel = new CandidatePanel(getContentPane());
		
		 loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    	if(loginButton.isEnabled()){
					    frame.setTitle("Okręg wyborczy:"+ loginPanel.getPeselField().getText());
						changePanel(myCandidatePanel.getPanel());
						new PeselVerify(loginPanel.getPeselField().getText()).print();
			    	}						
			}
		});
		 
		 buttonPanel.add(loginButton);
		 loginPanel.getPanel().add(buttonPanel);
		 loginPanel.getPanel().add(Box.createVerticalStrut(20));
		 loginButton.setEnabled(false);
		 
		 loginPanel.getPeselField().getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void changed() {
				 checkIfAvailable(loginPanel, loginButton);	
			  }
			  
		});		 
	
		 loginPanel.getZipCodeBox().addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				checkIfAvailable(loginPanel, loginButton);				
			}
		});
		
		 
		 getContentPane().add(loginPanel.getPanel());
	} 
	 
	private void checkIfAvailable(final LoginPanel loginPanel,
			final JButton loginButton) {	
		 boolean peselNumberIsNumeric = loginPanel.ifPeselCorrect();
		 boolean comboBoxIsTaken = loginPanel.ifComboBoxCorrect();
				 if (peselNumberIsNumeric && comboBoxIsTaken){
			       loginButton.setEnabled(true);
			     }
			     else {
			       loginButton.setEnabled(false);
			    }
	}		
}

//    JOptionPane.showMessageDialog(null, null, "InfoBox: "+ loginPanel.getPeselField().getText(), JOptionPane.INFORMATION_MESSAGE);

