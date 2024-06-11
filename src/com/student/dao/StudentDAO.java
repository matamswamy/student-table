package com.student.dao;

import java.util.List;

import com.student.dao.model.StudentTl;

public interface StudentDAO {

	public Integer insertUser(StudentTl studentTl);

	public List<StudentTl> getAllUsers();

}
