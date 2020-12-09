package com.kh.tpo.reservation.domain;

public class Airport {

	// 매개변수
	private String airportNo; // 공항번호
	private String airportName; // 공항명
	
	// 기본 생성자
	public Airport() {}

	// 매개변수 생성자
	public Airport(String airportNo, String airportName) {
		super();
		this.airportNo = airportNo;
		this.airportName = airportName;
	}

	// getter/setter
	public String getAirportNo() {
		return airportNo;
	}

	public void setAirportNo(String airportNo) {
		this.airportNo = airportNo;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	// toString
	@Override
	public String toString() {
		return "Airport [airportNo=" + airportNo + ", airportName=" + airportName + "]";
	}
	
	
}
