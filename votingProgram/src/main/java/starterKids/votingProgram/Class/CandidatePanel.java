package starterKids.votingProgram.Class;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CandidatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	final private Container pane;
	private JPanel candidatePanel;
	private JPanel candidateButtonsPanel;// = new JPanel();
	private JButton acceptButton;
	private ButtonGroup options = new ButtonGroup();

	CandidatePanel(final Container pane) {
		this.pane = pane;
		createCandidatePanel();
		createElementsToPanel();
		addElementsToPanel();
	}

		public void createCandidatePanel() {
			candidatePanel = new JPanel();
		}
		public void createElementsToPanel(){
			createCandidateButtonsPanel();
			createCandidate(3);
		}
			public void createCandidateButtonsPanel(){
				candidateButtonsPanel = new JPanel();
			}


	public void addElementsToPanel() {
		candidatePanel.setLayout(new BoxLayout(candidatePanel, BoxLayout.Y_AXIS));
		candidateButtonsPanel = new JPanel();
		candidateButtonsPanel.setLayout(new BoxLayout(candidateButtonsPanel, BoxLayout.Y_AXIS));


		JPanel buttonPanel = new JPanel();
		acceptButton = new JButton("Zatwierdz");
		acceptButton.setEnabled(false);
		buttonPanel.add(acceptButton);
		candidatePanel.add(Box.createVerticalGlue());
		candidatePanel.add(candidateButtonsPanel);
		candidatePanel.add(Box.createVerticalGlue());
		candidatePanel.add(buttonPanel);
		candidatePanel.add(Box.createVerticalStrut(20));

		acceptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				GroupButtonCheckSelected test = new GroupButtonCheckSelected();
				String selectedCandidate = test.getSelectedButtonText(options);
				
				resultPanel replyPanel = new resultPanel(
						selectedCandidate);
				changePanel(replyPanel);
				pane.add(replyPanel.getPanel());
				// JOptionPane.showMessageDialog(null, selectedCandidate);
			}
		});
	}

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			acceptButton.setEnabled(true);

		}
	};

	public void createCandidate(int number) {
		for (int i = 0; i < number; i++) {
			JRadioButton candidateOption = new JRadioButton("test" + i);
			candidateButtonsPanel.add(candidateOption);
			candidateButtonsPanel.add(Box.createVerticalGlue());
			candidateOption.addActionListener(listener);
			options.add(candidateOption);
		}
	}

	public void setCandidatePanel(JPanel candidatePanel) {
		this.candidateButtonsPanel = candidatePanel;
	}

	public JPanel getPanel() {
		return candidatePanel;
	}

	public void setPanel(JPanel panel) {
		this.candidatePanel = panel;
	}
	private void changePanel(JPanel newPanel) {
		pane.removeAll();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(newPanel);
		pane.revalidate();
	}
}
