package com.winchance.wechat.goodface.server.model;

import com.winchance.wechat.goodface.server.dao.dataobject.ImageDo;

public class Image {
    private String userId;

    private Long referTime;

    private String url;

    private String imageString;

    public ImageDo toImageDo() {
        ImageDo imageDo = new ImageDo();
        imageDo.setUserId(this.getUserId());
        imageDo.setReferTime(this.getReferTime());
        imageDo.setUrl(this.getUrl());
        return imageDo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getReferTime() {
        return referTime;
    }

    public void setReferTime(Long referTime) {
        this.referTime = referTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
