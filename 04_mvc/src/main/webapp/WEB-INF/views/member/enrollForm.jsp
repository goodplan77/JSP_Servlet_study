<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer {
	background: black;
	color: white;
	width: 1000px;
	margin: auto; /* 가운데 자동 정렬 */
	margin-top: 50px; /* 위로부터 50px 아래로 여백 만들기 */
}

#enroll-form table {
	margin: auto;
}

#enroll-form input {
	margin: 5px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/menubar.jsp"%>
	<div class="outer">

		<br>
		<h2 align="center">회원가입</h2>

		<form id="enroll-form" action="${path}/member/insert"
			method="post">

			<!-- 아이디, 비밀번호, 이름, 전화번호, 이메일, 주소, 취미 -->
			<table>
				<!-- (tr>td*3)*8 -->
				<tr>
					<td>* 아이디</td>
					<td><input type="text" name="userId" maxlength="12" required></td>
					<td><button type="button" onclick="idCheck();">중복확인</button></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="userPwd" maxlength="15"
						required></td>
					<td></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" maxlength="15" required></td>
					<!-- 단순 비교 확인 용도라 key 값을 부여 안해도 됨 -->
					<td></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName" maxlength="6" required></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;전화번호</td>
					<td><input type="text" name="phone" placeholder="- 포함해서 입력">
					<td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td><input type="text" name="address"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;관심분야</td>
					<td colspan="2">
						<!-- (input[type=checkbox name=interest id= value=]+label)*6 --> <input
						type="checkbox" name="interest" id="sports" value="운동"> <label
						for="sports">운동</label> <input type="checkbox" name="interest"
						id="hiking" value="등산"> <label for="hiking">등산</label> <input
						type="checkbox" name="interest" id="fishing" value="낚시"> <label
						for="fishing">낚시</label> <br> <input type="checkbox"
						name="interest" id="cooking" value="요리"> <label
						for="cooking">요리</label> <input type="checkbox" name="interest"
						id="game" value="게임"> <label for="game">게임</label> <input
						type="checkbox" name="interest" id="movie" value="영화"> <label
						for="movie">영화</label>
					</td>
				</tr>
			</table>

			<br>
			<br>

			<div align="center">
				<button type="submit" disabled>회원가입</button>
				<!-- 유효성 검사 완료후 disabled 해체 하는 방식 -->
				<button type="reset">초기화</button>
			</div>

			<br>
			<br>

		</form>

	</div>
	
	<script>
		function idCheck() {
			var $userId = $('#enroll-form [name=userId]');
			/* 명확하게 요소를 선택 해줘야함 */
			
			$.ajax({
				url : "${path}/member/idCheck",
				data : {
					checkId : $userId.val()
				},
				success : function(result){
					// 에러 코드 값 들?
					// result == "NN" -> 중복사용(사용불가)
					// result == "NY" -> 사용가능한 ID
					// result == "NNN"
					if(result === 'NY'){ // 중복 검사 유효 한 경우
						if(confirm("사용 가능한 아이디 입니다. 사용하시겠습니까?")){
							$("#enroll-form :submit").removeAttr("disabled"); // 회원가입 막기 기능 해체
							$userId.attr("readonly",true); // 다시 수정을 못하도록 읽기 전용으로 설정
						} else {
							$userId().val(""); // 입력한 값 비워두기
							$userId.focus(); // 강조 표시
						}
					} else { // 중복 검사 유효 하지 않은 경우
						alert("이미 존재하거나 사용할 수 없는 아이디입니다.");
						$userId().val(""); // 입력한 값 비워두기
						$userId.focus(); // 강조 표시
					}
				},
				error : function(xhr){
					console.log(xhr);
				}
			})
		}
	</script>

</body>
</html>