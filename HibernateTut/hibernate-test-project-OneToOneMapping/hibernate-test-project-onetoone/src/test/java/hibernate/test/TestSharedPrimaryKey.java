package hibernate.test;

import hibernate.test.dto.SharedPrimaryKey.*;


import org.hibernate.classic.Session;

public class TestSharedPrimaryKey {

	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccountNumber("123-456-789-123");
		
		
		
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("msmdhussain@gmail.com");
		emp.setFirstName("MUHAMMAD");
		emp.setLastName("Hussain");
		
		emp.setAccount(accountEntity);
		
		accountEntity.setEmployee(emp);
		
		session.save(emp);
		
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
	}
}
