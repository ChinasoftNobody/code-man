package com.chinasoft.lgh.codeman.service.pojo;

public class Response<T> {
    private boolean success;
    private T result;
    private String error;

    public Response(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    public Response(boolean success, T result, String error) {
        this.success = success;
        this.result = result;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static <T> Response<T> success(T result) {
        return new Response<>(true, result, null);
    }

    public static <T> Response<T> error(String error) {
        return new Response<>(false, null, error);
    }
}
