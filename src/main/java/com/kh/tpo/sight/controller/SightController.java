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

<<<<<<< HEAD
=======

//tag값의 정보를 가져오는 메소드
//		private static String getTagValue(String tag, Element eElement) {
//		    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
//		    Node nValue = (Node) nlList.item(0);
//		    if(nValue == null) 
//		        return null;
//		    return nValue.getNodeValue();
//		}
//
//		public static void main(String[] args) {
//			int page = 1;	// 페이지 초기값 
//			try{
//				while(true){
//					// parsing할 url 지정(API 키 포함해서)
//					//String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?=pJ3KoXLiUPTbegKASU9qcoZJUM5VTsBUzcx%2Fxun7o3kkoe942GUlF8ruLT1YrpsC4%2FejdjH3Rce%2FtJ2nU5hHyA%3D%3D"+page;
//					 StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
//				      urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=pJ3KoXLiUPTbegKASU9qcoZJUM5VTsBUzcx%2Fxun7o3kkoe942GUlF8ruLT1YrpsC4%2FejdjH3Rce%2FtJ2nU5hHyA%3D%3D"); /*Service Key*/
//				      urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지 결과수*/
//				      urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
//				      urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
//				      urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("TourAPI3.0_Guide", "UTF-8")); /*서비스명=어플명*/
//				      urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드, 시군구코드*/
//				      URL url = new URL(urlBuilder.toString());
//					DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
//					DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
//					Document doc = dBuilder.parse(url);
//					
//					// root tag 
//					doc.getDocumentElement().normalize();
//					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//					
//					// 파싱할 tag
//					NodeList nList = doc.getElementsByTagName("item");
//					System.out.println("파싱할 리스트 수 : "+ nList.getLength());
//					
//					for(int temp = 0; temp < nList.getLength(); temp++){
//						Node nNode = nList.item(temp);
//						if(nNode.getNodeType() == Node.ELEMENT_NODE){
//							
//							Element eElement = (Element) nNode;
//							System.out.println("######################");
//							System.out.println(eElement.getTextContent());
//							System.out.println("주소  : " + getTagValue("addr1", eElement));
//							System.out.println("명소이름 : " + getTagValue("title", eElement));
//							System.out.println("상품명 : " + getTagValue("fin_prdt_nm", eElement));
//							System.out.println("연평균 수익률  : " + getTagValue("avg_prft_rate", eElement));
//							System.out.println("공시 이율  : " + getTagValue("dcls_rate", eElement));
//						}	// for end
//					}	// if end
					
//					page += 1;
//					System.out.println("page number : "+page);
//					if(page > 12){	
//						break;
//					}
//				}	// while end
//				
//			} catch (Exception e){	
//				e.printStackTrace();
//			}	// try~catch end
//		}	// main end
	
	
	
	
	
>>>>>>> refs/remotes/origin/1211CJH
//  // sightList주소 불러오고, 페이징처리까지
<<<<<<< HEAD
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
=======
//  @RequestMapping(value="sightList.tpo", method=RequestMethod.GET)
//	public ModelAndView sightList (ModelAndView mv,@RequestParam(value="page", required=false)Integer page) {
		
	  // 
>>>>>>> refs/remotes/origin/1211CJH
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
<<<<<<< HEAD
	  
	  
	 return "sight/sightList";
	}
=======
//	  
//	  mv.setViewName("sight/sightList");
//	  return mv;
//	}
>>>>>>> refs/remotes/origin/1211CJH
//  
 }

	    

