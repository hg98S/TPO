package com.kh.tpo.reservation.store;

import java.util.ArrayList;

import com.kh.tpo.member.domain.ReservationInfo;
import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.Passenger;
import com.kh.tpo.reservation.domain.Reservation;
import com.kh.tpo.reservation.domain.ScheduleSearch;

public interface ReservationStore {

	public ArrayList<FlightSchedule> selectAirlineSearchList(ScheduleSearch scheduleSearch);
	public ArrayList<FlightSchedule> selectTimeSearchList(ScheduleSearch scheduleSearch);
	public ArrayList<FlightSchedule> selectAllSearchList(ScheduleSearch scheduleSearch);
	public int addScheduleOne(FlightSchedule flightSchedule);
	public int insertPassenger(Passenger passenger);
	public int insertReservation(Reservation reservation);
	public ArrayList<Reservation> selectReservation();
	public int insertRInfo(ReservationInfo rInfo);
	
}
