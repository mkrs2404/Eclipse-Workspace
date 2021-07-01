package com.mohit.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.business.domain.RoomReservation;
import com.mohit.business.service.ReservationService;
import com.mohit.data.entity.Room;
import com.mohit.data.repository.RoomRepository;

@RestController
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping("/rooms")
	public Iterable<Room> getRooms() {
		return this.roomRepository.findAll();
	}
	
	
}
