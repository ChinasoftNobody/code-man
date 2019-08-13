package com.chinasoft.lgh.codeman.service.exception;

public class IamException extends RuntimeException {
    private String code;

    public IamException(String message, String code) {
        super(message);
        this.code = code;
    }

    public IamException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
