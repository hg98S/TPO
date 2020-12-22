package com.kh.tpo.sight.store;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightReply;
import com.kh.tpo.sight.domain.SightReview;

@Repository
public class SightStoreLogic implements SightStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertSight(Sight sight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Sight> searchSight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReview(SightReview review) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inserReply(SightReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSightList(Sight sightList) {
		return sqlSession.insert("sightMapper.insertSightList", sightList);
	}

	@Override
	public ArrayList<Sight> selectSightList() {
		ArrayList<Sight> sList = (ArrayList)sqlSession.selectList("sightMapper.selectSightList");
//		for(SightList list: sList) {
//			System.out.println(list.toString());
//		}

		return sList;
	}

	@Override
	public Sight selectSight(int sNo) {
		return sqlSession.selectOne("sightMapper.selectSight", sNo);
	}

	@Override
	public ArrayList<Sight> sightChkList(HashMap<String, Integer> chkValue) {
		return (ArrayList)sqlSession.selectList("sightMapper.selectChkList", chkValue);
	}


}