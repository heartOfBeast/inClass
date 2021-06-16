package ksmart39.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart39.mybatis.domain.Goods;
import ksmart39.mybatis.service.GoodsService;

@Controller
public class GoodsController {

	private final GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService =goodsService;
	}
	
	
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		model.addAttribute("title", "상품등록");
		
		return "goods/addGoods";
	}
	
	
	@PostMapping("/addGoods") 
	public String addGoods(Goods goods, HttpSession session, RedirectAttributes reattr) {
	 
	String goodssellerid = (String)session.getAttribute("SID");
	 
	//1.등록
	if(goodssellerid !=null) { goods.setGoodsSellerId(goodssellerid);
		  goodsService.addGoods(goods);
	}
	//2.등록 후에
	reattr.addAttribute("memberId", goodssellerid);
	return "redirect:/goodsList";
	  
	}

	
	@GetMapping("/goodsList")
	public String getGoodsList(Model model, @RequestParam(name="memberId", required = false)String memberId ) {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		if(memberId != null) paramMap.put("memberId",  memberId);
		List<Goods> goodsList = goodsService.getGoodsList(paramMap);
		model.addAttribute("title", "상품등록");
		model.addAttribute("goodsList", goodsList);
	
		return "goods/goodsList";
	}
}
