package com.kh.tpo.reservation.domain;

import java.sql.Date;

public class Reservation {

	// 매개변수
	private int enNo; // 예매등록번호
	private String userId; // 회원아이디
	private int pNo; // 승객번호
	private int rNo; // 예매번호
	private Date rDate; // 예매일자
	private int rPeople; // 인원
	
	// 기본 생성자
	public Reservation () {}

	// 매개변수 생성자
	public Reservation(int enNo, String userId, int pNo, int rNo, Date rDate, int rPeople) {
		super();
		this.enNo = enNo;
		this.userId = userId;
		this.pNo = pNo;
		this.rNo = rNo;
		this.rDate = rDate;
		this.rPeople = rPeople;
	}

	// getter/setter
	public int getEnNo() {
		return enNo;
	}

	public void setEnNo(int enNo) {
		this.enNo = enNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public int getrPeople() {
		return rPeople;
	}

	public void setrPeople(int rPeople) {
		this.rPeople = rPeople;
	}

	// toString
	@Override
	public String toString() {
		return "Reservation [enNo=" + enNo + ", userId=" + userId + ", pNo=" + pNo + ", rNo=" + rNo + ", rDate=" + rDate
				+ ", rPeople=" + rPeople + "]";
	}
}
