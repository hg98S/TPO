package com.kh.tpo.reservation.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kh.tpo.reservation.domain.AirVo;
import com.kh.tpo.reservation.domain.Airport;
import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.MyUtils;
import com.kh.tpo.reservation.domain.TestFlight;

@Controller
public class ReservationController {

<<<<<<< HEAD
	//	@Autowired
	//	private ReservationService reservationService;
=======
//   @Autowired
//   private ReservationService reservationService;
   
   // 왕복
   @RequestMapping(value="getReservationDataSearch.tpo", method=RequestMethod.GET)
   public String getFlightScheduleSearch(Model model, String sDepAirportNm,String sArrAirportNm ,String sDepPlandTime, String sArrPlandTime, int adultCount , int childCount, int infantCount) {
      //가는거
      ArrayList<TestFlight> fList1 = searchair(sDepAirportNm,sArrAirportNm,sDepPlandTime);
      //오는거
      ArrayList<TestFlight> fList2 = searchair(sArrAirportNm,sDepAirportNm,sArrPlandTime);
      
      //요청좌석
      int adultChildCount = adultCount + childCount;
      
      System.out.println(fList1);
      System.out.println(fList2);
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
	// api값 받아오는 메소드
	public ArrayList<TestFlight> searchair(String sDepAirportNm, String sArrAirportNm, String sDepPlandTime) {
		String serviceKey = "EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D";
		JSONArray aItem = new JSONArray();
		ArrayList<TestFlight> fList = new ArrayList<TestFlight>();
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /* URL */
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("depAirportId", "UTF-8") + "=" + URLEncoder.encode(sDepAirportNm, "UTF-8")); /* 출발공항ID */
			urlBuilder.append("&" + URLEncoder.encode("arrAirportId", "UTF-8") + "=" + URLEncoder.encode(sArrAirportNm, "UTF-8")); /* 도착공항ID */
			urlBuilder.append("&" + URLEncoder.encode("depPlandTime", "UTF-8") + "=" + URLEncoder.encode(sDepPlandTime, "UTF-8")); /* 출발일 */
			urlBuilder.append("&" + URLEncoder.encode("airlineId", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 항공사ID */
			urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* 형식 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			//System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
			// conn.disconnect();
			// System.out.println(sb.toString());
=======
      
      model.addAttribute("fList",fList1);
      model.addAttribute("fList2",fList2);
      model.addAttribute("adultChildCount", adultChildCount);
      return "reservation/reservationSearchView";
   }
   
   public ArrayList<TestFlight> searchair(String sDepAirportNm,String sArrAirportNm ,String sDepPlandTime) {
      String serviceKey = "EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D";
      JSONArray aItem = new JSONArray();
      ArrayList<TestFlight> fList = new ArrayList<TestFlight>();
      StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
      try {
         urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
         urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
         urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*페이지 번호*/
         urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode(sDepAirportNm, "UTF-8")); /*출발공항ID*/
         urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode(sArrAirportNm, "UTF-8")); /*도착공항ID*/
         urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(sDepPlandTime, "UTF-8")); /*출발일*/
         urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*항공사ID*/
         urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*형식*/
         URL url = new URL(urlBuilder.toString());
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
         //conn.disconnect();
         //System.out.println(sb.toString());
>>>>>>> refs/remotes/origin/1221_CYJ

         FlightSchedule fsSchedule = null;
         ArrayList<FlightSchedule> fsList = new ArrayList<FlightSchedule>();

<<<<<<< HEAD
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
=======
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
>>>>>>> refs/remotes/origin/1221_CYJ

         // StringBuffer에 저장된 값을 FileOutputStream을 이용해서 파일을 만든다
         FileOutputStream output = new FileOutputStream("./FlightSchedule");
         output.write(sb.toString().getBytes());
         output.close();

<<<<<<< HEAD
			// Object obj = JSONValue.parse(new InputStreamReader(conn.getInputStream()));
			Object obj = JSONValue.parse(sb.toString());
=======

         // Object obj = JSONValue.parse(new InputStreamReader(conn.getInputStream()));
         Object obj = JSONValue.parse(sb.toString());
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
			// JSON 데이터를 JSONObject타입으로 만들어줌.
			JSONObject jObj = (JSONObject) obj;
			// System.out.println(jObj);
=======
         // JSON 데이터를 JSONObject타입으로 만들어줌.
         JSONObject jObj = (JSONObject) obj;
         //System.out.println(jObj);
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
			JSONObject jResponse = (JSONObject) jObj.get("response");
			// System.out.println(j_response);
=======
         JSONObject jResponse = (JSONObject) jObj.get("response");
         //System.out.println(j_response);
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
			JSONObject jBody = (JSONObject) jResponse.get("body");
			// System.out.println(j_body);
=======
         JSONObject jBody = (JSONObject) jResponse.get("body");
         //System.out.println(j_body);
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
			JSONObject jItems = (JSONObject) jBody.get("items");
			// System.out.println(j_items);
=======
         JSONObject jItems = (JSONObject) jBody.get("items");
         //System.out.println(j_items);
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
			aItem = (JSONArray) jItems.get("item");
			// System.out.println(aItem);
=======
         aItem = (JSONArray)jItems.get("item");
         //System.out.println(aItem);
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
			for (int i = 0; i < aItem.size(); i++) {
				TestFlight flight = new TestFlight();
				JSONObject reservationInfo = (JSONObject) aItem.get(i);
				// 2020-12-18 => 20201218
				// reservationInfo.get("depPlandTime").equals("20201218");
				flight.setDepPlandTime((Long) reservationInfo.get("depPlandTime"));
				flight.setArrPlandTime((Long) reservationInfo.get("arrPlandTime"));
				flight.setDepAirportNm((String) reservationInfo.get("depAirportNm"));
				flight.setArrAirportNm((String) reservationInfo.get("arrAirportNm"));
				flight.setAirlineNm((String) reservationInfo.get("airlineNm"));
=======

         for(int i = 0; i < aItem.size(); i++)
         {
            TestFlight flight = new TestFlight();
            JSONObject reservationInfo = (JSONObject)aItem.get(i);
            // 2020-12-18 => 20201218
            //reservationInfo.get("depPlandTime").equals("20201218");
            flight.setDepPlandTime((Long)reservationInfo.get("depPlandTime"));
            flight.setArrPlandTime((Long)reservationInfo.get("arrPlandTime"));
            flight.setDepAirportNm((String)reservationInfo.get("depAirportNm"));
            flight.setArrAirportNm((String)reservationInfo.get("arrAirportNm"));
            flight.setAirlineNm((String)reservationInfo.get("airlineNm"));
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
				if ((Long) reservationInfo.get("economyCharge") != null) {
					flight.setEconomyCharge((Long) reservationInfo.get("economyCharge"));
				} else {
					flight.setEconomyCharge(45000L);
				}
=======
            if((Long)reservationInfo.get("economyCharge") != null) {
               flight.setEconomyCharge((Long)reservationInfo.get("economyCharge"));
            } else {
               flight.setEconomyCharge(45000L);
            }
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
				flight.setPrestigeCharge((Long) reservationInfo.get("prestigeCharge"));
				flight.setVihicleId((String) reservationInfo.get("vihicleId"));
				fList.add(flight);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fList;
	}
=======
            flight.setPrestigeCharge((Long)reservationInfo.get("prestigeCharge"));
            flight.setVihicleId((String)reservationInfo.get("vihicleId"));
            fList.add(flight);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return fList;
   }
   //편도
   @RequestMapping(value="getReservationData.tpo", method=RequestMethod.GET)
   public String getFlightSchedule(Model model, String sDepAirportNm, String sDepAirportNm2, String sArrAirportNm ,String sDepPlandTime, int adultCount , int childCount, int infantCount) {
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
	// 왕복
	@RequestMapping(value = "getReservationDataSearch.tpo", method = RequestMethod.GET)
	public String getFlightScheduleSearch(Model model, String sDepAirportNm, String sArrAirportNm, String sDepPlandTime,
			String sArrPlandTime, int adultCount, int childCount, int infantCount) {
		// 가는편
		ArrayList<TestFlight> fList1 = searchair(sDepAirportNm, sArrAirportNm, sDepPlandTime);
		// 오는편
		ArrayList<TestFlight> fList2 = searchair(sArrAirportNm, sDepAirportNm, sArrPlandTime);
		
		// 인원수
		int acCount = adultCount + childCount;
		int totalCount = adultCount + childCount + infantCount;

		model.addAttribute("fList", fList1);
		model.addAttribute("fList2", fList2);
		model.addAttribute("acCount", acCount);
		model.addAttribute("tCount", totalCount);
		return "reservation/reservationSearchView";
	}
=======
      ArrayList<TestFlight> fList = searchair(sDepAirportNm,sArrAirportNm,sDepPlandTime);

      model.addAttribute("fList",fList);
      return "reservation/reservationSearchView2";
   }
>>>>>>> refs/remotes/origin/1221_CYJ

	// 편도
	@RequestMapping(value = "getReservationData.tpo", method = RequestMethod.GET)
	public String getFlightSchedule(Model model, String sDepAirportNm, String sArrAirportNm,
			String sDepPlandTime, int adultCount, int childCount, int infantCount) {
		// 가는편
		ArrayList<TestFlight> fList = searchair(sDepAirportNm, sArrAirportNm, sDepPlandTime);

<<<<<<< HEAD
		// 인원수
		int acCount = adultCount + childCount;
		int totalCount = adultCount + childCount + infantCount;
		
		model.addAttribute("fList", fList);
		model.addAttribute("acCount", acCount);
		model.addAttribute("tCount", totalCount);
		return "reservation/reservationSearchView2";
	}

	@RequestMapping(value = "reservation.tpo", method = RequestMethod.GET)
	public String reservationView() {
		return "reservation/reservation";
	}
=======
   @RequestMapping(value="reservation.tpo", method=RequestMethod.GET)
   public String reservationView() {
      return "reservation/reservation";
   }
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
	@RequestMapping(value = "ex.tpo", method = RequestMethod.GET)
	public String reservationSearchView() {
		return "reservation/reservationSearchView";
	}
=======
   @RequestMapping(value="ex.tpo", method=RequestMethod.GET)
   public String reservationSearchView() {
      return "reservation/reservationSearchView";
   }
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
	@RequestMapping(value = "ex2.tpo", method = RequestMethod.GET)
	public String passengerInsertForm() {
		return "reservation/passengerInsertForm";
	}
=======
   @RequestMapping(value="ex2.tpo", method=RequestMethod.GET)
   public String passengerInsertForm() {
      return "reservation/passengerInsertForm";
   }
>>>>>>> refs/remotes/origin/1221_CYJ

<<<<<<< HEAD
	@RequestMapping(value = "insertPassenger.tpo", method = RequestMethod.POST)
	public String reservationDetailView() {
		return "reservation/reservationDetailView";
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="reservationSearchView.tpo", method =
	 * RequestMethod.GET) public JSONArray testReservationSearchView() throws
	 * Exception { StringBuilder urlBuilder = new StringBuilder(
	 * "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"
	 * ); URL urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") +
	 * "=EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D"
	 * ); Service Key urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8")
	 * + "=" + URLEncoder.encode("200", "UTF-8")); 한 페이지 결과 수 urlBuilder.append("&"
	 * + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("",
	 * "UTF-8")); 페이지 번호 urlBuilder.append("&" +
	 * URLEncoder.encode("depAirportId","UTF-8") + "=" +
	 * URLEncoder.encode("NAARKSS", "UTF-8")); 출발공항ID urlBuilder.append("&" +
	 * URLEncoder.encode("arrAirportId","UTF-8") + "=" +
	 * URLEncoder.encode("NAARKPC", "UTF-8")); 도착공항ID urlBuilder.append("&" +
	 * URLEncoder.encode("depPlandTime","UTF-8") + "=" +
	 * URLEncoder.encode("20201220", "UTF-8")); 출발일 urlBuilder.append("&" +
	 * URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("",
	 * "UTF-8")); 항공사ID urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") +
	 * "=" + URLEncoder.encode("json", "UTF-8")); 형식 URL url = new
	 * URL(urlBuilder.toString()); HttpURLConnection conn = (HttpURLConnection)
	 * url.openConnection(); conn.setRequestMethod("GET");
	 * conn.setRequestProperty("Content-type", "application/json");
	 * System.out.println("Response code: " + conn.getResponseCode());
	 * BufferedReader rd; if(conn.getResponseCode() >= 200 && conn.getResponseCode()
	 * <= 300) { rd = new BufferedReader(new
	 * InputStreamReader(conn.getInputStream())); } else { rd = new
	 * BufferedReader(new InputStreamReader(conn.getErrorStream())); } StringBuilder
	 * sb = new StringBuilder(); String line; while ((line = rd.readLine()) != null)
	 * { sb.append(line); } rd.close(); //conn.disconnect();
	 * System.out.println(sb.toString());
	 * 
	 * Object obj = JSONValue.parse(sb.toString());
	 * 
	 * JSONObject jobj = (JSONObject)obj;
	 * 
	 * JSONObject obj_response = (JSONObject)jobj.get("response"); JSONObject obj1 =
	 * (JSONObject)obj_response.get("body"); JSONObject obj2 =
	 * (JSONObject)obj1.get("items"); JSONArray obj3 = (JSONArray)obj2.get("item");
	 * System.out.println(obj3);
	 * 
	 * String [] flightScheduleList = new String [obj3.size()];
	 * 
	 * for(int i = 0; i < obj3.size(); i++) {
	 * 
	 * JSONObject reservationInfo = (JSONObject)obj3.get(i); // 2020-12-18 =>
	 * 20201218 //reservationInfo.get("depPlandTime").equals("20201218"); Long
	 * depPlandTime = (Long)reservationInfo.get("depPlandTime"); Long arrPlandTime =
	 * (Long)reservationInfo.get("arrPlandTime"); String depAirportNm =
	 * (String)reservationInfo.get("depAirportNm"); String arrAirportNm =
	 * (String)reservationInfo.get("arrAirportNm"); String airlineNm =
	 * (String)reservationInfo.get("airlineNm"); Long economyCharge =
	 * (Long)reservationInfo.get("economyCharge"); Long prestigeCharge =
	 * (Long)reservationInfo.get("prestigeCharge"); String vihicleId =
	 * (String)reservationInfo.get("vihicleId");
	 * 
	 * if(airlineNm != null && economyCharge != null && prestigeCharge != null &&
	 * vihicleId != null) { System.out.println("========= " + (i+1) +
	 * "검색 내용 ========="); System.out.println("출발시간 : " + depPlandTime);
	 * System.out.println("도착시간 : " + arrPlandTime); System.out.println("출발공항 : " +
	 * depAirportNm); System.out.println("도착공항 : " + arrAirportNm);
	 * System.out.println("항공사명 : " + airlineNm); System.out.println("일반석운임료 : " +
	 * economyCharge); System.out.println("비즈니스석운임료 : " + prestigeCharge);
	 * System.out.println("항공편명 : " + vihicleId);
	 * 
	 * } else { System.out.println("========= " + (i+1) + "검색 내용 =========");
	 * System.out.println("비어있음"); } }
	 * 
	 * return obj3; }
	 */

	//	public static List<FlightSchedule> getAirportJson(String depAirportId, String arrAirportId, String depPlandTime) throws Exception {
	//    	String result = testReservationSearchView(depAirportId, arrAirportId, depPlandTime);
	//    	// Json형태의 String을 Json으로 만들기
	//    	JSONParser parser = new JSONParser();
	//    	JSONObject jsonObj = (JSONObject) parser.parse(result); 
	//    	// Object to JSONObject 다운캐스팅. json 처럼 생겨야지만 다운캐스팅 가능..
	//    	
	//    	//response
	//    	JSONObject j_response = (JSONObject) jsonObj.get("response");
	//    	//System.out.println(j_response);
	//    	JSONObject j_body = (JSONObject) j_response.get("body");
	//    	JSONObject j_items = (JSONObject) j_body.get("items");
	//    	JSONArray a_item = (JSONArray)j_items.get("item");
	//    	//System.out.println(a_item);
	//    	a_item.remove(0);
	//    	
	//    	// 1. Gson → 클래스로 변경 : AirVo
	//    	// Gson gson = new Gson();
	//    	// gson.fromJson(a_item.toString(), AirVo.class);
	//    	
	//    	// 2. Gson → 배열로 변경 : List<AirVo>
	//    	Gson gson = new Gson();
	//    	//List<AirVo> list = (List<AirVO>) gson.fromJson(a_item.toString(), AirVo.class);
	//    	List<FlightSchedule> list = gson.fromJson(a_item.toString(), new TypeToken<List<FlightSchedule>>(){}.getType());
	//    	for(FlightSchedule fs : list){
	//    		System.out.println(fs.getArrPlandTime());
	//    	}
	//    	
	//    	return list;
	//    }
	//	
	//	
	//	public String airport(FlightSchedule fs, Model model) throws Exception
	//	{
	//		Map<String, String> result = MyUtils.getAirportId();
	//		String depAirportId = result.get(fs.getDepAirportNm());
	//		String arrAirportId = result.get(fs.getArrAirportNm());
	//		String depPlandTime = fs.getDepPlandTime();
	//		String arrPlandTime = fs.getArrPlandTime();
	//		List<FlightSchedule> go = getAirportJson(depAirportId, arrAirportId, depPlandTime);
	//		List<FlightSchedule> back = getAirportJson(depAirportId, arrAirportId, arrPlandTime);
	//		
	//		model.addAttribute("go", go);
	//		model.addAttribute("back", back);
	//		
	//		return "reservation/reservationSearchView";
	//	}
}
=======
   @RequestMapping(value="insertPassenger.tpo", method=RequestMethod.POST)
   public String reservationDetailView() {
      return "reservation/reservationDetailView";
   }
   
   @ResponseBody
   @RequestMapping(value="reservationSearchView.tpo", method = RequestMethod.GET)
   public JSONArray testReservationSearchView() throws Exception
   {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("200", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKSS", "UTF-8")); /*출발공항ID*/
        urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20201220", "UTF-8")); /*출발일*/
        urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*항공사ID*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*형식*/
        URL url = new URL(urlBuilder.toString());
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
        //conn.disconnect();
        System.out.println(sb.toString());
        
        Object obj = JSONValue.parse(sb.toString());
        
        JSONObject jobj = (JSONObject)obj;
        
        JSONObject obj_response = (JSONObject)jobj.get("response");
        JSONObject obj1 = (JSONObject)obj_response.get("body");
        JSONObject obj2 = (JSONObject)obj1.get("items");
        JSONArray obj3 = (JSONArray)obj2.get("item");
        System.out.println(obj3);
        
        String [] flightScheduleList = new String [obj3.size()];
        
        for(int i = 0; i < obj3.size(); i++)
        {
           
          JSONObject reservationInfo = (JSONObject)obj3.get(i);
           // 2020-12-18 => 20201218
           //reservationInfo.get("depPlandTime").equals("20201218");
           Long depPlandTime = (Long)reservationInfo.get("depPlandTime");
           Long arrPlandTime = (Long)reservationInfo.get("arrPlandTime");
           String depAirportNm = (String)reservationInfo.get("depAirportNm");
           String arrAirportNm = (String)reservationInfo.get("arrAirportNm");
           String airlineNm = (String)reservationInfo.get("airlineNm");
           Long economyCharge = (Long)reservationInfo.get("economyCharge");
           Long prestigeCharge = (Long)reservationInfo.get("prestigeCharge");
           String vihicleId = (String)reservationInfo.get("vihicleId");
               
           if(airlineNm != null && economyCharge != null && 
                 prestigeCharge != null && vihicleId != null)
           {
               System.out.println("========= " + (i+1)  + "검색 내용 =========");
               System.out.println("출발시간 : " + depPlandTime);
               System.out.println("도착시간 : " + arrPlandTime);
               System.out.println("출발공항 : " + depAirportNm);
               System.out.println("도착공항 : " + arrAirportNm);
               System.out.println("항공사명 : " + airlineNm);
               System.out.println("일반석운임료 : " + economyCharge);
               System.out.println("비즈니스석운임료 : " + prestigeCharge);
               System.out.println("항공편명 : " + vihicleId);
               
           }
           else
           {
              System.out.println("========= " + (i+1)  + "검색 내용 =========");
              System.out.println("비어있음");
           }
        }
        
        return obj3;
    }
   
//   public static List<FlightSchedule> getAirportJson(String depAirportId, String arrAirportId, String depPlandTime) throws Exception {
//       String result = testReservationSearchView(depAirportId, arrAirportId, depPlandTime);
//       // Json형태의 String을 Json으로 만들기
//       JSONParser parser = new JSONParser();
//       JSONObject jsonObj = (JSONObject) parser.parse(result); 
//       // Object to JSONObject 다운캐스팅. json 처럼 생겨야지만 다운캐스팅 가능..
//       
//       //response
//       JSONObject j_response = (JSONObject) jsonObj.get("response");
//       //System.out.println(j_response);
//       JSONObject j_body = (JSONObject) j_response.get("body");
//       JSONObject j_items = (JSONObject) j_body.get("items");
//       JSONArray a_item = (JSONArray)j_items.get("item");
//       //System.out.println(a_item);
//       a_item.remove(0);
//       
//       // 1. Gson → 클래스로 변경 : AirVo
//       // Gson gson = new Gson();
//       // gson.fromJson(a_item.toString(), AirVo.class);
//       
//       // 2. Gson → 배열로 변경 : List<AirVo>
//       Gson gson = new Gson();
//       //List<AirVo> list = (List<AirVO>) gson.fromJson(a_item.toString(), AirVo.class);
//       List<FlightSchedule> list = gson.fromJson(a_item.toString(), new TypeToken<List<FlightSchedule>>(){}.getType());
//       for(FlightSchedule fs : list){
//          System.out.println(fs.getArrPlandTime());
//       }
//       
//       return list;
//    }
//   
//   
//   public String airport(FlightSchedule fs, Model model) throws Exception
//   {
//      Map<String, String> result = MyUtils.getAirportId();
//      String depAirportId = result.get(fs.getDepAirportNm());
//      String arrAirportId = result.get(fs.getArrAirportNm());
//      String depPlandTime = fs.getDepPlandTime();
//      String arrPlandTime = fs.getArrPlandTime();
//      List<FlightSchedule> go = getAirportJson(depAirportId, arrAirportId, depPlandTime);
//      List<FlightSchedule> back = getAirportJson(depAirportId, arrAirportId, arrPlandTime);
//      
//      model.addAttribute("go", go);
//      model.addAttribute("back", back);
//      
//      return "reservation/reservationSearchView";
//   }
}
>>>>>>> refs/remotes/origin/1221_CYJ
