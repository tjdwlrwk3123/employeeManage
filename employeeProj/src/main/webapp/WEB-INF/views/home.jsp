<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h1 {text-align: center;}
#joindiv {text-align: center;}
</style>
<body>
<h1>사원관리 페이지</h1>
<div id="joindiv">
<a href="${pageContext.request.contextPath}/list"><img id="joinEmp" src="${pageContext.request.contextPath}/resources/imgFolder/join.png"></a>
</div>
<div id="loginDiv" style="text-align: center;">
<c:choose>
	<c:when test="${sessionScope.userid!=null }">
		<a href="${pageContext.request.contextPath}/login/changeForm">비밀번호 변경</a>
		<a href="${pageContext.request.contextPath}/login/logout">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/login/loginForm">로그인</a>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>