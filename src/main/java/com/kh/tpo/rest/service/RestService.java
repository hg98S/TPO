package com.kh.tpo.rest.service;

import java.util.ArrayList;
import com.kh.tpo.rest.domain.PageInfo;
import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.Room;
import com.kh.tpo.rest.domain.Search;

public interface RestService {
	
	public int insertRest(ArrayList<Rest> list);
	public int insertRoom(ArrayList<Room> rooms);
	public ArrayList<Rest> restSearchList(PageInfo page);
	public Rest restSearchOne(int reNo);
	public ArrayList<Room> roomSearchList(int reNo);
	public ArrayList<Rest> selectSearchList(Search search);
	public int getListCount();
}
