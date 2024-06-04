<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="no1" value="${param.num1}" scope="page" />
<c:set var="no2" value="${param.num2}" />
<!-- 기본값 pageScope -->
<%-- <%
int no1 = 200;
pageContext.setAttribute("no1", null); // null값 + 에러가 나지 않음.
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
	border: 1px solid #000;
	margin: 10px;
}

th, td {
	border: 1px solid #000;
	padding: 5px;
}
</style>
</head>
<body>

	<h1>JSTL</h1>
	<p>JSP Custom Tag Library</p>
	<h1>Core</h1>

	<p>
		<c:out value="${no1}" />
		${no1}
	</p>
	<p>
		<c:out value="${no2}" />
		${no2}
	</p>
	<p>
		<c:out value="${no1+no2}" />
		${no1+no2}
	</p>

	<c:set var="outTest" value="<b>출력테스트</b>"></c:set>
	${outTest }
	<c:out value="${outTest }"></c:out>
	<!-- 태그로써 해석하지 않는다. -->
	<c:out value="${outTest }" escapeXml="false"></c:out>
	<!-- 태그로 해석해서 출력할지 여부 지정가능 (기본값 true. true면 해석안함 , false로 태그로 해석)  -->

	<h2>조건식</h2>
	<c:if test="${no1 > no2}">
		${no1 } > ${no2 }
	</c:if>
	<c:if test="${no1 < no2}">
		${no1 } &lt; ${no2 }
	</c:if>
	<c:if test="${no1 eq no2}">
		${no1 } eq ${no2 }
	</c:if>

	<c:set var='rnd' value='<%=new Random().nextInt(100)%>' />
	<p>
		<c:choose>
			<c:when test="${rnd mod 5 eq 0}">인형뽑기 성공</c:when>
			<c:when test="${rnd mod 5 eq 1}">권총뽑기 성공</c:when>
			<c:otherwise>꽝입니다</c:otherwise>
		</c:choose>
	<h2>반복문</h2>
	<c:forEach var="i" begin='1' end='6' step='1'>
		<h ${7-i}>Hello World${7-i}</h${7-i}>
	</c:forEach>

	<c:set var="list" value='<%=Arrays.asList("홍길동", "신사임당", "이순신")%>'></c:set>
	<c:forEach var="i" begin="0" end='${list.size() - 1}'>
		<p>${list[i]}</p>
	</c:forEach>
	<c:forEach items="${list }" var='name' varStatus="vs">
		<p>${vs.index}${vs.count }-${name }</p>
	</c:forEach>

	<table>
		<tr>
			<th>No</th>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>나이</th>
			<th>결혼여부</th>
		</tr>

		<c:forEach items="${personList}" var='person' varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${person.id}</td>
				<td>${person.name}</td>
				<td>${person.gender}</td>
				<td>${person.age}</td>
				<td><input type='checkbox' ${person.married ? 'checked' : '' }
					onclick='return false;'></td>
			</tr>
		</c:forEach>
	</table>

	<table>
		<c:forEach items="${map }" var='item'>
			<tr>
				<th>${item.key}</th>
				<td>${item.value}</td>
			</tr>
		</c:forEach>
	</table>

	<hr>

	<h3>5. 반복문 - forTokens</h3>
	<c:set var="device" value="컴퓨터,휴대폰,TV,에어컨/냉장고.세탁기"></c:set>

	<ul>
		<c:forTokens var='d' items="${device}" delims=",./">
			<li>${d }</li>
		</c:forTokens>
	</ul>
	
	<hr>
	<h2>url</h2>
	<img src="/action/resources/images/bono.jpg"/>
	<img src="<c:url value='/resources/images/bono.jpg'/>"/>
	<!-- contextPath 불필요. -->
	
	<a href="/action/el/elBasics.do?pname=아이폰&pcount=10&option=black&option=128gb">기존 방식</a>
	
	<c:url var='query' value = '/el/elBasics.do'>
		<c:param name="pname" value='아이폰'/>
		<c:param name="pcount" value='10'/>
		<c:param name="option" value='black'/>
		<c:param name="option" value='128gb'/>
	</c:url>
	
	<a href="${query}">c:url 을 이용한 방식</a>
</body>
</html>