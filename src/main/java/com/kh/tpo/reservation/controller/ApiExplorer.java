package com.kh.tpo.reservation.controller;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kh.tpo.reservation.domain.AirVo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApiExplorer
{
//	private static String getTagValue(String tag, Element element)
//	{
//		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
//		Node nodeValue = (Node) nodeList.item(0);
//		if(nodeValue ==  null)
//		{
//			return null;
//		}
//		return nodeValue.getNodeValue();
//	}
	
	public static void main(String[] args) throws Exception 
	{
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=EU79ymoWzbXgibv9N2xxkCNqTGTWwblmiNhJFJELWKjV322f7TRBlpIflk2DQtvooFmJZajrG9yhnaf1ozQ9ZQ%3D%3D"); /*Service Key*/
        //urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        //urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
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
        conn.disconnect();
        System.out.println(sb.toString());
        
        
        Object obj = JSONValue.parse(new InputStreamReader(conn.getInputStream()));
        
        JSONObject jobj = (JSONObject)obj;
        
        JSONObject obj1 = (JSONObject)jobj.get("body");
        JSONObject obj2 = (JSONObject)obj1.get("items");
        JSONArray obj3 = (JSONArray)obj2.get("item");
        
        String [] reservationList = new String[obj3.size()];
        ArrayList<AirVo> airList = new ArrayList<AirVo>();
        AirVo airVo = new AirVo();
        String noData = "";
        
        for(int i = 0; i < obj3.size(); i++)
        {
        	JSONObject reservationInfo = (JSONObject)obj3.get(i);
        	
        	String airlineNm = (String)reservationInfo.get("airlineNm");  /*항공사ID*/
        	String arrAirportNm = (String)reservationInfo.get("arrAirportNm"); /*도착공항ID*/
        	String arrPlandTime = (String)reservationInfo.get("arrPlandTime"); /*출발일도착시간*/
        	String depAirportNm = (String)reservationInfo.get("depAirportNm"); /*출발공항ID*/
        	String depPlandTime = (String)reservationInfo.get("depPlandTime"); /*출발일*/
        	String economyCharge = (String)reservationInfo.get("economyCharge"); /*일반석운임*/
        	String prestigeCharge = (String)reservationInfo.get("prestigeCharge"); /*비즈니스운임*/
        	String vihicleId = (String)reservationInfo.get("vihicleId"); /*항공편명*/
        	
        	System.out.println("airlineNm : " + airlineNm);
        	System.out.println("arrAirportNm : " + arrAirportNm);
        	System.out.println("arrPlandTime : " + arrPlandTime);
        	System.out.println("depAirportNm : " + depAirportNm);
        	System.out.println("depPlandTime : " + depPlandTime);
        	System.out.println("economyCharge : " + economyCharge);
        	System.out.println("prestigeCharge : " + prestigeCharge);
        	System.out.println("vihicleId : " + vihicleId);
//        	if(reservationInfo.is)
//        	{
//        		airlineNm = "항공사 : 배정없음";
//        	}
//        	else
//        	{
//        		
//        	}
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for(String data : reservationList)
        {
        	if(!arrayList.contains(data))
        	{
        		arrayList.add(data);
        	}
        }
        for(int i = 0; i < arrayList.size(); i++)
        {
        	airVo = new AirVo();
        	airVo.setAirlineNm(arrayList.get(i));
        	airVo.setArrAirportNm(arrayList.get(i));
        	airVo.setArrPlandTime(arrayList.get(i));
        	airVo.setDepAirportNm(arrayList.get(i));
        	airVo.setDepPlandTime(arrayList.get(i));
        	airVo.setEconomyCharge(arrayList.get(i));
        	airVo.setPrestigeCharge(arrayList.get(i));
        	airVo.setVihicleId(arrayList.get(i));
        	airList.add(airVo);
        }
        
        
        
//        try 
//        {
//        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			
//			FileOutputStream output = new FileOutputStream("./RESERVATION");
//	        output.write(sb.toString().getBytes());
//	        output.close();
//	        
//	        System.out.println(sb.toString());
//	        
//	        Document doc = dBuilder.parse("./RESERVATION");
//	        
//	        doc.getDocumentElement().normalize();
//	        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
//	        
//	        NodeList nodeList = doc.getElementsByTagName("item");
//	        
//	        for(int temp = 0; temp < nodeList.getLength(); temp++)
//	        {
//	        	Node node = nodeList.item(temp);
//	        	if(node.getNodeType() != Node.ELEMENT_NODE)
//	        	{
//	        		continue;
//	        	}
//	        	else
//	        	{
//	        		Element element = (Element) node;
//	        		System.out.println("############################");
//	        		System.out.println(element.getTextContent()); // 전체 정보 출력
//	        		try
//	        		{
//	        			System.out.println("항공사 : " + getTagValue("airlineNm", element)); // 태그별 정보
//	        		}
//	        		catch (Exception e)
//	        		{
//	        			System.out.println("항공사 : 배정없음");
//	        		}
//	        		System.out.println("도착공항 : " + getTagValue("arrAirportNm", element));
//	        		System.out.println("도착일자 : " + getTagValue("arrPlandTime", element));
//	        		System.out.println("출발공항 : " + getTagValue("depAirportNm", element));
//	        		System.out.println("출발일자 : " + getTagValue("depPlandTime", element));
//	        		try
//	        		{
//	        			System.out.println("일반석운임료 : " + getTagValue("economyCharge", element));
//	        		}
//	        		catch (Exception e)
//	        		{
//	        			System.out.println("일반석운임료 : 0");
//	        		}
//	        		try
//	        		{
//	        			System.out.println("비즈니스석운임료 : " + getTagValue("prestigeCharge", element));
//	        		}
//	        		catch (Exception e)
//	        		{
//	        			System.out.println("비즈니스석운임료 : 0");
//	        		}
//	        		System.out.println("항공편명 : " + getTagValue("vihicleId", element));
//	        	}
//	        }
//		}
//		catch (Exception e) 
//        {
//			e.printStackTrace();
//		}
        //return sb.toString();
    }
	
	// Json으로 만들기
//    public static List<AirVo> getAirportJson(String depAirportId, String arrAirportId, String depPlandTime) throws Exception {
//    	String result = getAirportData(depAirportId, arrAirportId, depPlandTime);
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
//    	List<AirVo> list = gson.fromJson(a_item.toString(), new TypeToken<List<AirVo>>(){}.getType());
//    	for(AirVo airVo : list){
//    		System.out.println(airVo.getArrPlandTime());
//    	}
//    	
//    	return list;
//    }
}
