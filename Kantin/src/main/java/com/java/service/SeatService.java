package com.java.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Seat;
import com.java.repository.SeatRepository;


@Service
@Transactional
public class SeatService {
	
	@Autowired SeatRepository seatRepo;
	
	public List<Seat> getAllSeat(){
		return seatRepo.findAll();
	}
	
	
	public Seat getSeatById(int id) {
		return seatRepo.findById(id).get();
	}
	
	public void saveSeat(Seat seat) {
		seatRepo.save(seat);
	}
	
	public void deleteSeat(int id) {
		seatRepo.deleteById(id);
	}

}
