<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>회원가입페이지</title>
   <link rel="stylesheet" href="resources/css/memberStyle.css">
   <script type="text/javascript" src="resources/js/jquery-3.6.0.js"></script>
   <script type="text/javascript" src="resources/js/memberJs.js"></script>
</head>
<body>
<div class="form_wrapper">
  <div class="form_container">
    <div class="title_container">
      <h2>회원가입</h2>
    </div>
    <div class="row clearfix">
      <div>
        <form action="joinPro.me" method="post" onsubmit="return submitCheck()">
          <div class="input_field"> <span><i aria-hidden="true" class="fa fa-check"></i></span>
            <input type="text" name="member_name" id="member_name" onkeyup="checkRexName(this.value)" placeholder="이름" />
          </div>
            <span id ="nameConfirm"></span>
          <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
            <input type="text" name="member_id" id="member_id" placeholder="숫자 포함 3~20자 이내로 작성해 주세요"  />
          </div>
            <input class="button" type="submit" value="아이디 중복확인" onclick="checkId()"/>
            <span class ="idRex">숫자 포함 3~20자 이내로 작성해 주세요.</span>
            <span class ="idOk">사용 가능한 아이디 입니다.</span>
            <span class ="idAlready">사용 불가능한 아이디 입니다.</span>
          	<br><br>
          <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
            <input type="password" name="member_passwd" id="member_passwd" placeholder="영문자,숫자,특수문자 조합 8~16자리 필수" onkeyup="checkPass(this.value)"/>
          </div>
            <span id="passRexConfirm"></span>
          <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
            <input type="password" name="member_passwd_re" id="passwd_re" onkeyup="checkPassConfirm(this.value)"/>
          </div>
            <span id="PassConfirm"></span>
          <div class="input_field"> <span><i aria-hidden="true" class="fa fa-calendar"></i></span>
            <input type="text" name="member_birth" id="member_birth" placeholder="생년월일(YYMMDD)" onkeyup="checkRexBirth(this.value)" />
          </div>
            <span id="birthConfirm"></span>
          <div class="input_field"> <span><i aria-hidden="true" class="fa fa-envelope"></i></span>
            <input type="text" name="member_email" id="member_email" placeholder="이메일" onkeyup="checkRexEmail(this.value)" />
          </div>
             <span id="emailConfirm"></span>
            <div class="input_field checkbox_option">
            	<input type="checkbox" id="ckBox">
    			<label for="ckBox">약관 동의</label>
            </div>
          <input class="button" type="submit" value="가입완료" />
          <input class="button" type="button" value="뒤로가기" onclick="history.back()"/>
        </form>
      </div>
    </div>
  </div>
</div>
<p class="credit">Developed by <a href="http://www.designtheway.com" target="_blank">Design the way</a></p>
<!-- partial -->
  <script src='https://use.fontawesome.com/4ecc3dbb0b.js'></script>
</body>
</html>