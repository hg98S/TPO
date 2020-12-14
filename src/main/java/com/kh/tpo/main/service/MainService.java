package com.kh.tpo.main.service;

import java.util.ArrayList;

import com.kh.tpo.main.domain.City;
import com.kh.tpo.main.domain.Urban;

public interface MainService {
	/*
	 * 전국 시도별 확진자 수 insert
	 * @param ArrayList<Urban>
	 * @result int
	 * */
	public int insertUrban(ArrayList<Urban> urbanList);
	/*
	 * 전국 시도별 확진자 수 select
	 * @param ArrayList<Urban>
	 * @result ArrayList<Urban>
	 * */
	public ArrayList<Urban> selectAllUrban();
	/*
	 * 서울 코로나 확진자 수 insert
	 * @param ArrayList<City>
	 * @result int
	 * */
	public int insertCity(ArrayList<City> cityList);
	/*
	 * 서울 확진자 수 select
	 * @param
	 * @result ArrayList<Urban>
	 * */
	public ArrayList<City> selectSeoul();
}
