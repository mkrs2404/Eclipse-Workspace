package com.mohit.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaCodeDemoApp {
	
	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportsConfig.class);
		
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeam());
		context.close();
		
	}
}
