package com.cafe2team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WarehousingController {
	//한개의 입고 현황 확인
	@GetMapping("readWarehousingState")
	public String readWarehousingState(Model model) {
		model.addAttribute("title", "입고");
		
		return "warehousing/readWarehousingState";
	}
	
	//입고현황
	@GetMapping("warehousingState")
	public String warehousingState(Model model) {
		model.addAttribute("title", "입고현황");
		
		return "warehousing/warehousingState";
	}
	
	//한 개의 입고지시서 상세
	@GetMapping("readWarehousingDirection")
	public String readWarehousingDirection(Model model) {
		model.addAttribute("title", "입고지시서");
		
		return "warehousing/readWarehousingDirection";
	
	}
	
	
	//입고지시서 목록
	@GetMapping("warehousingDirectionList")
	public String warehousingDirectiongList(Model model) {
		model.addAttribute("title", "입고지시서 목록");
		
		return "warehousing/warehousingDirectionList";
	}

	//입고요청서 작성
	@GetMapping("warehousingRequest")
	public String warehousingRequest(Model model) {
		model.addAttribute("title", "입고요청");
		
		return "warehousing/warehousingRequest";
	}
}
