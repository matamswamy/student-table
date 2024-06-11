package com.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	private JDBCUtils() {

	}

	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_student_db", "root", "Dharshan@123");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306//jdbc_student_db","root","Dharshan@123");
			} catch (ClassNotFoundException clfe) {
				clfe.printStackTrace();

			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return con;
	}
	public static void  closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException sqle) {
			   sqle.printStackTrace();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		}
	}
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
