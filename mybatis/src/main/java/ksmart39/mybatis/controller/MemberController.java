package ksmart39.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart39.mybatis.domain.Member;
import ksmart39.mybatis.service.GoodsService;
import ksmart39.mybatis.service.LoginService;
import ksmart39.mybatis.service.MemberService;

@Controller
public class MemberController {

	/**
	 * 필드 주입방식 (DI)
	 * MemberService memberService = new MemberService();
	 * 
	 * setter 주입방식
	 * setter 메소드 memberService
	 * 
	 * 생성자메소드 주입방식
	 * 생성자메소드 memberService
	 */
	
	/* @Autowired  필드 주입 방식
	private MemberService memberService; 
		@Autowired 
	private GoodsService goodsService;
	*/
	
	
	
	/* setter 메소드 주입 방식
	 * 
		private MemberService memberService;
		private GoodsService goodsService;

		@Autowired
		public void memberService(MemberService memberService , GoodsService goodsService) {
			this.memberService=memberService;
			this.goodsService=goodsService;
		}
		
	 * */
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	
	//생성자 메서드 주입방식
	private final MemberService memberService;
	private final GoodsService goodsService;
	
	@Autowired // => spring framework 4.3 이후부터 @Autowired 생략 가능
	public MemberController(MemberService memberService , GoodsService goodsService, LoginService loginService) {
		
		this.memberService=memberService;
		this.goodsService= goodsService;
	
	}
	
	@PostConstruct
	public void memberControllerInit() {
		
		log.info("=========================================");
		log.info("MemberController 객체생성");
		log.info("=========================================");
		
		
	}
	
	@PostMapping("/memberIdCheck")
	public @ResponseBody boolean memberIdCheck(@RequestParam(name = "memberId", required = false) String memberId) {
		boolean idCheck = true;
		log.info("memberIdCheck   memberId:::  {}", memberId);
		//idcheck 중복된 아이디가 있는 경우에는 false
		Member member = memberService.getMemberInfoById(memberId);
		if(member !=null) idCheck = false;

		
		return idCheck;
		
	};
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam(value = "memberId", required = false) String memberId, @RequestParam(value = "memberPw", required = false) String memberPw, HttpSession session, RedirectAttributes reAttr) {
		
		if(memberId != null && !"".equals(memberId) && memberPw != null && !"".equals(memberPw)) {
			Map<String, Object> resultMap = memberService.loginMember(memberId, memberPw);
			
			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			Member loginMember = (Member) resultMap.get("loginMember");
			
			if(loginCheck) {
				session.setAttribute("SID", loginMember.getMemberId());
				session.setAttribute("SNAME", loginMember.getMemberName());
				session.setAttribute("SLEVEL", loginMember.getMemberLevel());
				if("1".equals(loginMember.getMemberLevel())) {
					session.setAttribute("SLEVELNAME", "관리자");
				}else if("2".equals(loginMember.getMemberLevel())) {
					session.setAttribute("SLEVELNAME", "판매자");
				}else {
					session.setAttribute("SLEVELNAME", "구매자");

				}
				return "redirect:/";
			}
		}
		
		reAttr.addAttribute("loginResult", "등록된 회원이 없습니다.");
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(value = "loginResult", required = false) String loginResult) {
		
		model.addAttribute("title", "로그인화면");
		if(loginResult != null)model.addAttribute("loginResult", loginResult);
	
		return "login/login";
	}
	
	@PostMapping("/removeMember")
	public String removeMember(@RequestParam(value="memberId", required = false) String memberId, @RequestParam(value="memberPw", required = false) String memberPw,RedirectAttributes redirectAttr) {
		
		log.info("=========================================");
		log.info("화면에서 입력받은 값(회원탈퇴) memberId:{}", memberId);
		log.info("화면에서 입력받은 값(회원탈퇴) memberPw:{}", memberPw);
		log.info("=========================================");
		
		if(memberPw != null && !"".equals(memberPw)) {
			boolean result = memberService.removeMember(memberId, memberPw);
			if(result) {
				
				return "redirect:/memberList";
			}
		}
		redirectAttr.addAttribute("memberId", memberId);
		redirectAttr.addAttribute("result", "삭제실패");
		
		return "redirect:/removeMember";
	}
	
	@GetMapping("/removeMember")
	public String removeMember(@RequestParam(value="memberId", required = false) String memberId, @RequestParam(value="result", required = false) String result, Model model) {
		
		
		log.info("=========================================");
		log.info("화면에서 입력받은 값(회원탈퇴폼)");
		log.info("=========================================");
		
		model.addAttribute("title", "회원탈퇴폼");
		model.addAttribute("memberId", memberId);
		
		if(result != null) model.addAttribute("result", result);
		
		return "member/removeMember";
	}
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		log.info("=========================================");
		log.info("화면에서 입력받은 값(회원탈퇴) member:{}", member);
		log.info("=========================================");
		
		memberService.modifyMember(member);
		
		return "redirect:/memberList";
	}
	
	/**
	 * @requestParam(name = "memberId", required = false) = request.getParameter("memberId");
	 * @requestParam(name = "memberId", required = false) String memberId == String memberId = request.getParameter("memberId");
	 * 
	 * @return
	 */
	@GetMapping("/modifyMember")		//입력받고 바인딩 된 것을 memberId에 다시 바인딩
	public String modifyMember(@RequestParam(name = "memberId", required = false) String memberId, Model model) {
		
		
		log.info("=========================================");
		log.info("화면에서 입력받은 값(회원수정폼) memberId:{}", memberId);
		log.info("=========================================");
		
		
		//1. 회원 아이디로 회원테이블을 조회한 Member 객체
		Member member = memberService.getMemberInfoById(memberId);
		//2. Model 화면에 전달할 객체 삽입
		model.addAttribute("title", "회원수정폼");
		model.addAttribute("member", member);
		
		return "member/modifyMember";
	}
	
	@GetMapping("/addMember")
	public String addMember(Model model) {
		model.addAttribute("title", "회원가입폼");
		return "member/addMember";
	}
	
	/**
	 * 
	 * @param memberId, memberPw, . . . => Member dto의 멤버변수와 이름이 같다면 스프링이 알아서 바인딩해준다.
	 * 		    커맨드 객체(Member)
	 * 
	 */
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		
		log.info("=========================================");
		log.info("화면에서 입력받은 값(회원가입) member:{}", member);
		log.info("=========================================");
		
		
		memberService.addMember(member);
		
		return "redirect:/memberList";
	}
	
	@GetMapping("/memberList")
	public String getMemberList(Model model, @RequestParam(name = "searchKey", required = false) String searchKey, @RequestParam(name = "searchValue", required = false) String searchValue) {
		
		log.info("=========================================");
		log.info("searchKey", searchKey);
		log.info("searchKey", searchValue);
		log.info("=========================================");
		

		//map을 활용해서 검색 키워드 정리
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<Member> memberList = memberService.getMemberList(paramMap);
		
		
		log.info("=========================================");
		log.info("memberList:{}", memberList);
		log.info("=========================================");
		

		model.addAttribute("title", "회원목록");
		model.addAttribute("memberList", memberList);
		
		return "member/memberList";
	}
}
