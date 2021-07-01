package com.mohit.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.mohit.business.domain.RoomReservation;
import com.mohit.data.entity.Guest;
import com.mohit.data.entity.Reservation;
import com.mohit.data.entity.Room;
import com.mohit.data.repository.GuestRepository;
import com.mohit.data.repository.ReservationRepository;
import com.mohit.data.repository.RoomRepository;
import com.mohit.web.DateUtils;

@Service
public class ReservationService {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;

	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}

	public List<RoomReservation> getRoomReservationsForDate(Date date) {
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservationMap.put(room.getRoomId(), roomReservation);
		});

		Iterable<Reservation> reservations = this.reservationRepository
				.findReservationByReservationDate(new java.sql.Date(date.getTime()));
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			roomReservation.setDate(date);
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setGuestId(guest.getGuestId());
		});
		List<RoomReservation> roomReservations = new ArrayList<>();

		for (Long id : roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(id));
		}
		return roomReservations;
	}

//	public List<RoomReservation> getRoomReservationsForDate(String dateString){
//		
//		List<RoomReservation> roomReservations = new ArrayList<>();
//		Date date = DateUtils.createDateFromDateString(dateString);			
//		Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));			
//		reservations.forEach(reservation -> {
//			RoomReservation roomReservation = new RoomReservation();
//			Room room = roomRepository.findById(reservation.getRoomId()).get();
//			roomReservation.setDate(date);
//			roomReservation.setRoomId(room.getRoomId());
//			roomReservation.setRoomName(room.getName());
//			roomReservation.setRoomNumber(room.getRoomNumber());
//			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
//			roomReservation.setFirstName(guest.getFirstName());
//			roomReservation.setLastName(guest.getLastName());
//			roomReservation.setGuestId(guest.getGuestId());
//			roomReservations.add(roomReservation);
//		});
//		
//		return roomReservations;
//	}

}
