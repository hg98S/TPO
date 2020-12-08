package com.kh.tpo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.tpo.member.domain.Member;
import com.kh.tpo.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	// 로그인 페이지이동
	@RequestMapping(value="loginView.tpo", method=RequestMethod.GET)
	public String  MemberLoginView() {
		return "member/MemberLoginView";
	}
	
	// 로그인
	@RequestMapping(value="login.tpo", method=RequestMethod.POST)
	public String MemberLogin(HttpServletRequest request, Model model,Member member) {
		HttpSession session  = request.getSession();
		Member loginUser = mService.memberLogin(member);
		if(loginUser!=null) {
		model.addAttribute("loginUser", loginUser);
		return "index";
		}else {
		return "common/errorPage";
		}
	}
	
	// 회원가입 화면이동
	@RequestMapping(value="memberJoinForm.tpo", method=RequestMethod.GET)
	public String MemberJoinForm() {
		return "member/MemberJoinForm";
	}
}
