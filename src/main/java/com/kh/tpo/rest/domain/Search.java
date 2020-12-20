package com.kh.tpo.rest.domain;

public class Search {
	private String searchName;
	private int minPrice;
	private int maxPrice;
	private String alignList;
	private String location;
	private int sleep;
	
	public Search() {}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getAlignList() {
		return alignList;
	}

	public void setAlignList(String alignList) {
		this.alignList = alignList;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	@Override
	public String toString() {
		return "Search [searchName=" + searchName + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", alignList="
				+ alignList + ", location=" + location + ", sleep=" + sleep + "]";
	}


	

	
	
	
}
