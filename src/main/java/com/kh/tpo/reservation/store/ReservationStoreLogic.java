package com.kh.tpo.reservation.store;

import java.util.ArrayList;

import com.kh.tpo.member.domain.ReservationInfo;
import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.Passenger;
import com.kh.tpo.reservation.domain.Reservation;
import com.kh.tpo.reservation.domain.ScheduleSearch;

public class ReservationStoreLogic implements ReservationStore {

	@Override
	public ArrayList<FlightSchedule> selectAirlineSearchList(ScheduleSearch scheduleSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FlightSchedule> selectTimeSearchList(ScheduleSearch scheduleSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FlightSchedule> selectAllSearchList(ScheduleSearch scheduleSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addScheduleOne(FlightSchedule flightSchedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return 0;
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
