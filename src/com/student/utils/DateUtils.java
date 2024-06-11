package com.student.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.student.exception.MyCustomeException;

public class DateUtils {
	private DateUtils() {
		
	}
	public static Date convertStringToDate(String inputDate) {
		Date date = null;
		try {
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.parse(inputDate);
		}catch(ParseException pe) {
			throw new MyCustomeException("Exception occured in DateUtils class"+inputDate+"Exception is"+pe.getMessage());
			}
		return date;
		}
	public static String convertDateTOString(Date date) {
		String outPutDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			outPutDate = sdf.format(date);
		} catch (Exception e) {
			
		}
		return outPutDate;
	}
	}


