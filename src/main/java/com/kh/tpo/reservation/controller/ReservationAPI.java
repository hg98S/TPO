//package com.kh.tpo.reservation.controller;
//
//import java.io.BufferedReader;
//import java.io.FileOutputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONValue;
//import org.json.simple.parser.JSONParser;
//import org.w3c.dom.Document;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.kh.tpo.reservation.domain.FlightSchedule;
//
//public class ReservationAPI {
//	public static void main(String[] args) throws Exception {
//		String serviceKey = "EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D";
//
//		// 국내항공 조회
//		StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
//		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
//		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
//		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*페이지 번호*/
//		urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKSS", "UTF-8")); /*출발공항ID*/
//		urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/
//		urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20201218", "UTF-8")); /*출발일*/
//		urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*항공사ID*/
//		urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*형식*/
//		URL url = new URL(urlBuilder.toString());
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/json");
//		System.out.println("Response code: " + conn.getResponseCode());
//		BufferedReader rd;
//		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		} else {
//			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//		}
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = rd.readLine()) != null) {
//			sb.append(line);
//		}
//		rd.close();
//		conn.disconnect();
//		System.out.println(sb.toString());
//
//		FlightSchedule fsSchedule = null;
//		ArrayList<FlightSchedule> fsList = new ArrayList<FlightSchedule>();
//
//		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
//
//		// StringBuffer에 저장된 값을 FileOutputStream을 이용해서 파일을 만든다
//		FileOutputStream output = new FileOutputStream("./FlightSchedule");
//		output.write(sb.toString().getBytes());
//		output.close();
//
//
//		Object obj = JSONValue.parse(new InputStreamReader(conn.getInputStream()));
//
//		// JSON 데이터를 JSONObject타입으로 만들어줌.
//		JSONObject jObj = (JSONObject) obj;
//		//System.out.println(jObj);
//
//		JSONObject jResponse = (JSONObject) jObj.get("response");
//		//System.out.println(j_response);
//
//		JSONObject jBody = (JSONObject) jResponse.get("body");
//		//System.out.println(j_body);
//
//		JSONObject jItems = (JSONObject) jBody.get("items");
//		//System.out.println(j_items);
//
//		JSONArray aItem = (JSONArray)jItems.get("item");
//		System.out.println(aItem);
//
//		for (int i = 0; i < aItem.size(); i++) {
//			JSONObject schedule = (JSONObject)aItem.get(i);
//			System.out.println(schedule);
//		}
//	}
//
//
//		// XML문서 파싱
//		//		Document doc = dBuilder.parse("./FlightSchedule");
//		//		// 파싱된 XML문서를 정규화 작업
//		//		doc.getDocumentElement().normalize();
//		//		org.w3c.dom.Node response = null;
//		//		org.w3c.dom.Node body = null;
//		//		org.w3c.dom.Node items = null;
//		//		org.w3c.dom.NodeList item = doc.getElementsByTagName("item");
//		//		System.out.println(item);
//
//	}
//	//http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20201218&airlineId=AAR&_type=json
//	//Json으로 만들기
//	public static List<FlightSchedule> getAirportJson(String depAirportId, String arrAirportId, String depPlandTime) throws Exception {
//		String result = getAirportData(depAirportId, arrAirportId, depPlandTime);
//		// Json형태의 String을 Json으로 만들기
//		JSONParser parser = new JSONParser();
//		JSONObject jsonObj = (JSONObject) parser.parse(result); 
//		// Object to JSONObject 다운캐스팅. json 처럼 생겨야지만 다운캐스팅 가능..
//
//		//response
//		JSONObject j_response = (JSONObject) jsonObj.get("response");
//		JSONObject j_body = (JSONObject) j_response.get("body");
//		JSONObject j_items = (JSONObject) j_body.get("items");
//		JSONArray a_item = (JSONArray)j_items.get("item");
//		//System.out.println(a_item);
//
//		// 1. Gson → 클래스로 변경 : AirVO
//		// Gson gson = new Gson();
//		// gson.fromJson(a_item.toString(), AirVO.class);
//
//		// 2. Gson → 배열로 변경 : List<AirVO>
//		Gson gson = new Gson();
//		//List<AirVO> list = (List<AirVO>) gson.fromJson(a_item.toString(), AirVO.class);
//		List<FlightSchedule> list = gson.fromJson(a_item.toString(), new TypeToken<List<FlightSchedule>>(){}.getType());
//
//		for(FlightSchedule flightSchedule : list){
//			System.out.println(flightSchedule.getArrPlandTime());
//		}
//
//		return list;
//	}
//
////	public static void main(String[] args) {
////		try{
////			/*요청정보입력 * 아래와 같은 정보들은 사용자 가이드를 확인하여 찾아주시면 됩니다. * 위도 경도는 엑셀파일 안에 있습니다. * */
////			//자신이 조회를 원하는 지역의 경도와 위도를 입력해주세요 
////			String nx = "92"; 
////			//경도 
////			String ny = "131"; 
////			//위도 
////			String baseDate = "20180502"; 
////			// 자신이 조회하고싶은 날짜를 입력해주세요 
////			String baseTime = "0500"; 
////			//자신이 조회하고싶은 시간대를 입력해주세요 
////			// 서비스 인증키입니다. 공공데이터포털에서 제공해준 인증키를 넣어주시면 됩니다. 
////			String serviceKey = "개인별로 받은 인증키를 넣어주세요"; 
////			// 정보를 모아서 URL정보를 만들면됩니다. 맨 마지막 "&_type=json"에 따라 반환 데이터의 형태가 정해집니다. 
////			String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?" + "serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx="+ nx + "&ny=" + ny + "&_type=json"; URL url = new URL(urlStr);
////			// 위 urlStr을 이용해서 URL 객체를 만들어줍니다. 
////			BufferedReader bf;
////			String line = "";
////			String result="";
////			//날씨 정보를 받아옵니다.
////			bf = new BufferedReader(new InputStreamReader(url.openStream()));
////			//버퍼에 있는 정보를 하나의 문자열로 변환.
////			while((line=bf.readLine())!=null){ 
////				result=result.concat(line);
////				// System.out.println(result);
////				// 받아온 데이터를 확인해봅니다.
////			} 
////			// Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다.
////			JSONParser parser = new JSONParser();
////			JSONObject obj = (JSONObject) parser.parse(result);
////			// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
////			JSONObject parse_response = (JSONObject) obj.get("response");
////			// response 로 부터 body 찾아옵니다.
////			JSONObject parse_body = (JSONObject) parse_response.get("body");
////			// body 로 부터 items 받아옵니다.
////			JSONObject parse_items = (JSONObject) parse_body.get("items");
////			// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다 
////			JSONArray parse_item = (JSONArray) parse_items.get("item");
////			String category; JSONObject weather;
////			// parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
////			// 필요한 데이터만 가져오려고합니다.
////			for(int i = 0 ; i < parse_item.size(); i++) {
////				weather = (JSONObject) parse_item.get(i);
////				//String base_Date = (String)weather.get("baseDate");
////				//String fcst_Time = (String)weather.get("fcstDate");
////				double fcst_Value = ((Long)weather.get("fcstValue")).doubleValue();
////				//실수로된 값과 정수로된 값이 둘다 있어서 실수로 통일했습니다.
////				//String nX = (String)weather.get("nx");
////				//String nY = (String)weather.get("ny");
////				category = (String)weather.get("category");
////				//String base_Time = (String)weather.get("baseTime");
////				//String fcscDate = (String)weather.get("fcscDate");
////				// 출력합니다. System.out.print("배열의 "+i+"번째 요소");
////				System.out.print(" category : "+ category);
////				System.out.print(" fcst_Value : "+ fcst_Value);
////				System.out.println(); 
////			} // 마지막에보면 에러가 발생하였는데 casting문제입니다.
////			// 이는 반환되는 데이터타입이 달라서인데 이번 글에서는 여기까지만하고
////			// 데이터베이스에 입력할때는 수정해서 하겠습니다. 
////			bf.close(); 
////		}catch(Exception e){
////			System.out.println(e.getMessage());
////		} 
////	}
//}
//
//
////	public static void main(String[] args) {
////		List<FlightSchedule> getAirportJson = new List<FlightSchedule>();
////
////	}
//
//
//
///*FlightSchedule flightSchedule = null;
//		ArrayList<FlightSchedule> fsList = new ArrayList<FlightSchedule>();
//		String fsName = null;
//		String airlineName = null;
//		String departureDate = null;
//		String departureArea = null;
//		String arrivalDate = null;
//		String arrivalArea = null;
//		String economyChargeFare = null;
//		String prestigeChargeFare = null;
//
//		try {
//			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
//
//			FileOutputStream output = new FileOutputStream("./FLIGHTSCHEDULE");
//			output.write(sb.toString().getBytes());
//			output.close();
//
//			Document doc = dBuilder.parse("./FLIGHTSCHEDULE");
//
//			doc.getDocumentElement().normalize();
//			org.w3c.dom.Node vihicleId = null;
//			org.w3c.dom.Node airlineNm = null;
//			org.w3c.dom.Node arrAirportNm = null;
//			org.w3c.dom.Node arrPlandTime = null;
//			org.w3c.dom.Node depAirportNm = null;
//			org.w3c.dom.Node depPlandTime = null;
//			org.w3c.dom.Node economyCharge = null;
//			org.w3c.dom.Node prestigeCharge = null;
//
//			for (int i = 0; i < 10; i++) {
//				if(airlineNm != null) {
//					Element item = (Element)doc.getElementsByTagName("item").item(i);
//
//					vihicleId = item.getElementsByTagName("vihicleId").item(0);
//					airlineNm = item.getElementsByTagName("airlineNm").item(0);
//					arrAirportNm = item.getElementsByTagName("arrAirportNm").item(0);
//					arrPlandTime = item.getElementsByTagName("arrPlandTime").item(0);
//					depAirportNm = item.getElementsByTagName("depAirportNm").item(0);
//					depPlandTime = item.getElementsByTagName("depPlandTime").item(0);
//					economyCharge = item.getElementsByTagName("economyCharge").item(0);
//					prestigeCharge = item.getElementsByTagName("prestigeCharge").item(0);
//
//					fsName = vihicleId.getFirstChild().getNodeValue();
//					airlineName = airlineNm.getFirstChild().getNodeValue();
//					departureDate = depAirportNm.getFirstChild().getNodeValue();
//					departureArea = depPlandTime.getFirstChild().getNodeValue();
//					arrivalDate = arrAirportNm.getFirstChild().getNodeValue();
//					arrivalArea = arrPlandTime.getFirstChild().getNodeValue();
//					economyChargeFare = economyCharge.getFirstChild().getNodeValue();
//					prestigeChargeFare = prestigeCharge.getFirstChild().getNodeValue();
//
//					System.out.println("항공편명 : " + fsName
//							+ ", 항공사명 : " + airlineName
//							+ ", 출발지 : " + departureDate
//							+ ", 출발시간 : " + departureArea
//							+ ", 도착지 : " + arrivalDate
//							+ ", 도착시간 : " + arrivalArea
//							+ ", 일반석운임료 : " + economyChargeFare
//							+ ", 비즈니스석운임료 : " + prestigeChargeFare);
//				} else if (airlineNm == null) {
//
//					Element item = (Element)doc.getElementsByTagName("item").item(i);
//
//					vihicleId = item.getElementsByTagName("vihicleId").item(0);
//					airlineNm = item.getElementsByTagName("airlineNm").item(0);
//					arrAirportNm = item.getElementsByTagName("arrAirportNm").item(0);
//					arrPlandTime = item.getElementsByTagName("arrPlandTime").item(0);
//					depAirportNm = item.getElementsByTagName("depAirportNm").item(0);
//					depPlandTime = item.getElementsByTagName("depPlandTime").item(0);
//
//					fsName = vihicleId.getFirstChild().getNodeValue();
//					departureDate = depAirportNm.getFirstChild().getNodeValue();
//					departureArea = depPlandTime.getFirstChild().getNodeValue();
//					arrivalDate = arrAirportNm.getFirstChild().getNodeValue();
//					arrivalArea = arrPlandTime.getFirstChild().getNodeValue();
//
//					System.out.println("항공편명 : " + fsName
//							+ ", 출발지 : " + departureDate
//							+ ", 출발시간 : " + departureArea
//							+ ", 도착지 : " + arrivalDate
//							+ ", 도착시간 : " + arrivalArea);
//				}
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}*/
//
