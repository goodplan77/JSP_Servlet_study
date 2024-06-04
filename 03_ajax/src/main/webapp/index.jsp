<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Ajax</h1>
	
	<%
		String contextPath = request.getContextPath(); // ajax
		pageContext.setAttribute("path" , contextPath);
	%>
	<h2>js</h2>
	<ul>
		<li><a href = "${path }/js/ajax.jsp"/>js-ajax</li>
	</ul>
	
	<h2>text</h2>
	<ul>
		<li><a href = "${path }/text/text.jsp"/>text</li>
		<li><a href = "${path }/text/autocomplete.jsp"/>autocomplete</li>
	</ul>
</body>
</html>