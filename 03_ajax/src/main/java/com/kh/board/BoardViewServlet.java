package com.kh.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Board;


@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		
//		String no = request.getParameter("no");
//		request.setAttribute("no", no);
//		
//		request.getRequestDispatcher("/board/view.jsp").forward(request, response);
		List<Board> list = (List<Board>) request.getSession().getAttribute("list");
		
		int no = Integer.parseInt(request.getParameter("no"));
		for(Board b : list) {
			if(no == b.getNo()) {
				request.setAttribute("b", b);
				break;
			}
		}
		
		request.getRequestDispatcher("/board/view.jsp").forward(request, response);
	}
}
