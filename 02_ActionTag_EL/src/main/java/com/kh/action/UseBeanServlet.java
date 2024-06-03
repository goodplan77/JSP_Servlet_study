package com.kh.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.person.Person;

@WebServlet("/standard/useBean.do")
public class UseBeanServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
		Person person = new Person();
		person.setId("honngd");
		person.setName("홍길동");
		person.setAge(35);
		person.setGender('남');
		person.setMarried(true);
		
		req.setAttribute("honngd", person);
		
		req.getRequestDispatcher("/standard/useBean.jsp").forward(req, res);
	}
}
