package com.count.icount.model.Enums;

public enum HttpStatus {
    OK(200, "OK"),
    PAGE_NOT_FOUND(404, "PAGE_NOT_FOUND"),
    SERVER_ERROR(500, "SERVER_ERROR");

    private final int statusCode;
    private final String httpMessage;

    HttpStatus(int statusCode, String httpMessage) {
        this.statusCode = statusCode;
        this.httpMessage = httpMessage;
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public String getHttpMessage(){
        return this.httpMessage;
    }
}
