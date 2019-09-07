package com.chinasoft.lgh.codeman.server.exception;

public class CodeManException extends RuntimeException {
    private String code;

    public CodeManException(String message, String code) {
        super(message);
        this.code = code;
    }

    public CodeManException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
