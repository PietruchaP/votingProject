package starterKids.votingProgram;

import java.awt.EventQueue;


import starterKids.votingProgram.Class.MyFrame;

public class VotingProgram
{	
	static MyFrame window;
	
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGui();						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	});
    } 
	private static void createAndShowGui() {
		window = new MyFrame("Login");
	}
	
    public VotingProgram() {
	}
}

