package com.winchance.wechat.goodface.server.web.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winchance.util.StringUtil;
import com.winchance.wechat.common.Constant;
import com.winchance.wechat.common.util.WeixinSign;
import com.winchance.wechat.goodface.server.interation.WechatTokenServiceClient;

@Controller
public class HomeController {
    @Autowired
    private WechatTokenServiceClient wechatTokenServiceClient;

    @RequestMapping(value = "ResultView.htm", method = { RequestMethod.GET })
    public String resultView(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAllAttributes(WeixinSign.sign(Constant.APP_ID,
                                                  wechatTokenServiceClient.getJsapiTicket(),
                                                  getUrl(request)));
        return "home/ResultView";
    }

    @RequestMapping(value = "RuleView.htm", method = { RequestMethod.GET })
    public String ruleView(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAllAttributes(WeixinSign.sign(Constant.APP_ID,
                                                  wechatTokenServiceClient.getJsapiTicket(),
                                                  getUrl(request)));
        return "home/RuleView";
    }

    @RequestMapping(value = "TakePhotoView.htm", method = { RequestMethod.GET })
    public String takePhotoView(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAllAttributes(WeixinSign.sign(Constant.APP_ID,
                                                  wechatTokenServiceClient.getJsapiTicket(),
                                                  getUrl(request)));
        return "home/TakePhotoView";
    }

    private String getUrl(HttpServletRequest request) {
        StringBuffer url = new StringBuffer("http://ws.winchance870.com");
        url.append(request.getRequestURI());
        String queryString = request.getQueryString();
        if (!StringUtil.isEmpty(queryString))
            url.append("?").append(queryString);
        return url.toString();
    }
}
