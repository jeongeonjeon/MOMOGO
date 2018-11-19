<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/MOMOGO/css/common.css">
<link rel="stylesheet" href="/MOMOGO/css/signup.css">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	//daum주소 API사용
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('address2').focus();
            }
        }).open();
    }
</script>
</head>
<body>
	<form name="signUp" action="#" >
		<div id="signupForm">
			<h3 class="signupGuide">사업자 정보를 입력해주세요</h3>
			<div class="formRow">
				<p class="formName">아이디</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="id" placeholder="공백없이 4-20자">
				</div>
			</div>
			<div class="formRow">
				<p class="formName">비밀번호</p>
				<div class ="inputArea">
					<input class="inputValue" type="password" name="pw" placeholder="영문+숫자 포함,8-20자">

				</div>
			</div>
			<div class="formRow">
				<p class="formName">비밀번호 재확인</p>
				<div class ="inputArea">
					<input class="inputValue" type="password" name="pwCheck">
				</div>
			</div>
			<div class="formRow">
				<p class="formName">이메일</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="email" size="35">
				</div>
			</div>
			<div class="formRow">
				<p class="formName">이름</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="name">
				</div>
			</div>
			<div class="formRow">
				<p class="formName">휴대폰번호</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="phoneNum">
				</div>
			</div>
			<h3 class="signupGuide">음식점 정보를 입력해주세요</h3>
			<div class="formRow">
				<p class="formName">음식점 이름</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="restaurName">
				</div>
			</div>
			<div class="formRow">
				<p class="formName">사업자 등록번호</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="biZName">
				</div>
			</div>
			<div class="formRow">
				<p class="formName">음식점 전화번호</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="restaurNum">
				</div>
			</div>
			<div class="formRow">
				<p class="formName">음식점 주소</p>
				<div class ="inputArea">
					<input class="inputAddr" type="text" name="address" id="address" placeholder="주소" readonly="readonly" size="35">
					<input type="button" onclick="execDaumPostcode()" value="주소검색"><br>
					<input class="inputAddr" type="text" name="address2" id="address2" placeholder="상세주소" size="35">
				</div>
			</div>
			<div class="formRow">
				<p  class="formName">업종 카테고리</p>
				<div class ="inputArea">
					<select  class="inputValue" name="category">
						<option value="1">치킨</option>
						<option value="2">중국집</option>
						<option value="3">피자</option>
						<option value="4">족발/보쌈</option>
						<option value="5">야식</option>
						<option value="6">찜/탕</option>
						<option value="7">한식/분식/죽</option>
						<option value="8">돈까스/회/일식</option>
						<option value="9">도시락/패스트푸드</option>
					</select>
				</div>
			</div>
			<div class="formRow">
				<p class="formName">배달가능지역</p>
				<div class ="inputArea">
					<input class="inputValue" type="text" name="restaurAddr">
					<button class="areaBtn">검색</button>
				</div>
			</div>
		</div>
		<div class="joinBtn">
			<input type="submit" value="가입 신청">
			
		</div>
	</form>

</body>
</html>







