package com.kh.tpo.sight.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public int insertSightList(SightList sightList) {
		return sStore.insertSightList(sightList);
	}

	@Override
	public ArrayList<Sight> searchSight() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int insertReply(SightReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SightList> selectSightList() {
		
		return sStore.selectSightList();
	}

	@Override
	public Sight selectSight(int sNo) {
		return sStore.selectSight(sNo);
	}

	@Override
	public int insertReview(SightReview review, MultipartFile uploadFile, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

}
