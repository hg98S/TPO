package com.kh.tpo.main.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.tpo.main.domain.City;
import com.kh.tpo.main.domain.Urban;

@Repository
public class MainStoreLogic implements MainStore{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertCity(ArrayList<City> cityList) {
		return session.insert("MainMapper.insertCity", cityList);
	}

	@Override
	public int insertUrban(ArrayList<Urban> urbanList) {
		return session.insert("MainMapper.insertUrban", urbanList);
	}

	@Override
	public ArrayList<Urban> selectAllUrban() {
		return (ArrayList)session.selectList("MainMapper.selectAllUrban");
	}

	@Override
	public ArrayList<City> selectSeoul() {
		return (ArrayList)session.selectList("MainMapper.selectAllSeoul");
	}

}
