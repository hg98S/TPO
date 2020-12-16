package com.kh.tpo.rest.store;

import java.util.ArrayList;
import java.util.List;

import com.kh.tpo.rest.domain.PageInfo;
import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.RestInfo;
import com.kh.tpo.rest.domain.Room;
import com.kh.tpo.rest.domain.Search;

public interface RestStore {
	
	public int insertRest(ArrayList<Rest> list);
	public int insertRoom(ArrayList<Room> rooms);
	public ArrayList<Rest> restSearchList(PageInfo page);
	public Rest restSearchOne(Rest rest);
	public ArrayList<Room> roomSearchList(int reNo);
	public ArrayList<Rest> selectSearchList(Search search);
	public int getListCount();
	public Room roomInfo(int rNo);
	public int addReadCount(int reNo);
	public ArrayList<Rest> SearchrName(Search search);
	public ArrayList<RestInfo> searchPrice(Search search);

}
