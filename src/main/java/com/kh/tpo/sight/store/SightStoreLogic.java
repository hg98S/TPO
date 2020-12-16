package com.kh.tpo.sight.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightList;
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
	public int insertSightList(SightList sList) {
		return sqlSession.insert("sightMapper.insertSightList", sList);
	}

}