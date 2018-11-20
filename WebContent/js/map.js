$(document).ready(function() {
	$('.current_btn').click(function() {

		if (!navigator.geolocation) {
			alert("<p>사용자의 브라우저는 지오로케이션을 지원하지 않습니다.</p>");
			return;
		}

		function success(position) {
			var latitude = position.coords.latitude;
			var longitude = position.coords.longitude;

			var geocoder = new daum.maps.services.Geocoder();

			var callback = function(result, status) {
				if (status === daum.maps.services.Status.OK) {

					console.log('지역 명칭 : ' + result[0].address_name);
					console.log('행정구역 코드 : ' + result[0].code);

					$('.search_addr').val(result[0].address_name);
				}
			};

			geocoder.coord2RegionCode(25.506566, 75.1109853, callback);

		}
		;

		function error() {
			output.innerHTML = "사용자의 위치를 찾을 수 없습니다.";
		}
		;
		navigator.geolocation.getCurrentPosition(success, error);

	});
});
