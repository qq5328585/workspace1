package com.hua.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String date2String(String format, Date date){
        if(date == null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return  sdf.format(date);
    }

    public static void main(String[] args) {
        System.out.println(date2String("yyyyMMdd",new Date()));
    }
}
