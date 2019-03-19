package com.hua.utils;

public class StringUtils {
    public static String autoGenCode(String code, int num) {
        String res = "";
        res = String.format("%0" + num + "d", Long.parseLong(code));
        return res;
    }

    public static String getRecNum(int num){
        String recNum = "";
        int len = String.valueOf(num).length();
        String preFix = "";
        for(int i=0;i<7-len;i++){
            preFix +="0";
        }
        recNum = preFix + num;
        return  recNum;
    }
}
