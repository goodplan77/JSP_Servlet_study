<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AJAX 개요</h1>

	<!-- 
		Asynchronous Javascript and xml 의 약자
		- 동기식 / 비동기식
		동기식 : 요청(request) 처리 후 그에 해당하는 응답페이지가 돌아와야만 그 다음 작업 가능.
			만약 서버에서 호출된 결과까지 오랜 시간이 지연된다면 계속 대기해야함
			+ 새로운 화면 로딩?
			ex) form , a
		
		비 동기식 : 현재 페이지를 유지하면서 중간중간 추가적인 요청을 보내줄 수 있음.
			ex) 자동완성기능 , 아이디중복체크 , 실시간검색기능
	 -->

	<h1>XMLHttpRequest 객체를 이용한 ajax</h1>

	<button onclick="ajaxText1();">ajax get</button>
	<button onclick="ajaxText2();">ajax post</button>

	<div id='target'></div>

	<script>
	 	function ajaxText1() {
	 		var xhr = new XMLHttpRequest();
	 		xhr.open("get" , "/ajax/ajaxText.do?id=admin");
	 		
	 		xhr.onreadystatechange = () => {
	 			if(xhr.readyState == 4) { // 요청 전송 성공시
	 				
	 				if(xhr.status == 200){ // 응답 성공시
	 					console.log(xhr);
	 					target.innerText = xhr.responseText;
	 				}
	 				else if(xhr.status == 404){
	 					alert("찾는 페이지가 없습니다");
	 				} else {
	 					alert("에러발생");
	 				}
	 				
	 			}
	 		}
	 		
	 		xhr.send(); // 요청 전송
	 	}
	 	
	 	function ajaxText2() {
			const xhr = new XMLHttpRequest();
			
			xhr.open("post" , "/ajax/ajaxText.do");
			// 기본값 : 비동기식
			
			xhr.onreadystatechange = () => {
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						target.innerText = xhr.responseText;
					}
				}
			}
			
			xhr.setRequestHeader("Content-type" , "application/x-www-form-urlencoded");
			xhr.send("id=user01"); // 보내고자하는 데이터 send 함수의 매개변수로 작성
		}
	 </script>


</body>
</html>