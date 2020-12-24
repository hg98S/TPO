package com.kh.tpo.reservation.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.tpo.member.domain.ReservationInfo;
import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.Passenger;
import com.kh.tpo.reservation.domain.Reservation;
import com.kh.tpo.reservation.domain.ScheduleSearch;

@Repository
public class ReservationStoreLogic implements ReservationStore {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertPassenger(Passenger passenger) {
		return sqlSession.insert("ReservationMapper.insertPassenger", passenger);
	}

	@Override
	public int insertReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ReservationMapper.insertReservation", reservation);
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
