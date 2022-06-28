<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fintech - 금융결제원 오픈API</title> <!-- https://developers.kftc.or.kr/dev -->
</head>
<body>
	<c:if test="${accessToken eq null}"> <!-- 토큰이 없을 경우  -->
		<h3>토큰 미발급 상태이므로 토큰 발급 필수입니다.</h3>
		<form action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" method="get"><!--  사용자 인증  -->
			<input type="hidden" name="response_type" value="code">
			<input type="hidden" name="client_id" value="<spring:eval expression="@properties['api.clientId']"/>">
			<input type="hidden" name="redirect_uri" value="http://localhost:8080/conversion/callback">
			<input type="hidden" name="scope" value="login inquiry transfer">
			<input type="hidden" name="state" value="12345678123456781234567812345678">
			<input type="hidden" name="auth_type" value="0">
			<input type="submit" value="토큰발급">
		</form>
	</c:if>
	
	<c:if test="${accessToken ne null}"><!-- 토큰이있을 경우  -->
		<h3 align="center">토큰 발급 상태이므로 계좌 접근 가능!</h3>
		<form action="">
			<input type="submit" value="계좌조회" >
		</form>
	</c:if>
	
</body>
</html>