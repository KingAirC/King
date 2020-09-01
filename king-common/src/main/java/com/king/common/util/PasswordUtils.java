package com.king.common.util;

import com.king.common.constant.Constants;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtils {

    public static String encrypt(String source, String randomSalt) {
        return new SimpleHash(Md5Hash.ALGORITHM_NAME, source, randomSalt, Constants.DEFAULT_HASH_ITERATIONS).toString();
    }

}
