package com.kh.tpo.sight.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kh.tpo.sight.domain.Sight;
import com.kh.tpo.sight.domain.SightList;
import com.kh.tpo.sight.service.SightService;

@Controller
public class ApiController {

	@Autowired
	private SightService sService;


	// 명소리스트 호출-> xml 저장코드

	//  public static void main(String[] args) throws IOException {
	//      StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
	//      urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=pJ3KoXLiUPTbegKASU9qcoZJUM5VTsBUzcx%2Fxun7o3kkoe942GUlF8ruLT1YrpsC4%2FejdjH3Rce%2FtJ2nU5hHyA%3D%3D"); /*Service Key*/
	//      urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지 결과수*/
	//      urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
	//      urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
	//      urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("TourAPI3.0_Guide", "UTF-8")); /*서비스명=어플명*/
	//      urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드, 시군구코드*/
	//      URL url = new URL(urlBuilder.toString());
	//      // url 연결
	//      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	//      conn.setRequestMethod("GET");
	//      conn.setRequestProperty("Content-type", "application/json");
	//      System.out.println("Response code: " + conn.getResponseCode());
	//      BufferedReader rd;
	//      if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	//          rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	//      } else {
	//          rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	//      }
	//      StringBuilder sb = new StringBuilder();
	//      String line;
	//      while ((line = rd.readLine()) != null) {
	//          sb.append(line);
	//      }
	//      rd.close();
	//      conn.disconnect();
	// 
	//      ArrayList<Sight> sList = new ArrayList();
	//      try {
	//    	  // 문서읽는 개체 Document 생성
	//    	  // 
	//    	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	//    	  DocumentBuilder dBuilder  =  dbFactory.newDocumentBuilder();
	//    	  
	//    	  // Stringbuffer 에 저장된 값을 FileOutputStream으로 파일은 만든다
	//    	  FileOutputStream output = new FileOutputStream("./SIGHT");
	//    	  output.write(sb.toString().getBytes());
	//    	  output.close();
	//    	  
	//    	  
	//    	// console 출력
	//          System.out.println(sb.toString());
	//    	  
	//          
	//          // xml 문서parsing
	//          Document doc = dBuilder.parse("./SIGHT"); 

	// 파싱된 xml 문서를 정규화 
	//          doc.getDocumentElement().normalize();
	//          
	//          Element item = (Element)doc.getElementsByTagName("item").item(2);
	//          Node id = item.getElementsByTagName("title").item(0);
	//          Node a = item.getElementsByTagName("addr1").item(0);
	//          Node b = item.getElementsByTagName("firstimage").item(0);
	//          System.out.println(id.getNodeName());
	//          System.out.println(id.getChildNodes().item(2).getNodeValue());
	//          


	//      }catch(Exception e) {
	//    	  
	//      }
	//      
	//      
	//      
	//  }


	//tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		System.out.printf(tag, eElement);
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if(nValue == null) 
			return null;
		return nValue.getNodeValue();
	}

	//@RequestMapping(value="addSightList.kh", method=RequestMethod.POST)
	public void getSightList(ArrayList<SightList> sList) throws Exception {
		int page = 1;	// 페이지 초기값 
		//			try{
		while(true){
			// parsing할 url 지정(API 키 포함해서)
			//String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?=pJ3KoXLiUPTbegKASU9qcoZJUM5VTsBUzcx%2Fxun7o3kkoe942GUlF8ruLT1YrpsC4%2FejdjH3Rce%2FtJ2nU5hHyA%3D%3D"+page;
			StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=pJ3KoXLiUPTbegKASU9qcoZJUM5VTsBUzcx%2Fxun7o3kkoe942GUlF8ruLT1YrpsC4%2FejdjH3Rce%2FtJ2nU5hHyA%3D%3D"); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과수*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(Integer.toString(page), "UTF-8")); /*현재 페이지 번호*/
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("TourAPI3.0_Guide", "UTF-8")); /*서비스명=어플명*/
			urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드, 시군구코드*/
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
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

			//				      ArrayList<Sight> sList = new ArrayList();

			// Stringbuffer 에 저장된 값을 FileOutputStream으로 파일을 만든다
			FileOutputStream output = new FileOutputStream("./SIGHT");
			output.write(sb.toString().getBytes());
			output.close();

			// 만들 파일을 파싱하기위해 변수 생성
			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse("./SIGHT"); 

			// root tag 
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			System.out.println(doc.getDocumentElement());

			// 파싱할 tag~
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("파싱할 리스트 수 : "+ nList.getLength());

			for(int temp = 0; temp < nList.getLength(); temp++){
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){

					Element eElement = (Element) nNode;
					System.out.println("######################");
					//System.out.println(eElement.getTextContent());
					//System.out.println("주소  : " + getTagValue("addr1", eElement));
					//System.out.println("명소이름 : " + getTagValue("title", eElement));
					//System.out.println("명소 id : " + getTagValue("contentid", eElement));
					//System.out.println("연평균 수익률  : " + getTagValue("avg_prft_rate", eElement));
					//System.out.println("공시 이율  : " + getTagValue("dcls_rate", eElement));
					SightList sight = new SightList();
					String sNo = getTagValue("contentid", eElement);
					sight.setsNo(Integer.parseInt(sNo));
					sight.setAddr(getTagValue("addr1",eElement));
					sight.setTitle(getTagValue("title",eElement));


					//sList.setAddr(sNo)=getTagValue("contetnid", eElement) ;
					// sight DB에 넣기
					int result = sService.insertSightList(sight);
					if(result > 0) {
					}

					}	// if end
				}	// for end
				page += 1;
				System.out.println("page number : "+page);
				if(page > 20){	
					break;
				}
			}	// while end

			//			} catch (Exception e){	
			//				e.printStackTrace();
			//			}	// try~catch end



		}	// main end


	}
