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
		<li><button class="btn btn-info btn-block" onclick="location.href='position'">직위관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='department'">부서관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='basepay'">기본급관리</button></li>
		<li><button class="btn btn-danger btn-block">로그아웃</button></li>
	</ul>
</div>
<br>
<br>
<input type="hidden" id="result" value="${result }">
<div id="ppInsert">
<div id="insertTitle">직위 입력</div>
<form action="ppInsert" id="ppSubmit">
<input type="text" id="position" name="ppname" placeholder="직위명"><br>
<button class="btn btn-default">추가</button>
</form>
</div>
<br>
<div id="ppList">
	<div id="listTitle">직위 목록</div>
	<table id="ppTable" class="table">
		<tr>
			<th>번호</th>
			<th>직위명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="pp" items="${ppList }">
		<tr>
			<td>${pp.ppNum }</td>
			<td>${pp.ppName }</td>
			<td>
				<span class="updateButton">수정</span>
				<input type="text" class="newPositionName" style="display: none;">
				<button class="updatePosition" style="display: none;">확인</button>
				<input type="hidden" id="update" value="${update }">
			</td>
			<td>
				<a href="${cp }/ppDelete?ppNum=${pp.ppNum}">삭제</a>
				<input type="hidden" id="delete" value="${delete }">
			</td>
		</tr>
		</c:forEach>
	</table>
</div>

</body>
<script type="text/javascript">
$(document).ready(function(){
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
	};
	
	if($('#result').val()=='failed'){
		alert("직위 추가에 실패했습니다. 중복을 확인해주세요.");
	}
	if($('#update').val()=='failed'){
		alert("직위 수정에 실패했습니다. 중복을 확인해주세요.");
	}
	
	if($('#delete').val()=='failed'){
		alert("직위 삭제에 실패했습니다. 해당 직위를 가진 직원 명단이 존재합니다.");
	}
	
	$('#ppSubmit').submit(function(){
		if($('#position').val()==''){
			alert("직위명을 입력해주세요");
			return false;
		}
	});
	
	$('.updateButton').hover(function(){
		$(this).css('color','blue');
	},function(){
		$(this).css('color','black');
	});
	
	$('.updateButton').click(function(){
		$(this).next().toggle();
		$(this).next().next().toggle();
	});
	
	$('.updatePosition').click(function(){
		console.log($(this).parent().prev().prev().text());
		var ppNum=$(this).parent().prev().prev().text();
		var newName=$(this).prev().val();
		
		location.href=getContextPath()+"/updatePosition?ppNum="+ppNum+"&ppName="+newName;
	});
	
	
});
</script>
</html>