package com.kh.tpo.sight.service;

import java.util.ArrayList;

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
}
