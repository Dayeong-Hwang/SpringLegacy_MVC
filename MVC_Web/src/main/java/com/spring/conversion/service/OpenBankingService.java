package com.spring.conversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.conversion.vo.AccountSearchRequestVO;
import com.spring.conversion.vo.AccountSearchResponseVO;
import com.spring.conversion.vo.RequestTokenVO;
import com.spring.conversion.vo.ResponseTokenVO;
import com.spring.conversion.vo.UserInfoRequestVO;
import com.spring.conversion.vo.UserInfoResponseVO;

@Service
public class OpenBankingService {// OpenBankingController - OpenBankingApiClient 객체 중간자 역할
	// OpenBankingApiClient 객체 자동 주입
	
	@Autowired
	private OpenBankingApiClient openBankingApiClient;

	public ResponseTokenVO requestToken(RequestTokenVO requestToken) {
		return openBankingApiClient.requestToken(requestToken);
	}

	// 사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) {
		return openBankingApiClient.findUser(userInfoRequestVO);
	}

	public AccountSearchResponseVO findAccount(AccountSearchRequestVO accountSearchRequestVO) {
		return openBankingApiClient.findAccount(accountSearchRequestVO);
	}
}











