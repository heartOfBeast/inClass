package com.cafe2team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/memberList")
	public String memberList() {
		
	return "member/memberList";
}
	
	@GetMapping("/accountsignup")
	public String accountsignup(Model model) {
		model.addAttribute("title", "거래처 회원가입");
		
		return "signup/accountsignup";
	}
	
	@GetMapping("/adminsignup")
	public String dminsignup(Model model) {
		model.addAttribute("title", "관리자 회원가입");
		
		return "signup/adminsignup";
	}
	
}



