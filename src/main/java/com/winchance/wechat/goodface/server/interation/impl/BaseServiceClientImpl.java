package com.winchance.wechat.goodface.server.interation.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soa.common.model.SignOrder;
import com.soa.common.utils.cipher.TripleDES;
import com.winchance.util.StringUtil;

public abstract class BaseServiceClientImpl {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String key = "WINCHANCE-oms@#193g%(^$}";

    private TripleDES tripleDES;

    protected SignOrder getSignOrder(String key) {
        if (StringUtil.isEmpty(key))
            return null;

        String sign = encrypt(key);

        SignOrder signOrder = new SignOrder();
        signOrder.setKey(key);
        signOrder.setSign(sign);
        return signOrder;
    }

    private String encrypt(String src) {
        try {
            tripleDES = new TripleDES(key);
            return tripleDES.encrypt(src);
        } catch (Exception ignore) {
        }
        return "";
    }
}
