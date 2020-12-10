package com.kh.tpo.rest.store;

import java.util.ArrayList;
import java.util.List;

import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.Room;
import com.kh.tpo.rest.domain.Search;

public interface RestStore {
	
	public int insertRest(Rest rest);
	public ArrayList<Rest> restSearchList();
	public Rest restSearchOne(Rest rest, ArrayList<Room> room);
	public ArrayList<Rest> selectSearchList(Search search);

}
