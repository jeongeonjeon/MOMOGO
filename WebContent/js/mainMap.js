function daumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

        		
				// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					fullAddr = data.sido +" "+ data.sigungu + " " + data.bname1 + " " + data.bname2;
					
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					fullAddr = data.sido +" " + data.sigungu + " " + data.bname1 + " " + data.bname2;
				}

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById('address').value = fullAddr;

            }
        }).open();
    }

function moreBtn(category){
	
	if($('#address').val() == ""){
		alert("주소를 입력해주세요");
	}else{
		var address = $('#address').val();
		location.href = "/MOMOGO/store/storeList.do?category=" + category + "&address=" + address;
	}
}