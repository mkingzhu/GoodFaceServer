package com.winchance.util;

import java.util.regex.Pattern;

public class StringUtil {
    private static final ThreadLocal<Pattern> mobilePatternLocal = new ThreadLocal<Pattern>() {
        @Override
        protected Pattern initialValue() {
            return Pattern.compile("^((13[0-9])|147|(15[0-3,5-9])|(18[0,2,3,5-9]))\\d{8}$");
        }
    };

    public static boolean isEmpty(String value) {
        int strLen;
        if ((null == value) || (0 == (strLen = value.length())))
            return true;

        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(value.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean isValidMobile(String mobile) {
        if (isEmpty(mobile))
            return false;

        if (mobile.equals("13800138000") || mobile.equals("13000000000"))
            return false;

        return mobilePatternLocal.get().matcher(mobile).matches();
    }
}
