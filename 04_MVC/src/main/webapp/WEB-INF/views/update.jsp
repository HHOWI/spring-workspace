<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="updateMember" method="post">
		아이디 : <input type="text" name="id" value="${vo.id}" readonly><br>
		아이디 : <input type="password" name="pwd" value="${vo.pwd}" ><br>
		이름 : <input type="text" name="name" value="${vo.name}"><br>
		주소 : <input type="text" name="addr" value="${vo.addr}"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>