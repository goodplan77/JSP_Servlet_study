package com.kh.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuOrderServlet
 */
@WebServlet("/menuOrder.do")
public class MenuOrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String main_menu = request.getParameter("main_menu");
		String side_menu = request.getParameter("side_menu");
		String drink_menu = request.getParameter("drink_menu");

		int price = 0;

//		request.setAttribute("main_menu", main_menu);

		switch (main_menu) {
		case "한우버거":
			price += 5000;
			break;
		case "밥버거":
			price += 4500;
			break;
		case "치즈버거":
			price += 4000;
			break;
		}

//		request.setAttribute("side_menu", side_menu);

		switch (side_menu) {
		case "감자튀김":
			price += 1500;
			break;
		case "어니언링":
			price += 1700;
			break;

		}

//		request.setAttribute("drink_menu", drink_menu);

		switch (drink_menu) {
		case "콜라", "사이다":
			price += 1000;
			break;
		case "커피":
			price += 1500;
			break;
		case "밀크쉐이크":
			price += 2500;
			break;
		}

		request.setAttribute("price", price);

		request.getRequestDispatcher("/menu/menuOrder.jsp").forward(request, response);
	}

}
