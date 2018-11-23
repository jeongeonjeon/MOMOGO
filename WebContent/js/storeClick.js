
function moreBtn(category){
	
	if($('#address').val() == ""){
		alert("주소를 입력해주세요");
	}else{
		var address = $('#address').val();
		location.href = "/MOMOGO/store/storeList.do?category=" + category + "&address=" + address;
	}
}
function detailStoreBtn(storeNo){
	location.href = "/MOMOGO/store/detailStore.do?storeNo=" + storeNo ;
}