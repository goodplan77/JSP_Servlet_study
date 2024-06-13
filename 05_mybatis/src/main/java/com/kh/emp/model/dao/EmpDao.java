package com.kh.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDao {

	public List<Map<String, Object>> selectAllEmp(SqlSession sqlSession) {
		return sqlSession.selectList("emp.selectAllEmp");
	}

	public List<Map<String, Object>> search1(SqlSession sqlSession, Map<String, Object> param) {
		return sqlSession.selectList("emp.search1" , param);
	}

	public List<Map<String, Object>> search2(SqlSession sqlSession, Map<String, Object> param) {
		return sqlSession.selectList("emp.search2" , param);
	}

	public List<Map<String, String>> selectJobList(SqlSession sqlSession) {
		return sqlSession.selectList("emp.selectJobList");
	}

	public List<Map<String, String>> selectDeptList(SqlSession sqlSession) {
		return sqlSession.selectList("emp.selectDeptList");
	}

	public List<Map<String, Object>> search3(SqlSession sqlSession, Map<String, Object> param) {
		return sqlSession.selectList("emp.search3" , param);
	}

	public Map<String, Object> selectOneEmp(SqlSession sqlSession, String empId) {
		return sqlSession.selectOne("emp.selectOneEmp" , empId);
	}

	public int updateEmp(SqlSession sqlSession, Map<String, String> param) {
		return sqlSession.update("emp.updateEmp" , param);
	}

}
