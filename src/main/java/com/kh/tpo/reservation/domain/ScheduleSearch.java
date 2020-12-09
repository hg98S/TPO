package com.kh.tpo.reservation.domain;

public class ScheduleSearch {

	// 매개변수
	private String searchDepartureArea; // 출발지
	private String searchArrivalArea; // 도착지
	private String searchDepartureDate; // 출발시간
	private String searchArrivalDate; // 도착시간
	private int adultCount; // 성인 인원수
	private int childCount; // 소아 인원수
	private int infantCount; // 유아 인원수
	private String searchAirline; // 항공사 검색
	private String searchTime; // 시간 검색
	private boolean cookieDel; // 쿠키 삭제
	
	// 기본 생성자
	public ScheduleSearch() {}

	// 매개변수 생성자
	public ScheduleSearch(String searchDepartureArea, String searchArrivalArea, String searchDepartureDate,
			String searchArrivalDate, int adultCount, int childCount, int infantCount, String searchAirline,
			String searchTime, boolean cookieDel) {
		super();
		this.searchDepartureArea = searchDepartureArea;
		this.searchArrivalArea = searchArrivalArea;
		this.searchDepartureDate = searchDepartureDate;
		this.searchArrivalDate = searchArrivalDate;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.infantCount = infantCount;
		this.searchAirline = searchAirline;
		this.searchTime = searchTime;
		this.cookieDel = cookieDel;
	}

	// getter/setter
	public String getSearchDepartureArea() {
		return searchDepartureArea;
	}

	public void setSearchDepartureArea(String searchDepartureArea) {
		this.searchDepartureArea = searchDepartureArea;
	}

	public String getSearchArrivalArea() {
		return searchArrivalArea;
	}

	public void setSearchArrivalArea(String searchArrivalArea) {
		this.searchArrivalArea = searchArrivalArea;
	}

	public String getSearchDepartureDate() {
		return searchDepartureDate;
	}

	public void setSearchDepartureDate(String searchDepartureDate) {
		this.searchDepartureDate = searchDepartureDate;
	}

	public String getSearchArrivalDate() {
		return searchArrivalDate;
	}

	public void setSearchArrivalDate(String searchArrivalDate) {
		this.searchArrivalDate = searchArrivalDate;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public int getInfantCount() {
		return infantCount;
	}

	public void setInfantCount(int infantCount) {
		this.infantCount = infantCount;
	}

	public String getSearchAirline() {
		return searchAirline;
	}

	public void setSearchAirline(String searchAirline) {
		this.searchAirline = searchAirline;
	}

	public String getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}

	public boolean isCookieDel() {
		return cookieDel;
	}

	public void setCookieDel(boolean cookieDel) {
		this.cookieDel = cookieDel;
	}

	// toString
	@Override
	public String toString() {
		return "ScheduleSearch [searchDepartureArea=" + searchDepartureArea + ", searchArrivalArea=" + searchArrivalArea
				+ ", searchDepartureDate=" + searchDepartureDate + ", searchArrivalDate=" + searchArrivalDate
				+ ", adultCount=" + adultCount + ", childCount=" + childCount + ", infantCount=" + infantCount
				+ ", searchAirline=" + searchAirline + ", searchTime=" + searchTime + ", cookieDel=" + cookieDel + "]";
	}
}
