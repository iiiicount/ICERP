package com.count.icount.exception;

import com.count.icount.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CGetSellException extends RuntimeException{
    public CGetSellException(String msg, Throwable t) {
        super(msg, t);
    }

    public CGetSellException(String msg) {
        super(msg);
    }

    public CGetSellException() {
        super("해당 판매가 존재하지 않습니다.");
    }

    private ErrorCode errorCode;
    public CGetSellException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
