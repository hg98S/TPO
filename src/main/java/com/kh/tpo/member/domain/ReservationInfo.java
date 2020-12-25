package com.kh.tpo.member.domain;

import java.sql.Date;

public class ReservationInfo {

	private int riNo;
	private int enNo;	
	private String riVihicleId;
	private String riDepartureArea;
	private String riArrivalArea;
	private String riDepartureDate;
	private String riArrivalDate;
	private int riFare;
	private String riSeatGrade;
	
	public ReservationInfo() {}

	public int getRiNo() {
		return riNo;
	}

	public void setRiNo(int riNo) {
		this.riNo = riNo;
	}

	public int getEnNo() {
		return enNo;
	}

	public void setEnNo(int enNo) {
		this.enNo = enNo;
	}

	public String getRiVihicleId() {
		return riVihicleId;
	}

	public void setRiVihicleId(String riVihicleId) {
		this.riVihicleId = riVihicleId;
	}

	public String getRiDepartureArea() {
		return riDepartureArea;
	}

	public void setRiDepartureArea(String riDepartureArea) {
		this.riDepartureArea = riDepartureArea;
	}

	public String getRiArrivalArea() {
		return riArrivalArea;
	}

	public void setRiArrivalArea(String riArrivalArea) {
		this.riArrivalArea = riArrivalArea;
	}

	public String getRiDepartureDate() {
		return riDepartureDate;
	}

	public void setRiDepartureDate(String riDepartureDate) {
		this.riDepartureDate = riDepartureDate;
	}

	public String getRiArrivalDate() {
		return riArrivalDate;
	}

	public void setRiArrivalDate(String riArrivalDate) {
		this.riArrivalDate = riArrivalDate;
	}

	public int getRiFare() {
		return riFare;
	}

	public void setRiFare(int riFare) {
		this.riFare = riFare;
	}

	public String getRiSeatGrade() {
		return riSeatGrade;
	}

	public void setRiSeatGrade(String riSeatGrade) {
		this.riSeatGrade = riSeatGrade;
	}

	@Override
	public String toString() {
		return "ReservationInfo [riNo=" + riNo + ", enNo=" + enNo + ", riVihicleId=" + riVihicleId
				+ ", riDepartureArea=" + riDepartureArea + ", riArrivalArea=" + riArrivalArea + ", riDepartureDate="
				+ riDepartureDate + ", riArrivalDate=" + riArrivalDate + ", riFare=" + riFare + ", riSeatGrade="
				+ riSeatGrade + "]";
	}

	
}
