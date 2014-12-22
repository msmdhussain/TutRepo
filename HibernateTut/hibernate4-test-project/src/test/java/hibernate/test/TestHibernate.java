package hibernate.test;

import hibernate.test.dto.EmployeeEntity;

import org.hibernate.classic.Session;

public class TestHibernate {

	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("msmdhussain@gmail.com");
		emp.setFirstName("MUHAMMAD");
		emp.setLastName("Hussain");
		
		session.save(emp);
		
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
	}
}
