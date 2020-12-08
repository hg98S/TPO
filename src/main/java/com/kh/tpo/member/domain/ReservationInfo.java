package com.kh.tpo.member.domain;

import java.sql.Date;

public class ReservationInfo {

	private int riNo;
	private int enNo;
	private String riDepartureArea;
	private String riArrivatlArea;
	private Date riDepartureDate;
	private Date riArrivalDate;
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

	public String getRiDepartureArea() {
		return riDepartureArea;
	}

	public void setRiDepartureArea(String riDepartureArea) {
		this.riDepartureArea = riDepartureArea;
	}

	public String getRiArrivatlArea() {
		return riArrivatlArea;
	}

	public void setRiArrivatlArea(String riArrivatlArea) {
		this.riArrivatlArea = riArrivatlArea;
	}

	public Date getRiDepartureDate() {
		return riDepartureDate;
	}

	public void setRiDepartureDate(Date riDepartureDate) {
		this.riDepartureDate = riDepartureDate;
	}

	public Date getRiArrivalDate() {
		return riArrivalDate;
	}

	public void setRiArrivalDate(Date riArrivalDate) {
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
		return "ReservationInfo [riNo=" + riNo + ", enNo=" + enNo + ", riDepartureArea=" + riDepartureArea
				+ ", riArrivatlArea=" + riArrivatlArea + ", riDepartureDate=" + riDepartureDate + ", riArrivalDate="
				+ riArrivalDate + ", riFare=" + riFare + ", riSeatGrade=" + riSeatGrade + "]";
	}
	
	
}
