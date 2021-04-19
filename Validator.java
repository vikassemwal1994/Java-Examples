package com.mom.app.retail.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static final Pattern p = Pattern.compile("[6-9][0-9]{9}");
	private static final Pattern patternIfscCode = Pattern.compile("^[A-Z]{4}[0][A-Z0-9]{6}$");
	private static final Pattern panCardPattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");

	public static boolean isValidPassword(CharSequence password) {
		return password.length()>=8 && password.length()<20;
	}

	public static boolean isValidName(CharSequence name) {
		return name.length()>0 && name.length()<=50;
	}

	public static boolean isValidAddress(CharSequence address) {
		return address.length()>5 && address.length()<=100;
	}

	public static boolean isValidEmail(CharSequence target) {
		return target.length()>0 && target.length()<100 && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
	}

	public static boolean isValidMobile(CharSequence target) {
		Matcher m = p.matcher(target);
		return target.length() >=5 && android.util.Patterns.PHONE.matcher(target).matches() && m.find() && m.group().equals(target);
	}

	public static boolean isValidOTPLength(CharSequence target) {
		return target.length()>=4 && android.util.Patterns.PHONE.matcher(target).matches() ;
	}

	public static boolean isValidIfscCode(CharSequence ifscCode)
	{
		Matcher m = patternIfscCode.matcher(ifscCode);
		return ifscCode.length() == 11 && m.find();
	}

	public static boolean isValidPanCardNumber(CharSequence panCardNumber)
	{
		Matcher m = panCardPattern.matcher(panCardNumber);
		return panCardNumber.length() == 10 && m.find();
	}

	public static boolean isValidAccountNumber(CharSequence target, int minLength, int maxLength){
		return target.length()>=minLength && target.length()<=maxLength;
	}

	public static boolean isValidAmount(String strAmount) {
		long amt = Long.parseLong(strAmount);
		return amt >= DmtConstants.MINIMUM_TRANSFER_AMOUNT;
	}
}
