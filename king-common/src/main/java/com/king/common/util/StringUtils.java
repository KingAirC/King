package com.king.common.util;

public class StringUtils {

    public static String convert2DoubleBackslash(String s) {
        return s.replaceAll("\\\\", "\\\\\\\\");
    }

    public static String convert2SingleBackslash(String s) {
        return s.replaceAll("\\\\\\\\", "\\\\");
    }

    public static boolean isNullOrEmpty(String s) {
        return ((s == null) || ("".equals(s)));
    }

}
