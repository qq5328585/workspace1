package com.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    /*public static void main(String[] args) {
        System.out.println("这是入口!");
    }*/
    public static void main(String[] args) {
        int aa = 1;
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        long h = 3L;
        System.out.println(aa == a);
        System.out.println(a.equals(aa));
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

        Map<String, String> map= new HashMap<String, String>();
    }
}
