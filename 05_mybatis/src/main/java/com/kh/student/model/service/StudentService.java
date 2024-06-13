package com.kh.student.model.service;

import com.kh.student.model.dao.StudentDao;
import com.kh.student.model.vo.Student;
import static com.kh.common.MybatisTemplate.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class StudentService {

	private StudentDao dao = new StudentDao();

	public int insertStudent(Student student) {
		SqlSession session = getSqlSession();

		int result = dao.insertStudent(session, student);

		// insert - 트랜잭션 처리 필요
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public int insertStudentMap(Map<String, Object> student) {
		SqlSession session = getSqlSession();

		int result = dao.insertStudentMap(session, student);

		// insert - 트랜잭션 처리 필요
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public int selectStudentCount() {
		SqlSession session = getSqlSession();

		int total = dao.selectStudentCount(session);

		session.close();

		return total;
	}

	public Student selectOneStudent(int no) {
		SqlSession session = getSqlSession();

		Student student = dao.selectOneStudent(session, no);

		session.close();

		return student;
	}

	public Map<String, Object> selectOneStudentMap(int no) {
		SqlSession session = getSqlSession();

		Map<String, Object> student = dao.selectOneStudentMap(session, no);

		session.close();

		return student;
	}

	public int updateStudent(Student student) {
		SqlSession session = getSqlSession();

		int result = dao.updateStudent(session, student);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public int deleteStudent(int no) {
		SqlSession session = getSqlSession();

		int result = dao.deleteStudent(session, no);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public List<Student> selectStudentList() {
		SqlSession sqlsession = getSqlSession();

		List<Student> list = dao.selectStudentList(sqlsession);

		sqlsession.close();

		return list;
	}

	public List<Map<String, Object>> selectStudentMapList() {
		SqlSession sqlsession = getSqlSession();

		List<Map<String , Object>> maplist = dao.selectStudentMapList(sqlsession);

		sqlsession.close();

		return maplist;
	}

}
