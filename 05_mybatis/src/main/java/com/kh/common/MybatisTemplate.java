package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
	
	/*
	 * mybatis-config.xml 설정파일 기반으로 sqlSession 객체 생성.
	 */
	
	public static SqlSession getSqlSession() {
		
		//mybatis-config.xml파일을 읽어들여서 DB와 접속된 SqlSession 객체를 생성한 후 반환
		SqlSession session = null;
		
		//SqlSession 객체를 생성하기 위해서 SqlSessionFactory 객체가 필요
		//SqlSessionFactory를 생성하기 위해선(인스턴스화) SqlSessionFactoryBuilder 객체가 필요
		
		String resource ="/sql/mybatis-config.xml"; // 실제 경로 : C:/워크스페이스/05_mybatis/src/main/java/webapp/WEB-INF...
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource); // 자원과 연결된 InputStream 반환
			
			// 1단계) SqlSessionFactoryBuilder 객체 생성
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			
			// 2단계) InputStream 으로 부터 설정정보를 읽어들여서 SqlSessionFactory를 생성
			SqlSessionFactory ssf = ssfb.build(stream);
			
			// 3단계) SqlSession 객체 생성 및 트랜잭션 처리시 자동 commit 설정
			// false ==  자동 commit 하지 않겠다.
			session = ssf.openSession(false); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
		
	}

}
