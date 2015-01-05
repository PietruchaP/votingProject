package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
// chcialbym dziedziczyc po tej klasie metody dla tych zmiennych ale w kolejnej klasie -. przypomniec sobie
public class hibernateConfigurationClass {
	
	Configuration config;
	SessionFactory factory;
	Session session;
	
	public void getConfig(){
		config = new Configuration().configure();
		factory = buildSessionFactory();
		session = factory.openSession();
	}
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
}