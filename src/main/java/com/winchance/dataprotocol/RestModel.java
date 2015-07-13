package com.winchance.dataprotocol;

public class RestModel<T> {
    private String version = "1.0";
    private String encoding = "UTF-8";

    private Long errorCode = null;
    private String errorMsg = null;

    private Entity<T> entity = null;
    private Feed<T> feed = null;

    public RestModel() {}

    public RestModel(Entity<T> entity, Feed<T> feed, ErrorInfo errorInfo) {
        this.entity = entity;
        this.feed = feed;
        this.errorCode = errorInfo.getCode();
        this.errorMsg = errorInfo.getMsg();
    }

    public String getVersion() {
        return version;
    }

    public String getEncoding() {
        return encoding;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Entity<T> getEntity() {
        return entity;
    }

    public Feed<T> getFeed() {
        return feed;
    }
}
