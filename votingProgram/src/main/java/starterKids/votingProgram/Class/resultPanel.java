package starterKids.votingProgram.Class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class resultPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanel votingResultPanel;
	private JPanel messagePanel;
	private JPanel buttonPanel;
	
	private JButton exitButton;
	private String chosenCandidate = new String();
	private JLabel infoLabel;

	resultPanel(String candidate){
		chosenCandidate = candidate;
		createVotingResultPanel();
		addElementsToPanel();
	}
		public void createVotingResultPanel(){
			votingResultPanel = new JPanel();
			votingResultPanel.setLayout(new BoxLayout(votingResultPanel, BoxLayout.Y_AXIS));		
		}	
		public void addElementsToPanel(){
			createMessagePanelWithInfo();
			createButtonPanel();
			
			votingResultPanel.add(Box.createVerticalGlue());
			votingResultPanel.add(messagePanel);
			votingResultPanel.add(Box.createVerticalGlue());			
			votingResultPanel.add(buttonPanel);	
		}		
			private void createMessagePanelWithInfo() {
				messagePanel = new JPanel();
				infoLabel = new JLabel("Zagłosowałeś na "+ chosenCandidate);
				messagePanel.add(infoLabel);
			}
			private void createButtonPanel() {
				buttonPanel = new JPanel ();
				exitButton = new JButton ("wyjdz");
				exitButton.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
						
				buttonPanel.add(exitButton);
			}
			
	public JPanel getPanel() {
		return votingResultPanel;
	}
	
}
