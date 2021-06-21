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
<script type="text/javascript" src="/empl/resources/printThis.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<style>

h1 a{
	text-decoration: none;
	color: black;
}

#manageList ul{list-style: none;}
#manageList ul li{float: left; width: 300px;}

#employManage {width:1900px; height: 800px;}
#employManage table{width:1900px; text-align: center;}

/* 팝업으로 뜨는 윈도우 css  */ 
#mask {  
    position:absolute;  
    z-index:9000;  
    background-color:#000;  
    display:none;  
    left:0;
    top:0;
}
.photoPopup{
	display: none;
	position:absolute;
	left:65%;
	top:200px;
	margin-left: -500px;
	width:400px;
	height:550px;
	background-color:#FFF;
	z-index:10000;   
}

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
<div id="mask"></div>
<div id="employManage">
	<table class="table" id="empTable">
		<tr>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}" style="color:blue; text-decoration: none;">번호</a></th>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=userid" style="color:blue; text-decoration: none;">아이디</a></th>
			<th>이름</th>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=empbirth" style="color:blue; text-decoration: none;">생년월일</a></th>
			<th>양/음력</th>
			<th>전화번호</th>
			<th>지역명</th>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=deptnum" style="color:blue; text-decoration: none;">부서명</a></th>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=ppnum" style="color:blue; text-decoration: none;">직위명</a></th>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=joindate" style="color:blue; text-decoration: none;">입사일</a></th>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=basepay" style="color:blue; text-decoration: none;">기본급</a></th>
			<th>수당</th>
			<th><a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}&sort=totalpay" style="color:blue; text-decoration: none;">급여</a></th>
			<th>사진등록</th>
			<th class="warning">수정</th>
			<th class="danger">삭제</th>
		</tr>
		<c:forEach var="emp" items="${emplist }" varStatus="status">
		<tr>
			<td>${emp.empNum }</td>
			<td>${emp.userId }</td>
			<td>
				${emp.empName }
				<button class="showPhoto">사진</button>
			</td>
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
				<form action="${pageContext.request.contextPath}/insertPhoto" enctype="multipart/form-data" method="post">
				<input type="hidden" value="${emp.empNum }" name="empNum">
				<input type="file" name="photo" accept="image/*" style="width: 160px;" required/>
				<button>등록</button>
				</form>
				<input type="hidden" value="${insertImg }" class="insertImg">
			</td>
			<td><a href="${pageContext.request.contextPath}/updateForm?empNum=${emp.empNum}">수정</a></td>
			<td>
				<a href="${pageContext.request.contextPath}/deleteEmp?userid=${emp.userId }&empNum=${emp.empNum}" onclick="return confirm('직원번호:${emp.empNum} / 이름:${emp.empName }\n삭제하시겠습니까?')">삭제</a>
				<input type="hidden" id="result" value="${result }">
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
<div class="photoPopup">
</div>
<div id="paging">
	<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }" >
		<c:choose>
			<c:when test="${pu.pageNum==i }">
				<a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}"><span style="color: blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/list?keyword=${keyword}&search=${search}&pageNum=${i}"><span style="color: gray">[${i }]</span></a>
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
	<a href="admin/insertForm" class="btn btn-primary">직원추가</a>
	<a href="javascript:printEmp()" class="btn btn-primary">직원출력</a>
</div>

<div id="printArea"></div>
</body>
<script type="text/javascript">
function wrapWindowByMask(empnum){
	 
    //화면의 높이와 너비를 구한다.
    var maskHeight = $(document).height();  
    var maskWidth = $(window).width();  

    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
    $("#mask").css({"width":maskWidth,"height":maskHeight});  

    //애니메이션 효과 - 일단 0초동안 까맣게 됐다가 60% 불투명도로 간다.

    $("#mask").fadeIn(0);      
    $("#mask").fadeTo("slow",0.6);    

    $('.photoPopup').empty();
    
    $.getJSON('${pageContext.request.contextPath}/getPhoto?empnum='+empnum,function(data){
    	if(data!=null){
    		content='<img src="${pageContext.request.contextPath}/resources/imgFolder/'+data.img+'" style="width: 400px; height: 550px;">';
    	}
    	$('.photoPopup').prepend(content);
    	
    });
    
	//모달창 띄우기
    $(".photoPopup").show();

}

function printEmp(){
	
	$('#printArea').empty();
	$('#printArea').append($('#empTable').clone()); //새로운 영역에 테이블을 옮기기(수정,삭제 등등 열 삭제 위해)
	
	$('#printArea th:last').remove(); //마지막으로부터 3개 행 삭제(사진등록,수정,삭제부분)
	$('#printArea th:last').remove();
	$('#printArea th:last').remove();
	
	$('#printArea tr td:last-child').remove(); //마지막으로부터 3개 열 삭제(사진등록,수정,삭제)
	$('#printArea tr td:last-child').remove();
	$('#printArea tr td:last-child').remove();
	
	$('#printArea td button').remove(); //사진보기 버튼 삭제
	
	
	$('#printArea').printThis({
		importCSS:true,
		afterPrint:function(){
			$('#printArea').empty();
		}			
	});
	
	
}

$(document).ready(function(){
	$('#search').on('change',function(){
		console.log($(this).val());
		var content='';
		$('#selectBox').empty();
		if($(this).val()=='regionnum'){
			$.getJSON('${pageContext.request.contextPath}/getSelectRegion?keyword='+$(this).val(),function(data){
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
			$.getJSON('${pageContext.request.contextPath}/getSelectDept?keyword='+$(this).val(),function(data){
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
			$.getJSON('${pageContext.request.contextPath}/getSelectPosi?keyword='+$(this).val(),function(data){
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
	
	if($('#result').val()=='failed'){
		alert("삭제에 실패했습니다.");
	}
	if($('.insertImg').val()=='success'){
		alert("사진을 등록했습니다.");
	}else if($('.insertImg').val()=='failed'){
		alert("사진 등록에 실패했습니다");
	}
	
	$('.showPhoto').click(function(e){
		var empnum=$(this).parent().prev().prev().text();
		console.log(empnum);
		wrapWindowByMask(empnum);
	});    

    //검은 막을 눌렀을 때
    $('#mask').click(function () {  
        $(this).hide();
        $('.photoPopup').hide();
    });
	
});
</script>
</html>