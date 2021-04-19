package com.mom.app.retail.utils;

import java.text.DecimalFormat;

public class DecimalMomFormat {

    public static String getDoubleFormat(double data)
    {
        String sFromat="";

        DecimalFormat decimalFormat=new DecimalFormat("0.00");
       return String.valueOf(decimalFormat.format(data));
       }
}
