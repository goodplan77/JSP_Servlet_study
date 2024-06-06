<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>일반게시판</h2>
<table class='list-table'>
	<thead>
		<tr>
			<th style="width: 10%">번호</th>
			<th style="width: 40%">제목</th>
			<th style="width: 20%">작성자</th>
			<th style="width: 30%">작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="m">
			<tr>
				<th>${m.no}</th>
				<th>${m.title}</th>
				<th>${m.nickname}</th>
				<th><fmt:formatDate value="${m.createDate}"
						pattern="20yy-MM-dd" /></th>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>	
	$('tbody>tr').click(function() {
		var $no = $(this).children(':nth-of-type(1)').prop('innerText');

		$.ajax({
			url : "/ajax/board/view",
			data : {
				no : $no
			},
			success : function(data) {
				$('.outer').html(data);
			},
			error : function(xhr) {
				console.log(xhr);
			}
		})
	});
</script>




