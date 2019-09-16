package com.chinasoft.lgh.codeman.server.exception;


import com.alibaba.fastjson.JSON;
import com.chinasoft.lgh.codeman.server.common.Response;
import com.chinasoft.lgh.codeman.server.config.MessageLoader;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CodeManControllerAdvice {
    @Resource
    private MessageLoader messageLoader;

    @ExceptionHandler(CodeManException.class)
    public void error(CodeManException e, HttpServletResponse response) {
        try {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSON.toJSONString(Response.err(messageLoader.get(e.getCode()))));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    @ExceptionHandler(AccessDeniedException.class)
    public void error(AccessDeniedException e, HttpServletResponse response){
        try {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSON.toJSONString(Response.err(messageLoader.get(ExceptionCode.PERMISSION_DENIED))));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @ExceptionHandler(Exception.class)
    public void error(Exception e, HttpServletResponse response) {
        try {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSON.toJSONString(Response.err(messageLoader.get(ExceptionCode.SYSTEM_ERROR))));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @ExceptionHandler(BindException.class)
    public void error(BindException e, HttpServletResponse response) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            e.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError)objectError;
                stringBuffer.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append(System.lineSeparator());
            });
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSON.toJSONString(Response.err(stringBuffer.toString())));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void error(MethodArgumentNotValidException e, HttpServletResponse response){
        try {
            StringBuffer stringBuffer = new StringBuffer();
            e.getBindingResult().getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError)objectError;
                stringBuffer.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append(System.lineSeparator());
            });
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSON.toJSONString(Response.err(stringBuffer.toString())));
        }catch (IOException e1){
            e1.printStackTrace();
        }
    }
}
