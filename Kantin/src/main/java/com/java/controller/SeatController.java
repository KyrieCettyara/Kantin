package com.java.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Seat;
import com.java.service.SeatService;

@RestController
@RequestMapping("tempat-duduk")
public class SeatController {
	
	@Autowired SeatService seatService;
	
	@GetMapping("/get")
	public List<Seat> getAllProduk(){
		return seatService.getAllSeat();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Seat> getSeatById(@PathVariable("id") int id){
		try {
			Seat seat= seatService.getSeatById(id);
			return new ResponseEntity<Seat>(seat, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Seat>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/add")
	 public ResponseEntity<Seat> createSeat(@RequestBody Seat seat){
		seatService.saveSeat(seat);
		 
		 return new ResponseEntity<Seat>(seat, HttpStatus.OK);
	 }
	
	@DeleteMapping(value="/delete/{id}")
	 public ResponseEntity<String> deleteProduk(@PathVariable("id") int id){
		 try {
			 Seat existseat = seatService.getSeatById(id);
			 seatService.deleteSeat(id);
			 return new ResponseEntity<String>(HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
	 }


}
