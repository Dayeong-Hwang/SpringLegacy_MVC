package com.spring.conversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.conversion.service.MemberService;
import com.spring.conversion.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping(value = "/join.me", method = RequestMethod.GET)
	public String join() {
		
		return "member/joinForm";
	}

	
	@RequestMapping(value = "/joinPro.me", method = RequestMethod.POST)
	public String joinPost(@ModelAttribute MemberVO member, Model model) {

//		System.out.println(member);
		
		int insertCount = service.joinMember(member);
		if(insertCount == 0) { // 가입 실패
//			System.out.println("가입 실패!");
			model.addAttribute("msg", "가입실패했습니다!");
			// Dispatcher 방식으로 failBack.jsp 페이지로 포워딩
			return "failBack";
		} else { // 가입 성공
			System.out.println("가입성공을 축하드립니다!");
			// 홈(index.jsp 페이지)으로 이동
			return "redirect:/";
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestParam("member_id") String member_id) {
		
//		System.out.println(member_id);
		int cnt = service.idCheck(member_id);
		
		return cnt;
		
	}
}












