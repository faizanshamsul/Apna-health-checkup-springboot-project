package com.jsp.apnahealthcheckupspringbootrestapi.verification;

import java.util.regex.Pattern;

/*
 * Email and password verification class
 */
public class EmailPasswordVerification {

	public static String verifyEmail(String email) {

		Pattern number = Pattern.compile("[0-9]");
		Pattern alphabet = Pattern.compile("[a-zA-Z]");
		Pattern special = Pattern.compile("[@.]");

		if ((number.matcher(email).find()) && (alphabet.matcher(email).find()) && (special.matcher(email).find())) {
			return email;
		} else {
			return null;
		}
	}

	public static String verifyPassword(String password) {

		Pattern number = Pattern.compile("[0-9]");
		Pattern alphabet = Pattern.compile("[a-zA-Z]");
		Pattern special = Pattern.compile("[!@#$%^&*()]");

		if(password.length()<=8) {
			if ((number.matcher(password).find()) && 
					(alphabet.matcher(password).find()) && 
					(special.matcher(password).find())) {
				return password;
			} else {
				return null;
			}
		}else {
			return null;
		}
	}
}
