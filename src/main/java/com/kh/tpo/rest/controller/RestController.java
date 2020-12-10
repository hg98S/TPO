package com.kh.tpo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.tpo.rest.domain.Rest;
import com.kh.tpo.rest.service.RestService;


@Controller
public class RestController {
//	
	@Autowired
	private RestService reService;
	                                                                                                                                                                                                                        

	@RequestMapping(value="restList.tpo", method=RequestMethod.GET)
	public String restList() {
		return "rest/restList";
	}
	
	
	public void insertRest(@RequestBody Rest rest) {
		System.out.println(rest);                                                                       
		int result = reService.insertRest(rest);                                                                                        
		System.out.println(result);
		System.out.println("데이터 합친 값 " + rest);
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
}
