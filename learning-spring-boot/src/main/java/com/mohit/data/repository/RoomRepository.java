package com.mohit.data.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohit.data.entity.Reservation;
import com.mohit.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

	
}