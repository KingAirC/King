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

    public static String convertTableName2PojoName(String tableName) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = tableName.split("_");

        for (String s : strings) {
            stringBuffer.append(s.substring(0, 1).toUpperCase() + s.substring(1));
        }

        return stringBuffer.toString();
    }

}
