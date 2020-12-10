package com.kh.tpo.rest.store;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.Room;
import com.kh.tpo.rest.domain.Search;

@Repository
public class RestStoreLogic implements RestStore{
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int insertRest(Rest rlist) {
		System.out.println(rlist.toString());
		int result = 0;
		result = session.insert("RestMapper.insertRest", rlist);
		System.out.println(rlist.toString());
		return result;
	}

	@Override
	public ArrayList<Rest> restSearchList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rest restSearchOne(Rest rest, ArrayList<Room> room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Rest> selectSearchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

}
