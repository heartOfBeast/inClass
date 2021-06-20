package com.cafe2team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InquiryController {
 
	
	
	//문의게시판 댓글
	@GetMapping("inquiryReply")
	public String inquiryReply(Model model) {
		model.addAttribute("title", "댓글");
		
		return "redirect:/inquiry/readInquiry";
	}
	
	
	//자주묻는 질문
	@GetMapping("oftenFaq")
	public String oftenFaq(Model model) {
		model.addAttribute("title", "자주 묻는 질문");
		
		return "inquiry/oftenFaq";
	}
	

	//1:1문의
	@GetMapping("sendOneByOne")
	public String sendOneByOne(Model model) {
		model.addAttribute("title", "1:1문의");
		
		return "inquiry/sendOneByOne";
	}
	
	//작성글 읽기
	@GetMapping("readInquiry")
	public String readInquire(Model model) {
		model.addAttribute("title", "문의게시판");
	
		return "inquiry/readInquiry";
	}
	
	//문의게시판
	@GetMapping("inquiryList")
	public String inquiryList(Model model) {
		model.addAttribute("title", "문의게시판");
		
		return "inquiry/inquiryList";
	}
}
