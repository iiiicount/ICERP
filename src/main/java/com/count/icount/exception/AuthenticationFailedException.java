package com.count.icount.exception;

import com.count.icount.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class AuthenticationFailedException extends RuntimeException{
    private ErrorCode errorCode;

    public AuthenticationFailedException(){
        super();
        this.errorCode = ErrorCode.AUTHENTICATION_FAILED;
    }

    public AuthenticationFailedException(String errorMessage){
        super(errorMessage);
        this.errorCode = ErrorCode.AUTHENTICATION_FAILED;
    }
}
