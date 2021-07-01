package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student st = new Student("Aman", "Kindo", "aman@gmail.com");
			
			session.save(st);
			
			System.out.println(session.get(Student.class, st.getId() ));
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
