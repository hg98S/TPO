package com.kh.tpo.rest.store;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.tpo.rest.domain.PageInfo;
import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.RestInfo;
import com.kh.tpo.rest.domain.Room;
import com.kh.tpo.rest.domain.Search;

@Repository
public class RestStoreLogic implements RestStore{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return session.selectOne("RestMapper.getListCount");
	}

	@Override
	public int insertRest(ArrayList<Rest>  list) {
		System.out.println(list.toString());
		int result = 0;
			result = session.update("RestMapper.insertRest", list);
			System.out.println(list.toString());
		return result;
	}
	
	@Override
	public int insertRoom(ArrayList<Room> list) {
		// TODO Auto-generated method stub
		return session.update("RestMapper.selectRooms", list);
	}

	@Override
	public ArrayList<Rest> restSearchList(PageInfo page) {
		// TODO Auto-generated method stub
		int offset=(page.getCurrentPage()-1)*page.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, page.getBoardLimit());
		return (ArrayList)session.selectList("RestMapper.selectList", null, rowBounds);
	}

	@Override
	public Rest restSearchOne(Rest rest) {
		// TODO Auto-generated method stub
		return session.selectOne("RestMapper.selectOne",rest);
	}

	@Override
	public ArrayList<Rest> selectSearchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Room> roomSearchList(int reNo) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("RestMapper.selectRoomList", reNo);
	}

	@Override
	public Room roomInfo(int rNo) {
		// TODO Auto-generated method stub
		return session.selectOne("RestMapper.roomInfo", rNo);
	}

	@Override
	public int addReadCount(int reNo) {
		// TODO Auto-generated method stub
		return session.update("RestMapper.addCount",reNo);
	}

	@Override
	public ArrayList<Rest> SearchrName(Search search){
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("RestMapper.SearchrName", search);
	}

	@Override
	public ArrayList<RestInfo> searchPrice(Search search) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("RestMapper.SearchPrice", search);
	}




}