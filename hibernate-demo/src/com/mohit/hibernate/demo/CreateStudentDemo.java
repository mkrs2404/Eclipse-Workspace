package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			session.save(new Student("Mohit", "Kumar", "kumarmohit2496@gmail.com"));
			
			session.save(new Student("mkrs", "MK", "mkrs@live.in"));
			
			session.save(new Student("Summer", "Kumar", "summ@gmail.com"));
			
			session.save(new Student("Ravi", "Dubey", "ravi@yahoo.com"));
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
