package com.mohit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.data.entity.Guest;
import com.mohit.data.repository.GuestRepository;

@RestController
public class GuestController {
	
	@Autowired
	private GuestRepository guestRepository;
	
	@GetMapping("/guests")
	public Iterable<Guest> getRooms() {
		return this.guestRepository.findAll();
	}
}
