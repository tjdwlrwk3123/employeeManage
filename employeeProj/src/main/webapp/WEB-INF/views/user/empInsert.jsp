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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
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
		<li><button class="btn btn-info btn-block">직원관리</button></li>
		<li><button class="btn btn-default btn-block">지역관리</button></li>
		<li><button class="btn btn-default btn-block">직위관리</button></li>
		<li><button class="btn btn-default btn-block">부서관리</button></li>
		<li><button class="btn btn-danger btn-block">로그아웃</button></li>
	</ul>
</div>
<br>
<br>
<form action="empInsert">
	<div id="form">
		<div>이름:</div>
		<input type="text" name="name" placeholder="이름(30자 이내)">
		<div>생년월일:</div>
		<input type="text" name="birth" id="dp" readonly="readonly" placeholder="생년월일(YYYY-MM-DD)">
		<div>양/음력:</div>
		<input type="radio" name="sollun" value="solar">양력
		<input type="radio" name="sollun" value="lunar">음력
		<div>전화번호:</div>
		<input type="text" name="phone" placeholder="전화번호(-는 생략)">
		<div>지역:</div>
		<select name="region" class="form-control">
			<c:forEach var="reg" items="${regList }">
				<option value="${reg.regionNum }">${reg.regionName }</option>
			</c:forEach>
		</select>
		<div>입사일:</div>
		<input type="text" id="dp2" name="joining" readonly="readonly">
		<div>부서:</div>
		<select id="dept" name="department" class="form-control">
			<c:forEach var="dept" items="${deptList }"> 
				<option value="${dept.deptNum }">${dept.deptName }</option>
			</c:forEach>
		</select>
		<div>직위:</div>
		<select id="posi" name="position" class="form-control">
			<c:forEach var="posi" items="${posiList }">
				<option value="${posi.ppNum }">${posi.ppName }</option>
			</c:forEach>
		</select>
		<div>기본급:</div>
		<input type="text" id="basepay" name="basepay" value="2000000">
		<div>수당:</div>
		<input type="text" name="bonus" placeholder="수당">
	</div>
	<div id="submit">
		<button class="btn btn-default">추가</button>
	</div>
</form>
</body>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#dept').on('change',function(){
		$.getJSON('${cp}/getBasepay?dept='+$("#dept").val()+"&posi="+$("#posi").val(),function(data){
			var basepay=data.basepay;
			
			$("#basepay").val(basepay);
		});
	});
	
	$('#posi').on('change',function(){
		$.getJSON('${cp}/getBasepay?dept='+$("#dept").val()+"&posi="+$("#posi").val(),function(data){
			var basepay=data.basepay;
			
			$("#basepay").val(basepay);
		});
	});
	
	$('#dp').datepicker({
		dateFormat : 'yy-mm-dd',
		dayNamesMin:['일','월','화','수','목','금','토'],
		monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		yearSuffix:"년",
		minDate : '-100y',
		yearRange : 'c-100:c+10',
		showMonthAfterYear:true,
		showAnim : 'toggle',
		changeMonth : 'true',
		changeYear : 'true'
	});
	
	$('#dp2').datepicker({
		dateFormat : 'yy-mm-dd',
		dayNamesMin:['일','월','화','수','목','금','토'],
		monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		yearSuffix:"년",
		minDate : '-100y',
		yearRange : 'c-100:c+3',
		showMonthAfterYear:true,
		showAnim : 'toggle',
		changeMonth : 'true',
		changeYear : 'true'
	});
});
</script>
</html>