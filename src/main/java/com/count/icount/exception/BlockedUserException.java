package com.count.icount.exception;

import com.count.icount.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class BlockedUserException extends RuntimeException{
    private final ErrorCode errorCode = ErrorCode.BLOCKEDUSER;

    public BlockedUserException(String errorMessage){
        super(errorMessage);
    }

    public BlockedUserException(){
        super();
    }
}
