package hibernate;

import java.util.Scanner;

public class hibernateMain {
	static int id;
	static String zip_Code;
	
	public static void connectWithDatebaseZipCode(){
		
		Scanner scan = new Scanner(System.in);
		
		Zip_Codes_Operation crudOperation = new Zip_Codes_Operation();
		
		System.out.println("Menu :");
		System.out.println("1. Insert zipCode\n2.Retrieve zipCode\n3.Update zipCode\n4.Delete zipCode");
		System.out.println("Enter your choice: ");
		int choice = scan.nextInt();
		
		switch(choice){
		case 1:
			System.out.println("Inserting zipCode\n");
			zip_Code = scan.next();
			crudOperation.insertZipCode(zip_Code);
			break;
		case 2:
			System.out.println("Enter id:");
			id = scan.nextInt();
			crudOperation.retrieveZipCode(id);
			break;
		case 3:
			System.out.println("Updating zipCode\n");
			System.out.println("Enter id:");
			id = scan.nextInt();
			System.out.println("Enter zipCode");
			zip_Code = scan.next();
			crudOperation.updateZipCode(id, zip_Code);
			break;
		case 4:
			System.out.println("Delete zipCode\n");
			System.out.println("Enter id:");
			id = scan.nextInt();
			crudOperation.deleteZipCode(id);
			break;
			
		default:
				break;
		}
		
	}
}
