package com.java.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.model.IPemesanan;
import com.java.model.Pemesanan;



@Service
public class PemesananApi {
	
	String url = "http://localhost:8080/";
	
	@Autowired RestTemplate restTemplate;
	
	public List<Pemesanan> getAllPemesanan(){
		List<Pemesanan> listProduk= Arrays.stream(restTemplate.getForObject(url + "pemesanan/get", Pemesanan[].class)).collect(Collectors.toList());
		return listProduk;
	}
	
	public List<Pemesanan> getAllFPemesanan(){
		List<Pemesanan> listProduk= Arrays.stream(restTemplate.getForObject(url + "pemesanan/FinishPemesanan", Pemesanan[].class)).collect(Collectors.toList());
		return listProduk;
	}
	
	public List<IPemesanan> getByMonth(){
		List<IPemesanan> listMonth= Arrays.stream(restTemplate.getForObject(url + "pemesanan/SaleByMonth", IPemesanan[].class)).collect(Collectors.toList());
		return listMonth;
	}
	
	public List<IPemesanan> getByYear(){
		List<IPemesanan> listYear= Arrays.stream(restTemplate.getForObject(url + "pemesanan/SaleByYear", IPemesanan[].class)).collect(Collectors.toList());
		return listYear;
	}

}
