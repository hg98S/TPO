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
import com.kh.tpo.sight.store.Pagination;

@Controller
public class SightController {
	
	@Autowired
	private ApiController ac;

//  // sightList주소 불러오고, 페이징처리까지
  @RequestMapping(value="sightList.tpo", method=RequestMethod.GET)
	public String sightList (ModelAndView mv,SightList sList,
			@RequestParam(value="page", required=false)Integer page, Model model) {
	  //리스트가 DB 에 있는지 없는지 확인해서 
	  // api controller 에서 list 추가
//	  if(sList == null) {
	  ApiController ac = new ApiController();
//	  try {
//		ac.getSightList(sList, model);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	  }
	  
	  // 페이징 처리
//	  int currentPage = (page != null) ? page:1;
//	  int listCount = sService.getListCount();
//	  PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
//	  ArrayList<Sight> sList = sService.selectList(pi);
//	  if(!sList.isEmpty()) {
//		  mv.addObject("sList",sList);
//		  mv.addObject("pi",pi);
//		  mv.setViewName("sight/sightList");
//	  } else {
//		  mv.addObject("msg","명소 전체 조회실패");
//		  mv.setViewName("common/errorPage");
//	  }
	  
	  
	 return "sight/sightList";
	}
//  
  }

	    

