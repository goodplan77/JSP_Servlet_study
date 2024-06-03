<%-- page 지시어 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import='java.util.* , java.io.*'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file='/jsp/header.jsp'%>
	<h1>Basic</h1>
	<%
	// jsp의 구성요소 : scriptlet
	int sum = 0;
	for (int i = 1; i <= 10; i++) {
		sum += i;
	}

	// 현재시작
	Date now = new Date();
	%>

	<p>
		server-side : java로 계산된 결과 :
		<%=sum%></p>
	<!-- jsp의 구성요소 : 출력식 -->
	<p>
		server-side : java로 계산된결과 :
		<%
	out.println(now.getTime());
	%>
	</p>

	<p>
		client-side : javascript로 계산된 결과 : <span id="sum"></span>
	</p>
	<p>
		client-side : javascript로 계산된 현재시각 : <span id="now"></span>
	</p>
	<script>
		var sum = 0;
		for (var i = 0; i <= 10; i++) {
			sum += i;
		}
		document.querySelector("#sum").innerText = sum;
		var date = new Date();
		now.innerText = date + "()" + date.getTime() + ")";
	</script>
	<%@ include file='/jsp/footer.jsp'%>
</body>
</html>