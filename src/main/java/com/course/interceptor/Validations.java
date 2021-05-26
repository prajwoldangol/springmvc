package com.course.interceptor;

public class Validations {
	
	public static boolean isValidNum( String data ) {

		return data.matches("[0-9]+");

	}
	public static boolean isValidPhoneNum( String data) {

		return  data.length() == 10 && data.matches("[0-9]+") ;
	}

}
