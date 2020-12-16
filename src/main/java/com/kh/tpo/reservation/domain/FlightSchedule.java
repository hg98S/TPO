package com.kh.tpo.reservation.domain;

public class FlightSchedule {

	// 매개변수
	private int fsNo; // 항공일정번호
	private String airportId; // 공항번호
	private String airlineId; // 항공사번호
	private String vihicleId; // 항공편명
	private String airlineNm; // 항공사명
	private String depPlandTime; // 출발일자
	private String arrPlandTime; // 도착일자
	private String depAirportNm; // 출발지
	private String arrAirportNm; // 도착지
	private String economyCharge; // 일반석 운임료
	private String prestigeCharge; // 비즈니스석 운임료
	private int capacity; // 수용인원
	
	// 기본 생성자
	public FlightSchedule() {}

	// 매개변수 생성자
	public FlightSchedule(int fsNo, String airportId, String airlineId, String vihicleId, String airlineNm,
			String depPlandTime, String arrPlandTime, String depAirportNm, String arrAirportNm, String economyCharge,
			String prestigeCharge, int capacity) {
		super();
		this.fsNo = fsNo;
		this.airportId = airportId;
		this.airlineId = airlineId;
		this.vihicleId = vihicleId;
		this.airlineNm = airlineNm;
		this.depPlandTime = depPlandTime;
		this.arrPlandTime = arrPlandTime;
		this.depAirportNm = depAirportNm;
		this.arrAirportNm = arrAirportNm;
		this.economyCharge = economyCharge;
		this.prestigeCharge = prestigeCharge;
		this.capacity = capacity;
	}
	
	// getter/setter
	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getVihicleId() {
		return vihicleId;
	}

	public void setVihicleId(String vihicleId) {
		this.vihicleId = vihicleId;
	}

	public String getAirlineNm() {
		return airlineNm;
	}

	public void setAirlineNm(String airlineNm) {
		this.airlineNm = airlineNm;
	}

	public String getDepPlandTime() {
		return depPlandTime;
	}

	public void setDepPlandTime(String depPlandTime) {
		this.depPlandTime = depPlandTime;
	}

	public String getArrPlandTime() {
		return arrPlandTime;
	}

	public void setArrPlandTime(String arrPlandTime) {
		this.arrPlandTime = arrPlandTime;
	}

	public String getDepAirportNm() {
		return depAirportNm;
	}

	public void setDepAirportNm(String depAirportNm) {
		this.depAirportNm = depAirportNm;
	}

	public String getArrAirportNm() {
		return arrAirportNm;
	}

	public void setArrAirportNm(String arrAirportNm) {
		this.arrAirportNm = arrAirportNm;
	}

	public String getEconomyCharge() {
		return economyCharge;
	}

	public void setEconomyCharge(String economyCharge) {
		this.economyCharge = economyCharge;
	}

	public String getPrestigeCharge() {
		return prestigeCharge;
	}

	public void setPrestigeCharge(String prestigeCharge) {
		this.prestigeCharge = prestigeCharge;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// toString
	@Override
	public String toString() {
		return "FlightSchedule [fsNo=" + fsNo + ", airportId=" + airportId + ", airlineId=" + airlineId + ", vihicleId="
				+ vihicleId + ", airlineNm=" + airlineNm + ", depPlandTime=" + depPlandTime + ", arrPlandTime="
				+ arrPlandTime + ", depAirportNm=" + depAirportNm + ", arrAirportNm=" + arrAirportNm
				+ ", economyCharge=" + economyCharge + ", prestigeCharge=" + prestigeCharge + ", capacity=" + capacity
				+ "]";
	}
}
