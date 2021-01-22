package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.api.PemesananApi;


@RestController
@RequestMapping("pemesanan")
public class PemesananController {
	
	@Autowired PemesananApi pemesananapi;
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("pemesanan");
		mv.addObject("listPemesanan", pemesananapi.getAllPemesanan());
		
		System.out.println("get in pemesanan");
		return mv;
	}
	
	@GetMapping("/riwayat")
	public ModelAndView getRiwayat() {
		ModelAndView mv = new ModelAndView("riwayat");
		mv.addObject("listRiwayat", pemesananapi.getAllFPemesanan());
		
		System.out.println("get in pemesanan");
		return mv;
	}
	
	
}