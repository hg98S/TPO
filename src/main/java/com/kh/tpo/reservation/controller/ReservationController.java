package com.kh.tpo.reservation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.tpo.reservation.domain.AirVo;
import com.kh.tpo.reservation.domain.MyUtils;

@Controller
public class ReservationController {
	
	@RequestMapping(value="reservation.tpo", method=RequestMethod.GET)
	public String reservationView() {
		return "reservation/reservation";
	}
	
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
	
	@RequestMapping(value="reservationSearchView.tpo", method = RequestMethod.GET)
	public String airport(AirVo airVo, Model model) throws Exception
	{
		Map<String, String> result = MyUtils.getAirportId();
		String depAirportId = result.get(airVo.getDepAirportNm());
		String arrAirportId = result.get(airVo.getArrAirportNm());
		String depPlandTime = airVo.getDepPlandTime();
		String arrPlandTime = airVo.getArrPlandTime();
		List<AirVo> go = ApiExplorer.getAirportJson(depAirportId, arrAirportId, depPlandTime);
		List<AirVo> back = ApiExplorer.getAirportJson(depAirportId, arrAirportId, arrPlandTime);
		
		model.addAttribute("go", go);
		model.addAttribute("back", back);
		
		return "reservation/reservationSearchView";
	}	
}
