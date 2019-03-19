package com.hua.common.security;


import org.apache.commons.codec.binary.Base64;

public class Base64Util {
    public static String encode(byte[] bytes){
        return Base64.encodeBase64String(bytes);
    }

    public static  byte[] decode(String s){
        return  Base64.decodeBase64(s);
    }
}
