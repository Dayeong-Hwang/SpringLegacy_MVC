package com.spring.conversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.conversion.mapper.MemberMapper;
import com.spring.conversion.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;

	public int joinMember(MemberVO member) {
		return mapper.insertJoinMember(member);
	}

	public int idCheck(String member_id) {
		int cnt = mapper.selectCheckId(member_id);
		return cnt;
	}

}
