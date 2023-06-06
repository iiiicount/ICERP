package com.count.icount.exception;

import com.count.icount.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CBusinessException extends RuntimeException{
    public CBusinessException(String msg, Throwable t) {
        super(msg, t);
    }

    public CBusinessException(String msg) {
        super(msg);
    }

    public CBusinessException() {
        super("요청을 처리할 수 없습니다.");
    }

    private ErrorCode errorCode;
    public CBusinessException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
