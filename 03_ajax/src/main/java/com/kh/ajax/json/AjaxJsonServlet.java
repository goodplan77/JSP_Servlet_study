package com.kh.ajax.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.member.model.vo.Member;

/**
 * Servlet implementation class AjaxJsonServlet
 */
@WebServlet("/json")
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxJsonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * JSON(JavaScript Object Notation) - 비동기 통신에서 자주 사용되는 포맷 - 순수 문자열로 이루어져 있어서
		 * 가독성이 좋고 , 가볍기 때문에 플랫폼간의 데이터교환에 자주 사용된다.
		 * 
		 */

		// 클래스 없이 json 객체 만들기

//		Member m = new Member("gone", "김고은", "김고은.jpg");
//
//		response.setContentType("application/json; charset=utf-8");
//		String jsonMember = "{\"id\" : \"" + m.getId() + "\",\"name\" : \"" + m.getName() + "\",\"profile\" : \""
//				+ m.getProfile() + "\"}";
//		PrintWriter out = response.getWriter();
//		out.print(jsonMember);

		// 2. JSON-SIMPLE
//		Member m = new Member("gone", "김고은", "김고은.jpg");
//		JSONObject obj = new JSONObject(); // '{}'
//		obj.put("name", m.getName()); // '{"name" : "김고은"}'
//		obj.put("id", m.getId()); // '{"name" : "김고은","id" : "gone"}'
//		obj.put("profile", m.getProfile());
//
//		response.setContentType("application/json; charset=utf-8");
//		response.getWriter().print(obj);

		String searchId = request.getParameter("searchId");
		
		// 3. gson을 활용하여 json 객체 만들기 | 자바 객체 -> JSON -> 자바스크립트 객체

		List<Member> list = new ArrayList<>();
		list.add(new Member("hwan", "황제성", "hwang.jpg"));
		list.add(new Member("julia", "쥴리아 로버츠", "juliaRoberts.jpg"));
		list.add(new Member("gone", "김고은", "김고은.jpg"));
		list.add(new Member("daft", "다프트펑크", "daftpunk.jpg"));
		
		// 검색어와 일치하는 ID가 존재하는 경우 일치하는 회원정보를 보관
		Member member = null;
		
		if(searchId != null && !searchId.equals("")) {
			for(Member m : list) {
				if(m.getId().equals(searchId)) {
					member = m;
					break;
				}
			}
		}
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson((member == null) ? list : member);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
