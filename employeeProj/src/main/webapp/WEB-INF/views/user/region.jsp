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
		<li><button class="btn btn-default btn-block" onclick="location.href='${pageContext.request.contextPath}/list'">직원관리</button></li>
		<li><button class="btn btn-info btn-block" onclick="location.href='${pageContext.request.contextPath}/region'">지역관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='${pageContext.request.contextPath}/position'">직위관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='${pageContext.request.contextPath}/department'">부서관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='${pageContext.request.contextPath}/basepay'">기본급관리</button></li>
		<c:choose>
			<c:when test="${sessionScope.userid !=null }">
				<li><button class="btn btn-danger btn-block" onclick="location.href='${pageContext.request.contextPath}/login/logout'">로그아웃</button></li>
			</c:when>
			<c:otherwise>
				<li><button class="btn btn-info btn-block" onclick="location.href='${pageContext.request.contextPath}/login/loginForm'">로그인</button></li>
			</c:otherwise>
		</c:choose>
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
			<td>
				<span class="updateButton">수정</span>
				<input type="text" class="newRegionName" style="display: none;">
				<button class="updateRegion" style="display: none;">확인</button>
				<input type="hidden" id="update" value="${update }">
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/regionDelete?regionNum=${reg.regionNum}">삭제</a>
				<input type="hidden" id="delete" value=${delete }>
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
		alert("지역 추가에 실패했습니다. 중복을 확인해주세요.");
	}
	if($('#update').val()=='failed'){
		alert("지역 수정에 실패했습니다. 중복을 확인해주세요.");
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
	
	$('.updateButton').hover(function(){
		$(this).css('color','blue');
	},function(){
		$(this).css('color','black');
	});
	
	$('.updateButton').click(function(){
		$(this).next().toggle();
		$(this).next().next().toggle();
	});
	
	$('.updateRegion').click(function(){
		console.log($(this).parent().prev().prev().text());
		var regionNum=$(this).parent().prev().prev().text();
		var newName=$(this).prev().val();
		
		location.href=getContextPath()+"/updateRegion?regionNum="+regionNum+"&regionName="+newName;
	});
	
});
</script>
</html>