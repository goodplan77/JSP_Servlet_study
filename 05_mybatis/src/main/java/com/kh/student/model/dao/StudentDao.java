package com.kh.student.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public class StudentDao {

	public int insertStudent(SqlSession session, Student student) {
		// namespace.queryTagId
		return session.insert("student.insertStudent" , student);
	}

}
