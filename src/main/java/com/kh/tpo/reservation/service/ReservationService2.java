package com.kh.tpo.reservation.service;

import java.util.ArrayList;

import com.kh.tpo.member.domain.ReservationInfo;
import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.Passenger;
import com.kh.tpo.reservation.domain.Reservation;
import com.kh.tpo.reservation.domain.ScheduleSearch;

public interface ReservationService2 {

	/**
	 * 승객 정보 추가
	 * @param passenger
	 * @return
	 */
	public int insertAll(Passenger passenger, Reservation reservation);
	
	/**
	 * 예약 완료 후 예약내용 출력 
	 * @return
	 */
	public ArrayList<Reservation> selectReservation();
	
	/**
	 * 마이페이지에서 항공예약정보 출력
	 * @param rInfo
	 * @return
	 */
	public int insertRInfo(ReservationInfo rInfo);
}
