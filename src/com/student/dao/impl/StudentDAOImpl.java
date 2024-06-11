package com.student.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.dao.StudentDAO;
import com.student.dao.model.StudentTl;
import com.student.utils.JDBCUtils;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public Integer insertUser(StudentTl studentTl) {
		Integer studentId = 0;
		PreparedStatement pst = null;
		try {
			String sql = "insert into student_tl(first_name,last_name,email_id,mobile_number,password,dob)values(?,?,?,?,?,?)";
			pst = JDBCUtils.getConnection().prepareStatement(sql);
			pst.setString(1, studentTl.getFirstName());
			pst.setString(2, studentTl.getLastName());
			pst.setString(3, studentTl.getEmailId());
			pst.setString(4, studentTl.getMobileNumber());
			pst.setString(5, studentTl.getPassword());
			pst.setDate(6, studentTl.getDob());
			studentId = pst.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeStatement(pst);
		}
		return studentId;
	}

	@Override
	public List<StudentTl> getAllUsers() {
		List<StudentTl> students = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select first_name,last_name,email_id,mobile_number,password,dob from student_tl";
			st = JDBCUtils.getConnection().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				StudentTl studenttl = new StudentTl();
				studenttl.setUserId(rs.getInt("user_id"));
				studenttl.setFirstName(rs.getString("frist_name"));
				studenttl.setLastName(rs.getString("last_name"));
				studenttl.setEmailId(rs.getString("email_id"));
				studenttl.setMobileNumber(rs.getString("mobile_number"));
				studenttl.setPassword(rs.getString("mobile_number"));
				studenttl.setDob(rs.getDate("dob"));
				students.add(studenttl);
			}
		} catch (SQLException sqle) {
			
		}catch (Exception e) {
			
		}
		return students;
	}

}
