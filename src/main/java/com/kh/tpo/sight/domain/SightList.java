package com.kh.tpo.sight.domain;

public class SightList {
	
	private int sNo;
	private String addr;
	private String title;
	public SightList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SightList(int sNo, String addr, String title) {
		super();
		this.sNo = sNo;
		this.addr = addr;
		this.title = title;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "SightList [sNo=" + sNo + ", addr=" + addr + ", title=" + title + "]";
	}
	
}
