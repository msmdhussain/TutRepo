package hibernate.test;

import java.io.File;




import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

	private static SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {

			if(SESSION_FACTORY==null){
			 Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("hibernate.cfg.xml"));
			 StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
			 standardServiceRegistryBuilder.applySettings(configuration.getProperties());
			 ServiceRegistry serviceRegistry  = standardServiceRegistryBuilder.build();
			 SESSION_FACTORY = configuration.buildSessionFactory();
			}
			return SESSION_FACTORY;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY;
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}

}
