<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty vo}">
			<h1>로그인 정보</h1>
			<ul>
				<li>아이디 : ${vo.id}</li>
				<li>이름 : ${vo.name}</li>
				<li>주소 : ${vo.addr}</li>
			</ul>
			<a href="/index.jsp">첫 페이지로 이동</a>
		</c:when>
		<c:otherwise>
			<h2>로그인 실패!!</h2>
			<a href="/index.jsp">첫 페이지로 이동</a>
		</c:otherwise>
	</c:choose>
</body>
</html>