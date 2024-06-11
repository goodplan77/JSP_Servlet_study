package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

@WebServlet("/member/insert")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberInsertController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/enrollForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 클라이언트가 요청시 전달한 값들 뽑아오기
		String userId = request.getParameter("userId"); // 필수입력값
		String userPwd = request.getParameter("userPwd"); // 필수입력값
		String userName = request.getParameter("userName"); // 필수입력값
		String phone = request.getParameter("phone"); // 선택입력값 , 기본 : ""
		String email = request.getParameter("email"); // 선택입력값 , 기본 : ""
		String address = request.getParameter("address"); // 선택입력값 , 기본 : ""
		String[] interestArr = request.getParameterValues("interest"); // 선택입력값 , 기본 : null
	
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr); // ,를 구분자로 하여 결합하는 메소드
		}
		
		// 매개변수 생성자를 이용한 Member객체 포장
		Member m = new Member(0, userId, userPwd, userName, phone, email, address, interest, null, null, interest);
	
		// 서비스 요청 처리 (처리된 행의 갯수 응답)
		int result = new MemberService().insertMember(m);
		
		// 처리된 결과를 가지고 사용자가 보게될 응답 View 지정
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "회원가입 성공");
			response.sendRedirect(request.getContextPath()); // request 비우기. 
			// CRUD 시 request 정보가 남아 있기 때문에 sendRedirect를 통해 request 정보를 비워줘야함
		} else {
			request.setAttribute("errorMsg", "회원가입 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
