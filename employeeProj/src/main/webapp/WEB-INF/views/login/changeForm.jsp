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
<h2>비밀번호 변경</h2>

<form action="${pageContext.request.contextPath}/login/changePassword" id="confirm" method="post">
<div>
	<input type="password" placeholder="현재 비밀번호 입력" name="oldP">
</div>
<div>
	<input type="password" placeholder="변경할 비밀번호 입력" id="newP" name="newP">
</div>
<div>
	<input type="password" placeholder="변경할 비밀번호 확인" id="confirmP">
</div>
<button class="">변경</button>
</form>
<input type="hidden" value="${result }" id="result">
</body>
<script type="text/javascript">
$(document).ready(function(){
	$('#confirm').submit(function(){
		if($('#newP').val()!=$('#confirmP').val()){
			alert('비밀번호 확인이 일치하지 않습니다');
			return false;
		}
	});
	if($('#result').val()=='notEqual'){
		alert('기존 비밀번호가 일치하지 않습니다');
	}
});
</script>
</html>