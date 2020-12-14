package com.kh.tpo.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationController {
	
	@RequestMapping(value="ex.tpo", method=RequestMethod.GET)
	public String reservationSearchView() {
		return "reservation/reservationSearchView";
	}
	
	@RequestMapping(value="ex2.tpo", method=RequestMethod.GET)
	public String passengerInsertForm() {
		return "reservation/passengerInsertForm";
	}
	
	@RequestMapping(value="insertPassenger.tpo", method=RequestMethod.POST)
	public String reservationDetailView() {
		return "reservation/reservationDetailView";
	}
}
