package hibernate.service;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConnectionWithBase {

	static Scanner scan = new Scanner(System.in);
	
	
	public SpringConnectionWithBase (){
		connectWithDateBase();
	}
	
	public void connectWithDateBase(){
		
		int mainWindowChoice;
		
		System.out.println("Menu :");
		System.out.println("1. zip code\n2. exit");
		System.out.println("Enter your choice: ");
		mainWindowChoice = scan.nextInt();
		switch(mainWindowChoice){
		case 1:
				zipCodeNewChoice();
			break;		
		case 2:		
				System.exit(0);
			break;		
		default:
			break;
		}
	}
	
	private void zipCodeNewChoice(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//System.out.println("test czy wchodzi tutaj");
		//Manager manager = context.getBean(ManagerImpl.class);		  
		//Manager manager = new ManagerImpl();
//		ZipCodesDAO zipCodeDAO = context.getBean(ZipCodesDAO.class);		
		//ZipCodes zipcode = new ZipCodes();
		//zipcode.setZipCodes("11-111");
		//manager.insertZipCode(zipcode);
		//context.close();
	}
}
