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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.tpo.reservation.domain.AirVo;
import com.kh.tpo.reservation.domain.FlightSchedule;
import com.kh.tpo.reservation.domain.MyUtils;

@Controller
public class ReservationController {

	@ResponseBody
	@RequestMapping(value="getReservationData.tpo", method=RequestMethod.GET)
	public JSONArray getFlightSchedule() {
		
		String serviceKey = "EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D";
		JSONArray aItem = new JSONArray();
		String depPlandTime = null;
		String arrAirportNm = null;
		String depAirportNm = null;
		
		// 국내항공 조회
		StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
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
			
			FlightSchedule fsSchedule = null;
			ArrayList<FlightSchedule> fsList = new ArrayList<FlightSchedule>();
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
			
			// StringBuffer에 저장된 값을 FileOutputStream을 이용해서 파일을 만든다
			FileOutputStream output = new FileOutputStream("./FlightSchedule");
			output.write(sb.toString().getBytes());
			output.close();
			
			
//			Object obj = JSONValue.parse(new InputStreamReader(conn.getInputStream()));
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
			System.out.println(aItem);
			
			for (int i = 0; i < aItem.size(); i++) {
				JSONObject schedule = (JSONObject)aItem.get(i);
				// 2020-12-18 => 20201218
				//schedule.get("depPlandTime").equals("20201220");
				System.out.println(schedule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aItem;
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

	@RequestMapping(value="reservationSearchView.tpo", method = RequestMethod.GET)
	public String airport(AirVo airVo, Model model) throws Exception
	{
		Map<String, String> result = MyUtils.getAirportId();
		String depAirportId = result.get(airVo.getDepAirportNm());
		String arrAirportId = result.get(airVo.getArrAirportNm());
		String depPlandTime = airVo.getDepPlandTime();
		String arrPlandTime = airVo.getArrPlandTime();
		List<AirVo> go = ApiExplorer.getAirportJson(depAirportId, arrAirportId, depPlandTime);
		List<AirVo> back = ApiExplorer.getAirportJson(depAirportId, arrAirportId, arrPlandTime);

		model.addAttribute("go", go);
		model.addAttribute("back", back);

		return "reservation/reservationSearchView";
	}	
}
