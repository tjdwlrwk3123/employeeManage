<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

#employManage {width:1500px; height: 800px;}
#employManage table{width:1500px; text-align: center;}

</style>
<body>
<h1>직원관리 v1.0</h1>
<br>
<div id="manageList">
	<ul>
		<li><button class="btn btn-info btn-block">직원관리</button></li>
		<li><button class="btn btn-default btn-block">지역관리</button></li>
		<li><button class="btn btn-default btn-block">직위관리</button></li>
		<li><button class="btn btn-default btn-block">부서관리</button></li>
		<li><button class="btn btn-danger btn-block">로그아웃</button></li>
	</ul>
</div>
<br>
<br>
<div id="employManage">
	<table class="table">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>양/음력</th>
			<th>전화번호</th>
			<th>지역명</th>
			<th>직위명</th>
			<th>부서명</th>
			<th>기본급</th>
			<th>수당</th>
			<th>급여</th>
			<th>사진등록</th>
			<th class="warning">수정</th>
			<th class="danger">삭제</th>
		</tr>
		<c:forEach items="">
		<tr>
			<td></td>
		</tr>
		</c:forEach>
	</table>
</div>
<div id="addfunc">
	<a href="insertForm" class="btn btn-primary">직원추가</a>
	<a href="#" class="btn btn-primary">직원출력</a>
</div>
</body>
</html>