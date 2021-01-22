package com.java.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	
	@GetMapping("/riwayat/bulan")
	public ModelAndView getRiwayatBulan() {
		ModelAndView mv = new ModelAndView("tab1");
		mv.addObject("listRiwayat", pemesananapi.getByMonth());
		System.out.println("get in pemesanan");
		return mv;
	}
	
	@GetMapping("/riwayat/tahun")
	public ModelAndView getRiwayatTahun() {
		ModelAndView mv = new ModelAndView("tab2");
		mv.addObject("listRiwayat", pemesananapi.getByYear());
		System.out.println("get in pemesanan");
		return mv;
	}
	
	
}
