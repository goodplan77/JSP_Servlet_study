package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPerson2Servlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String animal = req.getParameter("animal");
		String[] foods = req.getParameterValues("food");
		
		// 비즈니스 로직
		String recommendation = "";
		switch(color){
		case "빨강" : recommendation = "빨간 짬봉"; break;
		case "노랑" : recommendation = "노랑 짬봉"; break;
		case "초록" : recommendation = "노랑 짬봉"; break;
		case "파랑" : recommendation = "파랑 짬봉"; break;
		}
		
		// 현재 servlet 에서 새로 생성된 데이터를 전달하기 위해서는
		// setAttribute(key , value:object)를 사용하여 저장.
		req.setAttribute("recommendation", recommendation);
		
		// html 작성을 jsp에게 위임
		RequestDispatcher reqdis = req.getRequestDispatcher("/servlet/testPersonRes.jsp"); // /가 최상위 webapp
		reqdis.forward(req, resp);
		
		// 응답메세지 작성
//				resp.setContentType("text/html; charset=utf-8");
//				PrintWriter out = resp.getWriter();
//				out.println("<!DOCTYPE html>");
//				out.println("<html>");
//					out.println("<head>");
//						out.println("<title>취향검사결과</title>");
//					out.println("</head>");
//					out.println("<body>");
//						out.println("<h1>개취검사결과</h1>");
//						out.println("<p>"+ name +"님의 개인 취향 검사 결과는</p>");
//						out.println("<p>좋아 하는 동물은 "+ color +"입니다</p>");
//						out.println("<p>좋아 하는 음식은 "+ Arrays.toString(foods) +"입니다.</p>");
//						out.println("<hr>");
//						out.println("<p class = 'recommendation'>오늘의 추천 음식은 "+ recommendation +"입니다.</p>");
//					out.println("</body>");
//				out.println("</html>");
		
	}
	
	

}
