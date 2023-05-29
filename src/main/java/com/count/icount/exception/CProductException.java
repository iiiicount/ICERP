package com.count.icount.exception;

import com.count.icount.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CProductException extends RuntimeException{
    public CProductException(String msg, Throwable t) {
        super(msg, t);
    }

    public CProductException(String msg) {
        super(msg);
    }

    public CProductException() {
        super("요청을 처리할 수 없습니다.");
    }

    private ErrorCode errorCode;
    public CProductException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
