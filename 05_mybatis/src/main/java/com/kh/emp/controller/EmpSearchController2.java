package com.kh.emp.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.emp.model.service.EmpService;

public class EmpSearchController2 extends AbstractController{
	
	private EmpService service = new EmpService();
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 사용자가 입력한 값 뽑아오기
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		String gender = request.getParameter("gender");
		String salStr = request.getParameter("salary");
		String salaryCompare = request.getParameter("salaryCompare");
		String hire_date = request.getParameter("hire_date");
		String hiredateCompare = request.getParameter("hiredateCompare");
		
		
		int salary = 0;
		Date hireDate = null; // java.sql.Date
		
		try {
			salary = Integer.parseInt(salStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(hire_date != null && !hire_date.equals("")) { // null이 아니고 , 빈문자열이 아닌경우 == 값이 있음
			hireDate = Date.valueOf(hire_date); //2020-06-13 
			// 문자열 형태의 값을 Date 로 변환
		}
		
		Map<String , Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		
		param.put("gender", gender);
		
		param.put("salary", salary);
		param.put("salaryCompare", salaryCompare);
		
		param.put("hire_date", hire_date); // 문자열
		param.put("hireDate", hireDate); // java.sql.Date
		param.put("hiredateCompare", hiredateCompare);
		
		System.out.println(param);
		
		// 2. 업무로직
		List<Map<String,Object>> list = service.search2(param);
		
		// 3. jsp 위임
		request.setAttribute("list", list);
		
		return "emp/search2";
	}

}
