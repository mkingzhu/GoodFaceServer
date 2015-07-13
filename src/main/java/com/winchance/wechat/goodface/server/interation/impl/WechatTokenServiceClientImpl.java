package com.winchance.wechat.goodface.server.interation.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.soa.common.model.SignOrder;
import com.winchance.wechat.facard.WechatTokenService;
import com.winchance.wechat.goodface.server.interation.WechatTokenServiceClient;

public class WechatTokenServiceClientImpl extends BaseServiceClientImpl implements WechatTokenServiceClient {
    @Autowired
    private WechatTokenService wechatTokenService;

    @Override
    public String getAccessToken() {
        SignOrder signOrder = getSignOrder("GET_ACCESS_TOKEN");
        return wechatTokenService.getAccessToken(signOrder);
    }

    @Override
    public String getJsapiTicket() {
        SignOrder signOrder = getSignOrder("GET_JSAPI_TICKET");
        return wechatTokenService.getJsapiTicket(signOrder);
    }
}
