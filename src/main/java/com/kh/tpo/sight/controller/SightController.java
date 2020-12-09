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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.kh.tpo.sight.domain.PageInfo;
import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.store.Pagination;

@Controller
public class SightController {

	// 명소리스트 호출-> xml 저장코드
    
  public static void main(String[] args) throws IOException {
      StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
      urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=pJ3KoXLiUPTbegKASU9qcoZJUM5VTsBUzcx%2Fxun7o3kkoe942GUlF8ruLT1YrpsC4%2FejdjH3Rce%2FtJ2nU5hHyA%3D%3D"); /*Service Key*/
      urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지 결과수*/
      urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
      urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
      urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("TourAPI3.0_Guide", "UTF-8")); /*서비스명=어플명*/
      urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드, 시군구코드*/
      URL url = new URL(urlBuilder.toString());
      // url 연결
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Content-type", "application/json");
      System.out.println("Response code: " + conn.getResponseCode());
      BufferedReader rd;
      if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
          rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      } else {
          rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
      }
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = rd.readLine()) != null) {
          sb.append(line);
      }
      rd.close();
      conn.disconnect();
 
      ArrayList<Sight> sList = new ArrayList();
      try {
    	  // 문서읽는 개체 Document 생성
    	  // 
    	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	  DocumentBuilder dBuilder  =  dbFactory.newDocumentBuilder();
    	  
    	  // Stringbuffer 에 저장된 값을 FileOutputStream으로 파일은 만든다
    	  FileOutputStream output = new FileOutputStream("./SIGHT");
    	  output.write(sb.toString().getBytes());
    	  output.close();
    	  
    	  
    	// console 출력
          System.out.println(sb.toString());
    	  
          
          // xml 문서parsing
          Document doc = dBuilder.parse("./SIGHT");
          
          // 파싱된 xml 문서를 정규화 
          doc.getDocumentElement().normalize();
          
          Element item = (Element)doc.getElementsByTagName("item").item(0);
          Node id = item.getElementsByTagName("").item(0);
          Node a = item.getElementsByTagName("").item(0);
          Node b = item.getElementsByTagName("").item(0);
          System.out.println(id.getNodeName());
          System.out.println(id.getChildNodes().item(0).getNodeValue());
          
    	  
    	  
      }catch(Exception e) {
    	  
      }
      
      
      
  }
	
  // sightList주소 불러오고, 페이징처리까지
  @RequestMapping(value="sightList.tpo", method=RequestMethod.GET)
	public ModelAndView sightList (ModelAndView mv,
			@RequestParam(value="page", required=false)Integer page) {
		
	  // 
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
	  
	  mv.setViewName("sight/SightList");
	  return mv;
	}
}
