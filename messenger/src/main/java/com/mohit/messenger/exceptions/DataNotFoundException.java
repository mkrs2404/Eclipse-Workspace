package com.mohit.messenger.exceptions;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6376013027071957655L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
