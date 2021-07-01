package com.mohit.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> st = session.createQuery("from Student s where s.firstName = 'Mohit' OR s.lastName = 'Kumar' OR s.email LIKE '%gmail.com'")
				                      .getResultList();
			for(Student s : st) {
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
