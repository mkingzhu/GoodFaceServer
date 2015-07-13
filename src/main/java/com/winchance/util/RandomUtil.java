package com.winchance.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtil {
    public static String getRandomString(int length) {
        String base = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
        Random random = new SecureRandom();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomNum(int length) {
        String base = "0123456789";
        Random random = new SecureRandom();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static boolean machRandom(int percent) {
        if (percent < 0 || percent > 100)
            return false;

        Random random = new SecureRandom();
        if ((random.nextInt(100) + 1) <= percent)
            return true;
        return false;
    }
}
