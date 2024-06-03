<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String life = "life is very short!";
pageContext.setAttribute("life", life);
pageContext.setAttribute("movie", "노인을 위한 나라는 없다");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <%
	String coffee = (String)request.getAttribute("coffee");
%> --%>
<body>
	<h1>EL Basics</h1>
	<%-- scope 생략시 pageScope , request , sessionScope , applicationScope --%>
	<p>${life}</p>
	<p>${requestScope.coffee}</p>
	<p>${serverTime}</p>
	<p>${honngd["id"]}</p>
	<%-- <p>${honngd.nickname }</p> 
		javax.el.PropertyNotFoundException: [nickname] 특성이 [com.kh.person.Person] 유형에 없습니다.
	--%>

	<p>${honngd.name }</p>
	<p>${honngd.gender }</p>
	<p>${honngd.age }</p>
	<p>${honngd.married }</p>
	<p>${book }</p>
	<p>${sessionScope.book }</p>
	<p>${movie }</p>
	<p>${applicationScope.movie }</p>
	
	<h2>list</h2>
	<p>${list }</p>
	<p>${list[0] }</p>
	<p>${list[1] }</p>
	<p>${list[2] }</p>
	<p>[${list[3] }]</p>
	
	<h2>map</h2>
	<p>${map }</p>
	<p>${map.language }</p>
	<p>${map["Mr.mkm"] }</p>
	<p>${map["Mr.mkm"].name }</p>
	
	<h1>param</h1>
	<p>${param.pname }</p>
	<p>${param.pcount }</p>
	<p>${paramValues.option[0] }</p>
	<p>${paramValues.option[1] }</p>
	
	<h1>cookie</h1>
	<p>${cookie.JSESSIONID }</p>
	<p>${cookie.JSESSIONID.value }</p>
	
	<h1>header</h1>
	<p>${header.accept}</p>
	<p>${header['user-agent']}</p>
	
	<h1>pageContext</h1>
	<p>${pageContext.request.contextPath}</p>
	<p>${pageContext.request.method}</p>

</body>
</html>