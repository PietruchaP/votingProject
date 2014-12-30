package hibernate;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Zip_Codes_Operation {

	Configuration config;
	SessionFactory factory;
	Session session;
	Transaction tx;
	
	public void getConfig(){

		config = new Configuration().configure();
		factory = buildSessionFactory();
		session = factory.openSession();
	}
	
	public void insertZipCode(String zipCode){
		System.out.println("Insert Zip Code");
		
		try{
			getConfig();
			
			Zip_Codes zip = new Zip_Codes();
			zip.setZip_Codes(zipCode);
			
			tx = session.beginTransaction();
			int result = (Integer)session.save(zip); //give primary key
			
			System.out.println("zipCode has been inserted with ID: "+result);			
			
			tx.commit();			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		System.out.println("zip Code:" + zipCode);
	}
	
	public void retrieveZipCode(int id){
		System.out.println("Retrive Zip Code : "+id);
		
		try{
			getConfig();
			tx = session.beginTransaction();
			
			Zip_Codes zip = (Zip_Codes)session.get(Zip_Codes.class,id);
			
			if(zip!=null){
				System.out.println("Printing Zip code:");
				System.out.println("Zip Code id: "+zip.getId());
				System.out.println("zip Code: "+zip.getZip_Codes());
			}
			else
			{
				System.out.println("No zipCode with this id");
			}
			
			
			
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}
	public void updateZipCode(int id, String zipCode){
		System.out.println("Updating Zip Code: "+id);
		System.out.println("Zip Code: "+zipCode);
	}
	public void deleteZipCode(int id){
		System.out.println("Deleting Zip Code: "+id);
	}
	
	public static org.w3c.dom.Document parseConfiguration(String resourcePath) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Validate DTD only on development environments
		factory.setValidating(false); // Don't validate DTD
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(builder.getClass().getResourceAsStream(resourcePath));
		} 
	
	//	private static SessionFactory sessionFactory = buildSessionFactory();
		
		private static SessionFactory buildSessionFactory(){
			
		try{
			Configuration configuration = new Configuration().configure();
	        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
	        serviceRegistryBuilder.applySettings(configuration.getProperties());
	        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	        return configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex){
			
			System.err.println("Initial SessionFactory creation failed."+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	/*	public static SessionFactory getSessionFactory() {
			
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }
	    
		public static void shutdown(){
			getSessionFactory().close();
		}
	*/
}
