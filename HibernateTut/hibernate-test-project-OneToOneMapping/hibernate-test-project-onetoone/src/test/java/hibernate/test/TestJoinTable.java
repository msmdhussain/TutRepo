package hibernate.test;

import hibernate.test.dto.joinTable.*;


import org.hibernate.classic.Session;

public class TestJoinTable {

	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		AccountEntity accountEntity = new AccountEntity();
		
		accountEntity.setAccountNumber("123-456-789-0");
		
		
		
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("bala@gmail.com");
		emp.setFirstName("bala");
		emp.setLastName("krish");
		emp.setAccount(accountEntity);
		
		session.save(emp);
		
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
	}
}
