package ksmart39.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ksmart39.mybatis.dao.GoodsMapper;
import ksmart39.mybatis.domain.Goods;

@Service
public class GoodsService {

	private final GoodsMapper goodsMapper;
	
	@Autowired
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	//상품추가
	public int addGoods(Goods goods) {
		int result = goodsMapper.addGoods(goods);
		return result;
	}
	
	//상품목록
	public List<Goods> getGoodsList(Map<String, Object> paramMap){
		List<Goods> goodsList = goodsMapper.getGoodsList();
		
		return goodsList;
	}
	
}
