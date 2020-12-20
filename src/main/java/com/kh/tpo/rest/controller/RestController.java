package com.kh.tpo.rest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.tpo.rest.common.pagination;
import com.kh.tpo.rest.domain.PageInfo;
import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.domain.RestInfo;
import com.kh.tpo.rest.domain.Search;
import com.kh.tpo.rest.service.RestService;


@Controller
public class RestController {
	//	
	@Autowired
	private RestService reService;
	
	
	// insert 삽입
	@RequestMapping(value="test.tpo", method = RequestMethod.GET)
	public void insertRest(ArrayList<Rest> list) throws IOException {
		/*
		 * Retest reste = new Retest(); reste.MacthList();
		 */
	//	System.out.println(list.toString());
		list = APIInfo.restAPI();
		int result = reService.insertRest(list);  
			if(result>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}

	}

	// 전체 조회
	@RequestMapping(value="restList.tpo", method=RequestMethod.GET)
	public ModelAndView restList(ModelAndView mv,  @RequestParam(value="page", required=false)Integer page) {
		int currentPage = (Integer) ((page != null) ? page : 1);
		int listCount = reService.getListCount();
		PageInfo pi = pagination.getPageInfo(currentPage, listCount);
		ArrayList<Rest> rList = reService.restSearchList(pi);
		if(!rList.isEmpty()) {
			mv.addObject("rList", rList);
			mv.addObject("pi", pi);
			mv.setViewName("rest/restList");
		}else {
			mv.addObject("msg", "숙소 리스트 조회 실패");
		}
		return mv;
	}
	
	//상세조회
	@RequestMapping(value="restDetail.tpo", method = RequestMethod.GET)
	public ModelAndView restOne(ModelAndView mv, Rest rest ,int reNo, Integer page) {
		reService.addReadCount(reNo);
		int currentPage = page !=null ? page:1;
		/* Rest rlist = reService.restSearchOne(rest); */
		// room 나오게 하기
		ArrayList<RestInfo> room = reService.roomSearchList(reNo);
	//	System.out.println(rest.toString());
		if(room != null) {
//			mv.addObject("room", room).addObject("currentPage", currentPage).addObject("rest", rlist).setViewName("rest/restOne");
			mv.addObject("room", room).addObject("currentPage", currentPage).setViewName("rest/restOne");
		}else {
			mv.addObject("msg", "게시글 상세조회 실패");
		}
		return mv;
	}
	
	// 숙소명 조회
	@RequestMapping(value="rNameSearch.tpo", method = RequestMethod.GET)
	public String rNameSearch(Model model, Search search) {
		//System.out.println(search.toString());
			ArrayList<Rest> rList = reService.SearchrName(search);
			if(!rList.isEmpty()) {
				model.addAttribute("rList", rList);
				model.addAttribute("search",search);
				return "rest/restList";
			}else {
				model.addAttribute("msg", "게시글 상세조회 실패");
				return "";
			}	
	}
	
	// 최저, 최고금액 조회
	@ResponseBody
	@RequestMapping(value="searchPrice.tpo", method=RequestMethod.GET)
	public void priceSearch(HttpServletResponse response, Search search) throws Exception {
	//	System.out.println(search.toString());
		ArrayList<RestInfo> rList = reService.searchPrice(search); 
		System.out.println("rList : " + rList.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(rList, response.getWriter());	
		/*
		 * if(!rList.isEmpty()) { model.addAttribute("rList", rList);
		 * model.addAttribute("search", search); return "success"; }else {
		 * model.addAttribute("msg", "게시글 상세조회 실패"); return "fail"; }
		 */
	}
	
	// 정렬
	@RequestMapping(value="alignList.tpo", method=RequestMethod.GET)
	  public ModelAndView alignRest(ModelAndView mv, Search search) {
		System.out.println( "search : " + search.toString());
		  ArrayList<RestInfo> rList = reService.alignList(search);
		  System.out.println("rList : " + rList.toString());
		  if(!rList.isEmpty()) {
			  mv.addObject("rList", rList);
			  mv.addObject("search", search);
			  mv.setViewName("rest/restList");
		  }	else {
				mv.addObject("msg", "게시글 상세조회 실패"); 
		  }
		  return mv;
	  }
	
	// 지역 검색
	@ResponseBody
	@RequestMapping(value="searchLocation.tpo", method=RequestMethod.GET)
	public void localSearch(HttpServletResponse response, Search search) throws Exception {
		ArrayList<RestInfo> rList = reService.searchLocal(search);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(rList, response.getWriter());	
		
	}
	 

	
	
	}

