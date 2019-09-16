package com.chinasoft.lgh.codeman.server.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private T result;
    private int status;
    private String error;

    public static <E> Response<E> of(E result){
        return new Response<>(result, 200, null);
    }

    public static Response<String> err(String error){
        return new Response<String>(null, 500, error);
    }
}
