package starterKids.votingProgram;

import hibernate.Zip_Codes_Operation;
import hibernate.Zip_Codes;

import java.awt.EventQueue;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import starterKids.votingProgram.Class.MyFrame;
import hibernate.hibernateMain;

public class VotingProgram
{	
	static MyFrame window;
	
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connectWithDatebase();
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
	
	private static void connectWithDatebase(){
	//	hibernateMain hibernateConnection = new hibernateMain();
	//	hibernateConnection.connectWithDatebaseZipCode();
	//	Zip_Codes_Operation crudOperation = new Zip_Codes_Operation();
		//Session session = CRUDOperation.getSessionFactory().openSession();
		//session.beginTransaction();
		//Query query = session.createQuery("from Zip_Codes");
        //List<Zip_Codes> zipCodesList = query.list();
        //for (Zip_Codes z : zipCodesList) {
        //       System.out.println(+z.getId() + "," + z.getZip_Codes());
        //}

        // close session
        //CRUDOperation.shutdown();

	}
	
    public VotingProgram() {
	}
}

