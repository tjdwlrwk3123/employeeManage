<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

#employManage {width:1500px; height: 600px;}
#employManage table{width:1500px; text-align: center;}

</style>
<body>
<h1>직원관리 v1.0</h1>
<br>
<div id="manageList">
	<ul>
		<li><button class="btn btn-info btn-block" onclick="location.href='list'">직원관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='region'">지역관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='position'">직위관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='department'">부서관리</button></li>
		<li><button class="btn btn-default btn-block" onclick="location.href='basepay'">기본급관리</button></li>
		<li><button class="btn btn-danger btn-block">로그아웃</button></li>
	</ul>
</div>
<br>
<br>
<div id="employManage">
	<table class="table">
		<tr>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}" style="color:blue; text-decoration: none;">번호</a></th>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=userid" style="color:blue; text-decoration: none;">아이디</a></th>
			<th>이름</th>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=empbirth" style="color:blue; text-decoration: none;">생년월일</a></th>
			<th>양/음력</th>
			<th>전화번호</th>
			<th>지역명</th>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=deptnum" style="color:blue; text-decoration: none;">부서명</a></th>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=ppnum" style="color:blue; text-decoration: none;">직위명</a></th>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=joindate" style="color:blue; text-decoration: none;">입사일</a></th>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=basepay" style="color:blue; text-decoration: none;">기본급</a></th>
			<th>수당</th>
			<th><a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=totalpay" style="color:blue; text-decoration: none;">급여</a></th>
			<th>사진등록</th>
			<th class="warning">수정</th>
			<th class="danger">삭제</th>
		</tr>
		<c:forEach var="emp" items="${emplist }" varStatus="status">
		<tr>
			<td>${emp.empNum }</td>
			<td>${emp.userId }</td>
			<td>${emp.empName }<button>사진</button></td>
			<td>${emp.empBirth }</td>
			<td>
				<c:choose>
					<c:when test="${emp.solarlunar == 1 }">양력</c:when>
					<c:otherwise>음력</c:otherwise>
				</c:choose>
			</td>
			<td>${emp.contactAdress }</td>
			<td>${regiName[status.index] }</td>
			<td>${deptName[status.index] }</td>
			<td>${ppName[status.index] }</td>
			<td>${emp.joinday }</td>
			<td><fmt:formatNumber value="${emp.basepay }" pattern="#,###"/></td>
			<td><fmt:formatNumber value="${emp.bonus }" pattern="#,###"/></td>
			<td><fmt:formatNumber value="${emp.basepay + emp.bonus }" pattern="#,###"/></td>
			<td>
			<button>등록</button>
			</td>
			<td><a href="">수정</a></td>
			<td><a href="">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
<div id="paging">
	<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }" >
		<c:choose>
			<c:when test="${pu.pageNum==i }">
				<a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}"><span style="color: blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/list?keyword=${keyword}&search=${search}&pageNum=${i}"><span style="color: gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
<div id="searchDiv">
	<form action="list" method="post">
		<select id="search" name="search">
			<option value="userid">아이디</option>
			<option value="empname">이름</option>
			<option value="contactadress">전화번호</option>
			<option value="regionnum">지역명</option>
			<option value="deptnum">부서명</option>
			<option value="ppnum">직위명</option>
		</select>
		<input type="text" name="keyword" id="selectKeyword">
		<select id="selectBox" name="keyword" style="display:none" disabled="disabled">
		</select>
		<button class="btn btn-default">검색</button>
	</form>
</div>
<div id="addfunc">
	<a href="insertForm" class="btn btn-primary">직원추가</a>
	<a href="#" class="btn btn-primary">직원출력</a>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$('#search').on('change',function(){
		console.log($(this).val());
		var content='';
		$('#selectBox').empty();
		if($(this).val()=='regionnum'){
			$.getJSON('${cp}/getSelectRegion?keyword='+$(this).val(),function(data){
				if(data!=null){
					for(let i=0;i<data.length;i++){
						content+='<option value="'+data[i].regionNum+'">'+data[i].regionName+'</option>';
					}
					$('#selectBox').append(content);
				}
			});
			$('#selectKeyword').css('display','none');
			$('#selectKeyword').attr('disabled',true);
			$('#selectBox').css('display','');
			$('#selectBox').attr('disabled',false);
		}else if($(this).val()=='deptnum'){
			$.getJSON('${cp}/getSelectDept?keyword='+$(this).val(),function(data){
				if(data!=null){
					for(let i=0;i<data.length;i++){
						content+='<option value="'+data[i].deptNum+'">'+data[i].deptName+'</option>';
					}
					$('#selectBox').append(content);
				}
			});
			$('#selectKeyword').css('display','none');
			$('#selectKeyword').attr('disabled',true);
			$('#selectBox').css('display','');
			$('#selectBox').attr('disabled',false);
		}else if($(this).val()=='ppnum'){
			$.getJSON('${cp}/getSelectPosi?keyword='+$(this).val(),function(data){
				if(data!=null){
					for(let i=0;i<data.length;i++){
						content+='<option value="'+data[i].ppNum+'">'+data[i].ppName+'</option>';
					}
					$('#selectBox').append(content);
				}
			});
			$('#selectKeyword').css('display','none');
			$('#selectKeyword').attr('disabled',true);
			$('#selectBox').css('display','');
			$('#selectBox').attr('disabled',false);
		}else{
			$('#selectKeyword').css('display','');
			$('#selectKeyword').attr('disabled',false);
			$('#selectBox').attr('disabled',true);
			$('#selectBox').disabled;
		}
	});
});
</script>
</html>