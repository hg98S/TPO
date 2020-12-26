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

import com.kh.tpo.rest.domain.API1;
import com.kh.tpo.rest.domain.API2;
import com.kh.tpo.rest.domain.API3;
import com.kh.tpo.rest.domain.Rest;

//
public class APIInfo {
	//	
	//	 
	//	// 숙소 정보 호출
	public static ArrayList<Rest> restAPI() throws IOException {
		Rest rest = null;
		API1 info = null;
		API2 intro = null;
		API3 rec = null;	
		ArrayList<Rest> joined = new ArrayList<Rest>();
		String serviceKey =  "6B%2BzQRQRMk5iKSRdVZa28m%2BffDiHLBtrOGeNl5Jche0E4sUm3qQh9QzABnMxlnD3brePS5Jx7qAmWyAqyCcgHA%3D%3D";
		ArrayList<API1> rlist = new ArrayList<API1>();
		ArrayList<API3> rlist1 = new ArrayList<API3>();
		ArrayList<API2> rlist2 = new ArrayList<API2>();
		String totalCount = null;
		int check = 0;
		String bb = "39";		
		String page = "5";
		String currentPage = "1";
		// url 토탈 값 가져오기
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay"); /*URL*/
		urlBuilder.append( "?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(currentPage, "UTF-8")); /*현재 페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
		urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
		urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*(A=제목순,B=조회순,C=수정순,D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
		urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*목록구분(Y=목록,N=개수)*/
		urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(bb, "UTF-8")); /*지역코드*/
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
		//	System.out.println("Response code: " + conn.getResponseCode());
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

		//ArrayList<Rest> rlist = new ArrayList<Rest>();
		try {
			// sqlSession과 같은 코드
			// Factory를 만들고 생성된 Factory를 통해 DocumentBuilder를 만들어야 함
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();

			// 파일 만드는 위치
			FileOutputStream output = new FileOutputStream("./REST");
			output.write(sb.toString().getBytes());
			output.close();

			//	System.out.println(sb.toString());

			// XML문서 파싱
			Document doc = dBuilder.parse("./REST");
			// 파싱된 XML문서를 정규화 작업
			doc.getDocumentElement().normalize();
			org.w3c.dom.Node totalCnt = null;
			Element item = (Element)doc.getElementsByTagName("item").item(0);

			totalCnt =  item.getElementsByTagName("totalCnt").item(0);
			//	System.out.println(totalCnt.getNodeName() + " : " + totalCnt.getChildNodes().item(0).getNodeValue());
			totalCount = totalCnt.getFirstChild().getNodeValue();
			//	System.out.println(totalCount);						
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		check = Integer.parseInt(totalCount);
		String conList[] = new String[check];
		// 숙소정보 가져오기(숙소정보api)
		urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(currentPage, "UTF-8")); /*현재 페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
		urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
		urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*(A=제목순,B=조회순,C=수정순,D=생성일순) 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
		urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록구분(Y=목록,N=개수)*/
		urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(bb, "UTF-8")); /*지역코드*/
		urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구코드(areaCode 필수)*/
		urlBuilder.append("&" + URLEncoder.encode("hanOk","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*한옥 여부*/
		urlBuilder.append("&" + URLEncoder.encode("benikia","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*베니키아 여부*/
		urlBuilder.append("&" + URLEncoder.encode("goodStay","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*굿스테이 여부*/
		urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 수정일*/
		url = new URL(urlBuilder.toString());
		// url 연결 
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		//	System.out.println("Response code: " + conn.getResponseCode());
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		sb = new StringBuilder();
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//System.out.println(sb.toString());

		try {
			// sqlSession과 같은 코드
			// Factory를 만들고 생성된 Factory를 통해 DocumentBuilder를 만들어야 함
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();

			// 파일 만드는 위치
			FileOutputStream output = new FileOutputStream("./REST");
			output.write(sb.toString().getBytes());
			output.close();

			//	System.out.println(sb.toString());

			// XML문서 파싱
			Document doc = dBuilder.parse("./REST");
			// 파싱된 XML문서를 정규화 작업
			doc.getDocumentElement().normalize();
			org.w3c.dom.Node contentId = null;
			org.w3c.dom.Node reName = null;
			org.w3c.dom.Node addr1 = null;
			org.w3c.dom.Node addr2 = null;
			org.w3c.dom.Node firstImage = null;
			org.w3c.dom.Node tel = null;
			org.w3c.dom.NodeList tList = doc.getElementsByTagName("title");

			for(int i=0; i<tList.getLength(); i++ ) {
				info = new API1();
				Element item = (Element)doc.getElementsByTagName("item").item(i);

				contentId =  item.getElementsByTagName("contentid").item(0);

			//	System.out.println(contentId.getNodeName() + " : " + contentId.getChildNodes().item(0).getNodeValue());
				String conId = contentId.getChildNodes().item(0).getNodeValue();
				conList[i] = conId;
				System.out.println(conList[i]);
				reName  = item.getElementsByTagName("title").item(0);
				//	System.out.println(reName.getNodeName() + " : " + reName.getChildNodes().item(0).getNodeValue());
				String title = reName.getFirstChild().getNodeValue();
				info.setReName(title);

				//						addr1 = item.getElementsByTagName("addr1").item(0);
				//						if(addr1 != null) {
				//						String adress = addr1.getFirstChild().getNodeValue();
				//						rest.setReAddr(adress);
				//						System.out.println(addr1.getNodeName() + " : " + addr1.getChildNodes().item(0).getNodeValue());
				//						}else {
				//							addr1 = null;
				//						}
				addr1 = item.getElementsByTagName("addr1").item(0);
				addr2 = item.getElementsByTagName("addr2").item(0);
				if(addr1 != null && addr2 != null) {
					//		System.out.println(addr2.getNodeName() + " : " + addr2.getChildNodes().item(0).getNodeValue());
					String totalAddr = (addr1.getFirstChild().getNodeValue()) + ((addr2.getFirstChild().getNodeValue()));
					//		System.out.println("1+2"+totalAddr);
					info.setReAddr(totalAddr);
					//		System.out.println("totalAddr : " + totalAddr);
				}else if(addr1 != null && addr2 == null) {
					addr2 = null;
					String totalAddr = addr1.getFirstChild().getNodeValue();
					//		System.out.println("1"+totalAddr);
					info.setReAddr(totalAddr);	
				}else {
					addr1 = null;
					addr2= null;

				}
				String reImage = null;
				firstImage = item.getElementsByTagName("firstimage").item(0);
				if(firstImage != null) {
					//	System.out.println(firstImage.getNodeName() + " : " + firstImage.getChildNodes().item(0).getNodeValue());
					reImage = firstImage.getFirstChild().getNodeValue();
					info.setReImage(reImage);
				}else {
					reImage = "없음";
					info.setReImage(reImage);
				}			
				tel = item.getElementsByTagName("tel").item(0);	
				String rePhone = null;
				if(tel != null) {
					//		System.out.println(tel.getNodeName() + " : " + tel.getChildNodes().item(0).getNodeValue());
					rePhone = tel.getFirstChild().getNodeValue();
					info.setRePhone(rePhone);
				}else {
					rePhone = "준비중"; 
					info.setRePhone(rePhone);
				}
				rlist.add(info);
			}

			//		System.out.println("rlist : " + rlist.size());
			//		System.out.println("숙소정보" + rlist.toString());		
		}catch(Exception e) {
			e.printStackTrace(); 
		}

		// 소개정보조회


		//=		System.out.println("소개정보조회 check : " + check);	
		for(int t = 0; t<Integer.parseInt(page); t++) {
			//	System.out.println("1 : " +  t);
			urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과수*/
			//		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(totalCount, "UTF-8")); /*한 페이지 결과수*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(conList[t], "UTF-8")); /*콘텐츠 ID*/
			//	System.out.println("2 : " +  t);
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("32", "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
			url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			//		System.out.println("Response code: " + conn.getResponseCode());
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			sb = new StringBuilder();
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			sb.toString();
		//	System.out.println(sb.toString());
			//	System.out.println("3 : " +  t);

			rest = null;
			//rlist = new ArrayList<Rest>();
			try {
				// sqlSession과 같은 코드
				// Factory를 만들고 생성된 Factory를 통해 DocumentBuilder를 만들어야 함
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();

				// 파일 만드는 위치
				FileOutputStream output = new FileOutputStream("./REST");
				output.write(sb.toString().getBytes());
				output.close();

				//		System.out.println("정보 확인 용 " + sb.toString());

				// XML문서 파싱
				Document doc = dBuilder.parse("./REST");
				// 파싱된 XML문서를 정규화 작업
				doc.getDocumentElement().normalize();
				org.w3c.dom.Node accomCountLodging = null; // PTOTAL(수용가능 인원)
				org.w3c.dom.Node reservationUrl = null; // REURL(홈페이지 url)
				org.w3c.dom.Node checkInTime = null; // CHECKIN 입실
				org.w3c.dom.Node checkOutTime = null; // CHECKOUT 퇴실시간
				org.w3c.dom.Node roomCount = null; // RTOTAL 총 객실수
				org.w3c.dom.Node subFacility = null; // 부대시설
				org.w3c.dom.NodeList con = doc.getElementsByTagName("contentid");
				org.w3c.dom.NodeList num = doc.getElementsByTagName("numOfRows");

				for(int i=0; i<con.getLength(); i++ ) {
					for(int p=0; p<num.getLength(); p++ ) {
						rec = new API3();
						Element item = (Element)doc.getElementsByTagName("item").item(i);

						accomCountLodging  = item.getElementsByTagName("accomcountlodging").item(0);
						//System.out.println(accomCountLodging.getNodeName() + " : " + accomcountlodging.getChildNodes().item(0).getNodeValue());
						int result = 0;
						if(accomCountLodging != null) {
							String pTotal = accomCountLodging.getFirstChild().getNodeValue();
							String[]pTotal2 = pTotal.split("약| |명");
						//		System.out.println(accomCountLodging.getNodeName() + " : " + accomCountLodging.getChildNodes().item(0).getNodeValue());
					//		System.out.println("명수 체크 : " + pTotal.length());
							if(pTotal.length()>4) {
								result = Integer.parseInt(pTotal2[2]);
					//			System.out.println( "결과값 : " +result);
								rec.setpTotal(result);
							}else {
								result = Integer.parseInt(pTotal2[0]);
					//			System.out.println( "결과값 : " +result);
								rec.setpTotal(result);								
							}
						//	System.out.println("수용인원" + result);
						}else {
							result = 0;
							rec.setpTotal(result);
						}

						String reUrl = null;
						reservationUrl = item.getElementsByTagName("reservationurl").item(0);
						if(reservationUrl != null) {
							reUrl = reservationUrl.getFirstChild().getNodeValue();
							rec.setReUrl(reUrl);
						//	System.out.println("홈페이지 : " + reUrl);
						}else {
							reUrl = "준비중";
							rec.setReUrl(reUrl);
						}

						String checkIn = null;
						checkInTime = item.getElementsByTagName("checkintime").item(0);
						if(checkInTime != null) {
							checkIn = checkInTime.getFirstChild().getNodeValue();
							rec.setCheckIn(checkIn);
							//	System.out.println("입실시간 : " + checkIn);
						}else {
							checkIn="전화로 문의해주시기 바랍니다.";
							rec.setCheckIn(checkIn);
						}

						String checkOut = null;
						checkOutTime = item.getElementsByTagName("checkouttime").item(0);
						if(checkOutTime != null) {
							checkOut = checkOutTime.getFirstChild().getNodeValue();
							rec.setCheckout(checkOut);
							//	System.out.println("퇴실시간 : " + checkOut);
						}else {
							checkOut="전화로 문의해주시기 바랍니다.";
							rec.setCheckout(checkOut);
						}


						roomCount = item.getElementsByTagName("roomcount").item(0);
						if(roomCount != null) {
							String rCount = roomCount.getFirstChild().getNodeValue();
							String[]rCount2 = rCount.split("실|채|개");
							//	System.out.println(roomCount.getNodeName() + " : " + roomCount.getChildNodes().item(0).getNodeValue());
							result = Integer.parseInt(rCount2[0]);
							rec.setrTotal(result);
					//		System.out.println("총객실수 : " + result);
						}else {
							result = 0;
							rec.setrTotal(result);
						}

						String reFacility = "";							
						subFacility = item.getElementsByTagName("subfacility").item(0);
					//	System.out.println(roomCount.getNodeName() + " : " + roomCount.getChildNodes().item(0).getNodeValue());
						if(subFacility.getFirstChild()== null) {
							reFacility = "홈페이지에서 확인해주시기 바랍니다.";
						//	System.out.println(reFacility);
							rec.setReFacility(reFacility);	
							
						}
						if(subFacility.getFirstChild()!= null) {						
							reFacility = subFacility.getFirstChild().getNodeValue();
					//		System.out.println("세부내역 : " + reFacility);
							rec.setReFacility(reFacility);
						}
						
						

					}
					rlist1.add(rec);
				//	System.out.println("rlist : " + rlist.toString());
				}

				

			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}

		// 공통정보조회
		for(int t = 0; t<Integer.parseInt(page); t++) {
			urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(conList[t], "UTF-8")); /*콘텐츠 ID*/
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("32", "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
			urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*기본정보 조회여부*/
			urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*원본, 썸네일 대표이미지 조회여부*/
			urlBuilder.append("&" + URLEncoder.encode("areacodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드 조회여부*/
			urlBuilder.append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*대,중,소분류코드 조회여부*/
			urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*주소, 상세주소 조회여부*/
			urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*좌표 X,Y 조회여부*/
			urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*콘텐츠 개요 조회여부*/
			url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			//			System.out.println("Response code: " + conn.getResponseCode());
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			sb = new StringBuilder();
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			//        System.out.println(sb.toString());

			intro = null;
			//   rlist = new ArrayList<Rest>();
			try {
				// sqlSession과 같은 코드
				// Factory를 만들고 생성된 Factory를 통해 DocumentBuilder를 만들어야 함
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();

				// 파일 만드는 위치
				FileOutputStream output = new FileOutputStream("./REST");
				output.write(sb.toString().getBytes());
				output.close();

				//         System.out.println(sb.toString());

				// XML문서 파싱
				Document doc = dBuilder.parse("./REST");
				// 파싱된 XML문서를 정규화 작업
				doc.getDocumentElement().normalize();
				org.w3c.dom.Node overView  = null; // reInfo(숙소정보)
				org.w3c.dom.NodeList con = doc.getElementsByTagName("contentid");
				org.w3c.dom.NodeList num = doc.getElementsByTagName("numOfRows");

				for(int i=0; i<con.getLength(); i++ ) {
					for(int p=0; p<num.getLength(); p++ ) {
						intro = new API2();

						Element item = (Element)doc.getElementsByTagName("item").item(i);

						String reInfo = null;
						overView  = item.getElementsByTagName("overview").item(0);
						if(overView != null) {
							reInfo = overView.getFirstChild().getNodeValue();
							// System.out.println(overView.getNodeName() + " : " + overView.getChildNodes().item(0).getNodeValue());
						//	 System.out.println("숙박정보" + reInfo);
							intro.setReInfo(reInfo);
							intro.setpStatus("Y");

						}else {
							reInfo = "준비중";
							intro.setReInfo(reInfo);
							intro.setpStatus("Y");
						}

						//                  System.out.println(accomcountlodging.getNodeName() + " : " + accomcountlodging.getChildNodes().item(0).getNodeValue());

					}
					rlist2.add(intro);
				}
				//				 System.out.println("공통 정보" + rlist2.toString());                  
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}

		rest = new Rest();
		String reName = null;
		String reAddr = null;
		String reImage = null;
		String rePhone = null;
		String reUrl = null;
		String reCheckIn = null;
		String reCheckOut = null;
		int rTotal = 0;
		int pTotal = 0;
		String reFacility = null;
		String reInfo = null;
		String pStatus = null;
		//System.out.println(rlist1.size());
		for(int b=0; b<rlist1.size(); b++) {
			//System.out.println("b : " + b);
			for(int j=0; j<=b; j++) {
			//	System.out.println("j : " + j);
				rest = new Rest();
				reName = rlist.get(b).getReName();
				reAddr = rlist.get(b).getReAddr();
				reImage = rlist.get(b).getReImage();
				rePhone = rlist.get(b).getRePhone();
				reUrl = rlist1.get(b).getReUrl();
				reCheckIn = rlist1.get(b).getCheckIn();
				reCheckOut = rlist1.get(b).getCheckout();
				rTotal = rlist1.get(b).getrTotal();
				pTotal = rlist1.get(b).getpTotal();
				reFacility = rlist1.get(b).getReFacility();
				reInfo = rlist2.get(b).getReInfo();
				pStatus = rlist2.get(b).getpStatus();

				rest.setReName(reName);
				rest.setReAddr(reAddr);
				rest.setReImage(reImage);
				rest.setRePhone(rePhone);
				rest.setReUrl(reUrl);
				rest.setCheckIn(reCheckIn);
				rest.setCheckout(reCheckOut);
				rest.setrTotal(rTotal);
				rest.setpTotal(pTotal);
				rest.setReFacility(reFacility);
				rest.setReInfo(reInfo);
				rest.setpStatus(pStatus);
				//	System.out.println(rest.toString());
				//	System.out.println(b);
				
			}
		//	System.out.println(b);
			joined.add(rest);	
			System.out.println(joined.toString());	
		//	
		}
	
		//			System.out.println("최종정보 : " + rlist.toString());
		//			System.out.println("최종정보 : " + rlist1.toString());
		//			System.out.println("최종정보 : " + rlist2.toString());
		//	System.out.println(realFinal.toString());
		
		return joined;
	}



	////		System.out.println("최종정보 : " + rlist1.toString());
	////		System.out.println("최종정보 : " + rlist2.toString());
	////		
	//		
	////	}
	//	    
	public static void main(String[] args) {
		try {
			APIInfo.restAPI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	    	   		
}
