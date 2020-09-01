package com.king.common.util;

import java.util.Random;

public class RandomUtils {

    /**
     * 产生n位随机数
     *
     * @return
     */
    public static String random(int n) {
        int begin = (int) Math.pow(10, n - 1);
        int bound = 9 * begin;

        int r = new Random().nextInt(bound) + begin;

        return "" + r;
    }

    /**
     * 默认产生5位随机数
     *
     * @return
     */
    public static String random() {
        return random(5);
    }

}
