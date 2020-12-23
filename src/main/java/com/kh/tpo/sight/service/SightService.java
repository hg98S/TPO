package com.kh.tpo.sight.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightReply;
import com.kh.tpo.sight.domain.SightReview;

public interface SightService {

	public int insertSight(Sight sight);
	public int insertSightList(Sight sightList);
	public ArrayList<Sight> selectSightList();
	public ArrayList<Sight> searchSight();
	public int insertReview(SightReview review, MultipartFile uploadFile, HttpServletRequest request);
	public int insertReply(SightReply reply);
	public Sight selectSight(int sNo);
	/*
	 * 체크에 따른 명소리스트 불러오기
	 * 
	 * @param HashMap<String,int>
	 * @return ArrayList<Sight>
	 * */
	public ArrayList<Sight> sightChkList(HashMap<String,Integer> chkValue);
	
	/* review */
	public ArrayList<SightReview> selectReviewList(int sNo);
	public SightReview selectReview(int reviewNo);
	public int deleteReview (int reviewNo);
}
