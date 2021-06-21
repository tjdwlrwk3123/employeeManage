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
		<li><button class="btn btn-info btn-block" onclick="location.href='list'">직원관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='region'">지역관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='position'">직위관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='department'">부서관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='basepay'">기본급관리</button></li>
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
<form action="empInsert" method="post" id="empInsert">
	<div id="form">
		<div>이름:</div>
		<input type="text" name="name" id="name" placeholder="이름(30자 이내)">
		<div>생년월일:</div>
		<input type="text" name="birth" id="dp" readonly="readonly" placeholder="생년월일(YYYY-MM-DD)">
		<div>양/음력:</div>
		<input type="radio" name="sollun" value="1">양력
		<input type="radio" name="sollun" value="2">음력
		<label>(체크하지 않을 시 양력으로 처리합니다.)</label>
		<div>연락처:</div>
		<input type="text" name="phone" id="phone" placeholder="전화번호(-는 생략)">
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
		<input type="text" id="basepay" name="basepay" placeholder="기본급">
		<div>수당:</div>
		<input type="text" name="bonus" id="bonus" placeholder="수당">
	</div>
	<div id="submit">
		<button class="btn btn-default">추가</button>
	</div>
</form>
<input type="hidden" id="result" value="${failed }">
</body>
<script type="text/javascript">
$(document).ready(function() {
	
	if($("#result").val()=='failed'){
		alert('직원 생성에 실패했습니다.');
	}
	
	$('#dept').on('change',function(){
		$.getJSON('${pageContext.request.contextPath}/getBasepay?dept='+$("#dept").val()+"&posi="+$("#posi").val(),function(data){
			var basepay=data.basepay;
			
			$("#basepay").val(basepay);
		});
	});
	
	$('#posi').on('change',function(){
		$.getJSON('${pageContext.request.contextPath}/getBasepay?dept='+$("#dept").val()+"&posi="+$("#posi").val(),function(data){
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
		yearRange : 'c-100:c+100',
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
		yearRange : 'c-100:c+100',
		showMonthAfterYear:true,
		showAnim : 'toggle',
		changeMonth : 'true',
		changeYear : 'true'
	});
	
	
	var check_num = /^[0-9]*$/; // 숫자 
	var check_eng = /[a-zA-Z]/; // 문자 
	var check_spc = /[\{\}\[\]\/?.,;:|\)*~`!^\-+<>@\#$%&\\\=\(\'\"]/gi;
	var check_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글체크

	$('#name').keyup(function(){
		if(check_spc.test($('#name').val())){
			alert("특수문자는 입력할 수 없습니다.");
		}
	});
	
	$('#phone').keyup(function(){
		if(!check_num.test($('#phone').val())){
			alert("숫자만 입력해주세요");
		}
	});
	
	$('#basepay').keyup(function(){
		if(!check_num.test($('#basepay').val())){
			alert("숫자만 입력해주세요");
		}
	});
	
	$('#bonus').keyup(function(){
		if(!check_num.test($('#bonus').val())){
			alert("숫자만 입력해주세요");
		}
	});
	
	$('#empInsert').submit(function(){
		if($('#name').val()=="" || check_spc.test($('#name').val())){
			alert("올바르게 이름을 입력해주세요");
			return false;
		}else if($('#phone').val()=="" || !check_num.test($('#phone').val())){
			alert("올바르게 연락처를 입력해주세요");
			return false;
		}else if($('#dp1').val()==""){
			alert("생년월일을 입력해주세요");
			return false;
		}else if($('#dp2').val()==""){
			alert("입사일을 입력해주세요");
			return false;
		}else if($('#basepay').val()==""){
			alert("기본급을 입력해주세요");
			return false;
		}else if(!check_num.test($('#bonus').val())){
			alert("수당은 숫자만 입력해주세요");
			return false;
		}else{
			return true;
		}
	});
});
</script>
</html>