package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member login(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member m = new MemberDao().login(conn , userId, userPwd);
		
		close(conn);
		
		return m;
	}

	public int idCheck(String checkId) {
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn , checkId);
		
		close(conn);
		
		return count;
	}

}
