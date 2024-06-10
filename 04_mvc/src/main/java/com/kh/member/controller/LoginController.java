package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Filter 에서 인코딩 처리 완료");

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd"); // 암호화된 데이터?

		// 로그인 관련 비즈니스 로직 실행
		Member loginUser = new MemberService().login(userId, userPwd);

		if (loginUser != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "성공적으로 로그인이 되었습니다");
			
			// url재요청 방식(sendRedirect방식) -> request시 전달한 데이터를 초기화
			response.sendRedirect(request.getContextPath()); // /mvc url 전달후 재 요청
		} else {
			// 에러 메시지 속성 생성후
			// 에러 페이지 jsp로 전달
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			
		}
	}

}
