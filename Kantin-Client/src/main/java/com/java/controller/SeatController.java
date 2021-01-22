package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.java.api.SeatApi;
import com.java.model.Produk;
import com.java.model.Seat;

@RestController
@RequestMapping("tempat-duduk")
public class SeatController {
	
	@Autowired SeatApi seatapi;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("tempat-duduk");
		mv.addObject("listTd", seatapi.getAllSeat());
		System.out.println("get in tempat duduk");
		return mv;
	}
	
    @GetMapping("/hapus/{id}")
    public RedirectView hapusSeat(@PathVariable("id") int id) {
    	System.out.println("into the delete");
    	seatapi.deleteSeat(id);
        return new RedirectView("/tempat-duduk/");
    }
    
    @GetMapping("/formTd/{id}")
    public ModelAndView tampilFormedit(@PathVariable(name = "id") int id, ModelMap modelMap) {
        System.out.println(seatapi.getSeatById(id).getId_seat());
        
        ModelAndView mv = new ModelAndView("formTd");
        mv.addObject("tempatDuduk", seatapi.getSeatById(id));
    
        return mv;
    }
    
    @PostMapping("/formTd")
    public RedirectView editSeat(@ModelAttribute Seat seat, BindingResult errors, SessionStatus status) {
        try {
        	seatapi.updateSeat(seat);
            status.setComplete();
            return new RedirectView("/tempat-duduk/");
        } catch (HttpStatusCodeException e) {
            ResponseEntity<String> response = ResponseEntity.status(e.getStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            errors.reject("error.object", response.getBody());
        }
        return new RedirectView("/tempat-duduk/formTd");
    }
    
    @GetMapping("/formAddTd")
    public ModelAndView tampilFormTambah(){

          Seat seat= new Seat();
          ModelAndView modelAndView = new ModelAndView("formAdd");
          modelAndView.addObject("produk", seat);
          modelAndView.setViewName("formAddTd");
        return modelAndView;
    }
    

    @PostMapping("/formAddTd")
    public RedirectView addProduk(@ModelAttribute("formAddTd") Seat seat){
    	seatapi.addSeat(seat);
        
        return new RedirectView("/tempat-duduk/");
    }

}
