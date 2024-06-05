<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<members>
	<c:forEach items="${list }" var='member'>
		<member>
			<id>${member.id}</id>
			<name>${member.name}</name>
			<profile>${member.profile}</profile>
		</member>
	</c:forEach>
</members>
