package com.spring.boot.springbootcontrolleradvice.Api;

public class ApiException extends RuntimeException {

    public ApiException(String message){
        super(message);
    }
}
