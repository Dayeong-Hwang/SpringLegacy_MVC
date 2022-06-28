package com.spring.conversion.mapper;

import com.spring.conversion.vo.MemberVO;

public interface MemberMapper {

	public int insertJoinMember(MemberVO member);

	public int selectCheckId(String member_id);

}
