package com.kh.emp.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.emp.model.service.EmpService;

public class EmpSearchController3 extends AbstractController{
	
	private EmpService service = new EmpService();
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 입력값 가져오기
		String[] jobCodeArr = request.getParameterValues("jobCode");
		String[] deptIdArr = request.getParameterValues("deptId");
		List<String> deptIdList = null; // 값 선택이 안되었을 수도 있음
		if(deptIdArr != null) {
			deptIdList = Arrays.asList(deptIdArr); // 불변 객체로 전달
		}
		List<String> jobCodeList = null;
		if(jobCodeArr != null) {
			jobCodeList = Arrays.asList(jobCodeArr); // 불변 객체로 전달
		}
		
		Map<String , Object> param = new HashMap<>();
		param.put("jobCodeArr" , jobCodeList);
		param.put("deptIdList" , deptIdList);
		
		// 업무 로직
		// jobList(직급정보)
		List<Map<String , String>> jobList = service.selectJobList();
		
		// deptList(부서정보)
		List<Map<String , String>> deptList = service.selectDeptList();
		
		// list(사원정보)
		List<Map<String , Object>> list = service.search3(param);
		
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("list", list);
		request.setAttribute("param", param);
		
		// jsp 포워딩
		
		return "emp/search3";
	}

}
