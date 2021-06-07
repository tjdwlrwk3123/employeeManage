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
		<li><button class="btn btn-info btn-block" onclick="location.href='region'">지역관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='position'">직위관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='department'">부서관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='basepay'">기본급관리</button></li>
		<li><button class="btn btn-danger btn-block">로그아웃</button></li>
	</ul>
</div>
<br>
<br>
<input type="hidden" id="result" value="${result }">
<div id="regionInsert">
<div id="insertTitle">지역 입력</div>
<form action="insertRegion" id="regionSubmit">
<input type="text" id="region" name="reginame" placeholder="지역명"><br>
<button class="btn btn-default">추가</button>
</form>
</div>
<br>
<div id="regionList">
	<div id="listTitle">지역 목록</div>
	<table id="regionTable" class="table">
		<tr>
			<th>번호</th>
			<th>지역명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="reg" items="${regionList }">
		<tr>
			<td>${reg.regionNum }</td>
			<td>${reg.regionName }</td>
			<td><a href="">수정</a></td>
			<td>
				<a href="${cp }/regionDelete?regionNum=${reg.regionNum}">삭제</a>
				<input type="hidden" id="delete" value=${delete }>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>

</body>
<script type="text/javascript">
$(document).ready(function(){
	if($('#result').val()=='failed'){
		alert("지역 추가에 실패했습니다. 중복을 확인해주세요.");
	}
	
	if($('#delete').val()=='failed'){
		alert("지역 삭제 실패했습니다. 해당 지역에 사는 직원의 명단이 존재합니다.");
	}
	
	$('#regionSubmit').submit(function(){
		if($('#region').val()==''){
			alert("지역명을 입력해주세요");
			return false;
		}
	});
	
	
});
</script>
</html>