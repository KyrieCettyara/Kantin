package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.Seat;

public interface SeatRepository  extends JpaRepository<Seat, Integer>{

}
