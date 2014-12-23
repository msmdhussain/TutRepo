package hibernate.test;

import hibernate.test.dto.foreignKeyAssociation.AccountEntity;
import hibernate.test.dto.foreignKeyAssociation.EmployeeEntity;

import org.hibernate.classic.Session;

public class TestforeinKeyAssociation {

	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		AccountEntity accountEntity = new AccountEntity();
		
		accountEntity.setAccountNumber("123-456-789");
		
		session.saveOrUpdate(accountEntity);
		
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("msmdhussain@gmail.com");
		emp.setFirstName("");
		emp.setLastName("Hussain");
		emp.setAccount(accountEntity);
		
		session.saveOrUpdate(emp);
		
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
	}
}
