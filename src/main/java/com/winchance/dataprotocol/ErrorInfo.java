package com.winchance.dataprotocol;

public enum ErrorInfo {
    OK(200L, "OK"),

    IO_EXCEPTION(0x8000L, "IO EXCEPTION"),

    PARAMS_NOT_FULL(0xEFFDL, "PARAMS NOT FULL"),
    PARSE_PARAMS_ERROR(0xEFFFL, "PARSE_PARAMS_ERROR");

    private final Long code;
    private final String msg;

    private ErrorInfo(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
