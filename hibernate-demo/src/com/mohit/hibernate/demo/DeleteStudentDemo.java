package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			/*
			 * Student st = session.get(Student.class, 5);
			 * 
			 * session.delete(st);
			 */
			
			session.createQuery("delete from Student where id = 6").executeUpdate();
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
