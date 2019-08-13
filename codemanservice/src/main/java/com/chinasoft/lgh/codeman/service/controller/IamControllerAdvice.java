package com.chinasoft.lgh.codeman.service.controller;


import com.chinasoft.lgh.codeman.service.config.MessageLoader;
import com.chinasoft.lgh.codeman.service.exception.IamException;

import java.io.IOException;

@ControllerAdvice
public class IamControllerAdvice {
    @Resource
    private MessageLoader messageLoader;

    @ExceptionHandler(IamException.class)
    public void error(IamException e, HttpServletResponse response) {
        try {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSON.toJSONString(Response.error(messageLoader.get(e.getCode()))));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @ExceptionHandler(Exception.class)
    public void error(Exception e, HttpServletResponse response) {
        try {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSON.toJSONString(Response.error(messageLoader.get(ExceptionCode.SYSTEM_ERROR))));
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
            response.getWriter().write(JSON.toJSONString(Response.error(stringBuffer.toString())));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
