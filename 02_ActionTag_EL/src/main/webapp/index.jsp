<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
	padding-left: 20px;
}
</style>
</head>
<body>
	<h1>ActionTag | EL</h1>
	<h2>표준 Action 태그</h2>
	<ul>
		<li><a href="/action/standard/useBean.do">useBean</a></li>
		<li><a href="/action/standard/include.jsp">include</a></li>
	</ul>
	
	<h2>el</h2>
	<ul>
		<li><a href="/action/el/elBasics.do?pname=아이폰&pcount=10&option=black&option=128gb">el basics</a></li>
		<li><a href="/action/el/elOperator.jsp">el operator</a></li>
	</ul>
	
	<h2>jstl</h2>
	<ul>
		<li><a href='${page.Context.request.contextPath}/jstl/coreBasics.do?num1=234&num2=432'>core basics</a></li>
	</ul>

</body>
</html>