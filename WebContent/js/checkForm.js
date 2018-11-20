/**
 * 게시판, 회원가입, 로그인에서 입력과 관련된 함수 라이브러리
 */

function isNull(obj, msg) {
	if(obj.value == "") {
		alert(msg);
		obj.focus();
		return true;
	}
	return false;
}

// 확장자 체크
function checkExt(obj) {
	var forbidName = ['exe', 'java', 'jsp', 'js', 'class'];
	
	var fileName = obj.value;	/*attachfile => 태그를 말한다. 사용자가 첨부한 파일명이 들어가있는 태그이기 때문에 첨부파일명을 뽑아내기 위해 value값을 써준다.*/
	var ext = fileName.substring(fileName.lastIndexOf('.') + 1);	
	/*첨부파일명에서 확장자명만 빼내게하는 코드 => 맨 마지막 문자부터 시작해서 .이 나오는 시점을 기준으로 +1을하여 결국에는 . 뒤로 확장명만 받겠금 설정한다.*/
	
	for(var i = 0; i < forbidName.length; i++) {
		if(forbidName[i] == ext) {
			alert(ext + '확장자는 파일업로드 정책에 위배됩니다');
			return true;	
		}
	}
	
	return false;
}

















