package com.kh.tpo.main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.tpo.main.domain.City;
import com.kh.tpo.main.domain.Urban;
import com.kh.tpo.main.store.MainStore;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainStore mainStore;
	@Override
	public int insertCity(ArrayList<City> cityList) {
		return mainStore.insertCity(cityList);
	}
	@Override
	public int insertUrban(ArrayList<Urban> urbanList) {
		return mainStore.insertUrban(urbanList);
	}
	@Override
	public ArrayList<Urban> selectAllUrban() {
		return mainStore.selectAllUrban();
	}
	@Override
	public ArrayList<City> selectSeoul() {
		return mainStore.selectSeoul();
	}

}
