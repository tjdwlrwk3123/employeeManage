<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/empl/resources/jquery-3.5.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<style>
h1 a{
	text-decoration: none;
	color: black;
}
#manageList ul{list-style: none;}
#manageList ul li{float: left; width: 300px;}

</style>
<body>
<h1><a href="${pageContext.request.contextPath}/">직원관리 v1.0</a></h1>
<br>
<div id="manageList">
	<ul>
		<li><button class="btn btn-default btn-block" onclick="location.href='list'">직원관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='region'">지역관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='position'">직위관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='department'">부서관리</button></li>
		<li><button class="btn btn-info btn-block" onclick="location.href='basepay'">기본급관리</button></li>
		<c:choose>
			<c:when test="${sessionScope.userid !=null }">
				<li><button class="btn btn-danger btn-block" onclick="location.href='login/logout'">로그아웃</button></li>
			</c:when>
			<c:otherwise>
				<li><button class="btn btn-info btn-block" onclick="location.href='login/loginForm'">로그인</button></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<br>
<br>
<input type="hidden" id="result" value="${result }">
<div id="basepayInsert">
<div id="insertTitle">기본급 입력</div>
<form action="mergeBasepay" id="basepaySubmit">
<div>부서:</div>
<select id="dept" name="deptNum" class="form-control">
	<c:forEach var="dept" items="${dList }"> 
		<option value="${dept.deptNum }">${dept.deptName }</option>
	</c:forEach>
</select>
<div>직위:</div>
<select id="posi" name="ppNum" class="form-control">
	<c:forEach var="posi" items="${pList }">
		<option value="${posi.ppNum }">${posi.ppName }</option>
	</c:forEach>
</select>
<input type="text" id="basepay" name="basepay" placeholder="기본급"><br>
<button class="btn btn-default">추가/변경</button>
</form>
</div>
<br>
<div id="basepayList">
	<div id="listTitle">기본급 목록</div>
	<table id="basepayTable" class="table">
		<tr>
			<th>번호</th>
			<th>부서</th>
			<th>직위</th>
			<th>기본급</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="bp" items="${bList }">
		<tr>
			<td>${bp.payNum }</td>
			<td>${bp.deptName }</td>
			<td>${bp.ppName }</td>
			<td><fmt:formatNumber value="${bp.basepay }" pattern="#,###"/></td>
			<td><a href="">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>

</body>
<script type="text/javascript">
$(document).ready(function(){
	if($('#result').val()=='failed'){
		alert("기본급 추가/변경에 실패했습니다.");
	}
	
	$('#dept').on('change',function(){
		$.getJSON('${pageContext.request.contextPath}/getBasepay?dept='+$("#dept").val()+"&posi="+$("#posi").val(),function(data){
			var basepay=data.basepay;
			
			$("#basepay").val(basepay);
		}).fail(function(){
			$("#basepay").val("");
		});
	});
	
	$('#posi').on('change',function(){
		$.getJSON('${pageContext.request.contextPath}/getBasepay?dept='+$("#dept").val()+"&posi="+$("#posi").val(),function(data){
			var basepay=data.basepay;
			
			$("#basepay").val(basepay);
		}).fail(function(){
			$("#basepay").val("");
		});
		
	});
});
</script>
</html>