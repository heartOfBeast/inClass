package ksmart39.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.mybatis.domain.Member;

@Mapper
public interface MemberMapper {

	
	//회원테이블
	public int removeMemberById(String memberId);

	//상품테이블
	public int removeGoodsById(String memberId);

	//주문테이블(구매자용)
	public int removeOrderById(String memberId);

	//주문테이블(판매자용)
	public int removeOrderBySellerId(String memberId);

	//로그인테이블
	public int removeLoginById(String memberId);
	
	//회원정보 수정
	public int modifyMember(Member member);
	
	//회원 목록 조회
	public List<Member> getMemberList(Map<String, Object> paramMap);
	
	//회원 가입 (업데이트 딜리트 인서트는 int)
	public int addMember(Member member);
	
	//회원 정보 조회
	public Member getMemberInfoById(String memberId);
}
