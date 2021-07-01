package com.mohit.springdemo;

public class BaseballCoach implements Coach{
	
	private FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 20 minutes batting";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
