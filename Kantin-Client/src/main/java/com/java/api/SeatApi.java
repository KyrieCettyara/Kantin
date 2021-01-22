package com.java.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.model.Produk;
import com.java.model.Seat;

@Service
public class SeatApi {

	String url = "http://localhost:8080/";
	
	@Autowired RestTemplate restTemplate;
	
	public List<Seat> getAllSeat(){
		List<Seat> listSeat = Arrays.stream(restTemplate.getForObject(url + "tempat-duduk/get", Seat[].class)).collect(Collectors.toList());
		return listSeat;
	}
	
	public Seat getSeatById(int id) {
		Seat seat = restTemplate.getForObject(url + "tempat-duduk/get/{id}", Seat.class, id);
		return seat;
	}
	
	public void deleteSeat(Integer id) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", id);
		restTemplate.delete(url + "tempat-duduk/delete/{id}", parameter);
	}
	
	public void updateSeat(Seat seat) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", seat.getId_seat());
		restTemplate.put(url + "tempat-duduk/edit/{id}", seat, parameter);
	}
	
	public void addSeat(Seat seat) {
		restTemplate.postForObject(url + "/tempat-duduk/add", seat, Seat.class);
	}
}
