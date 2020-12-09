package com.kh.tpo.reservation.domain;

import java.sql.Date;

public class Passenger {

	// 매개변수
	private int pNo; // 승객번호
	private int fsNo; // 항공일정번호
	private String pName; // 승객이름
	private String pGender; // 성별
	private Date pBirthday; // 생년월일
	private String nationality; // 국적
	private String pEmail; // 이메일
	private String pPhone; // 전화번호
	
	// 기본 생성자
	public Passenger() {}
	
	// 매개변수 생성자
	public Passenger(int pNo, int fsNo, String pName, String pGender, Date pBirthday, String nationality, String pEmail,
			String pPhone) {
		super();
		this.pNo = pNo;
		this.fsNo = fsNo;
		this.pName = pName;
		this.pGender = pGender;
		this.pBirthday = pBirthday;
		this.nationality = nationality;
		this.pEmail = pEmail;
		this.pPhone = pPhone;
	}

	// getter/setter
	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public Date getpBirthday() {
		return pBirthday;
	}

	public void setpBirthday(Date pBirthday) {
		this.pBirthday = pBirthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getpEmail() {
		return pEmail;
	}

	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public String getpPhone() {
		return pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	// toString
	@Override
	public String toString() {
		return "Passenger [pNo=" + pNo + ", fsNo=" + fsNo + ", pName=" + pName + ", pGender=" + pGender + ", pBirthday="
				+ pBirthday + ", nationality=" + nationality + ", pEmail=" + pEmail + ", pPhone=" + pPhone + "]";
	}
}
