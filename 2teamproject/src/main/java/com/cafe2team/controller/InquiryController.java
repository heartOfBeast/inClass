package com.cafe2team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InquiryController {

	@GetMapping("writeOneByOne")
	public String writeOneByOne(Model model) {
		model.addAttribute("title", "1:1 문의 작성");
		
		return "inquiry/writeOneByOne";
	}
	
	@GetMapping("sendOneByOne")
	public String sendOneByOne(Model model) {
		model.addAttribute("title", "1:1문의");
		
		return "inquiry/sendOneByOne";
	}
	
	
	@GetMapping("readInquiry")
	public String readInquire(Model model) {
		model.addAttribute("title", "문의게시판");
	
		return "inquiry/readInquiry";
	}
	
	
	@GetMapping("inquiryList")
	public String inquiryList(Model model) {
		model.addAttribute("title", "문의게시판");
		
		return "inquiry/inquiryList";
	}
}
