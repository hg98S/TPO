package com.kh.tpo.sight.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightList;
import com.kh.tpo.sight.domain.SightReply;
import com.kh.tpo.sight.domain.SightReview;
import com.kh.tpo.sight.store.SightStore;

@Service
public class SightServiceImpl implements SightService{

	@Autowired
	private SightStore sStore;
	
	@Override
	public int insertSight(Sight sight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSightList(SightList sList) {
		return sStore.insertSightList(sList);
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
	public int insertReply(SightReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

}
