package com.student.controller;

import java.util.List;

import com.student.service.StudentService;
import com.student.service.dto.StudentDTO;
import com.student.service.impl.StudentServiceImpl;

public class StudentController {
	
	private StudentService studentService;
	
	public StudentController() {
		this.studentService= new StudentServiceImpl();
	}
	
	public Integer insertUSers(StudentDTO studentDTO) {
		if(studentDTO != null) {
			return studentService.saveUser(studentDTO);
		}
		return null;
	}
	
	public List<StudentDTO> getAllUsers(){
		return studentService.loadAllStudents();
	}

}
