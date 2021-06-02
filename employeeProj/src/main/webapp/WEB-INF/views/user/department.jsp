<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/empl/resources/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>

#manageList ul{list-style: none;}
#manageList ul li{float: left; width: 300px;}

</style>
<body>
<h1>직원관리 v1.0</h1>
<br>
<div id="manageList">
	<ul>
		<li><button class="btn btn-default btn-block" onclick="location.href='list'">직원관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='region'">지역관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='position'">직위관리</button></li>
		<li><button class="btn btn-info btn-block" onclick="location.href='department'">부서관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='basepay'">기본급관리</button></li>
		<li><button class="btn btn-danger btn-block">로그아웃</button></li>
	</ul>
</div>
<br>
<br>
<input type="hidden" id="result" value="${result }">
<div id="deptInsert">
<div id="insertTitle">부서 입력</div>
<form action="deptInsert" id="deptSubmit">
<input type="text" id="dept" name="deptname" placeholder="부서명"><br>
<button class="btn btn-default">추가</button>
</form>
</div>
<br>
<div id="deptList">
	<div id="listTitle">부서 목록</div>
	<table id="deptTable" class="table">
		<tr>
			<th>번호</th>
			<th>부서명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="dept" items="${deptList }">
		<tr>
			<td>${dept.deptNum }</td>
			<td>${dept.deptName }</td>
			<td><a href="">수정</a></td>
			<td><a href="">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>

</body>
<script type="text/javascript">
$(document).ready(function(){
	if($('#result').val()=='failed'){
		alert("부서 추가에 실패했습니다. 중복을 확인해주세요.");
	}
	
	$('#deptSubmit').submit(function(){
		if($('#dept').val()==''){
			alert("부서명을 입력해주세요");
			return false;
		}
	});
});
</script>
</html>