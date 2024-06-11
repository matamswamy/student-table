package com.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.service.dto.StudentDTO;
import com.student.utils.DateUtils;

public class StudentApplication {
	private static StudentController studentController;

	static {
		studentController = new StudentController();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer option = 0;
		do {
			System.out.println("Entre option");
			System.out.println("0 for exit");						
			System.out.println("1 for insertUser");						
			System.out.println("2 for getAllUser");
			option = sc.nextInt();
			switch (option) {
			case 1:
				saveUSer();
				break;
			case 2:
				getAllUsers();
				break;

			default:
				System.out.println("please select correct option");
				break;
			case 0:
				System.out.println("your exit");
				
			}
		} while (option != 0);

	}

	public static void saveUSer() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String firstName = br.readLine();
			String lastName = br.readLine();
			String emailId = br.readLine();
			String mobileNumber = br.readLine();
			String password = br.readLine();
			String dob = br.readLine();
			Date udate = DateUtils.convertStringToDate(dob);
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setFristName(firstName);
			studentDTO.setLastName(lastName);
			studentDTO.setEmailId(emailId);
			studentDTO.setMobileNumber(mobileNumber);
			studentDTO.setPassword(password);
			studentDTO.setDob(udate);;
			Integer userId = studentController.insertUSers(studentDTO);
			if (userId != 0 && userId > 0) {
				System.out.println("student Details are scusess full inserted");
			} else {
				System.out.println("student Details not inserted");
			}
		} catch (Exception e) {

		}

	}
	
	public static void getAllUsers() {
		try {
			List<StudentDTO> users = studentController.getAllUsers();
			if(users !=null && !users.isEmpty()) {
				for(StudentDTO user : users) {
					System.out.println("student Details are");
					System.out.println("studend id is"+user.getUserId());
					System.out.println("student firstName is"+user.getFristName());
					System.out.println("student lastName is"+user.getLastName());
					System.out.println("student emailId is"+user.getEmailId());
					System.out.println("student mobileNumber is"+user.getMobileNumber());
					System.out.println("student password is"+user.getMobileNumber());
					System.out.println("student date is"+DateUtils.convertDateTOString(user.getDob()));
				}
			}else {
				System.out.println("user details are not avalable");
			}
		}catch (Exception e) {
			
		}
	}

}
