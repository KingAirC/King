package com.king.common.util;

import java.util.UUID;

public class PrimaryKeyUtils {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuidClean() {
        return uuid().replaceAll("-", "");
    }

}
