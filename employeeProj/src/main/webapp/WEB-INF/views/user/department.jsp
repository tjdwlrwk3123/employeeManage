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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
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
			<td>
				<span class="updateButton">수정</span>
				<input type="text" class="newDeptName" style="display: none;">
				<button class="updateDept" style="display: none;">확인</button>
				<input type="hidden" id="update" value="${update }">
			</td>
			<td>
				<a href="${cp }/deptDelete?deptNum=${dept.deptNum}">삭제</a>
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
		alert("부서 추가에 실패했습니다. 중복을 확인해주세요.");
	}
	if($('#update').val()=='failed'){
		alert("부서 수정에 실패했습니다. 중복을 확인해주세요.");
	}
	if($('#delete').val()=='failed'){
		alert("부서 삭제에 실패했습니다. 해당 부서에 소속된 직원명단이 존재합니다.");
	}
	if($('#delete').val()=='idk'){
		alert("삭제 도중 오류가 발생했습니다. 관리자에게 문의해주세요.");
	}
	
	$('#deptSubmit').submit(function(){
		if($('#dept').val()==''){
			alert("부서명을 입력해주세요");
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
	
	$('.updateDept').click(function(){
		console.log($(this).parent().prev().prev().text());
		var deptNum=$(this).parent().prev().prev().text();
		var newName=$(this).prev().val();
		
		location.href=getContextPath()+"/updateDept?deptNum="+deptNum+"&deptName="+newName;
	});
});
</script>
</html>