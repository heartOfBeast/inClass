package ksmart39.mybatis.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import ksmart39.mybatis.domain.Goods;

@Mapper
public interface GoodsMapper {

	//상품추가
	public int addGoods(Goods goods);
	//상품목록조회
	public List<Goods> getGoodsList();
}
