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
	pageContext.setAttribute("path", contextPath);
	%>
	<h2>js</h2>
	<ul>
		<li><a href="${path }/js/ajax.jsp" />js-ajax</li>
	</ul>

	<h2>text</h2>
	<ul>
		<li><a href="${path }/text/text.jsp" />text</li>
		<li><a href="${path }/text/autocomplete.jsp" />autocomplete</li>
	</ul>

	<h2>html</h2>
	<ul>
		<li><a href="${path }/html/html.jsp">html</a></li>
	</ul>

	<h2>xml</h2>
	<ul>
		<li><a href="${path }/xml/xml.jsp">xml</a></li>
	</ul>

	<h2>json</h2>
	<ul>
		<li><a href="${path }/json/json.jsp">json</a></li>
	</ul>

	<h2>board</h2>
	<ul>
		<li><a href="${path }/board">board</a></li>
	</ul>
</body>
</html>