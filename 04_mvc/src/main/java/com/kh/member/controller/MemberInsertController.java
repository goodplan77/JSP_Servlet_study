package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		System.out.println("post 진입");
		HttpSession session = request.getSession();
		System.out.println((String)request.getParameter("userId"));
		System.out.println((String)request.getParameter("userPwd"));
		System.out.println((String)request.getParameter("userName"));
		System.out.println((String)request.getParameter("phone"));
		System.out.println((String)request.getParameter("email"));
		System.out.println((String)request.getParameter("address"));
		String[] arg = request.getParameterValues("interest");
		for(String s : arg) {
			System.out.println(s);
		}
	}

}
