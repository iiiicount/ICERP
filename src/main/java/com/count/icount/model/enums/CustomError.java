package com.count.icount.model.enums;

public enum CustomError {
    PAGE_NOT_FOUND(400, "PAGE_NOT_FOUND"),
    INVALID_REQUEST(400, "INVALID_REQUEST"),
    SERVER_ERROR(500, "SERVER_ERROR");

    private final int statusCode;
    private String errorMessage;

    CustomError(int statusCode, String errorMessage){
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
