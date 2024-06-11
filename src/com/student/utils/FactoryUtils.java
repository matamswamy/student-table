package com.student.utils;


import com.student.dao.model.StudentTl;
import com.student.service.dto.StudentDTO;

public class FactoryUtils {
	private FactoryUtils() {
		
	}
	public static StudentTl convertStudentDTOToStudentTl(StudentDTO studentDTO) {
		StudentTl studentTl = null;
		if(studentDTO != null ) {
			studentTl = new StudentTl();
			studentTl.setFirstName(studentDTO.getFristName());
			studentTl.setLastName(studentDTO.getLastName());
			studentTl.setEmailId(studentDTO.getEmailId());
			studentTl.setMobileNumber(studentDTO.getMobileNumber());
			studentTl.setPassword(studentDTO.getPassword());
			if(studentDTO != null) {
				java.sql.Date sdate = new java.sql.Date(studentDTO.getDob().getTime());
				studentTl.setDob(sdate);
			}
			
		}
		return studentTl;
	}
	
	public static StudentDTO convertStudentTlToStudentDTO(StudentTl studentTl) {
		StudentDTO studentDTO = null;
		if(studentTl != null) {
			studentDTO = new StudentDTO();
			studentDTO.setFristName(studentTl.getFirstName());
			studentDTO.setLastName(studentTl.getLastName());
			studentDTO.setEmailId(studentTl.getEmailId());
			studentDTO.setMobileNumber(studentDTO.getMobileNumber());
			studentDTO.setPassword(studentTl.getPassword());
			studentDTO.setDob(studentTl.getDob());
			
		}
		return studentDTO;
	}

}
