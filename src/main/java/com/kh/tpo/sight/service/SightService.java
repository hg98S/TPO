package com.kh.tpo.sight.service;

import java.util.ArrayList;

import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightList;
import com.kh.tpo.sight.domain.SightReply;
import com.kh.tpo.sight.domain.SightReview;

public interface SightService {

	public int insertSight(Sight sight);
	public int insertSightList(SightList sList);
	public ArrayList<Sight> searchSight();
	public int insertReview(SightReview review);
	public int insertReply(SightReply reply);
}
