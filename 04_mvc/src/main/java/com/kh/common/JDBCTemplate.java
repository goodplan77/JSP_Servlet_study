package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	public static Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##SERVER", "SERVER");
			
			conn.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void commit(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				// 커넥션 설정 완료 , 닫혀 있을때만 commit 실행
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void rollback(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				// 커넥션 설정 완료 , 닫혀 있을때만 rollback 실행
				conn.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				// 커넥션 설정 완료 , 닫혀 있을때만 close 실행
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Apache-Tomcat : 에러 발생시 별도 에러 페이지 발생등... -> 서버 종료는 안함

	public static void close(Statement stmt) {

		try {
			if (stmt != null && !stmt.isClosed()) {
				// 스테이트먼트 설정 완료 , 닫혀 있을때만 close 실행
				stmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {

		try {
			if (rset != null && !rset.isClosed()) {
				// ResultSet 설정 완료 , 닫혀 있을때만 close 실행
				rset.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
