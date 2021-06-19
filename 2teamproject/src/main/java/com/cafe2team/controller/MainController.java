package com.cafe2team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String login(Model model) {
		
		return "logindefault";
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		
		return "main/main";
	}
}
