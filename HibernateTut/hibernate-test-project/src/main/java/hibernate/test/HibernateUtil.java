package hibernate.test;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {

			return new AnnotationConfiguration().configure(
					new File("/home/komlimobile/workspace/tutorialsrepo/HibernateTut/hibernate-test-project/src/main/java/hibernate/test/hibernate.cfg.xml")).buildSessionFactory();
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
