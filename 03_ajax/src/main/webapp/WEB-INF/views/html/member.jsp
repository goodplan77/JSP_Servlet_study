<%@ page import="com.kh.ajax.member.model.vo.Member"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
List<Member> list = (List<Member>) request.getAttribute("list");
%>

<table>
	<%
	for (Member m : list) {
	%>
	<tr>
		<td><%=m.getId()%></td>
		<td><%=m.getName()%></td>
		<td><img src="/ajax/images/<%= m.getProfile() %>"></td>
	</tr>
	<%
	}
	%>
</table> --%>
<table>
<c:forEach items ="${list }" var = "m">
		<tr>
			<td>${m.id }</td>
			<td>${m.name }</td>
			<td><img src="/ajax/images/${m.profile }"></td>
		</tr>
</c:forEach>
</table>