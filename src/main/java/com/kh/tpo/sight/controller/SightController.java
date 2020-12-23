package com.kh.tpo.sight.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.kh.tpo.sight.common.Pagination;
import com.kh.tpo.sight.domain.PageInfo;
import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightReview;
import com.kh.tpo.sight.service.SightService;

@Controller
public class SightController {
	
	@Autowired
	private ApiController ac;
	
	@Autowired
	private SightService sService;

//  // sightList주소 불러오고, 페이징처리까지
	  @RequestMapping(value="sightList.tpo", method=RequestMethod.GET)
		public ModelAndView sightList (ModelAndView mv,ArrayList<Sight> sightList,
				@RequestParam(value="page", required=false)Integer page, Model model) throws Exception{
		  System.out.println(page);
		  int currentPage = (page!=null)? page:1;
		  int listCount = sService.getListCount();
		  System.out.println(listCount);
		  PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		  System.out.println(pi.toString());
		  ArrayList<Sight> sList = sService.selectSightList(pi);
//		  for(Sight list: sList) {
//				System.out.println(list.toString());
//			}
			  // DB에 저장된 값이 있는 경우
			  if(!sList.isEmpty()) {
				  mv.addObject("sList", sList);
				  mv.addObject("pi", pi);
				  mv.setViewName("sight/sightList");;
			  }
//			  else{ // DB에 저장된 값이 없는 경우
//				 ac.getSightList(sightList);
//				  if(!sList.isEmpty()) {
//					  mv.addObject("sList", sList);
//					  mv.setViewName("sight/sightList");;
//				  } else {
//					  mv.addObject("msg", "명소 조회 실패");
//					  mv.setViewName("common/errorPage");
//				  }
//			  }
			  else {
				  mv.setViewName("common/errorPage");
			  }
			  return mv;
		  }
		  
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
		  
		 
	  
//	  @RequestMapping(value="selectSight.tpo",method=RequestMethod.GET)
//	  public ModelAndView selectSight(ModelAndView mv, int sNo ,HttpServletRequest request) {
//		  Sight sight = new Sight();
//		  System.out.println(sNo);
//		  if(sService.selectSight(sNo) == null ){
//			  ac.getSightDetail(sNo);
//			  mv.addObject("msg","다시 시도해 주십시오");
//			  mv.setViewName("common/errorPage");
//			  
//			  
//		  } else {
//			  sight=sService.selectSight(sNo);
//			  mv.addObject("sight", sight)
//			  .setViewName("sight/sightDetail");
//			  System.out.println(sight.toString());
//
//		  }
//		  return mv;
//	  }
	  
	  @RequestMapping(value="sightReviewWrieteForm.tpo" , method= RequestMethod.GET )
	  public String writeReview() {
		  return "sight/reviewWriteForm";
	  }
	  
	  
	  @RequestMapping(value="insertReview.tpo", method=RequestMethod.POST)
	  public ModelAndView  insertReview (SightReview review, ModelAndView mv, 
			  @RequestParam(name="uploadFile", required=false)MultipartFile uploadFile, HttpServletRequest request  ) {
		  
		  System.out.println(uploadFile);
		  System.out.println(review);
		  if(!uploadFile.getOriginalFilename().equals("")) {
			  String filePath = saveFile(uploadFile, request);
			  if(filePath != null) {
				  review.setReviewPicture(uploadFile.getOriginalFilename());
					  
				  }
			  }
		  
		  int result = sService.insertReview(review, uploadFile, request);
		  if(result>0) {
		  mv.addObject(review).setViewName("sight/sightDetail");
		  }else {
			  mv.addObject("msg", "리뷰 등록실패!").setViewName("common/errorPage");
		  }
		  return mv;
	  }
	  
	  public String saveFile(MultipartFile file, HttpServletRequest request) {
			// 파일 저장 경로 설정
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\nuploadFiles";
			// 저장 폴더 선택
			File folder = new File(savePath);
			// 만약 폴더가 없을경우 자동 생성
			if(!folder.exists()) {
				folder.mkdir();
			}
			String filePath = folder + "\\" + file.getOriginalFilename();
			// 파일저장
			
			try {
				file.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return filePath;
		}
	  
	  // 명소체크된 값 불러오는 메소드
	  @ResponseBody
	  @RequestMapping(value="sightChkList.tpo", method=RequestMethod.GET)
	  public void sightChkList(HttpServletResponse response, int parking, int babyCar, int pet, @RequestParam(value="page", required=false)Integer page) throws Exception {
		  System.out.println("parking: " + parking +", babyCar: " + babyCar + ", pet: " + pet);
		  System.out.println(page);
		  int currentPage = (page!=null)? page:1;
		  int listCount = sService.getListCount();
		  System.out.println(listCount);
		  PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		  System.out.println(pi.toString());
		  HashMap<String,Integer> chkValue = new HashMap<String, Integer>();
		  chkValue.put("parking", parking);
		  chkValue.put("babyCar", babyCar);
		  chkValue.put("pet", pet);
		  ArrayList<Sight> sightList = sService.sightChkList(chkValue,pi);
		  for(Sight sight: sightList) {
		  System.out.println(sight.toString());
		  }
		  HashMap<String,Object> sightPage = new HashMap<String,Object>();
		  sightPage.put("sightList", sightList);
		  sightPage.put("pi", pi);
	      response.setContentType("application/json");
	      response.setCharacterEncoding("utf-8");
		  new Gson().toJson(sightPage, response.getWriter());
	  }
	  
}

	    

