package com.count.icount.exception;

import com.count.icount.exception.handler.ErrorCode;
import lombok.Getter;

// 예외 처리 class 이름 맨 앞에 C 붙이기
// 그냥 우리끼리 정하는 규칙? 커스텀한 예외처리 이니까 만든것이라는 표시
// handler/GlobalExceptionHandler에도 등록을 해주어야함

@Getter
public class CExceptionExample extends RuntimeException{
    public CExceptionExample(String msg, Throwable t) {
        super(msg, t);
    }

    public CExceptionExample(String msg) {
        super(msg);
    }

    public CExceptionExample() {
        super("exception 예시");
    }

    private ErrorCode errorCode;
    public CExceptionExample(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
