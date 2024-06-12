package com.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.student.model.service.StudentService;
import com.kh.student.model.vo.Student;

public class SelectOneStudentController extends AbstractController{

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = 0;
		request.getParameter("no");
		try {
			no = Integer.parseInt(request.getParameter("no"));
		} catch (NumberFormatException e) {
			
		}
		
		// 클라이언트가 학생번호를 입력한 경우
		if(no != 0) {
			Student student = new StudentService().selectOneStudent(no);
			request.setAttribute("student", student);
		}
		
		//학생수 조회
		int total = new StudentService().selectStudentCount();
		request.setAttribute("total", total);
		
		return "student/selectOne";
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "";
	}
	
	
}
