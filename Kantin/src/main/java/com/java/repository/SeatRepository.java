package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Seat;

@Repository
public interface SeatRepository  extends JpaRepository<Seat, Integer>{

}
