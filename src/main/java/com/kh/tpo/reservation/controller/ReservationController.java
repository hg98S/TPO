package com.kh.tpo.reservation.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.TestFlight;

@Controller
public class ReservationController {

	//	@Autowired
	//	private ReservationService reservationService;

	@RequestMapping(value="getReservationData.tpo", method=RequestMethod.GET)
	public String getFlightSchedule(Model model, String sDepAirportNm,String sArrAirportNm ,String sDepPlandTime, int adultCount , int childCount, int infantCount) {

		String serviceKey = "EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D";
		JSONArray aItem = new JSONArray();
		ArrayList<TestFlight> fList = new ArrayList<TestFlight>();
		// 국내항공 조회
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
//			System.out.println(sb.toString());

			FlightSchedule fsSchedule = null;
			ArrayList<FlightSchedule> fsList = new ArrayList<FlightSchedule>();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();

			// StringBuffer에 저장된 값을 FileOutputStream을 이용해서 파일을 만든다
			FileOutputStream output = new FileOutputStream("./FlightSchedule");
			output.write(sb.toString().getBytes());
			output.close();


			// Object obj = JSONValue.parse(new InputStreamReader(conn.getInputStream()));
			Object obj = JSONValue.parse(sb.toString());

			// JSON 데이터를 JSONObject타입으로 만들어줌.
			JSONObject jObj = (JSONObject) obj;
			//System.out.println(jObj);

			JSONObject jResponse = (JSONObject) jObj.get("response");
			//System.out.println(j_response);

			JSONObject jBody = (JSONObject) jResponse.get("body");
			//System.out.println(j_body);

			JSONObject jItems = (JSONObject) jBody.get("items");
			//System.out.println(j_items);

			aItem = (JSONArray)jItems.get("item");
//			System.out.println(aItem);
			
			
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
				
				if((Long)reservationInfo.get("economyCharge") != null) {
					flight.setEconomyCharge((Long)reservationInfo.get("economyCharge"));
				} else {
					flight.setEconomyCharge(45000L);
				}
				
				flight.setPrestigeCharge((Long)reservationInfo.get("prestigeCharge"));
				flight.setVihicleId((String)reservationInfo.get("vihicleId"));
				fList.add(flight);
				System.out.println(flight);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fList",fList);
		return "reservation/reservationSearchView";
	}


	@RequestMapping(value="reservation.tpo", method=RequestMethod.GET)
	public String reservationView() {
		return "reservation/reservation";
	}

	@RequestMapping(value="ex.tpo", method=RequestMethod.GET)
	public String reservationSearchView() {
		return "reservation/reservationSearchView";
	}

	@RequestMapping(value="ex2.tpo", method=RequestMethod.GET)
	public String passengerInsertForm() {
		return "reservation/passengerInsertForm";
	}

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
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKSS", "UTF-8")); /*출발공항ID*/
		urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/
		urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*출발일*/
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
}
