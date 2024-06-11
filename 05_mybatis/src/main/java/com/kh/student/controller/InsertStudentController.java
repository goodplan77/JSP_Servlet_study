package com.kh.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.student.model.service.StudentService;
import com.kh.student.model.vo.Student;

@WebServlet("/student/insertStudent")
public class InsertStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService studentService = new StudentService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/insertStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 입력값 처리
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student student = new Student();
		student.setName(name);
		student.setTel(tel);
		
		// 2. 서비스 요청 처리
		int result = studentService.insertStudent(student);
		
		// 3. 응답데이터처리
		request.getSession().setAttribute("msg", "학생 등록 성공");
		
		response.sendRedirect("/mybatis/student/insertStudent");
	}

}
