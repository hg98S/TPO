package com.kh.tpo.reservation.domain;

public class Airline {

	// 매개변수
	private String airlineNo; // 항공사번호
	private String airlineName; // 항공사명
	
	// 기본 생성자
	public Airline() {}

	// 매개변수 생성자
	public Airline(String airlineNo, String airlineName) {
		super();
		this.airlineNo = airlineNo;
		this.airlineName = airlineName;
	}

	// getter/setter
	public String getAirlineNo() {
		return airlineNo;
	}

	public void setAirlineNo(String airlineNo) {
		this.airlineNo = airlineNo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	// toString
	@Override
	public String toString() {
		return "Airline [airlineNo=" + airlineNo + ", airlineName=" + airlineName + "]";
	}
}
