package com.cafe2team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalesController {
	
	//매출리스트
	@GetMapping("/salesList")
	public String salesList(Model model) {
		model.addAttribute("title", "매출 내역 조회");
		
		return "sales/salesList";
	}
	
	//매출수정
	@GetMapping("/modifySales")
	public String modifyMember(Model model) {
		model.addAttribute("title", "매출수정");
		
		return "sales/modifySales";
	}
	
	//매출등록
	@GetMapping("/addSales")
	public String addSales(Model model) {
		model.addAttribute("title", "매출등록");
		
		return "sales/addSales";
	}
	
	//매출현황 메인폼
	@GetMapping("/currentSalesState")
	public String currentSalesState(Model model) {
		model.addAttribute("title", "매출현황");
		
		return "sales/currentSalesState";
	}
}
