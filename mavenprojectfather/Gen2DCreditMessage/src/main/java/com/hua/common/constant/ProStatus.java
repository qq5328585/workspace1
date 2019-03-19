package com.hua.common.constant;

public enum  ProStatus {
    SUCCESS("SUCCESS","处理成功"),FAIL("FAIL","处理失败");

    private String code;
    private String msg;

    ProStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
