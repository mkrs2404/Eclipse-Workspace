package com.mohit.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	
	public static void main(String args[]) {
		
		//Load Spring Configuration File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieving bean
		Coach coach = context.getBean("myCoach", Coach.class);
		 
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune()); 
		
		CricketCoach myCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune()); 
		System.out.println(myCoach.getEmailAddress());
		System.out.println(myCoach.getTeam());
		 
		context.close(); 
	}
}
