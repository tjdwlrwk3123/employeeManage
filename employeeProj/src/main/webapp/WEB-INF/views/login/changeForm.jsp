<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/empl/resources/jquery-3.5.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<body>
<h1>비밀번호 변경</h1>

<form action="${cp }/login/changePassword" onsubmit="javascript:confirmP();">
<div>
	<input type="password" placeholder="현재 비밀번호 입력" name="oldP">
</div>
<div>
	<input type="password" placeholder="변경할 비밀번호 입력" id="newP" name="newP">
</div>
<div>
	<input type="password" placeholder="한번 더 변경할 비밀번호 입력" id="confirmP">
</div>
<button class="">변경</button>
</form>
</body>
<script type="text/javascript">
$(document).ready(function(){
	function confirmP(){
		if($('#newP').val()!=$('#confirmP').val()){
			alert('비밀번호 확인이 일치하지 않습니다');
			return false;
		}
	}
});
</script>
</html>