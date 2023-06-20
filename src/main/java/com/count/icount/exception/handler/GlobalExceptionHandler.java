package com.count.icount.exception.handler;

import com.count.icount.exception.AuthenticationFailedException;
import com.count.icount.exception.CExceptionExample;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice //모든 컨트롤러에서 발생하는 exception 처리
public class GlobalExceptionHandler {
    @ExceptionHandler(CExceptionExample.class)
    public ResponseEntity<ErrorResponse> handleCExceptionExample(CExceptionExample ex){
        log.error("handleCExceptionExample", ex);
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<?> handleAuthenticationFailed(AuthenticationFailedException e){
        ErrorResponse response = new ErrorResponse(e.getErrorCode());

        String message = e.getMessage();
        if(message != null && message.length() > 0){
            response.setMessage(message);
        }

        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }
}
