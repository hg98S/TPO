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
		  
		 
	  
		  @RequestMapping(value="selectSight.tpo",method=RequestMethod.GET)
		  public ModelAndView selectSight(ModelAndView mv,HttpServletRequest request) {
			  Sight sight = new Sight();
			  ArrayList<SightReview> rList = null;
			  String sNo = request.getParameter("sno");
			  int sightNumber = Integer.parseInt(sNo);
			  if(sService.selectSight(sightNumber) == null ){
				  ac.getSightDetail(sightNumber);
				  mv.addObject("msg","다시 시도해 주십시오");
				  mv.setViewName("common/errorPage");

			  } else {
				  sight=sService.selectSight(sightNumber);
				  if(sService.selectReviewList(sightNumber)!= null){
					  rList = sService.selectReviewList(sightNumber);
					  mv.addObject("sight", sight)
					  .addObject("review", rList)
					  .setViewName("sight/sightDetail");
				  }else {
					  sight=sService.selectSight(sightNumber);
					  rList = sService.selectReviewList(sightNumber);
					  mv.addObject("sight", sight)
					  .addObject("review", rList)
					  .setViewName("sight/sightDetail");
				  }
			  }
				  return mv;
			  }

//	  }
	  
	  @RequestMapping(value="sightReviewWrieteForm.tpo" , method= RequestMethod.GET )
	  public ModelAndView writeReview(ModelAndView mv, String sNo){
		  System.out.println(sNo);
		  mv.addObject("sNo", sNo)
		  .setViewName("sight/reviewWriteForm");
		  
		  return mv;
	  }
	  
	  
	  @RequestMapping(value="insertReview.tpo", method=RequestMethod.POST)
	  public ModelAndView  insertReview (SightReview review, ModelAndView mv, 
			  @RequestParam(name="uploadFile", required=false)MultipartFile uploadFile, HttpServletRequest request  ) {
		  
		  if(!uploadFile.getOriginalFilename().equals("")) {
			  String filePath = saveFile(uploadFile, request);
			  if(filePath != null) {
				  review.setReviewPicture(uploadFile.getOriginalFilename());
					  
				  }
			  }
		  
		  int result = sService.insertReview(review);
		  if(result>0) {
		  mv.addObject(review).setViewName("sight/sightDetail");
		  }else {
			  mv.addObject("msg", "리뷰 등록실패!").setViewName("common/errorPage");
		  }
		  return mv;
	  }

	  
		public String saveFile(MultipartFile file, HttpServletRequest request) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\reviewuploadfiles";
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
	  
	  
		@RequestMapping(value="deleteReview.tpo", method=RequestMethod.GET)
		public String reviewDelete ( Model model, HttpServletRequest request) {
			int reviewNo = 0;
			reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
			SightReview review = sService.selectReview(reviewNo);
			int result = sService.deleteReview(reviewNo);
			
			if(result >0) {
				if(review.getReviewPicture() != null) {
					deleteFile(review.getReviewPicture(), request);
				}
				return "redirect:sightList.rpo";
			}else {
				model.addAttribute("msg", "공지사항 삭제 실패");
				return "common/errorPage";
			}
			
		}
		public void deleteFile(String fileName, HttpServletRequest request) {
			// 파일 저장 경로 설정
			String root = request.getSession().getServletContext().getRealPath("resources");
			String deletePath = root + "\\reviewuploadfiles";
			// 삭제할 파일 경로를 통한 파일 객체생성
			File deleteFile = new File(deletePath+"\\"+fileName);
			// 해당 파일이 존재할 경우 삭제
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			
			
		}
}

	    

