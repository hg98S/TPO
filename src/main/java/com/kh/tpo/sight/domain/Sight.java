package com.kh.tpo.sight.domain;

public class Sight {

	private int sNo;
	private String sName;
	private String sLocation;
	private String sIntroduce;
	private String sFee;
	private String sPicture;
	private String sParking;
	private String sBabyCarriage;
	private String sPet;
	private String sToilet;
	public Sight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sight(int sNo, String sName, String sLocation, String sIntroduce, String sFee, String sPicture,
			String sParking, String sBabyCarriage, String sPet, String sToilet) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.sLocation = sLocation;
		this.sIntroduce = sIntroduce;
		this.sFee = sFee;
		this.sPicture = sPicture;
		this.sParking = sParking;
		this.sBabyCarriage = sBabyCarriage;
		this.sPet = sPet;
		this.sToilet = sToilet;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsLocation() {
		return sLocation;
	}
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	public String getsIntroduce() {
		return sIntroduce;
	}
	public void setsIntroduce(String sIntroduce) {
		this.sIntroduce = sIntroduce;
	}
	public String getsFee() {
		return sFee;
	}
	public void setsFee(String sFee) {
		this.sFee = sFee;
	}
	public String getsPicture() {
		return sPicture;
	}
	public void setsPicture(String sPicture) {
		this.sPicture = sPicture;
	}
	public String getsParking() {
		return sParking;
	}
	public void setsParking(String sParking) {
		this.sParking = sParking;
	}
	public String getsBabyCarriage() {
		return sBabyCarriage;
	}
	public void setsBabyCarriage(String sBabyCarriage) {
		this.sBabyCarriage = sBabyCarriage;
	}
	public String getsPet() {
		return sPet;
	}
	public void setsPet(String sPet) {
		this.sPet = sPet;
	}
	public String getsToilet() {
		return sToilet;
	}
	public void setsToilet(String sToilet) {
		this.sToilet = sToilet;
	}
	@Override
	public String toString() {
		return "Sight [sNo=" + sNo + ", sName=" + sName + ", sLocation=" + sLocation + ", sIntroduce=" + sIntroduce
				+ ", sFee=" + sFee + ", sPicture=" + sPicture + ", sParking=" + sParking + ", sBabyCarriage="
				+ sBabyCarriage + ", sPet=" + sPet + ", sToilet=" + sToilet + "]";
	}
	
	
}
