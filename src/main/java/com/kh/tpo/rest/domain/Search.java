package com.kh.tpo.rest.domain;

public class Search {
	private String searchName;
	private int minPrice;
	private int maxPrice;
	
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

	@Override
	public String toString() {
		return "Search [searchName=" + searchName + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}
	
	

	
	
	
}
