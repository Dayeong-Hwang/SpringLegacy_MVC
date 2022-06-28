package com.spring.conversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.conversion.service.OpenBankingService;
import com.spring.conversion.vo.AccountSearchRequestVO;
import com.spring.conversion.vo.AccountSearchResponseVO;
import com.spring.conversion.vo.RequestTokenVO;
import com.spring.conversion.vo.ResponseTokenVO;
import com.spring.conversion.vo.UserInfoRequestVO;
import com.spring.conversion.vo.UserInfoResponseVO;


@Controller
@Component
@PropertySource("classpath:config/api.properties")
public class OpenBankingController {
	@Value("${api.clientId}")
	private String clientId;
	@Value("${api.clientSecret}")
	private String clientSecret;

	 
	// OpenBankingService 객체 자동 주입
	@Autowired
	private OpenBankingService openBankingService;
	
	@RequestMapping(value = "/fintech", method = RequestMethod.GET)
	public String fintech() {
		return "fintech";
	}
	
	
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String getToken(@ModelAttribute RequestTokenVO requestToken, Model model) {
		// OAuth 인증 완료 후 전송되는 인증코드(code)를 자동으로 RequestTokenVO 객체에 저장
//		System.out.println("인증코드 : " + requestToken.getCode());
		
		// 응답데이터로 전달받은 인증코드를 사용하여 엑세스토큰 발급 받기
		ResponseTokenVO responseToken = openBankingService.requestToken(requestToken);
		
		// bank_main.jsp 페이지로 포워딩
		model.addAttribute("responseToken", responseToken);
		return "bank_main";
	}
	
	// 사용자 정보 조회
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String getUserInfo(@ModelAttribute UserInfoRequestVO userInfoRequestVO, Model model) {
		// Service 객체의 findUser() 메서드를 호출하여 사용자 정보 조회
		UserInfoResponseVO userInfo = openBankingService.findUser(userInfoRequestVO);
		
		// Model 객체에 UserInfoResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("access_token", userInfoRequestVO.getAccess_token());
		
		return "account/user_info";
	}
	
	// 등록계좌 조회
	@RequestMapping(value = "/accountList", method = RequestMethod.GET)
	public String getAccountList(@ModelAttribute AccountSearchRequestVO accountSearchRequestVO, Model model) {
		// Service 객체의 findAccount() 메서드를 호출하여 사용자 정보 조회
		AccountSearchResponseVO accountList = openBankingService.findAccount(accountSearchRequestVO);
		
		// Model 객체에 AccountSearchResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("accountList", accountList);
		model.addAttribute("access_token", accountSearchRequestVO.getAccess_token());
		
		return "account/list";
	}
	
}