package com.mom.app.retail.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean isMobileNumberValid(String number) {
        Pattern p = Pattern.compile("^[6-9]\\d{9}$");
        Matcher m = p.matcher(number);
        return (m.find() && m.group().equals(number));
    }

    public static boolean isPanNumberValid(String panNumber) {
        Pattern panRegEx = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
        return !TextUtils.isEmpty(panNumber) && panRegEx.matcher(panNumber).matches();
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
