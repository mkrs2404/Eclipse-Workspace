package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student st = (Student)session.createQuery("from Student where firstName = 'Mohit'").getResultList().get(0);
			st.setEmail("mohit@yahoo.com"); 
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
