<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h1>휴대전화 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>모델번호</th>
				<th>모델이름</th>
				<th>가격</th>
				<th>제조사명</th>
			</tr>
		</thead>
		<tbody id="list">
		</tbody>
	</table>
	<h1>휴대전화 정보</h1>
	<form id="phoneFrm">
		모델번호 : <input type="text" name="num" id="num"><br> 모델명 :
		<input type="text" name="model" id="model"><br> 가격 : <input
			type="text" name="price" id="price"><br> 제조사 : <select
			id="vcode" name="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select><br> <input type="button" value="추가하기" id="insert"> <input
			type="button" value="수정하기" id="update"> <input type="button"
			value="삭제하기" id="delete">
	</form>
	<script>
function list() {
    $.ajax({
        url : '/api/phone', // API 엔드포인트 URL을 여기에 입력
        type : 'GET',             // GET 요청을 사용하려면 'GET'을 입력
        success: function(data) {
            // 성공 시 처리
            // 휴대전화 목록을 HTML에 추가
            var listHtml = '';
            for (let phone of data) {
                listHtml += '<tr>';
                listHtml += '<td class="num">' + phone.num + '</td>';
                listHtml += '<td class="model">' + phone.model + '</td>';
                listHtml += '<td class="price">' + phone.price + '</td>';
                listHtml += '<td class="vendor">' + phone.company.vendor + '</td>';
                listHtml += '</tr>';
            }
            $('#list').html(listHtml);
        },
        error: function() {
            // 오류 시 처리
            console.error('데이터를 불러오는 중 오류가 발생했습니다.');
        }
    });
}
list();

function empty() {
	$('#num').val("");
	$('#model').val("");
	$('#price').val("");
	$('#vcode').val("10");
}
// 상세 조회
$('#list').on('click', '.num', function() {
	$.ajax({
		url: '/api/phone/' + $(this).text(),
		type: 'GET',
		success: function(data) {
			if(data) {
				$('#num').val(data.num);
				$('#model').val(data.model);
				$('#price').val(data.price);
				$('#vcode').val(data.vcode);
			} else {
                // 해당 모델번호의 정보가 없을 경우 처리
                console.error('해당 모델번호의 정보를 찾을 수 없습니다.');
            }
        },
        error: function() {
            // 오류 시 처리
            console.error('휴대전화 정보를 불러오는 중 오류가 발생했습니다.');
		}
	});
});

// 추가
$('#insert').on('click', function() {
	// JSON 방식으로 전달!
	let phone = {
			num: $('#num').val(),
			model: $('#model').val(),
			price: $('#price').val(),
			vcode: $('#vcode').val()
	};
	$.ajax({
		url: '/api/phone',
		type: 'POST',
		data:  JSON.stringify(phone),
		contentType: 'application/json',
		success: function(phone) {
			list();
		}
	});
});

// 수정
$('#update').on('click', function() {
	// JSON 방식으로 전달!
	let phone = {
			num: $('#num').val(),
			model: $('#model').val(),
			price: $('#price').val(),
			vcode: $('#vcode').val()
	};
	$.ajax({
		url: '/api/phone',
		type: 'PUT',
		data:  JSON.stringify(phone),
		contentType: 'application/json',
		success: function(phone) {
			list();
		}
	});
});

// 삭제
$('#delete').on('click', function() {
	// JSON 방식으로 전달!
	$.ajax({
		url: '/api/phone/' + $('#num').val(),
		type: 'DELETE',
		success: function(data) {
			list();
			empty();
		}
	});
});
</script>
</body>
</html>







