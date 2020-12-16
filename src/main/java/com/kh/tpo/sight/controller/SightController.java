package com.kh.tpo.sight.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kh.tpo.sight.domain.PageInfo;
import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightList;
import com.kh.tpo.sight.domain.SightReview;
import com.kh.tpo.sight.service.SightService;
import com.kh.tpo.sight.store.Pagination;

@Controller
public class SightController {
	
	@Autowired
	private ApiController ac;
	
	@Autowired
	private SightService sService;

//  // sightList주소 불러오고, 페이징처리까지
	  @RequestMapping(value="sightList.kh", method=RequestMethod.GET)
		public ModelAndView sightList (ModelAndView mv,ArrayList<SightList> sightList,
				@RequestParam(value="page", required=false)Integer page, Model model) {
		  
		  
		  ArrayList<SightList> sList = sService.selectSightList();
			  
			  if(!sList.isEmpty()) {
				  mv.addObject("sList", sList);
				  mv.setViewName("sight/sightList");;
			  } else {
				  try {
					ac.getSightList(sightList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  if(!sList.isEmpty()) {
					  mv.addObject("sList", sList);
					  mv.setViewName("sight/sightList");;
				  } else {
					  mv.addObject("msg", "명소 조회 실패");
					  mv.setViewName("common/errorPage");
				  }
			  }
			  return mv;
		  }
//		  for(SightList list: sList) {
//				System.out.println(list.toString());
//			}
		  
//		  if(sList == null) {
//		  int currentPage = (page != null) ? page:1;
//		  int listCount = sService.getListCount();
//		  PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
//		  ArrayList<Sight> sList = sService.selectList(pi);
//		  if(!sList.isEmpty()) {
//			  mv.addObject("sList",sList);
//			  mv.addObject("pi",pi);
//			  mv.setViewName("sight/sightList");
//		  } else {
//			  mv.addObject("msg","명소 전체 조회실패");
//			  mv.setViewName("common/errorPage");
//		  }
		  
		 
	  
	  @RequestMapping(value="selectSight",method=RequestMethod.GET)
	  public ModelAndView selectSight(ModelAndView mv, int sNo ) {
		  Sight sight = new Sight();
		  sight = sService.selectSight(sNo);
		  if(sight != null ){
			  mv.addObject("sight", sight);
			  mv.setViewName("sight/sightDetail");
			  
		  } else {
			  mv.addObject("msg","명소세부정보조회실패");
			  mv.setViewName("common/errorPage");
		  }
		  
		  
		  return mv;
	  }
	  
	  public String insertReview (SightReview review) {
		  
		  //SightReview review = new SightReview();
		  //review.setReviewTitle(reviewTitle);
		  int result = sService.insertReview(review);
		  return null;
	  }
	  
}

	    

