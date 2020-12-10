package com.kh.tpo.reservation.service;

import java.util.ArrayList;

import com.kh.tpo.member.domain.ReservationInfo;
import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.Passenger;
import com.kh.tpo.reservation.domain.Reservation;
import com.kh.tpo.reservation.domain.ScheduleSearch;

public interface ReservationService {

	/**
	 * 항공사별 검색 조회
	 * @param scheduleSearch
	 * @return
	 */
	public ArrayList<FlightSchedule> selectAirlineSearchList(ScheduleSearch scheduleSearch);
	
	/**
	 * 시간대별 검색 조회
	 * @param scheduleSearch
	 * @return
	 */
	public ArrayList<FlightSchedule> selectTimeSearchList(ScheduleSearch scheduleSearch);
	
	/**
	 * 항공사/시간대별 검색 조회
	 * @param scheduleSearch
	 * @return
	 */
	public ArrayList<FlightSchedule> selectAllSearchList(ScheduleSearch scheduleSearch);
	
	/**
	 * 운항스케줄 선택시 테이블에 추가
	 * @param flightSchedule
	 * @return
	 */
	public int addScheduleOne(FlightSchedule flightSchedule);
	
	/**
	 * 승객 정보 추가
	 * @param passenger
	 * @return
	 */
	public int insertPassenger(Passenger passenger);
	
	/**
	 * 예약 정보 추가
	 * @param reservation
	 * @return
	 */
	public int insertReservation(Reservation reservation);
	
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
