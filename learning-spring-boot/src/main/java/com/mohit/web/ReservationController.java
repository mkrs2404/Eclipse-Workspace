package com.mohit.web;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.business.domain.RoomReservation;
import com.mohit.business.service.ReservationService;
import com.mohit.data.entity.Reservation;
import com.mohit.data.repository.ReservationRepository;

/* If I make this Controller, methods which are returning html pages will work but the Rest services won't.
 * For that, we need to make it @RestController*/
@Controller
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/reservations")
	public Iterable<Reservation> getRooms() {
		return this.reservationRepository.findAll();
	}
	
	@GetMapping("/reservations/{dateString}")
	public String getRoomReservationsForDate(@PathVariable String dateString, Model model) throws ParseException{		
		Date date = DateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "reservations";
	}
}
