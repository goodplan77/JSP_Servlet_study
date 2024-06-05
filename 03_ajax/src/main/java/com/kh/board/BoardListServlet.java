package com.kh.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Board;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Date date = new Date();
		List<Board> list = new ArrayList<>();
		list.add(new Board(1,"kh게시판 1번글","admin","zzzzzzzz", date));
		list.add(new Board(2,"kh게시판 2번글","admin","111111111", date));
		list.add(new Board(3,"kh게시판 1번글","mkm","333333333", date));
		list.add(new Board(4,"kh게시판 4번글","user01","44444", date));
		list.add(new Board(5,"kh게시판 5번글","user02","asdfasdf", date));
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);

		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}

}
