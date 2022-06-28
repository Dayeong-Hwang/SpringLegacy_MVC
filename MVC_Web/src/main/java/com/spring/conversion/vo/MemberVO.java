package com.spring.conversion.vo;

/*
 * 
member_idx INT PRIMARY KEY AUTO_INCREMENT,
member_name VARCHAR(100),
member_id VARCHAR(100),
member_passwd VARCHAR(100),
member_birth VARCHAR(6),
member_email VARCHAR(100),
member_social_type VARCHAR(100),
member_social_id VARCHAR(100),
member_social_access_token VARCHAR(400),
member_join_date VARCHAR(100),
member_modify_date VARCHAR(400),
member_auth VARCHAR(100),
member_authstatus CHAR(1)

*/

public class MemberVO {
	private int idx;
	private String member_name;
	private String member_id;
	private String member_passwd;
	private String member_birth;
	private String member_email;
	private String member_social_type;
	private String member_social_id;
	private String member_social_access_token;
	private String member_join_date;
	private String member_modify_date;
	private String member_auth;
	private String member_authstatus;
	
	public MemberVO() {
	}

	public MemberVO(int idx, String member_name, String member_id, String member_passwd, String member_birth,
			String member_email, String member_social_type, String member_social_id, String member_social_access_token,
			String member_join_date, String member_modify_date, String member_auth, String member_authstatus) {
		super();
		this.idx = idx;
		this.member_name = member_name;
		this.member_id = member_id;
		this.member_passwd = member_passwd;
		this.member_birth = member_birth;
		this.member_email = member_email;
		this.member_social_type = member_social_type;
		this.member_social_id = member_social_id;
		this.member_social_access_token = member_social_access_token;
		this.member_join_date = member_join_date;
		this.member_modify_date = member_modify_date;
		this.member_auth = member_auth;
		this.member_authstatus = member_authstatus;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_passwd() {
		return member_passwd;
	}

	public void setMember_passwd(String member_passwd) {
		this.member_passwd = member_passwd;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_social_type() {
		return member_social_type;
	}

	public void setMember_social_type(String member_social_type) {
		this.member_social_type = member_social_type;
	}

	public String getMember_social_id() {
		return member_social_id;
	}

	public void setMember_social_id(String member_social_id) {
		this.member_social_id = member_social_id;
	}

	public String getMember_social_access_token() {
		return member_social_access_token;
	}

	public void setMember_social_access_token(String member_social_access_token) {
		this.member_social_access_token = member_social_access_token;
	}

	public String getMember_join_date() {
		return member_join_date;
	}

	public void setMember_join_date(String member_join_date) {
		this.member_join_date = member_join_date;
	}

	public String getMember_modify_date() {
		return member_modify_date;
	}

	public void setMember_modify_date(String member_modify_date) {
		this.member_modify_date = member_modify_date;
	}

	public String getMember_auth() {
		return member_auth;
	}

	public void setMember_auth(String member_auth) {
		this.member_auth = member_auth;
	}

	public String getMember_authstatus() {
		return member_authstatus;
	}

	public void setMember_authstatus(String member_authstatus) {
		this.member_authstatus = member_authstatus;
	}

	
	
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", member_name=" + member_name + ", member_id=" + member_id + ", member_passwd="
				+ member_passwd + ", member_birth=" + member_birth + ", member_email=" + member_email
				+ ", member_social_type=" + member_social_type + ", member_social_id=" + member_social_id
				+ ", member_social_access_token=" + member_social_access_token + ", member_join_date="
				+ member_join_date + ", member_modify_date=" + member_modify_date + ", member_auth=" + member_auth
				+ ", member_authstatus=" + member_authstatus + "]";
	}
	
}
