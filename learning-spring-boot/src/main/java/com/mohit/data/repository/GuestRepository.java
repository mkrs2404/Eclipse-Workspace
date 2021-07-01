package com.mohit.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohit.data.entity.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long>{

}
