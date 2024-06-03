<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/standard/header.jsp">
		<jsp:param value="INCLUDE" name="title"/>
	</jsp:include>
	<section>
		<article>
			<h2>모든 국민은 학문과 예술의 자유를 가진다. 국회의원의 선거구와 비례대표제 기타 선거에 관한 사항은 법률로
				정한다. 정부는 예산에 변경을 가할 필요가 있을 때에는 추가경정예산안을 편성하여 국회에 제출할 수 있다. 신체장애자 및
				질병·노령 기타의 사유로 생활능력이 없는 국민은 법률이 정하는 바에 의하여 국가의 보호를 받는다. 모든 국민은 근로의
				의무를 진다. 국가는 근로의 의무의 내용과 조건을 민주주의원칙에 따라 법률로 정한다.</h2>
				<a href="another.jsp">another</a>
		</article>
	</section>
	<jsp:include page="/standard/footer.jsp"/>

</body>
</html>