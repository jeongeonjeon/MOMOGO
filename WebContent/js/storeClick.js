
function moreBtn(category){
	
	if($('#address').val() == ""){
		alert("주소를 입력해주세요");
	}else{
		var address = $('#address').val();
		var length = address.indexOf('동 ');
		if(length != -1)
			address = address.substring(0, length+1);
		
		if(address){
			location.href = "/MOMOGO/store/storeList.do?category=" + category + "&address=" + address;
		}else{
			alert('에러');
		}
	}
}
function detailStoreBtn(storeNo){
	location.href = "/MOMOGO/store/detailStore.do?storeNo=" + storeNo ;
}