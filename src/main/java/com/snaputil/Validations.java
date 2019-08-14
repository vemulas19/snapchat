package com.snaputil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	
	public int addition(int a, int b){
		return a+b;
	}
	
	 public static boolean isValid(String MobileNumber){
		 Pattern p=Pattern.compile("[6-9][0-9]{9}");
		Matcher m=p.matcher(MobileNumber);
		boolean isok=m.matches();
		 return isok;
	 }
	 
	 public static boolean isValidMail(String Email){
		 Pattern p=Pattern.compile("^[_A-Za-z-\\+]+(\\.[_A-Za-z-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		 Matcher m=p.matcher(Email);
    boolean isMatch=m.matches();
    return isMatch;
	 }
}
