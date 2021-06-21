<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h1 a{
	text-decoration: none;
	color: black;
}
</style>
<script type="text/javascript" src="/empl/resources/jquery-3.5.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<body>
<h1><a href="${pageContext.request.contextPath}/">직원관리 v1.0</a></h1>
<h2>로그인</h2>
<form action="${pageContext.request.contextPath }/login/loginSubmit" method="post">
	<input type="text" id="id" name="id"><br>
	<input type="password" id="password" name="password"><br>
	<input type="submit" value="로그인">
</form>
<input type="hidden" value="${result }" id="result">
</body>
<script type="text/javascript">
$(document).ready(function(){
	if($('#result').val()=='noId'){
		alert('아이디 또는 비밀번호가 맞지 않습니다');
	}else if($('#result').val()=='notEqual'){
		alert('아이디 또는 비밀번호가 맞지 않습니다');
	}else if($('#result').val()=='bycrypt'){
		alert('비밀번호 암호화');
	}
});
</script>
</html>