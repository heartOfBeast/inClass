package com.cafe2team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	
	//창고별 물량
	@GetMapping("warehouseProduct")
	public String warehouseProduct(Model model) {
		model.addAttribute("title", "창고별물량");
		
		return "product/warehouseProduct";
	}
	//상품수정
	@GetMapping("modifyProduct")
	public String modifyProduct(Model model) {
		model.addAttribute("title", "상품수정");
		
		return "product/modifyProduct";
	}
	
	//상풍목록
	@GetMapping("productList")
	public String productList(Model model) {
		model.addAttribute("title", "상품목록");
		
		return "product/productList";
	}
	
	//상품추가
	@GetMapping("addProduct")
	public String addProduct(Model model) {
		model.addAttribute("title", "상품등록");
		
		return "product/addProduct";
	}
}
