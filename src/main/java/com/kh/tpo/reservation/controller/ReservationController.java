package com.kh.tpo.reservation.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.tpo.reservation.domain.AirVo;
import com.kh.tpo.reservation.domain.MyUtils;
import com.kh.tpo.reservation.service.ReservationService;

@Controller
public class ReservationController {
	
//	@Autowired
//	private ReservationService reservationService;
	
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
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20201218", "UTF-8")); /*출발일*/
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
        
        for(int i = 0; i < obj3.size(); i++)
        {
        	JSONObject reservationInfo = (JSONObject)obj3.get(i);
        	//reservationInfo.get("depPlandTime").equals("20201218");
        	System.out.println(reservationInfo);
        }
        return obj3;
    }
}
