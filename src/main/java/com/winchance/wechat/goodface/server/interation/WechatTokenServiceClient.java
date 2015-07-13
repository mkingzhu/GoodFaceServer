package com.winchance.wechat.goodface.server.interation;

public interface WechatTokenServiceClient {
    public String getAccessToken();

    public String getJsapiTicket();
}
