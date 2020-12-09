package com.kh.tpo.reservation.domain;

public class FlightSchedule {

	// 매개변수
	private int fsNo; // 항공일정번호
	private String airportNo; // 공항번호
	private String airlineNo; // 항공사번호
	private String departureDate; // 출발일자
	private String arrivalDate; // 도착일자
	private String departureArea; // 출발지
	private String arrivalArea; // 도착지
	private int capacity; // 수용인원
	private String fsName; // 항공편명
	private String seatGrade; // 좌석등급
	private int fare; // 운임료
	
	// 기본 생성자
	public FlightSchedule() {}

	// 매개변수 생성자
	public FlightSchedule(int fsNo, String airportNo, String airlineNo, String departureDate, String arrivalDate,
			String departureArea, String arrivalArea, int capacity, String fsName, String seatGrade, int fare) {
		super();
		this.fsNo = fsNo;
		this.airportNo = airportNo;
		this.airlineNo = airlineNo;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureArea = departureArea;
		this.arrivalArea = arrivalArea;
		this.capacity = capacity;
		this.fsName = fsName;
		this.seatGrade = seatGrade;
		this.fare = fare;
	}
	
	// getter/setter
	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public String getAirportNo() {
		return airportNo;
	}

	public void setAirportNo(String airportNo) {
		this.airportNo = airportNo;
	}

	public String getAirlineNo() {
		return airlineNo;
	}

	public void setAirlineNo(String airlineNo) {
		this.airlineNo = airlineNo;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureArea() {
		return departureArea;
	}

	public void setDepartureArea(String departureArea) {
		this.departureArea = departureArea;
	}

	public String getArrivalArea() {
		return arrivalArea;
	}

	public void setArrivalArea(String arrivalArea) {
		this.arrivalArea = arrivalArea;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getFsName() {
		return fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getSeatGrade() {
		return seatGrade;
	}

	public void setSeatGrade(String seatGrade) {
		this.seatGrade = seatGrade;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	// toString
	@Override
	public String toString() {
		return "FlightSchedule [fsNo=" + fsNo + ", airportNo=" + airportNo + ", airlineNo=" + airlineNo
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", departureArea="
				+ departureArea + ", arrivalArea=" + arrivalArea + ", capacity=" + capacity + ", fsName=" + fsName
				+ ", seatGrade=" + seatGrade + ", fare=" + fare + "]";
	}
}
