<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
div#student-container {
	text-align: center;
}

table.tbl-student {
	margin: 10px auto;
	border: 1px solid;
	border-collapse: collapse;
}

table.tbl-student th, table.tbl-student td {
	border: 1px solid;
	padding: 5px;
	line-height: 2em; /*input태그로 인해 cell이 높이가 길어져 border 두줄현상방지 */
}

table.tbl-student th {
	text-align: right;
}

table.tbl-student td {
	text-align: left;
}

table.tbl-student tr:last-of-type td:first-child {
	text-align: center;
}
</style>
<c:if test="${not empty msg}">
	<script>
		alert("${msg}");
		<c:remove var="msg" scope="session"/>
	</script>
</c:if>
</head>
<body>
	<div id='student-container'>
		<h2>학생정보 검색</h2>
		<p>총 학생수는 ${requestScope.total}명입니다.</p>
		<form>
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td><input type="number" name="no" value="${param.no}"
						required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>

		<c:if test="${not empty param.no && empty student}">
			<p>해당학생이 존재하지 않습니다.</p>
		</c:if>

		<c:if test="${not empty student}">
			<h1>학생 정보 수정</h1>
			<form name="studentUpdateFrm"
				action="${pageContext.request.contextPath}/student/updateStudent.do"
				method="POST">
				<table class="tbl-student">
					<tr>
						<th>학생번호</th>
						<td><input type="number" name="no" value="${student.no}"
							required readonly /></td>
					</tr>
					<tr>
						<th>학생이름</th>
						<td><input type="text" name="name" value="${student.name}"
							required /></td>
					</tr>
					<tr>
						<th>학생전화번호</th>
						<td><input type="tel" name="tel" value="${student.tel}"
							required /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="수정" /> <input
							type="button" value="삭제" onclick="deleteStudent();" /></td>
					</tr>
				</table>
			</form>
			<form name = "studentDelFrm" action="/mybatis/student/deleteStudent.do" method="post">
				<input type="hidden" name="no" value="${param.no }"/>
			</form>
			<script>
				function deleteStudent() {
					// location.href = "/mybatis/student/deleteStudent.do?no=${param.no}"; //get방식 요청
					if(confirm("정말 삭제하시겠습니까?")){
						$("[name=studentDelFrm]").submit();
					}
				}
			</script>
		</c:if>

		<h1>학생정보 검색</h1>
		<form name="ajaxStudentSearchFrm"
			action="/mybatis/student/selectOneStudentMap.do" method="post">
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td><input type="number" name="no" value="" required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>

		<script>
			$("[name=ajaxStudentSearchFrm]").submit(function (e){
				e.preventDefault(); // 폼 기본이벤트 방지
				var no = $(this).find("[name=no]").val();
				
				$.ajax({
					url : "/mybatis/student/selectOneStudentMap.do",
					data : {no}, //{no : no} 축약형
					success : function(data){
						console.log(data) // js 객체
						
						var $table = $("<table class='tbl-student'></table>");
						if(data){
							$table.append("<tr><th>학생번호</th><td>"+data.no+"</td></tr>")
							.append("<tr><th>학생번호</th><td>"+data.name+"</td></tr>")
							.append("<tr><th>학생번호</th><td>"+data.tel+"</td></tr>")
							.append("<tr><th>학생번호</th><td>"+data.regDate+"</td></tr>")
							.insertAfter($("[name=ajaxStudentSearchFrm]"));
						} else {
							alert("조회한 회원은 존재하지 않습니다.")
						}
					},
					error : function(xhr){
						console.log(xhr)
					}
				})
			})
		</script>
	</div>
</body>
</html>