<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List"%>
<%@ page import= "com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String no = (String)request.getAttribute("no");
%>
<h2>게시판상세보기</h2>
<table class='detail-table'>
	<tr>
		<th colSpan="4">${list[no-1].title}</th>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${list[no-1].nickname}</td>
		<th>작성일</th>
		<td><fmt:formatDate value="${list[no-1].createDate}" pattern="20yy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td colSpan="3" style="height: 200px;">${list[no-1].content}</td>
	</tr>
</table>


