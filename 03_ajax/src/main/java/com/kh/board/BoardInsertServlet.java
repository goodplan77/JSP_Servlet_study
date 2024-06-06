package com.kh.board;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Board;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		List<Board> temp = (List<Board>) session.getAttribute("list");

		Board board = new Board();
		board.setNo(temp.size() + 1);
		board.setTitle(request.getParameter("inputtitle"));
		board.setNickname(request.getParameter("inputnickname"));
		board.setContent(request.getParameter("inputcontent"));
		board.setCreateDate(new Date());

		temp.add(board);

		session.setAttribute("list", temp);
		
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);

	}
}
