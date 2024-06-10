package com.kh.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;

@WebFilter(urlPatterns = {
		"/member/myPage",
		"/notice/list",
		"/notice/insert/",
		"/notice/view"
}) // 여러개의 url 패턴을 제시하고 싶은 경우 , 위와 같은 배열 형태로 제시 해야함
public class LoginFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		// ServletRequest -> HttpServletRequest 형변환. Http 프로토콜 방식?
		
		HttpSession session = httpReq.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		if(loginUser == null) { // 로그인이 되어 있지 않은 상황
			session.setAttribute("alertMsg", "로그인 후 사용할 수 있습니다.");
			httpRes.sendRedirect(httpReq.getContextPath()); // /mvc 경로로 url 재전송
			return ; // 다음 chain이 실행되지 못하도록 반환
		}
		
		chain.doFilter(request, response);
		// filter 가 여러개 모여 chain을 이룸. chain + doFilter() 를 이용하여 다음 필터 실행
		// 마지막 이라면 service 메소드 호출
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
