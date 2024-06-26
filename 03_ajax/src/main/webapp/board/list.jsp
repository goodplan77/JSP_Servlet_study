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
		<c:forEach var="m" items="${list }" >
			<tr>
				<td>${m.no}</td>
				<td>${m.title}</td>
				<td>${m.nickname}</td>
				<td><fmt:formatDate value="${m.createDate}"
						pattern="20yy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>	
	/* $('tbody>tr').click(function() {
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
	}); */
	
	$('table.list-table>tbody>tr').on("click",function(){
		var no = $(this).children().eq(0).text().trim();
		
		$.ajax({
			url : "/ajax/board/view",
			data : {no} ,
			success : function(data){
				$(".outer").html(data);
			},
			error : function(xhr){
				console.log(xhr);
			}
		})
	})
</script>




