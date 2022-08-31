package com.dmartinezl.generics;

import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericValidPassword {
	
	 private static final String COMPLEX_PASSWORD_REGEX =
	            "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
	            "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
	            "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
	            "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
	            "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
	            "{8,32}$";
		 
		private static final Pattern PASSWORD_PATTERN = Pattern.compile(COMPLEX_PASSWORD_REGEX);
		
	
	public String ValidPassword(String password) {
		
			 if (PASSWORD_PATTERN.matcher(password).matches()) {
		            return "Ok";
		        }
		        else {
		        	return "password from 4 to 32 characters that requires at least 3 of 4 (uppercase"
					 		+ " and lowercase letters, numbers and special characters) and at most"
					 		+ " 2 consecutive equal characters.";
		        }
			 
		}


}
