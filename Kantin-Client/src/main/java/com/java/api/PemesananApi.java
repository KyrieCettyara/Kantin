package com.java.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

}
