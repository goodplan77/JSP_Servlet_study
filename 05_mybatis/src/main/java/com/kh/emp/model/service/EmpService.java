package com.kh.emp.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import static com.kh.common.MybatisTemplate.getSqlSession;

import com.kh.emp.model.dao.EmpDao;

public class EmpService {
	private EmpDao dao = new EmpDao();

	public List<Map<String, Object>> selectAllEmp() {
		SqlSession sqlSession = getSqlSession();
		List<Map<String, Object>> list = dao.selectAllEmp(sqlSession);
		sqlSession.close();

		return list;
	}

	public List<Map<String, Object>> search1(Map<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		List<Map<String, Object>> list = dao.search1(sqlSession, param);
		sqlSession.close();

		return list;
	}

	public List<Map<String, Object>> search2(Map<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		List<Map<String, Object>> list = dao.search2(sqlSession, param);
		sqlSession.close();

		return list;
	}

	public List<Map<String, String>> selectJobList() {
		SqlSession sqlSession = getSqlSession();
		List<Map<String, String>> jobList = dao.selectJobList(sqlSession);
		sqlSession.close();
		return jobList;
	}

	public List<Map<String, String>> selectDeptList() {
		SqlSession sqlSession = getSqlSession();
		List<Map<String, String>> deptList = dao.selectDeptList(sqlSession);
		sqlSession.close();
		return deptList;
	}

	public List<Map<String, Object>> search3(Map<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		List<Map<String, Object>> list = dao.search3(sqlSession, param);
		sqlSession.close();
		return list;
	}

	public Map<String, Object> selectOneEmp(String empId) {
		SqlSession sqlSession = getSqlSession();
		Map<String, Object> emp = dao.selectOneEmp(sqlSession, empId);
		sqlSession.close();
		return emp;
	}

	public int updateEmp(Map<String, String> param) {
		SqlSession sqlSession = getSqlSession();
		int result = dao.updateEmp(sqlSession, param);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}

}
