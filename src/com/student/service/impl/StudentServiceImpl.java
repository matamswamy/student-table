package com.student.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.student.dao.StudentDAO;
import com.student.dao.impl.StudentDAOImpl;
import com.student.dao.model.StudentTl;
import com.student.exception.MyCustomeException;
import com.student.service.StudentService;
import com.student.service.dto.StudentDTO;
import com.student.utils.FactoryUtils;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO;
	public StudentServiceImpl() {
		this.studentDAO= new StudentDAOImpl();
	}

	@Override
	public Integer saveUser(StudentDTO studentDTO) {
		Integer userId = 0;
		try {
			if(studentDTO != null) {
				StudentTl studentTl = FactoryUtils.convertStudentDTOToStudentTl(studentDTO);
				if(studentTl != null) {
					userId = studentDAO.insertUser(studentTl);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public List<StudentDTO> loadAllStudents() {
		List<StudentDTO> users = new ArrayList<>();
		try {
			List<StudentTl> usersList = studentDAO.getAllUsers();
			if(usersList != null && !usersList.isEmpty()) {
				ListIterator<StudentTl> li = usersList.listIterator();
				while(li.hasNext()) {
					StudentTl studentTl = li.next();
					StudentDTO studentDTO = FactoryUtils.convertStudentTlToStudentDTO(studentTl);
					users.add(studentDTO);
				}
			}
			
		} catch (Exception e) {
			throw new MyCustomeException("Exception occured while getting user details in StudentServiceImpl"+e.getMessage());
		}
		
		return users;
	}

	
	

}
