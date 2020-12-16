package com.kh.tpo.rest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.tpo.rest.domain.PageInfo;
import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.RestInfo;
import com.kh.tpo.rest.domain.Room;
import com.kh.tpo.rest.domain.Search;
import com.kh.tpo.rest.store.RestStore;

@Service
public class RestServiceImpl implements RestService{

	@Autowired
	private RestStore reStore;

	public int insertRest(ArrayList<Rest> list) {
		int result = 0;
			System.out.println("reService : " + list.toString());
			result = reStore.insertRest(list);
			System.out.println(result);
		return result;
	}

	@Override
	public ArrayList<Rest> restSearchList(PageInfo page) {
		// TODO Auto-generated method stub
		return reStore.restSearchList(page);
	}
	
	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return reStore.getListCount();
	}
	
	
	@Override
	public Rest restSearchOne(Rest rest) {
		// TODO Auto-generated method stub
		return reStore.restSearchOne(rest);
	}

	@Override
	public int insertRoom(ArrayList<Room> list) {
		// TODO Auto-generated method stub
		return reStore.insertRoom(list);
	}

	@Override
	public ArrayList<Room> roomSearchList(int reNo) {
		// TODO Auto-generated method stub
		return reStore.roomSearchList(reNo);
	} 

	@Override
	public ArrayList<Rest> selectSearchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room roomInfo(int rNo) {
		// TODO Auto-generated method stub
		return reStore.roomInfo(rNo);
	}

	@Override
	public int addReadCount(int reNo) {
		// TODO Auto-generated method stub
		return reStore.addReadCount(reNo);
	}

	@Override
	public ArrayList<Rest> SearchrName(Search search){
		// TODO Auto-generated method stub
		return reStore.SearchrName(search);
	}

	@Override
	public ArrayList<RestInfo> searchPrice(Search search) {
		// TODO Auto-generated method stub
		return reStore.searchPrice(search);
	}

	


}
