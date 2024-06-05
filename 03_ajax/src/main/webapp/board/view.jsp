<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 상세보기 페이지 -->
<h2>게시판상세보기</h2>
<table class='detail-table'>
	<tr>
		<th colSpan="4">${list[0].title}</th>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${list[0].nickname}</td>
		<th>작성일</th>
		<td><fmt:formatDate value="${list[0].createDate}" pattern="20yy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td colSpan="3" style="height: 200px;">${list[0].content}</td>
	</tr>
</table>


