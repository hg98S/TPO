package com.kh.tpo.rest.controller;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.kh.tpo.rest.domain.Rest;


public class RestController {

	public static void main(String[] args) throws IOException {
		// url
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=qp7X139Hx%2BBYCZZ1IoBBD3cKG3aVLbxe6r5VN%2BsdjOJut6nmmxb6HUdCzPaIEHlDSLQYPJwnIUcIf%2FzEfEB5Wg%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
		urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
		urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*(A=제목순,B=조회순,C=수정순,D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
		urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록구분(Y=목록,N=개수)*/
		urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드*/
		urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구코드(areaCode 필수)*/
		urlBuilder.append("&" + URLEncoder.encode("hanOk","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*한옥 여부*/
		urlBuilder.append("&" + URLEncoder.encode("benikia","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*베니키아 여부*/
		urlBuilder.append("&" + URLEncoder.encode("goodStay","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*굿스테이 여부*/
		urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 수정일*/
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
		Rest rest = null;
		ArrayList<Rest> rlist = new ArrayList();
		try {
			// 문서를 읽기위한 Document객체를 만들어야함 (sqlSession만드는거랑 똑같다고 보면됨)
			// Factory를 만들고 생성된 Factory를 통해 DocumentBuilder를 만들어야 함
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();

			// StringBuffer에 저장된 값을 FileOutputStream을 이용해서 파일을 만든다
			FileOutputStream output = new FileOutputStream("./TEST");
			output.write(sb.toString().getBytes());
			output.close();

			System.out.println(sb.toString());
			
		    // XML문서 파싱
		    Document doc = dBuilder.parse("./TEST");
		    // 파싱된 XML문서를 정규화 작업
		    doc.getDocumentElement().normalize();
		   
		    Element item = (Element)doc.getElementsByTagName("item").item(0);
		    Node id = item.getElementsByTagName("addr1").item(0);
		    Node d = item.getElementsByTagName("addr1").item(0);
		    Node b = item.getElementsByTagName("addr1").item(0);
		    System.out.println(id.getNodeName());
		    System.out.println(id.getChildNodes().item(0).getNodeValue());
			
		}catch(Exception e) {
		      e.printStackTrace(); 
	    }

	}
}
