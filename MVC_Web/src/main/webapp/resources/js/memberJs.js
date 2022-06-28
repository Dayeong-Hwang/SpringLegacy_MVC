  
   //가입을 위한 조건확인
   var subCheckPassRe = false, subCheckPass = false, subCheckBrith= false; subCheckEmail = false, subCheckName = false, subCheckId = false;
   
	function checkId() { //아이디 중복체크 하기
	 	 let regex = /^(?=.*[a-z])(?=.*\d)[a-z\d]{3,20}$/;
	 	  if(!$('#member_id').val().match(regex)){
	 		  $('.idRex').css("display","inline-block");
              $('#member_id').val('');
              $('#member_id').focus();
	  	 } else if($('#member_id').val().match(regex)) {
	  		 $('.idRex').css("display","none");
	  		 $.ajax({
			  	url:"idCheck", //Controller에서 요청 받을 주소
			  	type: "post",
			  	data:{member_id:$('#member_id').val()}, 
			  	dataType:"json",
			  	success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
			  		if (cnt == 0) { //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
				  	  $('.idOk').css("display","inline-block"); 
		              $('.idAlready').css("display", "none");
		              subCheckId = true;
					} else { // cnt가 1일 경우 -> 이미 존재하는 아이디
				       $('.idAlready').css("display","inline-block");
	                   $('.idOk').css("display", "none");
	                   $('#member_id').val('');
	                   $('#member_id').focus();
	                   subCheckId =false;
					}
			  	}, error: function () {
					alert("에러입니다!!");
				}
		   });
		}
	};
	
	//비밀번호 정규식
	function checkPass(pass) {
		let lengthRegex = /^[A-Za-z0-9-!@#$%]{8,16}$/;
		let engUpperRegex = /[A-Z]/;
		let engLowerRegex = /[a-z]/;
		let numRegex = /[0-9]/;
		let specRegex = /[!@#$%]/;

		let count = 0;

		if (lengthRegex.exec(pass)) {
			if (engUpperRegex.exec(pass))
				count++;
			if (engLowerRegex.exec(pass))
				count++;
			if (numRegex.exec(pass))
				count++;
			if (specRegex.exec(pass))
				count++;

			switch (count) {
			case 4:
				$("#passRexConfirm").text("사용 가능한 패스워드(안전)");
				$("#passRexConfirm").css("color","GREEN");
				subCheckPass = true;
				break;
			case 3:
				$("#passRexConfirm").text("사용 가능한 패스워드(보통)");
				$("#passRexConfirm").css("color","BLUE");
				subCheckPass = true;
				break;
			case 2:
				$("#passRexConfirm").text("사용 가능한 패스워드(위험)");
				$("#passRexConfirm").css("color","ORANGE");
				subCheckPass = true;
				break;
			default:
				$("#passRexConfirm").text("영문자, 숫자, 특수문자 중 2가지 이상 조합 필수!");
				$("#passRexConfirm").css("color","RED");
				subCheckPass= false;
			}
		} else {
			$("#passRexConfirm").text("영문자,숫자,특수문자 조합 8~16자리 필수");
			$("#passRexConfirm").css("color","RED");
			subCheckPass= false;
		}  
		 
	}
	
	
	//비밀번호 일치여부 확인
	 function checkPassConfirm(passConfirm) {
		
		let member_passwd = $("#member_passwd").val();
		if(member_passwd == passConfirm){
			$("#PassConfirm").text("비밀번호 일치");
			$("#PassConfirm").css("color","GREEN");
			subCheckPassRe = true;
			
		} else {
			$("#PassConfirm").text("비밀번호 불일치");
			$("#PassConfirm").css("color","RED");
			subCheckPassRe =false;
		}
	}

	//생년월일 정규표현식
	function checkRexBirth(birth) {
		let regex = /^\d{6}$/;
		if(!regex.exec(birth)){
			$("#birthConfirm").text("YYMMDD로 입력해주세요!");
			$("#birthConfirm").css("color","RED");
			$("#birthConfirm").css("display","inline-block");
			subCheckBrith = false;
		}else {
		    $('#birthConfirm').css("display","none");
		    subCheckBrith = true;
		} 
	}
	
	
	//이메일 정규표현식
	function checkRexEmail(email) {
		let regex =/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		if(!regex.exec(email)){
			$("#emailConfirm").text("이메일 양식을 확인해주세요!");
			$("#emailConfirm").css("color","RED");
			$("#emailConfirm").css("display","inline-block");
			subCheckEmail =false;
		} else {
		    $('#emailConfirm').css("display","none");
		    subCheckEmail =true;
		}
	}
	
	//이름 정규표현식
	function checkRexName(name) {
		let regex = /^[가-힣]{2,4}$/;
		if(!regex.exec(name)){
			$("#nameConfirm").text("이름을 확인해주세요");
			$("#nameConfirm").css("color","RED");
			$("#nameConfirm").css("display","inline-block");
			subCheckName =false;
		} else {
		    $('#nameConfirm').css("display","none");
		    subCheckName =true;
		}
	}
	
	
	//마지막 조건 확인하기
	function submitCheck(){
		if(!subCheckName){ 
			alert("이름 확인 필수!");
			$("#member_name").focus();
			return false;
		} 
		if(!subCheckId){ 
			alert("아이디 확인 필수!");
			$("#member_id").focus();
			return false;
		}
		if(!subCheckPass){ 
			alert("패스워드 조건 확인 필수!");
			$("#member_passwd").focus();
			return false;
		}
		if(!subCheckPassRe){ 
			alert("패스워드 확인 필수!");
			$("#passwd_re").focus();
			return false;
		}
		if (!subCheckEmail){ 
			alert("이메일 확인 필수!");
			$("#member_email").focus();
			return false;
		}
		if(!$('#ckBox').is(':checked')){
			alert("약관 동의 필수!");
			return false;
		}
	}	
	
