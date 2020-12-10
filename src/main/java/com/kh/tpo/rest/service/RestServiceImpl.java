package com.kh.tpo.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.Room;
import com.kh.tpo.rest.domain.Search;
import com.kh.tpo.rest.store.RestStore;

@Service
public class RestServiceImpl implements RestService{
	
	@Autowired
	private RestStore reStore;

	public int insertRest(Rest rlist) {
		System.out.println("reService : " + rlist);
		int result = reStore.insertRest(rlist);
		System.out.println(result);
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
