package com.kh.tpo.reservation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.tpo.member.domain.ReservationInfo;
import com.kh.tpo.reservation.domain.Passenger;
import com.kh.tpo.reservation.domain.Reservation;

@Service
public class ReservationServiceImpl2 implements ReservationService2{
	
	@Autowired
	public ReservationService2 rStore2;
	
	@Override
	public int insertAll(Passenger passenger, Reservation reservation) {
		return rStore2.insertAll(passenger, reservation);
	}

	@Override
	public ArrayList<Reservation> selectReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRInfo(ReservationInfo rInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
