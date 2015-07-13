package com.winchance.wechat.common.util;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import com.winchance.util.RandomUtil;

public class WeixinSign {
    public static Map<String, String> sign(String appId, String jsapiTicket, String url) {
        String nonceStr = createNonceStr();
        String timestamp = createTimestamp();

        StringBuilder build = new StringBuilder("jsapi_ticket=");
        build.append(jsapiTicket)
             .append("&noncestr=").append(nonceStr)
             .append("&timestamp=").append(timestamp)
             .append("&url=").append(url);
        String source = build.toString();

        String signature = null;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(source.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (Exception ignore) {
        }

        Map<String, String> ret = new HashMap<String, String>();
        ret.put("url", url);
        ret.put("jsapi_ticket", jsapiTicket);
        ret.put("nonceStr", nonceStr);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        ret.put("appId", appId);
        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        try {
            for (byte b : hash)
                formatter.format("%02x", b);
            return formatter.toString();
        } finally {
            formatter.close();
        }
    }

    private static String createNonceStr() {
        return RandomUtil.getRandomString(16);
    }

    private static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
