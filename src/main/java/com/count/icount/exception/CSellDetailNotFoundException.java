package com.count.icount.exception;

import com.count.icount.exception.handler.ErrorCode;

public class CSellDetailNotFoundException extends RuntimeException{
    public CSellDetailNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CSellDetailNotFoundException(String msg) {
        super(msg);
    }

    public CSellDetailNotFoundException() {
        super("해당판매상세가 존재하지 않습니다");
    }

    private ErrorCode errorCode;
    public CSellDetailNotFoundException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
