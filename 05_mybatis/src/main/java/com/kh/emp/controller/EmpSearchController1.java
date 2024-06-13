package com.kh.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.emp.model.service.EmpService;

public class EmpSearchController1 extends AbstractController {

	private EmpService service = new EmpService();

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 사용자 입력값
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");

		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		// System.out.println(param);

		// 2. 업무로직 (검색했을경우 / 검색안한경우)
		List<Map<String, Object>> list = null;
		if (searchType == null || searchKeyword == null) {
			list = service.selectAllEmp(); // 전체 회원 조회
		} else {
			list = service.search1(param);
		}

//		for(Map<String,Object> emp : list) {
//		System.out.println(emp);
//	}

		// 3. jsp 작업 위임
		request.setAttribute("list", list);

		return "emp/search1";
	}

}
