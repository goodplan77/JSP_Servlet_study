<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 
		해당 스코프에서 id 와 동일한 속성명으로 저장된 객체를 가져옴.
		존재하지 않을 때는 해당타입의 객체를 하나 생성.
		
		(property 접근방식)
		- getter : getter 메서드에서 get을 제외하고 소문자로 시작하는 이름. -> name -> getName();
		- setter : setter 에서 set을 제외한 소문자로 시작하는 이름. -> age -> setAge(value);
	 -->
<jsp:useBean id="honngd" class="com.kh.person.Person" scope="request"></jsp:useBean>
<jsp:useBean id="sinsa" class="com.kh.person.Person"></jsp:useBean>
<jsp:setProperty property="id" name="sinsa" value='ssinsa' />
<jsp:setProperty property="name" name="sinsa" value='신사임당' />
<jsp:setProperty property="gender" name="sinsa" value='여' />
<jsp:setProperty property="age" name="sinsa" value='50' />
<jsp:setProperty property="married" name="sinsa" value='true' />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid #000;
	padding: 5px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<h1>useBean</h1>
	<table>
		<tr>
			<th>id</th>
			<td><jsp:getProperty property="id" name="honngd"/></td>
		</tr>
		<tr>
			<th>name</th>
			<td><jsp:getProperty property="name" name="honngd"/></td>
		</tr>
		<tr>
			<th>age</th>
			<td><jsp:getProperty property="age" name="honngd"/></td>
		</tr>
		<tr>
			<th>gender</th>
			<td><jsp:getProperty property="gender" name="honngd"/></td>
		</tr>
		<tr>
			<th>married</th>
			<td><jsp:getProperty property="married" name="honngd"/></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<th>id</th>
			<td><jsp:getProperty property="id" name="sinsa"/></td>
		</tr>
		<tr>
			<th>name</th>
			<td><jsp:getProperty property="name" name="sinsa"/></td>
		</tr>
		<tr>
			<th>age</th>
			<td><jsp:getProperty property="age" name="sinsa"/></td>
		</tr>
		<tr>
			<th>gender</th>
			<td><jsp:getProperty property="gender" name="sinsa"/></td>
		</tr>
		<tr>
			<th>married</th>
			<td><jsp:getProperty property="married" name="sinsa"/></td>
		</tr>
	</table>
</body>
</html>