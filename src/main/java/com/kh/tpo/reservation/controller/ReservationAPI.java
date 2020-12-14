package com.kh.tpo.reservation.controller;

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

import com.kh.tpo.reservation.domain.FlightSchedule;

public class ReservationAPI {
	public static void main(String[] args) throws IOException {

		String serviceKey = "EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D";

		// 국내항공 조회
		StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKSS", "UTF-8")); /*출발공항ID*/
		urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/
		urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20201216", "UTF-8")); /*출발일*/
		urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*항공사ID*/
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
		conn.disconnect();
		System.out.println(sb.toString());

		FlightSchedule flightSchedule = null;
		ArrayList<FlightSchedule> fsList = new ArrayList<FlightSchedule>();
		String fsName = null;
		String airlineName = null;
		String departureDate = null;
		String departureArea = null;
		String arrivalDate = null;
		String arrivalArea = null;
		String economyChargeFare = null;
		String prestigeChargeFare = null;

		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dFactory.newDocumentBuilder();

			FileOutputStream output = new FileOutputStream("./FLIGHTSCHEDULE");
			output.write(sb.toString().getBytes());
			output.close();

			Document doc = dBuilder.parse("./FLIGHTSCHEDULE");

			doc.getDocumentElement().normalize();
			org.w3c.dom.Node vihicleId = null;
			org.w3c.dom.Node airlineNm = null;
			org.w3c.dom.Node arrAirportNm = null;
			org.w3c.dom.Node arrPlandTime = null;
			org.w3c.dom.Node depAirportNm = null;
			org.w3c.dom.Node depPlandTime = null;
			org.w3c.dom.Node economyCharge = null;
			org.w3c.dom.Node prestigeCharge = null;

			for (int i = 0; i < 10; i++) {
				if(airlineNm != null) {
					Element item = (Element)doc.getElementsByTagName("item").item(i);
					
					vihicleId = item.getElementsByTagName("vihicleId").item(0);
					airlineNm = item.getElementsByTagName("airlineNm").item(0);
					arrAirportNm = item.getElementsByTagName("arrAirportNm").item(0);
					arrPlandTime = item.getElementsByTagName("arrPlandTime").item(0);
					depAirportNm = item.getElementsByTagName("depAirportNm").item(0);
					depPlandTime = item.getElementsByTagName("depPlandTime").item(0);
					economyCharge = item.getElementsByTagName("economyCharge").item(0);
					prestigeCharge = item.getElementsByTagName("prestigeCharge").item(0);
					
					fsName = vihicleId.getFirstChild().getNodeValue();
					airlineName = airlineNm.getFirstChild().getNodeValue();
					departureDate = depAirportNm.getFirstChild().getNodeValue();
					departureArea = depPlandTime.getFirstChild().getNodeValue();
					arrivalDate = arrAirportNm.getFirstChild().getNodeValue();
					arrivalArea = arrPlandTime.getFirstChild().getNodeValue();
					economyChargeFare = economyCharge.getFirstChild().getNodeValue();
					prestigeChargeFare = prestigeCharge.getFirstChild().getNodeValue();
					
					System.out.println("항공편명 : " + fsName
							+ ", 항공사명 : " + airlineName
							+ ", 출발지 : " + departureDate
							+ ", 출발시간 : " + departureArea
							+ ", 도착지 : " + arrivalDate
							+ ", 도착시간 : " + arrivalArea
							+ ", 일반석운임료 : " + economyChargeFare
							+ ", 비즈니스석운임료 : " + prestigeChargeFare);
				} else if (airlineNm == null) {
					
					Element item = (Element)doc.getElementsByTagName("item").item(i);
					
					vihicleId = item.getElementsByTagName("vihicleId").item(0);
					airlineNm = item.getElementsByTagName("airlineNm").item(0);
					arrAirportNm = item.getElementsByTagName("arrAirportNm").item(0);
					arrPlandTime = item.getElementsByTagName("arrPlandTime").item(0);
					depAirportNm = item.getElementsByTagName("depAirportNm").item(0);
					depPlandTime = item.getElementsByTagName("depPlandTime").item(0);
					
					fsName = vihicleId.getFirstChild().getNodeValue();
					departureDate = depAirportNm.getFirstChild().getNodeValue();
					departureArea = depPlandTime.getFirstChild().getNodeValue();
					arrivalDate = arrAirportNm.getFirstChild().getNodeValue();
					arrivalArea = arrPlandTime.getFirstChild().getNodeValue();
					
					System.out.println("항공편명 : " + fsName
							+ ", 출발지 : " + departureDate
							+ ", 출발시간 : " + departureArea
							+ ", 도착지 : " + arrivalDate
							+ ", 도착시간 : " + arrivalArea);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
