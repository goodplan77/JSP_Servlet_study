package com.kh.student.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public class StudentDao {

	public int insertStudent(SqlSession session, Student student) {
		// namespace.queryTagId
		return session.insert("student.insertStudent", student);
	}

	public int insertStudentMap(SqlSession session, Map<String, Object> student) {
		return session.insert("student.insertStudentMap", student);
	}

	public int selectStudentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}

	public Student selectOneStudent(SqlSession session, int no) {
		return session.selectOne("student.selectOneStudent" , no);
	}

	public Map<String, Object> selectOneStudentMap(SqlSession session, int no) {
		return session.selectOne("student.selectOneStudentMap" , no); // 조회결과가 없을때 NULL 반환
	}

	public int updateStudent(SqlSession session, Student student) {
		return session.update("student.updateStudent" , student);
	}

	public int deleteStudent(SqlSession session, int no) {
		return session.delete("student.deleteStudent" , no);
	}

	public List<Student> selectStudentList(SqlSession sqlsession) {
		return sqlsession.selectList("student.selectStudentList"); // 조회결과가 없을때 빈 컬렉션 반환
	}

	public List<Map<String , Object>> selectStudentListMap(SqlSession sqlsession) {
		return sqlsession.selectList("student.selectStudentListMap");
	}

}
