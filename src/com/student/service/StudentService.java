package com.student.service;

import java.util.List;

import com.student.service.dto.StudentDTO;

public interface StudentService {
	public Integer saveUser(StudentDTO studentDTO);
	
	public List<StudentDTO>  loadAllStudents();

}
